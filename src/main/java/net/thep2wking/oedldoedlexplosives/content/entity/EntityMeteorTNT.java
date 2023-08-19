package net.thep2wking.oedldoedlexplosives.content.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;

public class EntityMeteorTNT extends ModEntityTNTBase {
	public EntityMeteorTNT(World world, double x, double y, double z, EntityLivingBase igniter, int fuse,
			float explosionStrength, boolean spawnFire, boolean blockDamage) {
		super(world, x, y, z, igniter, fuse, explosionStrength, spawnFire, blockDamage);
	}

	public EntityMeteorTNT(World world) {
		super(world);
	}

	@Override
	public void explode() {
		this.world.newExplosion(this, this.posX, this.posY + (double) (this.height / 16.0F), this.posZ, this.explosionStrength, this.spawnFire, this.blockDamage);

		this.world.addWeatherEffect(new EntityLightningBolt(world, this.posX, this.posY, (double) (this.height / 16.0F), false));
		this.world.addWeatherEffect(new EntityLightningBolt(world, this.posX + 1, this.posY, (double) (this.height / 16.0F), false));
		this.world.addWeatherEffect(new EntityLightningBolt(world, this.posX - 1, this.posY, (double) (this.height / 16.0F), false));
		this.world.addWeatherEffect(new EntityLightningBolt(world, this.posX, this.posY, (double) (this.height / 16.0F) + 1, false));
		this.world.addWeatherEffect(new EntityLightningBolt(world, this.posX, this.posY, (double) (this.height / 16.0F) - 1, false));
	}
}