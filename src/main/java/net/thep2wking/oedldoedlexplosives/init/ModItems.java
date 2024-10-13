package net.thep2wking.oedldoedlexplosives.init;

import net.minecraft.item.Item;
import net.thep2wking.oedldoedlcore.api.item.ModItemBase;
import net.thep2wking.oedldoedlcore.api.item.ModItemBlockBase;
import net.thep2wking.oedldoedlcore.util.ModRarities;
import net.thep2wking.oedldoedlexplosives.OedldoedlExplosives;
import net.thep2wking.oedldoedlexplosives.api.ModItemBlockTNTBase;
import net.thep2wking.oedldoedlexplosives.content.item.ItemCombatDynamite;
import net.thep2wking.oedldoedlexplosives.content.item.ItemDividedByZero;
import net.thep2wking.oedldoedlexplosives.content.item.ItemEggsplosive;
import net.thep2wking.oedldoedlexplosives.content.item.ItemGrenadeApple;
import net.thep2wking.oedldoedlexplosives.content.item.ItemTNTDisruptor;
import net.thep2wking.oedldoedlexplosives.content.item.ItemTNTWrench;
import net.thep2wking.oedldoedlexplosives.content.item.ItemTheP2WKingDynamite;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.animal.ItemAnimalDynamite;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.compact.ItemCompactDynamite;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.cubic.ItemCubicDynamite;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.digging.ItemDiggingDynamite;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.drilling.ItemDrillingDynamite;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.easteregg.ItemEasterEggDynamite;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.ender.ItemEnderDynamite;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.flat.ItemFlatDynamite;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.gravelfirework.ItemGravelFireworkDynamite;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.gravity.ItemGravityDynamite;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.grove.ItemGroveDynamite;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.lightning.ItemLightningDynamite;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.miningflat.ItemMiningFlatDynamite;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.multiply.ItemMultiplyDynamite;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.sandfirework.ItemSandFireworkDynamite;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.tnt.ItemDynamite;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.tntfirework.ItemDynamiteFirework;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.vaporize.ItemVaporizeDynamite;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.x100.ItemDynamiteX100;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.x20.ItemDynamiteX20;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.x2000.ItemDynamiteX2000;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.x5.ItemDynamiteX5;
import net.thep2wking.oedldoedlexplosives.content.toomuchtnt.x500.ItemDynamiteX500;

public class ModItems {
	public static final Item RAINBOW_BLOCK = new ModItemBlockBase(ModBlocks.RAINBOW_BLOCK, ModRarities.WHITE, false, 1, 0);
	public static final Item GUNPOWDER_BLOCK = new ModItemBlockBase(ModBlocks.GUNPOWDER_BLOCK, ModRarities.WHITE, false, 1, 0);

	public static final Item FAKE_TNT = new ModItemBlockTNTBase(ModBlocks.FAKE_TNT, ModRarities.WHITE, false, 1, 0);
	public static final Item COMBAT_TNT = new ModItemBlockTNTBase(ModBlocks.COMBAT_TNT, ModRarities.YELLOW, false, 1, 0);

	public static final Item TNT_X5_EPP = new ModItemBlockTNTBase(ModBlocks.TNT_X5_EPP, ModRarities.WHITE, false, 1, 0);
	public static final Item TNT_X20_EPP = new ModItemBlockTNTBase(ModBlocks.TNT_X20_EPP, ModRarities.YELLOW, false, 1, 0);
	public static final Item C4 = new ModItemBlockTNTBase(ModBlocks.C4, ModRarities.WHITE, false, 1, 0);
	
	public static final Item DRILL_TNT = new ModItemBlockTNTBase(ModBlocks.DRILL_TNT, ModRarities.YELLOW, false, 1, 0);
	public static final Item FLAT_TNT_PP = new ModItemBlockTNTBase(ModBlocks.FLAT_TNT_EPP, ModRarities.YELLOW, false, 1, 0);

	public static final Item NUKE_TNT = new ModItemBlockTNTBase(ModBlocks.NUKE_TNT, ModRarities.RED, false, 1, 0);
	public static final Item METEOR_TNT_EPP = new ModItemBlockTNTBase(ModBlocks.METEOR_TNT_EPP, ModRarities.YELLOW, false, 1, 0);
	
	public static final Item DETONATOR_CHAIN_TNT = new ModItemBlockTNTBase(ModBlocks.DETONATOR_CHAIN_TNT, ModRarities.WHITE, false, 1, 0);

	public static final Item DAY_TNT = new ModItemBlockTNTBase(ModBlocks.DAY_TNT, ModRarities.YELLOW, false, 1, 0);
	public static final Item NIGHT_TNT = new ModItemBlockTNTBase(ModBlocks.NIGHT_TNT, ModRarities.DARK_GRAY, false, 1, 0);

	public static final Item SPHERE_TNT_EPP = new ModItemBlockTNTBase(ModBlocks.SPHERE_TNT_EPP, ModRarities.YELLOW, false, 1, 0);
	public static final Item H_TNT = new ModItemBlockTNTBase(ModBlocks.H_TNT, ModRarities.DARK_RED, false, 1, 0);

	public static final Item DERPY_TNT = new ModItemBlockTNTBase(ModBlocks.DERPY_TNT, ModRarities.WHITE, false, 1, 0);
	public static final Item INCENDITARY_TNT = new ModItemBlockTNTBase(ModBlocks.INCENDITARY_TNT, ModRarities.WHITE, false, 1, 0);
	public static final Item NAPALM_TNT = new ModItemBlockTNTBase(ModBlocks.NAPALM_TNT, ModRarities.YELLOW, false, 1, 0);
	public static final Item SNOW_TNT = new ModItemBlockTNTBase(ModBlocks.SNOW_TNT, ModRarities.WHITE, false, 1, 0);
	public static final Item SIR_DERPINGTON = new ModItemBlockTNTBase(ModBlocks.SIR_DERPINGTON, ModRarities.LIGHT_PURPLE, false, 1, 0);

	public static final Item BUNDLED_TNT = new ModItemBlockTNTBase(ModBlocks.BUNDLED_TNT, ModRarities.WHITE, false, 1, 0);
	public static final Item TNT_RAIN = new ModItemBlockTNTBase(ModBlocks.TNT_RAIN, ModRarities.RED, false, 1, 0);

	public static final Item ISLAND_TNT = new ModItemBlockTNTBase(ModBlocks.ISLAND_TNT, ModRarities.YELLOW, false, 1, 0);
	public static final Item SUPERSONIC_TNT = new ModItemBlockTNTBase(ModBlocks.SUPERSONIC_TNT, ModRarities.YELLOW, false, 1, 0);
	public static final Item WOOL_TNT = new ModItemBlockTNTBase(ModBlocks.WOOL_TNT, ModRarities.AQUA, false, 1, 0);
	public static final Item RAINBOW_TNT = new ModItemBlockTNTBase(ModBlocks.RAINBOW_TNT, ModRarities.AQUA, false, 1, 0);

	public static final Item TROLL_TNT = new ModItemBlockTNTBase(ModBlocks.TROLL_TNT, ModRarities.YELLOW, false, 1, 0);
	public static final Item CHUNK_TNT = new ModItemBlockTNTBase(ModBlocks.CHUNK_TNT, ModRarities.RED, false, 1, 0);
	public static final Item NUKE_NC = new ModItemBlockTNTBase(ModBlocks.NUKE_NC, ModRarities.RED, false, 1, 0);

	public static final Item NUKE_TNT_CB = new ModItemBlockTNTBase(ModBlocks.NUKE_TNT_CB, ModRarities.WHITE, false, 1, 0);
	public static final Item MEGA_NUKE_TNT = new ModItemBlockTNTBase(ModBlocks.MEGA_NUKE_TNT, ModRarities.YELLOW, false, 1, 0);
	public static final Item ANTIMATTER_BOMB = new ModItemBlockTNTBase(ModBlocks.ANTIMATTER_BOMB, ModRarities.RED, false, 1, 0);

	public static final Item ISLAND_TNT_CB = new ModItemBlockTNTBase(ModBlocks.ISLAND_TNT_CB, ModRarities.WHITE, false, 1, 0);
	public static final Item RANDOM_BLOCKS_TNT = new ModItemBlockTNTBase(ModBlocks.RANDOM_BLOCKS_TNT, ModRarities.YELLOW, false, 1, 0);
	public static final Item LAVA_TNT = new ModItemBlockTNTBase(ModBlocks.LAVA_TNT, ModRarities.YELLOW, false, 1, 0);
	public static final Item BUTTER_TNT = new ModItemBlockTNTBase(ModBlocks.BUTTER_TNT, ModRarities.GOLD, false, 1, 0);

	public static final Item EGG_TNT = new ModItemBlockTNTBase(ModBlocks.EGG_TNT, ModRarities.WHITE, false, 1, 0);
	public static final Item ARROW_TNT_CB = new ModItemBlockTNTBase(ModBlocks.ARROW_TNT_CB, ModRarities.WHITE, false, 1, 0);

	public static final Item CONFIGUREABLE_TNT = new ModItemBlockTNTBase(ModBlocks.CONFIGUREABLE_TNT, ModRarities.WHITE, false, 1, 0);
	public static final Item LOLXD_TNT = new ModItemBlockTNTBase(ModBlocks.LOLXD_TNT, ModRarities.DARK_GRAY, false, 1, 0);
	public static final Item CRASH_TNT = new ModItemBlockTNTBase(ModBlocks.CRASH_TNT, ModRarities.RED, false, 1, 0);

	public static final Item TNT_TREE = new ModItemBlockTNTBase(ModBlocks.TNT_TREE, ModRarities.GREEN, false, 1, 0);

	public static final Item FLOWER_POWER = new ModItemBlockTNTBase(ModBlocks.FLOWER_POWER, ModRarities.WHITE, false, 1, 0);
	public static final Item CUBIC_TNT = new ModItemBlockTNTBase(ModBlocks.CUBIC_TNT, ModRarities.WHITE, false, 1, 0);
	public static final Item ANIMAL_TNT = new ModItemBlockTNTBase(ModBlocks.ANIMAL_TNT, ModRarities.WHITE, false, 1, 0);
	public static final Item GRAVEL_FIREWORK = new ModItemBlockTNTBase(ModBlocks.GRAVEL_FIREWORK, ModRarities.GRAY, false, 1, 0);
	public static final Item SAND_FIREWORK = new ModItemBlockTNTBase(ModBlocks.SAND_FIREWORK, ModRarities.YELLOW, false, 1, 0);
	public static final Item TNT_FIREWORK = new ModItemBlockTNTBase(ModBlocks.TNT_FIREWORK, ModRarities.RED, false, 1, 0);
	public static final Item ENTITY_FIREWORK = new ModItemBlockTNTBase(ModBlocks.ENTITY_FIREWORK, ModRarities.GREEN, false, 1, 0);

	public static final Item MULTIPLY_TNT = new ModItemBlockTNTBase(ModBlocks.MULTIPLY_TNT, ModRarities.YELLOW, false, 1, 0);
	public static final Item GROVE_TNT = new ModItemBlockTNTBase(ModBlocks.GROVE_TNT, ModRarities.WHITE, false, 1, 0);

	public static final Item LIGHNING_TNT = new ModItemBlockTNTBase(ModBlocks.LIGHNING_TNT, ModRarities.YELLOW, false, 1, 0);
	public static final Item VAPORIZE_TNT = new ModItemBlockTNTBase(ModBlocks.VAPORIZE_TNT, ModRarities.WHITE, false, 1, 0);
	public static final Item COMPACT_TNT = new ModItemBlockTNTBase(ModBlocks.COMPACT_TNT, ModRarities.WHITE, false, 1, 0);

	public static final Item ENDER_TNT = new ModItemBlockTNTBase(ModBlocks.ENDER_TNT, ModRarities.LIGHT_PURPLE, false, 1, 0);
	public static final Item GRAVITY_TNT = new ModItemBlockTNTBase(ModBlocks.GRAVITY_TNT, ModRarities.YELLOW, false, 1, 0);

	public static final Item EASTER_EGG = new ModItemBlockTNTBase(ModBlocks.EASTER_EGG, ModRarities.GOLD, false, 1, 0);

	public static final Item FLAT_TNT = new ModItemBlockTNTBase(ModBlocks.FLAT_TNT, ModRarities.YELLOW, false, 1, 0);
	public static final Item MINING_FLAT_TNT = new ModItemBlockTNTBase(ModBlocks.MINING_FLAT_TNT, ModRarities.YELLOW, false, 1, 0);

	public static final Item DIGGING_TNT = new ModItemBlockTNTBase(ModBlocks.DIGGING_TNT, ModRarities.WHITE, false, 1, 0);
	public static final Item DRILLING_TNT = new ModItemBlockTNTBase(ModBlocks.DRILLING_TNT, ModRarities.YELLOW, false, 1, 0);

	public static final Item TNT_X5 = new ModItemBlockTNTBase(ModBlocks.TNT_X5, ModRarities.WHITE, false, 1, 0);
	public static final Item TNT_X20 = new ModItemBlockTNTBase(ModBlocks.TNT_X20, ModRarities.YELLOW, false, 1, 0);
	public static final Item TNT_X100 = new ModItemBlockTNTBase(ModBlocks.TNT_X100, ModRarities.YELLOW, false, 1, 0);
	public static final Item TNT_X500 = new ModItemBlockTNTBase(ModBlocks.TNT_X500, ModRarities.AQUA, false, 1, 0);
	public static final Item TNT_X2000 = new ModItemBlockTNTBase(ModBlocks.TNT_X2000, ModRarities.RED, false, 1, 0);

	public static final Item OVER_9000_TNT = new ModItemBlockTNTBase(ModBlocks.OVER_9000_TNT, ModRarities.DARK_RED, false, 1, 0);
	public static final Item THEP2WKING_TNT = new ModItemBlockTNTBase(ModBlocks.THEP2WKING_TNT, ModRarities.GOLD, false, 1, 0);

	public static final Item DYNAMITE = new ItemDynamite(OedldoedlExplosives.MODID, "dynamite", OedldoedlExplosives.TAB, ModRarities.WHITE, false, 1, 0);
	public static final Item DYNAMITE_X5 = new ItemDynamiteX5(OedldoedlExplosives.MODID, "dynamite_x5", OedldoedlExplosives.TAB, ModRarities.WHITE, false, 1, 0);
	public static final Item DYNAMITE_X20 = new ItemDynamiteX20(OedldoedlExplosives.MODID, "dynamite_x20", OedldoedlExplosives.TAB, ModRarities.YELLOW, false, 1, 0);
	public static final Item DYNAMITE_X100 = new ItemDynamiteX100(OedldoedlExplosives.MODID, "dynamite_x100", OedldoedlExplosives.TAB, ModRarities.YELLOW, false, 1, 0);
	public static final Item DYNAMITE_X500 = new ItemDynamiteX500(OedldoedlExplosives.MODID, "dynamite_x500", OedldoedlExplosives.TAB, ModRarities.AQUA, false, 1, 0);
	public static final Item DYNAMITE_X2000 = new ItemDynamiteX2000(OedldoedlExplosives.MODID, "dynamite_x2000", OedldoedlExplosives.TAB, ModRarities.RED, false, 1, 0);

	public static final Item VAPORIZE_DYNAMITE = new ItemVaporizeDynamite(OedldoedlExplosives.MODID, "vaporize_dynamite", OedldoedlExplosives.TAB, ModRarities.WHITE, false, 1, 0);
	public static final Item GRAVITY_DYNAMITE = new ItemGravityDynamite(OedldoedlExplosives.MODID, "gravity_dynamite", OedldoedlExplosives.TAB, ModRarities.YELLOW, false, 1, 0);
	public static final Item LIGHTNING_DYNAMITE = new ItemLightningDynamite(OedldoedlExplosives.MODID, "lightning_dynamite", OedldoedlExplosives.TAB, ModRarities.YELLOW, false, 1, 0);
	public static final Item COMPACT_DYNAMITE = new ItemCompactDynamite(OedldoedlExplosives.MODID, "compact_dynamite", OedldoedlExplosives.TAB, ModRarities.WHITE, false, 1, 0);

	public static final Item COMBAT_DYNAMITE = new ItemCombatDynamite(OedldoedlExplosives.MODID, "combat_dynamite", OedldoedlExplosives.TAB, ModRarities.YELLOW, false, 1, 0);
	public static final Item CUBIC_DYNAMITE = new ItemCubicDynamite(OedldoedlExplosives.MODID, "cubic_dynamite", OedldoedlExplosives.TAB, ModRarities.WHITE, false, 1, 0);
	public static final Item ANIMAL_DYNAMITE = new ItemAnimalDynamite(OedldoedlExplosives.MODID, "animal_dynamite", OedldoedlExplosives.TAB, ModRarities.WHITE, false, 1, 0);
	public static final Item THEP2WKING_DYNAMITE = new ItemTheP2WKingDynamite(OedldoedlExplosives.MODID, "thep2wking_dynamite", OedldoedlExplosives.TAB, ModRarities.GOLD, false, 1, 0);

	public static final Item MULTIPLY_DYNAMITE = new ItemMultiplyDynamite(OedldoedlExplosives.MODID, "multiply_dynamite", OedldoedlExplosives.TAB, ModRarities.YELLOW, false, 1, 0);
	public static final Item GROVE_DYNAMITE = new ItemGroveDynamite(OedldoedlExplosives.MODID, "grove_dynamite", OedldoedlExplosives.TAB, ModRarities.WHITE, false, 1, 0);

	public static final Item ENDER_DYNAMITE = new ItemEnderDynamite(OedldoedlExplosives.MODID, "ender_dynamite", OedldoedlExplosives.TAB, ModRarities.LIGHT_PURPLE, false, 1, 0);
	public static final Item EASTER_EGG_DYNAMITE = new ItemEasterEggDynamite(OedldoedlExplosives.MODID, "easter_egg_dynamite", OedldoedlExplosives.TAB, ModRarities.GOLD, false, 1, 0);

	public static final Item FLAT_DYNAMITE = new ItemFlatDynamite(OedldoedlExplosives.MODID, "flat_dynamite", OedldoedlExplosives.TAB, ModRarities.YELLOW, false, 1, 0);
	public static final Item MINING_FLAT_DYNAMITE = new ItemMiningFlatDynamite(OedldoedlExplosives.MODID, "mining_flat_dynamite", OedldoedlExplosives.TAB, ModRarities.YELLOW, false, 1, 0);

	public static final Item DIGGING_DYNAMITE = new ItemDiggingDynamite(OedldoedlExplosives.MODID, "digging_dynamite", OedldoedlExplosives.TAB, ModRarities.WHITE, false, 1, 0);
	public static final Item DRILLING_DYNAMITE = new ItemDrillingDynamite(OedldoedlExplosives.MODID, "drilling_dynamite", OedldoedlExplosives.TAB, ModRarities.YELLOW, false, 1, 0);

	public static final Item GRAVEL_FIREWORK_DYNAMITE = new ItemGravelFireworkDynamite(OedldoedlExplosives.MODID, "gravel_firework_dynamite", OedldoedlExplosives.TAB, ModRarities.GRAY, false, 1, 0);
	public static final Item SAND_FIREWORK_DYNAMITE = new ItemSandFireworkDynamite(OedldoedlExplosives.MODID, "sand_firework_dynamite", OedldoedlExplosives.TAB, ModRarities.YELLOW, false, 1, 0);
	public static final Item DYNAMITE_FIREWORK = new ItemDynamiteFirework(OedldoedlExplosives.MODID, "dynamite_firework", OedldoedlExplosives.TAB, ModRarities.RED, false, 1, 0);

	public static final Item EGGSPLOSIVE = new ItemEggsplosive(OedldoedlExplosives.MODID, "eggsplosive", OedldoedlExplosives.TAB, ModRarities.WHITE, false, 2, 0);
	public static final Item GRENADE_APPLE = new ItemGrenadeApple(OedldoedlExplosives.MODID, "grenade_apple", OedldoedlExplosives.TAB, ModRarities.WHITE, false, 1, 0);

	public static final Item TNT_WRENCH = new ItemTNTWrench(OedldoedlExplosives.MODID, "tnt_wrench", OedldoedlExplosives.TAB, ModRarities.WHITE, false, 2, 0);
	public static final Item TNT_DISRUPTOR = new ItemTNTDisruptor(OedldoedlExplosives.MODID, "tnt_disruptor", OedldoedlExplosives.TAB, ModRarities.RED, true, 2, 0);
	public static final Item PLASTIC = new ModItemBase(OedldoedlExplosives.MODID, "plastic", OedldoedlExplosives.TAB, ModRarities.WHITE, false, 1, 0);
	public static final Item CHIP = new ModItemBase(OedldoedlExplosives.MODID, "chip", OedldoedlExplosives.TAB, ModRarities.YELLOW, false, 1, 0);
	public static final Item DIVIDED_BY_ZERO = new ItemDividedByZero(OedldoedlExplosives.MODID, "divided_by_zero", OedldoedlExplosives.TAB, ModRarities.RED, false, 1, 0);
}