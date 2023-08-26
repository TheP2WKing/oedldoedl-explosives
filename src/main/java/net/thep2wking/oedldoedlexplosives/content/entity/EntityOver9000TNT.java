package net.thep2wking.oedldoedlexplosives.content.entity;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;
import net.thep2wking.oedldoedlexplosives.config.ExplosivesConfig;

public class EntityOver9000TNT extends ModEntityTNTBase {
	public EntityOver9000TNT(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
	}

	public EntityOver9000TNT(World world) {
		super(world);
	}

	@Override
	public void explode() {
		this.world.newExplosion(this, this.posX, this.posY + (double) (this.height / 16.0F), this.posZ, 4.0f, false,
				true);
	}

	@Override
	public boolean hasNoGravity() {
		return ExplosivesConfig.CONTENT.OVER_9000_TNT;
	}

	@Override
	public void onUpdate() {
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;
		if (!this.hasNoGravity()) {
			this.motionY -= 0.03999999910593033D;
		}

		this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
		this.motionX *= 0.9800000190734863D;
		this.motionY *= 0.9800000190734863D;
		this.motionZ *= 0.9800000190734863D;
		if (this.onGround) {
			this.motionX *= 0.699999988079071D;
			this.motionZ *= 0.699999988079071D;
			this.motionY *= -0.5D;
		}

		if (ExplosivesConfig.CONTENT.OVER_9000_TNT) {
			int tnts = 0;
			if (this.fuse-- <= 0) {
				if (-this.fuse % 10 == 0) {
					final Random rnd2 = new Random();
					final int rangeMin2 = -3;
					final int rangeMax2 = 3;
					final EntityTNTPrimed entitytntprimed = new EntityTNTPrimed(this.world,
							(double) ((float) this.posX + 0.1f),
							(double) ((float) this.posY + 0.1f), (double) ((float) this.posZ + 0.1f), this.ignitor);
					entitytntprimed.addVelocity(rangeMin2 + (rangeMax2 - rangeMin2) * rnd2.nextDouble(),
							rangeMin2 + (rangeMax2 - rangeMin2) * rnd2.nextDouble(),
							rangeMin2 + (rangeMax2 - rangeMin2) * rnd2.nextDouble());
					this.world.spawnEntity((Entity) entitytntprimed);
					++tnts;
				}
				if (tnts >= 9001) {
					this.setDead();
				}
			}
		} else {
			--this.fuse;
			if (this.fuse <= 0) {
				this.setDead();
				if (!this.world.isRemote) {
					this.explode();
				}
			} else {
				this.handleWaterMovement();
				this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX, this.posY + 0.5D, this.posZ, 0.0D,
						0.0D,
						0.0D);
			}
		}
	}
}