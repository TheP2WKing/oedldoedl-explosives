package net.thep2wking.oedldoedlexplosives.content.toomuchtnt.digging;

import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class ExplosionDiggingTNT extends ModExplosionBase {
	public ExplosionDiggingTNT(World worldIn, Entity ignitor, double x, double y, double z, float explosionStrength,
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
		Set<BlockPos> set = Sets.<BlockPos>newHashSet();
		for (int j = 0; j < this.smoothness; ++j) {
			for (int k = 0; k < this.smoothness; ++k) {
				for (int l = 0; l < this.smoothness; ++l) {
					if (j == 0 || j == (this.smoothness - 1) || k == 0 || k == (this.smoothness - 1) || l == 0
							|| l == (this.smoothness - 1)) {
						double d0 = (double) ((float) j / (this.smoothness - 1) * 0.0F - 0.0F);
						double d1 = (double) ((float) k / (this.smoothness - 1) * 0.0F - 1.0F);
						double d2 = (double) ((float) l / (this.smoothness - 1) * 0.0F - 0.0F);
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
							float f2;
							BlockPos blockpos = new BlockPos(d4, d6, d8);
							IBlockState iblockstate = this.world.getBlockState(blockpos);
							if (iblockstate.getBlock().getHarvestLevel(iblockstate) <= -1) {
								f2 = this.ignitor != null
										? this.ignitor.getExplosionResistance(this, this.world, blockpos, iblockstate)
										: iblockstate.getBlock().getExplosionResistance(world, blockpos, (Entity) null,
												this);
								f -= (f2 + 0.3F) * 0.3F;
							}
							if (iblockstate.getMaterial() != Material.AIR) {
								f2 = this.ignitor != null
										? this.ignitor.getExplosionResistance(this, this.world, blockpos, iblockstate)
										: iblockstate.getBlock().getExplosionResistance(world, blockpos, (Entity) null,
												this);
								f -= (1.3f + 0.3F) * 0.3F;
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

	@Override
	public void doExplosionSpawnFire() {
		if (this.spawnFire) {
			for (BlockPos blockpos1 : this.affectedBlockPositions) {
				if (this.world.getBlockState(blockpos1).getMaterial() == Material.AIR
						&& this.world.getBlockState(blockpos1.down()).isFullBlock()) {
					this.world.setBlockState(blockpos1, Blocks.FLOWING_WATER.getDefaultState());
					this.world.setBlockState(blockpos1.up(), Blocks.FLOWING_WATER.getDefaultState());
				}
			}
		}
	}
}