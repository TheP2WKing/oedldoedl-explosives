package net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.chunk;

import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class ExplosionChunk extends ModExplosionBase {
	public ExplosionChunk(World worldIn, Entity ignitor, double x, double y, double z, float explosionStrength,
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
			this.world.setBlockState(blockpos, Blocks.TNT.getDefaultState(), 3);
		}
	}

	@Override
	public void doAffectedBlocks() {
		Chunk chunk = this.world.getChunkFromBlockCoords(new BlockPos(this.x, this.y, this.z));
		int chunkX = chunk.x;
		int chunkZ = chunk.z;
		int chunkPosX1 = chunkX * 16;
		int chunkPosX2 = chunkX * 16 + 15;
		int chunkPosY1 = 0;
		int chunkPosY2 = 256;
		int chunkPosZ1 = chunkZ * 16;
		int chunkPosZ2 = chunkZ * 16 + 15;
		for (int x = chunkPosX1; x <= chunkPosX2; x++) {
			for (int y = chunkPosY1; y <= chunkPosY2; y++) {
				for (int z = chunkPosZ1; z <= chunkPosZ2; z++) {
					BlockPos blockpos = new BlockPos(x, y, z);
					this.affectedBlockPositions.add(blockpos);
				}
			}
		}
	}
}