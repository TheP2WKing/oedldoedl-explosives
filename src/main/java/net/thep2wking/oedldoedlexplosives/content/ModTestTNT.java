package net.thep2wking.oedldoedlexplosives.content;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModBlockTNTBase;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;

public class ModTestTNT extends ModBlockTNTBase {

	public ModTestTNT(String modid, String name, CreativeTabs tab, SoundType sound, MapColor mapColor, int lightLevel) {
		super(modid, name, tab, sound, mapColor, lightLevel);
	}

	

	@Override
	public ModEntityTNTBase create(World world, double x, double y, double z, EntityLivingBase ignitor) {
		return new ModEntityTest(world, x, y, z, ignitor);
		
	}
	
}
