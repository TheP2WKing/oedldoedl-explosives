package net.thep2wking.oedldoedlexplosives.content.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;

public class EntityNuke extends ModEntityTNTBase {
	public EntityNuke(World world, double x, double y, double z, EntityLivingBase igniter, int fuse,
			float explosionStrength, boolean spawnFire, boolean blockDamage) {
		super(world, x, y, z, igniter, fuse, explosionStrength, spawnFire, blockDamage);
	}

	public EntityNuke(World world) {
		super(world);
	}

	@Override
	public void explode() {
		this.world.newExplosion(this, this.posX, this.posY + (double) (this.height / 16.0F), this.posZ,
				explosionStrength, spawnFire, blockDamage);
		this.world.newExplosion(this, this.posX, this.posY + (double) (this.height / 16.0F) - 5, this.posZ,
				explosionStrength, spawnFire, blockDamage);
		this.world.newExplosion(this, this.posX + 10, this.posY + (double) (this.height / 16.0F), this.posZ,
				explosionStrength, spawnFire, blockDamage);
		this.world.newExplosion(this, this.posX - 10, this.posY + (double) (this.height / 16.0F), this.posZ,
				explosionStrength, spawnFire, blockDamage);
		this.world.newExplosion(this, this.posX, this.posY + (double) (this.height / 16.0F), this.posZ + 10,
				explosionStrength, spawnFire, blockDamage);
		this.world.newExplosion(this, this.posX, this.posY + (double) (this.height / 16.0F), this.posZ - 10,
				explosionStrength, spawnFire, blockDamage);
	}
}