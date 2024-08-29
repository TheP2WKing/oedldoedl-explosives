package net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.rainbow;

import java.util.Collections;
import java.util.List;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import net.thep2wking.oedldoedlcore.api.block.ModBlockBase;
import net.thep2wking.oedldoedlcore.util.ModRegistryHelper;
import net.thep2wking.oedldoedlcore.util.ModToolTypes;

public class BlockRainbow extends ModBlockBase implements IShearable {
	public BlockRainbow(String modid, String name, CreativeTabs tab, Material material, SoundType sound,
			MapColor mapColor, int harvestLevel, ModToolTypes toolType, float hardness, float resistance,
			int lightLevel) {
		super(modid, name, tab, material, sound, mapColor, harvestLevel, toolType, hardness, resistance, lightLevel);
		ModRegistryHelper.registerFlameableBlock(this, 30, 60);
	}

	@Override
	public boolean isFlammable(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return true;
	}

	@Override
	public boolean isShearable(ItemStack item, IBlockAccess world, BlockPos pos) {
		return true;
	}

    @Override
    public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
        return Collections.singletonList(new ItemStack(this));
    }
	
    @SuppressWarnings("deprecation")
	@Override
    public float getPlayerRelativeBlockHardness(IBlockState state, EntityPlayer player, World world, BlockPos pos) {
        ItemStack stack = player.getHeldItemMainhand();
        if (stack.getItem() instanceof ItemShears) {
            return 0.2F;
        }
        return super.getPlayerRelativeBlockHardness(state, player, world, pos);
    }
}