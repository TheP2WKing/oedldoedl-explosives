package net.thep2wking.oedldoedlexplosives.content.toomuchtnt.easteregg;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityDynamiteBase;
import net.thep2wking.oedldoedlexplosives.api.ModEntityImpactTNTBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;
import net.thep2wking.oedldoedlexplosives.init.ModItems;

public class EntityEasterEggDynamite extends ModEntityDynamiteBase {
	public EntityEasterEggDynamite(World world, double x, double y, double z) {
		super(world, x, y, z);
	}

	public EntityEasterEggDynamite(World world, EntityLivingBase thrower) {
		super(world, thrower);
	}

	public EntityEasterEggDynamite(World world) {
		super(world);
	}

	@Override
	public Item setParticleItem() {
		return ModItems.EASTER_EGG_DYNAMITE;
	}

	@Override
	public ModExplosionBase createDynamiteExplosion(double x, double y, double z) {
		return new ExplosionEasterEgg(world, thrower, x, y, z, 6.0f, true, true, false, 32);
	}

	@Override
	public ModEntityImpactTNTBase createImpactTNTEntity(double x, double y, double z) {
		return new EntityEasterEggImpact(world, x, y, z, thrower, 6.0f, true, true, false, 32);
	}

	@Override
	public void handleExtraExplosionEffects(double x, double y, double z) {
		spawnImpactTNTX5(1.25f, 2.0f, 1.25f);
		spawnImpactTNTX4(2.25f, 2.25f, 2.25f);
	}
}