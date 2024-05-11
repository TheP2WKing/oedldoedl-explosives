package net.thep2wking.oedldoedlexplosives.content.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;
import net.thep2wking.oedldoedlexplosives.content.entity.living.EntityGiantTheP2WKing;

public class EntityTheP2WKingTNT extends ModEntityTNTBase {
	public EntityTheP2WKingTNT(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
	}

	public EntityTheP2WKingTNT(World world) {
		super(world);
	}

	@Override
	public void explode() {
		this.world.newExplosion(this, this.posX, this.posY + (double) (this.height / 16.0F), this.posZ, 0, false,
				false);
		spawnTheP2WKing(this.world, this.posX, this.posY, this.posZ);
		// spawnTheP2WKing(this.world, this.posX, this.posY, this.posZ);
		// spawnTheP2WKing(this.world, this.posX, this.posY, this.posZ);
		// spawnTheP2WKing(this.world, this.posX, this.posY, this.posZ);
	}

	public static void spawnTheP2WKing(World world, double posX, double posY, double posZ) {
		if (!world.isRemote) {
			EntityGiantTheP2WKing entity = new EntityGiantTheP2WKing(world);
			entity.setLocationAndAngles(posX, posY, posZ, 0.0f, 0.0f);
			world.spawnEntity((Entity) entity);
		}
	}
}