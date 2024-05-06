package net.thep2wking.oedldoedlexplosives.api;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.world.World;

/**
 * @author TheP2WKing
 */
public class ModEntityImpactTNTBase extends ModEntityTNTBase {
	public ModEntityImpactTNTBase(World world, double x, double y, double z, EntityLivingBase igniter,
			float explosionStrength, boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(world, x, y, z, igniter, 1200, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
	}

	public ModEntityImpactTNTBase(World world, double x, double y, double z, EntityLivingBase igniter,
			float explosionStrength, boolean spawnFire, boolean blockDamage) {
		super(world, x, y, z, igniter, 1200, explosionStrength, spawnFire, blockDamage);
	}

	public ModEntityImpactTNTBase(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
	}

	public ModEntityImpactTNTBase(World world) {
		super(world);
	}

	@Override
	public boolean canBePushed() {
		return false;
	}

	@Override
	public boolean isImmuneToExplosions() {
		return true;
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
		this.customUpdate();
		--this.fuse;
		if (!this.world.isRemote) {
			if (this.onGround) {
				this.setDead();
				if (!this.world.isRemote) {
					this.explode();
				}
			}
			if (this.collided) {
				this.setDead();
				if (!this.world.isRemote) {
					this.explode();
				}
			}
		}
		if (this.fuse <= 0) {
			this.setDead();
			if (!this.world.isRemote) {
				this.explode();
			}
		} else {
			this.handleWaterMovement();
			this.setParticles();
		}
	}
}