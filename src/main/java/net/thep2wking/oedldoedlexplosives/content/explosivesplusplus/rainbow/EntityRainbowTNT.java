package net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.rainbow;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityRotatableTNTBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionRotatableBase;

public class EntityRainbowTNT extends ModEntityRotatableTNTBase {
	public EntityRainbowTNT(World world, double x, double y, double z, EntityLivingBase igniter, int fuse,
			float explosionStrength, boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(world, x, y, z, igniter, fuse, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
	}

	public EntityRainbowTNT(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
	}

	public EntityRainbowTNT(World world) {
		super(world);
	}

	@Override
	public ModExplosionRotatableBase createRotatableTNTExplosion(double x, double y, double z) {
		return new ExplosionRainbow(world, ignitor, x, y, z, 30.0f, false, false, false, 0);
	}
}