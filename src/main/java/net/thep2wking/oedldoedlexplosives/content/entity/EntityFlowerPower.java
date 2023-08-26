package net.thep2wking.oedldoedlexplosives.content.entity;

import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;
import net.thep2wking.oedldoedlexplosives.config.ExplosivesConfig;

public class EntityFlowerPower extends ModEntityTNTBase {
	public EntityFlowerPower(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
	}

	public EntityFlowerPower(World world) {
		super(world);
	}

	@Override
	public void explode() {
		this.world.newExplosion(this, this.posX, this.posY + (double) (this.height / 16.0F), this.posZ, 0, false,
				false);
		Random random = new Random();

		int radius = 8;
		if (ExplosivesConfig.PROPERTIES.NON_STANDARD_EXPLOSION_DAMAGE) {
			for (int r = radius, x5 = -r; x5 < r; ++x5) {
				for (int y5 = r; y5 > -r; --y5) {
					for (int z6 = -r; z6 < r; ++z6) {
						if (this.world
								.getBlockState(new BlockPos((int) this.posX + x5, (int) this.posY + y5 - 1,
										(int) this.posZ + z6)) == Blocks.GRASS.getDefaultState()
								&& this.world.getBlockState(new BlockPos((int) this.posX + x5, (int) this.posY + y5,
										(int) this.posZ + z6)) == Blocks.AIR.getDefaultState()
								|| this.world
										.getBlockState(new BlockPos((int) this.posX + x5, (int) this.posY + y5 - 1,
												(int) this.posZ + z6)) == Blocks.DIRT.getDefaultState()
										&& this.world
												.getBlockState(new BlockPos((int) this.posX + x5, (int) this.posY + y5,
														(int) this.posZ + z6)) == Blocks.AIR.getDefaultState()) {
							if (6 <= random.nextInt(8)) {
								this.world.setBlockState(
										new BlockPos((int) this.posX + x5, (int) this.posY + y5, (int) this.posZ + z6),
										Blocks.RED_FLOWER.getStateFromMeta(random.nextInt(8)));

								if (7 == random.nextInt(8)) {
									this.world.setBlockState(
											new BlockPos((int) this.posX + x5, (int) this.posY + y5,
													(int) this.posZ + z6),
											Blocks.YELLOW_FLOWER.getStateFromMeta(0));
								}
							}

						}
					}
				}
			}
		}
	}
}