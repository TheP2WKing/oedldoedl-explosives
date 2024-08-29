package net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.meteor;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class ExplosionMeteorEpp extends ModExplosionBase {
	public ExplosionMeteorEpp(World worldIn, Entity ignitor, double x, double y, double z, float explosionStrength,
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
			int heightOffset = 220;
			EntityMeteorEpp meteor = new EntityMeteorEpp(world, x, y + heightOffset, z, ignitor);
			if (!world.isRemote) {
				this.world.spawnEntity(meteor);
			}
			int radius = 2;
			Random random = new Random();
			for (int i = 0; i < 5; i++) {
				double offsetX = (random.nextDouble() * 2 * radius) - radius;
				double offsetZ = (random.nextDouble() * 2 * radius) - radius;
				this.world.addWeatherEffect(
						new EntityLightningBolt(world, x + offsetX, y + heightOffset, z + offsetZ,
								true));
			}
			this.world.addWeatherEffect(new EntityLightningBolt(world, x, y, z, true));
		}
	}
}