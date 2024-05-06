package net.thep2wking.oedldoedlexplosives.content.toomuchtnt.x2000;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumRarity;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityDynamiteBase;
import net.thep2wking.oedldoedlexplosives.api.ModItemDynamiteBase;

public class ItemDynamiteX2000 extends ModItemDynamiteBase {
	public ItemDynamiteX2000(String modid, String name, CreativeTabs tab, EnumRarity rarity, boolean hasEffect,
			int tooltipLines, int annotationLines) {
		super(modid, name, tab, rarity, hasEffect, tooltipLines, annotationLines);
	}

	@Override
	public ModEntityDynamiteBase createDynamiteEntity(World world) {
		return new EntityDynamiteX2000(world);
	}

	@Override
	public ModEntityDynamiteBase createDynamiteEntity(World world, EntityLivingBase entity) {
		return new EntityDynamiteX2000(world, entity);
	}
}