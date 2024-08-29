package net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.bundled;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class EntityBundledTNT extends ModEntityTNTBase {
	public EntityBundledTNT(World world, double x, double y, double z, EntityLivingBase igniter, int fuse,
			float explosionStrength, boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(world, x, y, z, igniter, fuse, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
	}

	public EntityBundledTNT(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
	}

	public EntityBundledTNT(World world) {
		super(world);
	}

	@Override
	public ModExplosionBase createTNTExplosion(double x, double y, double z) {
		return new ExplosionBundled(world, ignitor, x, y, z, 4.0f, false, false, false, 0);
	}
}