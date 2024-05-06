package net.thep2wking.oedldoedlexplosives.content.toomuchtnt.tntfirework;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityImpactTNTBase;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class EntityTNTFirework extends ModEntityTNTBase {
	public EntityTNTFirework(World world, double x, double y, double z, EntityLivingBase igniter, int fuse,
			float explosionStrength, boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(world, x, y, z, igniter, fuse, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
	}

	public EntityTNTFirework(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
		this.setFuse(20);
	}

	public EntityTNTFirework(World world) {
		super(world);
		this.setFuse(20);
	}

	@Override
	public ModExplosionBase createTNTExplosion(double x, double y, double z) {
		return new ExplosionTNTFirework(world, ignitor, x, y, z, 8.0f, false, false, false, 0);
	}

	@Override
	public ModEntityImpactTNTBase createImpactTNTEntity(double x, double y, double z) {
		return new EntityTNTFireworkImpact(world, x, y, z, ignitor, 4.0f, false, true, true, 16);
	}

	@Override
	public void handleExtraExplosionEffects(double x, double y, double z) {
		spawnImpactTNTX10(2.5f, 4.0f, 2.5f);
		spawnImpactTNTX10(2.5f, 4.0f, 2.5f);
		spawnImpactTNTX10(2.5f, 4.0f, 2.5f);
		spawnImpactTNTX10(2.5f, 4.0f, 2.5f);
		spawnImpactTNTX10(2.5f, 4.0f, 2.5f);
		spawnImpactTNTX10(2.5f, 4.0f, 2.5f);
		spawnImpactTNTX10(2.5f, 4.0f, 2.5f);
		spawnImpactTNTX10(2.5f, 4.0f, 2.5f);
		spawnImpactTNTX10(2.5f, 4.0f, 2.5f);
		spawnImpactTNTX10(2.5f, 4.0f, 2.5f);

		spawnImpactTNTX10(2.5f, 4.0f, 2.5f);
		spawnImpactTNTX10(2.5f, 4.0f, 2.5f);
		spawnImpactTNTX10(2.5f, 4.0f, 2.5f);
		spawnImpactTNTX10(2.5f, 4.0f, 2.5f);
		spawnImpactTNTX10(2.5f, 4.0f, 2.5f);
		spawnImpactTNTX10(2.5f, 4.0f, 2.5f);
		spawnImpactTNTX10(2.5f, 4.0f, 2.5f);
		spawnImpactTNTX10(2.5f, 4.0f, 2.5f);
		spawnImpactTNTX10(2.5f, 4.0f, 2.5f);
		spawnImpactTNTX10(2.5f, 4.0f, 2.5f);
	}

	@Override
	public boolean hasNoGravity() {
		return true;
	}

	@Override
	public void onUpdate() {
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;
		if (this.hasNoGravity()) {
			this.motionY = 2.03999999910593033D;
		}
		this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
		this.motionX *= 0.9800000190734863D;
		this.motionY *= 0.9800000190734863D;
		this.motionZ *= 0.9800000190734863D;
		if (this.onGround) {
			this.motionX *= 0.699999988079071D;
			this.motionZ *= 0.699999988079071D;
			this.motionY *= -0.5D;
		}
		if (!world.isRemote) {
			this.customUpdate();
		}
		--this.fuse;
		if (this.fuse <= 0) {
			this.setDead();
			if (!world.isRemote) {
				this.explode();
			}
		} else {
			this.handleWaterMovement();
			this.world.spawnParticle(EnumParticleTypes.FLAME, this.posX, this.posY - 0.5, this.posZ, 0.0, 0.0, 0.0,
					new int[0]);
			this.world.spawnParticle(EnumParticleTypes.FLAME, this.posX, this.posY - 0.4, this.posZ, 0.0, 0.0, 0.0,
					new int[0]);
			this.world.spawnParticle(EnumParticleTypes.FLAME, this.posX, this.posY - 0.3, this.posZ, 0.0, 0.0, 0.0,
					new int[0]);
			this.world.spawnParticle(EnumParticleTypes.FLAME, this.posX, this.posY - 0.2, this.posZ, 0.0, 0.0, 0.0,
					new int[0]);
			this.world.spawnParticle(EnumParticleTypes.FLAME, this.posX, this.posY - 0.1, this.posZ, 0.0, 0.0, 0.0,
					new int[0]);
			this.world.spawnParticle(EnumParticleTypes.FLAME, this.posX, this.posY, this.posZ, 0.0, 0.0, 0.0,
					new int[0]);
			this.world.spawnParticle(EnumParticleTypes.FLAME, this.posX, this.posY + 0.1, this.posZ, 0.0, 0.0, 0.0,
					new int[0]);
			this.world.spawnParticle(EnumParticleTypes.FLAME, this.posX, this.posY + 0.2, this.posZ, 0.0, 0.0, 0.0,
					new int[0]);
			this.world.spawnParticle(EnumParticleTypes.FLAME, this.posX, this.posY + 0.3, this.posZ, 0.0, 0.0, 0.0,
					new int[0]);
			this.world.spawnParticle(EnumParticleTypes.FLAME, this.posX, this.posY + 0.4, this.posZ, 0.0, 0.0, 0.0,
					new int[0]);
			this.world.spawnParticle(EnumParticleTypes.FLAME, this.posX, this.posY + 0.5, this.posZ, 0.0, 0.0, 0.0,
					new int[0]);
			this.world.spawnParticle(EnumParticleTypes.FLAME, this.posX, this.posY + 0.6, this.posZ, 0.0, 0.0, 0.0,
					new int[0]);
			this.world.spawnParticle(EnumParticleTypes.FLAME, this.posX, this.posY + 0.7, this.posZ, 0.0, 0.0, 0.0,
					new int[0]);
			this.world.spawnParticle(EnumParticleTypes.FLAME, this.posX, this.posY + 0.8, this.posZ, 0.0, 0.0, 0.0,
					new int[0]);
			this.world.spawnParticle(EnumParticleTypes.FLAME, this.posX, this.posY + 0.9, this.posZ, 0.0, 0.0, 0.0,
					new int[0]);
			this.world.spawnParticle(EnumParticleTypes.FLAME, this.posX, this.posY + 1.0, this.posZ, 0.0, 0.0, 0.0,
					new int[0]);
			this.world.spawnParticle(EnumParticleTypes.FLAME, this.posX, this.posY + 1.1, this.posZ, 0.0, 0.0, 0.0,
					new int[0]);
			this.world.spawnParticle(EnumParticleTypes.FLAME, this.posX, this.posY + 1.2, this.posZ, 0.0, 0.0, 0.0,
					new int[0]);
		}
	}
}