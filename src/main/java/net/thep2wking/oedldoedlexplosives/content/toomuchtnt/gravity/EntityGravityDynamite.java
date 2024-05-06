package net.thep2wking.oedldoedlexplosives.content.toomuchtnt.gravity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityDynamiteBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;
import net.thep2wking.oedldoedlexplosives.init.ModItems;

public class EntityGravityDynamite extends ModEntityDynamiteBase {
	private int fuse = 140;

	public EntityGravityDynamite(World world, double x, double y, double z) {
		super(world, x, y, z);
	}

	public EntityGravityDynamite(World world, EntityLivingBase thrower) {
		super(world, thrower);
	}

	public EntityGravityDynamite(World world) {
		super(world);
	}

	@Override
	public Item setParticleItem() {
		return ModItems.GRAVITY_DYNAMITE;
	}

	@Override
	public ModExplosionBase createDynamiteExplosion(double x, double y, double z) {
		return new ExplosionGravityTNT(world, thrower, x, y, z, 5.0f, false, false, false, 0);
	}

	@Override
	public void onUpdate() {
		super.onUpdate();
		if (this.hasImpacted) {
			for (int i = 1; i < 7; i++) {
				if (i % 6 == 0) {
					ModExplosionBase explosion = new ExplosionGravityTNTPre(world, thrower, this.posX, this.posY + 2f,
							this.posZ, 10.0f, false, false, false, 0);
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
		this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX + 1.0, this.posY, this.posZ, -0.1,
				0.0, 0.0, new int[0]);
		this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX - 1.0, this.posY, this.posZ, 0.1,
				0.0, 0.0, new int[0]);
		this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX, this.posY, this.posZ + 1.0, 0.0,
				0.0, -0.1, new int[0]);
		this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX, this.posY, this.posZ - 1.0, 0.0,
				0.0, 0.1, new int[0]);
		this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX + 0.7, this.posY, this.posZ + 0.7,
				-0.07, 0.0, -0.07, new int[0]);
		this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX - 0.7, this.posY, this.posZ + 0.7,
				0.07, 0.0, -0.07, new int[0]);
		this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX + 0.7, this.posY, this.posZ - 0.7,
				-0.07, 0.0, 0.07, new int[0]);
		this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX - 0.7, this.posY, this.posZ - 0.7,
				0.07, 0.0, 0.07, new int[0]);
		if (fuse == 0) {
			this.explode(this.posX, this.posY, this.posZ);
		}
		this.hasImpacted = true;
		this.setVelocity(0.0, 0.0, 0.0);
	}
}