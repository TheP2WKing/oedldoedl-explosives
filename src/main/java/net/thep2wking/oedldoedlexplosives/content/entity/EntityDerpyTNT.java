package net.thep2wking.oedldoedlexplosives.content.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;

public class EntityDerpyTNT extends ModEntityTNTBase {
	public EntityDerpyTNT(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
	}

	public EntityDerpyTNT(World world) {
		super(world);
	}

	@Override
	public void explode() {
		final int min = -10;
		final int max = 10;
		final int xpos = min + (int) (Math.random() * (max - min + 1));
		final int ypos = min + (int) (Math.random() * (max - min + 1));
		final int zpos = min + (int) (Math.random() * (max - min + 1));
		this.world.newExplosion(this, this.posX + xpos, this.posY + (double) (this.height / 16.0F) + ypos,
				this.posZ + zpos, 4.0f, false, true);
	}
}