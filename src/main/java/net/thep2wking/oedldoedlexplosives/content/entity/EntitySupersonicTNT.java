package net.thep2wking.oedldoedlexplosives.content.entity;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;
import net.thep2wking.oedldoedlexplosives.config.ExplosivesConfig;

public class EntitySupersonicTNT extends ModEntityTNTBase {
	public EntitySupersonicTNT(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
	}

	public EntitySupersonicTNT(World world) {
		super(world);
	}

	@Override
	public void explode() {
		this.world.newExplosion(this, this.posX, this.posY + (double) (this.height / 16.0F), this.posZ, 0, false,
				false);

		if (ExplosivesConfig.PROPERTIES.NON_STANDARD_EXPLOSION_DAMAGE) {
			int r = 6;
			r += 3;
			for (int y = r; y > -r; --y) {
				for (int x = -r; x < r; ++x) {
					for (int z = -r; z < r; ++z) {
						if (Math.pow(x, 2.0) + Math.pow(y, 2.0) < Math.pow(r, 2.0)
								&& this.world.getBlockState(new BlockPos((int) this.posX + x, (int) this.posY + y,
										(int) this.posZ + z)) != Blocks.BEDROCK
								&& this.world.getBlockState(new BlockPos((int) this.posX + x, (int) this.posY + y,
										(int) this.posZ + z)) != Blocks.AIR
								&& this.fuse % 2 == 0) {
							final int rangeMin = -5;
							final int rangeMax = 5;
							final Random rnd = new Random();
							final EntityFallingBlock fallingblock = new EntityFallingBlock(this.world,
									(double) ((int) this.posX + x), (double) ((int) this.posY + y),
									(double) ((int) this.posZ + z),
									this.world.getBlockState(
											new BlockPos((int) this.posX + x, (int) this.posY + y,
													(int) this.posZ + z)));
							fallingblock.setVelocity(rangeMin + (rangeMax - rangeMin) * rnd.nextDouble(), 5.0,
									rangeMin + (rangeMax - rangeMin) * rnd.nextDouble());
							fallingblock.fallTime = 1;
							world.spawnEntity((Entity) fallingblock);
							this.world.setBlockState(
									new BlockPos((int) this.posX + x, (int) this.posY + y, (int) this.posZ + z),
									Blocks.AIR.getDefaultState());
						}
					}
				}
			}
		}
	}
}