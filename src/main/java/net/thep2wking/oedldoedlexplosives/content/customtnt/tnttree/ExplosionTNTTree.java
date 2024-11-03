package net.thep2wking.oedldoedlexplosives.content.customtnt.tnttree;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;
import net.thep2wking.oedldoedlexplosives.init.ModBlocks;

public class ExplosionTNTTree extends ModExplosionBase {
	public ExplosionTNTTree(World worldIn, Entity ignitor, double x, double y, double z, float explosionStrength,
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
		this.affectedBlockPositions.add(new BlockPos(this.x, this.y, this.z));
		this.affectedBlockPositions.add(new BlockPos(this.x, this.y + 1, this.z));

		// First leaf layer
		this.affectedBlockPositions.add(new BlockPos(this.x, this.y + 2, this.z));
		this.affectedBlockPositions.add(new BlockPos(this.x + 1, this.y + 2, this.z));
		this.affectedBlockPositions.add(new BlockPos(this.x + 2, this.y + 2, this.z));
		this.affectedBlockPositions.add(new BlockPos(this.x - 1, this.y + 2, this.z));
		this.affectedBlockPositions.add(new BlockPos(this.x - 2, this.y + 2, this.z));
		this.affectedBlockPositions.add(new BlockPos(this.x, this.y + 2, this.z + 1));
		this.affectedBlockPositions.add(new BlockPos(this.x + 1, this.y + 2, this.z + 1));
		this.affectedBlockPositions.add(new BlockPos(this.x + 2, this.y + 2, this.z + 1));
		this.affectedBlockPositions.add(new BlockPos(this.x - 1, this.y + 2, this.z + 1));
		this.affectedBlockPositions.add(new BlockPos(this.x - 2, this.y + 2, this.z + 1));
		this.affectedBlockPositions.add(new BlockPos(this.x, this.y + 2, this.z - 1));
		this.affectedBlockPositions.add(new BlockPos(this.x + 1, this.y + 2, this.z - 1));
		this.affectedBlockPositions.add(new BlockPos(this.x + 2, this.y + 2, this.z - 1));
		this.affectedBlockPositions.add(new BlockPos(this.x - 1, this.y + 2, this.z - 1));
		this.affectedBlockPositions.add(new BlockPos(this.x - 2, this.y + 2, this.z - 1));
		this.affectedBlockPositions.add(new BlockPos(this.x, this.y + 2, this.z + 2));
		this.affectedBlockPositions.add(new BlockPos(this.x + 1, this.y + 2, this.z + 2));
		this.affectedBlockPositions.add(new BlockPos(this.x - 1, this.y + 2, this.z + 2));
		this.affectedBlockPositions.add(new BlockPos(this.x, this.y + 2, this.z - 2));
		this.affectedBlockPositions.add(new BlockPos(this.x + 1, this.y + 2, this.z - 2));
		this.affectedBlockPositions.add(new BlockPos(this.x - 1, this.y + 2, this.z - 2));

		// Second leaf layer
		this.affectedBlockPositions.add(new BlockPos(this.x, this.y + 3, this.z));
		this.affectedBlockPositions.add(new BlockPos(this.x + 1, this.y + 3, this.z));
		this.affectedBlockPositions.add(new BlockPos(this.x + 2, this.y + 3, this.z));
		this.affectedBlockPositions.add(new BlockPos(this.x - 1, this.y + 3, this.z));
		this.affectedBlockPositions.add(new BlockPos(this.x - 2, this.y + 3, this.z));
		this.affectedBlockPositions.add(new BlockPos(this.x, this.y + 3, this.z + 1));
		this.affectedBlockPositions.add(new BlockPos(this.x + 1, this.y + 3, this.z + 1));
		this.affectedBlockPositions.add(new BlockPos(this.x + 2, this.y + 3, this.z + 1));
		this.affectedBlockPositions.add(new BlockPos(this.x - 1, this.y + 3, this.z + 1));
		this.affectedBlockPositions.add(new BlockPos(this.x - 2, this.y + 3, this.z + 1));
		this.affectedBlockPositions.add(new BlockPos(this.x, this.y + 3, this.z - 1));
		this.affectedBlockPositions.add(new BlockPos(this.x + 1, this.y + 3, this.z - 1));
		this.affectedBlockPositions.add(new BlockPos(this.x + 2, this.y + 3, this.z - 1));
		this.affectedBlockPositions.add(new BlockPos(this.x - 1, this.y + 3, this.z - 1));
		this.affectedBlockPositions.add(new BlockPos(this.x - 2, this.y + 3, this.z - 1));
		this.affectedBlockPositions.add(new BlockPos(this.x, this.y + 3, this.z + 2));
		this.affectedBlockPositions.add(new BlockPos(this.x + 1, this.y + 3, this.z + 2));
		this.affectedBlockPositions.add(new BlockPos(this.x - 1, this.y + 3, this.z + 2));
		this.affectedBlockPositions.add(new BlockPos(this.x, this.y + 3, this.z - 2));
		this.affectedBlockPositions.add(new BlockPos(this.x + 1, this.y + 3, this.z - 2));
		this.affectedBlockPositions.add(new BlockPos(this.x - 1, this.y + 3, this.z - 2));

		// Third leaf layer
		this.affectedBlockPositions.add(new BlockPos(this.x, this.y + 4, this.z));
		this.affectedBlockPositions.add(new BlockPos(this.x + 1, this.y + 4, this.z));
		this.affectedBlockPositions.add(new BlockPos(this.x - 1, this.y + 4, this.z));
		this.affectedBlockPositions.add(new BlockPos(this.x, this.y + 4, this.z + 1));
		this.affectedBlockPositions.add(new BlockPos(this.x + 1, this.y + 4, this.z + 1));
		this.affectedBlockPositions.add(new BlockPos(this.x - 1, this.y + 4, this.z + 1));
		this.affectedBlockPositions.add(new BlockPos(this.x, this.y + 4, this.z - 1));
		this.affectedBlockPositions.add(new BlockPos(this.x + 1, this.y + 4, this.z - 1));
		this.affectedBlockPositions.add(new BlockPos(this.x - 1, this.y + 4, this.z - 1));

		// Fourth leaf layer
		this.affectedBlockPositions.add(new BlockPos(this.x, this.y + 5, this.z));
		this.affectedBlockPositions.add(new BlockPos(this.x + 1, this.y + 5, this.z));
		this.affectedBlockPositions.add(new BlockPos(this.x - 1, this.y + 5, this.z));
		this.affectedBlockPositions.add(new BlockPos(this.x, this.y + 5, this.z + 1));
		this.affectedBlockPositions.add(new BlockPos(this.x, this.y + 5, this.z - 1));
	}

	@Override
	public void doExplosionBlockDamage(boolean spawnParticles) {
		for (BlockPos blockpos : this.affectedBlockPositions) {
			this.world.setBlockState(blockpos, ModBlocks.FAKE_TNT.getDefaultState(), 3);
		}
	}
}