package net.thep2wking.oedldoedlexplosives.init;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.thep2wking.oedldoedlcore.util.ModToolTypes;
import net.thep2wking.oedldoedlexplosives.OedldoedlExplosives;
import net.thep2wking.oedldoedlexplosives.content.block.BlockAnitmatterBomb;
import net.thep2wking.oedldoedlexplosives.content.block.BlockArrowTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockBundledTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockButterTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockC4;
import net.thep2wking.oedldoedlexplosives.content.block.BlockChunkTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockCombatTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockConfigureableTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockCrashTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockDayTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockDerpyTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockDetonatorChainTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockDrillTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockEggTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockEntityFirework;
import net.thep2wking.oedldoedlexplosives.content.block.BlockFakeTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockFlowerPower;
import net.thep2wking.oedldoedlexplosives.content.block.BlockHTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockIncenditaryTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockIslandTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockLOLXDTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockLavaTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockMegaNukeTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockMeteorTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockMiniNukeTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockNCNuke;
import net.thep2wking.oedldoedlexplosives.content.block.BlockNapalmTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockNightTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockNukeTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockOver9000TNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockRainbowTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockRandomBlocksTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockSirDerpingtonTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockSnowTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockSphereTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockSupersonicTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockTNTRain;
import net.thep2wking.oedldoedlexplosives.content.block.BlockTNTTree;
import net.thep2wking.oedldoedlexplosives.content.block.BlockTheP2WKingTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockTrollTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockWoolTNT;
import net.thep2wking.oedldoedlexplosives.content.block.misc.BlockRainbow;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.animal.BlockAnimalTNT;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.compact.BlockCompactTNT;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.cubic.BlockCubicTNT;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.digging.BlockDiggingTNT;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.drilling.BlockDrillingTNT;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.easteregg.BlockEasterEgg;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.ender.BlockEnderTNT;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.flat.BlockFlatTNT;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.gravelfirework.BlockGravelFirework;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.gravity.BlockGravityTNT;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.grove.BlockGroveTNT;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.lightning.BlockLightningTNT;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.miningflat.BlockMiningFlatTNT;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.multiply.BlockMultiplyTNT;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.sandfirework.BlockSandFirework;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.tntfirework.BlockTNTFirework;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.vaporize.BlockVaporizeTNT;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.x100.BlockTNTX100;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.x20.BlockTNTX20;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.x2000.BlockTNTX2000;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.x5.BlockTNTX5;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.x500.BlockTNTX500;

public class ModBlocks {
	public static final Block RAINBOW = new BlockRainbow(OedldoedlExplosives.MODID, "rainbow_block",
			OedldoedlExplosives.TAB, Material.CLOTH, SoundType.CLOTH, MapColor.ORANGE_STAINED_HARDENED_CLAY, 0,
			ModToolTypes.NO_TOOL, 0.8f, 0.8f, 0);

	public static final Block FAKE_TNT = new BlockFakeTNT(OedldoedlExplosives.MODID, "fake_tnt",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.TNT, 0);
	public static final Block COMBAT_TNT = new BlockCombatTNT(OedldoedlExplosives.MODID, "combat_tnt",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.TNT, 0);

	public static final Block C4 = new BlockC4(OedldoedlExplosives.MODID, "c4", OedldoedlExplosives.TAB,
			SoundType.PLANT, MapColor.SILVER, 0);

	public static final Block DRILL_TNT = new BlockDrillTNT(OedldoedlExplosives.MODID, "drill_tnt",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.GRAY, 0);
	public static final Block FLAT_TNT_PP = new net.thep2wking.oedldoedlexplosives.content.block.BlockFlatTNT(OedldoedlExplosives.MODID, "flat_tnt_ep",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.GRAY, 0);

	public static final Block NUKE_TNT = new BlockNukeTNT(OedldoedlExplosives.MODID, "nuke_tnt",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.GRAY, 0);
	public static final Block H_TNT = new BlockHTNT(OedldoedlExplosives.MODID, "h_tnt",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.TNT, 0);

	public static final Block METEOR_TNT = new BlockMeteorTNT(OedldoedlExplosives.MODID, "meteor_tnt",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.TNT, 0);
	public static final Block SPHERE_TNT = new BlockSphereTNT(OedldoedlExplosives.MODID, "sphere_tnt",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.TNT, 0);
	public static final Block DERPY_TNT = new BlockDerpyTNT(OedldoedlExplosives.MODID, "derpy_tnt",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.TNT, 0);
	public static final Block INCENDITARY_TNT = new BlockIncenditaryTNT(OedldoedlExplosives.MODID, "incenditary_tnt",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.TNT, 0);

	public static final Block DETONATOR_CHAIN_TNT = new BlockDetonatorChainTNT(OedldoedlExplosives.MODID,
			"detonator_chain_tnt", OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.RED, 0);
	public static final Block DAY_TNT = new BlockDayTNT(OedldoedlExplosives.MODID, "day_tnt", OedldoedlExplosives.TAB,
			SoundType.PLANT, MapColor.TNT, 0);
	public static final Block NIGHT_TNT = new BlockNightTNT(OedldoedlExplosives.MODID, "night_tnt",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.TNT, 0);
	public static final Block SIR_DERPINGTON_TNT = new BlockSirDerpingtonTNT(OedldoedlExplosives.MODID,
			"sir_derpington_tnt", OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.TNT, 0);
	public static final Block TNT_RAIN = new BlockTNTRain(OedldoedlExplosives.MODID, "tnt_rain",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.TNT, 0);

	public static final Block NAPALM_TNT = new BlockNapalmTNT(OedldoedlExplosives.MODID, "napalm_tnt",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.TNT, 0);
	public static final Block ISLAND_TNT = new BlockIslandTNT(OedldoedlExplosives.MODID, "island_tnt",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.TNT, 0);
	public static final Block WOOL_TNT = new BlockWoolTNT(OedldoedlExplosives.MODID, "wool_tnt",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.TNT, 0);

	public static final Block SNOW_TNT = new BlockSnowTNT(OedldoedlExplosives.MODID, "snow_tnt",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.TNT, 0);
	public static final Block BUNDLED_TNT = new BlockBundledTNT(OedldoedlExplosives.MODID, "bundled_tnt",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.TNT, 0);
	public static final Block SUPERSONIC_TNT = new BlockSupersonicTNT(OedldoedlExplosives.MODID, "supersonic_tnt",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.TNT, 0);
	public static final Block RAINBOW_TNT = new BlockRainbowTNT(OedldoedlExplosives.MODID, "rainbow_tnt",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.TNT, 0);

	public static final Block TROLL_TNT = new BlockTrollTNT(OedldoedlExplosives.MODID, "troll_tnt",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.RED, 0);
	public static final Block CHUNK_TNT = new BlockChunkTNT(OedldoedlExplosives.MODID, "chunk_tnt",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.RED, 0);
	public static final Block NUKE_NC = new BlockNCNuke(OedldoedlExplosives.MODID, "nc_nuke", OedldoedlExplosives.TAB,
			SoundType.PLANT, MapColor.BLACK, 0);

	public static final Block MINI_NUKE_TNT = new BlockMiniNukeTNT(OedldoedlExplosives.MODID, "mini_nuke_tnt",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.TNT, 0);
	public static final Block MEGA_NUKE_TNT = new BlockMegaNukeTNT(OedldoedlExplosives.MODID, "mega_nuke_tnt",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.TNT, 0);
	public static final Block ANTIMATTER_BOMB = new BlockAnitmatterBomb(OedldoedlExplosives.MODID, "antimatter_bomb",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.TNT, 0);

	public static final Block BUTTER_TNT = new BlockButterTNT(OedldoedlExplosives.MODID, "butter_tnt",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.GOLD, 0);
	public static final Block LAVA_TNT = new BlockLavaTNT(OedldoedlExplosives.MODID, "lava_tnt",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.ORANGE_STAINED_HARDENED_CLAY, 0);
	public static final Block EGG_TNT = new BlockEggTNT(OedldoedlExplosives.MODID, "egg_tnt", OedldoedlExplosives.TAB,
			SoundType.PLANT, MapColor.TNT, 0);
	public static final Block ARROW_TNT = new BlockArrowTNT(OedldoedlExplosives.MODID, "arrow_tnt",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.TNT, 0);

	public static final Block RANDOM_BLOCKS_TNT = new BlockRandomBlocksTNT(OedldoedlExplosives.MODID,
			"random_blocks_tnt", OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.TNT, 0);
	public static final Block CRASH_TNT = new BlockCrashTNT(OedldoedlExplosives.MODID, "crash_tnt",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.TNT, 0);
	public static final Block LOLXD_TNT = new BlockLOLXDTNT(OedldoedlExplosives.MODID, "lolxd_tnt",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.TNT, 0);

	public static final Block TNT_TREE = new BlockTNTTree(OedldoedlExplosives.MODID, "tnt_tree",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.TNT, 0);
	public static final Block CONFIGUREABLE_TNT = new BlockConfigureableTNT(OedldoedlExplosives.MODID,
			"configureable_tnt", OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.TNT, 0);

	public static final Block FLOWER_POWER = new BlockFlowerPower(OedldoedlExplosives.MODID, "flower_power",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.PINK, 0);
	public static final Block CUBIC_TNT = new BlockCubicTNT(OedldoedlExplosives.MODID, "cubic_tnt",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.TNT, 0);
	public static final Block ANIMAL_TNT = new BlockAnimalTNT(OedldoedlExplosives.MODID, "animal_tnt",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.BROWN, 0);
	public static final Block GRAVEL_FIREWORK = new BlockGravelFirework(OedldoedlExplosives.MODID, "gravel_firework",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.GRAY, 0);
	public static final Block SAND_FIREWORK = new BlockSandFirework(OedldoedlExplosives.MODID, "sand_firework",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.SAND, 0);
	public static final Block TNT_FIREWORK = new BlockTNTFirework(OedldoedlExplosives.MODID, "tnt_firework",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.BLACK, 0);
	public static final Block ENTITY_FIREWORK = new BlockEntityFirework(OedldoedlExplosives.MODID, "entity_firework",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.SNOW, 0);

	public static final Block MULTIPLY_TNT = new BlockMultiplyTNT(OedldoedlExplosives.MODID, "multiply_tnt",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.YELLOW, 0);
	public static final Block GROVE_TNT = new BlockGroveTNT(OedldoedlExplosives.MODID, "grove_tnt",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.BROWN, 0);

	public static final Block LIGHNING_TNT = new BlockLightningTNT(OedldoedlExplosives.MODID, "lightning_tnt",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.SAND, 0);
	public static final Block VAPORIZE_TNT = new BlockVaporizeTNT(OedldoedlExplosives.MODID, "vaporize_tnt",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.SNOW, 0);
	public static final Block COMPACT_TNT = new BlockCompactTNT(OedldoedlExplosives.MODID, "compact_tnt",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.RED, 0);

	public static final Block ENDER_TNT = new BlockEnderTNT(OedldoedlExplosives.MODID, "ender_tnt",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.GREEN, 0);
	public static final Block GRAVITY_TNT = new BlockGravityTNT(OedldoedlExplosives.MODID, "gravity_tnt",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.GRAY, 0);

	public static final Block EASTER_EGG = new BlockEasterEgg(OedldoedlExplosives.MODID, "easter_egg",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.ORANGE_STAINED_HARDENED_CLAY, 0);

	public static final Block FLAT_TNT = new BlockFlatTNT(OedldoedlExplosives.MODID, "flat_tnt",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.GREEN, 0);
	public static final Block MINING_FLAT_TNT = new BlockMiningFlatTNT(OedldoedlExplosives.MODID, "mining_flat_tnt",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.ORANGE_STAINED_HARDENED_CLAY, 0);

	public static final Block DIGGING_TNT = new BlockDiggingTNT(OedldoedlExplosives.MODID, "digging_tnt",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.TNT, 0);
	public static final Block DRILLING_TNT = new BlockDrillingTNT(OedldoedlExplosives.MODID, "drilling_tnt",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.ORANGE_STAINED_HARDENED_CLAY, 0);

	public static final Block TNT_X5 = new BlockTNTX5(OedldoedlExplosives.MODID, "tnt_x5", OedldoedlExplosives.TAB,
			SoundType.PLANT, MapColor.BLUE, 0);
	public static final Block TNT_X20 = new BlockTNTX20(OedldoedlExplosives.MODID, "tnt_x20", OedldoedlExplosives.TAB,
			SoundType.PLANT, MapColor.GREEN, 0);
	public static final Block TNT_X100 = new BlockTNTX100(OedldoedlExplosives.MODID, "tnt_x100",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.ORANGE_STAINED_HARDENED_CLAY, 0);
	public static final Block TNT_X500 = new BlockTNTX500(OedldoedlExplosives.MODID, "tnt_x500",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.BLACK, 0);
	public static final Block TNT_X2000 = new BlockTNTX2000(OedldoedlExplosives.MODID, "tnt_x2000",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.YELLOW, 0);

	public static final Block OVER_9000_TNT = new BlockOver9000TNT(OedldoedlExplosives.MODID, "over_9000_tnt",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.PURPLE, 0);
	public static final Block THEP2WKING_TNT = new BlockTheP2WKingTNT(OedldoedlExplosives.MODID, "thep2wking_tnt",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.GOLD, 0);
}