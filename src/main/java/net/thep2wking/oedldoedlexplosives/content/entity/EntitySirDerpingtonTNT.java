package net.thep2wking.oedldoedlexplosives.content.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;

public class EntitySirDerpingtonTNT extends ModEntityTNTBase {
	public EntitySirDerpingtonTNT(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
	}

	public EntitySirDerpingtonTNT(World world) {
		super(world);
	}

	@Override
	public void explode() {
		this.world.newExplosion(this, this.posX, this.posY + (double) (this.height / 16.0F), this.posZ, 0, false,
				false);
		for (int x = 0; x < 10; ++x) {
			EntityPig pig = new EntityPig(this.world);
			pig.setPosition(this.posX, this.posY, this.posZ);
			this.world.spawnEntity(pig);
		}
	}
}