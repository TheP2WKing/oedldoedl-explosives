package net.thep2wking.oedldoedlexplosives.content.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;
import net.thep2wking.oedldoedlexplosives.config.ExplosivesConfig;

public class EntityButterTNT extends ModEntityTNTBase {
	public EntityButterTNT(World world, double x, double y, double z, EntityLivingBase igniter, int fuse,
			float explosionStrength, boolean spawnFire, boolean blockDamage) {
		super(world, x, y, z, igniter, fuse, explosionStrength, spawnFire, blockDamage);
	}

	public EntityButterTNT(World world) {
		super(world);
	}

	public static Block getBlock(World w, int x, int y, int z, BlockPos pos) {
		return w.getBlockState(pos.add(x - pos.getX(), y - pos.getY(), z - pos.getZ())).getBlock();
	}

	public static void setBlock(World w, int x, int y, int z, BlockPos pos, Block b) {
		w.setBlockState(pos.add(x - pos.getX(), y - pos.getY(), z - pos.getZ()), b.getDefaultState());
	}

	@Override
	public void explode() {
		this.world.newExplosion(this, this.posX, this.posY + (double) (this.height / 16.0F), this.posZ,
				this.explosionStrength, this.spawnFire, this.blockDamage);
		if (ExplosivesConfig.PROPERTIES.NON_STANDARD_EXPLOSION_DAMAGE) {
			for (int i2 = (int) this.posX - 4; i2 < (int) this.posX + 4; ++i2) {
				for (int j2 = (int) this.posY - 3; j2 < (int) this.posY; ++j2) {
					for (int k2 = (int) this.posZ - 4; k2 < (int) this.posZ + 4; ++k2) {
						BlockPos pos = new BlockPos(i2, j2, k2);
						if (getBlock(this.world, i2, j2, k2, pos) != Blocks.AIR)
							continue;
						setBlock(this.world, i2, j2, k2, pos, Blocks.GOLD_BLOCK);
					}
				}
			}
		}
	}
}