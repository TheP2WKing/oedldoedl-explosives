package net.thep2wking.oedldoedlexplosives.content.toomuchtnt.x2000;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class EntityTNTX2000 extends ModEntityTNTBase {
	public EntityTNTX2000(World world, double x, double y, double z, EntityLivingBase igniter, int fuse,
			float explosionStrength, boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(world, x, y, z, igniter, fuse, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
		this.setFuse(320);
	}

	public EntityTNTX2000(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
		this.setFuse(320);
	}

	public EntityTNTX2000(World world) {
		super(world);
		this.setFuse(320);
	}

	@Override
	public void setParticles() {
		world.spawnParticle(EnumParticleTypes.REDSTONE, this.posX, this.posY + 1.0D, this.posZ, 0.35, 0.885, 0.0, new int[]{0});
	}

	@Override
	public ModExplosionBase createTNTExplosion(double x, double y, double z) {
		return new ModExplosionBase(world, ignitor, x, y, z, 100.0f, false, true, true, 220);
	}
}