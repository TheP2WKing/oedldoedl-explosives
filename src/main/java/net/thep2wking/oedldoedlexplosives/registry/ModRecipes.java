package net.thep2wking.oedldoedlexplosives.registry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.thep2wking.oedldoedlcore.util.ModFluidUtil;
import net.thep2wking.oedldoedlcore.util.ModLogger;
import net.thep2wking.oedldoedlcore.util.ModRecipeHelper;
import net.thep2wking.oedldoedlexplosives.OedldoedlExplosives;
import net.thep2wking.oedldoedlexplosives.config.ExplosivesConfig;
import net.thep2wking.oedldoedlexplosives.init.ModBlocks;
import net.thep2wking.oedldoedlexplosives.init.ModItems;
import net.thep2wking.oedldoedlexplosives.util.ModExplosivesRecipeHelper;

public class ModRecipes {
	public static void registerOreDict() {
		ModLogger.registeredOreDictLogger(OedldoedlExplosives.MODID);

		if (ExplosivesConfig.RECIPES.DEFAULT_OREDICT) {
			ModRecipeHelper.addOreDict("blockRainbow", ModBlocks.RAINBOW_BLOCK, 0);
			ModRecipeHelper.addOreDict("blockGunpowder", ModBlocks.GUNPOWDER_BLOCK, 0);

			ModRecipeHelper.addOreDict("tntC4", ModBlocks.C4, 0);
			ModRecipeHelper.addOreDict("tntX5", ModBlocks.TNT_X5, 0);
			ModRecipeHelper.addOreDict("tntX5", ModBlocks.TNT_X5_EPP, 0);
			ModRecipeHelper.addOreDict("tntX20", ModBlocks.TNT_X20, 0);
			ModRecipeHelper.addOreDict("tntX20", ModBlocks.TNT_X20_EPP, 0);
			ModRecipeHelper.addOreDict("tntX100", ModBlocks.TNT_X100, 0);
			ModRecipeHelper.addOreDict("tntX500", ModBlocks.TNT_X500, 0);
			ModRecipeHelper.addOreDict("tntX2000", ModBlocks.TNT_X2000, 0);

			ModRecipeHelper.addOreDict("dynamite", ModItems.DYNAMITE, 0);
			ModRecipeHelper.addOreDict("dynamiteX5", ModItems.DYNAMITE_X5, 0);
			ModRecipeHelper.addOreDict("dynamiteX20", ModItems.DYNAMITE_X20, 0);
			ModRecipeHelper.addOreDict("dynamiteX100", ModItems.DYNAMITE_X100, 0);
			ModRecipeHelper.addOreDict("dynamiteX500", ModItems.DYNAMITE_X500, 0);
			ModRecipeHelper.addOreDict("dynamiteX2000", ModItems.DYNAMITE_X2000, 0);

			ModRecipeHelper.addOreDict("itemPlastic", ModItems.PLASTIC, 0);
			ModRecipeHelper.addOreDict("sheetPlastic", ModItems.PLASTIC, 0);
			ModRecipeHelper.addOreDict("plastic", ModItems.PLASTIC, 0);
			ModRecipeHelper.addOreDict("itemChip", ModItems.CHIP, 0);
			ModRecipeHelper.addOreDict("chip", ModItems.CHIP, 0);
			ModRecipeHelper.addOreDict("dividedByZero", ModItems.DIVIDED_BY_ZERO, 0);
		}
	}

	public static void registerRecipes() {
		ModLogger.registeredRecipesLogger(OedldoedlExplosives.MODID);

		if (ExplosivesConfig.RECIPES.DEFAULT_SMELTING_RECIPES) {
			ModRecipeHelper.addOreDictSmeltingRecipe(new ItemStack(ModItems.PLASTIC, 1, 0), "gemCoal", 0.35f);
		}

		if (ExplosivesConfig.RECIPES.DEFAULT_RECIPES) {
			ModRecipeHelper.addShapelessRecipe(OedldoedlExplosives.MODID, "rainbow_block",
					new ItemStack(ModBlocks.RAINBOW_BLOCK, 1, 0), "wool", "dyeRed", "dyeOrange", "dyeYellow",
					"dyeLime", "dyeBlue", "dyeLightBlue", "dyePurple", "dyeMagenta");

			ModRecipeHelper.add4xCompressRecipe(OedldoedlExplosives.MODID, "gunpowder_block_from_gunpowder",
					ModBlocks.GUNPOWDER_BLOCK, "gunpowder");
			ModRecipeHelper.add4xDecompressRecipe(OedldoedlExplosives.MODID, "gunpowder_from_gunpoder_block",
					Items.GUNPOWDER, "blockGunpowder");

			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "fake_tnt",
					new ItemStack(ModBlocks.FAKE_TNT, 1, 0), "ABA", "BCB", "ABA", 'A', "gunpowder", 'B', "sand", 'C',
					"dustRedstone");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "combat_tnt",
					new ItemStack(ModBlocks.COMBAT_TNT, 1, 0), " A ", "ABA", " A ", 'A',
					new ItemStack(Items.STONE_SWORD, 1, 0), 'B', "tntX5");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "c4", new ItemStack(ModBlocks.C4, 1, 0), "ABA",
					"BAB", "ABA", 'A', "sheetPlastic", 'B', "sand");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "tnt_x5_epp",
					new ItemStack(ModBlocks.TNT_X5_EPP, 1, 0), "ABA", "BAB", "ABA", 'A', "tnt", 'B', "sand");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "tnt_x20_epp",
					new ItemStack(ModBlocks.TNT_X20_EPP, 1, 0), "ABA", "B B", "ABA", 'A', "tntX5", 'B', "sand");

			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "tnt_x5", new ItemStack(ModBlocks.TNT_X5, 1, 0),
					"AA", "AA", 'A', "tnt");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "tnt_x20",
					new ItemStack(ModBlocks.TNT_X20, 1, 0), "AA", "AA", 'A', "tntX5");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "tnt_x100",
					new ItemStack(ModBlocks.TNT_X100, 1, 0), "AA", "AA", 'A', "tntX20");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "tnt_x500",
					new ItemStack(ModBlocks.TNT_X500, 1, 0), "AA", "AA", 'A', "tntX100");
			ModRecipeHelper.addShapelessRecipe(OedldoedlExplosives.MODID, "tnt_x2000",
					new ItemStack(ModBlocks.TNT_X2000, 1, 0), "tntX500", "powderUranium");

			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "drill_tnt",
					new ItemStack(ModBlocks.DRILL_TNT, 1, 0), "ABA", "ABA", "ABA", 'A', "cobblestone", 'B', "tntX20");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "flat_tnt_epp",
					new ItemStack(ModBlocks.FLAT_TNT_EPP, 1, 0), "AAA", "BBB", "AAA", 'A', "cobblestone", 'B',
					"tntX20");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "nuke_tnt",
					new ItemStack(ModBlocks.NUKE_TNT, 1, 0), "ABA", "ACA", "AAA", 'A', "tntX20", 'B', "powderUranium",
					'C', new ItemStack(ModBlocks.METEOR_TNT_EPP, 1, 0));
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "h_tnt", new ItemStack(ModBlocks.H_TNT, 1, 0),
					"ABA", "CDE", "AFA", 'A', "tntX20", 'B', "powderUranium", 'C',
					new ItemStack(ModBlocks.METEOR_TNT_EPP, 1, 0), 'D', new ItemStack(ModBlocks.NUKE_TNT, 1, 0), 'E',
					new ItemStack(ModBlocks.FLAT_TNT_EPP, 1, 0), 'F', new ItemStack(ModBlocks.DERPY_TNT, 1, 0));
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "meteor_tnt",
					new ItemStack(ModBlocks.METEOR_TNT_EPP, 1, 0), "ABA", "BBB", "ABA", 'A', "tntX5", 'B', "tntX20");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "sphere_tnt",
					new ItemStack(ModBlocks.SPHERE_TNT_EPP, 1, 0), " A ", "ABA", " A ", 'A', "tntX5", 'B', "tntX20");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "derpy_tnt",
					new ItemStack(ModBlocks.DERPY_TNT, 8, 0), "ABA", "BAB", "ABA", 'A', "tntC4", 'B', "enderpearl");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "incenditary_tnt",
					new ItemStack(ModBlocks.INCENDITARY_TNT, 1, 0), "ABA", "BAB", "ABA", 'A', "tnt", 'B',
					new ItemStack(Items.FIRE_CHARGE, 1, 0));
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "detonator_chain_tnt",
					new ItemStack(ModBlocks.DETONATOR_CHAIN_TNT, 8, 0), "AA", "AA", 'A', "tntC4");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "day_tnt",
					new ItemStack(ModBlocks.DAY_TNT, 1, 0), "ABA", "BCB", "ABA", 'A', "sand", 'B', "gunpowder", 'C',
					new ItemStack(Items.CLOCK, 1, 0));
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "night_tnt",
					new ItemStack(ModBlocks.NIGHT_TNT, 1, 0), "ABA", "BCB", "ABA", 'A', "gunpowder", 'B', "sand", 'C',
					new ItemStack(Items.CLOCK, 1, 0));
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "sir_derpington_tnt",
					new ItemStack(ModBlocks.SIR_DERPINGTON, 1, 0), "AAA", "ABA", "AAA", 'A',
					new ItemStack(Items.PORKCHOP, 1, 0), 'B', "tnt");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "tnt_rain",
					new ItemStack(ModBlocks.TNT_RAIN, 1, 0), "AAA", "ABA", "AAA", 'A',
					new ItemStack(ModBlocks.BUNDLED_TNT, 1, 0), 'B', "powderUranium");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "napalm_tnt",
					new ItemStack(ModBlocks.NAPALM_TNT, 1, 0), "ABA", "BAB", "ABA", 'A', "tntX5", 'B', "listAlllava");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "island_tnt",
					new ItemStack(ModBlocks.ISLAND_TNT, 1, 0), " A ", "BCB", " D ", 'A', "grass", 'B', "enderpearl",
					'C', new ItemStack(ModBlocks.SPHERE_TNT_EPP, 1, 0), 'D', "gunpowder");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "wool_tnt",
					new ItemStack(ModBlocks.WOOL_TNT, 1, 0), "AAA", "BBB", "AAA", 'A', "wool", 'B', "tntX20");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "snow_tnt",
					new ItemStack(ModBlocks.SNOW_TNT, 1, 0), "ABA", "BAB", "ABA", 'A', "tnt", 'B', "blockSnow");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "bundled_tnt",
					new ItemStack(ModBlocks.BUNDLED_TNT, 1, 0), "AAA", "ABA", "AAA", 'A', "tnt", 'B', "string");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "supersonic_tnt",
					new ItemStack(ModBlocks.SUPERSONIC_TNT, 1, 0), " A ", "BCB", " D ", 'A', "feather", 'B',
					"enderpearl",
					'C', new ItemStack(ModBlocks.ISLAND_TNT, 1, 0), 'D', "gunpowder");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "rainbow_tnt",
					new ItemStack(ModBlocks.RAINBOW_TNT, 1, 0), "AAA", "ABA", "AAA", 'A', "blockRainbow", 'B', "tnt");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "troll_tnt",
					new ItemStack(ModBlocks.TROLL_TNT, 2, 0), "ABA", "BCB", "ABA", 'A', "gunpowder", 'B',
					new ItemStack(ModBlocks.DETONATOR_CHAIN_TNT, 1, 0), 'C', "tntC4");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "chunk_tnt",
					new ItemStack(ModBlocks.CHUNK_TNT, 1, 0), "ABA", "ACA", "AAA", 'A',
					new ItemStack(ModBlocks.METEOR_TNT_EPP, 1, 0), 'B', "powderUranium", 'C',
					new ItemStack(ModBlocks.NUKE_TNT, 1, 0));
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "nuke_nc",
					new ItemStack(ModBlocks.NUKE_NC, 1, 0), "ABA", "ACA", "ADA", 'A',
					new ItemStack(ModBlocks.NUKE_TNT_CB, 1, 0), 'B', "dustRedstone", 'C',
					new ItemStack(ModBlocks.METEOR_TNT_EPP, 1, 0), 'D', "dyeBlack");

			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "nuke_tnt_cb",
					new ItemStack(ModBlocks.NUKE_TNT_CB, 1, 0), "AAA", "ABA", "AAA", 'A', "gunpowder", 'B', "tntX5");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "mega_nuke_tnt",
					new ItemStack(ModBlocks.MEGA_NUKE_TNT, 1, 0), "ABA", "BCB", "ABA", 'A', "blockGunpowder", 'B',
					"gunpowder", 'C', new ItemStack(ModBlocks.NUKE_TNT_CB, 1, 0));
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "antimatter_bomb",
					new ItemStack(ModBlocks.ANTIMATTER_BOMB, 1, 0), " A ", "ABA", " A ", 'A',
					new ItemStack(ModBlocks.MEGA_NUKE_TNT, 1, 0), 'B', "powderUranium");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "butter_tnt",
					new ItemStack(ModBlocks.BUTTER_TNT, 1, 0), "AAA", "ABA", "AAA", 'A', "blockGold", 'B', "tnt");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "lava_tnt",
					new ItemStack(ModBlocks.LAVA_TNT, 1, 0), "ABA", "AAA", 'A', "listAlllava", 'B', "tntX5");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "egg_tnt",
					new ItemStack(ModBlocks.EGG_TNT, 1, 0), "AAA", "ABA", "AAA", 'A', "egg", 'B', "tnt");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "arrow_tnt",
					new ItemStack(ModBlocks.ARROW_TNT_CB, 1, 0), "AAA", "ABA", "AAA", 'A', "arrow", 'B', "tnt");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "island_tnt_cb",
					new ItemStack(ModBlocks.ISLAND_TNT_CB, 1, 0), "ABA", "AAA", 'A', "listAllwater", 'B', "tntX5");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "random_blocks_tnt",
					new ItemStack(ModBlocks.RANDOM_BLOCKS_TNT, 1, 0), "ABC", "BDB", "EBF", 'A',
					new ItemStack(Blocks.REDSTONE_LAMP, 1, 0), 'B', "gemDiamond", 'C', "plankWood", 'D', "tntX5", 'E',
					"stickWood", 'F', new ItemStack(Blocks.ACTIVATOR_RAIL, 1, 0));
			ModRecipeHelper.addShapelessRecipe(OedldoedlExplosives.MODID, "crash_tnt",
					new ItemStack(ModBlocks.CRASH_TNT, 1, 0), "tnt", "dividedByZero");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "lolxd_tnt",
					new ItemStack(ModBlocks.LOLXD_TNT, 1, 0), "AAA", "ABA", "AAA", 'A', "blockCoal", 'B', "tnt");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "tnt_tree",
					new ItemStack(ModBlocks.TNT_TREE, 1, 0), "ABA", "BCB", "ADA", 'A', "gunpowder", 'B',
					new ItemStack(ModBlocks.FAKE_TNT, 1, 0), 'C', "tntX5", 'D',
					new ItemStack(ModBlocks.TROLL_TNT, 1, 0));
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "configureable_tnt",
					new ItemStack(ModBlocks.CONFIGUREABLE_TNT, 1, 0), "ABA", "ACA", "ADA", 'A', "dustRedstone", 'B',
					"itemChip", 'C', "tnt", 'D', "gunpowder");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "flower_power",
					new ItemStack(ModBlocks.FLOWER_POWER, 1, 0), "ABA", "BAB", "ABA", 'A', "tnt", 'B', "flower");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "cubic_tnt",
					new ItemStack(ModBlocks.CUBIC_TNT, 1, 0), "AAA", "ABA", "AAA", 'A', "cobblestone", 'B', "tntX5");

			ModRecipeHelper.addShapelessRecipe(OedldoedlExplosives.MODID, "animal_tnt",
					new ItemStack(ModBlocks.ANIMAL_TNT, 1, 0), "tnt", new ItemStack(Items.BEEF, 1, 0),
					new ItemStack(Items.PORKCHOP, 1, 0), new ItemStack(Items.CHICKEN, 1, 0), "flesh", "bone", "string",
					"slimeball", "enderpearl");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "gravel_firework",
					new ItemStack(ModBlocks.GRAVEL_FIREWORK, 1, 0), "AAA", "ABA", "ACA", 'A', "gravel", 'B', "tntX5",
					'C', "fireworkCharge");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "sand_firework",
					new ItemStack(ModBlocks.SAND_FIREWORK, 1, 0), "AAA", "ABA", "ACA", 'A', "sand", 'B', "tntX5", 'C',
					"fireworkCharge");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "tnt_firework",
					new ItemStack(ModBlocks.TNT_FIREWORK, 1, 0), "AAA", "ABA", "ACA", 'A', "tntX20", 'B', "tntX5", 'C',
					"fireworkCharge");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "entity_firework",
					new ItemStack(ModBlocks.ENTITY_FIREWORK, 1, 0), "ABC", "DEF", "GHI", 'A', "spiderEye", 'B', "skull",
					'C', new ItemStack(Items.PORKCHOP, 1, 0), 'D', "flesh", 'E',
					new ItemStack(ModBlocks.TNT_FIREWORK, 1, 0), 'F', "leather", 'G', "bone", 'H', "powderUranium", 'I',
					"wool");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "multiply_tnt",
					new ItemStack(ModBlocks.MULTIPLY_TNT, 1, 0), "ABA", "BCB", "ABA", 'A', "bonemeal", 'B', "ingotGold",
					'C', "tnt");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "grove_tnt",
					new ItemStack(ModBlocks.GROVE_TNT, 1, 0), "AAA", "BCB", "DDD", 'A', "treeSapling", 'B', "bonemeal",
					'C', "tntX5", 'D', "dirt");
			ModRecipeHelper.addShapelessRecipe(OedldoedlExplosives.MODID, "lightning_tnt",
					new ItemStack(ModBlocks.LIGHNING_TNT, 1, 0), new ItemStack(ModBlocks.COMPACT_TNT, 1, 0),
					"rodBlaze");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "vaporize_tnt",
					new ItemStack(ModBlocks.VAPORIZE_TNT, 1, 0), " A ", "ABA", " A ", 'A',
					new ItemStack(Items.BUCKET, 1, 0), 'B', "tntX20");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "compact_tnt",
					new ItemStack(ModBlocks.COMPACT_TNT, 1, 0), "AAA", "ABA", "AAA", 'A', "tnt", 'B', "tntX5");
			ModRecipeHelper.addShapelessRecipe(OedldoedlExplosives.MODID, "ender_tnt",
					new ItemStack(ModBlocks.ENDER_TNT, 1, 0), "tnt", "enderpearl");
			ModRecipeHelper.addShapelessRecipe(OedldoedlExplosives.MODID, "gravity_tnt",
					new ItemStack(ModBlocks.GRAVITY_TNT, 1, 0), new ItemStack(ModBlocks.ENDER_TNT, 1, 0), "cropApple");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "easter_egg",
					new ItemStack(ModBlocks.EASTER_EGG, 1, 0), "ABA", "CCC", "DBD", 'A',
					new ItemStack(Items.MELON_SEEDS, 1, 0), 'B', "tntX20", 'C', "bonemeal", 'D',
					new ItemStack(Items.PUMPKIN_SEEDS, 1, 0));
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "flat_tnt",
					new ItemStack(ModBlocks.FLAT_TNT, 1, 0), "A", "B", 'A', "tntX20", 'B', "obsidian");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "mining_flat_tnt",
					new ItemStack(ModBlocks.MINING_FLAT_TNT, 1, 0), "AAA", "BCB", "AAA", 'A', "torch", 'B', "tntX5",
					'C', new ItemStack(ModBlocks.FLAT_TNT, 1, 0));
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "drigging_tnt",
					new ItemStack(ModBlocks.DIGGING_TNT, 1, 0), "A", "A", "B", 'A', "tntX5", 'B',
					ModFluidUtil.addFluidBucket(FluidRegistry.WATER));
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "drilling",
					new ItemStack(ModBlocks.DRILLING_TNT, 1, 0), "A", "B", "C", 'A',
					new ItemStack(ModBlocks.DIGGING_TNT, 1, 0), 'B', "tntX100", 'C',
					ModFluidUtil.addFluidBucket(FluidRegistry.WATER));

			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "over_9000_tnt",
					new ItemStack(ModBlocks.OVER_9000_TNT, 1, 0), "ABA", "CDC", "ACA", 'A',
					new ItemStack(ModBlocks.TNT_RAIN, 1, 0), 'B', "powderUranium", 'C',
					new ItemStack(ModBlocks.BUNDLED_TNT, 1, 0), 'D', new ItemStack(ModBlocks.H_TNT, 1, 0));
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "thep2wking_tnt",
					new ItemStack(ModBlocks.THEP2WKING_TNT, 1, 0), "ABA", "CBC", "DBD", 'A', "woolYellow", 'B',
					new ItemStack(ModBlocks.TROLL_TNT, 1, 0), 'C', "woolWhite", 'D', "woolBlack");

			ModExplosivesRecipeHelper.addDynamiteRecipe("dynamite", ModItems.DYNAMITE, "tnt");
			ModExplosivesRecipeHelper.addDynamiteRecipe("dynamite_x5", ModItems.DYNAMITE_X5, "tntX5");
			ModExplosivesRecipeHelper.addDynamiteRecipe("dynamite_x20", ModItems.DYNAMITE_X20, "tntX20");
			ModExplosivesRecipeHelper.addDynamiteRecipe("dynamite_x100", ModItems.DYNAMITE_X100, "tntX100");
			ModExplosivesRecipeHelper.addDynamiteRecipe("dynamite_x500", ModItems.DYNAMITE_X500, "tntX500");
			ModExplosivesRecipeHelper.addDynamiteRecipe("dynamite_x2000", ModItems.DYNAMITE_X2000, "tntX2000");

			ModExplosivesRecipeHelper.addDynamiteRecipe("vaporize_dynamite", ModItems.VAPORIZE_DYNAMITE,
					ModBlocks.VAPORIZE_TNT);
			ModExplosivesRecipeHelper.addDynamiteRecipe("gravity_dynamite", ModItems.GRAVITY_DYNAMITE,
					ModBlocks.GRAVITY_TNT);
			ModExplosivesRecipeHelper.addDynamiteRecipe("lightning_dynamite", ModItems.LIGHTNING_DYNAMITE,
					ModBlocks.LIGHNING_TNT);
			ModExplosivesRecipeHelper.addDynamiteRecipe("compact_dynamite", ModItems.COMPACT_DYNAMITE,
					ModBlocks.COMPACT_TNT);

			ModExplosivesRecipeHelper.addDynamiteRecipe("combat_dynamite", ModItems.COMBAT_DYNAMITE,
					ModBlocks.COMBAT_TNT);
			ModExplosivesRecipeHelper.addDynamiteRecipe("cubic_dynamite", ModItems.CUBIC_DYNAMITE, ModBlocks.CUBIC_TNT);
			ModExplosivesRecipeHelper.addDynamiteRecipe("animal_dynamite", ModItems.ANIMAL_DYNAMITE,
					ModBlocks.ANIMAL_TNT);
			ModExplosivesRecipeHelper.addDynamiteRecipe("thep2wking_dynamite", ModItems.THEP2WKING_DYNAMITE,
					ModBlocks.THEP2WKING_TNT);

			ModExplosivesRecipeHelper.addDynamiteRecipe("multiply_dynamite", ModItems.MULTIPLY_DYNAMITE,
					ModBlocks.MULTIPLY_TNT);
			ModExplosivesRecipeHelper.addDynamiteRecipe("grove_dynamite", ModItems.GROVE_DYNAMITE, ModBlocks.GROVE_TNT);
			ModExplosivesRecipeHelper.addDynamiteRecipe("ender_dynamite", ModItems.ENDER_DYNAMITE, ModBlocks.ENDER_TNT);
			ModExplosivesRecipeHelper.addDynamiteRecipe("easter_egg_dynamite", ModItems.EASTER_EGG_DYNAMITE,
					ModBlocks.EASTER_EGG);
			ModExplosivesRecipeHelper.addDynamiteRecipe("flat_dynamite", ModItems.FLAT_DYNAMITE, ModBlocks.FLAT_TNT);
			ModExplosivesRecipeHelper.addDynamiteRecipe("mining_flat_dynamite", ModItems.MINING_FLAT_DYNAMITE,
					ModBlocks.MINING_FLAT_TNT);
			ModExplosivesRecipeHelper.addDynamiteRecipe("digging_dynamite", ModItems.DIGGING_DYNAMITE,
					ModBlocks.DIGGING_TNT);
			ModExplosivesRecipeHelper.addDynamiteRecipe("drilling_dynamite", ModItems.DRILLING_DYNAMITE,
					ModBlocks.DRILLING_TNT);

			ModExplosivesRecipeHelper.addDynamiteRecipe("gravel_firework_Dynamite", ModItems.GRAVEL_FIREWORK_DYNAMITE,
					ModBlocks.GRAVEL_FIREWORK);
			ModExplosivesRecipeHelper.addDynamiteRecipe("sand_firework_dynamite", ModItems.SAND_FIREWORK_DYNAMITE,
					ModBlocks.SAND_FIREWORK);
			ModExplosivesRecipeHelper.addDynamiteRecipe("dynamite_firework", ModItems.DYNAMITE_FIREWORK,
					ModBlocks.TNT_FIREWORK);

			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "eggsplosive",
					new ItemStack(ModItems.EGGSPLOSIVE, 6, 0), "ABA", "ACA", "ACA", 'A', "egg", 'B', "nuggetIron", 'C',
					"gunpowder");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "grenade_apple",
					new ItemStack(ModItems.GRENADE_APPLE, 6, 0), "ABA", "ACA", "ACA", 'A', "cropApple", 'B',
					"nuggetIron", 'C', "gunpowder");

			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "tnt_wrench",
					new ItemStack(ModItems.TNT_WRENCH, 1, 0), "  A", " B ", "B  ", 'A', "toolShears", 'B', "ingotIron");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "chip", new ItemStack(ModItems.CHIP, 1, 0),
					"AAA", "BCB", "AAA", 'A', "ingotIron", 'B', "woolBlack", 'C', "dustRedstone");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "divided_by_zero",
					new ItemStack(ModItems.DIVIDED_BY_ZERO, 1, 0), "ABC", "DED", "DBD", 'A', "dyeBlack", 'B',
					"ingotIron", 'C', "dyeOrange", 'D', "buttonStone", 'E', "dustRedstone");

			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "tnt_disruptor",
					new ItemStack(ModItems.TNT_DISRUPTOR, 1, 0), " AB", " AA", "C  ", 'A', "commandBlock", 'B', "tnt",
					'C', "stickWood");
		}
	}
}