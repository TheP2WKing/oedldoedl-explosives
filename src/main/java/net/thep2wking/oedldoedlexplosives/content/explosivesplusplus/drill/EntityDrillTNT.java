package net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.drill;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class EntityDrillTNT extends ModEntityTNTBase {
	public EntityDrillTNT(World world, double x, double y, double z, EntityLivingBase igniter, int fuse,
			float explosionStrength, boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(world, x, y, z, igniter, fuse, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
	}

	public EntityDrillTNT(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
	}

	public EntityDrillTNT(World world) {
		super(world);
	}

	@Override
	public ModExplosionBase createTNTExplosion(double x, double y, double z) {
		return new ModExplosionBase(world, ignitor, x, y, z, 20.0f, false, true, false, 16);
	}

	@Override
	public void handleExplosion(double x, double y, double z) {
		int steps = 4;
		for (int posY = (int) y; posY > 0; posY -= steps) {
			ModExplosionBase explosion = createTNTExplosion(x, posY, z);
			this.handleExplosionLogic(explosion);
		}
	}
}