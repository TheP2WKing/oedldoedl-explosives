package net.thep2wking.oedldoedlexplosives.content.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityEndermite;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.entity.monster.EntityHusk;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityStray;
import net.minecraft.entity.monster.EntityVindicator;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;

public class EntityAnimalTNT extends ModEntityTNTBase {
	public EntityAnimalTNT(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
	}

	public EntityAnimalTNT(World world) {
		super(world);
	}

	@Override
	public void explode() {
		this.world.newExplosion(this, this.posX, this.posY + (double) (this.height / 16.0F), this.posZ, 0, false,
				false);

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
			EntitySlime entity = new EntitySlime(this.world);
			entity.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
			this.world.spawnEntity((Entity) entity);
		}
		if (!this.world.isRemote) {
			EntityPigZombie entity = new EntityPigZombie(this.world);
			entity.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
			this.world.spawnEntity((Entity) entity);
		}
		if (!this.world.isRemote) {
			EntitySheep entity = new EntitySheep(this.world);
			entity.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
			this.world.spawnEntity((Entity) entity);
		}
		if (!this.world.isRemote) {
			EntityWolf entity = new EntityWolf(this.world);
			entity.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
			this.world.spawnEntity((Entity) entity);
		}
		if (!this.world.isRemote) {
			EntityMooshroom entity = new EntityMooshroom(this.world);
			entity.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
			this.world.spawnEntity((Entity) entity);
		}
		if (!this.world.isRemote) {
			EntityOcelot entity = new EntityOcelot(this.world);
			entity.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
			this.world.spawnEntity((Entity) entity);
		}
		if (!this.world.isRemote) {
			EntityBlaze entity = new EntityBlaze(this.world);
			entity.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
			this.world.spawnEntity((Entity) entity);
		}
		if (!this.world.isRemote) {
			EntityMagmaCube entity = new EntityMagmaCube(this.world);
			entity.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
			this.world.spawnEntity((Entity) entity);
		}
		if (!this.world.isRemote) {
			EntityCaveSpider entity = new EntityCaveSpider(this.world);
			entity.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
			this.world.spawnEntity((Entity) entity);
		}
		if (!this.world.isRemote) {
			EntityVillager entity = new EntityVillager(this.world);
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
			EntityGuardian entity = new EntityGuardian(this.world);
			entity.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
			this.world.spawnEntity((Entity) entity);
		}
		if (!this.world.isRemote) {
			EntityVindicator entity = new EntityVindicator(this.world);
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
		if (!this.world.isRemote) {
			EntityEndermite entity = new EntityEndermite(this.world);
			entity.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
			this.world.spawnEntity((Entity) entity);
		}
		if (!this.world.isRemote) {
			EntitySilverfish entity = new EntitySilverfish(this.world);
			entity.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
			this.world.spawnEntity((Entity) entity);
		}
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
			EntitySlime entity = new EntitySlime(this.world);
			entity.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
			this.world.spawnEntity((Entity) entity);
		}
		if (!this.world.isRemote) {
			EntityPigZombie entity = new EntityPigZombie(this.world);
			entity.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
			this.world.spawnEntity((Entity) entity);
		}
		if (!this.world.isRemote) {
			EntitySheep entity = new EntitySheep(this.world);
			entity.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
			this.world.spawnEntity((Entity) entity);
		}
		if (!this.world.isRemote) {
			EntityWolf entity = new EntityWolf(this.world);
			entity.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
			this.world.spawnEntity((Entity) entity);
		}
		if (!this.world.isRemote) {
			EntityMooshroom entity = new EntityMooshroom(this.world);
			entity.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
			this.world.spawnEntity((Entity) entity);
		}
		if (!this.world.isRemote) {
			EntityOcelot entity = new EntityOcelot(this.world);
			entity.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
			this.world.spawnEntity((Entity) entity);
		}
		if (!this.world.isRemote) {
			EntityBlaze entity = new EntityBlaze(this.world);
			entity.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
			this.world.spawnEntity((Entity) entity);
		}
		if (!this.world.isRemote) {
			EntityMagmaCube entity = new EntityMagmaCube(this.world);
			entity.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
			this.world.spawnEntity((Entity) entity);
		}
		if (!this.world.isRemote) {
			EntityCaveSpider entity = new EntityCaveSpider(this.world);
			entity.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
			this.world.spawnEntity((Entity) entity);
		}
		if (!this.world.isRemote) {
			EntityVillager entity = new EntityVillager(this.world);
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
			EntityGuardian entity = new EntityGuardian(this.world);
			entity.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
			this.world.spawnEntity((Entity) entity);
		}
		if (!this.world.isRemote) {
			EntityVindicator entity = new EntityVindicator(this.world);
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
		if (!this.world.isRemote) {
			EntityEndermite entity = new EntityEndermite(this.world);
			entity.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
			this.world.spawnEntity((Entity) entity);
		}
		if (!this.world.isRemote) {
			EntitySilverfish entity = new EntitySilverfish(this.world);
			entity.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
			this.world.spawnEntity((Entity) entity);
		}
	}
}