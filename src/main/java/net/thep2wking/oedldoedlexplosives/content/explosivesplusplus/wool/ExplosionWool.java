package net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.wool;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class ExplosionWool extends ModExplosionBase {
	public ExplosionWool(World worldIn, Entity ignitor, double x, double y, double z, float explosionStrength,
			boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(worldIn, ignitor, x, y, z, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
	}

	@Override
	public void doExplosionA() {
		this.doAffectedBlocks();
		this.doDamageAndKnockback(false);
	}

	@Override
	public void doExplosionBlockDamage(boolean spawnParticles) {
		for (BlockPos blockpos : this.affectedBlockPositions) {
			this.transformToWool(this.world, blockpos);
		}
	}

	@Override
	public void doAffectedBlocks() {
		int radius = (int) this.explosionStrength;
		for (int x = -radius; x <= radius; x++) {
			for (int y = -radius; y <= radius; y++) {
				for (int z = -radius; z <= radius; z++) {
					BlockPos blockpos = new BlockPos(this.x + x, this.y + y, this.z + z);
					IBlockState iblockstate = this.world.getBlockState(blockpos);
					if (iblockstate.getMaterial() != Material.AIR
							&& iblockstate.getBlockHardness(this.world, blockpos) != -1) {
						this.affectedBlockPositions.add(blockpos);
					}
				}
			}
		}
	}

	private void transformToWool(World world, BlockPos position) {
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

	@SuppressWarnings("deprecation")
	private boolean checkMapColor(World world, BlockPos blockPos, MapColor mapColor) {
		return world.getBlockState(blockPos).isFullCube() && !world.getBlockState(blockPos).getBlock().hasTileEntity()
				&& world.getBlockState(blockPos).getBlock().getHarvestLevel(world.getBlockState(blockPos)) != -1
				&& world.getBlockState(blockPos).getBlock().getMapColor(world.getBlockState(blockPos), world,
						blockPos) == mapColor
				&& world.getBlockState(blockPos).getBlock().getMapColor(world.getBlockState(blockPos), world,
						blockPos) != MapColor.AIR
				&& world.getBlockState(blockPos).getBlock().getMapColor(world.getBlockState(blockPos), world,
						blockPos) != MapColor.CLOTH;
	}

	@SuppressWarnings("deprecation")
	private void setWoolBlock(World world, BlockPos blockPos, int meta) {
		world.setBlockState(blockPos, Blocks.WOOL.getStateFromMeta(meta));
	}
}