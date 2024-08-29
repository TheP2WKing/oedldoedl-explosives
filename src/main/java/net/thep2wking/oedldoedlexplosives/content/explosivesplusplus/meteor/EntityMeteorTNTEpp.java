package net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.meteor;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class EntityMeteorTNTEpp extends ModEntityTNTBase {
	public EntityMeteorTNTEpp(World world, double x, double y, double z, EntityLivingBase igniter, int fuse,
			float explosionStrength, boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(world, x, y, z, igniter, fuse, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
	}

	public EntityMeteorTNTEpp(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
	}

	public EntityMeteorTNTEpp(World world) {
		super(world);
	}

	@Override
	public ModExplosionBase createTNTExplosion(double x, double y, double z) {
		return new ExplosionMeteorEpp(world, ignitor, x, y, z, 4.0f, true, false, false, 0);
	}
}