package net.thep2wking.oedldoedlexplosives.content.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModBlockTNTBase;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;
import net.thep2wking.oedldoedlexplosives.config.ExplosivesConfig;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityTrollTNT;
import net.thep2wking.oedldoedlexplosives.init.ModBlocks;

public class BlockTrollTNT extends ModBlockTNTBase {
	public BlockTrollTNT(String modid, String name, CreativeTabs tab, SoundType sound, MapColor mapColor,int lightLevel) {
		super(modid, name, tab, sound, mapColor, lightLevel);
	}

	@Override
	public ModEntityTNTBase createTNTEntity(World world, double x, double y, double z, EntityLivingBase ignitor) {
		return new EntityTrollTNT(world, x, y, z, ignitor, 10, 4.0f, false, true);
	}

	@Override
	public boolean removedByPlayer(IBlockState state, World world, BlockPos pos, EntityPlayer player, boolean willHarvest) {
		final boolean removed = super.removedByPlayer(state, world, pos, player, willHarvest);
		if (!player.isCreative() && ExplosivesConfig.CONTENT.TROLL_TNT_MULTIPLY) {
			world.setBlockState(pos, ModBlocks.TROLL_TNT.getDefaultState());
			world.setBlockState(pos.up(), ModBlocks.TROLL_TNT.getDefaultState());
			world.setBlockState(pos.down(), ModBlocks.TROLL_TNT.getDefaultState());
			world.setBlockState(pos.north(), ModBlocks.TROLL_TNT.getDefaultState());
			world.setBlockState(pos.west(), ModBlocks.TROLL_TNT.getDefaultState());
			world.setBlockState(pos.south(), ModBlocks.TROLL_TNT.getDefaultState());
			world.setBlockState(pos.east(), ModBlocks.TROLL_TNT.getDefaultState());
		}
		return removed;
	}
}