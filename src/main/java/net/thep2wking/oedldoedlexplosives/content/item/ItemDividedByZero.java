package net.thep2wking.oedldoedlexplosives.content.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.thep2wking.oedldoedlcore.api.item.ModItemBase;
import net.thep2wking.oedldoedlcore.util.ModLogger;
import net.thep2wking.oedldoedlexplosives.config.ExplosivesConfig;

public class ItemDividedByZero extends ModItemBase {
	public ItemDividedByZero(String modid, String name, CreativeTabs tab, EnumRarity rarity, boolean hasEffect,
			int tooltipLines, int annotationLines) {
		super(modid, name, tab, rarity, hasEffect, tooltipLines, annotationLines);
		setMaxStackSize(1);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		if (ExplosivesConfig.CONTENT.INTENDED_GAME_CRASHING) {
			ModLogger.LOGGER.warn(">>>>>>>> THIS CRASH IS INTENDED! <<<<<<<<");
			FMLCommonHandler.instance().exitJava(0, true);
		}
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
	}
}