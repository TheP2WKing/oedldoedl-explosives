package net.thep2wking.oedldoedlexplosives.content.toomuchtnt.multiply;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityDynamiteBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;
import net.thep2wking.oedldoedlexplosives.init.ModItems;

public class EntityMultiplyDynamite extends ModEntityDynamiteBase {
	public EntityMultiplyDynamite(World world, double x, double y, double z) {
		super(world, x, y, z);
	}

	public EntityMultiplyDynamite(World world, EntityLivingBase thrower) {
		super(world, thrower);
	}

	public EntityMultiplyDynamite(World world) {
		super(world);
	}

	@Override
	public Item setParticleItem() {
		return ModItems.CUBIC_DYNAMITE;
	}

	@Override
	public ModExplosionBase createDynamiteExplosion(double x, double y, double z) {
		return new ExplosionMultiplyTNT(world, thrower, x, y, z, 2.0f, false, true, true, 16);
	}
}