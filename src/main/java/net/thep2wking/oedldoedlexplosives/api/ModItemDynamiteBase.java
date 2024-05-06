package net.thep2wking.oedldoedlexplosives.api;

import net.minecraft.block.BlockDispenser;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlcore.api.item.ModItemBase;

/**
 * @author TheP2WKing
 */
public class ModItemDynamiteBase extends ModItemBase {
	public ModItemDynamiteBase(String modid, String name, CreativeTabs tab, EnumRarity rarity, boolean hasEffect,
			int tooltipLines, int annotationLines) {
		super(modid, name, tab, rarity, hasEffect, tooltipLines, annotationLines);
		BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(this, new IBehaviorDispenseItem() {
			@Override
			public ItemStack dispense(IBlockSource source, ItemStack stack) {
				World world = source.getWorld();
				IPosition iposition = BlockDispenser.getDispensePosition(source);
				EnumFacing enumfacing = (EnumFacing) source.getBlockState().getValue(BlockDispenser.FACING);
				ModEntityDynamiteBase entitydynamite = createDispenseEntity(world, iposition.getX(), iposition.getY(),
						iposition.getZ());
				entitydynamite.shoot(enumfacing.getFrontOffsetX(), (float) enumfacing.getFrontOffsetY() + 0.1F,
						enumfacing.getFrontOffsetZ(), 1.1F, 6.0F);
				world.spawnEntity(entitydynamite);
				world.playSound(null, iposition.getX(), iposition.getY(), iposition.getZ(),
						SoundEvents.ENTITY_EGG_THROW, SoundCategory.NEUTRAL, 0.5F,
						0.4F / (world.rand.nextFloat() * 0.4F + 0.8F));
				stack.shrink(1);
				return stack;
			}
		});
	}

	public ModEntityDynamiteBase createDynamiteEntity(World world, EntityLivingBase entity) {
		return new ModEntityDynamiteBase(world, entity);
	}

	public ModEntityDynamiteBase createDynamiteEntity(World world) {
		return new ModEntityDynamiteBase(world);
	}

	public ModEntityDynamiteBase createDispenseEntity(World world, double x, double y, double z) {
		ModEntityDynamiteBase entity = this.createDynamiteEntity(world);
		entity.setPosition(x, y, z);
		return entity;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		if (!playerIn.capabilities.isCreativeMode) {
			itemstack.shrink(1);
		}
		worldIn.playSound((EntityPlayer) null, playerIn.posX, playerIn.posY, playerIn.posZ,
				SoundEvents.ENTITY_EGG_THROW, SoundCategory.NEUTRAL, 0.5F,
				0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

		if (!worldIn.isRemote) {
			ModEntityDynamiteBase entity = this.createDynamiteEntity(worldIn, playerIn);
			entity.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
			worldIn.spawnEntity(entity);
		}
		playerIn.swingArm(handIn);
		playerIn.addStat(StatList.getObjectUseStats(this));
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
	}
}