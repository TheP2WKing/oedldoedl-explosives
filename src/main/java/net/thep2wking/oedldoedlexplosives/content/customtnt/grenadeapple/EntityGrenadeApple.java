package net.thep2wking.oedldoedlexplosives.content.customtnt.grenadeapple;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityDynamiteBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;
import net.thep2wking.oedldoedlexplosives.init.ModItems;

public class EntityGrenadeApple extends ModEntityDynamiteBase {
	public EntityGrenadeApple(World world, double x, double y, double z) {
		super(world, x, y, z);
	}

	public EntityGrenadeApple(World world, EntityLivingBase thrower) {
		super(world, thrower);
	}

	public EntityGrenadeApple(World world) {
		super(world);
	}

	@Override
	public Item setParticleItem() {
		return ModItems.GRENADE_APPLE;
	}

	@Override
	public ModExplosionBase createDynamiteExplosion(double x, double y, double z) {
		return new ModExplosionBase(world, thrower, x, y, z, 2.0f, false, true, true, 16);
	}
}