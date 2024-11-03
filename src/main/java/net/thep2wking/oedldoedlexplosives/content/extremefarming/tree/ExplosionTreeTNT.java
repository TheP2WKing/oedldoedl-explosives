package net.thep2wking.oedldoedlexplosives.content.extremefarming.tree;

import java.util.Random;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class ExplosionTreeTNT extends ModExplosionBase {
	public ExplosionTreeTNT(World worldIn, Entity ignitor, double x, double y, double z, float explosionStrength,
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
                                EnumFacing.UP, (BlockSapling) Blocks.SAPLING)
                        && this.random.nextInt(2) == 0) {
                    this.placeRandomSapling(blockpos1);
                }
            }
        }
    }

    public void placeRandomSapling(BlockPos blockpos1) {
        BlockPlanks.EnumType[] saplings = BlockPlanks.EnumType.values();
        BlockPlanks.EnumType wood = saplings[new Random().nextInt(saplings.length)];
        IBlockState saplingState = Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE, wood);
        this.world.setBlockState(blockpos1, saplingState);
    }
}