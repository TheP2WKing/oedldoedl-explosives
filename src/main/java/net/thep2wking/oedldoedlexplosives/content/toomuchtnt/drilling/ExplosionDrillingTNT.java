package net.thep2wking.oedldoedlexplosives.content.toomuchtnt.drilling;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class ExplosionDrillingTNT extends ModExplosionBase {
	public ExplosionDrillingTNT(World worldIn, Entity ignitor, double x, double y, double z, float explosionStrength,
			boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(worldIn, ignitor, x, y, z, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
	}
}