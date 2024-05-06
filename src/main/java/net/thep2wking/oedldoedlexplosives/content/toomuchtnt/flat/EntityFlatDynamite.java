package net.thep2wking.oedldoedlexplosives.content.toomuchtnt.flat;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityDynamiteBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;
import net.thep2wking.oedldoedlexplosives.init.ModItems;

public class EntityFlatDynamite extends ModEntityDynamiteBase {
	public EntityFlatDynamite(World world, double x, double y, double z) {
		super(world, x, y, z);
	}

	public EntityFlatDynamite(World world, EntityLivingBase thrower) {
		super(world, thrower);
	}

	public EntityFlatDynamite(World world) {
		super(world);
	}

	@Override
	public Item setParticleItem() {
		return ModItems.COMPACT_DYNAMITE;
	}

	@Override
	public ModExplosionBase createDynamiteExplosion(double x, double y, double z) {
		return new ExplosionFlatTNT(world, thrower, x, y, z, 10.0f, false, true, true, 128);
	}
}