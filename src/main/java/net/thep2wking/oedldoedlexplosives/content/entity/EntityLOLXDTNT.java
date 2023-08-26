package net.thep2wking.oedldoedlexplosives.content.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;
import net.thep2wking.oedldoedlexplosives.config.ExplosivesConfig;

public class EntityLOLXDTNT extends ModEntityTNTBase {
	public EntityLOLXDTNT(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
	}

	public EntityLOLXDTNT(World world) {
		super(world);
	}

	@Override
	public void explode() {
		this.world.newExplosion(this, this.posX, this.posY + (double) (this.height / 16.0F), this.posZ, 0, false,
				false);
		if (ExplosivesConfig.PROPERTIES.NON_STANDARD_EXPLOSION_DAMAGE) {
			this.world.setBlockState(new BlockPos(this.posX, this.posY, this.posZ),
					Blocks.COAL_BLOCK.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX, this.posY + 1.0, this.posZ),
					Blocks.COAL_BLOCK.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX, this.posY + 2.0, this.posZ),
					Blocks.COAL_BLOCK.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX, this.posY + 3.0, this.posZ),
					Blocks.COAL_BLOCK.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 1.0, this.posY, this.posZ),
					Blocks.COAL_BLOCK.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 3.0, this.posY, this.posZ),
					Blocks.COAL_BLOCK.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 3.0, this.posY + 1.0, this.posZ),
					Blocks.COAL_BLOCK.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 3.0, this.posY + 2.0, this.posZ),
					Blocks.COAL_BLOCK.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 3.0, this.posY + 3.0, this.posZ),
					Blocks.COAL_BLOCK.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 4.0, this.posY, this.posZ),
					Blocks.COAL_BLOCK.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 5.0, this.posY, this.posZ),
					Blocks.COAL_BLOCK.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 5.0, this.posY + 1.0, this.posZ),
					Blocks.COAL_BLOCK.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 5.0, this.posY + 2.0, this.posZ),
					Blocks.COAL_BLOCK.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 5.0, this.posY + 3.0, this.posZ),
					Blocks.COAL_BLOCK.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 5.0, this.posY + 3.0, this.posZ),
					Blocks.COAL_BLOCK.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 3.0, this.posY + 3.0, this.posZ),
					Blocks.COAL_BLOCK.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 4.0, this.posY + 3.0, this.posZ),
					Blocks.COAL_BLOCK.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 5.0, this.posY + 3.0, this.posZ),
					Blocks.COAL_BLOCK.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 7.0, this.posY, this.posZ),
					Blocks.COAL_BLOCK.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 7.0, this.posY + 1.0, this.posZ),
					Blocks.COAL_BLOCK.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 7.0, this.posY + 2.0, this.posZ),
					Blocks.COAL_BLOCK.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 7.0, this.posY + 3.0, this.posZ),
					Blocks.COAL_BLOCK.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 8.0, this.posY, this.posZ),
					Blocks.COAL_BLOCK.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 10.0, this.posY, this.posZ),
					Blocks.COAL_BLOCK.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 12.0, this.posY, this.posZ),
					Blocks.COAL_BLOCK.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 11.0, this.posY + 1.0, this.posZ),
					Blocks.COAL_BLOCK.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 10.0, this.posY + 2.0, this.posZ),
					Blocks.COAL_BLOCK.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 12.0, this.posY + 2.0, this.posZ),
					Blocks.COAL_BLOCK.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 14.0, this.posY, this.posZ),
					Blocks.COAL_BLOCK.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 14.0, this.posY + 1.0, this.posZ),
					Blocks.COAL_BLOCK.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 14.0, this.posY + 2.0, this.posZ),
					Blocks.COAL_BLOCK.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 14.0, this.posY + 3.0, this.posZ),
					Blocks.COAL_BLOCK.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 15.0, this.posY, this.posZ),
					Blocks.COAL_BLOCK.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 15.0, this.posY + 3.0, this.posZ),
					Blocks.COAL_BLOCK.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 16.0, this.posY + 2.0, this.posZ),
					Blocks.COAL_BLOCK.getDefaultState());
			this.world.setBlockState(new BlockPos(this.posX + 16.0, this.posY + 1.0, this.posZ),
					Blocks.COAL_BLOCK.getDefaultState());
		}
	}
}