package net.thep2wking.oedldoedlexplosives.content.crazybombs.island;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class ExplosionIslandCb extends ModExplosionBase {
	public ExplosionIslandCb(World worldIn, Entity ignitor, double x, double y, double z, float explosionStrength,
			boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(worldIn, ignitor, x, y, z, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
	}

	@Override
	public void doExplosionA() {
		this.doAffectedBlocks();
		this.doDamageAndKnockback(false);
	}

	@Override
	public void doAffectedBlocks() {
		int radiusX = (int) this.explosionStrength;
		int radiusY = (int) this.explosionStrength / 2;
		int radiusZ = (int) this.explosionStrength;

		// Define the ranges for the loops
		int startX = (int) x - radiusX;
		int endX = (int) x + radiusX;
		int startY = (int) y - radiusY;
		int endY = (int) y;
		int startZ = (int) z - radiusZ;
		int endZ = (int) z + radiusZ;

		// Define the specific ranges for each loop
		int[][] ranges = {
				{ startX, endX, startY, startY + 2, startZ, endZ },
				{ startX, endX, startY, endY, startZ, startZ + 2 },
				{ startX, endX, startY, endY, endZ - 2, endZ },
				{ startX, startX + 2, startY, endY, startZ, endZ },
				{ endX - 2, endX, startY, endY, startZ, endZ }
		};

		// Iterate over the defined ranges and set the blocks
		for (int[] range : ranges) {
			for (int i = range[0]; i < range[1]; ++i) {
				for (int j = range[2]; j < range[3]; ++j) {
					for (int k = range[4]; k < range[5]; ++k) {
						BlockPos pos = new BlockPos(i, j, k);
						this.affectedBlockPositions.add(pos);
					}
				}
			}
		}
	}

	@Override
	public void doExplosionBlockDamage(boolean spawnParticles) {
		for (BlockPos blockpos : this.affectedBlockPositions) {
			IBlockState blockState = this.world.getBlockState(blockpos);
			if (blockState.getBlockHardness(this.world, blockpos) != -1) {
				this.world.setBlockState(blockpos, Blocks.FLOWING_WATER.getDefaultState(), 3);
			}
		}
	}
}