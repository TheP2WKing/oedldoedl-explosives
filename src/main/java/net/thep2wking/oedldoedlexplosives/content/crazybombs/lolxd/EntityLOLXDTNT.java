package net.thep2wking.oedldoedlexplosives.content.crazybombs.lolxd;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityRotatableTNTBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionRotatableBase;

public class EntityLOLXDTNT extends ModEntityRotatableTNTBase {
	public EntityLOLXDTNT(World world, double x, double y, double z, EntityLivingBase igniter, int fuse,
			float explosionStrength, boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(world, x, y, z, igniter, fuse, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
	}

	public EntityLOLXDTNT(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
	}

	public EntityLOLXDTNT(World world) {
		super(world);
	}

	@Override
	public ModExplosionRotatableBase createRotatableTNTExplosion(double x, double y, double z) {
		return new ExplosionLOLXD(world, ignitor, x, y, z, 4.0f, true, false, false, 0);
	}
}