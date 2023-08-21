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
import net.thep2wking.oedldoedlexplosives.content.block.BlockCrashTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockCubicTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockDayTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockDerpyTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockDetonatorChainTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockDrillTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockEggTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockFakeTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockFlatTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockFlowerPower;
import net.thep2wking.oedldoedlexplosives.content.block.BlockHTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockIncenditaryTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockIslandTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockLOLXDTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockLavaTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockMegaNukeTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockMeteorTNT;
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
import net.thep2wking.oedldoedlexplosives.content.block.BlockTNTx20;
import net.thep2wking.oedldoedlexplosives.content.block.BlockTNTx5;
import net.thep2wking.oedldoedlexplosives.content.block.BlockTrollTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockWoolTNT;
import net.thep2wking.oedldoedlexplosives.content.block.misc.BlockRainbow;

public class ModBlocks {
	public static final Block RAINBOW = new BlockRainbow(OedldoedlExplosives.MODID, "rainbow_block",
			OedldoedlExplosives.TAB, Material.CLOTH, SoundType.CLOTH, MapColor.ORANGE_STAINED_HARDENED_CLAY, 0,
			ModToolTypes.NO_TOOL, 0.8f, 0.8f, 0);

	public static final Block FAKE_TNT = new BlockFakeTNT(OedldoedlExplosives.MODID, "fake_tnt",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.TNT, 0);

	public static final Block C4 = new BlockC4(OedldoedlExplosives.MODID, "c4", OedldoedlExplosives.TAB,
			SoundType.PLANT, MapColor.SILVER, 0);
	public static final Block TNT_X5 = new BlockTNTx5(OedldoedlExplosives.MODID, "tnt_x5", OedldoedlExplosives.TAB,
			SoundType.PLANT, MapColor.SILVER, 0);
	public static final Block TNT_X20 = new BlockTNTx20(OedldoedlExplosives.MODID, "tnt_x20", OedldoedlExplosives.TAB,
			SoundType.PLANT, MapColor.YELLOW, 0);

	public static final Block DRILL_TNT = new BlockDrillTNT(OedldoedlExplosives.MODID, "drill_tnt",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.GRAY, 0);
	public static final Block FLAT_TNT = new BlockFlatTNT(OedldoedlExplosives.MODID, "flat_tnt",
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

	public static final Block NUKE = new BlockNCNuke(OedldoedlExplosives.MODID, "nc_nuke", OedldoedlExplosives.TAB,
			SoundType.PLANT, MapColor.BLACK, 0);
	public static final Block TROLL_TNT = new BlockTrollTNT(OedldoedlExplosives.MODID, "troll_tnt",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.RED, 0);
	public static final Block CHUNK_TNT = new BlockChunkTNT(OedldoedlExplosives.MODID, "chunk_tnt",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.RED, 0);

	public static final Block MEGA_NUKE_TNT = new BlockMegaNukeTNT(OedldoedlExplosives.MODID, "mega_nuke_tnt",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.TNT, 0);
	public static final Block ANTIMATTER_BOMB = new BlockAnitmatterBomb(OedldoedlExplosives.MODID, "antimatter_bomb",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.TNT, 0);

	public static final Block BUTTER_TNT = new BlockButterTNT(OedldoedlExplosives.MODID, "butter_tnt",
			OedldoedlExplosives.TAB, SoundType.METAL, MapColor.GOLD, 0);
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

	public static final Block FLOWER_POWER = new BlockFlowerPower(OedldoedlExplosives.MODID, "flower_power",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.PINK, 0);
	public static final Block CUBIC_TNT = new BlockCubicTNT(OedldoedlExplosives.MODID, "cubic_tnt",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.TNT, 0);
	public static final Block OVER_9000_TNT = new BlockOver9000TNT(OedldoedlExplosives.MODID, "over_9000_tnt",
			OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.PURPLE, 0);
}