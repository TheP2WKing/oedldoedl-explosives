package net.thep2wking.oedldoedlexplosives.content.entity.throwable;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityDynamiteX5 extends EntityThrowable {
	public EntityDynamiteX5(World worldIn) {
		super(worldIn);
	}

	public EntityDynamiteX5(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
	}

	public EntityDynamiteX5(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void handleStatusUpdate(byte id) {
		if (id == 3) {
			for (int i = 0; i < 8; ++i) {
				this.world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, this.posX, this.posY, this.posZ, 0.0D, 0.0D,
						0.0D);
			}
		}
	}

	@Override
	public void onImpact(RayTraceResult result) {
		if (result.entityHit != null && !this.world.isRemote) {
			world.newExplosion(null, result.entityHit.getPosition().getX(), result.entityHit.getPosition().getY(),
					result.entityHit.getPosition().getZ(), 6.0f, false, true);
			result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0);
		}
		if (!this.world.isRemote) {
			this.world.setEntityState(this, (byte) 3);
			this.world.newExplosion(null, this.getPosition().getX(), this.getPosition().getY(),
					this.getPosition().getZ(), 6.0f, false, true);
			this.setDead();
		}
	}
}