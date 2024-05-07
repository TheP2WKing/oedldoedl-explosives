package net.thep2wking.oedldoedlexplosives.content.toomuchtnt.drilling;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityDynamiteBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;
import net.thep2wking.oedldoedlexplosives.init.ModItems;

public class EntityDrillingDynamite extends ModEntityDynamiteBase {
	public EntityDrillingDynamite(World world, double x, double y, double z) {
		super(world, x, y, z);
	}

	public EntityDrillingDynamite(World world, EntityLivingBase thrower) {
		super(world, thrower);
	}

	public EntityDrillingDynamite(World world) {
		super(world);
	}

	@Override
	public Item setParticleItem() {
		return ModItems.DRILLING_DYNAMITE;
	}

	@Override
	public ModExplosionBase createDynamiteExplosion(double x, double y, double z) {
		return new ExplosionDrillingTNT(world, thrower, x, y, z, 1.0f, false, true, false, 64);
	}
}