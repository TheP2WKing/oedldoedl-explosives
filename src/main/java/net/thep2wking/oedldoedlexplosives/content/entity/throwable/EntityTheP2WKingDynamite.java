package net.thep2wking.oedldoedlexplosives.content.entity.throwable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.oedldoedlexplosives.config.ExplosivesConfig;
import net.thep2wking.oedldoedlexplosives.content.entity.living.EntityTheP2WKing;
import net.thep2wking.oedldoedlexplosives.init.ModBlocks;
import net.thep2wking.oedldoedlexplosives.init.ModItems;

public class EntityTheP2WKingDynamite extends EntityThrowable {
	public EntityTheP2WKingDynamite(World worldIn) {
		super(worldIn);
	}

	public EntityTheP2WKingDynamite(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
	}

	public EntityTheP2WKingDynamite(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void handleStatusUpdate(byte id) {
		if (id == 3) {
			for (int i = 0; i < 8; ++i) {
				this.world.spawnParticle(EnumParticleTypes.ITEM_CRACK, this.posX, this.posY, this.posZ, 0.0D, 0.0D,
						0.0D, Item.getIdFromItem(ModItems.THEP2WKING_DYNAMITE));
			}
		}
	}

	@Override
	public void onImpact(RayTraceResult result) {
		if (result.entityHit != null && !this.world.isRemote) {
			world.newExplosion(null, result.entityHit.getPosition().getX(), result.entityHit.getPosition().getY(),
					result.entityHit.getPosition().getZ(), 0.0f, false, false);
			result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0);
		}
		if (!this.world.isRemote) {
			this.world.setEntityState(this, (byte) 3);
			this.world.newExplosion(null, this.getPosition().getX(), this.getPosition().getY(),
					this.getPosition().getZ(), 0.0f, false, false);
			if (!this.world.isRemote) {
				EntityTheP2WKing entity = new EntityTheP2WKing(this.world);
				entity.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0f, 0.0f);
				if (ExplosivesConfig.CONTENT.THEP2WKING_CARRIES_TROLL_TNT) {
					entity.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(ModBlocks.TROLL_TNT, 1, 0));
				}
				this.world.spawnEntity((Entity) entity);
			}
			this.setDead();
		}
	}
}