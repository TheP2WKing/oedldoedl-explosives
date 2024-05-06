package net.thep2wking.oedldoedlexplosives.content.toomuchtnt.ender;

import java.util.List;
import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentProtection;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class ExplosionEnderTNT extends ModExplosionBase {
	public ExplosionEnderTNT(World worldIn, Entity ignitor, double x, double y, double z, float explosionStrength,
			boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(worldIn, ignitor, x, y, z, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
	}

	@Override
	public void doDamageAndKnockback(boolean explosionDamage) {
		float f3 = this.explosionStrength * 2.0F;
		int k1 = MathHelper.floor(this.x - (double) f3 - 1.0D);
		int l1 = MathHelper.floor(this.x + (double) f3 + 1.0D);
		int i2 = MathHelper.floor(this.y - (double) f3 - 1.0D);
		int i1 = MathHelper.floor(this.y + (double) f3 + 1.0D);
		int j2 = MathHelper.floor(this.z - (double) f3 - 1.0D);
		int j1 = MathHelper.floor(this.z + (double) f3 + 1.0D);
		List<Entity> list = this.world.getEntitiesWithinAABBExcludingEntity(this.ignitor,
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
						double d11 = d10;
						if (entity instanceof EntityLivingBase) {
							d11 = EnchantmentProtection.getBlastDamageReduction((EntityLivingBase) entity, d10);
						}
						entity.motionX += d5 * d11 * this.explosionStrength;
						entity.motionY += d7 * d11 * (this.explosionStrength / 2);
						entity.motionZ += d9 * d11 * this.explosionStrength;
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
							if (iblockstate.getMaterial() == Material.AIR) {
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
}