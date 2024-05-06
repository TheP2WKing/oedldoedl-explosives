package net.thep2wking.oedldoedlexplosives.content.toomuchtnt.ender;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityDynamiteBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;
import net.thep2wking.oedldoedlexplosives.init.ModItems;

public class EntityEnderDynamite extends ModEntityDynamiteBase {
	public EntityEnderDynamite(World world, double x, double y, double z) {
		super(world, x, y, z);
	}

	public EntityEnderDynamite(World world, EntityLivingBase thrower) {
		super(world, thrower);
	}

	public EntityEnderDynamite(World world) {
		super(world);
	}

	@Override
	public Item setParticleItem() {
		return ModItems.ENDER_DYNAMITE;
	}

	@Override
	public ModExplosionBase createDynamiteExplosion(double x, double y, double z) {
		return new ExplosionEnderTNT(world, thrower, x, y, z, 16.0f, false, false, false, 0);
	}

	@Override
	public void onImpact(RayTraceResult result) {
		if (this.isDead) {
			return;
		}
		if (result.entityHit != null && result.entityHit instanceof EntityPlayer && result.entityHit.world.isRemote) {
			return;
		}
		this.explode(this.posX, this.posY, this.posZ);
	}
}