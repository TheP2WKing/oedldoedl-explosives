package net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.nuke;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModBlockTNTBase;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;

public class BlockNukeTNT extends ModBlockTNTBase {
	public BlockNukeTNT(String modid, String name, CreativeTabs tab, SoundType sound, MapColor mapColor,
			int lightLevel) {
		super(modid, name, tab, sound, mapColor, lightLevel);
	}

	@Override
	public ModEntityTNTBase createTNTEntity(World world, double x, double y, double z, EntityLivingBase ignitor) {
		return new EntityNukeTNT(world, x, y, z, ignitor);
	}
}