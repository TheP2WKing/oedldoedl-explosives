package net.thep2wking.oedldoedlexplosives.content.crazybombs.lolxd;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModBlockRotatableTNTBase;
import net.thep2wking.oedldoedlexplosives.api.ModEntityRotatableTNTBase;

public class BlockLOLXDTNT extends ModBlockRotatableTNTBase {
	public BlockLOLXDTNT(String modid, String name, CreativeTabs tab, SoundType sound, MapColor mapColor,
			int lightLevel) {
		super(modid, name, tab, sound, mapColor, lightLevel);
	}

	@Override
	public ModEntityRotatableTNTBase createRotatableTNTEntity(World world, double x, double y, double z,
			EntityLivingBase ignitor) {
		return new EntityLOLXDTNT(world, x, y, z, ignitor);
	}
}