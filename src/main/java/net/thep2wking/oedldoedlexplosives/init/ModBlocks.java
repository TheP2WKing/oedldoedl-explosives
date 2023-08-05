package net.thep2wking.oedldoedlexplosives.init;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.thep2wking.oedldoedlexplosives.OedldoedlExplosives;
import net.thep2wking.oedldoedlexplosives.content.block.BlockC4;
import net.thep2wking.oedldoedlexplosives.content.block.BlockChunkTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockDayTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockDrillTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockFlatTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockNCNuke;
import net.thep2wking.oedldoedlexplosives.content.block.BlockNightTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockNukeTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockSirDerpingtonTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockTNTx20;
import net.thep2wking.oedldoedlexplosives.content.block.BlockTNTx5;
import net.thep2wking.oedldoedlexplosives.content.block.BlockTrollTNT;

public class ModBlocks {
	public static final Block C4 = new BlockC4(OedldoedlExplosives.MODID, "c4", OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.SILVER, 0);
	public static final Block TNT_X5 = new BlockTNTx5(OedldoedlExplosives.MODID, "tnt_x5", OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.SILVER, 0);
	public static final Block TNT_X20 = new BlockTNTx20(OedldoedlExplosives.MODID, "tnt_x20", OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.YELLOW, 0);
	
	public static final Block DAY_TNT = new BlockDayTNT(OedldoedlExplosives.MODID, "day_tnt", OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.TNT, 0);
	public static final Block NIGHT_TNT = new BlockNightTNT(OedldoedlExplosives.MODID, "night_tnt", OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.TNT, 0);
	public static final Block SIR_DERPINGTON_TNT = new BlockSirDerpingtonTNT(OedldoedlExplosives.MODID, "sir_derpington_tnt", OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.TNT, 0);

	public static final Block DRILL_TNT = new BlockDrillTNT(OedldoedlExplosives.MODID, "drill_tnt", OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.GRAY, 0);
	public static final Block FLAT_TNT = new BlockFlatTNT(OedldoedlExplosives.MODID, "flat_tnt", OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.GRAY, 0);

	public static final Block NUKE_TNT = new BlockNukeTNT(OedldoedlExplosives.MODID, "nuke_tnt", OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.GRAY, 0);

	public static final Block NUKE = new BlockNCNuke(OedldoedlExplosives.MODID, "nc_nuke", OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.BLACK, 0);
	public static final Block TROLL_TNT = new BlockTrollTNT(OedldoedlExplosives.MODID, "troll_tnt", OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.RED, 0);
	public static final Block CHUNK_TNT = new BlockChunkTNT(OedldoedlExplosives.MODID, "chunk_tnt", OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.RED, 0);
}
