package net.thep2wking.oedldoedlexplosives.content.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;

public class EntityWoolTNT extends ModEntityTNTBase {
	public EntityWoolTNT(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
	}

	public EntityWoolTNT(World world) {
		super(world);
	}

	@Override
	@SuppressWarnings("all")
	public void explode() {
		this.world.newExplosion(this, this.posX, this.posY + (double) (this.height / 16.0F), this.posZ, 0, false, false);

		final float f = (float)(Math.random() * 3.141592653589793 * 2.0);

		for (int r = 32, x4 = -r; x4 < r; ++x4) {
			for (int y4 = -r; y4 < r; ++y4) {
				for (int z4 = -r; z4 < r; ++z4) {
					if (this.world.getBlockState(new BlockPos((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4)) == Blocks.GRASS.getDefaultState()) {
						this.world.setBlockState(new BlockPos((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4), Blocks.WOOL.getStateFromMeta(5));
					}
					else if (this.world.getBlockState(new BlockPos((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4)) == Blocks.DIRT.getDefaultState()) {
						this.world.setBlockState(new BlockPos((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4), Blocks.WOOL.getStateFromMeta(12));
					}
					else if (this.world.getBlockState(new BlockPos((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4)) == Blocks.STONE.getDefaultState()) {
						this.world.setBlockState(new BlockPos((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4), Blocks.WOOL.getStateFromMeta(8));
					}
					else if (this.world.getBlockState(new BlockPos((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4)) == Blocks.GRAVEL.getDefaultState()) {
						this.world.setBlockState(new BlockPos((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4), Blocks.WOOL.getStateFromMeta(8));
					}
					else if (this.world.getBlockState(new BlockPos((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4)) == Blocks.SAND.getDefaultState()) {
						this.world.setBlockState(new BlockPos((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4), Blocks.WOOL.getStateFromMeta(4));
					}

					else if (this.world.getBlockState(new BlockPos((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4)) == Blocks.STONE.getStateFromMeta(1)) {
						this.world.setBlockState(new BlockPos((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4), Blocks.WOOL.getStateFromMeta(14));
					}

					else if (this.world.getBlockState(new BlockPos((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4)) == Blocks.STONE.getStateFromMeta(3)) {
						this.world.setBlockState(new BlockPos((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4), Blocks.WOOL.getStateFromMeta(0));
					}

					else if (this.world.getBlockState(new BlockPos((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4)) == Blocks.STONE.getStateFromMeta(5)) {
						this.world.setBlockState(new BlockPos((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4), Blocks.WOOL.getStateFromMeta(8));
					}

					else if (this.world.getBlockState(new BlockPos((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4)) == Blocks.LOG.getDefaultState()) {
						this.world.setBlockState(new BlockPos((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4), Blocks.WOOL.getStateFromMeta(12));
					}
					else if (this.world.getBlockState(new BlockPos((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4)) == Blocks.LOG2.getDefaultState()) {
						this.world.setBlockState(new BlockPos((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4), Blocks.WOOL.getStateFromMeta(12));
					}
					else if (this.world.getBlockState(new BlockPos((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4)) == Blocks.LEAVES.getDefaultState()) {
						this.world.setBlockState(new BlockPos((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4), Blocks.WOOL.getStateFromMeta(13));
					}
					else if (this.world.getBlockState(new BlockPos((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4)) == Blocks.LEAVES2.getDefaultState()) {
						this.world.setBlockState(new BlockPos((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4), Blocks.WOOL.getStateFromMeta(13));
					}
					else if (this.world.getBlockState(new BlockPos((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4)) == Blocks.COBBLESTONE.getDefaultState()) {
						this.world.setBlockState(new BlockPos((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4), Blocks.WOOL.getStateFromMeta(7));
					}

					else if (this.world.getBlockState(new BlockPos((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4)) == Blocks.LOG.getStateFromMeta(2)) {
						this.world.setBlockState(new BlockPos((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4), Blocks.WOOL.getStateFromMeta(12));
					}
					else if (this.world.getBlockState(new BlockPos((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4)) == Blocks.LEAVES.getStateFromMeta(2)) {
						this.world.setBlockState(new BlockPos((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4), Blocks.WOOL.getStateFromMeta(13));
					}

					// if (this.worldObj.getBlock((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4) == Blocks.grass) {
					// 	this.worldObj.setBlock((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4, Blocks.wool, 5, 2);
					// }
					// else if (this.worldObj.getBlock((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4) == Blocks.dirt) {
					// 	this.worldObj.setBlock((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4, Blocks.wool, 12, 2);
					// }
					// else if (this.worldObj.getBlock((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4) == Blocks.log || this.worldObj.getBlock((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4) == Blocks.log2) {
					// 	this.worldObj.setBlock((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4, Blocks.wool, 12, 2);
					// }
					// else if (this.worldObj.getBlock((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4) == Blocks.leaves) {
					// 	this.worldObj.setBlock((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4, Blocks.wool, 13, 2);
					// }
					// else if (this.worldObj.getBlock((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4) == Blocks.stone) {
					// 	this.worldObj.setBlock((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4, Blocks.wool, 8, 2);
					// }
					// else if (this.worldObj.getBlock((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4) == Blocks.cobblestone) {
					// 	this.worldObj.setBlock((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4, Blocks.wool, 7, 2);
					// }
					// else if (this.worldObj.getBlock((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4) == Blocks.obsidian) {
					// 	this.worldObj.setBlock((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4, Blocks.wool, 15, 2);
					// }
					// else if (this.worldObj.getBlock((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4) == Blocks.sand) {
					// 	this.worldObj.setBlock((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4, Blocks.wool, 0, 2);
					// }
					// else if (this.worldObj.getBlock((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4) == Blocks.planks) {
					// 	this.worldObj.setBlock((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4, Blocks.wool, 4, 2);
					// }
					// else if (this.worldObj.getBlock((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4) == Blocks.stonebrick) {
					// 	this.worldObj.setBlock((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4, Blocks.wool, 8, 2);
					// }
					// else if (this.worldObj.getBlock((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4) == Blocks.brick_block) {
					// 	this.worldObj.setBlock((int)this.posX + x4, (int)this.posY + y4, (int)this.posZ + z4, Blocks.wool, 14, 2);
					// }
				}
			}
		}
	}
}