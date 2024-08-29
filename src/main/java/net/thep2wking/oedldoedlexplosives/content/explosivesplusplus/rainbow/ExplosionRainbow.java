package net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.rainbow;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionRotatableBase;
import net.thep2wking.oedldoedlexplosives.init.ModBlocks;

public class ExplosionRainbow extends ModExplosionRotatableBase {
	public ExplosionRainbow(World worldIn, Entity ignitor, double x, double y, double z, float explosionStrength,
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
			this.world.setBlockState(blockpos, ModBlocks.RAINBOW_BLOCK.getDefaultState(), 3);
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public void doAffectedBlocks() {
		int radius = (int) this.explosionStrength;
		EnumFacing.Axis axis = this.getAxis();
		for (int r = radius, x5 = -r; x5 < r; ++x5) {
			for (int y5 = -r; y5 < r; ++y5) {
				BlockPos blockpos;
				if (axis == EnumFacing.Axis.Z) {
					blockpos = new BlockPos(this.x + x5, this.y + y5, this.z);
				} else if (axis == EnumFacing.Axis.X) {
					blockpos = new BlockPos(this.x, this.y + y5, this.z + x5);
				} else {
					blockpos = new BlockPos(this.x + x5, this.y + y5, this.z);
				}
				IBlockState iblockstate = this.world.getBlockState(blockpos);
				if ((iblockstate.getMaterial() == Material.AIR
						|| iblockstate.getBlock().isReplaceable(this.world, blockpos)
						|| !iblockstate.getBlock().isFullBlock(iblockstate))
						&& iblockstate.getBlockHardness(this.world, blockpos) != -1) {
					if (Math.pow(x5, 2.0) + Math.pow(y5, 2.0) < Math.pow(r, 2.0)
							&& Math.pow(x5, 2.0) + Math.pow(y5, 2.0) > Math.pow(r - 2, 2.0)) {
						this.affectedBlockPositions.add(blockpos);
					}
				}
			}
		}
	}
}