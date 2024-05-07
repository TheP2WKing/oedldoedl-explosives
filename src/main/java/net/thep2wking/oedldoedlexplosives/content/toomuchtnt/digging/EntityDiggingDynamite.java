package net.thep2wking.oedldoedlexplosives.content.toomuchtnt.digging;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityDynamiteBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;
import net.thep2wking.oedldoedlexplosives.init.ModItems;

public class EntityDiggingDynamite extends ModEntityDynamiteBase {
	public EntityDiggingDynamite(World world, double x, double y, double z) {
		super(world, x, y, z);
	}

	public EntityDiggingDynamite(World world, EntityLivingBase thrower) {
		super(world, thrower);
	}

	public EntityDiggingDynamite(World world) {
		super(world);
	}

	@Override
	public Item setParticleItem() {
		return ModItems.DIGGING_DYNAMITE;
	}

	@Override
	public ModExplosionBase createDynamiteExplosion(double x, double y, double z) {
		return new ExplosionDiggingTNT(world, thrower, x, y, z, 1.0f, false, true, false, 64);
	}
}