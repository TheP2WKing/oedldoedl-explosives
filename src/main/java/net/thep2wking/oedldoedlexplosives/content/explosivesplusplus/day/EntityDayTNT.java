package net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.day;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class EntityDayTNT extends ModEntityTNTBase {
	public EntityDayTNT(World world, double x, double y, double z, EntityLivingBase igniter, int fuse,
			float explosionStrength, boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(world, x, y, z, igniter, fuse, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
	}

	public EntityDayTNT(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
	}

	public EntityDayTNT(World world) {
		super(world);
	}

	@Override
	public ModExplosionBase createTNTExplosion(double x, double y, double z) {
		return new ExplosionDay(world, ignitor, x, y, z, 4.0f, false, false, false, 0);
	}
}