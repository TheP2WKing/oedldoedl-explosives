package net.thep2wking.oedldoedlexplosives.content.entity;

import java.util.List;

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
import net.thep2wking.oedldoedlexplosives.config.ExplosivesConfig;

public class EntityEntityFirework extends ModEntityTNTBase {
	public EntityEntityFirework(World world, double x, double y, double z, EntityLivingBase igniter, int fuse,
			float explosionStrength, boolean spawnFire, boolean blockDamage) {
		super(world, x, y, z, igniter, fuse, explosionStrength, spawnFire, blockDamage);
	}

	public EntityEntityFirework(World world) {
		super(world);
	}

	public void spawnFireworkEntity() {
		if (!this.world.isRemote) {
			Entity entity = EntityList.createEntityByIDFromName(
					new ResourceLocation(this.getEntityData().getString("id").toString()), this.world);
			if (entity != null) {
				entity.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
				float f = (float) (Math.random() * Math.PI * 2.0);
				entity.motionX = (double) (-((float) Math.sin(f)) * 2.5f) * Math.random();
				entity.motionY = Math.abs(4.0 * Math.random());
				entity.motionZ = (double) (-((float) Math.cos(f)) * 2.5f) * Math.random();
				this.world.spawnEntity((Entity) entity);
			}
		}
	}

	public void spawnFireworkBlockX10() {
		spawnFireworkEntity();
		spawnFireworkEntity();
		spawnFireworkEntity();
		spawnFireworkEntity();
		spawnFireworkEntity();
		spawnFireworkEntity();
		spawnFireworkEntity();
		spawnFireworkEntity();
		spawnFireworkEntity();
		spawnFireworkEntity();
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

		if (this.getEntityData().getString("id").toString() != "") {
			this.world.newExplosion(this, this.posX, this.posY + (double) (this.height / 16.0F), this.posZ,
					this.explosionStrength, this.spawnFire, this.blockDamage);
		} else {
			this.world.newExplosion(this, this.posX, this.posY + (double) (this.height / 16.0F), this.posZ,
					this.explosionStrength + 8.0f, this.spawnFire, this.blockDamage);
		}
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
			this.world.spawnParticle(EnumParticleTypes.DAMAGE_INDICATOR, this.posX, this.posY - 0.5, this.posZ, 0.0,
					0.0, 0.0,
					new int[0]);
			this.world.spawnParticle(EnumParticleTypes.DAMAGE_INDICATOR, this.posX, this.posY - 0.4, this.posZ, 0.0,
					0.0, 0.0,
					new int[0]);
			this.world.spawnParticle(EnumParticleTypes.DAMAGE_INDICATOR, this.posX, this.posY - 0.3, this.posZ, 0.0,
					0.0, 0.0,
					new int[0]);
			this.world.spawnParticle(EnumParticleTypes.DAMAGE_INDICATOR, this.posX, this.posY - 0.2, this.posZ, 0.0,
					0.0, 0.0,
					new int[0]);
			this.world.spawnParticle(EnumParticleTypes.DAMAGE_INDICATOR, this.posX, this.posY - 0.1, this.posZ, 0.0,
					0.0, 0.0,
					new int[0]);
			this.world.spawnParticle(EnumParticleTypes.DAMAGE_INDICATOR, this.posX, this.posY, this.posZ, 0.0, 0.0, 0.0,
					new int[0]);
			this.world.spawnParticle(EnumParticleTypes.DAMAGE_INDICATOR, this.posX, this.posY + 0.1, this.posZ, 0.0,
					0.0, 0.0,
					new int[0]);
			this.world.spawnParticle(EnumParticleTypes.DAMAGE_INDICATOR, this.posX, this.posY + 0.2, this.posZ, 0.0,
					0.0, 0.0,
					new int[0]);
			this.world.spawnParticle(EnumParticleTypes.DAMAGE_INDICATOR, this.posX, this.posY + 0.3, this.posZ, 0.0,
					0.0, 0.0,
					new int[0]);
			this.world.spawnParticle(EnumParticleTypes.DAMAGE_INDICATOR, this.posX, this.posY + 0.4, this.posZ, 0.0,
					0.0, 0.0,
					new int[0]);
			this.world.spawnParticle(EnumParticleTypes.DAMAGE_INDICATOR, this.posX, this.posY + 0.5, this.posZ, 0.0,
					0.0, 0.0,
					new int[0]);
			this.world.spawnParticle(EnumParticleTypes.DAMAGE_INDICATOR, this.posX, this.posY + 0.6, this.posZ, 0.0,
					0.0, 0.0,
					new int[0]);
			this.world.spawnParticle(EnumParticleTypes.DAMAGE_INDICATOR, this.posX, this.posY + 0.7, this.posZ, 0.0,
					0.0, 0.0,
					new int[0]);
			this.world.spawnParticle(EnumParticleTypes.DAMAGE_INDICATOR, this.posX, this.posY + 0.8, this.posZ, 0.0,
					0.0, 0.0,
					new int[0]);
			this.world.spawnParticle(EnumParticleTypes.DAMAGE_INDICATOR, this.posX, this.posY + 0.9, this.posZ, 0.0,
					0.0, 0.0,
					new int[0]);
			this.world.spawnParticle(EnumParticleTypes.DAMAGE_INDICATOR, this.posX, this.posY + 1.0, this.posZ, 0.0,
					0.0, 0.0,
					new int[0]);
			this.world.spawnParticle(EnumParticleTypes.DAMAGE_INDICATOR, this.posX, this.posY + 1.1, this.posZ, 0.0,
					0.0, 0.0,
					new int[0]);
			this.world.spawnParticle(EnumParticleTypes.DAMAGE_INDICATOR, this.posX, this.posY + 1.2, this.posZ, 0.0,
					0.0, 0.0,
					new int[0]);
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
}