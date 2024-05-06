package net.thep2wking.oedldoedlexplosives.content.toomuchtnt.lightning;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityDynamiteBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;
import net.thep2wking.oedldoedlexplosives.init.ModItems;

public class EntityLightningDynamate extends ModEntityDynamiteBase {
	private int fuse = 40;

	public EntityLightningDynamate(World world, double x, double y, double z) {
		super(world, x, y, z);
	}

	public EntityLightningDynamate(World world, EntityLivingBase thrower) {
		super(world, thrower);
	}

	public EntityLightningDynamate(World world) {
		super(world);
	}

	@Override
	public Item setParticleItem() {
		return ModItems.LIGHTNING_DYNAMITE;
	}

	@Override
	public ModExplosionBase createDynamiteExplosion(double x, double y, double z) {
		return new ModExplosionBase(world, thrower, x, y, z, 5.0f, true, true, true, 16);
	}

	@Override
	public void onUpdate() {
		super.onUpdate();
		if (this.hasImpacted) {
			for (int i = 1; i < 6; i++) {
				int randomFuse = this.world.rand.nextInt(40);
				int randomFuse2 = this.world.rand.nextInt(40);
				ModExplosionBase explosion = new ExplosionLightningTNT(world, thrower, this.posX, this.posY, this.posZ,
						8.0f, false, false, false, 0);
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

	@Override
	public void onImpact(RayTraceResult result) {
		if (this.isDead) {
			return;
		}
		if (result.entityHit != null && result.entityHit instanceof EntityPlayer && result.entityHit.world.isRemote) {
			return;
		}
		if (fuse > 0) {
			fuse--;
		}
		if (fuse == 0 && !world.isRemote) {
			this.explode(this.posX, this.posY, this.posZ);
		}
		this.hasImpacted = true;
		this.setVelocity(0.0, 0.0, 0.0);
	}
}