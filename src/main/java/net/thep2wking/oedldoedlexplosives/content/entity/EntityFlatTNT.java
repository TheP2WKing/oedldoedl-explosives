package net.thep2wking.oedldoedlexplosives.content.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;

public class EntityFlatTNT extends ModEntityTNTBase {
	public EntityFlatTNT(World world, double x, double y, double z, EntityLivingBase igniter, int fuse,
			float explosionStrength, boolean spawnFire, boolean blockDamage) {
		super(world, x, y, z, igniter, fuse, explosionStrength, spawnFire, blockDamage);
	}

	public EntityFlatTNT(World world) {
		super(world);
	}

	@Override
	public void explode() {
		int posX1 = this.getPosition().getX() - 16;
		int posX2 = this.getPosition().getX() + 16;
		int posZ1 = this.getPosition().getZ() - 16;
		int posZ2 = this.getPosition().getZ() + 16;

		for (int x = posX1; x < posX2; x += 8) {
			for (int z = posZ1; z < posZ2; z += 8) {
				this.world.newExplosion(this, x, this.posY + (double) (this.height / 16.0F), z, explosionStrength,
						spawnFire, blockDamage);
			}
		}
	}
}