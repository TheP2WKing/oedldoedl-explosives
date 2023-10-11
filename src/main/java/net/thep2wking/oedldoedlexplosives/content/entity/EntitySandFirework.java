package net.thep2wking.oedldoedlexplosives.content.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;

public class EntitySandFirework extends ModEntityTNTBase {
	public EntitySandFirework(World world, double x, double y, double z, EntityLivingBase igniter, int fuse,
			float explosionStrength, boolean spawnFire, boolean blockDamage) {
		super(world, x, y, z, igniter, fuse, explosionStrength, spawnFire, blockDamage);
	}

	public EntitySandFirework(World world) {
		super(world);
	}

	public void spawnFireworkBlock() {
		if (!this.world.isRemote) {
			EntityFallingBlock entitytntprimed = new EntityFallingBlock(this.world, (float) this.posX + 0.5f,
					(float) this.posY + 0.5f, (float) this.posZ + 0.5f, Blocks.SAND.getDefaultState());
			float f = (float) (Math.random() * Math.PI * 2.0);
			entitytntprimed.fallTime = 2;
			entitytntprimed.motionX = (double) (-((float) Math.sin(f)) * 2.5f) * Math.random();
			entitytntprimed.motionY = Math.abs(4.0 * Math.random());
			entitytntprimed.motionZ = (double) (-((float) Math.cos(f)) * 2.5f) * Math.random();
			this.world.spawnEntity((Entity) entitytntprimed);
		}
	}

	public void spawnFireworkBlockX10() {
		spawnFireworkBlock();
		spawnFireworkBlock();
		spawnFireworkBlock();
		spawnFireworkBlock();
		spawnFireworkBlock();
		spawnFireworkBlock();
		spawnFireworkBlock();
		spawnFireworkBlock();
		spawnFireworkBlock();
		spawnFireworkBlock();
	}

	@Override
	public void explode() {
		spawnFireworkBlockX10();
		spawnFireworkBlockX10();
		spawnFireworkBlockX10();
		spawnFireworkBlockX10();
		spawnFireworkBlockX10();
		spawnFireworkBlockX10();
		spawnFireworkBlockX10();
		spawnFireworkBlockX10();
		spawnFireworkBlockX10();
		spawnFireworkBlockX10();

		spawnFireworkBlockX10();
		spawnFireworkBlockX10();
		spawnFireworkBlockX10();
		spawnFireworkBlockX10();
		spawnFireworkBlockX10();
		spawnFireworkBlockX10();
		spawnFireworkBlockX10();
		spawnFireworkBlockX10();
		spawnFireworkBlockX10();
		spawnFireworkBlockX10();

		this.world.newExplosion(this, this.posX, this.posY + (double) (this.height / 16.0F), this.posZ,
				this.explosionStrength, this.spawnFire, this.blockDamage);
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
			this.motionY = 2.000000002980232;
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