package net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.derpy;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class EntityDerpyTNT extends ModEntityTNTBase {
	public EntityDerpyTNT(World world, double x, double y, double z, EntityLivingBase igniter, int fuse,
			float explosionStrength, boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(world, x, y, z, igniter, fuse, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
	}

	public EntityDerpyTNT(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
	}

	public EntityDerpyTNT(World world) {
		super(world);
	}

	@Override
	public ModExplosionBase createTNTExplosion(double x, double y, double z) {
		return new ModExplosionBase(world, ignitor, x, y, z, 4.0f, false, true, true, 16);
	}

	@Override
	public void handleExplosion(double x, double y, double z) {
		int min = -10;
		int max = 10;
		final int xpos = min + (int) (Math.random() * (max - min + 1));
		final int ypos = min + (int) (Math.random() * (max - min + 1));
		final int zpos = min + (int) (Math.random() * (max - min + 1));
		ModExplosionBase explosion = this.createTNTExplosion(this.posX + xpos, this.posY + ypos, this.posZ + zpos);
		this.handleExplosionLogic(explosion);
	}
}