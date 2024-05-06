package net.thep2wking.oedldoedlexplosives.content.toomuchtnt.gravity;

import java.util.List;
import net.minecraft.enchantment.EnchantmentProtection;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class ExplosionGravityTNT extends ModExplosionBase {
	public ExplosionGravityTNT(World worldIn, Entity ignitor, double x, double y, double z, float explosionStrength,
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
						double d10 = (this.explosionStrength - d12) * d14;
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
}