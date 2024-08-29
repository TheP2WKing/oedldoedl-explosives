package net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.day;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class ExplosionDay extends ModExplosionBase {
	public ExplosionDay(World worldIn, Entity ignitor, double x, double y, double z, float explosionStrength,
			boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(worldIn, ignitor, x, y, z, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
	}

	@Override
	public void doExplosionBlockDamage(boolean spawnParticles) {
		super.doExplosionBlockDamage(spawnParticles);
		this.world.setWorldTime(0);
	}

	@Override
	public void doExplosionA() {
		this.doAffectedBlocks();
		this.doDamageAndKnockback(false);
	}
}