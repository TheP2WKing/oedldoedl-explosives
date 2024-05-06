package net.thep2wking.oedldoedlexplosives.content.toomuchtnt.x5;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityDynamiteBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;
import net.thep2wking.oedldoedlexplosives.init.ModItems;

public class EntityDynamiteX5 extends ModEntityDynamiteBase {
	public EntityDynamiteX5(World world, double x, double y, double z) {
		super(world, x, y, z);
	}

	public EntityDynamiteX5(World world, EntityLivingBase thrower) {
		super(world, thrower);
	}

	public EntityDynamiteX5(World world) {
		super(world);
	}

	@Override
	public Item setParticleItem() {
		return ModItems.DYNAMITE_X5;
	}

	@Override
	public ModExplosionBase createDynamiteExplosion(double x, double y, double z) {
		return new ModExplosionBase(world, thrower, x, y, z, 4.0f, false, true, true, 64);
	}
}