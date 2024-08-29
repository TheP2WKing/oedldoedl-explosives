package net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.island;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class ExplosionIsland extends ModExplosionBase {
	public ExplosionIsland(World worldIn, Entity ignitor, double x, double y, double z, float explosionStrength,
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
				int radius = (int) this.explosionStrength;
				BlockPos newBlockPos = blockpos.up(radius * 2);
				this.world.setBlockState(newBlockPos, iblockstate);
				this.dropBlocks(iblockstate, block, blockpos);
			}
		}
	}

	@Override
	public void doAffectedBlocks() {
		int radius = (int) this.explosionStrength;
		for (int r = radius, x3 = -r; x3 < r; ++x3) {
			for (int y3 = -r; y3 < r; ++y3) {
				for (int z3 = -r; z3 < r; ++z3) {
					BlockPos blockpos = new BlockPos(this.x + x3, this.y + y3, this.z + z3);
					IBlockState iblockstate = this.world.getBlockState(blockpos);
					if (iblockstate.getMaterial() != Material.AIR
							&& iblockstate.getBlockHardness(this.world, blockpos) != -1) {
						if (Math.pow(x3, 2.0) + Math.pow(y3, 2.0) + Math.pow(z3, 2.0) < Math.pow(r, 2.0)) {
							this.affectedBlockPositions.add(blockpos);
						}
					}
				}
			}
		}
	}
}