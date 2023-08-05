package net.thep2wking.oedldoedlexplosives.content.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModBlockTNTBase;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityC4;

public class BlockC4 extends ModBlockTNTBase {
	public BlockC4(String modid, String name, CreativeTabs tab, SoundType sound, MapColor mapColor, int lightLevel) {
		super(modid, name, tab, sound, mapColor, lightLevel);
	}

	@Override
	public ModEntityTNTBase createTNTEntity(World world, double x, double y, double z, EntityLivingBase ignitor) {
		return new EntityC4(world, x, y, z, ignitor, 1, 4.0f, false, true);
	}

	@Override
	public void onBlockDestroyedByExplosion(World worldIn, BlockPos pos, Explosion explosionIn) {
		if (!worldIn.isRemote) {
			ModEntityTNTBase entitytntprimed = createTNTEntity(worldIn, (double) ((float) pos.getX() + 0.5F),
					(double) pos.getY(), (double) ((float) pos.getZ() + 0.5F), explosionIn.getExplosivePlacedBy());
			entitytntprimed.setFuse(entitytntprimed.getFuse());
			worldIn.spawnEntity(entitytntprimed);
		}
	}
}