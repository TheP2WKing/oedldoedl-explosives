package net.thep2wking.oedldoedlexplosives.content.toomuchtnt.ender;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class EntityEnderTNT extends ModEntityTNTBase {
	public EntityEnderTNT(World world, double x, double y, double z, EntityLivingBase igniter, int fuse,
			float explosionStrength, boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(world, x, y, z, igniter, fuse, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
	}

	public EntityEnderTNT(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
	}

	public EntityEnderTNT(World world) {
		super(world);
	}

	@Override
	public void setParticles() {
		world.spawnParticle(EnumParticleTypes.REDSTONE, this.posX, this.posY + 1.0, this.posZ, 2.0, 0.5, 2.0,
				new int[0]);
	}

	@Override
	public ModExplosionBase createTNTExplosion(double x, double y, double z) {
		return new ExplosionEnderTNT(world, ignitor, x, y, z, 40.0f, false, false, false, 0);
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
		if (this.fuse <= 0) {
			this.setDead();
			this.explode();
		} else {
			this.handleWaterMovement();
			this.setParticles();
		}
	}
}