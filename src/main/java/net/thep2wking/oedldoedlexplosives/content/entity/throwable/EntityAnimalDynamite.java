package net.thep2wking.oedldoedlexplosives.content.entity.throwable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityHusk;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityStray;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityAnimalDynamite extends EntityThrowable {
	public EntityAnimalDynamite(World worldIn) {
		super(worldIn);
	}

	public EntityAnimalDynamite(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
	}

	public EntityAnimalDynamite(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void handleStatusUpdate(byte id) {
		if (id == 3) {
			for (int i = 0; i < 8; ++i) {
				this.world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, this.posX, this.posY, this.posZ, 0.0D, 0.0D,
						0.0D);
			}
		}
	}

	@Override
	public void onImpact(RayTraceResult result) {
		if (result.entityHit != null && !this.world.isRemote) {
			world.newExplosion(null, result.entityHit.getPosition().getX(), result.entityHit.getPosition().getY(),
					result.entityHit.getPosition().getZ(), 0.0f, false, false);
			result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0);
		}
		if (!this.world.isRemote) {
			this.world.setEntityState(this, (byte) 3);
			this.world.newExplosion(null, this.getPosition().getX(), this.getPosition().getY(),
					this.getPosition().getZ(), 0.0f, false, false);
			if (!this.world.isRemote) {
				EntitySkeleton entity = new EntitySkeleton(this.world);
				entity.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
				this.world.spawnEntity((Entity) entity);
			}
			if (!this.world.isRemote) {
				EntityCreeper entity = new EntityCreeper(this.world);
				entity.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
				this.world.spawnEntity((Entity) entity);
			}
			if (!this.world.isRemote) {
				EntityZombie entity = new EntityZombie(this.world);
				entity.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
				this.world.spawnEntity((Entity) entity);
			}
			if (!this.world.isRemote) {
				EntityEnderman entity = new EntityEnderman(this.world);
				entity.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
				this.world.spawnEntity((Entity) entity);
			}
			if (!this.world.isRemote) {
				EntityPig entity = new EntityPig(this.world);
				entity.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
				this.world.spawnEntity((Entity) entity);
			}
			if (!this.world.isRemote) {
				EntityCow entity = new EntityCow(this.world);
				entity.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
				this.world.spawnEntity((Entity) entity);
			}
			if (!this.world.isRemote) {
				EntityChicken entity = new EntityChicken(this.world);
				entity.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
				this.world.spawnEntity((Entity) entity);
			}
			if (!this.world.isRemote) {
				EntitySpider entity = new EntitySpider(this.world);
				entity.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
				this.world.spawnEntity((Entity) entity);
			}
			if (!this.world.isRemote) {
				EntitySheep entity = new EntitySheep(this.world);
				entity.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
				this.world.spawnEntity((Entity) entity);
			}
			if (!this.world.isRemote) {
				EntityBlaze entity = new EntityBlaze(this.world);
				entity.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
				this.world.spawnEntity((Entity) entity);
			}
			if (!this.world.isRemote) {
				EntityRabbit entity = new EntityRabbit(this.world);
				entity.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
				this.world.spawnEntity((Entity) entity);
			}
			if (!this.world.isRemote) {
				EntityHorse entity = new EntityHorse(this.world);
				entity.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
				this.world.spawnEntity((Entity) entity);
			}
			if (!this.world.isRemote) {
				EntityLlama entity = new EntityLlama(this.world);
				entity.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
				this.world.spawnEntity((Entity) entity);
			}
			if (!this.world.isRemote) {
				EntityHusk entity = new EntityHusk(this.world);
				entity.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
				this.world.spawnEntity((Entity) entity);
			}
			if (!this.world.isRemote) {
				EntityStray entity = new EntityStray(this.world);
				entity.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
				this.world.spawnEntity((Entity) entity);
			}
			this.setDead();
		}
	}
}