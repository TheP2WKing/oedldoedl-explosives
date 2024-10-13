package net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.supersonic;

import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class ExplosionSupersonic extends ModExplosionBase {
	public ExplosionSupersonic(World worldIn, Entity ignitor, double x, double y, double z, float explosionStrength,
			boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(worldIn, ignitor, x, y, z, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
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
							if (iblockstate.getMaterial() != Material.AIR
									&& iblockstate.getBlockHardness(this.world, blockpos) != -1) {
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
	public void doExplosionBlockDamage(boolean spawnParticles) {
		if (this.blockDamage) {
			for (BlockPos blockpos : this.affectedBlockPositions) {
				IBlockState iblockstate = this.world.getBlockState(blockpos);
				Block block = iblockstate.getBlock();
				if (spawnParticles) {
					double d0 = (double) ((float) blockpos.getX() + this.world.rand.nextFloat());
					double d1 = (double) ((float) blockpos.getY() + this.world.rand.nextFloat());
					double d2 = (double) ((float) blockpos.getZ() + this.world.rand.nextFloat());
					double d3 = d0 - this.x;
					double d4 = d1 - this.y;
					double d5 = d2 - this.z;
					double d6 = (double) MathHelper.sqrt(d3 * d3 + d4 * d4 + d5 * d5);
					d3 = d3 / d6;
					d4 = d4 / d6;
					d5 = d5 / d6;
					double d7 = 0.5D / (d6 / (double) this.explosionStrength + 0.1D);
					d7 = d7 * (double) (this.world.rand.nextFloat() * this.world.rand.nextFloat() + 0.3F);
					d3 = d3 * d7;
					d4 = d4 * d7;
					d5 = d5 * d7;
					this.world.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, (d0 + this.x) / 2.0D,
							(d1 + this.y) / 2.0D, (d2 + this.z) / 2.0D, d3, d4, d5);
					this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0, d1, d2, d3, d4, d5);
				}
				int range = 4;
				EntityFallingBlock fallingBlock = new EntityFallingBlock(this.world, blockpos.getX(),
						blockpos.getY(), blockpos.getZ(), iblockstate);
				// Correct method to set velocity
				fallingBlock.motionX = -range + (range * 2) * random.nextDouble();
				fallingBlock.motionY = range;
				fallingBlock.motionZ = -range + (range * 2) * random.nextDouble();
				fallingBlock.fallTime = 1;
				if (fallingBlock != null) {
					this.world.spawnEntity(fallingBlock);
				}
				this.dropBlocks(iblockstate, block, blockpos);
			}
		}
	}
}