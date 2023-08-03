package net.thep2wking.oedldoedlexplosives.registry;

import net.thep2wking.oedldoedlcore.util.ModLogger;
import net.thep2wking.oedldoedlexplosives.OedldoedlExplosives;

public class ModRecipes {
	public static void registerOreDict() {
		ModLogger.registeredOreDictLogger(OedldoedlExplosives.MODID);
	}

	public static void registerRecipes() {
		ModLogger.registeredRecipesLogger(OedldoedlExplosives.MODID);
	}
}