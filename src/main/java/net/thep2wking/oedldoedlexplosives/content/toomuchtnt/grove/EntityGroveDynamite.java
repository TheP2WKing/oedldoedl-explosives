package net.thep2wking.oedldoedlexplosives.content.toomuchtnt.grove;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityDynamiteBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;
import net.thep2wking.oedldoedlexplosives.init.ModItems;

public class EntityGroveDynamite extends ModEntityDynamiteBase {
	public EntityGroveDynamite(World world, double x, double y, double z) {
		super(world, x, y, z);
	}

	public EntityGroveDynamite(World world, EntityLivingBase thrower) {
		super(world, thrower);
	}

	public EntityGroveDynamite(World world) {
		super(world);
	}

	@Override
	public Item setParticleItem() {
		return ModItems.GROVE_DYNAMITE;
	}

	@Override
	public ModExplosionBase createDynamiteExplosion(double x, double y, double z) {
		return new ExplosionGroveTNT(world, thrower, x, y, z, 6.0f, true, false, false, 64);
	}

	@Override
	public void onImpact(RayTraceResult result) {
		if (this.isDead) {
			return;
		}
		if (result.entityHit != null && result.entityHit instanceof EntityPlayer && result.entityHit.world.isRemote) {
			return;
		}
		if (!world.isRemote) {
			this.explode(this.posX, this.posY, this.posZ);
		}
		this.hasImpacted = true;
	}

	@Override
	public void setParticles() {
		world.spawnParticle(EnumParticleTypes.REDSTONE, this.posX, this.posY, this.posZ, 0.2, 0.5, 0.2,
				new int[] { 0 });
	}
}