package net.thep2wking.oedldoedlexplosives.content.toomuchtnt.miningflat;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityDynamiteBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;
import net.thep2wking.oedldoedlexplosives.init.ModItems;

public class EntityMiningFlatDynamite extends ModEntityDynamiteBase {
	public EntityMiningFlatDynamite(World world, double x, double y, double z) {
		super(world, x, y, z);
	}

	public EntityMiningFlatDynamite(World world, EntityLivingBase thrower) {
		super(world, thrower);
	}

	public EntityMiningFlatDynamite(World world) {
		super(world);
	}

	@Override
	public Item setParticleItem() {
		return ModItems.COMPACT_DYNAMITE;
	}

	@Override
	public ModExplosionBase createDynamiteExplosion(double x, double y, double z) {
		return new ExplosionMiningFlatTNT(world, thrower, x, y, z, 10.0f, true, true, true, 128);
	}
}