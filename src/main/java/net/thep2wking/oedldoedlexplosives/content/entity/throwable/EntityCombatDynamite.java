package net.thep2wking.oedldoedlexplosives.content.entity.throwable;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.oedldoedlexplosives.init.ModItems;

public class EntityCombatDynamite extends EntityThrowable {
	public EntityCombatDynamite(World worldIn) {
		super(worldIn);
	}

	public EntityCombatDynamite(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
	}

	public EntityCombatDynamite(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void handleStatusUpdate(byte id) {
		if (id == 3) {
			for (int i = 0; i < 8; ++i) {
				this.world.spawnParticle(EnumParticleTypes.ITEM_CRACK, this.posX, this.posY, this.posZ, 0.0D, 0.0D,
						0.0D, Item.getIdFromItem(ModItems.COMBAT_DYNAMITE));
			}
		}
	}

	@Override
	public void onImpact(RayTraceResult result) {
		if (result.entityHit != null && !this.world.isRemote) {
			world.newExplosion(null, result.entityHit.getPosition().getX(), result.entityHit.getPosition().getY(),
					result.entityHit.getPosition().getZ(), 8.0f, false, false);
			result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0);
		}
		if (!this.world.isRemote) {
			this.world.setEntityState(this, (byte) 3);
			this.world.newExplosion(null, this.getPosition().getX(), this.getPosition().getY(),
					this.getPosition().getZ(), 8.0f, false, false);
			this.setDead();
		}
	}
}