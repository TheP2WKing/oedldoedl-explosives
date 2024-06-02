package net.thep2wking.oedldoedlexplosives.content.item;

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
import net.minecraft.util.math.AxisAlignedBB;
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
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		int radius = ExplosivesConfig.CONTENT.TNT_DISRUPTER_RADIUS;
		if (playerIn.capabilities.isCreativeMode || ExplosivesConfig.CONTENT.TNT_DISRUPTER_USEABLE_IN_SURVIVAL) {
			if (!worldIn.isRemote) {
				List<Entity> tnts = worldIn.getEntitiesWithinAABB(EntityTNTPrimed.class, new AxisAlignedBB(
						playerIn.posX - radius, playerIn.posY - radius, playerIn.posZ - radius,
						playerIn.posX + radius, playerIn.posY + radius, playerIn.posZ + radius));
				for (Entity entity : tnts) {
					if (entity instanceof EntityTNTPrimed && entity != null) {
						entity.setDead();
						worldIn.playSound((EntityPlayer) null, entity.posX, entity.posY, entity.posZ,
								SoundEvents.ENTITY_PLAYER_DEATH, SoundCategory.NEUTRAL, 0.5F, 1.0F);
					}
				}
				List<Entity> dynamites = worldIn.getEntitiesWithinAABB(ModEntityDynamiteBase.class, new AxisAlignedBB(
						playerIn.posX - radius, playerIn.posY - radius, playerIn.posZ - radius,
						playerIn.posX + radius, playerIn.posY + radius, playerIn.posZ + radius));
				for (Entity entity : dynamites) {
					if (entity instanceof ModEntityDynamiteBase && entity != null) {
						entity.setDead();
						worldIn.playSound((EntityPlayer) null, entity.posX, entity.posY, entity.posZ,
								SoundEvents.ENTITY_PLAYER_DEATH, SoundCategory.NEUTRAL, 0.5F, 1.0F);
					}
				}
			}
			playerIn.swingArm(handIn);
			playerIn.addStat(StatList.getObjectUseStats(this));
			return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
		}
		return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);
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