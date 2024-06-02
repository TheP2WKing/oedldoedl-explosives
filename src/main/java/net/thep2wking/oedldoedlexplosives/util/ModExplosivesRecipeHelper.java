package net.thep2wking.oedldoedlexplosives.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.thep2wking.oedldoedlcore.util.ModRecipeHelper;
import net.thep2wking.oedldoedlexplosives.OedldoedlExplosives;

public class ModExplosivesRecipeHelper {
	// dynamites
	public static void addDynamiteRecipe(String name, Item dynamite, String tnt) {
		ModRecipeHelper.addShapelessRecipe(OedldoedlExplosives.MODID, name, new ItemStack(dynamite, 4, 0), tnt);
	}

	public static void addDynamiteRecipe(String name, Item dynamite, Item tnt) {
		ModRecipeHelper.addShapelessRecipe(OedldoedlExplosives.MODID, name, new ItemStack(dynamite, 4, 0),
				new ItemStack(tnt, 1, 0));
	}

	public static void addDynamiteRecipe(String name, Item dynamite, Block tnt) {
		ModRecipeHelper.addShapelessRecipe(OedldoedlExplosives.MODID, name, new ItemStack(dynamite, 4, 0),
				new ItemStack(tnt, 1, 0));
	}
}