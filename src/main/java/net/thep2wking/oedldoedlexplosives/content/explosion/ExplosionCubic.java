package net.thep2wking.oedldoedlexplosives.content.explosion;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlcore.util.ModLogger;
import net.thep2wking.oedldoedlexplosives.config.ExplosivesConfig;

public class ExplosionCubic extends ExplosionBase {
	public ExplosionCubic(World worldIn, Entity entityIn, double x, double y, double z, float size, boolean flaming,
			boolean damagesTerrain) {
		super(worldIn, entityIn, x, y, z, size, flaming, damagesTerrain);
	}

	@Override
	public void doExplosionA() {
		super.doExplosionA();
		int chunkPosX1 = (int) (this.x - 4);
		int chunkPosX2 = (int) (this.x + 3);
		int chunkPosY1 = (int) (this.y - 2);
		int chunkPosY2 = (int) (this.y + 3);
		int chunkPosZ1 = (int) (this.z - 3);
		int chunkPosZ2 = (int) (this.z + 4);
		if (ExplosivesConfig.PROPERTIES.NON_STANDARD_EXPLOSION_DAMAGE) {
			fillReactangle(this.world, chunkPosX1, chunkPosY1, chunkPosZ1, chunkPosX2, chunkPosY2, chunkPosZ2,
					Blocks.AIR);
		}

		ModLogger.LOGGER.info("hmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
	}

	@Override
	public void doExplosionB(boolean spawnParticles) {
		super.doExplosionB(spawnParticles);
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
}
