package net.thep2wking.oedldoedlexplosives.init;

import net.thep2wking.oedldoedlcore.util.ModRegistryHelper;
import net.thep2wking.oedldoedlexplosives.OedldoedlExplosives;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityAntimatterBomb;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityArrowTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityBundledTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityButterTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityC4;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityChunkTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityCombatTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityConfigureableTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityCrashTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityCubicTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityDayTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityDerpyTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityDetonatorChainTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityDrillTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityEggTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityFakeTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityFlatTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityFlowerPower;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityHTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityIncenditaryTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityIslandTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityLOLXDTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityLavaTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityMegaNukeTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityMeteorTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityMiniNukeTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityNCNuke;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityNapalmTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityNightTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityNukeTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityOver9000TNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityRainbowTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityRandomBlocksTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntitySirDerpingtonTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntitySnowTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntitySphereTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntitySupersonicTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityTNTRain;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityTNTTree;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityTNTx20;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityTNTx5;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityTrollTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityWoolTNT;

public class ModEntities {
	public static void registerEntities() {
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "fake_tnt", OedldoedlExplosives.INSTANCE, 0, EntityFakeTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "combat_tnt", OedldoedlExplosives.INSTANCE, 1, EntityCombatTNT.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "c4", OedldoedlExplosives.INSTANCE, 2, EntityC4.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "tnt_x5", OedldoedlExplosives.INSTANCE, 3, EntityTNTx5.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "tnt_x20", OedldoedlExplosives.INSTANCE, 4, EntityTNTx20.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "drill_tnt", OedldoedlExplosives.INSTANCE, 5, EntityDrillTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "flat_tnt", OedldoedlExplosives.INSTANCE, 6, EntityFlatTNT.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "nuke_tnt", OedldoedlExplosives.INSTANCE, 7, EntityNukeTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "h_tnt", OedldoedlExplosives.INSTANCE, 8, EntityHTNT.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "meteor_tnt", OedldoedlExplosives.INSTANCE, 9, EntityMeteorTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "sphere_tnt", OedldoedlExplosives.INSTANCE, 10, EntitySphereTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "derpy_tnt", OedldoedlExplosives.INSTANCE, 11, EntityDerpyTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "incenditary_tnt", OedldoedlExplosives.INSTANCE, 12, EntityIncenditaryTNT.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "detonator_chain_tnt", OedldoedlExplosives.INSTANCE, 13, EntityDetonatorChainTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "day_tnt", OedldoedlExplosives.INSTANCE, 14, EntityDayTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "night_tnt", OedldoedlExplosives.INSTANCE, 15, EntityNightTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "sir_derpington_tnt", OedldoedlExplosives.INSTANCE, 16, EntitySirDerpingtonTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "tnt_rain", OedldoedlExplosives.INSTANCE, 17, EntityTNTRain.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "napalm_tnt", OedldoedlExplosives.INSTANCE, 18, EntityNapalmTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "island_tnt", OedldoedlExplosives.INSTANCE, 19, EntityIslandTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "wool_tnt", OedldoedlExplosives.INSTANCE, 20, EntityWoolTNT.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "snow_tnt", OedldoedlExplosives.INSTANCE, 21, EntitySnowTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "bundled_tnt", OedldoedlExplosives.INSTANCE, 22, EntityBundledTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "supersonic_tnt", OedldoedlExplosives.INSTANCE, 23, EntitySupersonicTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "rainbow_tnt", OedldoedlExplosives.INSTANCE, 24, EntityRainbowTNT.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "nc_nuke", OedldoedlExplosives.INSTANCE, 25, EntityNCNuke.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "troll_tnt", OedldoedlExplosives.INSTANCE, 26, EntityTrollTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "chunk_tnt", OedldoedlExplosives.INSTANCE, 27, EntityChunkTNT.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "mini_nuke_tnt", OedldoedlExplosives.INSTANCE, 28, EntityMiniNukeTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "mega_nuke_tnt", OedldoedlExplosives.INSTANCE, 29, EntityMegaNukeTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "antimatter_bomb", OedldoedlExplosives.INSTANCE, 30, EntityAntimatterBomb.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "butter_tnt", OedldoedlExplosives.INSTANCE, 31, EntityButterTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "lava_tnt", OedldoedlExplosives.INSTANCE, 32, EntityLavaTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "egg_tnt", OedldoedlExplosives.INSTANCE, 33, EntityEggTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "arrow_tnt", OedldoedlExplosives.INSTANCE, 34, EntityArrowTNT.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "random_blocks_tnt", OedldoedlExplosives.INSTANCE, 35, EntityRandomBlocksTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "crash_tnt", OedldoedlExplosives.INSTANCE, 36, EntityCrashTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "lolxd_tnt", OedldoedlExplosives.INSTANCE, 37, EntityLOLXDTNT.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "tnt_tree", OedldoedlExplosives.INSTANCE, 38, EntityTNTTree.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "configureable_tnt", OedldoedlExplosives.INSTANCE, 39, EntityConfigureableTNT.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "flower_power", OedldoedlExplosives.INSTANCE, 40, EntityFlowerPower.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "cubic_tnt", OedldoedlExplosives.INSTANCE, 41, EntityCubicTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "over_9000_tnt", OedldoedlExplosives.INSTANCE, 42, EntityOver9000TNT.class, 160, 10, true);
	}
}