package net.thep2wking.oedldoedlexplosives.content.toomuchtnt.multiply;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class ExplosionMultiplyTNT extends ModExplosionBase {
	public ExplosionMultiplyTNT(World worldIn, Entity ignitor, double x, double y, double z, float explosionStrength,
			boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(worldIn, ignitor, x, y, z, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
	}

	@Override
	public void dropBlocks(IBlockState iblockstate, Block block, BlockPos blockpos) {
		if (iblockstate.getMaterial() != Material.AIR) {
			if (block.canDropFromExplosion(this) && this.dropBlocks) {
				block.dropBlockAsItem(this.world, blockpos, this.world.getBlockState(blockpos), 0);
				block.dropBlockAsItem(this.world, blockpos, this.world.getBlockState(blockpos), 0);
			}
			block.onBlockExploded(this.world, blockpos, this);
		}
	}
}