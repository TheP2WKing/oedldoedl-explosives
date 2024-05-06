package net.thep2wking.oedldoedlexplosives.content.toomuchtnt.vaporize;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityDynamiteBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;
import net.thep2wking.oedldoedlexplosives.init.ModItems;

public class EntityVaporizeDynamite extends ModEntityDynamiteBase {
	public EntityVaporizeDynamite(World world, double x, double y, double z) {
		super(world, x, y, z);
	}

	public EntityVaporizeDynamite(World world, EntityLivingBase thrower) {
		super(world, thrower);
	}

	public EntityVaporizeDynamite(World world) {
		super(world);
	}

	@Override
	public Item setParticleItem() {
		return ModItems.VAPORIZE_DYNAMITE;
	}

	@Override
	public ModExplosionBase createDynamiteExplosion(double x, double y, double z) {
		return new ExplosionVaporizeTNT(world, thrower, x, y, z, 7.0f, false, true, false, 64);
	}
}