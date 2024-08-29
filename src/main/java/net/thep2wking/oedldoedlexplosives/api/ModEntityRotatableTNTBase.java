package net.thep2wking.oedldoedlexplosives.api;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ModEntityRotatableTNTBase  extends ModEntityTNTBase {
	private EnumFacing.Axis axis;

	public ModEntityRotatableTNTBase(World world, double x, double y, double z, EntityLivingBase igniter, int fuse,
			float explosionStrength, boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(world, x, y, z, igniter, fuse, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
	}

	public ModEntityRotatableTNTBase(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
	}

	public ModEntityRotatableTNTBase(World world) {
		super(world);
	}

	public ModEntityRotatableTNTBase setAxis(EnumFacing.Axis axis) {
		this.axis = axis;
		return this;
	}

	public EnumFacing.Axis getAxis() {
		return axis;
	}

	@Override
	public final ModExplosionBase createTNTExplosion(double x, double y, double z) {
		return createRotatableTNTExplosion(x, y, z).setAxis(this.getAxis());
	}

	public ModExplosionRotatableBase createRotatableTNTExplosion(double x, double y, double z) {
		return new ModExplosionRotatableBase(world, ignitor, x, y, z, 4.0f, false, true, true, 16);
	}
}