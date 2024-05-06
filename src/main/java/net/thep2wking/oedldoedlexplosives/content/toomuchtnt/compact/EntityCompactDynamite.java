package net.thep2wking.oedldoedlexplosives.content.toomuchtnt.compact;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityDynamiteBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;
import net.thep2wking.oedldoedlexplosives.init.ModItems;

public class EntityCompactDynamite extends ModEntityDynamiteBase {
	public EntityCompactDynamite(World world, double x, double y, double z) {
		super(world, x, y, z);
	}

	public EntityCompactDynamite(World world, EntityLivingBase thrower) {
		super(world, thrower);
	}

	public EntityCompactDynamite(World world) {
		super(world);
	}

	@Override
	public Item setParticleItem() {
		return ModItems.COMPACT_DYNAMITE;
	}

	@Override
	public ModExplosionBase createDynamiteExplosion(double x, double y, double z) {
		return new ExplosionCompactTNT(world, thrower, x, y, z, 3.0f, true, true, false, 64);
	}
}