package net.thep2wking.oedldoedlexplosives.content.entity;

import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;

public class EntityArrowTNT extends ModEntityTNTBase {
	public EntityArrowTNT(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
	}

	public EntityArrowTNT(World world) {
		super(world);
	}

	@Override
	public void explode() {
        Random random = new Random();
        for (int i = 0; i < 150; ++i) {
            EntityTippedArrow arrow = new EntityTippedArrow(this.world);
            arrow.setPosition(this.posX, this.posY, this.posZ);
            int LOLXD = random.nextInt(4);
            if (LOLXD == 0) {
                arrow.setVelocity((double)((float)(-random.nextInt(20)) / 10.0f), (double)((float)(random.nextInt(10) + 5) / 10.0f), (double)((float)(-random.nextInt(20)) / 10.0f));
            }
            if (LOLXD == 1) {
                arrow.setVelocity((double)((float)(-random.nextInt(20)) / 10.0f), (double)((float)(random.nextInt(10) + 5) / 10.0f), (double)((float)random.nextInt(20) / 10.0f));
            }
            if (LOLXD == 2) {
                arrow.setVelocity((double)((float)random.nextInt(20) / 10.0f), (double)((float)(random.nextInt(10) + 5) / 10.0f), (double)((float)(-random.nextInt(20)) / 10.0f));
            }
            if (LOLXD == 3) {
                arrow.setVelocity((double)((float)random.nextInt(20) / 10.0f), (double)((float)(random.nextInt(10) + 5) / 10.0f), (double)((float)random.nextInt(20) / 10.0f));
            }
            this.world.spawnEntity(arrow);
        }
		this.world.newExplosion(this, this.posX, this.posY + (double) (this.height / 16.0F), this.posZ, 0, false, false);
	}
}