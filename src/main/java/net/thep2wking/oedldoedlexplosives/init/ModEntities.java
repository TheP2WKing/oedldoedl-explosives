package net.thep2wking.oedldoedlexplosives.init;

import net.thep2wking.oedldoedlcore.util.ModRegistryHelper;
import net.thep2wking.oedldoedlexplosives.OedldoedlExplosives;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityChunkTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityNCNuke;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityTrollTNT;

public class ModEntities {
	public static void registerEntities() {
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "nc_nuke", OedldoedlExplosives.INSTANCE, 1,
				EntityNCNuke.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "troll_tnt", OedldoedlExplosives.INSTANCE, 2,
				EntityTrollTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "chunk_tnt", OedldoedlExplosives.INSTANCE, 3,
				EntityChunkTNT.class, 160, 10, true);
	}
}
