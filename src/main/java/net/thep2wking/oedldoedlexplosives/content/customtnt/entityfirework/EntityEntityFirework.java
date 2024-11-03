package net.thep2wking.oedldoedlexplosives.content.customtnt.entityfirework;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;
import net.thep2wking.oedldoedlexplosives.config.ExplosivesConfig;

public class EntityEntityFirework extends ModEntityTNTBase {
	public EntityEntityFirework(World world, double x, double y, double z, EntityLivingBase igniter, int fuse,
			float explosionStrength, boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(world, x, y, z, igniter, fuse, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
		this.setFuse(20);
	}

	public EntityEntityFirework(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
		this.setFuse(20);
	}

	public EntityEntityFirework(World world) {
		super(world);
		this.setFuse(20);
	}

	@Override
	public ModExplosionBase createTNTExplosion(double x, double y, double z) {
		return new ExplosionEntityFirework(world, ignitor, x, y, z, 8.0f, false, false, false, 0);
	}

	@Override
	public void handleExtraExplosionEffects(double x, double y, double z) {
		spawnFallingEntityX10(2.5f, 4.0f, 2.5f);
		spawnFallingEntityX10(2.5f, 4.0f, 2.5f);
		spawnFallingEntityX10(2.5f, 4.0f, 2.5f);
		spawnFallingEntityX10(2.5f, 4.0f, 2.5f);
		spawnFallingEntityX10(2.5f, 4.0f, 2.5f);
		spawnFallingEntityX10(2.5f, 4.0f, 2.5f);
		spawnFallingEntityX10(2.5f, 4.0f, 2.5f);
		spawnFallingEntityX10(2.5f, 4.0f, 2.5f);
		spawnFallingEntityX10(2.5f, 4.0f, 2.5f);
		spawnFallingEntityX10(2.5f, 4.0f, 2.5f);

		spawnFallingEntityX10(2.5f, 4.0f, 2.5f);
		spawnFallingEntityX10(2.5f, 4.0f, 2.5f);
		spawnFallingEntityX10(2.5f, 4.0f, 2.5f);
		spawnFallingEntityX10(2.5f, 4.0f, 2.5f);
		spawnFallingEntityX10(2.5f, 4.0f, 2.5f);
		spawnFallingEntityX10(2.5f, 4.0f, 2.5f);
		spawnFallingEntityX10(2.5f, 4.0f, 2.5f);
		spawnFallingEntityX10(2.5f, 4.0f, 2.5f);
		spawnFallingEntityX10(2.5f, 4.0f, 2.5f);
		spawnFallingEntityX10(2.5f, 4.0f, 2.5f);
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
			int[] params = { 0 };
			this.world.spawnParticle(EnumParticleTypes.DAMAGE_INDICATOR, this.posX, this.posY - 0.5, this.posZ, 0.0,
					0.0, 0.0, params);
			this.world.spawnParticle(EnumParticleTypes.DAMAGE_INDICATOR, this.posX, this.posY - 0.4, this.posZ, 0.0,
					0.0, 0.0, params);
			this.world.spawnParticle(EnumParticleTypes.DAMAGE_INDICATOR, this.posX, this.posY - 0.3, this.posZ, 0.0,
					0.0, 0.0, params);
			this.world.spawnParticle(EnumParticleTypes.DAMAGE_INDICATOR, this.posX, this.posY - 0.2, this.posZ, 0.0,
					0.0, 0.0, params);
			this.world.spawnParticle(EnumParticleTypes.DAMAGE_INDICATOR, this.posX, this.posY - 0.1, this.posZ, 0.0,
					0.0, 0.0, params);
			this.world.spawnParticle(EnumParticleTypes.DAMAGE_INDICATOR, this.posX, this.posY, this.posZ, 0.0, 0.0, 0.0,
					params);
			this.world.spawnParticle(EnumParticleTypes.DAMAGE_INDICATOR, this.posX, this.posY + 0.1, this.posZ, 0.0,
					0.0, 0.0, params);
			this.world.spawnParticle(EnumParticleTypes.DAMAGE_INDICATOR, this.posX, this.posY + 0.2, this.posZ, 0.0,
					0.0, 0.0, params);
			this.world.spawnParticle(EnumParticleTypes.DAMAGE_INDICATOR, this.posX, this.posY + 0.3, this.posZ, 0.0,
					0.0, 0.0, params);
			this.world.spawnParticle(EnumParticleTypes.DAMAGE_INDICATOR, this.posX, this.posY + 0.4, this.posZ, 0.0,
					0.0, 0.0, params);
			this.world.spawnParticle(EnumParticleTypes.DAMAGE_INDICATOR, this.posX, this.posY + 0.5, this.posZ, 0.0,
					0.0, 0.0, params);
			this.world.spawnParticle(EnumParticleTypes.DAMAGE_INDICATOR, this.posX, this.posY + 0.6, this.posZ, 0.0,
					0.0, 0.0, params);
			this.world.spawnParticle(EnumParticleTypes.DAMAGE_INDICATOR, this.posX, this.posY + 0.7, this.posZ, 0.0,
					0.0, 0.0, params);
			this.world.spawnParticle(EnumParticleTypes.DAMAGE_INDICATOR, this.posX, this.posY + 0.8, this.posZ, 0.0,
					0.0, 0.0, params);
			this.world.spawnParticle(EnumParticleTypes.DAMAGE_INDICATOR, this.posX, this.posY + 0.9, this.posZ, 0.0,
					0.0, 0.0, params);
			this.world.spawnParticle(EnumParticleTypes.DAMAGE_INDICATOR, this.posX, this.posY + 1.0, this.posZ, 0.0,
					0.0, 0.0, params);
			this.world.spawnParticle(EnumParticleTypes.DAMAGE_INDICATOR, this.posX, this.posY + 1.1, this.posZ, 0.0,
					0.0, 0.0, params);
			this.world.spawnParticle(EnumParticleTypes.DAMAGE_INDICATOR, this.posX, this.posY + 1.2, this.posZ, 0.0,
					0.0, 0.0, params);
		}

		if (this.fuse == 19) {
			double distance = 2000;
			BlockPos blockPos = new BlockPos(this.posX, this.posY, this.posZ);
			List<EntityLivingBase> listBlockPos = world.getEntitiesWithinAABB(EntityLivingBase.class,
					new AxisAlignedBB(blockPos).grow(ExplosivesConfig.CONTENT.ENTITY_FIREWORK_RADIUS));
			for (EntityLivingBase entity : listBlockPos) {
				double xD = entity.posX - this.posX;
				double yD = entity.posY - this.posY;
				double zD = entity.posZ - this.posZ;
				double d = Math.sqrt(xD * xD + yD * yD + zD * zD);
				if (d < distance && entity != null && !(entity instanceof EntityPlayer)) {
					distance = d;
					this.getEntityData().setString("id", EntityList.getKey(entity).toString());
				}
			}
		}
	}

	public void spawnFallingEntity(float motionX, float motionY, float motionZ) {
		if (!this.world.isRemote) {
			Entity entity = EntityList.createEntityByIDFromName(
					new ResourceLocation(this.getEntityData().getString("id").toString()), this.world);
			if (entity != null) {
				float f = (float) (Math.random() * Math.PI * 2.0);
				entity.motionX = (double) (-((float) Math.sin(f)) * motionX) * Math.random();
				entity.motionY = Math.abs(motionY * Math.random());
				entity.motionZ = (double) (-((float) Math.cos(f)) * motionZ) * Math.random();
				Random random = new Random();
				entity.setLocationAndAngles(this.posX, this.posY, this.posZ, random.nextFloat() * 360.0f, 0);
				world.spawnEntity(entity);
			}
		}
	}

	public void spawnFallingEntityX2(float motionX, float motionY, float motionZ) {
		spawnFallingEntity(motionX, motionY, motionZ);
		spawnFallingEntity(motionX, motionY, motionZ);
	}

	public void spawnFallingEntityX4(float motionX, float motionY, float motionZ) {
		spawnFallingEntityX2(motionX, motionY, motionZ);
		spawnFallingEntityX2(motionX, motionY, motionZ);
	}

	public void spawnFallingEntityX5(float motionX, float motionY, float motionZ) {
		spawnFallingEntity(motionX, motionY, motionZ);
		spawnFallingEntityX2(motionX, motionY, motionZ);
		spawnFallingEntityX2(motionX, motionY, motionZ);
	}

	public void spawnFallingEntityX8(float motionX, float motionY, float motionZ) {
		spawnFallingEntityX4(motionX, motionY, motionZ);
		spawnFallingEntityX4(motionX, motionY, motionZ);
	}

	public void spawnFallingEntityX10(float motionX, float motionY, float motionZ) {
		spawnFallingEntityX2(motionX, motionY, motionZ);
		spawnFallingEntityX4(motionX, motionY, motionZ);
		spawnFallingEntityX4(motionX, motionY, motionZ);
	}

	public void spawnFallingEntityX20(float motionX, float motionY, float motionZ) {
		spawnFallingEntityX10(motionX, motionY, motionZ);
		spawnFallingEntityX10(motionX, motionY, motionZ);
	}
}