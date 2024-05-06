package net.thep2wking.oedldoedlexplosives.content.toomuchtnt.animal;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityDynamiteBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;
import net.thep2wking.oedldoedlexplosives.init.ModItems;

public class EntityAnimalDynamite extends ModEntityDynamiteBase {
	public EntityAnimalDynamite(World world, double x, double y, double z) {
		super(world, x, y, z);
	}

	public EntityAnimalDynamite(World world, EntityLivingBase thrower) {
		super(world, thrower);
	}

	public EntityAnimalDynamite(World world) {
		super(world);
	}

	@Override
	public Item setParticleItem() {
		return ModItems.ANIMAL_DYNAMITE;
	}

	@Override
	public ModExplosionBase createDynamiteExplosion(double x, double y, double z) {
		return new ExplosionAnimalTNT(world, thrower, x, y, z, 4.0f, false, false, false, 64);
	}
}