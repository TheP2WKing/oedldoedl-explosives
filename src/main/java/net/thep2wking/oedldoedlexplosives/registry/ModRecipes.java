package net.thep2wking.oedldoedlexplosives.registry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.thep2wking.oedldoedlcore.util.ModLogger;
import net.thep2wking.oedldoedlcore.util.ModRecipeHelper;
import net.thep2wking.oedldoedlexplosives.OedldoedlExplosives;
import net.thep2wking.oedldoedlexplosives.config.ExplosivesConfig;
import net.thep2wking.oedldoedlexplosives.init.ModBlocks;
import net.thep2wking.oedldoedlexplosives.init.ModItems;

public class ModRecipes {
	public static void registerOreDict() {
		ModLogger.registeredOreDictLogger(OedldoedlExplosives.MODID);

		if (ExplosivesConfig.RECIPES.DEFAULT_OREDICT) {
			ModRecipeHelper.addOreDict("blockRainbow", ModBlocks.RAINBOW, 0);

			ModRecipeHelper.addOreDict("tntC4", ModBlocks.C4, 0);
			ModRecipeHelper.addOreDict("tntX5", ModBlocks.TNT_X5, 0);
			ModRecipeHelper.addOreDict("tntX20", ModBlocks.TNT_X20, 0);

			ModRecipeHelper.addOreDict("dynamite", ModItems.DYNAMITE, 0);
			ModRecipeHelper.addOreDict("dynamiteX5", ModItems.DYNAMITE_X5, 0);
			ModRecipeHelper.addOreDict("dynamiteX20", ModItems.DYNAMITE_X20, 0);

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
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "rainbow_block",
					new ItemStack(ModBlocks.RAINBOW, 1, 0), "ABC", "DEF", "GHI", 'A', "dyeRed", 'B', "dyeOrange", 'C',
					"dyeYellow", 'D', "dyePurple", 'E', "wool", 'F', "dyeLime", 'G', "dyeMagenta", 'H', "dyeBlue", 'I',
					"dyeLightBlue");

			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "fake_tnt",
					new ItemStack(ModBlocks.FAKE_TNT, 1, 0), "ABA", "BCB", "ABA", 'A', "gunpowder", 'B', "sand", 'C',
					"dustRedstone");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "combat_tnt",
					new ItemStack(ModBlocks.COMBAT_TNT, 1, 0), " A ", "ABA", " A ", 'A',
					new ItemStack(Items.STONE_SWORD, 1, 0), 'B', "tntX5");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "c4", new ItemStack(ModBlocks.C4, 1, 0), "ABA",
					"BAB", "ABA", 'A', "sheetPlastic", 'B', "sand");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "tnt_x5", new ItemStack(ModBlocks.TNT_X5, 1, 0),
					"AA", "AA", 'A', "tnt");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "tnt_x20",
					new ItemStack(ModBlocks.TNT_X20, 1, 0), "AA", "AA", 'A', "tntX5");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "drill_tnt",
					new ItemStack(ModBlocks.DRILL_TNT, 1, 0), "ABA", "ABA", "ABA", 'A', "cobblestone", 'B', "tntX20");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "flat_tnt",
					new ItemStack(ModBlocks.FLAT_TNT, 1, 0), "AAA", "BBB", "AAA", 'A', "cobblestone", 'B', "tntX20");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "nuke_tnt",
					new ItemStack(ModBlocks.NUKE_TNT, 1, 0), "ABA", "ACA", "AAA", 'A', "tntX20", 'B', "powderUranium",
					'C', new ItemStack(ModBlocks.METEOR_TNT, 1, 0));
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "h_tnt", new ItemStack(ModBlocks.H_TNT, 1, 0),
					"ABA", "CDE", "AFA", 'A', "tntX20", 'B', "powderUranium", 'C',
					new ItemStack(ModBlocks.METEOR_TNT, 1, 0), 'D', new ItemStack(ModBlocks.NUKE_TNT, 1, 0), 'E',
					new ItemStack(ModBlocks.FLAT_TNT, 1, 0), 'F', new ItemStack(ModBlocks.DERPY_TNT, 1, 0));
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "meteor_tnt",
					new ItemStack(ModBlocks.METEOR_TNT, 1, 0), "ABA", "BBB", "ABA", 'A', "tntX5", 'B', "tntX20");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "sphere_tnt",
					new ItemStack(ModBlocks.SPHERE_TNT, 1, 0), " A ", "ABA", " A ", 'A', "tntX5", 'B', "tntX20");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "derpy_tnt",
					new ItemStack(ModBlocks.DERPY_TNT, 16, 0), "ABA", "BAB", "ABA", 'A', "tntC4", 'B', "enderpearl");
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
					new ItemStack(ModBlocks.SIR_DERPINGTON_TNT, 1, 0), "AAA", "ABA", "AAA", 'A',
					new ItemStack(Items.PORKCHOP, 1, 0), 'B', "tnt");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "tnt_rain",
					new ItemStack(ModBlocks.TNT_RAIN, 1, 0), "AAA", "ABA", "AAA", 'A',
					new ItemStack(ModBlocks.BUNDLED_TNT, 1, 0), 'B', "powderUranium");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "napalm_tnt",
					new ItemStack(ModBlocks.NAPALM_TNT, 1, 0), "ABA", "BAB", "ABA", 'A', "tntX5", 'B', "listAlllava");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "island_tnt",
					new ItemStack(ModBlocks.ISLAND_TNT, 1, 0), " A ", "BCB", " D ", 'A', "grass", 'B', "enderpearl",
					'C', "tntX20", 'D', "gunpowder");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "wool_tnt",
					new ItemStack(ModBlocks.WOOL_TNT, 1, 0), "AAA", "BBB", "AAA", 'A', "wool", 'B', "tntX20");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "snow_tnt",
					new ItemStack(ModBlocks.SNOW_TNT, 1, 0), "ABA", "BAB", "ABA", 'A', "tnt", 'B', "blockSnow");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "bundled_tnt",
					new ItemStack(ModBlocks.BUNDLED_TNT, 1, 0), "AAA", "ABA", "AAA", 'A', "tnt", 'B', "string");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "supersonic_tnt",
					new ItemStack(ModBlocks.SUPERSONIC_TNT, 1, 0), "ABA", "ABA", "ABA", 'A', "enderpearl", 'B',
					new ItemStack(ModBlocks.ISLAND_TNT, 1, 0));
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "rainbow_tnt",
					new ItemStack(ModBlocks.RAINBOW_TNT, 1, 0), "AAA", "ABA", "AAA", 'A', "blockRainbow", 'B', "tntX5");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "troll_tnt",
					new ItemStack(ModBlocks.TROLL_TNT, 1, 0), "ABA", "BCB", "ABA", 'A', "gunpowder", 'B',
					new ItemStack(ModBlocks.DETONATOR_CHAIN_TNT, 1, 0), 'C', "tntC4");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "chunk_tnt",
					new ItemStack(ModBlocks.CHUNK_TNT, 1, 0), "ABA", "ACA", "AAA", 'A',
					new ItemStack(ModBlocks.METEOR_TNT, 1, 0), 'B', "powderUranium", 'C',
					new ItemStack(ModBlocks.NUKE_TNT, 1, 0));
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "nuke_nc",
					new ItemStack(ModBlocks.NUKE_NC, 1, 0), "ABA", "ACA", "ADA", 'A',
					new ItemStack(ModBlocks.MINI_NUKE_TNT, 1, 0), 'B', "dustRedstone", 'C',
					new ItemStack(ModBlocks.METEOR_TNT, 1, 0), 'D', "dyeBlack");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "mini_nuke_tnt",
					new ItemStack(ModBlocks.MINI_NUKE_TNT, 1, 0), "ABA", "BAB", "ABA", 'A', "tntX5", 'B',
					new ItemStack(ModBlocks.INCENDITARY_TNT, 1, 0));
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "mega_nuke_tnt",
					new ItemStack(ModBlocks.MEGA_NUKE_TNT, 1, 0), "ABA", "CAC", "ACA", 'A',
					new ItemStack(ModBlocks.METEOR_TNT, 1, 0), 'B', "powderUranium", 'C',
					new ItemStack(ModBlocks.MINI_NUKE_TNT, 1, 0));
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "antimatter_bomb",
					new ItemStack(ModBlocks.ANTIMATTER_BOMB, 1, 0), " A ", "ABA", " A ", 'A',
					new ItemStack(ModBlocks.MEGA_NUKE_TNT, 1, 0), 'B', "powderUranium");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "butter_tnt",
					new ItemStack(ModBlocks.BUTTER_TNT, 1, 0), "AAA", "ABA", "AAA", 'A', "blockGold", 'B', "tntX20");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "lava_tnt",
					new ItemStack(ModBlocks.LAVA_TNT, 1, 0), " A ", "ABA", " A ", 'A', "listAlllava", 'B', "tntX5");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "egg_tnt",
					new ItemStack(ModBlocks.EGG_TNT, 1, 0), "AAA", "ABA", "AAA", 'A', "egg", 'B', "tnt");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "arrow_tnt",
					new ItemStack(ModBlocks.ARROW_TNT, 1, 0), "AAA", "ABA", "AAA", 'A', "arrow", 'B', "tnt");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "random_blocks_tnt",
					new ItemStack(ModBlocks.RANDOM_BLOCKS_TNT, 1, 0), "ABC", "BDB", "EBF", 'A',
					new ItemStack(Blocks.REDSTONE_LAMP, 1, 0), 'B', "gemDiamond", 'C', "plankWood", 'D', "tntX5", 'E',
					"stickWood", 'F', new ItemStack(Blocks.ACTIVATOR_RAIL, 1, 0));
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "crash_tnt",
					new ItemStack(ModBlocks.CRASH_TNT, 1, 0), "A", "B", 'A', "dividedByZero", 'B', "tnt");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "lolxd_tnt",
					new ItemStack(ModBlocks.LOLXD_TNT, 1, 0), "AAA", "ABA", "AAA", 'A', "blockCoal", 'B', "tntX5");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "tnt_tree",
					new ItemStack(ModBlocks.TNT_TREE, 1, 0), "ABA", "BCB", "ADA", 'A', "gunpowder", 'B',
					new ItemStack(ModBlocks.FAKE_TNT, 1, 0), 'C', "tntX5", 'D',
					new ItemStack(ModBlocks.TROLL_TNT, 1, 0));
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "configureable_tnt",
					new ItemStack(ModBlocks.CONFIGUREABLE_TNT, 1, 0), "ABA", "ACA", "ADA", 'A', "dustRedstone", 'B',
					"itemChip", 'C', "tnt", 'D', "gunpowder");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "flower_power",
					new ItemStack(ModBlocks.FLOWER_POWER, 1, 0), "ABA", "BAB", "ABA", 'A', "flower", 'B', "tnt");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "cubic_tnt",
					new ItemStack(ModBlocks.CUBIC_TNT, 1, 0), "AAA", "ABA", "AAA", 'A', "cobblestone", 'B', "tntX5");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "animal_tnt",
					new ItemStack(ModBlocks.ANIMAL_TNT, 1, 0), "ABC", "DEF", "GHI", 'A', "flesh", 'B', "bone", 'C',
					"string", 'D', "slimeball", 'E', "tnt", 'F', "rodBlaze", 'G', new ItemStack(Items.BEEF, 1, 0), 'H',
					new ItemStack(Items.PORKCHOP, 1, 0), 'I', new ItemStack(Items.CHICKEN, 1, 0));
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
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "over_9000_tnt",
					new ItemStack(ModBlocks.OVER_9000_TNT, 1, 0), "ABA", "CDC", "ACA", 'A',
					new ItemStack(ModBlocks.TNT_RAIN, 1, 0), 'B', "powderUranium", 'C',
					new ItemStack(ModBlocks.BUNDLED_TNT, 1, 0), 'D', new ItemStack(ModBlocks.H_TNT, 1, 0));
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "thep2wking_tnt",
					new ItemStack(ModItems.THEP2WKING_TNT, 1, 0), "ABA", "CBC", "DBD", 'A', "woolYellow", 'B',
					new ItemStack(ModBlocks.TROLL_TNT, 1, 0), 'C', "woolWhite", 'D', "woolBlack");

			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "dynamite",
					new ItemStack(ModItems.DYNAMITE, 4, 0), "A", 'A', "tnt");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "dynamite_x5",
					new ItemStack(ModItems.DYNAMITE_X5, 4, 0), "A", 'A', "tntX5");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "dynamite_x20",
					new ItemStack(ModItems.DYNAMITE_X20, 4, 0), "A", 'A', "tntX20");
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "combat_dynamite",
					new ItemStack(ModItems.COMBAT_DYNAMITE, 4, 0), "A", 'A', new ItemStack(ModBlocks.COMBAT_TNT, 1, 0));
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "cubic_dynamite",
					new ItemStack(ModItems.CUBIC_DYNAMITE, 4, 0), "A", 'A', new ItemStack(ModBlocks.CUBIC_TNT, 1, 0));
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "animal_dynamite",
					new ItemStack(ModItems.ANIMAL_DYNAMITE, 4, 0), "A", 'A', new ItemStack(ModBlocks.ANIMAL_TNT, 1, 0));
			ModRecipeHelper.addShapedRecipe(OedldoedlExplosives.MODID, "thep2wking_dynamite",
					new ItemStack(ModItems.THEP2WKING_DYNAMITE, 4, 0), "A", 'A',
					new ItemStack(ModBlocks.THEP2WKING_TNT, 1, 0));

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
					"ingotIron", 'C', "dyeOrange", 'D', new ItemStack(Blocks.STONE_BUTTON, 1, 0), 'E', "dustRedstone");
		}
	}
}