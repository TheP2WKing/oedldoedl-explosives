package net.thep2wking.oedldoedlexplosives.content.toomuchtnt.gravity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class EntityGravityTNT extends ModEntityTNTBase {
	public EntityGravityTNT(World world, double x, double y, double z, EntityLivingBase igniter, int fuse,
			float explosionStrength, boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(world, x, y, z, igniter, fuse, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
	}

	public EntityGravityTNT(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
		this.setFuse(180);
	}

	public EntityGravityTNT(World world) {
		super(world);
		this.setFuse(180);
	}

	@Override
	public ModExplosionBase createTNTExplosion(double x, double y, double z) {
		return new ExplosionGravityTNT(world, ignitor, x, y, z, 12.0f, false, false, false, 0);
	}

	@Override
	public void onUpdate() {
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;
		if (!this.hasNoGravity()) {
			this.motionY -= 0.03999999910593033D;
			if (this.fuse <= 100) {
				if (this.motionY > 0) {
					this.motionY = 0;
				}
			}
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
		this.customUpdate();
		--this.fuse;
		if (this.fuse <= 0) {
			this.setDead();
			this.explode();
		} else {
			this.handleWaterMovement();
			this.setParticles();
			this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX + 1.0, this.posY + 0.5, this.posZ, -0.1,
					0.0, 0.0, new int[0]);
			this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX - 1.0, this.posY + 0.5, this.posZ, 0.1,
					0.0, 0.0, new int[0]);
			this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX, this.posY + 0.5, this.posZ + 1.0, 0.0,
					0.0, -0.1, new int[0]);
			this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX, this.posY + 0.5, this.posZ - 1.0, 0.0,
					0.0, 0.1, new int[0]);
			this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX + 0.7, this.posY + 0.5, this.posZ + 0.7,
					-0.07, 0.0, -0.07, new int[0]);
			this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX - 0.7, this.posY + 0.5, this.posZ + 0.7,
					0.07, 0.0, -0.07, new int[0]);
			this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX + 0.7, this.posY + 0.5, this.posZ - 0.7,
					-0.07, 0.0, 0.07, new int[0]);
			this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX - 0.7, this.posY + 0.5, this.posZ - 0.7,
					0.07, 0.0, 0.07, new int[0]);
		}
	}

	@Override
	public void customUpdate() {
		if (this.fuse <= 100) {
			for (int i = 1; i < 7; i++) {
				if (i % 6 == 0) {
					ModExplosionBase explosion = new ExplosionGravityTNTPre(world, ignitor, this.posX,
							this.posY + 2f,
							this.posZ, 12.0f, false, false, false, 0);
					explosion.doExplosionA();
					explosion.doExplosionB(false);
				}
			}
		}
	}
}