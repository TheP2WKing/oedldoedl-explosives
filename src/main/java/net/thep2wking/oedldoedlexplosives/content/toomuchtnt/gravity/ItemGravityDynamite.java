package net.thep2wking.oedldoedlexplosives.content.toomuchtnt.gravity;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumRarity;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityDynamiteBase;
import net.thep2wking.oedldoedlexplosives.api.ModItemDynamiteBase;

public class ItemGravityDynamite extends ModItemDynamiteBase {
	public ItemGravityDynamite(String modid, String name, CreativeTabs tab, EnumRarity rarity, boolean hasEffect,
			int tooltipLines, int annotationLines) {
		super(modid, name, tab, rarity, hasEffect, tooltipLines, annotationLines);
	}

	@Override
	public ModEntityDynamiteBase createDynamiteEntity(World world) {
		return new EntityGravityDynamite(world);
	}

	@Override
	public ModEntityDynamiteBase createDynamiteEntity(World world, EntityLivingBase entity) {
		return new EntityGravityDynamite(world, entity);
	}
}