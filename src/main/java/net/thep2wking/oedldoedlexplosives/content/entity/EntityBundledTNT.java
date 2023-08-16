package net.thep2wking.oedldoedlexplosives.content.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;

public class EntityBundledTNT extends ModEntityTNTBase {
	public EntityBundledTNT(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
	}

	public EntityBundledTNT(World world) {
		super(world);
	}

	@Override
	public void explode() {
		this.world.newExplosion(this, this.posX, this.posY + (double) (this.height / 16.0F), this.posZ, 0, false,
				false);

		EntityTNTPrimed entitytntprimed2 = new EntityTNTPrimed(this.world, (double) ((float) this.posX + 0.1f),
				(double) ((float) this.posY + 0.1f), (double) ((float) this.posZ + 0.1f), this.ignitor);
		entitytntprimed2.addVelocity(0.3, 0.1, 0.0);
		this.world.spawnEntity((Entity) entitytntprimed2);
		entitytntprimed2 = new EntityTNTPrimed(this.world, (double) ((float) this.posX + 0.1f),
				(double) ((float) this.posY + 0.1f), (double) ((float) this.posZ + 0.1f), this.ignitor);
		entitytntprimed2.addVelocity(-0.3, 0.1, 0.0);
		this.world.spawnEntity((Entity) entitytntprimed2);
		entitytntprimed2 = new EntityTNTPrimed(this.world, (double) ((float) this.posX + 0.1f),
				(double) ((float) this.posY + 0.1f), (double) ((float) this.posZ + 0.1f), this.ignitor);
		entitytntprimed2.addVelocity(0.0, 0.1, 0.3);
		this.world.spawnEntity((Entity) entitytntprimed2);
		entitytntprimed2 = new EntityTNTPrimed(this.world, (double) ((float) this.posX + 0.1f),
				(double) ((float) this.posY + 0.1f), (double) ((float) this.posZ + 0.1f), this.ignitor);
		entitytntprimed2.addVelocity(0.0, 0.1, -0.3);
		this.world.spawnEntity((Entity) entitytntprimed2);
		entitytntprimed2 = new EntityTNTPrimed(this.world, (double) ((float) this.posX + 0.1f),
				(double) ((float) this.posY + 0.1f), (double) ((float) this.posZ + 0.1f), this.ignitor);
		entitytntprimed2.addVelocity(0.3, 0.1, 0.3);
		this.world.spawnEntity((Entity) entitytntprimed2);
		entitytntprimed2 = new EntityTNTPrimed(this.world, (double) ((float) this.posX + 0.1f),
				(double) ((float) this.posY + 0.1f), (double) ((float) this.posZ + 0.1f), this.ignitor);
		entitytntprimed2.addVelocity(-0.3, 0.1, 0.3);
		this.world.spawnEntity((Entity) entitytntprimed2);
		entitytntprimed2 = new EntityTNTPrimed(this.world, (double) ((float) this.posX + 0.1f),
				(double) ((float) this.posY + 0.1f), (double) ((float) this.posZ + 0.1f), this.ignitor);
		entitytntprimed2.addVelocity(0.3, 0.1, -0.3);
		this.world.spawnEntity((Entity) entitytntprimed2);
		entitytntprimed2 = new EntityTNTPrimed(this.world, (double) ((float) this.posX + 0.1f),
				(double) ((float) this.posY + 0.1f), (double) ((float) this.posZ + 0.1f), this.ignitor);
		entitytntprimed2.addVelocity(-0.3, 0.1, -0.3);
		this.world.spawnEntity((Entity) entitytntprimed2);
		entitytntprimed2 = new EntityTNTPrimed(this.world, (double) ((float) this.posX + 0.1f),
				(double) ((float) this.posY + 0.1f), (double) ((float) this.posZ + 0.1f), this.ignitor);
		entitytntprimed2.addVelocity(0.0, 0.1, 0.0);
		this.world.spawnEntity((Entity) entitytntprimed2);
	}
}