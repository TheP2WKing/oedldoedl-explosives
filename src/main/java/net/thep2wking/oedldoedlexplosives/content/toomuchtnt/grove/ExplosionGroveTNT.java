package net.thep2wking.oedldoedlexplosives.content.toomuchtnt.grove;

import java.util.ArrayList;
import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class ExplosionGroveTNT extends ModExplosionBase {
	ArrayList<BlockPos> newAffectedBlockPositions = new ArrayList<BlockPos>();

	public ExplosionGroveTNT(World worldIn, Entity ignitor, double x, double y, double z, float explosionStrength,
			boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(worldIn, ignitor, x, y, z, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void doExplosionSpawnFire() {
		if (this.spawnFire) {
			for (BlockPos blockpos : this.affectedBlockPositions) {
				int i = blockpos.getX();
				int j = blockpos.getY();
				int k = blockpos.getZ();
				BlockPos blockpos1 = new BlockPos(i, j, k);
				BlockPos blockpos2 = new BlockPos(i, j - 1, k);
				if (this.world.getBlockState(blockpos1).getMaterial() != Material.AIR || !this.world.getBlockState(blockpos2).isFullBlock())
					continue;
				if (this.world.getBlockState(blockpos2).getBlock() == Blocks.LEAVES || this.world.getBlockState(blockpos2).getBlock() == Blocks.LEAVES2)
					continue;
				this.world.setBlockState(new BlockPos(i, j - 1, k), Blocks.GRASS.getDefaultState(), 3);
			}
		}
		if (this.spawnFire) {
			for (BlockPos blockpos : this.affectedBlockPositions) {
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
				if (this.world.isAirBlock(new BlockPos(i, j, k))) {
					this.newTreeElement(new BlockPos(i, j, k), logblock, 3);
				}
				if (this.world.isAirBlock(new BlockPos(i, j + 1, k))) {
					this.newTreeElement(new BlockPos(i, j + 1, k), logblock, 3);
				}
				if (this.world.isAirBlock(new BlockPos(i, j + 2, k))) {
					this.newTreeElement(new BlockPos(i, j + 2, k), logblock, 3);
				}
				if (this.world.isAirBlock(new BlockPos(i, j + 3, k))) {
					this.newTreeElement(new BlockPos(i, j + 3, k), logblock, 3);
				}
				if (this.world.isAirBlock(new BlockPos(i, j + 4, k))) {
					this.newTreeElement(new BlockPos(i, j + 4, k), logblock, 3);
				}
				if (this.world.isAirBlock(new BlockPos(i, j + 5, k))) {
					this.newTreeElement(new BlockPos(i, j + 5, k), leavesblock, 3);
				}
				if (this.world.isAirBlock(new BlockPos(i + 1, j + 2, k))) {
					this.newTreeElement(new BlockPos(i + 1, j + 2, k), leavesblock, 3);
				}
				if (this.world.isAirBlock(new BlockPos(i, j + 2, k + 1))) {
					this.newTreeElement(new BlockPos(i, j + 2, k + 1), leavesblock, 3);
				}
				if (this.world.isAirBlock(new BlockPos(i - 1, j + 2, k))) {
					this.newTreeElement(new BlockPos(i - 1, j + 2, k), leavesblock, 3);
				}
				if (this.world.isAirBlock(new BlockPos(i, j + 2, k - 1))) {
					this.newTreeElement(new BlockPos(i, j + 2, k - 1), leavesblock, 3);
				}
				if (this.world.isAirBlock(new BlockPos(i + 1, j + 3, k))) {
					this.newTreeElement(new BlockPos(i + 1, j + 3, k), leavesblock, 3);
				}
				if (this.world.isAirBlock(new BlockPos(i, j + 3, k + 1))) {
					this.newTreeElement(new BlockPos(i, j + 3, k + 1), leavesblock, 3);
				}
				if (this.world.isAirBlock(new BlockPos(i - 1, j + 3, k))) {
					this.newTreeElement(new BlockPos(i - 1, j + 3, k), leavesblock, 3);
				}
				if (this.world.isAirBlock(new BlockPos(i, j + 3, k - 1))) {
					this.newTreeElement(new BlockPos(i, j + 3, k - 1), leavesblock, 3);
				}
				if (this.world.isAirBlock(new BlockPos(i + 1, j + 4, k))) {
					this.newTreeElement(new BlockPos(i + 1, j + 4, k), leavesblock, 3);
				}
				if (this.world.isAirBlock(new BlockPos(i, j + 4, k + 1))) {
					this.newTreeElement(new BlockPos(i, j + 4, k + 1), leavesblock, 3);
				}
				if (this.world.isAirBlock(new BlockPos(i - 1, j + 4, k))) {
					this.newTreeElement(new BlockPos(i - 1, j + 4, k), leavesblock, 3);
				}
				if (this.world.isAirBlock(new BlockPos(i, j + 4, k - 1))) {
					this.newTreeElement(new BlockPos(i, j + 4, k - 1), leavesblock, 3);
				}
			}
		}
	}

	public boolean newTreeElement(BlockPos pos, IBlockState newState, int flags) {
		return this.world.setBlockState(pos, newState, flags);
	}

	@Override
	public void doAffectedBlocks() {
		Set<BlockPos> set = Sets.<BlockPos>newHashSet();
		for (int j = 0; j < this.smoothness; ++j) {
			for (int k = 0; k < this.smoothness; ++k) {
				for (int l = 0; l < this.smoothness; ++l) {
					if (j == 0 || j == (this.smoothness - 1) || k == 0 || k == (this.smoothness - 1) || l == 0
							|| l == (this.smoothness - 1)) {
						double d0 = (double) ((float) j / (this.smoothness - 1) * 2.0F - 1.0F);
						double d1 = (double) ((float) k / (this.smoothness - 1) * 2.0F - 1.0F);
						double d2 = (double) ((float) l / (this.smoothness - 1) * 2.0F - 1.0F);
						double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
						d0 = d0 / d3;
						d1 = d1 / d3;
						d2 = d2 / d3;
						float f = this.explosionStrength * (0.7F + this.world.rand.nextFloat() * 0.6F);
						double d4 = this.x;
						double d6 = this.y;
						double d8 = this.z;
						for (@SuppressWarnings("unused")
						float f1 = 0.3F; f > 0.0F; f -= 0.22500001F) {
							BlockPos blockpos = new BlockPos(d4, d6, d8);
							IBlockState iblockstate = this.world.getBlockState(blockpos);
							if (iblockstate.getMaterial() != Material.AIR) {
								float f2 = this.ignitor != null
										? this.ignitor.getExplosionResistance(this, this.world, blockpos, iblockstate)
										: iblockstate.getBlock().getExplosionResistance(world, blockpos, (Entity) null,
												this);
								f -= (f2 + 0.3F + 1000f) * 0.3F;
							}
							if (f > 0.0F && (this.ignitor == null || this.ignitor.canExplosionDestroyBlock(this,
									this.world, blockpos, iblockstate, f))) {
								set.add(blockpos);
							}
							d4 += d0 * 0.30000001192092896D;
							d6 += d1 * 0.30000001192092896D;
							d8 += d2 * 0.30000001192092896D;
						}
					}
				}
			}
		}
		this.affectedBlockPositions.addAll(set);
	}
}