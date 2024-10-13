package net.thep2wking.oedldoedlexplosives.init;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.passive.EntityPig;
import net.thep2wking.oedldoedlcore.util.ModLogger;
import net.thep2wking.oedldoedlcore.util.ModRegistryHelper;
import net.thep2wking.oedldoedlcore.util.world.ModBiomeUtil;
import net.thep2wking.oedldoedlexplosives.OedldoedlExplosives;
import net.thep2wking.oedldoedlexplosives.config.ExplosivesConfig;
import net.thep2wking.oedldoedlexplosives.content.crazybombs.antimatter.EntityAntimatterBomb;
import net.thep2wking.oedldoedlexplosives.content.crazybombs.arrow.EntityArrowTNTCb;
import net.thep2wking.oedldoedlexplosives.content.crazybombs.butter.EntityButterTNT;
import net.thep2wking.oedldoedlexplosives.content.crazybombs.configureable.EntityConfigureableTNT;
import net.thep2wking.oedldoedlexplosives.content.crazybombs.crash.EntityCrashTNT;
import net.thep2wking.oedldoedlexplosives.content.crazybombs.egg.EntityEggTNT;
import net.thep2wking.oedldoedlexplosives.content.crazybombs.island.EntityIslandTNTCb;
import net.thep2wking.oedldoedlexplosives.content.crazybombs.lava.EntityLavaTNT;
import net.thep2wking.oedldoedlexplosives.content.crazybombs.lolxd.EntityLOLXDTNT;
import net.thep2wking.oedldoedlexplosives.content.crazybombs.meganuke.EntityMegaNukeTNT;
import net.thep2wking.oedldoedlexplosives.content.crazybombs.nuke.EntityNukeTNTCb;
import net.thep2wking.oedldoedlexplosives.content.crazybombs.randomblocks.EntityRandomBlocksTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityCombatTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityEntityFirework;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityFakeTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityFlowerPower;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityNCNuke;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityOver9000TNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityTNTTree;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityTheP2WKingTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.living.EntityGiantTheP2WKing;
import net.thep2wking.oedldoedlexplosives.content.entity.living.EntityTheP2WKing;
import net.thep2wking.oedldoedlexplosives.content.entity.throwable.EntityCombatDynamite;
import net.thep2wking.oedldoedlexplosives.content.entity.throwable.EntityEggsplosive;
import net.thep2wking.oedldoedlexplosives.content.entity.throwable.EntityGrenadeApple;
import net.thep2wking.oedldoedlexplosives.content.entity.throwable.EntityTheP2WKingDynamite;
import net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.bundled.EntityBundledTNT;
import net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.c4.EntityC4;
import net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.chunk.EntityChunkTNT;
import net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.day.EntityDayTNT;
import net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.derpy.EntityDerpyTNT;
import net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.detonatorchain.EntityDetonatorChainTNT;
import net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.drill.EntityDrillTNT;
import net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.flat.EntityFlatTNTEpp;
import net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.h.EntityHTNT;
import net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.incenditary.EntityIncenditaryTNT;
import net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.island.EntityIslandTNT;
import net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.meteor.EntityMeteorEpp;
import net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.meteor.EntityMeteorTNTEpp;
import net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.napalm.EntityNapalmTNT;
import net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.night.EntityNightTNT;
import net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.rain.EntityTNTRain;
import net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.rainbow.EntityRainbowTNT;
import net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.sirderpington.EntitySirDerpington;
import net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.snow.EntitySnowTNT;
import net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.sphere.EntitySphereTNTEpp;
import net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.supersonic.EntitySupersonicTNT;
import net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.troll.EntityTrollTNT;
import net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.wool.EntityWoolTNT;
import net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.x20.EntityTNTX20Epp;
import net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.x5.EntityTNTX5Epp;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.animal.EntityAnimalDynamite;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.animal.EntityAnimalTNT;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.compact.EntityCompactDynamite;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.compact.EntityCompactTNT;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.cubic.EntityCubicDynamite;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.cubic.EntityCubicTNT;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.digging.EntityDiggingDynamite;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.digging.EntityDiggingTNT;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.drilling.EntityDrillingDynamite;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.drilling.EntityDrillingTNT;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.easteregg.EntityEasterEgg;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.easteregg.EntityEasterEggDynamite;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.easteregg.EntityEasterEggImpact;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.ender.EntityEnderDynamite;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.ender.EntityEnderTNT;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.flat.EntityFlatDynamite;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.flat.EntityFlatTNT;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.gravelfirework.EntityGravelFirework;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.gravelfirework.EntityGravelFireworkDynamite;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.gravity.EntityGravityDynamite;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.gravity.EntityGravityTNT;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.grove.EntityGroveDynamite;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.grove.EntityGroveTNT;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.lightning.EntityLightningDynamate;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.lightning.EntityLightningTNT;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.miningflat.EntityMiningFlatDynamite;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.miningflat.EntityMiningFlatTNT;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.multiply.EntityMultiplyDynamite;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.multiply.EntityMultiplyTNT;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.sandfirework.EntitySandFirework;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.sandfirework.EntitySandFireworkDynamite;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.tnt.EntityDynamite;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.tntfirework.EntityDynamiteFirework;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.tntfirework.EntityTNTFirework;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.tntfirework.EntityTNTFireworkImpact;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.vaporize.EntityVaporizeDynamite;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.vaporize.EntityVaporizeTNT;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.x100.EntityDynamiteX100;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.x100.EntityTNTX100;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.x20.EntityDynamiteX20;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.x20.EntityTNTX20;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.x2000.EntityDynamiteX2000;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.x2000.EntityTNTX2000;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.x5.EntityDynamiteX5;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.x5.EntityTNTX5;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.x500.EntityDynamiteX500;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.x500.EntityTNTX500;

public class ModEntities {
	public static void registerEntities() {
		ModLogger.registeredEntitiesLogger(OedldoedlExplosives.MODID);

		int id = 0;
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "fake_tnt", OedldoedlExplosives.INSTANCE, id++, EntityFakeTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "combat_tnt", OedldoedlExplosives.INSTANCE, id++, EntityCombatTNT.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "tnt_x5_epp", OedldoedlExplosives.INSTANCE, id++, EntityTNTX5Epp.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "tnt_x20_epp", OedldoedlExplosives.INSTANCE, id++, EntityTNTX20Epp.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "c4", OedldoedlExplosives.INSTANCE, id++, EntityC4.class, 160, 10, true);
		
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "drill_tnt", OedldoedlExplosives.INSTANCE, id++, EntityDrillTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "flat_tnt_epp", OedldoedlExplosives.INSTANCE, id++, EntityFlatTNTEpp.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "nuke_tnt", OedldoedlExplosives.INSTANCE, id++, EntityNukeTNTCb.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "meteor_tnt_epp", OedldoedlExplosives.INSTANCE, id++, EntityMeteorTNTEpp.class, 160, 10, true);
		
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "detonator_chain_tnt", OedldoedlExplosives.INSTANCE, id++, EntityDetonatorChainTNT.class, 160, 10, true);
		
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "day_tnt", OedldoedlExplosives.INSTANCE, id++, EntityDayTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "night_tnt", OedldoedlExplosives.INSTANCE, id++, EntityNightTNT.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "sphere_tnt_epp", OedldoedlExplosives.INSTANCE, id++, EntitySphereTNTEpp.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "h_tnt", OedldoedlExplosives.INSTANCE, id++, EntityHTNT.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "derpy_tnt", OedldoedlExplosives.INSTANCE, id++, EntityDerpyTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "incenditary_tnt", OedldoedlExplosives.INSTANCE, id++, EntityIncenditaryTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "napalm_tnt", OedldoedlExplosives.INSTANCE, id++, EntityNapalmTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "snow_tnt", OedldoedlExplosives.INSTANCE, id++, EntitySnowTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "sir_derpington", OedldoedlExplosives.INSTANCE, id++, EntitySirDerpington.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "bundled_tnt", OedldoedlExplosives.INSTANCE, id++, EntityBundledTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "tnt_rain", OedldoedlExplosives.INSTANCE, id++, EntityTNTRain.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "island_tnt", OedldoedlExplosives.INSTANCE, id++, EntityIslandTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "supersonic_tnt", OedldoedlExplosives.INSTANCE, id++, EntitySupersonicTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "wool_tnt", OedldoedlExplosives.INSTANCE, id++, EntityWoolTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "rainbow_tnt", OedldoedlExplosives.INSTANCE, id++, EntityRainbowTNT.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "troll_tnt", OedldoedlExplosives.INSTANCE, id++, EntityTrollTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "chunk_tnt", OedldoedlExplosives.INSTANCE, id++, EntityChunkTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "nc_nuke", OedldoedlExplosives.INSTANCE, id++, EntityNCNuke.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "nuke_tnt_cb", OedldoedlExplosives.INSTANCE, id++, EntityNukeTNTCb.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "mega_nuke_tnt", OedldoedlExplosives.INSTANCE, id++, EntityMegaNukeTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "antimatter_bomb", OedldoedlExplosives.INSTANCE, id++, EntityAntimatterBomb.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "island_tnt_cb", OedldoedlExplosives.INSTANCE, id++, EntityIslandTNTCb.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "random_blocks_tnt", OedldoedlExplosives.INSTANCE, id++, EntityRandomBlocksTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "lava_tnt", OedldoedlExplosives.INSTANCE, id++, EntityLavaTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "butter_tnt", OedldoedlExplosives.INSTANCE, id++, EntityButterTNT.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "egg_tnt", OedldoedlExplosives.INSTANCE, id++, EntityEggTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "arrow_tnt_cb", OedldoedlExplosives.INSTANCE, id++, EntityArrowTNTCb.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "configureable_tnt", OedldoedlExplosives.INSTANCE, id++, EntityConfigureableTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "lolxd_tnt", OedldoedlExplosives.INSTANCE, id++, EntityLOLXDTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "crash_tnt", OedldoedlExplosives.INSTANCE, id++, EntityCrashTNT.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "tnt_tree", OedldoedlExplosives.INSTANCE, id++, EntityTNTTree.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "flower_power", OedldoedlExplosives.INSTANCE, id++, EntityFlowerPower.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "cubic_tnt", OedldoedlExplosives.INSTANCE, id++, EntityCubicTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "animal_tnt", OedldoedlExplosives.INSTANCE, id++, EntityAnimalTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "gravel_firework", OedldoedlExplosives.INSTANCE, id++, EntityGravelFirework.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "sand_firework", OedldoedlExplosives.INSTANCE, id++, EntitySandFirework.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "tnt_firework", OedldoedlExplosives.INSTANCE, id++, EntityTNTFirework.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "tnt_firework_impact", OedldoedlExplosives.INSTANCE, id++, EntityTNTFireworkImpact.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "entity_firework", OedldoedlExplosives.INSTANCE, id++, EntityEntityFirework.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "multiply_tnt", OedldoedlExplosives.INSTANCE, id++, EntityMultiplyTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "grove_tnt", OedldoedlExplosives.INSTANCE, id++, EntityGroveTNT.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "lightning_tnt", OedldoedlExplosives.INSTANCE, id++, EntityLightningTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "vaporize_tnt", OedldoedlExplosives.INSTANCE, id++, EntityVaporizeTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "compact_tnt", OedldoedlExplosives.INSTANCE, id++, EntityCompactTNT.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "ender_tnt", OedldoedlExplosives.INSTANCE, id++, EntityEnderTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "gravity_tnt", OedldoedlExplosives.INSTANCE, id++, EntityGravityTNT.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "easter_egg", OedldoedlExplosives.INSTANCE, id++, EntityEasterEgg.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "easter_egg_impact", OedldoedlExplosives.INSTANCE, id++, EntityEasterEggImpact.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "flat_tnt", OedldoedlExplosives.INSTANCE, id++, EntityFlatTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "mining_flat_tnt", OedldoedlExplosives.INSTANCE, id++, EntityMiningFlatTNT.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "digging_tnt", OedldoedlExplosives.INSTANCE, id++, EntityDiggingTNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "drilling_tnt", OedldoedlExplosives.INSTANCE, id++, EntityDrillingTNT.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "tnt_x5", OedldoedlExplosives.INSTANCE, id++, EntityTNTX5.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "tnt_x20", OedldoedlExplosives.INSTANCE, id++, EntityTNTX20.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "tnt_x100", OedldoedlExplosives.INSTANCE, id++, EntityTNTX100.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "tnt_x500", OedldoedlExplosives.INSTANCE, id++, EntityTNTX500.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "tnt_x2000", OedldoedlExplosives.INSTANCE, id++, EntityTNTX2000.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "over_9000_tnt", OedldoedlExplosives.INSTANCE, id++, EntityOver9000TNT.class, 160, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "thep2wking_tnt", OedldoedlExplosives.INSTANCE, id++, EntityTheP2WKingTNT.class, 160, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "dynamite", OedldoedlExplosives.INSTANCE, id++, EntityDynamite.class, 64, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "dynamite_x5", OedldoedlExplosives.INSTANCE, id++, EntityDynamiteX5.class, 64, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "dynamite_x20", OedldoedlExplosives.INSTANCE, id++, EntityDynamiteX20.class, 64, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "dynamite_x100", OedldoedlExplosives.INSTANCE, id++, EntityDynamiteX100.class, 64, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "dynamite_x500", OedldoedlExplosives.INSTANCE, id++, EntityDynamiteX500.class, 64, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "dynamite_x2000", OedldoedlExplosives.INSTANCE, id++, EntityDynamiteX2000.class, 64, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "vaporize_dynamite", OedldoedlExplosives.INSTANCE, id++, EntityVaporizeDynamite.class, 64, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "gravity_dynamite", OedldoedlExplosives.INSTANCE, id++, EntityGravityDynamite.class, 64, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "lightning_dynamite", OedldoedlExplosives.INSTANCE, id++, EntityLightningDynamate.class, 64, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "compact_dynamite", OedldoedlExplosives.INSTANCE, id++, EntityCompactDynamite.class, 64, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "multiply_dynamite", OedldoedlExplosives.INSTANCE, id++, EntityMultiplyDynamite.class, 64, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "grove_dynamite", OedldoedlExplosives.INSTANCE, id++, EntityGroveDynamite.class, 64, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "combat_dynamite", OedldoedlExplosives.INSTANCE, id++, EntityCombatDynamite.class, 64, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "cubic_dynamite", OedldoedlExplosives.INSTANCE, id++, EntityCubicDynamite.class, 64, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "animal_dynamite", OedldoedlExplosives.INSTANCE, id++, EntityAnimalDynamite.class, 64, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "thep2wking_dynamite", OedldoedlExplosives.INSTANCE, id++, EntityTheP2WKingDynamite.class, 64, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "ender_dynamite", OedldoedlExplosives.INSTANCE, id++, EntityEnderDynamite.class, 64, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "easter_egg_dynamite", OedldoedlExplosives.INSTANCE, id++, EntityEasterEggDynamite.class, 64, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "drilling_dynamite", OedldoedlExplosives.INSTANCE, id++, EntityDrillingDynamite.class, 64, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "digging_dynamite", OedldoedlExplosives.INSTANCE, id++, EntityDiggingDynamite.class, 64, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "flat_dynamite", OedldoedlExplosives.INSTANCE, id++, EntityFlatDynamite.class, 64, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "mining_flat_dynamite", OedldoedlExplosives.INSTANCE, id++, EntityMiningFlatDynamite.class, 64, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "gravel_firework_dynamite", OedldoedlExplosives.INSTANCE, id++, EntityGravelFireworkDynamite.class, 64, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "sand_firework_dynamite", OedldoedlExplosives.INSTANCE, id++, EntitySandFireworkDynamite.class, 64, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "dynamite_firework", OedldoedlExplosives.INSTANCE, id++, EntityDynamiteFirework.class, 64, 10, true);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "eggsplosive", OedldoedlExplosives.INSTANCE, id++, EntityEggsplosive.class, 64, 10, true);
		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "grenade_apple", OedldoedlExplosives.INSTANCE, id++, EntityGrenadeApple.class, 64, 10, true);
	
		ModRegistryHelper.registerEntityWithSpawnEgg(OedldoedlExplosives.MODID, "thep2wking", OedldoedlExplosives.INSTANCE, id++, EntityTheP2WKing.class, 80, 3, false, 0x000000, 0xe7b202);
		ModRegistryHelper.registerEntityWithSpawnEgg(OedldoedlExplosives.MODID, "giant_thep2wking", OedldoedlExplosives.INSTANCE, id++, EntityGiantTheP2WKing.class, 80, 3, false, 0x000000, 0xe7b202);

		ModRegistryHelper.registerEntity(OedldoedlExplosives.MODID, "meteor_epp", OedldoedlExplosives.INSTANCE, id++, EntityMeteorEpp.class, 128, 10, true);

		if (ExplosivesConfig.CONTENT.SPAWN_THEP2WKING) {
			ModRegistryHelper.registerEntitySpawn(EntityTheP2WKing.class, EnumCreatureType.CREATURE, 2, 1, 1, ModBiomeUtil.getBiomesWithCreatures(EntityPig.class));
		}
	}
}