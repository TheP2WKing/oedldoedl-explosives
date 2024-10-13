package net.thep2wking.oedldoedlexplosives.content.crazybombs.lolxd;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionRotatableBase;

public class ExplosionLOLXD extends ModExplosionRotatableBase {
	public ExplosionLOLXD(World worldIn, Entity ignitor, double x, double y, double z, float explosionStrength,
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
			this.world.setBlockState(blockpos, Blocks.COAL_BLOCK.getDefaultState(), 3);
		}
	}

	@Override
	public void doAffectedBlocks() {
		EnumFacing.Axis axis = this.getAxis();
		if (axis == EnumFacing.Axis.Z) {
			this.setAxisBlocksZ();
		} else if (axis == EnumFacing.Axis.X) {
			this.setAxisBlocksX();
		} else {
			this.setAxisBlocksZ();
		}
	}

	private void setAxisBlocksX() {
		int off = 8;
		addBlockAndRecord(new BlockPos(x, y, z - off));
		addBlockAndRecord(new BlockPos(x, y + 1.0, z - off));
		addBlockAndRecord(new BlockPos(x, y + 2.0, z - off));
		addBlockAndRecord(new BlockPos(x, y + 3.0, z - off));
		addBlockAndRecord(new BlockPos(x, y, z + 1.0 - off));
		addBlockAndRecord(new BlockPos(x, y, z + 3.0 - off));
		addBlockAndRecord(new BlockPos(x, y + 1.0, z + 3.0 - off));
		addBlockAndRecord(new BlockPos(x, y + 2.0, z + 3.0 - off));
		addBlockAndRecord(new BlockPos(x, y + 3.0, z + 3.0 - off));
		addBlockAndRecord(new BlockPos(x, y, z + 4.0 - off));
		addBlockAndRecord(new BlockPos(x, y, z + 5.0 - off));
		addBlockAndRecord(new BlockPos(x, y + 1.0, z + 5.0 - off));
		addBlockAndRecord(new BlockPos(x, y + 2.0, z + 5.0 - off));
		addBlockAndRecord(new BlockPos(x, y + 3.0, z + 5.0 - off));
		addBlockAndRecord(new BlockPos(x, y + 3.0, z + 5.0 - off));
		addBlockAndRecord(new BlockPos(x, y + 3.0, z + 3.0 - off));
		addBlockAndRecord(new BlockPos(x, y + 3.0, z + 4.0 - off));
		addBlockAndRecord(new BlockPos(x, y + 3.0, z + 5.0 - off));
		addBlockAndRecord(new BlockPos(x, y, z + 7.0 - off));
		addBlockAndRecord(new BlockPos(x, y + 1.0, z + 7.0 - off));
		addBlockAndRecord(new BlockPos(x, y + 2.0, z + 7.0 - off));
		addBlockAndRecord(new BlockPos(x, y + 3.0, z + 7.0 - off));
		addBlockAndRecord(new BlockPos(x, y, z + 8.0 - off));
		addBlockAndRecord(new BlockPos(x, y, z + 10.0 - off));
		addBlockAndRecord(new BlockPos(x, y, z + 12.0 - off));
		addBlockAndRecord(new BlockPos(x, y + 1.0, z + 11.0 - off));
		addBlockAndRecord(new BlockPos(x, y + 2.0, z + 10.0 - off));
		addBlockAndRecord(new BlockPos(x, y + 2.0, z + 12.0 - off));
		addBlockAndRecord(new BlockPos(x, y, z + 14.0 - off));
		addBlockAndRecord(new BlockPos(x, y + 1.0, z + 14.0 - off));
		addBlockAndRecord(new BlockPos(x, y + 2.0, z + 14.0 - off));
		addBlockAndRecord(new BlockPos(x, y + 3.0, z + 14.0 - off));
		addBlockAndRecord(new BlockPos(x, y, z + 15.0 - off));
		addBlockAndRecord(new BlockPos(x, y + 3.0, z + 15.0 - off));
		addBlockAndRecord(new BlockPos(x, y + 2.0, z + 16.0 - off));
		addBlockAndRecord(new BlockPos(x, y + 1.0, z + 16.0 - off));
	}

	private void setAxisBlocksZ() {
		int off = 8;
		addBlockAndRecord(new BlockPos(x - off, y, z));
		addBlockAndRecord(new BlockPos(x - off, y + 1.0, z));
		addBlockAndRecord(new BlockPos(x - off, y + 2.0, z));
		addBlockAndRecord(new BlockPos(x - off, y + 3.0, z));
		addBlockAndRecord(new BlockPos(x + 1.0 - off, y, z));
		addBlockAndRecord(new BlockPos(x + 3.0 - off, y, z));
		addBlockAndRecord(new BlockPos(x + 3.0 - off, y + 1.0, z));
		addBlockAndRecord(new BlockPos(x + 3.0 - off, y + 2.0, z));
		addBlockAndRecord(new BlockPos(x + 3.0 - off, y + 3.0, z));
		addBlockAndRecord(new BlockPos(x + 4.0 - off, y, z));
		addBlockAndRecord(new BlockPos(x + 5.0 - off, y, z));
		addBlockAndRecord(new BlockPos(x + 5.0 - off, y + 1.0, z));
		addBlockAndRecord(new BlockPos(x + 5.0 - off, y + 2.0, z));
		addBlockAndRecord(new BlockPos(x + 5.0 - off, y + 3.0, z));
		addBlockAndRecord(new BlockPos(x + 5.0 - off, y + 3.0, z));
		addBlockAndRecord(new BlockPos(x + 3.0 - off, y + 3.0, z));
		addBlockAndRecord(new BlockPos(x + 4.0 - off, y + 3.0, z));
		addBlockAndRecord(new BlockPos(x + 5.0 - off, y + 3.0, z));
		addBlockAndRecord(new BlockPos(x + 7.0 - off, y, z));
		addBlockAndRecord(new BlockPos(x + 7.0 - off, y + 1.0, z));
		addBlockAndRecord(new BlockPos(x + 7.0 - off, y + 2.0, z));
		addBlockAndRecord(new BlockPos(x + 7.0 - off, y + 3.0, z));
		addBlockAndRecord(new BlockPos(x + 8.0 - off, y, z));
		addBlockAndRecord(new BlockPos(x + 10.0 - off, y, z));
		addBlockAndRecord(new BlockPos(x + 12.0 - off, y, z));
		addBlockAndRecord(new BlockPos(x + 11.0 - off, y + 1.0, z));
		addBlockAndRecord(new BlockPos(x + 10.0 - off, y + 2.0, z));
		addBlockAndRecord(new BlockPos(x + 12.0 - off, y + 2.0, z));
		addBlockAndRecord(new BlockPos(x + 14.0 - off, y, z));
		addBlockAndRecord(new BlockPos(x + 14.0 - off, y + 1.0, z));
		addBlockAndRecord(new BlockPos(x + 14.0 - off, y + 2.0, z));
		addBlockAndRecord(new BlockPos(x + 14.0 - off, y + 3.0, z));
		addBlockAndRecord(new BlockPos(x + 15.0 - off, y, z));
		addBlockAndRecord(new BlockPos(x + 15.0 - off, y + 3.0, z));
		addBlockAndRecord(new BlockPos(x + 16.0 - off, y + 2.0, z));
		addBlockAndRecord(new BlockPos(x + 16.0 - off, y + 1.0, z));
	}

	@SuppressWarnings("deprecation")
	private void addBlockAndRecord(BlockPos pos) {
		IBlockState iblockstate = this.world.getBlockState(pos);
		if ((iblockstate.getMaterial() == Material.AIR
				|| iblockstate.getBlock().isReplaceable(this.world, pos)
				|| !iblockstate.getBlock().isFullBlock(iblockstate))
				&& iblockstate.getBlockHardness(this.world, pos) != -1) {
			this.affectedBlockPositions.add(pos);
		}
	}
}