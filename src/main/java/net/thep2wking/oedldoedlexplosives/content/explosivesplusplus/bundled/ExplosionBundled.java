package net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.bundled;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class ExplosionBundled extends ModExplosionBase {
	public ExplosionBundled(World worldIn, Entity ignitor, double x, double y, double z, float explosionStrength,
			boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(worldIn, ignitor, x, y, z, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
	}

	@Override
	public void doExplosionA() {
		this.doAffectedBlocks();
		this.doDamageAndKnockback(false);
	}

	@Override
	public void doExplosionBlockDamage(boolean spawnParticles) {
		super.doExplosionBlockDamage(spawnParticles);
		if (!world.isRemote) {
			spawnBundle();
		}
	}

	public void spawnTNTWithVelocity(double offsetX, double offsetY, double offsetZ, double velocityX,
			double velocityY, double velocityZ) {
		EntityTNTPrimed entityTNTPrimed;
		if (this.ignitor instanceof EntityLivingBase) {
			entityTNTPrimed = new EntityTNTPrimed(this.world, x + offsetX, y + offsetY, z + offsetZ,
					(EntityLivingBase) ignitor);
		} else {
			entityTNTPrimed = new EntityTNTPrimed(this.world, x + offsetX, y + offsetY, z + offsetZ, null);
		}
		entityTNTPrimed.addVelocity(velocityX, velocityY, velocityZ);
		this.world.spawnEntity(entityTNTPrimed);
	}

	private void spawnBundle() {
		double offset = 0.1;
		double velocity = 0.3;
		double[][] velocities = {
				{ velocity, 0.1, 0.0 }, { -velocity, 0.1, 0.0 }, { 0.0, 0.1, velocity }, { 0.0, 0.1, -velocity },
				{ velocity, 0.1, velocity }, { -velocity, 0.1, velocity }, { velocity, 0.1, -velocity },
				{ -velocity, 0.1, -velocity },
				{ 0.0, 0.1, 0.0 }
		};
		for (double[] v : velocities) {
			spawnTNTWithVelocity(offset, offset, offset, v[0], v[1], v[2]);
		}
	}
}