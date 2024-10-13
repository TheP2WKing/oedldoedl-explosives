package net.thep2wking.oedldoedlexplosives.content.crazybombs.arrow;

import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class ExplosionArrowCb extends ModExplosionBase {
	public ExplosionArrowCb(World worldIn, Entity ignitor, double x, double y, double z, float explosionStrength,
			boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(worldIn, ignitor, x, y, z, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
	}

	@Override
	public void doExplosionA() {
		this.doAffectedBlocks();
		this.doDamageAndKnockback(false);
	}

	@Override
	public void doExplosionSpawnFire() {
		if (this.spawnFire) {
			int amount = (int) (this.explosionStrength * 50);
			int velocity = 8;
			for (int i = 0; i < amount; ++i) {
				EntityTippedArrow arrow = new EntityTippedArrow(this.world, this.x, this.y, this.z);
				double defaultDamage = arrow.getDamage();
				arrow.setDamage(defaultDamage * 2);
				int velocityRandom = random.nextInt(4);
				double xVelocity = (double) ((float) (random.nextInt(velocity * 2)) / 10.0f);
				double yVelocity = (double) ((float) (random.nextInt(velocity) + 5) / 10.0f);
				double zVelocity = (double) ((float) (random.nextInt(velocity * 2)) / 10.0f);
				if (velocityRandom == 0) {
					xVelocity = -xVelocity;
					zVelocity = -zVelocity;
				} else if (velocityRandom == 1) {
					xVelocity = -xVelocity;
				} else if (velocityRandom == 2) {
					zVelocity = -zVelocity;
				}
				arrow.motionX = xVelocity;
				arrow.motionY = yVelocity;
				arrow.motionZ = zVelocity;
				if (arrow != null) {
					this.world.spawnEntity(arrow);
				}
			}
		}
	}
}