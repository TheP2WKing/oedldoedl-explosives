package net.thep2wking.oedldoedlexplosives.init;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.passive.EntityPig;
import net.thep2wking.oedldoedlcore.util.ModBiomeUtil;
import net.thep2wking.oedldoedlcore.util.ModLogger;
import net.thep2wking.oedldoedlcore.util.ModRegistryHelper;
import net.thep2wking.oedldoedlexplosives.OedldoedlExplosives;
import net.thep2wking.oedldoedlexplosives.config.ExplosivesConfig;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityAnimalTNT;
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
import net.thep2wking.oedldoedlexplosives.content.entity.EntityEntityFirework;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityFakeTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityFlatTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityFlowerPower;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityGroveTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityHTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityIncenditaryTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityIslandTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityLOLXDTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityLavaTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityMegaNukeTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityMeteorTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityMiniNukeTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityMultiplyTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityNCNuke;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityNapalmTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityNightTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityNukeTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityOver9000TNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityRainbowTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityRandomBlocksTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityTNTFireworkCustomTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntitySirDerpingtonTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntitySnowTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntitySphereTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntitySupersonicTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityTNTFirework;
import net.thep2wking.oedldoedlexplosives.content.entity.EntitySandFirework;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityTNTRain;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityTNTTree;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityTNTx20;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityTNTx5;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityTheP2WKingTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityTrollTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityWoolTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.living.EntityTheP2WKing;
import net.thep2wking.oedldoedlexplosives.content.entity.throwable.EntityAnimalDynamite;
import net.thep2wking.oedldoedlexplosives.content.entity.throwable.EntityCombatDynamite;
import net.thep2wking.oedldoedlexplosives.content.entity.throwable.EntityCubicDynamite;
import net.thep2wking.oedldoedlexplosives.content.entity.throwable.EntityDynamite;
import net.thep2wking.oedldoedlexplosives.content.entity.throwable.EntityDynamiteX20;
import net.thep2wking.oedldoedlexplosives.content.entity.throwable.EntityDynamiteX5;
import net.thep2wking.oedldoedlexplosives.content.entity.throwable.EntityEggsplosive;
import net.thep2wking.oedldoedlexplosives.content.entity.throwable.EntityGrenadeApple;
import net.thep2wking.oedldoedlexplosives.content.entity.throwable.EntityTheP2WKingDynamite;

public class ModEntities {
	public static void registerEntities() {
		ModLogger.registeredEntitiesLogger(OedldoedlExplosives.MODID);

		int id = 0;
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "fake_tnt", OedldoedlExplosives.INSTANCE, id++, EntityFakeTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "combat_tnt", OedldoedlExplosives.INSTANCE, id++, EntityCombatTNT.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "c4", OedldoedlExplosives.INSTANCE, id++, EntityC4.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "tnt_x5", OedldoedlExplosives.INSTANCE, id++, EntityTNTx5.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "tnt_x20", OedldoedlExplosives.INSTANCE, id++, EntityTNTx20.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "drill_tnt", OedldoedlExplosives.INSTANCE, id++, EntityDrillTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "flat_tnt", OedldoedlExplosives.INSTANCE, id++, EntityFlatTNT.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "nuke_tnt", OedldoedlExplosives.INSTANCE, id++, EntityNukeTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "h_tnt", OedldoedlExplosives.INSTANCE, id++, EntityHTNT.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "meteor_tnt", OedldoedlExplosives.INSTANCE, id++, EntityMeteorTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "sphere_tnt", OedldoedlExplosives.INSTANCE, id++, EntitySphereTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "derpy_tnt", OedldoedlExplosives.INSTANCE, id++, EntityDerpyTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "incenditary_tnt", OedldoedlExplosives.INSTANCE, id++, EntityIncenditaryTNT.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "detonator_chain_tnt", OedldoedlExplosives.INSTANCE, id++, EntityDetonatorChainTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "day_tnt", OedldoedlExplosives.INSTANCE, id++, EntityDayTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "night_tnt", OedldoedlExplosives.INSTANCE, id++, EntityNightTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "sir_derpington_tnt", OedldoedlExplosives.INSTANCE, id++, EntitySirDerpingtonTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "tnt_rain", OedldoedlExplosives.INSTANCE, id++, EntityTNTRain.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "napalm_tnt", OedldoedlExplosives.INSTANCE, id++, EntityNapalmTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "island_tnt", OedldoedlExplosives.INSTANCE, id++, EntityIslandTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "wool_tnt", OedldoedlExplosives.INSTANCE, id++, EntityWoolTNT.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "snow_tnt", OedldoedlExplosives.INSTANCE, id++, EntitySnowTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "bundled_tnt", OedldoedlExplosives.INSTANCE, id++, EntityBundledTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "supersonic_tnt", OedldoedlExplosives.INSTANCE, id++, EntitySupersonicTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "rainbow_tnt", OedldoedlExplosives.INSTANCE, id++, EntityRainbowTNT.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "troll_tnt", OedldoedlExplosives.INSTANCE, id++, EntityTrollTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "chunk_tnt", OedldoedlExplosives.INSTANCE, id++, EntityChunkTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "nc_nuke", OedldoedlExplosives.INSTANCE, id++, EntityNCNuke.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "mini_nuke_tnt", OedldoedlExplosives.INSTANCE, id++, EntityMiniNukeTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "mega_nuke_tnt", OedldoedlExplosives.INSTANCE, id++, EntityMegaNukeTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "antimatter_bomb", OedldoedlExplosives.INSTANCE, id++, EntityAntimatterBomb.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "butter_tnt", OedldoedlExplosives.INSTANCE, id++, EntityButterTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "lava_tnt", OedldoedlExplosives.INSTANCE, id++, EntityLavaTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "egg_tnt", OedldoedlExplosives.INSTANCE, id++, EntityEggTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "arrow_tnt", OedldoedlExplosives.INSTANCE, id++, EntityArrowTNT.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "random_blocks_tnt", OedldoedlExplosives.INSTANCE, id++, EntityRandomBlocksTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "crash_tnt", OedldoedlExplosives.INSTANCE, id++, EntityCrashTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "lolxd_tnt", OedldoedlExplosives.INSTANCE, id++, EntityLOLXDTNT.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "tnt_tree", OedldoedlExplosives.INSTANCE, id++, EntityTNTTree.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "configureable_tnt", OedldoedlExplosives.INSTANCE, id++, EntityConfigureableTNT.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "flower_power", OedldoedlExplosives.INSTANCE, id++, EntityFlowerPower.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "cubic_tnt", OedldoedlExplosives.INSTANCE, id++, EntityCubicTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "animal_tnt", OedldoedlExplosives.INSTANCE, id++, EntityAnimalTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "sand_firework", OedldoedlExplosives.INSTANCE, id++, EntitySandFirework.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "tnt_firework", OedldoedlExplosives.INSTANCE, id++, EntityTNTFirework.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "entity_firework", OedldoedlExplosives.INSTANCE, id++, EntityEntityFirework.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "multiply_tnt", OedldoedlExplosives.INSTANCE, id++, EntityMultiplyTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "grove_tnt", OedldoedlExplosives.INSTANCE, id++, EntityGroveTNT.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "over_9000_tnt", OedldoedlExplosives.INSTANCE, id++, EntityOver9000TNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "thep2wking_tnt", OedldoedlExplosives.INSTANCE, id++, EntityTheP2WKingTNT.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "dynamite", OedldoedlExplosives.INSTANCE, id++, EntityDynamite.class, 64, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "dynamite_x5", OedldoedlExplosives.INSTANCE, id++, EntityDynamiteX5.class, 64, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "dynamite_x20", OedldoedlExplosives.INSTANCE, id++, EntityDynamiteX20.class, 64, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "combat_dynamite", OedldoedlExplosives.INSTANCE, id++, EntityCombatDynamite.class, 64, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "cubic_dynamite", OedldoedlExplosives.INSTANCE, id++, EntityCubicDynamite.class, 64, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "animal_dynamite", OedldoedlExplosives.INSTANCE, id++, EntityAnimalDynamite.class, 64, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "thep2wking_dynamite", OedldoedlExplosives.INSTANCE, id++, EntityTheP2WKingDynamite.class, 64, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "eggsplosive", OedldoedlExplosives.INSTANCE, id++, EntityEggsplosive.class, 64, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "grenade_apple", OedldoedlExplosives.INSTANCE, id++, EntityGrenadeApple.class, 64, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "tnt_firework_custom_tnt", OedldoedlExplosives.INSTANCE, id++, EntityTNTFireworkCustomTNT.class, 160, 10, true);
	
		ModRegistryHelper.registerEntityWithSpawnEgg(OedldoedlExplosives.MODID, "thep2wking", OedldoedlExplosives.INSTANCE, id++, EntityTheP2WKing.class, 80, 3, false, 0, 15184386);

		if (ExplosivesConfig.CONTENT.SPAWN_THEP2WKING) {
			ModRegistryHelper.registerEntitySpawn(EntityTheP2WKing.class, EnumCreatureType.CREATURE, 20, 1, 1, ModBiomeUtil.getEntitySpawningBiomes(EnumCreatureType.CREATURE, EntityPig.class));
		}
	}
}