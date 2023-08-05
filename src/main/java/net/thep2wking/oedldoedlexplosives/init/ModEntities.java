package net.thep2wking.oedldoedlexplosives.init;

import net.thep2wking.oedldoedlcore.util.ModRegistryHelper;
import net.thep2wking.oedldoedlexplosives.OedldoedlExplosives;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityC4;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityChunkTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityDayTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityDrillTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityFlatTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityNCNuke;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityNightTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityNukeTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntitySirDerpingtonTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityTNTx20;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityTNTx5;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityTrollTNT;

public class ModEntities {
	public static void registerEntities() {
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "c4", OedldoedlExplosives.INSTANCE, 0,
				EntityC4.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "tnt_x5", OedldoedlExplosives.INSTANCE, 1,
				EntityTNTx5.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "tnt_x20", OedldoedlExplosives.INSTANCE, 2,
				EntityTNTx20.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "drill_tnt", OedldoedlExplosives.INSTANCE, 3,
				EntityDrillTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "flat_tnt", OedldoedlExplosives.INSTANCE, 4,
				EntityFlatTNT.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "nuke_tnt", OedldoedlExplosives.INSTANCE, 5,
				EntityNukeTNT.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "day_tnt", OedldoedlExplosives.INSTANCE, 6,
				EntityDayTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "night_tnt", OedldoedlExplosives.INSTANCE, 7,
				EntityNightTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "sir_derpington_tnt", OedldoedlExplosives.INSTANCE,
				8, EntitySirDerpingtonTNT.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "nc_nuke", OedldoedlExplosives.INSTANCE, 100,
				EntityNCNuke.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "troll_tnt", OedldoedlExplosives.INSTANCE, 200,
				EntityTrollTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "chunk_tnt", OedldoedlExplosives.INSTANCE, 300,
				EntityChunkTNT.class, 160, 10, true);
	}
}
