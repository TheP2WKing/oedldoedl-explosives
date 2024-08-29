package net.thep2wking.oedldoedlexplosives.api;

import mcjty.theoneprobe.api.IProbeHitData;
import mcjty.theoneprobe.api.IProbeInfo;
import mcjty.theoneprobe.api.ProbeMode;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlcore.config.CoreConfig;
import net.thep2wking.oedldoedlcore.integration.top.ITOPInfoProvider;
import net.thep2wking.oedldoedlexplosives.OedldoedlExplosives;
import net.thep2wking.oedldoedlexplosives.config.ExplosivesConfig;
import net.thep2wking.oedldoedlexplosives.content.item.ItemTNTWrench;

public class ModBlockRotatableTNTBase extends ModBlockTNTBase implements ITOPInfoProvider {
	public static final PropertyEnum<EnumFacing.Axis> AXIS = PropertyEnum.create("axis", EnumFacing.Axis.class,
			EnumFacing.Axis.X, EnumFacing.Axis.Z);

	public ModBlockRotatableTNTBase(String modid, String name, CreativeTabs tab, SoundType sound, MapColor mapColor,
			int lightLevel) {
		super(modid, name, tab, sound, mapColor, lightLevel);
		this.setDefaultState(this.blockState.getBaseState().withProperty(AXIS, EnumFacing.Axis.X).withProperty(EXPLODE,
				Boolean.valueOf(false)));
	}

	@Override
	public BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, AXIS, EXPLODE);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		EnumFacing.Axis axis = (meta & 1) == 0 ? EnumFacing.Axis.X : EnumFacing.Axis.Z;
		boolean explode = (meta & 2) != 0;
		return this.getDefaultState().withProperty(AXIS, axis).withProperty(EXPLODE, explode);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		int meta = state.getValue(AXIS) == EnumFacing.Axis.X ? 0 : 1;
		if (state.getValue(EXPLODE)) {
			meta |= 2;
		}
		return meta;
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer,
			ItemStack stack) {
		worldIn.setBlockState(pos, state.withProperty(AXIS, placer.getHorizontalFacing().getAxis()), 2);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (!playerIn.isSneaking() && playerIn.getHeldItem(hand).getItem() instanceof ItemTNTWrench) {
			EnumFacing.Axis currentAxis = state.getValue(AXIS);
			EnumFacing.Axis newAxis = currentAxis == EnumFacing.Axis.X ? EnumFacing.Axis.Z : EnumFacing.Axis.X;
			worldIn.setBlockState(pos, state.withProperty(AXIS, newAxis));
			playerIn.swingArm(hand);
			return true;
		}
		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
	}

	public EnumFacing.Axis getAxisNullSafe(World world, double x, double y, double z) {
		IBlockState state = world.getBlockState(new BlockPos(x, y, z));
		return state.getProperties().containsKey(AXIS) ? state.getValue(AXIS) : EnumFacing.Axis.Z;
	}

	@Override
	public final ModEntityTNTBase createTNTEntity(World world, double x, double y, double z, EntityLivingBase ignitor) {
		return createRotatableTNTEntity(world, x, y, z, ignitor).setAxis(this.getAxisNullSafe(world, x, y, z));
	}

	public ModEntityRotatableTNTBase createRotatableTNTEntity(World world, double x, double y, double z,
			EntityLivingBase ignitor) {
		return new ModEntityRotatableTNTBase(world, x, y, z, ignitor);
	}

	@Override
	public void addProbeInfo(ProbeMode mode, IProbeInfo probeInfo, EntityPlayer player, World world,
			IBlockState blockState, IProbeHitData data) {
		if (ExplosivesConfig.INTEGRATION.THEONEPROBE.ROTATABLE_TNT_AXIS) {
			EnumFacing.Axis axis = blockState.getValue(AXIS);
			String axisFormatted = TextFormatting.YELLOW + " " + axis.getName().toUpperCase();
			String direction = axis == EnumFacing.Axis.X
					? "(" + EnumFacing.EAST.getName() + " / " + EnumFacing.WEST.getName() + ")"
					: "(" + EnumFacing.NORTH.getName() + " / " + EnumFacing.SOUTH.getName() + ")";
			String key = "top." + OedldoedlExplosives.MODID + ".axis";
			probeInfo.text(CoreConfig.TOOLTIPS.COLORS.INFORMATION_ANNOTATION_FORMATTING.getColor() + "{*" + key + "*}"
					+ axisFormatted + " " + direction);
		}
	}
}