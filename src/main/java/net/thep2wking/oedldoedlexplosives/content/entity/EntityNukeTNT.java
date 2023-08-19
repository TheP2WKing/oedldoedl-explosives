package net.thep2wking.oedldoedlexplosives.content.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;

public class EntityNukeTNT extends ModEntityTNTBase {
	public EntityNukeTNT(World world, double x, double y, double z, EntityLivingBase igniter, int fuse, float explosionStrength, boolean spawnFire, boolean blockDamage) {
		super(world, x, y, z, igniter, fuse, explosionStrength, spawnFire, blockDamage);
	}

	public EntityNukeTNT(World world) {
		super(world);
	}

	@Override
	public void explode() {
		int posX1 = this.getPosition().getX() - 25;
		int posX2 = this.getPosition().getX() + 25;
		int posY1 = this.getPosition().getY() - 15;
		int posY2 = this.getPosition().getY() + 15;
		int posZ1 = this.getPosition().getZ() - 25;
		int posZ2 = this.getPosition().getZ() + 25;

		for (int x = posX1; x < posX2; x += 5) {
			for (int y = posY1; y < posY2; y += 5) {
				for (int z = posZ1; z < posZ2; z += 5) {
					this.world.newExplosion(this, x, y, z, explosionStrength, spawnFire, blockDamage);			
				}
			}
		}
		this.world.newExplosion(this, this.posX, this.posY, this.posZ, 100.0f, true, blockDamage);	
	}
}