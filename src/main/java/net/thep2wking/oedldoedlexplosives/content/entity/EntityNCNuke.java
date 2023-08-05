package net.thep2wking.oedldoedlexplosives.content.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;

public class EntityNCNuke extends ModEntityTNTBase {
	public EntityNCNuke(World world, double x, double y, double z, EntityLivingBase igniter, int fuse,
			float explosionStrength, boolean spawnFire, boolean blockDamage) {
		super(world, x, y, z, igniter, fuse, explosionStrength, spawnFire, blockDamage);
	}

	public EntityNCNuke(World world) {
		super(world);
	}

	@Override
	public void explode() {
		this.world.newExplosion(this, this.posX, this.posY + (double) (this.height / 16.0F), this.posZ,
				explosionStrength, spawnFire, blockDamage);
		this.world.newExplosion(this, this.posX, this.posY + (double) (this.height / 16.0F) - 5, this.posZ,
				explosionStrength, spawnFire, blockDamage);
		this.world.newExplosion(this, this.posX + 10, this.posY + (double) (this.height / 16.0F), this.posZ,
				explosionStrength, spawnFire, blockDamage);
		this.world.newExplosion(this, this.posX - 10, this.posY + (double) (this.height / 16.0F), this.posZ,
				explosionStrength, spawnFire, blockDamage);
		this.world.newExplosion(this, this.posX, this.posY + (double) (this.height / 16.0F), this.posZ + 10,
				explosionStrength, spawnFire, blockDamage);
		this.world.newExplosion(this, this.posX, this.posY + (double) (this.height / 16.0F), this.posZ - 10,
				explosionStrength, spawnFire, blockDamage);
	}

	@Override
	public void onUpdate() {
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;
		if (!this.hasNoGravity()) {
			this.motionY -= 0.03999999910593033D;
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
		--this.fuse;
		if (this.fuse <= 0) {
			this.setDead();

			if (!this.world.isRemote) {
				this.explode();
			}
		} else {
			this.handleWaterMovement();
			this.world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, this.posX, this.posY + 0.5D, this.posZ, 0.0D, 0.0D,
					0.0D);
			this.world.spawnParticle(EnumParticleTypes.LAVA, this.posX, this.posY + 0.5D, this.posZ, 0.0D, 0.0D, 0.0D);
		}
	}
}