package net.thep2wking.oedldoedlexplosives.init;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.thep2wking.oedldoedlexplosives.OedldoedlExplosives;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;
import net.thep2wking.oedldoedlexplosives.content.ModEntityTest;

public class ModEntities {
	public static void registerEntities() {
		EntityRegistry.registerModEntity(new ResourceLocation(OedldoedlExplosives.MODID, "test_tnt"),
				ModEntityTest.class, OedldoedlExplosives.MODID + "." + "test_tnt", 1, OedldoedlExplosives.INSTANCE,
				160, 10,
				true);
	}
}
