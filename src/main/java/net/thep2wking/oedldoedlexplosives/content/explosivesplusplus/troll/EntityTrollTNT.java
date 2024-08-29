package net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.troll;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class EntityTrollTNT extends ModEntityTNTBase {
	public EntityTrollTNT(World world, double x, double y, double z, EntityLivingBase igniter, int fuse,
			float explosionStrength, boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(world, x, y, z, igniter, fuse, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
		this.setFuse(10);
	}

	public EntityTrollTNT(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
		this.setFuse(10);
	}

	public EntityTrollTNT(World world) {
		super(world);
		this.setFuse(10);
	}

	@Override
	public ModExplosionBase createTNTExplosion(double x, double y, double z) {
		return new ModExplosionBase(world, ignitor, x, y, z, 4.0f, false, true, false, 16);
	}
}