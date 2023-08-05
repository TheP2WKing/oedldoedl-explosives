package net.thep2wking.oedldoedlexplosives.content.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModBlockTNTBase;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityNCNuke;
import net.thep2wking.oedldoedlexplosives.init.ModSounds;

public class BlockNCNuke extends ModBlockTNTBase {
	public BlockNCNuke(String modid, String name, CreativeTabs tab, SoundType sound, MapColor mapColor, int lightLevel) {
		super(modid, name, tab, sound, mapColor, lightLevel);
	}

	@Override
	public ModEntityTNTBase createTNTEntity(World world, double x, double y, double z, EntityLivingBase ignitor) {
		return new EntityNCNuke(world, x, y, z, ignitor, 600, 50.0f, true, true);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		return false;
	}

	@Override
	public void onBlockDestroyedByExplosion(World worldIn, BlockPos pos, Explosion explosionIn) {
		if (!worldIn.isRemote) {
			ModEntityTNTBase entitytntprimed = createTNTEntity(worldIn, (double) ((float) pos.getX() + 0.5F),
					(double) pos.getY(), (double) ((float) pos.getZ() + 0.5F), explosionIn.getExplosivePlacedBy());
			entitytntprimed.setFuse(entitytntprimed.getFuse());
			worldIn.spawnEntity(entitytntprimed);
			worldIn.playSound((EntityPlayer) null, pos.getX(), pos.getY(), pos.getZ(), ModSounds.NUKE_ALARM,
					SoundCategory.BLOCKS, 5.0F, 1.0F);
		}
	}

	@Override
	public void explode(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase igniter) {
		if (!worldIn.isRemote) {
			if (((Boolean) state.getValue(EXPLODE)).booleanValue()) {
				ModEntityTNTBase entitytntprimed = createTNTEntity(worldIn, (double) ((float) pos.getX() + 0.5F),
						(double) pos.getY(), (double) ((float) pos.getZ() + 0.5F), igniter);
				worldIn.spawnEntity(entitytntprimed);
				worldIn.playSound((EntityPlayer) null, pos.getX(), pos.getY(), pos.getZ(), ModSounds.NUKE_ALARM,
						SoundCategory.BLOCKS, 5.0F, 1.0F);
			}
		}
	}
}