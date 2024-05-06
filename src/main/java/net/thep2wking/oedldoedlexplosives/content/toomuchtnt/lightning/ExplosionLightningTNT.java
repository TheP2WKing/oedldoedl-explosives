package net.thep2wking.oedldoedlexplosives.content.toomuchtnt.lightning;

import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class ExplosionLightningTNT extends ModExplosionBase {
	public ExplosionLightningTNT(World worldIn, Entity ignitor, double x, double y, double z, float explosionStrength,
			boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(worldIn, ignitor, x, y, z, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
	}
	
	@Override
	public void doExplosionBlockDamage(boolean spawnParticles) {
		super.doExplosionBlockDamage(spawnParticles);
		int radius = (int) this.explosionStrength;
		double x = this.x + (double) this.world.rand.nextInt(radius) - (double) (radius / 2);
		double y = this.y;
		double z = this.z + (double) this.world.rand.nextInt(radius) - (double) (radius / 2);
		for (int i = 1; i <= (radius / 2); i++) {
			if (this.world.getBlockState(new BlockPos(x, this.y - i, z)).isFullBlock()) {
				y = this.y - i;
				break;
			} else if (this.world.getBlockState(new BlockPos(x, this.y + i, z)).isFullBlock()) {
				y = this.y + i;
				break;
			}
		}
		this.world.addWeatherEffect(new EntityLightningBolt(this.world, x, y, z, false));
	}

	@Override
	public void doExplosionB(boolean spawnParticles) {
		this.doExplosionBlockDamage(false);
		this.doExplosionSpawnFire();
	}
}