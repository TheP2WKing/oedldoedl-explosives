package net.thep2wking.oedldoedlexplosives.config.categories;

import net.minecraftforge.common.config.Config;

public class Content {
	@Config.Name("TNT Wrench Disarm")
	public boolean TNT_WRENCH_DISARM = true;

	@Config.Name("Troll TNT Multiply")
	public boolean TROLL_TNT_MULTIPLY = true;

	@Config.Name("Fake TNT Block Damage")
	public boolean FAKE_TNT_BLOCK_DAMAGE = true;

	@Config.Name("Intended Game Crashing")
	public boolean INTENDED_GAME_CRASHING = true;

	@Config.Name("Random Blocks TNT Max ID")
	@Config.RangeInt(min = 0, max = 10000)
	public int RANDOM_BLOCKS_TNT_MAX_ID = 230;

	@Config.Name("Over 900 TNT Keeps Spawning TNT")
	public boolean OVER_9000_TNT_KEEPS_SPAWNING_TNT = true;

	@Config.Name("TheP2WKing Carries Troll TNT")
	public boolean THEP2WKING_CARRIES_TROLL_TNT = true;

	@Config.Name("Spawn TheP2WKing")
	public boolean SPAWN_THEP2WKING = true;

	@Config.Name("Entity Firework Radius")
	@Config.RangeInt(min = 0, max = 16)
	public int ENTITY_FIREWORK_RADIUS = 5;

	@Config.Name("TNT Disrupter Useable In Survival")
	public boolean TNT_DISRUPTER_USEABLE_IN_SURVIVAL = false;

	@Config.Name("TNT Disrupter Radius")
	@Config.RangeInt(min = 0, max = 100)
	public int TNT_DISRUPTER_RADIUS = 20;
}