package net.thep2wking.oedldoedlexplosives.content.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;

public class EntityHTNT extends ModEntityTNTBase {
	public EntityHTNT(World world, double x, double y, double z, EntityLivingBase igniter, int fuse,
			float explosionStrength, boolean spawnFire, boolean blockDamage) {
		super(world, x, y, z, igniter, fuse, explosionStrength, spawnFire, blockDamage);
	}

	public EntityHTNT(World world) {
		super(world);
	}

	public static void fillSphere(final World w, final int _x, final int _y, final int _z, final int r, final Block b) {
		for (int x = -r; x < r; ++x) {
			for (int y = -r; y < r; ++y) {
				for (int z = -r; z < r; ++z) {
					if (Math.pow(x, 2.0) + Math.pow(y, 2.0) + Math.pow(z, 2.0) < Math.pow(r, 2.0) && w
							.getBlockState(new BlockPos(x + _x, y + _y, z + _z)) != Blocks.BEDROCK.getDefaultState()) {
						w.setBlockState(new BlockPos(x + _x, y + _y, z + _z), b.getDefaultState());
					}
				}
			}
		}
	}

	@Override
	public void explode() {
		this.world.newExplosion(this, this.posX, this.posY + (double) (this.height / 16.0F), this.posZ, 0, false,
				false);

		int r = 80;
		fillSphere(this.world, (int) this.posX, (int) this.posY, (int) this.posZ, r, Blocks.AIR);
		r += 3;
		for (int x4 = -r; x4 < r; ++x4) {
			for (int y4 = -r; y4 < r; ++y4) {
				for (int z4 = -r; z4 < r; ++z4) {
					if (Math.pow(x4, 2.0) + Math.pow(y4, 2.0) + Math.pow(z4, 2.0) < Math.pow(r, 2.0)
							&& this.world.getBlockState(new BlockPos((int) this.posX + x4, (int) this.posY + y4,
									(int) this.posZ + z4)) != Blocks.BEDROCK.getDefaultState()
							&& Math.random() > 0.5) {
						this.world.setBlockState(
								new BlockPos((int) this.posX + x4, (int) this.posY + y4, (int) this.posZ + z4),
								Blocks.AIR.getDefaultState());
					}
				}
			}
		}
	}
}