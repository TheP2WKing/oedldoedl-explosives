package net.thep2wking.oedldoedlexplosives.content.toomuchtnt.easteregg;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class ExplosionEasterEgg extends ModExplosionBase {
	public ExplosionEasterEgg(World worldIn, Entity ignitor, double x, double y, double z, float explosionStrength,
			boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(worldIn, ignitor, x, y, z, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
	}

	@Override
	public void doExplosionSpawnFire() {
		if (this.spawnFire) {
			for (BlockPos blockpos1 : this.affectedBlockPositions) {
				IBlockState iblockstate = this.world.getBlockState(blockpos1.down());
				if (this.world.getBlockState(blockpos1).getMaterial() == Material.AIR
						&& iblockstate.getBlockHardness(this.world, blockpos1.down()) != -1
						&& this.world.getBlockState(blockpos1.down()).isFullBlock() && this.random.nextInt(2) == 0) {
					this.world.setBlockState(blockpos1.down(), Blocks.PUMPKIN.getDefaultState());
				}
				if (this.world.getBlockState(blockpos1).getMaterial() == Material.AIR
						&& iblockstate.getBlockHardness(this.world, blockpos1.down()) != -1
						&& this.world.getBlockState(blockpos1.down()).isFullBlock() && this.random.nextInt(3) == 0) {
					this.world.setBlockState(blockpos1.down(), Blocks.MELON_BLOCK.getDefaultState());
				}
			}
		}
	}
}