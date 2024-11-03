package net.thep2wking.oedldoedlexplosives.content.customtnt.thep2wking;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityDynamiteBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;
import net.thep2wking.oedldoedlexplosives.init.ModItems;

public class EntityTheP2WKingDynamite extends ModEntityDynamiteBase {
	public EntityTheP2WKingDynamite(World world, double x, double y, double z) {
		super(world, x, y, z);
	}

	public EntityTheP2WKingDynamite(World world, EntityLivingBase thrower) {
		super(world, thrower);
	}

	public EntityTheP2WKingDynamite(World world) {
		super(world);
	}

	@Override
	public Item setParticleItem() {
		return ModItems.THEP2WKING_DYNAMITE;
	}

	@Override
	public ModExplosionBase createDynamiteExplosion(double x, double y, double z) {
		return new ExplosionTheP2WKingTNT(world, thrower, x, y, z, 0.0f, false, false, false, 0);
	}
}