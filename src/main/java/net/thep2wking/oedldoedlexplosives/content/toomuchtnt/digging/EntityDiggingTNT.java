package net.thep2wking.oedldoedlexplosives.content.toomuchtnt.digging;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class EntityDiggingTNT extends ModEntityTNTBase {
	public EntityDiggingTNT(World world, double x, double y, double z, EntityLivingBase igniter, int fuse,
			float explosionStrength, boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(world, x, y, z, igniter, fuse, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
	}

	public EntityDiggingTNT(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
	}

	public EntityDiggingTNT(World world) {
		super(world);
	}

	@Override
	public ModExplosionBase createTNTExplosion(double x, double y, double z) {
		return new ExplosionDiggingTNT(world, ignitor, x, y, z, 90.0f, true, true, false, 64);
	}

	@Override
	public void setParticles() {
		this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX, this.posY + 1.5, this.posZ, 0.0, -0.1, 0.0,
				new int[0]);
	}
}