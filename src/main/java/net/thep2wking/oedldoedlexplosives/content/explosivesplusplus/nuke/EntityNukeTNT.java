package net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.nuke;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class EntityNukeTNT extends ModEntityTNTBase {
	public EntityNukeTNT(World world, double x, double y, double z, EntityLivingBase igniter, int fuse,
			float explosionStrength, boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(world, x, y, z, igniter, fuse, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
		this.setFuse(180);
	}

	public EntityNukeTNT(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
		this.setFuse(180);
	}

	public EntityNukeTNT(World world) {
		super(world);
		this.setFuse(180);
	}

	@Override
	public ModExplosionBase createTNTExplosion(double x, double y, double z) {
		return new ModExplosionBase(world, ignitor, x, y, z, 5.0f, false, true, false, 16);
	}

	@Override
	public void handleExplosion(double x, double y, double z) {
		final int xDia = 40;
		final int yDia = 40;
		final int zDia = 40;
		for (int x2 = 0; x2 < xDia; x2 += 5) {
			for (int z2 = 0; z2 < zDia; z2 += 5) {
				for (int y2 = 0; y2 < yDia; y2 += 2) {
					ModExplosionBase explosion = createTNTExplosion(x + x2 - xDia / 2.0, y + y2 - yDia / 2.0,
							z + z2 - zDia / 2.0);
					this.handleExplosionLogic(explosion);
				}
			}
		}
		ModExplosionBase explosion = new ModExplosionBase(world, ignitor, x, y, z, 100.0f, false, true, true, 128);
		this.handleExplosionLogic(explosion);
	}
}