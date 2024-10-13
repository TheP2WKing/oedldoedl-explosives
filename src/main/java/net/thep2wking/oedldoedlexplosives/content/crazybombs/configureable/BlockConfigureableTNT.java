package net.thep2wking.oedldoedlexplosives.content.crazybombs.configureable;

import mcjty.theoneprobe.api.IProbeHitData;
import mcjty.theoneprobe.api.IProbeInfo;
import mcjty.theoneprobe.api.ProbeMode;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlcore.config.CoreConfig;
import net.thep2wking.oedldoedlcore.integration.top.ITOPInfoProvider;
import net.thep2wking.oedldoedlexplosives.OedldoedlExplosives;
import net.thep2wking.oedldoedlexplosives.api.ModBlockTNTBase;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;
import net.thep2wking.oedldoedlexplosives.config.ExplosivesConfig;
import net.thep2wking.oedldoedlexplosives.content.item.ItemTNTWrench;

public class BlockConfigureableTNT extends ModBlockTNTBase implements ITOPInfoProvider {
	public static final PropertyInteger SIZE = PropertyInteger.create("size", 0, 10);

	public BlockConfigureableTNT(String modid, String name, CreativeTabs tab, SoundType sound, MapColor mapColor,
			int lightLevel) {
		super(modid, name, tab, sound, mapColor, lightLevel);
		this.setDefaultState(blockState.getBaseState().withProperty(SIZE, Integer.valueOf(0)).withProperty(EXPLODE,
				Boolean.valueOf(false)));
	}

	@Override
	public BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, SIZE, EXPLODE);
	}

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(SIZE);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(SIZE, meta);
    }

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer,
			ItemStack stack) {
		worldIn.setBlockState(pos, state.withProperty(SIZE, 0), 2);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (!playerIn.isSneaking() && playerIn.getHeldItem(hand).getItem() instanceof ItemTNTWrench) {
			int j = state.getValue(SIZE);
			j = (j + 1) % SIZE.getAllowedValues().size();
			worldIn.setBlockState(pos, state.withProperty(SIZE, j), 4);
			if (!worldIn.isRemote) {
				playerIn.sendMessage(new TextComponentString("Configurable TNT's explosion size set to " + j));
			}
			return true;
		}
		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
	}

	public int getSizeNullSafe(World world, double x, double y, double z) {
		IBlockState state = world.getBlockState(new BlockPos(x, y, z));
		return state.getProperties().containsKey(SIZE) ? state.getValue(SIZE) : 0;
	}

	@Override
	public ModEntityTNTBase createTNTEntity(World world, double x, double y, double z, EntityLivingBase ignitor) {
		return new EntityConfigureableTNT(world, x, y, z, ignitor).setSize(this.getSizeNullSafe(world, x, y, z));
	}

	@Override
	public void addProbeInfo(ProbeMode mode, IProbeInfo probeInfo, EntityPlayer player, World world,
			IBlockState blockState, IProbeHitData data) {
		if (ExplosivesConfig.INTEGRATION.THEONEPROBE.ROTATABLE_TNT_AXIS) {
			int size = blockState.getValue(SIZE);
			String sizeFormatted = TextFormatting.YELLOW + " " + size;
			String key = "top." + OedldoedlExplosives.MODID + ".size";
			probeInfo.text(CoreConfig.TOOLTIPS.COLORS.INFORMATION_ANNOTATION_FORMATTING.getColor() + "{*" + key + "*}"
					+ sizeFormatted);
		}
	}
}