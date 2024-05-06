package net.thep2wking.oedldoedlexplosives.content.toomuchtnt.lightning;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class EntityLightningTNT extends ModEntityTNTBase {
	public EntityLightningTNT(World world, double x, double y, double z, EntityLivingBase igniter, int fuse,
			float explosionStrength, boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(world, x, y, z, igniter, fuse, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
	}

	public EntityLightningTNT(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
		this.setFuse(120);
	}

	public EntityLightningTNT(World world) {
		super(world);
		this.setFuse(120);
	}

	@Override
	public ModExplosionBase createTNTExplosion(double x, double y, double z) {
		return new ModExplosionBase(world, ignitor, x, y, z, 8.0f, true, true, true, 24);
	}

	@Override
	public void customUpdate() {
		if (this.fuse <= 40) {
			for (int i = 1; i < 20; i++) {
				int randomFuse = this.world.rand.nextInt(40);
				int randomFuse2 = this.world.rand.nextInt(40);
				ModExplosionBase explosion = new ExplosionLightningTNT(world, ignitor, this.posX, this.posY, this.posZ,
						22.0f, false, false, false, 0);
				if (this.fuse == randomFuse && !world.isRemote) {
					explosion.doExplosionA();
					explosion.doExplosionB(false);
				}
				if (this.fuse == randomFuse2 && !world.isRemote) {
					explosion.doExplosionA();
					explosion.doExplosionB(false);
				}
			}
		}
	}
}