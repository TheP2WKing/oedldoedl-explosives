package net.thep2wking.oedldoedlexplosives.content.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;

public class EntityCubicTNT extends ModEntityTNTBase {
	public EntityCubicTNT(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
	}

	public EntityCubicTNT(World world) {
		super(world);
	}

	public static void fillReactangle(World world, int x1, int y1, int z1, int x2, int y2, int z2, Block block) {
		for (int x = x1; x < x2; ++x) {
			for (int y = y1; y < y2; ++y) {
				for (int z = z1; z < z2; ++z) {
					world.setBlockState(new BlockPos(x, y, z), block.getDefaultState());
					world.newExplosion(null, x, y, z, 0, false, false);
				}
			}
		}
	}

	@Override
	public void explode() {
		int chunkPosX1 = (int) (this.posX - 4);
		int chunkPosX2 = (int) (this.posX + 3);
		int chunkPosY1 = (int) (this.posY - 2);
		int chunkPosY2 = (int) (this.posY + 3);
		int chunkPosZ1 = (int) (this.posZ - 3);
		int chunkPosZ2 = (int) (this.posZ + 4);

		fillReactangle(this.world, chunkPosX1, chunkPosY1, chunkPosZ1, chunkPosX2, chunkPosY2, chunkPosZ2, Blocks.AIR);
	}
}