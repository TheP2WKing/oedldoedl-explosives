package net.thep2wking.oedldoedlexplosives.content.customtnt.eggsplosive;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityDynamiteBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;
import net.thep2wking.oedldoedlexplosives.init.ModItems;

public class EntityEggsplosive extends ModEntityDynamiteBase {
	public EntityEggsplosive(World world, double x, double y, double z) {
		super(world, x, y, z);
	}

	public EntityEggsplosive(World world, EntityLivingBase thrower) {
		super(world, thrower);
	}

	public EntityEggsplosive(World world) {
		super(world);
	}

	@Override
	public Item setParticleItem() {
		return ModItems.EGGSPLOSIVE;
	}

	@Override
	public ModExplosionBase createDynamiteExplosion(double x, double y, double z) {
		return new ModExplosionBase(world, thrower, x, y, z, 2.0f, false, true, true, 16);
	}

	@Override
	public void handleExtraExplosionEffects(double x, double y, double z) {
		if (!world.isRemote) {
			if (this.rand.nextInt(8) == 0) {
				int i = 1;
				if (this.rand.nextInt(32) == 0) {
					i = 4;
				}
				for (int j = 0; j < i; ++j) {
					EntityChicken entitychicken = new EntityChicken(this.world);
					entitychicken.setGrowingAge(-24000);
					entitychicken.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
					this.world.spawnEntity(entitychicken);
				}
			}
		}
	}
}