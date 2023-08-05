package net.thep2wking.oedldoedlexplosives.content.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;

public class EntityDrillTNT extends ModEntityTNTBase {
	public EntityDrillTNT(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
	}

	public EntityDrillTNT(World world) {
		super(world);
	}

	@Override
	public void explode() {
		for (int y = this.getPosition().getY(); y > 0; y -= 4) {
			this.world.newExplosion(this, this.getPosition().getX(), y, this.getPosition().getZ(), 20.0f, false, true);
		}
	}
}