package net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.rain;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class EntityTNTRain extends ModEntityTNTBase {
	public EntityTNTRain(World world, double x, double y, double z, EntityLivingBase igniter, int fuse,
			float explosionStrength, boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(world, x, y, z, igniter, fuse, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
		this.setFuse(160);
	}

	public EntityTNTRain(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
		this.setFuse(160);
	}

	public EntityTNTRain(World world) {
		super(world);
		this.setFuse(160);
	}

	@Override
	public ModExplosionBase createTNTExplosion(double x, double y, double z) {
		return new ExplosionTNTRain(world, ignitor, x, y, z, 4.0f, false, false, false, 16);
	}
}