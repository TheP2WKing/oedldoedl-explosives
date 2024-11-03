package net.thep2wking.oedldoedlexplosives.content.customtnt.nuke;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class EntityNuke extends ModEntityTNTBase {
	public EntityNuke(World world, double x, double y, double z, EntityLivingBase igniter, int fuse,
			float explosionStrength, boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(world, x, y, z, igniter, fuse, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
		this.setFuse(600);
	}

	public EntityNuke(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
		this.setFuse(600);
	}

	public EntityNuke(World world) {
		super(world);
		this.setFuse(600);
	}

	@Override
	public ModExplosionBase createTNTExplosion(double x, double y, double z) {
		return new ModExplosionBase(world, ignitor, x, y, z, 80.0f, false, true, false, 160);
	}

	@Override
	public void setParticles() {
		this.world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, this.posX, this.posY + 0.5D, this.posZ, 0.0D, 0.0D,
				0.0D);
		this.world.spawnParticle(EnumParticleTypes.LAVA, this.posX, this.posY + 0.5D, this.posZ, 0.0D, 0.0D, 0.0D);
	}
}