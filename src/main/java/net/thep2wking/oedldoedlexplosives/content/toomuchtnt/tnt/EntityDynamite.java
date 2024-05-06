package net.thep2wking.oedldoedlexplosives.content.toomuchtnt.tnt;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityDynamiteBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;
import net.thep2wking.oedldoedlexplosives.init.ModItems;

public class EntityDynamite extends ModEntityDynamiteBase {
	public EntityDynamite(World world, double x, double y, double z) {
		super(world, x, y, z);
	}

	public EntityDynamite(World world, EntityLivingBase thrower) {
		super(world, thrower);
	}

	public EntityDynamite(World world) {
		super(world);
	}

	@Override
	public Item setParticleItem() {
		return ModItems.DYNAMITE;
	}

	@Override
	public ModExplosionBase createDynamiteExplosion(double x, double y, double z) {
		return new ModExplosionBase(world, thrower, x, y, z, 2.0f, false, true, true, 16);
	}
}