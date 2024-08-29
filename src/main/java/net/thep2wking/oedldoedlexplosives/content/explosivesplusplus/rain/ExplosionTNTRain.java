package net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.rain;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class ExplosionTNTRain extends ModExplosionBase {
	public ExplosionTNTRain(World worldIn, Entity ignitor, double x, double y, double z, float explosionStrength,
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
		int radius = 50;
		int steps = 5;
		double[] heights = { 12.5, 17.5, 22.5 };
		for (int newX = -radius; newX < radius; newX += steps) {
			for (int newZ = -radius; newZ < radius; newZ += steps) {
				for (double height : heights) {
					if (!world.isRemote) {
						spawnTNT(x + 0.5 + newX, y + height, z + 0.5 + newZ);
					}
				}
			}
		}
	}

	private void spawnTNT(double x, double y, double z) {
		EntityTNTPrimed entityTNTPrimed;
		if (this.ignitor instanceof EntityLivingBase) {
			entityTNTPrimed = new EntityTNTPrimed(this.world, x, y, z, (EntityLivingBase) ignitor);
		} else {
			entityTNTPrimed = new EntityTNTPrimed(this.world, x, y, z, null);
		}
		this.world.spawnEntity(entityTNTPrimed);
	}
}