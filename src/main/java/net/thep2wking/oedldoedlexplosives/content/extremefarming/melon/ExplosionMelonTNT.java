package net.thep2wking.oedldoedlexplosives.content.extremefarming.melon;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class ExplosionMelonTNT extends ModExplosionBase {
	public ExplosionMelonTNT(World worldIn, Entity ignitor, double x, double y, double z, float explosionStrength,
			boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(worldIn, ignitor, x, y, z, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
	}

	@Override
	public void doExplosionA() {
		this.doAffectedBlocks();
		this.doDamageAndKnockback(false);
	}

	@Override
	public void doExplosionSpawnFire() {
		if (this.spawnFire) {
			for (BlockPos blockpos1 : this.affectedBlockPositions) {
				IBlockState blockState = this.world.getBlockState(blockpos1);
				if ((blockState.getMaterial() == Material.AIR
						|| blockState.getBlock().isReplaceable(this.world, blockpos1))
						&& this.world.getBlockState(blockpos1.down()).isFullBlock() && this.random.nextInt(2) == 0) {
					this.world.setBlockState(blockpos1, Blocks.MELON_BLOCK.getDefaultState());
				}
			}
		}
	}
}