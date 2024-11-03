package net.thep2wking.oedldoedlexplosives.content.misc;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlcore.api.item.ModItemBase;
import net.thep2wking.oedldoedlexplosives.OedldoedlExplosives;
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
			playerIn.swingArm(handIn);
			playerIn.addStat(StatList.getObjectUseStats(this));
			TextComponentTranslation crashMessage = new TextComponentTranslation(
					this.getUnlocalizedName() + ".runtime_exception");
			throw new RuntimeException("[" + OedldoedlExplosives.NAME + "] " + crashMessage.getUnformattedText());
		}
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
	}
}