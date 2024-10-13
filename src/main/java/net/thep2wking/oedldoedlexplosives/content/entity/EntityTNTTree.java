package net.thep2wking.oedldoedlexplosives.content.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;
import net.thep2wking.oedldoedlexplosives.init.ModBlocks;

public class EntityTNTTree extends ModEntityTNTBase {
	public EntityTNTTree(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
	}

	public EntityTNTTree(World world) {
		super(world);
	}

	@Override
	public void explode() {
		this.world.newExplosion(this, this.posX, this.posY + (double) (this.height / 16.0F), this.posZ, 0, false,
				false);


			// steam
			this.world.setBlockState(new BlockPos(this.posX, this.posY, this.posZ),
					ModBlocks.FAKE_TNT.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX, this.posY + 1, this.posZ),
					ModBlocks.FAKE_TNT.getDefaultState());

			// first leaf layer
			this.world.setBlockState(new BlockPos(this.posX, this.posY + 2, this.posZ),
					ModBlocks.FAKE_TNT.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 1, this.posY + 2, this.posZ),
					ModBlocks.FAKE_TNT.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 2, this.posY + 2, this.posZ),
					ModBlocks.FAKE_TNT.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX - 1, this.posY + 2, this.posZ),
					ModBlocks.FAKE_TNT.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX - 2, this.posY + 2, this.posZ),
					ModBlocks.FAKE_TNT.getDefaultState());

			this.world.setBlockState(new BlockPos(this.posX, this.posY + 2, this.posZ + 1),
					ModBlocks.FAKE_TNT.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 1, this.posY + 2, this.posZ + 1),
					ModBlocks.FAKE_TNT.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 2, this.posY + 2, this.posZ + 1),
					ModBlocks.FAKE_TNT.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX - 1, this.posY + 2, this.posZ + 1),
					ModBlocks.FAKE_TNT.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX - 2, this.posY + 2, this.posZ + 1),
					ModBlocks.FAKE_TNT.getDefaultState());

			this.world.setBlockState(new BlockPos(this.posX, this.posY + 2, this.posZ - 1),
					ModBlocks.FAKE_TNT.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 1, this.posY + 2, this.posZ - 1),
					ModBlocks.FAKE_TNT.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 2, this.posY + 2, this.posZ - 1),
					ModBlocks.FAKE_TNT.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX - 1, this.posY + 2, this.posZ - 1),
					ModBlocks.FAKE_TNT.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX - 2, this.posY + 2, this.posZ - 1),
					ModBlocks.FAKE_TNT.getDefaultState());

			this.world.setBlockState(new BlockPos(this.posX, this.posY + 2, this.posZ + 2),
					ModBlocks.FAKE_TNT.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 1, this.posY + 2, this.posZ + 2),
					ModBlocks.FAKE_TNT.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX - 1, this.posY + 2, this.posZ + 2),
					ModBlocks.FAKE_TNT.getDefaultState());

			this.world.setBlockState(new BlockPos(this.posX, this.posY + 2, this.posZ - 2),
					ModBlocks.FAKE_TNT.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 1, this.posY + 2, this.posZ - 2),
					ModBlocks.FAKE_TNT.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX - 1, this.posY + 2, this.posZ - 2),
					ModBlocks.FAKE_TNT.getDefaultState());

			// second leaf layer
			this.world.setBlockState(new BlockPos(this.posX, this.posY + 3, this.posZ),
					ModBlocks.FAKE_TNT.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 1, this.posY + 3, this.posZ),
					ModBlocks.FAKE_TNT.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 2, this.posY + 3, this.posZ),
					ModBlocks.FAKE_TNT.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX - 1, this.posY + 3, this.posZ),
					ModBlocks.FAKE_TNT.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX - 2, this.posY + 3, this.posZ),
					ModBlocks.FAKE_TNT.getDefaultState());

			this.world.setBlockState(new BlockPos(this.posX, this.posY + 3, this.posZ + 1),
					ModBlocks.FAKE_TNT.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 1, this.posY + 3, this.posZ + 1),
					ModBlocks.FAKE_TNT.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 2, this.posY + 3, this.posZ + 1),
					ModBlocks.FAKE_TNT.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX - 1, this.posY + 3, this.posZ + 1),
					ModBlocks.FAKE_TNT.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX - 2, this.posY + 3, this.posZ + 1),
					ModBlocks.FAKE_TNT.getDefaultState());

			this.world.setBlockState(new BlockPos(this.posX, this.posY + 3, this.posZ - 1),
					ModBlocks.FAKE_TNT.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 1, this.posY + 3, this.posZ - 1),
					ModBlocks.FAKE_TNT.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 2, this.posY + 3, this.posZ - 1),
					ModBlocks.FAKE_TNT.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX - 1, this.posY + 3, this.posZ - 1),
					ModBlocks.FAKE_TNT.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX - 2, this.posY + 3, this.posZ - 1),
					ModBlocks.FAKE_TNT.getDefaultState());

			this.world.setBlockState(new BlockPos(this.posX, this.posY + 3, this.posZ + 2),
					ModBlocks.FAKE_TNT.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 1, this.posY + 3, this.posZ + 2),
					ModBlocks.FAKE_TNT.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX - 1, this.posY + 3, this.posZ + 2),
					ModBlocks.FAKE_TNT.getDefaultState());

			this.world.setBlockState(new BlockPos(this.posX, this.posY + 3, this.posZ - 2),
					ModBlocks.FAKE_TNT.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 1, this.posY + 3, this.posZ - 2),
					ModBlocks.FAKE_TNT.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX - 1, this.posY + 3, this.posZ - 2),
					ModBlocks.FAKE_TNT.getDefaultState());

			// third leaf layer
			this.world.setBlockState(new BlockPos(this.posX, this.posY + 4, this.posZ),
					ModBlocks.FAKE_TNT.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 1, this.posY + 4, this.posZ),
					ModBlocks.FAKE_TNT.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX - 1, this.posY + 4, this.posZ),
					ModBlocks.FAKE_TNT.getDefaultState());

			this.world.setBlockState(new BlockPos(this.posX, this.posY + 4, this.posZ + 1),
					ModBlocks.FAKE_TNT.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 1, this.posY + 4, this.posZ + 1),
					ModBlocks.FAKE_TNT.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX - 1, this.posY + 4, this.posZ + 1),
					ModBlocks.FAKE_TNT.getDefaultState());

			this.world.setBlockState(new BlockPos(this.posX, this.posY + 4, this.posZ - 1),
					ModBlocks.FAKE_TNT.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 1, this.posY + 4, this.posZ - 1),
					ModBlocks.FAKE_TNT.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX - 1, this.posY + 4, this.posZ - 1),
					ModBlocks.FAKE_TNT.getDefaultState());

			// fourth leaf layer
			this.world.setBlockState(new BlockPos(this.posX, this.posY + 5, this.posZ),
					ModBlocks.FAKE_TNT.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 1, this.posY + 5, this.posZ),
					ModBlocks.FAKE_TNT.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX - 1, this.posY + 5, this.posZ),
					ModBlocks.FAKE_TNT.getDefaultState());

			this.world.setBlockState(new BlockPos(this.posX, this.posY + 5, this.posZ + 1),
					ModBlocks.FAKE_TNT.getDefaultState());

			this.world.setBlockState(new BlockPos(this.posX, this.posY + 5, this.posZ - 1),
					ModBlocks.FAKE_TNT.getDefaultState());
		
	}
}