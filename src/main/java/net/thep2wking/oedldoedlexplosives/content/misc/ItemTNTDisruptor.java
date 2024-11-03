package net.thep2wking.oedldoedlexplosives.content.misc;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.oedldoedlcore.api.item.ModItemBase;
import net.thep2wking.oedldoedlcore.config.CoreConfig;
import net.thep2wking.oedldoedlcore.util.ModTooltips;
import net.thep2wking.oedldoedlexplosives.api.ModEntityDynamiteBase;
import net.thep2wking.oedldoedlexplosives.config.ExplosivesConfig;

public class ItemTNTDisruptor extends ModItemBase {
	public ItemTNTDisruptor(String modid, String name, CreativeTabs tab, EnumRarity rarity, boolean hasEffect,
			int tooltipLines, int annotationLines) {
		super(modid, name, tab, rarity, hasEffect, tooltipLines, annotationLines);
		setMaxStackSize(1);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack stack = playerIn.getHeldItem(handIn);
		if (playerIn.capabilities.isCreativeMode || ExplosivesConfig.CONTENT.TNT_DISRUPTER_USEABLE_IN_SURVIVAL) {
			if (!worldIn.isRemote) {
				int removedCount = 0;
				List<EntityTNTPrimed> tnts = worldIn.getEntities(EntityTNTPrimed.class, entity -> entity != null);
				for (Entity entity : tnts) {
					if (entity instanceof EntityTNTPrimed && entity != null) {
						entity.setDead();
						removedCount++;
						worldIn.playSound((EntityPlayer) null, entity.posX, entity.posY, entity.posZ,
								SoundEvents.ENTITY_PLAYER_DEATH, SoundCategory.NEUTRAL, 0.5F, 1.0F);
					}
				}
				List<ModEntityDynamiteBase> dynamites = worldIn.getEntities(ModEntityDynamiteBase.class,
						entity -> entity != null);
				for (Entity entity : dynamites) {
					if (entity instanceof ModEntityDynamiteBase && entity != null) {
						entity.setDead();
						removedCount++;
						worldIn.playSound((EntityPlayer) null, entity.posX, entity.posY, entity.posZ,
								SoundEvents.ENTITY_PLAYER_DEATH, SoundCategory.NEUTRAL, 0.5F, 1.0F);
					}
				}
				ModTooltips.sendItemInfoChatComponent(playerIn, stack,
						removedCount + " "
								+ new TextComponentTranslation(this.getUnlocalizedName() + ".tip3").getFormattedText(),
						TextFormatting.RED);
			}
			playerIn.swingArm(handIn);
			playerIn.addStat(StatList.getObjectUseStats(this));
			return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
		}
		return new ActionResult<ItemStack>(EnumActionResult.FAIL, stack);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		if (ModTooltips.showAnnotationTip()) {
			tooltip.add(CoreConfig.TOOLTIPS.COLORS.INFORMATION_ANNOTATION_FORMATTING.getColor()
					+ I18n.format(this.getUnlocalizedName() + ".annotation1") + " " + TextFormatting.YELLOW
					+ (ExplosivesConfig.CONTENT.TNT_DISRUPTER_USEABLE_IN_SURVIVAL
							? I18n.format(this.getUnlocalizedName() + ".annotation2")
							: I18n.format(this.getUnlocalizedName() + ".annotation3")));
		}
		if (ModTooltips.showInfoTip()) {
			for (int i = 1; i <= tooltipLines; ++i) {
				ModTooltips.addInformation(tooltip, this.getUnlocalizedName(), i);
			}
		} else if (ModTooltips.showInfoTipKey() && !(tooltipLines == 0)) {
			ModTooltips.addKey(tooltip, ModTooltips.KEY_INFO);
		}
	}
}