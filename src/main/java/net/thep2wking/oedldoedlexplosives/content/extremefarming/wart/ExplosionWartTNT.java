package net.thep2wking.oedldoedlexplosives.content.extremefarming.wart;

import java.util.Random;

import net.minecraft.block.BlockNetherWart;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class ExplosionWartTNT extends ModExplosionBase {
	public ExplosionWartTNT(World worldIn, Entity ignitor, double x, double y, double z, float explosionStrength,
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
                BlockPos blockBelowPos = blockpos1.down();
                IBlockState blockBelowState = this.world.getBlockState(blockBelowPos);
                if ((blockState.getMaterial() == Material.AIR
                        || blockState.getBlock().isReplaceable(this.world, blockpos1))
                        && blockBelowState.getBlock().canSustainPlant(blockBelowState, this.world, blockBelowPos,
                                EnumFacing.UP, (BlockNetherWart) Blocks.NETHER_WART)
                        && this.random.nextInt(2) == 0) {
                    this.placeRandomWart(blockpos1);
                }
            }
        }
    }

    public void placeRandomWart(BlockPos blockpos) {
        int randomAge = new Random().nextInt(4);
        IBlockState plant = Blocks.NETHER_WART.getDefaultState().withProperty(BlockNetherWart.AGE, randomAge);
        this.world.setBlockState(blockpos, plant);
    }
}