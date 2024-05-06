package net.thep2wking.oedldoedlexplosives.content.toomuchtnt.grove;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class EntityGroveTNT extends ModEntityTNTBase {
	public EntityGroveTNT(World world, double x, double y, double z, EntityLivingBase igniter, int fuse,
			float explosionStrength, boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(world, x, y, z, igniter, fuse, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
	}

	public EntityGroveTNT(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
	}

	public EntityGroveTNT(World world) {
		super(world);
	}

	@Override
	public void setParticles() {
		world.spawnParticle(EnumParticleTypes.REDSTONE, this.posX, this.posY + 1.0, this.posZ, 0.2, 0.5, 0.2,
				new int[0]);
	}

	@Override
	public ModExplosionBase createTNTExplosion(double x, double y, double z) {
		return new ExplosionGroveTNT(world, ignitor, x, y, z, 12.0f, true, false, false, 128);
	}
}