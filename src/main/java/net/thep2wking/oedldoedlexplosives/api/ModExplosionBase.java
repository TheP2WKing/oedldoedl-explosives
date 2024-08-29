package net.thep2wking.oedldoedlexplosives.api;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentProtection;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

/**
 * @author TheP2WKing
 */
public class ModExplosionBase extends Explosion {
	public final boolean spawnFire;
	public final boolean blockDamage;
	public final boolean dropBlocks;
	public final int smoothness;
	public final Random random;
	public final World world;
	public final double x;
	public final double y;
	public final double z;
	public final Entity ignitor;
	public final float explosionStrength;
	public final List<BlockPos> affectedBlockPositions;
	public final Map<EntityPlayer, Vec3d> playerKnockbackMap;
	public final Vec3d position;

	public ModExplosionBase(World worldIn, Entity ignitor, double x, double y, double z, float explosionStrength,
			List<BlockPos> affectedPositions) {
		this(worldIn, ignitor, x, y, z, explosionStrength, false, true, true, 16, affectedPositions);
	}

	public ModExplosionBase(World worldIn, Entity ignitor, double x, double y, double z, float explosionStrength,
			boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness,
			List<BlockPos> affectedPositions) {
		this(worldIn, ignitor, x, y, z, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
		this.affectedBlockPositions.addAll(affectedPositions);
	}

	public ModExplosionBase(World worldIn, Entity ignitor, double x, double y, double z, float explosionStrength,
			boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(worldIn, ignitor, x, y, z, explosionStrength, spawnFire, blockDamage);
		this.random = new Random();
		this.affectedBlockPositions = Lists.<BlockPos>newArrayList();
		this.playerKnockbackMap = Maps.<EntityPlayer, Vec3d>newHashMap();
		this.world = worldIn;
		this.ignitor = ignitor;
		this.explosionStrength = explosionStrength;
		this.x = x;
		this.y = y;
		this.z = z;
		this.spawnFire = spawnFire;
		this.blockDamage = blockDamage;
		this.dropBlocks = dropBlocks;
		this.smoothness = smoothness;
		this.position = new Vec3d(this.x, this.y, this.z);
	}

	@Override
	public void doExplosionA() {
		this.doAffectedBlocks();
		this.doDamageAndKnockback(true);
	}

	public void doAffectedBlocks() {
		Set<BlockPos> set = Sets.<BlockPos>newHashSet();
		for (int j = 0; j < this.smoothness; ++j) {
			for (int k = 0; k < this.smoothness; ++k) {
				for (int l = 0; l < this.smoothness; ++l) {
					if (j == 0 || j == (this.smoothness - 1) || k == 0 || k == (this.smoothness - 1) || l == 0
							|| l == (this.smoothness - 1)) {
						double d0 = (double) ((float) j / (this.smoothness - 1) * 2.0F - 1.0F);
						double d1 = (double) ((float) k / (this.smoothness - 1) * 2.0F - 1.0F);
						double d2 = (double) ((float) l / (this.smoothness - 1) * 2.0F - 1.0F);
						double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
						d0 = d0 / d3;
						d1 = d1 / d3;
						d2 = d2 / d3;
						float f = this.explosionStrength * (0.7F + this.world.rand.nextFloat() * 0.6F);
						double d4 = this.x;
						double d6 = this.y;
						double d8 = this.z;
						for (@SuppressWarnings("unused")
						float f1 = 0.3F; f > 0.0F; f -= 0.22500001F) {
							BlockPos blockpos = new BlockPos(d4, d6, d8);
							IBlockState iblockstate = this.world.getBlockState(blockpos);
							if (iblockstate.getMaterial() != Material.AIR) {
								float f2 = this.ignitor != null
										? this.ignitor.getExplosionResistance(this, this.world, blockpos, iblockstate)
										: iblockstate.getBlock().getExplosionResistance(world, blockpos, (Entity) null,
												this);
								f -= (f2 + 0.3F) * 0.3F;
							}
							if (f > 0.0F && (this.ignitor == null || this.ignitor.canExplosionDestroyBlock(this,
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
	}

	public void doDamageAndKnockback(boolean explosionDamage) {
		float f3 = this.explosionStrength * 2.0F;
		int k1 = MathHelper.floor(this.x - (double) f3 - 1.0D);
		int l1 = MathHelper.floor(this.x + (double) f3 + 1.0D);
		int i2 = MathHelper.floor(this.y - (double) f3 - 1.0D);
		int i1 = MathHelper.floor(this.y + (double) f3 + 1.0D);
		int j2 = MathHelper.floor(this.z - (double) f3 - 1.0D);
		int j1 = MathHelper.floor(this.z + (double) f3 + 1.0D);
		List<Entity> list = this.world.getEntitiesWithinAABBExcludingEntity(null,
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
						if (explosionDamage) {
							entity.attackEntityFrom(DamageSource.causeExplosionDamage(this),
									(float) ((int) ((d10 * d10 + d10) / 2.0D * 7.0D * (double) f3 + 1.0D)));
						}
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
		this.world.playSound((EntityPlayer) null, this.x, this.y, this.z, SoundEvents.ENTITY_GENERIC_EXPLODE,
				SoundCategory.BLOCKS, 4.0F,
				(1.0F + (this.world.rand.nextFloat() - this.world.rand.nextFloat()) * 0.2F) * 0.7F);
		if (this.explosionStrength >= 2.0F && this.blockDamage) {
			this.world.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, this.x, this.y, this.z, 1.0D, 0.0D, 0.0D);
		} else {
			this.world.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, this.x, this.y, this.z, 1.0D, 0.0D, 0.0D);
		}
		this.doExplosionBlockDamage(spawnParticles);
		this.doExplosionSpawnFire();
	}

	public void doExplosionBlockDamage(boolean spawnParticles) {
		if (this.blockDamage) {
			for (BlockPos blockpos : this.affectedBlockPositions) {
				IBlockState iblockstate = this.world.getBlockState(blockpos);
				Block block = iblockstate.getBlock();
				if (spawnParticles) {
					double d0 = (double) ((float) blockpos.getX() + this.world.rand.nextFloat());
					double d1 = (double) ((float) blockpos.getY() + this.world.rand.nextFloat());
					double d2 = (double) ((float) blockpos.getZ() + this.world.rand.nextFloat());
					double d3 = d0 - this.x;
					double d4 = d1 - this.y;
					double d5 = d2 - this.z;
					double d6 = (double) MathHelper.sqrt(d3 * d3 + d4 * d4 + d5 * d5);
					d3 = d3 / d6;
					d4 = d4 / d6;
					d5 = d5 / d6;
					double d7 = 0.5D / (d6 / (double) this.explosionStrength + 0.1D);
					d7 = d7 * (double) (this.world.rand.nextFloat() * this.world.rand.nextFloat() + 0.3F);
					d3 = d3 * d7;
					d4 = d4 * d7;
					d5 = d5 * d7;
					this.world.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, (d0 + this.x) / 2.0D,
							(d1 + this.y) / 2.0D, (d2 + this.z) / 2.0D, d3, d4, d5);
					this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0, d1, d2, d3, d4, d5);
				}
				this.dropBlocks(iblockstate, block, blockpos);
			}
		}
	}

	public void dropBlocks(IBlockState iblockstate, Block block, BlockPos blockpos) {
		if (iblockstate.getMaterial() != Material.AIR) {
			if (block.canDropFromExplosion(this) && this.dropBlocks) {
				block.dropBlockAsItemWithChance(this.world, blockpos, this.world.getBlockState(blockpos),
						1.0F / this.explosionStrength, 0);
			}
			block.onBlockExploded(this.world, blockpos, this);
		}
	}

	public void doExplosionSpawnFire() {
		if (this.spawnFire) {
			for (BlockPos blockpos1 : this.affectedBlockPositions) {
				if (this.world.getBlockState(blockpos1).getMaterial() == Material.AIR
						&& this.world.getBlockState(blockpos1.down()).isFullBlock() && this.random.nextInt(3) == 0) {
					this.world.setBlockState(blockpos1, Blocks.FIRE.getDefaultState());
				}
			}
		}
	}

	@Override
	public Map<EntityPlayer, Vec3d> getPlayerKnockbackMap() {
		return this.playerKnockbackMap;
	}

	@Nullable
	@Override
	public EntityLivingBase getExplosivePlacedBy() {
		if (this.ignitor == null) {
			return null;
		} else if (this.ignitor instanceof ModEntityTNTBase) {
			return ((ModEntityTNTBase) this.ignitor).getTntPlacedBy();
		} else {
			return this.ignitor instanceof EntityLivingBase ? (EntityLivingBase) this.ignitor : null;
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

	public float getExplosionStrength() {
		return this.explosionStrength;
	}

	public boolean doBlockDamage() {
		return this.blockDamage;
	}

	public boolean doDropBlocks() {
		return this.dropBlocks;
	}

	public boolean doSpawnFire() {
		return this.spawnFire;
	}

	public int getSmoothness() {
		return this.smoothness;
	}
}