package net.thep2wking.oedldoedlexplosives.content.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundCategory;
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
		this.world.playSound((EntityPlayer) null, this.posX, this.posY, this.posZ, SoundEvents.ENTITY_GENERIC_EXPLODE,
				SoundCategory.BLOCKS, 4.0F,
				(1.0F + (this.world.rand.nextFloat() - this.world.rand.nextFloat()) * 0.2F) * 0.7F);
		for (int x = 0; x< 10; ++x) {
			EntityPig pig = new EntityPig(this.world);
			pig.setPosition(this.posX, this.posY, this.posZ);
			this.world.spawnEntity(pig);
		}
	}
}