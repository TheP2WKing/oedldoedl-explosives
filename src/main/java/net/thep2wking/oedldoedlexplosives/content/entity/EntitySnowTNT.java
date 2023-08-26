package net.thep2wking.oedldoedlexplosives.content.entity;

import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockFire;
import net.minecraft.block.BlockFlower;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;
import net.thep2wking.oedldoedlexplosives.config.ExplosivesConfig;

public class EntitySnowTNT extends ModEntityTNTBase {
	public EntitySnowTNT(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
	}

	public EntitySnowTNT(World world) {
		super(world);
	}

	@Override
	public void explode() {
		this.world.newExplosion(this, this.posX, this.posY + (double) (this.height / 16.0F), this.posZ, 0, false,
				false);

		if (ExplosivesConfig.PROPERTIES.NON_STANDARD_EXPLOSION_DAMAGE) {
			int radius = 16;
			for (int r = radius, x5 = -r; x5 < r; ++x5) {
				for (int y5 = r; y5 > -r; --y5) {
					for (int z6 = -r; z6 < r; ++z6) {
						if (this.world
								.getBlockState(new BlockPos((int) this.posX + x5, (int) this.posY + y5 - 1,
										(int) this.posZ + z6)) != Blocks.AIR.getDefaultState()
								&& this.world.getBlockState(new BlockPos((int) this.posX + x5, (int) this.posY + y5 - 1,
										(int) this.posZ + z6)) != Blocks.SNOW_LAYER.getDefaultState()
								&& this.world.getBlockState(new BlockPos((int) this.posX + x5, (int) this.posY + y5,
										(int) this.posZ + z6)) == Blocks.AIR.getDefaultState()
								&& !this.world
										.getBlockState(new BlockPos((int) this.posX + x5, (int) this.posY + y5 - 1,
												(int) this.posZ + z6))
										.getBlock().isReplaceable(world,
												new BlockPos((int) this.posX + x5, (int) this.posY + y5 - 1,
														(int) this.posZ + z6))
								&& !(this.world.getBlockState(
										new BlockPos((int) this.posX + x5, (int) this.posY + y5 - 1,
												(int) this.posZ + z6))
										.getBlock() instanceof BlockFlower)
								&& !(this.world.getBlockState(
										new BlockPos((int) this.posX + x5, (int) this.posY + y5 - 1,
												(int) this.posZ + z6))
										.getBlock() instanceof BlockDoublePlant)) {
							this.world.setBlockState(
									new BlockPos((int) this.posX + x5, (int) this.posY + y5, (int) this.posZ + z6),
									Blocks.SNOW_LAYER.getDefaultState());
						}
					}
				}
			}

			for (int r = radius, x4 = -r; x4 < r; ++x4) {
				for (int y4 = -r; y4 < r; ++y4) {
					for (int z4 = -r; z4 < r; ++z4) {
						if (this.world
								.getBlockState(new BlockPos((int) this.posX + x4, (int) this.posY + y4,
										(int) this.posZ + z4)) == Blocks.WATER.getDefaultState()
								|| this.world.getBlockState(new BlockPos((int) this.posX + x4, (int) this.posY + y4,
										(int) this.posZ + z4)) == Blocks.FLOWING_WATER.getDefaultState()) {
							this.world.setBlockState(
									new BlockPos((int) this.posX + x4, (int) this.posY + y4, (int) this.posZ + z4),
									Blocks.ICE.getDefaultState());
						}
					}
				}
			}

			for (int r = radius, x4 = -r; x4 < r; ++x4) {
				for (int y4 = -r; y4 < r; ++y4) {
					for (int z4 = -r; z4 < r; ++z4) {
						if (this.world
								.getBlockState(new BlockPos((int) this.posX + x4, (int) this.posY + y4,
										(int) this.posZ + z4)) == Blocks.LAVA.getDefaultState()
								|| this.world.getBlockState(new BlockPos((int) this.posX + x4, (int) this.posY + y4,
										(int) this.posZ + z4)) == Blocks.FLOWING_LAVA.getDefaultState()) {
							this.world.setBlockState(
									new BlockPos((int) this.posX + x4, (int) this.posY + y4, (int) this.posZ + z4),
									Blocks.OBSIDIAN.getDefaultState());
						}
					}
				}
			}

			for (int r = radius, x5 = -r; x5 < r; ++x5) {
				for (int y5 = r; y5 > -r; --y5) {
					for (int z6 = -r; z6 < r; ++z6) {
						if (this.world
								.getBlockState(new BlockPos((int) this.posX + x5, (int) this.posY + y5 - 1,
										(int) this.posZ + z6)) != Blocks.AIR.getDefaultState()
								&& this.world.getBlockState(new BlockPos((int) this.posX + x5, (int) this.posY + y5 - 1,
										(int) this.posZ + z6)) != Blocks.SNOW_LAYER.getDefaultState()
								&& this.world.getBlockState(
										new BlockPos((int) this.posX + x5, (int) this.posY + y5, (int) this.posZ + z6))
										.getBlock() instanceof BlockFire) {
							this.world.setBlockState(
									new BlockPos((int) this.posX + x5, (int) this.posY + y5, (int) this.posZ + z6),
									Blocks.SNOW_LAYER.getDefaultState());
						}
					}
				}
			}
		}
	}
}