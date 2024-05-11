package net.thep2wking.oedldoedlexplosives.content.toomuchtnt.drilling;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityDynamiteBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.ocean.ExplosionOceanTNT;
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
		return new ExplosionDrillingTNT(world, thrower, x, y, z, 4.0f, false, true, false, 128);
	}

	@Override
	public void handleExtraExplosionEffects(double x, double y, double z) {
		ModExplosionBase explosion2 = new ExplosionDrillingTNT(world, thrower, x, y - 15, z, 2.0f, false, true, false,
				64);
		ModExplosionBase explosion3 = new ExplosionDrillingTNT(world, thrower, x, y - 25, z, 2.0f, false, true, false,
				64);
		ModExplosionBase explosion4 = new ExplosionOceanTNT(world, thrower, x, y - 50, z, 2.0f, true, true, false, 64);
		ModExplosionBase explosion5 = new ExplosionOceanTNT(world, thrower, x, 5, z, 2.0f, true, true, false, 64);
		this.handleExplosionLogic(explosion2);
		this.handleExplosionLogic(explosion3);
		this.handleExplosionLogic(explosion4);
		this.handleExplosionLogic(explosion5);
	}
}