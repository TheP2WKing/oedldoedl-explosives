package net.thep2wking.oedldoedlexplosives.init;

import net.thep2wking.oedldoedlcore.util.ModRegistryHelper;
import net.thep2wking.oedldoedlexplosives.OedldoedlExplosives;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityAntimatterBomb;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityArrowTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityBundledTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityButterTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityC4;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityChunkTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityCrashTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityDayTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityDetonatorChainTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityDrillTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityEggTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityFlatTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityHTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityIslandTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityLOLXDTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityLavaTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityMegaNukeTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityNCNuke;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityNapalmTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityNightTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityNukeTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityRainbowTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityRandomBlocksTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntitySirDerpingtonTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntitySnowTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntitySupersonicTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityTNTRain;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityTNTx20;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityTNTx5;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityTrollTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityWoolTNT;

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
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "h_tnt", OedldoedlExplosives.INSTANCE, 55,
				EntityHTNT.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "detonator_chain_tnt", OedldoedlExplosives.INSTANCE,
				6, EntityDetonatorChainTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "day_tnt", OedldoedlExplosives.INSTANCE, 7,
				EntityDayTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "night_tnt", OedldoedlExplosives.INSTANCE, 8,
				EntityNightTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "sir_derpington_tnt", OedldoedlExplosives.INSTANCE,
				9, EntitySirDerpingtonTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "tnt_rain", OedldoedlExplosives.INSTANCE,
				99, EntityTNTRain.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "napalm_tnt", OedldoedlExplosives.INSTANCE,
				999, EntityNapalmTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "island_tnt", OedldoedlExplosives.INSTANCE,
				998, EntityIslandTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "wool_tnt", OedldoedlExplosives.INSTANCE,
				898, EntityWoolTNT.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "snow_tnt", OedldoedlExplosives.INSTANCE,
				796, EntitySnowTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "bundled_tnt", OedldoedlExplosives.INSTANCE,
				797, EntityBundledTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "supersonic_tnt", OedldoedlExplosives.INSTANCE,
				798, EntitySupersonicTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "rainbow_tnt", OedldoedlExplosives.INSTANCE,
				799, EntityRainbowTNT.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "nc_nuke", OedldoedlExplosives.INSTANCE, 100,
				EntityNCNuke.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "troll_tnt", OedldoedlExplosives.INSTANCE, 200,
				EntityTrollTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "chunk_tnt", OedldoedlExplosives.INSTANCE, 300,
				EntityChunkTNT.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "mega_nuke_tnt", OedldoedlExplosives.INSTANCE, 299,
				EntityMegaNukeTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "antimatter_bomb", OedldoedlExplosives.INSTANCE,
				298, EntityAntimatterBomb.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "butter_tnt", OedldoedlExplosives.INSTANCE, 301,
				EntityButterTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "lava_tnt", OedldoedlExplosives.INSTANCE, 302,
				EntityLavaTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "egg_tnt", OedldoedlExplosives.INSTANCE, 303,
				EntityEggTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "arrow_tnt", OedldoedlExplosives.INSTANCE, 304,
				EntityArrowTNT.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "random_blocks_tnt", OedldoedlExplosives.INSTANCE,
				310, EntityRandomBlocksTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "crash_tnt", OedldoedlExplosives.INSTANCE, 311,
				EntityCrashTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "lolxd_tnt", OedldoedlExplosives.INSTANCE, 312,
				EntityLOLXDTNT.class, 160, 10, true);
	}
}