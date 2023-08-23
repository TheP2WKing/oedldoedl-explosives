package net.thep2wking.oedldoedlexplosives.content.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;

public class EntityConfigureableTNT extends ModEntityTNTBase {
	public EntityConfigureableTNT(World world, double x, double y, double z, EntityLivingBase igniter, int fuse,
			float explosionStrength, boolean spawnFire, boolean blockDamage) {
		super(world, x, y, z, igniter, fuse, explosionStrength, spawnFire, blockDamage);
	}

	public EntityConfigureableTNT(World world) {
		super(world);
	}
}