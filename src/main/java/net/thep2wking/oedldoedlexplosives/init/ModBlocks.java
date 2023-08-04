package net.thep2wking.oedldoedlexplosives.init;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.thep2wking.oedldoedlexplosives.OedldoedlExplosives;
import net.thep2wking.oedldoedlexplosives.content.block.BlockChunkTNT;
import net.thep2wking.oedldoedlexplosives.content.block.BlockNuke;
import net.thep2wking.oedldoedlexplosives.content.block.BlockTrollTNT;

public class ModBlocks {
	public static final Block NUKE = new BlockNuke(OedldoedlExplosives.MODID, "nuke", OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.BLACK, 0);
	public static final Block TROLL_TNT = new BlockTrollTNT(OedldoedlExplosives.MODID, "troll_tnt", OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.RED, 0);
	public static final Block CHUNK_TNT = new BlockChunkTNT(OedldoedlExplosives.MODID, "chunk_tnt", OedldoedlExplosives.TAB, SoundType.PLANT, MapColor.RED, 0);
}
