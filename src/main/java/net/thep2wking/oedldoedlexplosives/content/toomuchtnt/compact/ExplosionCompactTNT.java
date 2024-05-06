package net.thep2wking.oedldoedlexplosives.content.toomuchtnt.compact;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class ExplosionCompactTNT extends ModExplosionBase {
	public ExplosionCompactTNT(World worldIn, Entity ignitor, double x, double y, double z, float explosionStrength,
			boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(worldIn, ignitor, x, y, z, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
	}

	@Override
	public void doExplosionSpawnFire() {
		if (this.spawnFire) {
			for (BlockPos blockpos1 : this.affectedBlockPositions) {
				if (this.world.getBlockState(blockpos1).getMaterial() == Material.AIR
						&& this.world.getBlockState(blockpos1.down()).isFullBlock() && this.random.nextInt(3) == 0) {
					this.world.setBlockState(new BlockPos(blockpos1.getX(), blockpos1.getY(), blockpos1.getZ()),
							Blocks.TNT.getDefaultState());
				}
				if (this.world.getBlockState(blockpos1).getMaterial() != Material.AIR
						|| !this.world.getBlockState(blockpos1.down()).isFullBlock() || this.random.nextInt(4) != 0) {
					continue;
				}
				this.world.setBlockState(new BlockPos(blockpos1.getX(), blockpos1.getY(), blockpos1.getZ()),
						Blocks.FIRE.getDefaultState());
			}
		}
	}
}