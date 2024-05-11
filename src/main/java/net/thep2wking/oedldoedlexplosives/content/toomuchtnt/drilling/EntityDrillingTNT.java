package net.thep2wking.oedldoedlexplosives.content.toomuchtnt.drilling;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.ocean.ExplosionOceanTNT;

public class EntityDrillingTNT extends ModEntityTNTBase {
	public EntityDrillingTNT(World world, double x, double y, double z, EntityLivingBase igniter, int fuse,
			float explosionStrength, boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(world, x, y, z, igniter, fuse, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
	}

	public EntityDrillingTNT(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
	}

	public EntityDrillingTNT(World world) {
		super(world);
	}

	@Override
	public ModExplosionBase createTNTExplosion(double x, double y, double z) {
		return new ExplosionDrillingTNT(world, ignitor, x, y, z, 6.0f, false, true, false, 128);
	}

	@Override
	public void handleExtraExplosionEffects(double x, double y, double z) {
		ModExplosionBase explosion2 = new ExplosionDrillingTNT(world, ignitor, x, y - 30, z, 3.0f, false, true, false,
				64);
		ModExplosionBase explosion3 = new ExplosionDrillingTNT(world, ignitor, x, y - 55, z, 3.0f, false, true, false,
				64);
		ModExplosionBase explosion4 = new ExplosionOceanTNT(world, ignitor, x, y - 90, z, 3.0f, true, true, false, 64);
		ModExplosionBase explosion5 = new ExplosionOceanTNT(world, ignitor, x, 7, z, 3.0f, true, true, false, 64);
		this.handleExplosionLogic(explosion2);
		this.handleExplosionLogic(explosion3);
		this.handleExplosionLogic(explosion4);
		this.handleExplosionLogic(explosion5);
	}

	public void setParticles() {
		this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX, this.posY + 2.5, this.posZ, 0.0, -0.2, 0.0,
				new int[0]);
		this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX + 0.4, this.posY + 1.7, this.posZ + 0.4, 0.0,
				-0.1, 0.0, new int[0]);
		this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX + 0.4, this.posY + 1.7, this.posZ - 0.4, 0.0,
				-0.1, 0.0, new int[0]);
		this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX - 0.4, this.posY + 1.7, this.posZ + 0.4, 0.0,
				-0.1, 0.0, new int[0]);
		this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX - 0.4, this.posY + 1.7, this.posZ - 0.4, 0.0,
				-0.1, 0.0, new int[0]);
	}
}