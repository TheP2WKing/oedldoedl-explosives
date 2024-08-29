package net.thep2wking.oedldoedlexplosives.content.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModBlockTNTBase;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityConfigureableTNT;
import net.thep2wking.oedldoedlexplosives.init.ModItems;

public class BlockConfigureableTNT extends ModBlockTNTBase {
	public static final PropertyInteger SIZE = PropertyInteger.create("size", 0, 11);

	public BlockConfigureableTNT(String modid, String name, CreativeTabs tab, SoundType sound, MapColor mapColor,
			int lightLevel) {
		super(modid, name, tab, sound, mapColor, lightLevel);
		this.setDefaultState(blockState.getBaseState().withProperty(SIZE, Integer.valueOf(0)).withProperty(EXPLODE, Boolean.valueOf(false)));
		//TODO CRASH
	}

	@Override
	public ModEntityTNTBase createTNTEntity(World world, double x, double y, double z, EntityLivingBase ignitor) {
		return new EntityConfigureableTNT(world, x, y, z, ignitor, 80,
				world.getBlockState(new BlockPos(x, y, z)).getValue(SIZE), false, true);
	}

	// @Override
	// public void onBlockExploded(World world, BlockPos pos, Explosion explosion) {
    //     if (!world.isRemote) {
    //         ModEntityTNTBase entitytntprimed = createTNTEntity(world, (double) ((float) pos.getX() + 0.5F),
    //                 (double) pos.getY(), (double) ((float) pos.getZ() + 0.5F), explosion.getExplosivePlacedBy());
    //         entitytntprimed.setFuse(
    //                 (short) (world.rand.nextInt(entitytntprimed.getFuse() / 4) + entitytntprimed.getFuse() / 8));
    //         world.spawnEntity(entitytntprimed);
    //     }
	// }

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		ItemStack itemstack = playerIn.getHeldItem(hand);
		if (!itemstack.isEmpty()) {
			if (itemstack.getItem() == Items.FLINT_AND_STEEL || itemstack.getItem() == Items.FIRE_CHARGE) {
				this.explode(worldIn, pos, state.withProperty(EXPLODE, Boolean.valueOf(true)), playerIn);
				worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 11);
				if (itemstack.getItem() == Items.FLINT_AND_STEEL) {
					itemstack.damageItem(1, playerIn);
				} else if (!playerIn.capabilities.isCreativeMode) {
					itemstack.shrink(1);
				}
				return true;
			}
			if (itemstack.getItem() == ModItems.TNT_WRENCH) {
				int j = state.getValue(SIZE);
				worldIn.setBlockState(pos, state.withProperty(SIZE, Integer.valueOf(j + 1)), 4);
				if (++j >= 11) {
					worldIn.setBlockState(pos, state.withProperty(SIZE, Integer.valueOf(0)), 4);
					j = 0;
				}
				if (j < 0) {
					worldIn.setBlockState(pos, state.withProperty(SIZE, Integer.valueOf(1)), 4);
					j = 1;
				}
				if (!worldIn.isRemote) {
					playerIn.sendMessage(new TextComponentString("Configurable TNT's explosion size set to " + j));
				}
			}
		}
		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(SIZE, Integer.valueOf(meta));
    }

	@Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(SIZE);
    }

    @Override
    public BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] { SIZE, EXPLODE });
    }
}