package net.thep2wking.oedldoedlexplosives.content.crazybombs.meganuke;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class EntityMegaNukeTNT extends ModEntityTNTBase {
	public EntityMegaNukeTNT(World world, double x, double y, double z, EntityLivingBase igniter, int fuse,
			float explosionStrength, boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(world, x, y, z, igniter, fuse, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
		this.setFuse(220);
	}

	public EntityMegaNukeTNT(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
		this.setFuse(220);
	}

	public EntityMegaNukeTNT(World world) {
		super(world);
		this.setFuse(220);
	}

	@Override
	public ModExplosionBase createTNTExplosion(double x, double y, double z) {
		return new ExplosionMegaNuke(world, ignitor, x, y, z, 65.0f, true, true, true, 32);
	}
}