package net.thep2wking.oedldoedlexplosives.content.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;

public class EntityMiniNukeTNT extends ModEntityTNTBase {
	public EntityMiniNukeTNT(World world, double x, double y, double z, EntityLivingBase igniter, int fuse,
			float explosionStrength, boolean spawnFire, boolean blockDamage) {
		super(world, x, y, z, igniter, fuse, explosionStrength, spawnFire, blockDamage);
	}

	public EntityMiniNukeTNT(World world) {
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
		this.world.newExplosion(this, this.posX + 8, this.posY + (double) (this.height / 16.0F), this.posZ + 8,
				this.explosionStrength, this.spawnFire, this.blockDamage);
		this.world.newExplosion(this, this.posX + 8, this.posY + (double) (this.height / 16.0F), this.posZ - 8,
				this.explosionStrength, this.spawnFire, this.blockDamage);
		this.world.newExplosion(this, this.posX - 8, this.posY + (double) (this.height / 16.0F), this.posZ + 8,
				this.explosionStrength, this.spawnFire, this.blockDamage);
		this.world.newExplosion(this, this.posX - 8, this.posY + (double) (this.height / 16.0F), this.posZ - 8,
				this.explosionStrength, this.spawnFire, this.blockDamage);
		for (int posX2 = (int) this.posX - 20; posX2 < (int) this.posX + 20; ++posX2) {
			for (int posY2 = (int) this.posY - 10; posY2 < (int) this.posY + 10; ++posY2) {
				for (int posZ2 = (int) this.posZ - 20; posZ2 < (int) this.posZ + 20; ++posZ2) {
					BlockPos pos = new BlockPos(posX2, posY2 - 1, posZ2);
					BlockPos pos2 = new BlockPos(posX2, posY2, posZ2);
					Block thisgetblock = getBlock(this.world, posX2, posY2 - 1, posZ2, pos);
					Block thisgetblock2 = getBlock(this.world, posX2, posY2, posZ2, pos2);
					if (thisgetblock == Blocks.AIR || thisgetblock2 != Blocks.AIR)
						continue;
					BlockPos pos3 = new BlockPos(posX2, posY2, posZ2);
					setBlock(this.world, posX2, posY2, posZ2, pos3, (Block) Blocks.FIRE);
				}
			}
		}
	}
}