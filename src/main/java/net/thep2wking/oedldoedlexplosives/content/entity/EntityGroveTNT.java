package net.thep2wking.oedldoedlexplosives.content.entity;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;

public class EntityGroveTNT extends ModEntityTNTBase {
	public EntityGroveTNT(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
	}

	public EntityGroveTNT(World world) {
		super(world);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void explode() {
		this.world.newExplosion(this, this.posX, this.posY + (double) (this.height / 16.0F), this.posZ, 0, false,
				false);
		int radius = 14;
		List<BlockPos> affectedBlockPositions = new ArrayList<>();
		for (int x = -radius; x <= radius; x++) {
			for (int y = -radius; y <= radius; y++) {
				for (int z = -radius; z <= radius; z++) {
					BlockPos blockPos = new BlockPos(posX + x, posY + y, posZ + z);
					affectedBlockPositions.add(blockPos);
				}
			}
		}

		for (BlockPos blockpos : affectedBlockPositions) {
			IBlockState leavesblock;
			IBlockState logblock;
			int wood;
			int log;
			BlockPos blockpos1;
			BlockPos blockpos2;
			int i = blockpos.getX();
			int j = blockpos.getY();
			int k = blockpos.getZ();
			blockpos1 = new BlockPos(i, j, k);
			blockpos2 = new BlockPos(i, j - 1, k);
			log = this.world.rand.nextInt(3);
			if (log == 0) {
				wood = this.world.rand.nextInt(2);
				logblock = Blocks.LOG2.getStateFromMeta(wood);
				leavesblock = Blocks.LEAVES2.getStateFromMeta(wood);
			} else {
				wood = this.world.rand.nextInt(4);
				logblock = Blocks.LOG.getStateFromMeta(wood);
				leavesblock = Blocks.LEAVES.getStateFromMeta(wood);
			}
			if (this.world.getBlockState(blockpos1).getMaterial() != Material.AIR
					|| this.world.getBlockState(blockpos2).getMaterial() != Material.GRASS
					|| !this.world.getBlockState(blockpos2).isFullBlock() || this.world.rand.nextInt(10) != 0)
				continue;
			this.newTree(new BlockPos(i, j, k), logblock, 3);
			this.newTree(new BlockPos(i, j + 1, k), logblock, 3);
			this.newTree(new BlockPos(i, j + 2, k), logblock, 3);
			this.newTree(new BlockPos(i, j + 3, k), logblock, 3);
			this.newTree(new BlockPos(i, j + 4, k), logblock, 3);
			this.newTree(new BlockPos(i, j + 5, k), leavesblock, 3);
			this.newTree(new BlockPos(i + 1, j + 2, k), leavesblock, 3);
			this.newTree(new BlockPos(i, j + 2, k + 1), leavesblock, 3);
			this.newTree(new BlockPos(i - 1, j + 2, k), leavesblock, 3);
			this.newTree(new BlockPos(i, j + 2, k - 1), leavesblock, 3);
			this.newTree(new BlockPos(i + 1, j + 3, k), leavesblock, 3);
			this.newTree(new BlockPos(i, j + 3, k + 1), leavesblock, 3);
			this.newTree(new BlockPos(i - 1, j + 3, k), leavesblock, 3);
			this.newTree(new BlockPos(i, j + 3, k - 1), leavesblock, 3);
			this.newTree(new BlockPos(i + 1, j + 4, k), leavesblock, 3);
			this.newTree(new BlockPos(i, j + 4, k + 1), leavesblock, 3);
			this.newTree(new BlockPos(i - 1, j + 4, k), leavesblock, 3);
			this.newTree(new BlockPos(i, j + 4, k - 1), leavesblock, 3);
		}
	}

	public boolean newTree(BlockPos pos, IBlockState newState, int flags) {
		return this.world.setBlockState(pos, newState, flags);
	}
}