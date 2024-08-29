package net.thep2wking.oedldoedlexplosives.config;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.thep2wking.oedldoedlcore.util.ModReferences;
import net.thep2wking.oedldoedlexplosives.OedldoedlExplosives;
import net.thep2wking.oedldoedlexplosives.config.categories.Content;
import net.thep2wking.oedldoedlexplosives.config.categories.Integration;
import net.thep2wking.oedldoedlexplosives.config.categories.Properties;
import net.thep2wking.oedldoedlexplosives.config.categories.Recipes;

@Config(modid = OedldoedlExplosives.MODID, name = ModReferences.BASE_MODID + "/"
        + OedldoedlExplosives.MODID, category = OedldoedlExplosives.MODID)
public class ExplosivesConfig {
    @Config.Name("content")
    public static final Content CONTENT = new Content();

    @Config.Name("properties")
    public static final Properties PROPERTIES = new Properties();

    @Config.Name("recipes")
    public static final Recipes RECIPES = new Recipes();

    @Config.Name("integration")
    public static final Integration INTEGRATION = new Integration();
    
    @Mod.EventBusSubscriber
    public static class ConfigHolder {
        @SubscribeEvent
        public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
            if (event.getModID().equals(OedldoedlExplosives.MODID)) {
                ConfigManager.sync(OedldoedlExplosives.MODID, Config.Type.INSTANCE);
            }
        }
    }
}