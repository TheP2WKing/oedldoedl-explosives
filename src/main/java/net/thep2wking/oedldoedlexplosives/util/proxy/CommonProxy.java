package net.thep2wking.oedldoedlexplosives.util.proxy;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.thep2wking.oedldoedlcore.util.ModLogger;
import net.thep2wking.oedldoedlexplosives.OedldoedlExplosives;
import net.thep2wking.oedldoedlexplosives.integration.top.TOPCompatibility;

public class CommonProxy {
	public void preInit(FMLPreInitializationEvent event) {
	}

	public void init(FMLInitializationEvent event) {
		if (Loader.isModLoaded("theoneprobe")) {
			ModLogger.registeredIntegration("TheOneProbe", OedldoedlExplosives.MODID);
			TOPCompatibility.register();
		}
	}

	public void postInit(FMLPostInitializationEvent event) {
	}

	public void render() {
	}
}