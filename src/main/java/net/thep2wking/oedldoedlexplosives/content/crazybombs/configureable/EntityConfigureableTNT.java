package net.thep2wking.oedldoedlexplosives.content.crazybombs.configureable;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class EntityConfigureableTNT extends ModEntityTNTBase {
	private int size;

	public EntityConfigureableTNT(World world, double x, double y, double z, EntityLivingBase igniter, int fuse,
			float explosionStrength, boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(world, x, y, z, igniter, fuse, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
	}

	public EntityConfigureableTNT(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
	}

	public EntityConfigureableTNT(World world) {
		super(world);
	}

	public EntityConfigureableTNT setSize(int size) {
		this.size = size;
		return this;
	}

	public int getSize() {
		return size;
	}

	@Override
	public ModExplosionBase createTNTExplosion(double x, double y, double z) {
		return new ModExplosionBase(world, ignitor, x, y, z, this.getSize(), false, true, true, 16);
	}
}