package net.thep2wking.oedldoedlexplosives.api;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentProtection;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;

public class ModExplosionBase extends Explosion {
	public final boolean causesFire;
	public final boolean damagesTerrain;
	public final Random random;
	public final World world;
	public final double x;
	public final double y;
	public final double z;
	public final Entity exploder;
	public final float size;
	public final List<BlockPos> affectedBlockPositions;
	public final Map<EntityPlayer, Vec3d> playerKnockbackMap;
	public final Vec3d position;

	public ModExplosionBase(World worldIn, Entity entityIn, double x, double y, double z, float size,
			List<BlockPos> affectedPositions) {
		this(worldIn, entityIn, x, y, z, size, false, true, affectedPositions);
	}

	public ModExplosionBase(World worldIn, Entity entityIn, double x, double y, double z, float size,
			boolean causesFire,
			boolean damagesTerrain, List<BlockPos> affectedPositions) {
		this(worldIn, entityIn, x, y, z, size, causesFire, damagesTerrain);
		this.affectedBlockPositions.addAll(affectedPositions);
	}

	public ModExplosionBase(World worldIn, Entity entityIn, double x, double y, double z, float size, boolean flaming,
			boolean damagesTerrain) {
		super(worldIn, entityIn, x, y, z, size, flaming, damagesTerrain);
		this.random = new Random();
		this.affectedBlockPositions = Lists.<BlockPos>newArrayList();
		this.playerKnockbackMap = Maps.<EntityPlayer, Vec3d>newHashMap();
		this.world = worldIn;
		this.exploder = entityIn;
		this.size = size;
		this.x = x;
		this.y = y;
		this.z = z;
		this.causesFire = flaming;
		this.damagesTerrain = damagesTerrain;
		this.position = new Vec3d(this.x, this.y, this.z);
	}

	@Override
	@SuppressWarnings("unused")
	public void doExplosionA() {
		Set<BlockPos> set = Sets.<BlockPos>newHashSet();
		for (int j = 0; j < 16; ++j) {
			for (int k = 0; k < 16; ++k) {
				for (int l = 0; l < 16; ++l) {
					if (j == 0 || j == 15 || k == 0 || k == 15 || l == 0 || l == 15) {
						double d0 = (double) ((float) j / 15.0F * 2.0F - 1.0F);
						double d1 = (double) ((float) k / 15.0F * 2.0F - 1.0F);
						double d2 = (double) ((float) l / 15.0F * 2.0F - 1.0F);
						double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
						d0 = d0 / d3;
						d1 = d1 / d3;
						d2 = d2 / d3;
						float f = this.size * (0.7F + this.world.rand.nextFloat() * 0.6F);
						double d4 = this.x;
						double d6 = this.y;
						double d8 = this.z;
						for (float f1 = 0.3F; f > 0.0F; f -= 0.22500001F) {
							BlockPos blockpos = new BlockPos(d4, d6, d8);
							IBlockState iblockstate = this.world.getBlockState(blockpos);
							if (iblockstate.getMaterial() != Material.AIR) {
								float f2 = this.exploder != null
										? this.exploder.getExplosionResistance(this, this.world, blockpos, iblockstate)
										: iblockstate.getBlock().getExplosionResistance(world, blockpos, (Entity) null,
												this);
								f -= (f2 + 0.3F) * 0.3F;
							}
							if (f > 0.0F && (this.exploder == null || this.exploder.canExplosionDestroyBlock(this,
									this.world, blockpos, iblockstate, f))) {
								set.add(blockpos);
							}
							d4 += d0 * 0.30000001192092896D;
							d6 += d1 * 0.30000001192092896D;
							d8 += d2 * 0.30000001192092896D;
						}
					}
				}
			}
		}

		this.affectedBlockPositions.addAll(set);
		float f3 = this.size * 2.0F;
		int k1 = MathHelper.floor(this.x - (double) f3 - 1.0D);
		int l1 = MathHelper.floor(this.x + (double) f3 + 1.0D);
		int i2 = MathHelper.floor(this.y - (double) f3 - 1.0D);
		int i1 = MathHelper.floor(this.y + (double) f3 + 1.0D);
		int j2 = MathHelper.floor(this.z - (double) f3 - 1.0D);
		int j1 = MathHelper.floor(this.z + (double) f3 + 1.0D);
		List<Entity> list = this.world.getEntitiesWithinAABBExcludingEntity(this.exploder,
				new AxisAlignedBB((double) k1, (double) i2, (double) j2, (double) l1, (double) i1, (double) j1));
		net.minecraftforge.event.ForgeEventFactory.onExplosionDetonate(this.world, this, list, f3);
		Vec3d vec3d = new Vec3d(this.x, this.y, this.z);
		for (int k2 = 0; k2 < list.size(); ++k2) {
			Entity entity = list.get(k2);
			if (!entity.isImmuneToExplosions()) {
				double d12 = entity.getDistance(this.x, this.y, this.z) / (double) f3;
				if (d12 <= 1.0D) {
					double d5 = entity.posX - this.x;
					double d7 = entity.posY + (double) entity.getEyeHeight() - this.y;
					double d9 = entity.posZ - this.z;
					double d13 = (double) MathHelper.sqrt(d5 * d5 + d7 * d7 + d9 * d9);
					if (d13 != 0.0D) {
						d5 = d5 / d13;
						d7 = d7 / d13;
						d9 = d9 / d13;
						double d14 = (double) this.world.getBlockDensity(vec3d, entity.getEntityBoundingBox());
						double d10 = (1.0D - d12) * d14;
						entity.attackEntityFrom(DamageSource.causeExplosionDamage(this),
								(float) ((int) ((d10 * d10 + d10) / 2.0D * 7.0D * (double) f3 + 1.0D)));
						double d11 = d10;
						if (entity instanceof EntityLivingBase) {
							d11 = EnchantmentProtection.getBlastDamageReduction((EntityLivingBase) entity, d10);
						}
						entity.motionX += d5 * d11;
						entity.motionY += d7 * d11;
						entity.motionZ += d9 * d11;
						if (entity instanceof EntityPlayer) {
							EntityPlayer entityplayer = (EntityPlayer) entity;

							if (!entityplayer.isSpectator()
									&& (!entityplayer.isCreative() || !entityplayer.capabilities.isFlying)) {
								this.playerKnockbackMap.put(entityplayer, new Vec3d(d5 * d10, d7 * d10, d9 * d10));
							}
						}
					}
				}
			}
		}
	}

	@Override
	public void doExplosionB(boolean spawnParticles) {
		super.doExplosionB(spawnParticles);
	}

	@Override
	public Map<EntityPlayer, Vec3d> getPlayerKnockbackMap() {
		return this.playerKnockbackMap;
	}

	@Nullable
	@Override
	public EntityLivingBase getExplosivePlacedBy() {
		if (this.exploder == null) {
			return null;
		} else if (this.exploder instanceof EntityTNTPrimed) {
			return ((EntityTNTPrimed) this.exploder).getTntPlacedBy();
		} else {
			return this.exploder instanceof EntityLivingBase ? (EntityLivingBase) this.exploder : null;
		}
	}

	@Override
	public void clearAffectedBlockPositions() {
		this.affectedBlockPositions.clear();
	}

	@Override
	public List<BlockPos> getAffectedBlockPositions() {
		return this.affectedBlockPositions;
	}

	@Override
	public Vec3d getPosition() {
		return this.position;
	}

	public ModExplosionBase newExplosion(World world, @Nullable Entity entityIn, double x, double y, double z,
			float strength, boolean isFlaming, boolean isSmoking) {
		ModExplosionBase explosion = createExplosion(world, entityIn, x, y, z, strength, isFlaming, isSmoking);
		if (ForgeEventFactory.onExplosionStart(world, explosion))
			return explosion;
		explosion.doExplosionA();
		explosion.doExplosionB(true);
		return explosion;
	}

	public ModExplosionBase createExplosion(World world, @Nullable Entity entityIn, double x, double y, double z,
			float strength, boolean isFlaming, boolean isSmoking) {
		return new ModExplosionBase(world, entityIn, x, y, z, strength, isFlaming, isSmoking);
	}
}