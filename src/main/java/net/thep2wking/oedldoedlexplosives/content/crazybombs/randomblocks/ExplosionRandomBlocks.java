package net.thep2wking.oedldoedlexplosives.content.crazybombs.randomblocks;

import java.util.Arrays;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;
import net.thep2wking.oedldoedlexplosives.config.ExplosivesConfig;

public class ExplosionRandomBlocks extends ModExplosionBase {
	public ExplosionRandomBlocks(World worldIn, Entity ignitor, double x, double y, double z, float explosionStrength,
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
		int radius = (int) this.explosionStrength;
		int radiusY = (int) this.explosionStrength * 2;
		for (int x = -radius; x <= radius; x++) {
			for (int y = 0; y <= radiusY; y++) {
				for (int z = -radius; z <= radius; z++) {
					BlockPos blockpos = new BlockPos(this.x + x, this.y + y, this.z + z);
					this.affectedBlockPositions.add(blockpos);
				}
			}
		}
	}

	private static final List<Block> BLACKLIST = Arrays.asList(
			Blocks.WATER,
			Blocks.LAVA,
			Blocks.FLOWING_WATER,
			Blocks.FLOWING_LAVA);

	@Override
	public void doExplosionBlockDamage(boolean spawnParticles) {
		for (BlockPos blockpos : this.affectedBlockPositions) {
			IBlockState blockState = this.world.getBlockState(blockpos);
			if (this.world.getBlockState(blockpos).getMaterial() == Material.AIR
					|| blockState.getBlock().isReplaceable(this.world, blockpos)) {
				if (random.nextInt(5) == 0) {
					int randomblockid = random.nextInt(ExplosivesConfig.CONTENT.RANDOM_BLOCKS_TNT_MAX_ID);
					Block randomblock = Block.getBlockById((int) randomblockid);
					if (!BLACKLIST.contains(randomblock) && randomblock.canPlaceBlockAt(this.world, blockpos)) {
						this.world.setBlockState(blockpos, randomblock.getDefaultState(), 3);
					}
				}
			}
		}
	}
}