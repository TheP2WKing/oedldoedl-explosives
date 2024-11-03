package net.thep2wking.oedldoedlexplosives.content.customtnt.combat;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityDynamiteBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;
import net.thep2wking.oedldoedlexplosives.init.ModItems;

public class EntityCombatDynamite extends ModEntityDynamiteBase {
	public EntityCombatDynamite(World world, double x, double y, double z) {
		super(world, x, y, z);
	}

	public EntityCombatDynamite(World world, EntityLivingBase thrower) {
		super(world, thrower);
	}

	public EntityCombatDynamite(World world) {
		super(world);
	}

	@Override
	public Item setParticleItem() {
		return ModItems.COMBAT_DYNAMITE;
	}

	@Override
	public ModExplosionBase createDynamiteExplosion(double x, double y, double z) {
		return new ModExplosionBase(world, thrower, x, y, z, 8.0f, false, false, false, 64);
	}
}