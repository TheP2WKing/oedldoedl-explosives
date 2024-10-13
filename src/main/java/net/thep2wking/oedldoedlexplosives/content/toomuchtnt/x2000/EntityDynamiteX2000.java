package net.thep2wking.oedldoedlexplosives.content.toomuchtnt.x2000;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityDynamiteBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;
import net.thep2wking.oedldoedlexplosives.init.ModItems;

public class EntityDynamiteX2000 extends ModEntityDynamiteBase {
	public EntityDynamiteX2000(World world, double x, double y, double z) {
		super(world, x, y, z);
	}

	public EntityDynamiteX2000(World world, EntityLivingBase thrower) {
		super(world, thrower);
	}

	public EntityDynamiteX2000(World world) {
		super(world);
	}

	@Override
	public Item setParticleItem() {
		return ModItems.DYNAMITE_X2000;
	}

	@Override
	public ModExplosionBase createDynamiteExplosion(double x, double y, double z) {
		return new ModExplosionBase(world, thrower, x, y, z, 70.0f, false, true, true, 192);
	}

	@Override
	public void setParticles() {
		world.spawnParticle(EnumParticleTypes.REDSTONE, this.posX, this.posY, this.posZ, 0.35, 0.885, 0.0, new int[]{0});
	}
}