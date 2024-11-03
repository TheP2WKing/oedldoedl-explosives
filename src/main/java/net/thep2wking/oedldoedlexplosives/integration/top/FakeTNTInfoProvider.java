package net.thep2wking.oedldoedlexplosives.integration.top;

import mcjty.theoneprobe.Tools;
import mcjty.theoneprobe.api.ElementAlignment;
import mcjty.theoneprobe.api.IBlockDisplayOverride;
import mcjty.theoneprobe.api.IProbeConfig;
import mcjty.theoneprobe.api.IProbeHitData;
import mcjty.theoneprobe.api.IProbeInfo;
import mcjty.theoneprobe.api.ProbeMode;
import mcjty.theoneprobe.api.TextStyleClass;
import mcjty.theoneprobe.apiimpl.ProbeConfig;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockSilverfish;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.thep2wking.oedldoedlexplosives.content.customtnt.fake.BlockFakeTNT;

public class FakeTNTInfoProvider implements IBlockDisplayOverride {
	@Override
	public boolean overrideStandardInfo(ProbeMode mode, IProbeInfo probeInfo, EntityPlayer player,
			World world, IBlockState blockState, IProbeHitData data) {
		if (blockState.getBlock() instanceof BlockFakeTNT) {
			Block block = Blocks.TNT;
			String modid = Tools.getModName(block);
			ItemStack pickBlock = new ItemStack(Blocks.TNT, 1, 0);
			IProbeConfig config = new ProbeConfig();
			if (block instanceof BlockSilverfish && mode != ProbeMode.DEBUG
					&& !Tools.show(mode, config.getShowSilverfish())) {
				BlockSilverfish.EnumType type = (BlockSilverfish.EnumType) blockState.getValue(BlockSilverfish.VARIANT);
				blockState = type.getModelBlock();
				block = blockState.getBlock();
				pickBlock = new ItemStack(Blocks.TNT, 1, 0);
			}
			if (block instanceof BlockFluidBase || block instanceof BlockLiquid) {
				Fluid fluid = FluidRegistry.lookupFluidForBlock(block);
				if (fluid != null) {
					FluidStack fluidStack = new FluidStack(fluid, 1000);
					ItemStack bucketStack = FluidUtil.getFilledBucket(fluidStack);
					IProbeInfo horizontal = probeInfo.horizontal();
					if (fluidStack.isFluidEqual(FluidUtil.getFluidContained(bucketStack))) {
						horizontal.item(bucketStack);
					} else {
						horizontal.icon(fluid.getStill(), -1, -1, 16, 16, probeInfo.defaultIconStyle().width(20));
					}
					horizontal.vertical().text(TextStyleClass.NAME + fluidStack.getLocalizedName())
							.text(TextStyleClass.MODNAME + modid);
					return true;
				}
			}
			if (!pickBlock.isEmpty()) {
				if (Tools.show(mode, config.getShowModName())) {
					probeInfo.horizontal().item(pickBlock).vertical().itemLabel(pickBlock)
							.text(TextStyleClass.MODNAME + modid);
				} else {
					probeInfo.horizontal(probeInfo.defaultLayoutStyle().alignment(ElementAlignment.ALIGN_CENTER))
							.item(pickBlock).itemLabel(pickBlock);
				}
			} else if (Tools.show(mode, config.getShowModName())) {
				probeInfo.vertical().text(TextStyleClass.NAME + getBlockUnlocalizedName(block))
						.text(TextStyleClass.MODNAME + modid);
			} else {
				probeInfo.vertical().text(TextStyleClass.NAME + getBlockUnlocalizedName(block));
			}
			return true;
		}
		return false;
	}

	private static String getBlockUnlocalizedName(Block block) {
		return "{*" + block.getUnlocalizedName() + ".name" + "*}";
	}
}