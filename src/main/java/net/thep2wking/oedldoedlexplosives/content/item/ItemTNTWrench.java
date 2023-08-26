package net.thep2wking.oedldoedlexplosives.content.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockTNT;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlcore.api.item.ModItemBase;
import net.thep2wking.oedldoedlexplosives.api.ModBlockTNTBase;
import net.thep2wking.oedldoedlexplosives.config.ExplosivesConfig;

public class ItemTNTWrench extends ModItemBase {
	public ItemTNTWrench(String modid, String name, CreativeTabs tab, EnumRarity rarity, boolean hasEffect,
			int tooltipLines, int annotationLines) {
		super(modid, name, tab, rarity, hasEffect, tooltipLines, annotationLines);
		setMaxStackSize(1);
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) {
		IBlockState state = world.getBlockState(pos);
		Block block = state.getBlock();
		if (block instanceof ModBlockTNTBase || block instanceof BlockTNT) {
			if (!world.isRemote && player.isSneaking() && ExplosivesConfig.CONTENT.TNT_WRENCH_DISARM) {
				world.destroyBlock(pos, false);
				if (!player.capabilities.isCreativeMode) {
					world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(),
							new ItemStack(Item.getItemFromBlock(block))));
				}
			}
			return EnumActionResult.SUCCESS;
		}
		return EnumActionResult.FAIL;
	}
}