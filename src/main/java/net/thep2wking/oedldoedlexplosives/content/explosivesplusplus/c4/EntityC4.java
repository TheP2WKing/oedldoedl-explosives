package net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.c4;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class EntityC4 extends ModEntityTNTBase {
	public EntityC4(World world, double x, double y, double z, EntityLivingBase igniter, int fuse,
			float explosionStrength, boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(world, x, y, z, igniter, fuse, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
		this.setFuse(1);
	}

	public EntityC4(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
		this.setFuse(1);
	}

	public EntityC4(World world) {
		super(world);
		this.setFuse(1);
	}

	@Override
	public ModExplosionBase createTNTExplosion(double x, double y, double z) {
		return new ModExplosionBase(world, ignitor, x, y, z, 4.0f, false, true, true, 16);
	}
}