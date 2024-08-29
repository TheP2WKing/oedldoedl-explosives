package net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.flat;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class EntityFlatTNTEpp extends ModEntityTNTBase {
	public EntityFlatTNTEpp(World world, double x, double y, double z, EntityLivingBase igniter, int fuse,
			float explosionStrength, boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(world, x, y, z, igniter, fuse, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
	}

	public EntityFlatTNTEpp(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
	}

	public EntityFlatTNTEpp(World world) {
		super(world);
	}

	@Override
	public ModExplosionBase createTNTExplosion(double x, double y, double z) {
		return new ModExplosionBase(world, ignitor, x, y, z, 5.0f, false, true, false, 16);
	}

	@Override
	public void handleExplosion(double x, double y, double z) {
		int radius = 16;
		int steps = 2;
		for (int posX = (int) (x - radius); posX < (int) (x + radius); posX += steps) {
			for (int posZ = (int) (z - radius); posZ < (int) (z + radius); posZ += steps) {
				ModExplosionBase explosion = createTNTExplosion(posX, y, posZ);
				this.handleExplosionLogic(explosion);
			}
		}
	}
}