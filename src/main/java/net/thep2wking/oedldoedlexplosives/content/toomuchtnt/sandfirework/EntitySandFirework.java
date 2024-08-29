package net.thep2wking.oedldoedlexplosives.content.toomuchtnt.sandfirework;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class EntitySandFirework extends ModEntityTNTBase {
	public EntitySandFirework(World world, double x, double y, double z, EntityLivingBase igniter, int fuse,
			float explosionStrength, boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(world, x, y, z, igniter, fuse, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
		this.setFuse(20);
	}

	public EntitySandFirework(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
		this.setFuse(20);
	}

	public EntitySandFirework(World world) {
		super(world);
		this.setFuse(20);
	}

	@Override
	public ModExplosionBase createTNTExplosion(double x, double y, double z) {
		return new ExplosionSandFirework(world, ignitor, x, y, z, 8.0f, false, false, false, 0);
	}

	@Override
	public void handleExtraExplosionEffects(double x, double y, double z) {
		spawnFallingBlockX10(2.5f, 4.0f, 2.5f);
		spawnFallingBlockX10(2.5f, 4.0f, 2.5f);
		spawnFallingBlockX10(2.5f, 4.0f, 2.5f);
		spawnFallingBlockX10(2.5f, 4.0f, 2.5f);
		spawnFallingBlockX10(2.5f, 4.0f, 2.5f);
		spawnFallingBlockX10(2.5f, 4.0f, 2.5f);
		spawnFallingBlockX10(2.5f, 4.0f, 2.5f);
		spawnFallingBlockX10(2.5f, 4.0f, 2.5f);
		spawnFallingBlockX10(2.5f, 4.0f, 2.5f);
		spawnFallingBlockX10(2.5f, 4.0f, 2.5f);

		spawnFallingBlockX10(2.5f, 4.0f, 2.5f);
		spawnFallingBlockX10(2.5f, 4.0f, 2.5f);
		spawnFallingBlockX10(2.5f, 4.0f, 2.5f);
		spawnFallingBlockX10(2.5f, 4.0f, 2.5f);
		spawnFallingBlockX10(2.5f, 4.0f, 2.5f);
		spawnFallingBlockX10(2.5f, 4.0f, 2.5f);
		spawnFallingBlockX10(2.5f, 4.0f, 2.5f);
		spawnFallingBlockX10(2.5f, 4.0f, 2.5f);
		spawnFallingBlockX10(2.5f, 4.0f, 2.5f);
		spawnFallingBlockX10(2.5f, 4.0f, 2.5f);
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
			int[] params = { Block.getStateId(Blocks.SAND.getDefaultState()) };
			this.world.spawnParticle(EnumParticleTypes.FALLING_DUST, this.posX, this.posY - 0.5, this.posZ, 0.0, 0.0,
					0.0, params);
			this.world.spawnParticle(EnumParticleTypes.FALLING_DUST, this.posX, this.posY - 0.4, this.posZ, 0.0, 0.0,
					0.0, params);
			this.world.spawnParticle(EnumParticleTypes.FALLING_DUST, this.posX, this.posY - 0.3, this.posZ, 0.0, 0.0,
					0.0, params);
			this.world.spawnParticle(EnumParticleTypes.FALLING_DUST, this.posX, this.posY - 0.2, this.posZ, 0.0, 0.0,
					0.0, params);
			this.world.spawnParticle(EnumParticleTypes.FALLING_DUST, this.posX, this.posY - 0.1, this.posZ, 0.0, 0.0,
					0.0, params);
			this.world.spawnParticle(EnumParticleTypes.FALLING_DUST, this.posX, this.posY, this.posZ, 0.0, 0.0, 0.0,
					params);
			this.world.spawnParticle(EnumParticleTypes.FALLING_DUST, this.posX, this.posY + 0.1, this.posZ, 0.0, 0.0,
					0.0, params);
			this.world.spawnParticle(EnumParticleTypes.FALLING_DUST, this.posX, this.posY + 0.2, this.posZ, 0.0, 0.0,
					0.0, params);
			this.world.spawnParticle(EnumParticleTypes.FALLING_DUST, this.posX, this.posY + 0.3, this.posZ, 0.0, 0.0,
					0.0, params);
			this.world.spawnParticle(EnumParticleTypes.FALLING_DUST, this.posX, this.posY + 0.4, this.posZ, 0.0, 0.0,
					0.0, params);
			this.world.spawnParticle(EnumParticleTypes.FALLING_DUST, this.posX, this.posY + 0.5, this.posZ, 0.0, 0.0,
					0.0, params);
			this.world.spawnParticle(EnumParticleTypes.FALLING_DUST, this.posX, this.posY + 0.6, this.posZ, 0.0, 0.0,
					0.0, params);
			this.world.spawnParticle(EnumParticleTypes.FALLING_DUST, this.posX, this.posY + 0.7, this.posZ, 0.0, 0.0,
					0.0, params);
			this.world.spawnParticle(EnumParticleTypes.FALLING_DUST, this.posX, this.posY + 0.8, this.posZ, 0.0, 0.0,
					0.0, params);
			this.world.spawnParticle(EnumParticleTypes.FALLING_DUST, this.posX, this.posY + 0.9, this.posZ, 0.0, 0.0,
					0.0, params);
			this.world.spawnParticle(EnumParticleTypes.FALLING_DUST, this.posX, this.posY + 1.0, this.posZ, 0.0, 0.0,
					0.0, params);
			this.world.spawnParticle(EnumParticleTypes.FALLING_DUST, this.posX, this.posY + 1.1, this.posZ, 0.0, 0.0,
					0.0, params);
			this.world.spawnParticle(EnumParticleTypes.FALLING_DUST, this.posX, this.posY + 1.2, this.posZ, 0.0, 0.0,
					0.0, params);
		}
	}

	public void spawnFallingBlock(float motionX, float motionY, float motionZ) {
		if (!this.world.isRemote) {
			EntityFallingBlock entity = new EntityFallingBlock(world, this.posX, this.posY + this.height / 2.0F,
					this.posZ,
					Blocks.SAND.getDefaultState());
			float f = (float) (Math.random() * Math.PI * 2.0);
			entity.fallTime = 1;
			entity.motionX = (double) (-((float) Math.sin(f)) * motionX) * Math.random();
			entity.motionY = Math.abs(motionY * Math.random());
			entity.motionZ = (double) (-((float) Math.cos(f)) * motionZ) * Math.random();
			world.spawnEntity(entity);
		}
	}

	public void spawnFallingBlockX2(float motionX, float motionY, float motionZ) {
		spawnFallingBlock(motionX, motionY, motionZ);
		spawnFallingBlock(motionX, motionY, motionZ);
	}

	public void spawnFallingBlockX4(float motionX, float motionY, float motionZ) {
		spawnFallingBlockX2(motionX, motionY, motionZ);
		spawnFallingBlockX2(motionX, motionY, motionZ);
	}

	public void spawnFallingBlockX5(float motionX, float motionY, float motionZ) {
		spawnFallingBlock(motionX, motionY, motionZ);
		spawnFallingBlockX2(motionX, motionY, motionZ);
		spawnFallingBlockX2(motionX, motionY, motionZ);
	}

	public void spawnFallingBlockX8(float motionX, float motionY, float motionZ) {
		spawnFallingBlockX4(motionX, motionY, motionZ);
		spawnFallingBlockX4(motionX, motionY, motionZ);
	}

	public void spawnFallingBlockX10(float motionX, float motionY, float motionZ) {
		spawnFallingBlockX2(motionX, motionY, motionZ);
		spawnFallingBlockX4(motionX, motionY, motionZ);
		spawnFallingBlockX4(motionX, motionY, motionZ);
	}

	public void spawnFallingBlockX20(float motionX, float motionY, float motionZ) {
		spawnFallingBlockX10(motionX, motionY, motionZ);
		spawnFallingBlockX10(motionX, motionY, motionZ);
	}
}