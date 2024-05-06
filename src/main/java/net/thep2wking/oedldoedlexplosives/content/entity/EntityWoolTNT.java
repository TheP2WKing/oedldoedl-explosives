package net.thep2wking.oedldoedlexplosives.content.entity;

import net.minecraft.block.material.MapColor;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;
import net.thep2wking.oedldoedlexplosives.config.ExplosivesConfig;

public class EntityWoolTNT extends ModEntityTNTBase {
	public EntityWoolTNT(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
	}

	public EntityWoolTNT(World world) {
		super(world);
	}

	@SuppressWarnings("deprecation")
	public static boolean checkMapColor(World world, BlockPos blockPos, MapColor mapcolor) {
		return world.getBlockState(blockPos).isFullBlock() && !world.getBlockState(blockPos).getBlock().hasTileEntity()
				&& world.getBlockState(blockPos).getBlock().getHarvestLevel(world.getBlockState(blockPos)) != -1
				&& world.getBlockState(blockPos).getBlock().getMapColor(world.getBlockState(blockPos), world,
						blockPos) == mapcolor
				&& world.getBlockState(blockPos).getBlock().getMapColor(world.getBlockState(blockPos), world,
						blockPos) != MapColor.AIR
				&& world.getBlockState(blockPos).getBlock().getMapColor(world.getBlockState(blockPos), world,
						blockPos) != MapColor.CLOTH;
	}

	@SuppressWarnings("deprecation")
	public static void setWoolBlock(World world, BlockPos blockPos, int meta) {
		world.setBlockState(blockPos, Blocks.WOOL.getStateFromMeta(meta));
	}

	@Override
	@SuppressWarnings("all")
	public void explode() {
		this.world.newExplosion(this, this.posX, this.posY + (double) (this.height / 16.0F), this.posZ, 0, false,
				false);

		if (ExplosivesConfig.PROPERTIES.NON_STANDARD_EXPLOSION_DAMAGE) {
			for (int r = 32, x4 = -r; x4 < r; ++x4) {
				for (int y4 = -r; y4 < r; ++y4) {
					for (int z4 = -r; z4 < r; ++z4) {
						BlockPos position = new BlockPos((int) this.posX + x4, (int) this.posY + y4,
								(int) this.posZ + z4);

						if (checkMapColor(world, position, MapColor.ADOBE)) {
							setWoolBlock(world, position, 1);
						} else if (checkMapColor(world, position, MapColor.BLACK)) {
							setWoolBlock(world, position, 15);
						} else if (checkMapColor(world, position, MapColor.BLACK_STAINED_HARDENED_CLAY)) {
							setWoolBlock(world, position, 15);
						} else if (checkMapColor(world, position, MapColor.BLUE)) {
							setWoolBlock(world, position, 11);
						} else if (checkMapColor(world, position, MapColor.BLUE_STAINED_HARDENED_CLAY)) {
							setWoolBlock(world, position, 11);
						} else if (checkMapColor(world, position, MapColor.BROWN)) {
							setWoolBlock(world, position, 12);
						} else if (checkMapColor(world, position, MapColor.BROWN_STAINED_HARDENED_CLAY)) {
							setWoolBlock(world, position, 12);
						} else if (checkMapColor(world, position, MapColor.CLAY)) {
							setWoolBlock(world, position, 8);
						} else if (checkMapColor(world, position, MapColor.CYAN)) {
							setWoolBlock(world, position, 9);
						} else if (checkMapColor(world, position, MapColor.CYAN_STAINED_HARDENED_CLAY)) {
							setWoolBlock(world, position, 9);
						} else if (checkMapColor(world, position, MapColor.DIAMOND)) {
							setWoolBlock(world, position, 3);
						} else if (checkMapColor(world, position, MapColor.DIRT)) {
							setWoolBlock(world, position, 12);
						} else if (checkMapColor(world, position, MapColor.EMERALD)) {
							setWoolBlock(world, position, 5);
						} else if (checkMapColor(world, position, MapColor.FOLIAGE)) {
							setWoolBlock(world, position, 13);
						} else if (checkMapColor(world, position, MapColor.GOLD)) {
							setWoolBlock(world, position, 4);
						} else if (checkMapColor(world, position, MapColor.GRASS)) {
							setWoolBlock(world, position, 5);
						} else if (checkMapColor(world, position, MapColor.GRAY)) {
							setWoolBlock(world, position, 7);
						} else if (checkMapColor(world, position, MapColor.GRAY_STAINED_HARDENED_CLAY)) {
							setWoolBlock(world, position, 7);
						} else if (checkMapColor(world, position, MapColor.GREEN)) {
							setWoolBlock(world, position, 13);
						} else if (checkMapColor(world, position, MapColor.GREEN_STAINED_HARDENED_CLAY)) {
							setWoolBlock(world, position, 13);
						} else if (checkMapColor(world, position, MapColor.ICE)) {
							setWoolBlock(world, position, 3);
						} else if (checkMapColor(world, position, MapColor.IRON)) {
							setWoolBlock(world, position, 8);
						} else if (checkMapColor(world, position, MapColor.LAPIS)) {
							setWoolBlock(world, position, 11);
						} else if (checkMapColor(world, position, MapColor.LIGHT_BLUE)) {
							setWoolBlock(world, position, 3);
						} else if (checkMapColor(world, position, MapColor.LIGHT_BLUE_STAINED_HARDENED_CLAY)) {
							setWoolBlock(world, position, 3);
						} else if (checkMapColor(world, position, MapColor.LIME)) {
							setWoolBlock(world, position, 5);
						} else if (checkMapColor(world, position, MapColor.LIME_STAINED_HARDENED_CLAY)) {
							setWoolBlock(world, position, 5);
						} else if (checkMapColor(world, position, MapColor.MAGENTA)) {
							setWoolBlock(world, position, 2);
						} else if (checkMapColor(world, position, MapColor.MAGENTA_STAINED_HARDENED_CLAY)) {
							setWoolBlock(world, position, 2);
						} else if (checkMapColor(world, position, MapColor.NETHERRACK)) {
							setWoolBlock(world, position, 14);
						} else if (checkMapColor(world, position, MapColor.OBSIDIAN)) {
							setWoolBlock(world, position, 15);
						} else if (checkMapColor(world, position, MapColor.ORANGE_STAINED_HARDENED_CLAY)) {
							setWoolBlock(world, position, 1);
						} else if (checkMapColor(world, position, MapColor.PINK)) {
							setWoolBlock(world, position, 6);
						} else if (checkMapColor(world, position, MapColor.PINK_STAINED_HARDENED_CLAY)) {
							setWoolBlock(world, position, 6);
						} else if (checkMapColor(world, position, MapColor.PURPLE)) {
							setWoolBlock(world, position, 10);
						} else if (checkMapColor(world, position, MapColor.PURPLE_STAINED_HARDENED_CLAY)) {
							setWoolBlock(world, position, 10);
						} else if (checkMapColor(world, position, MapColor.QUARTZ)) {
							setWoolBlock(world, position, 0);
						} else if (checkMapColor(world, position, MapColor.RED)) {
							setWoolBlock(world, position, 14);
						} else if (checkMapColor(world, position, MapColor.RED_STAINED_HARDENED_CLAY)) {
							setWoolBlock(world, position, 14);
						} else if (checkMapColor(world, position, MapColor.SAND)) {
							setWoolBlock(world, position, 4);
						} else if (checkMapColor(world, position, MapColor.SILVER)) {
							setWoolBlock(world, position, 8);
						} else if (checkMapColor(world, position, MapColor.SILVER_STAINED_HARDENED_CLAY)) {
							setWoolBlock(world, position, 8);
						} else if (checkMapColor(world, position, MapColor.SNOW)) {
							setWoolBlock(world, position, 0);
						} else if (checkMapColor(world, position, MapColor.STONE)) {
							setWoolBlock(world, position, 8);
						} else if (checkMapColor(world, position, MapColor.TNT)) {
							setWoolBlock(world, position, 14);
						} else if (checkMapColor(world, position, MapColor.WATER)) {
							setWoolBlock(world, position, 11);
						} else if (checkMapColor(world, position, MapColor.WHITE_STAINED_HARDENED_CLAY)) {
							setWoolBlock(world, position, 0);
						} else if (checkMapColor(world, position, MapColor.WOOD)) {
							setWoolBlock(world, position, 12);
						} else if (checkMapColor(world, position, MapColor.YELLOW)) {
							setWoolBlock(world, position, 4);
						} else if (checkMapColor(world, position, MapColor.YELLOW_STAINED_HARDENED_CLAY)) {
							setWoolBlock(world, position, 4);
						}
					}
				}
			}
		}
	}
}