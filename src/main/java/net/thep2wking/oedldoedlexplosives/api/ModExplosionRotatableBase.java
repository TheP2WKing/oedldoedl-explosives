package net.thep2wking.oedldoedlexplosives.api;

import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ModExplosionRotatableBase extends ModExplosionBase {
	private EnumFacing.Axis axis;

	public ModExplosionRotatableBase(World worldIn, Entity ignitor, double x, double y, double z, float explosionStrength,
			boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(worldIn, ignitor, x, y, z, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
	}

	public ModExplosionRotatableBase setAxis(EnumFacing.Axis axis) {
		this.axis = axis;
		return this;
	}

	public EnumFacing.Axis getAxis() {
		return axis;
	}
}