package net.thep2wking.oedldoedlexplosives.content.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;

public class EntityEggTNT extends ModEntityTNTBase {
	public EntityEggTNT(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
	}

	public EntityEggTNT(World world) {
		super(world);
	}

	@Override
	public void explode() {
		for (int i = (int) this.posX - 5; i < (int) this.posX + 5; ++i) {
			for (int j = (int) this.posZ - 5; j < (int) this.posZ + 5; ++j) {
				EntityItem item;
				EntityChicken chicken;
				if (this.world.getBlockState(new BlockPos((double) i, this.posY, (double) j))
						.getBlock() == Blocks.AIR) {
					if (this.rand.nextInt(5) == 3) {
						chicken = new EntityChicken(this.world);
						chicken.setPosition((double) i, this.posY + (double) 0.2f, (double) j);
						this.world.spawnEntity(chicken);
						continue;
					}
					item = new EntityItem(this.world, (double) i, this.posY + (double) 0.2f, (double) j,
							new ItemStack(Items.EGG, 1));
					this.world.spawnEntity(item);
					continue;
				}
				if (this.rand.nextInt(5) == 3) {
					chicken = new EntityChicken(this.world);
					chicken.setPosition(this.posX, this.posY, this.posZ);
					this.world.spawnEntity(chicken);
					continue;
				}
				item = new EntityItem(this.world, this.posX, this.posY, this.posZ, new ItemStack(Items.EGG, 1));
				this.world.spawnEntity(item);
			}
		}
		this.world.newExplosion(this, this.posX, this.posY + (double) (this.height / 16.0F), this.posZ, 0, false,
				false);
	}
}