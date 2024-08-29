package net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.h;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class EntityHTNT extends ModEntityTNTBase {
	public EntityHTNT(World world, double x, double y, double z, EntityLivingBase igniter, int fuse,
			float explosionStrength, boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(world, x, y, z, igniter, fuse, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
		this.setFuse(420);
	}

	public EntityHTNT(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
		this.setFuse(420);
	}

	public EntityHTNT(World world) {
		super(world);
		this.setFuse(420);
	}

	@Override
	public ModExplosionBase createTNTExplosion(double x, double y, double z) {
		return new ExplosionH(world, ignitor, x, y, z, 80.0f, false, true, false, 0);
	}
}