package net.thep2wking.oedldoedlexplosives.content.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;

public class EntityTNTRain extends ModEntityTNTBase {
	public EntityTNTRain(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
	}

	public EntityTNTRain(World world) {
		super(world);
	}

	@Override
	public void explode() {
		this.world.newExplosion(this, this.posX, this.posY + (double) (this.height / 16.0F), this.posZ, 0, false,
				false);
		for (int x4 = 0; x4 < 100; x4 += 5) {
			for (int z5 = 0; z5 < 100; z5 += 5) {
				EntityTNTPrimed entitytntprimed = new EntityTNTPrimed(this.world, (float) this.posX + 0.5f + x4 - 50.0,
						(double) ((float) this.posY + 12.5f), (float) this.posZ + 0.5f + z5 - 50.0, this.ignitor);
				this.world.spawnEntity(entitytntprimed);
				entitytntprimed = new EntityTNTPrimed(this.world, (float) this.posX + 0.5f + x4 - 50.0,
						(double) ((float) this.posY + 17.5f), (float) this.posZ + 0.5f + z5 - 50.0, this.ignitor);
				this.world.spawnEntity(entitytntprimed);
				entitytntprimed = new EntityTNTPrimed(this.world, (float) this.posX + 0.5f + x4 - 50.0,
						(double) ((float) this.posY + 22.5f), (float) this.posZ + 0.5f + z5 - 50.0, this.ignitor);
				this.world.spawnEntity(entitytntprimed);
			}
		}
	}
}