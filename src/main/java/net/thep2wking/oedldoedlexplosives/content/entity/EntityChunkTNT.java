package net.thep2wking.oedldoedlexplosives.content.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;
import net.thep2wking.oedldoedlexplosives.config.ExplosivesConfig;

public class EntityChunkTNT extends ModEntityTNTBase {
	public EntityChunkTNT(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
	}

	public EntityChunkTNT(World world) {
		super(world);
	}

	public static void fillReactangle(World world, int x1, int y1, int z1, int x2, int y2, int z2, Block block) {
		for (int x = x1; x < x2; ++x) {
			for (int y = y1; y < y2; ++y) {
				for (int z = z1; z < z2; ++z) {
					world.setBlockState(new BlockPos(x, y, z), block.getDefaultState());
				}
			}
		}
	}

	@Override
	public void explode() {
		this.world.newExplosion(this, this.posX, this.posY + (double) (this.height / 16.0F), this.posZ, 0, false,
				false);

		Chunk chunk = this.world.getChunkFromBlockCoords(this.getPosition());
		int chunkX = chunk.x;
		int chunkZ = chunk.z;

		int chunkPosX1 = chunkX * 16;
		int chunkPosX2 = chunkX * 16 + 16;
		int chunkPosY1 = 0;
		int chunkPosY2 = 256;
		int chunkPosZ1 = chunkZ * 16;
		int chunkPosZ2 = chunkZ * 16 + 16;

		if (ExplosivesConfig.PROPERTIES.NON_STANDARD_EXPLOSION_DAMAGE) {
			fillReactangle(this.world, chunkPosX1, chunkPosY1, chunkPosZ1, chunkPosX2, chunkPosY2, chunkPosZ2,
					Blocks.TNT);
		}
	}
}