package net.thep2wking.oedldoedlexplosives.registry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.thep2wking.oedldoedlcore.util.ModLogger;
import net.thep2wking.oedldoedlcore.util.ModRegistryHelper;
import net.thep2wking.oedldoedlexplosives.OedldoedlExplosives;
import net.thep2wking.oedldoedlexplosives.init.ModBlocks;
import net.thep2wking.oedldoedlexplosives.init.ModItems;
import net.thep2wking.oedldoedlexplosives.init.ModSounds;

@Mod.EventBusSubscriber
public class ModRegistry {
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {
		ModRegistryHelper.registerModels(event, OedldoedlExplosives.MODID);
	}

	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event) {
		ModLogger.registeredBlocksLogger(OedldoedlExplosives.MODID);
		ModRegistryHelper.registerBlock(event, ModBlocks.RAINBOW_BLOCK);
		ModRegistryHelper.registerBlock(event, ModBlocks.GUNPOWDER_BLOCK);

		ModRegistryHelper.registerBlock(event, ModBlocks.FAKE_TNT);
		ModRegistryHelper.registerBlock(event, ModBlocks.COMBAT_TNT);

		ModRegistryHelper.registerBlock(event, ModBlocks.TNT_X5_EPP);
		ModRegistryHelper.registerBlock(event, ModBlocks.TNT_X20_EPP);
		ModRegistryHelper.registerBlock(event, ModBlocks.C4);

		ModRegistryHelper.registerBlock(event, ModBlocks.DRILL_TNT);
		ModRegistryHelper.registerBlock(event, ModBlocks.FLAT_TNT_EPP);

		ModRegistryHelper.registerBlock(event, ModBlocks.NUKE_TNT);
		ModRegistryHelper.registerBlock(event, ModBlocks.METEOR_TNT_EPP);

		ModRegistryHelper.registerBlock(event, ModBlocks.DETONATOR_CHAIN_TNT);
		
		ModRegistryHelper.registerBlock(event, ModBlocks.DAY_TNT);
		ModRegistryHelper.registerBlock(event, ModBlocks.NIGHT_TNT);

		ModRegistryHelper.registerBlock(event, ModBlocks.SPHERE_TNT_EPP);
		ModRegistryHelper.registerBlock(event, ModBlocks.H_TNT);

		ModRegistryHelper.registerBlock(event, ModBlocks.DERPY_TNT);
		ModRegistryHelper.registerBlock(event, ModBlocks.INCENDITARY_TNT);
		ModRegistryHelper.registerBlock(event, ModBlocks.NAPALM_TNT);
		ModRegistryHelper.registerBlock(event, ModBlocks.SNOW_TNT);
		ModRegistryHelper.registerBlock(event, ModBlocks.SIR_DERPINGTON);

		ModRegistryHelper.registerBlock(event, ModBlocks.TNT_RAIN);
		ModRegistryHelper.registerBlock(event, ModBlocks.BUNDLED_TNT);

		ModRegistryHelper.registerBlock(event, ModBlocks.ISLAND_TNT);
		ModRegistryHelper.registerBlock(event, ModBlocks.SUPERSONIC_TNT);
		ModRegistryHelper.registerBlock(event, ModBlocks.WOOL_TNT);
		ModRegistryHelper.registerBlock(event, ModBlocks.RAINBOW_TNT);

		ModRegistryHelper.registerBlock(event, ModBlocks.TROLL_TNT);
		ModRegistryHelper.registerBlock(event, ModBlocks.CHUNK_TNT);
		ModRegistryHelper.registerBlock(event, ModBlocks.NUKE_NC);
		
		ModRegistryHelper.registerBlock(event, ModBlocks.NUKE_TNT_CB);
		ModRegistryHelper.registerBlock(event, ModBlocks.MEGA_NUKE_TNT);
		ModRegistryHelper.registerBlock(event, ModBlocks.ANTIMATTER_BOMB);

		ModRegistryHelper.registerBlock(event, ModBlocks.RANDOM_BLOCKS_TNT);
		ModRegistryHelper.registerBlock(event, ModBlocks.ISLAND_TNT_CB);
		ModRegistryHelper.registerBlock(event, ModBlocks.LAVA_TNT);
		ModRegistryHelper.registerBlock(event, ModBlocks.BUTTER_TNT);

		ModRegistryHelper.registerBlock(event, ModBlocks.EGG_TNT);
		ModRegistryHelper.registerBlock(event, ModBlocks.ARROW_TNT_CB);

		ModRegistryHelper.registerBlock(event, ModBlocks.CONFIGUREABLE_TNT);
		ModRegistryHelper.registerBlock(event, ModBlocks.LOLXD_TNT);
		ModRegistryHelper.registerBlock(event, ModBlocks.CRASH_TNT);

		ModRegistryHelper.registerBlock(event, ModBlocks.TNT_TREE);

		ModRegistryHelper.registerBlock(event, ModBlocks.FLOWER_POWER);
		ModRegistryHelper.registerBlock(event, ModBlocks.CUBIC_TNT);
		ModRegistryHelper.registerBlock(event, ModBlocks.ANIMAL_TNT);
		ModRegistryHelper.registerBlock(event, ModBlocks.GRAVEL_FIREWORK);
		ModRegistryHelper.registerBlock(event, ModBlocks.SAND_FIREWORK);
		ModRegistryHelper.registerBlock(event, ModBlocks.TNT_FIREWORK);
		ModRegistryHelper.registerBlock(event, ModBlocks.ENTITY_FIREWORK);

		ModRegistryHelper.registerBlock(event, ModBlocks.MULTIPLY_TNT);
		ModRegistryHelper.registerBlock(event, ModBlocks.GROVE_TNT);

		ModRegistryHelper.registerBlock(event, ModBlocks.LIGHNING_TNT);
		ModRegistryHelper.registerBlock(event, ModBlocks.VAPORIZE_TNT);

		ModRegistryHelper.registerBlock(event, ModBlocks.ENDER_TNT);
		ModRegistryHelper.registerBlock(event, ModBlocks.GRAVITY_TNT);
		ModRegistryHelper.registerBlock(event, ModBlocks.COMPACT_TNT);

		ModRegistryHelper.registerBlock(event, ModBlocks.EASTER_EGG);

		ModRegistryHelper.registerBlock(event, ModBlocks.FLAT_TNT);
		ModRegistryHelper.registerBlock(event, ModBlocks.MINING_FLAT_TNT);

		ModRegistryHelper.registerBlock(event, ModBlocks.DIGGING_TNT);
		ModRegistryHelper.registerBlock(event, ModBlocks.DRILLING_TNT);

		ModRegistryHelper.registerBlock(event, ModBlocks.TNT_X5);
		ModRegistryHelper.registerBlock(event, ModBlocks.TNT_X20);
		ModRegistryHelper.registerBlock(event, ModBlocks.TNT_X100);
		ModRegistryHelper.registerBlock(event, ModBlocks.TNT_X500);
		ModRegistryHelper.registerBlock(event, ModBlocks.TNT_X2000);

		ModRegistryHelper.registerBlock(event, ModBlocks.OVER_9000_TNT);
		ModRegistryHelper.registerBlock(event, ModBlocks.THEP2WKING_TNT);
	}

	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {
		ModLogger.registeredItemsLogger(OedldoedlExplosives.MODID);
		ModRegistryHelper.registerItemBlock(event, ModItems.RAINBOW_BLOCK);
		ModRegistryHelper.registerItemBlock(event, ModItems.GUNPOWDER_BLOCK);

		ModRegistryHelper.registerItemBlock(event, ModItems.FAKE_TNT);
		ModRegistryHelper.registerItemBlock(event, ModItems.COMBAT_TNT);

		ModRegistryHelper.registerItemBlock(event, ModItems.TNT_X5_EPP);
		ModRegistryHelper.registerItemBlock(event, ModItems.TNT_X20_EPP);
		ModRegistryHelper.registerItemBlock(event, ModItems.C4);

		ModRegistryHelper.registerItemBlock(event, ModItems.DRILL_TNT);
		ModRegistryHelper.registerItemBlock(event, ModItems.FLAT_TNT_PP);

		ModRegistryHelper.registerItemBlock(event, ModItems.NUKE_TNT);
		ModRegistryHelper.registerItemBlock(event, ModItems.METEOR_TNT_EPP);

		ModRegistryHelper.registerItemBlock(event, ModItems.DETONATOR_CHAIN_TNT);
		
		ModRegistryHelper.registerItemBlock(event, ModItems.DAY_TNT);
		ModRegistryHelper.registerItemBlock(event, ModItems.NIGHT_TNT);

		ModRegistryHelper.registerItemBlock(event, ModItems.SPHERE_TNT_EPP);
		ModRegistryHelper.registerItemBlock(event, ModItems.H_TNT);

		ModRegistryHelper.registerItemBlock(event, ModItems.DERPY_TNT);
		ModRegistryHelper.registerItemBlock(event, ModItems.INCENDITARY_TNT);
		ModRegistryHelper.registerItemBlock(event, ModItems.NAPALM_TNT);
		ModRegistryHelper.registerItemBlock(event, ModItems.SNOW_TNT);
		ModRegistryHelper.registerItemBlock(event, ModItems.SIR_DERPINGTON);

		ModRegistryHelper.registerItemBlock(event, ModItems.BUNDLED_TNT);
		ModRegistryHelper.registerItemBlock(event, ModItems.TNT_RAIN);

		ModRegistryHelper.registerItemBlock(event, ModItems.ISLAND_TNT);
		ModRegistryHelper.registerItemBlock(event, ModItems.SUPERSONIC_TNT);
		ModRegistryHelper.registerItemBlock(event, ModItems.WOOL_TNT);
		ModRegistryHelper.registerItemBlock(event, ModItems.RAINBOW_TNT);

		ModRegistryHelper.registerItemBlock(event, ModItems.TROLL_TNT);
		ModRegistryHelper.registerItemBlock(event, ModItems.CHUNK_TNT);
		ModRegistryHelper.registerItemBlock(event, ModItems.NUKE_NC);

		ModRegistryHelper.registerItemBlock(event, ModItems.NUKE_TNT_CB);
		ModRegistryHelper.registerItemBlock(event, ModItems.MEGA_NUKE_TNT);
		ModRegistryHelper.registerItemBlock(event, ModItems.ANTIMATTER_BOMB);

		ModRegistryHelper.registerItemBlock(event, ModItems.ISLAND_TNT_CB);
		ModRegistryHelper.registerItemBlock(event, ModItems.RANDOM_BLOCKS_TNT);
		ModRegistryHelper.registerItemBlock(event, ModItems.LAVA_TNT);
		ModRegistryHelper.registerItemBlock(event, ModItems.BUTTER_TNT);

		ModRegistryHelper.registerItemBlock(event, ModItems.EGG_TNT);
		ModRegistryHelper.registerItemBlock(event, ModItems.ARROW_TNT_CB);

		ModRegistryHelper.registerItemBlock(event, ModItems.CONFIGUREABLE_TNT);
		ModRegistryHelper.registerItemBlock(event, ModItems.LOLXD_TNT);
		ModRegistryHelper.registerItemBlock(event, ModItems.CRASH_TNT);

		ModRegistryHelper.registerItemBlock(event, ModItems.TNT_TREE);

		ModRegistryHelper.registerItemBlock(event, ModItems.FLOWER_POWER);
		ModRegistryHelper.registerItemBlock(event, ModItems.CUBIC_TNT);
		ModRegistryHelper.registerItemBlock(event, ModItems.ANIMAL_TNT);
		ModRegistryHelper.registerItemBlock(event, ModItems.GRAVEL_FIREWORK);
		ModRegistryHelper.registerItemBlock(event, ModItems.SAND_FIREWORK);
		ModRegistryHelper.registerItemBlock(event, ModItems.TNT_FIREWORK);
		ModRegistryHelper.registerItemBlock(event, ModItems.ENTITY_FIREWORK);

		ModRegistryHelper.registerItemBlock(event, ModItems.MULTIPLY_TNT);
		ModRegistryHelper.registerItemBlock(event, ModItems.GROVE_TNT);

		ModRegistryHelper.registerItemBlock(event, ModItems.LIGHNING_TNT);
		ModRegistryHelper.registerItemBlock(event, ModItems.VAPORIZE_TNT);
		ModRegistryHelper.registerItemBlock(event, ModItems.COMPACT_TNT);

		ModRegistryHelper.registerItemBlock(event, ModItems.ENDER_TNT);
		ModRegistryHelper.registerItemBlock(event, ModItems.GRAVITY_TNT);

		ModRegistryHelper.registerItemBlock(event, ModItems.EASTER_EGG);

		ModRegistryHelper.registerItemBlock(event, ModItems.FLAT_TNT);
		ModRegistryHelper.registerItemBlock(event, ModItems.MINING_FLAT_TNT);

		ModRegistryHelper.registerItemBlock(event, ModItems.DIGGING_TNT);
		ModRegistryHelper.registerItemBlock(event, ModItems.DRILLING_TNT);

		ModRegistryHelper.registerItemBlock(event, ModItems.TNT_X5);
		ModRegistryHelper.registerItemBlock(event, ModItems.TNT_X20);
		ModRegistryHelper.registerItemBlock(event, ModItems.TNT_X100);
		ModRegistryHelper.registerItemBlock(event, ModItems.TNT_X500);
		ModRegistryHelper.registerItemBlock(event, ModItems.TNT_X2000);

		ModRegistryHelper.registerItemBlock(event, ModItems.OVER_9000_TNT);
		ModRegistryHelper.registerItemBlock(event, ModItems.THEP2WKING_TNT);

		ModRegistryHelper.registerItem(event, ModItems.DYNAMITE);
		ModRegistryHelper.registerItem(event, ModItems.DYNAMITE_X5);
		ModRegistryHelper.registerItem(event, ModItems.DYNAMITE_X20);
		ModRegistryHelper.registerItem(event, ModItems.DYNAMITE_X100);
		ModRegistryHelper.registerItem(event, ModItems.DYNAMITE_X500);
		ModRegistryHelper.registerItem(event, ModItems.DYNAMITE_X2000);

		ModRegistryHelper.registerItem(event, ModItems.VAPORIZE_DYNAMITE);
		ModRegistryHelper.registerItem(event, ModItems.GRAVITY_DYNAMITE);
		ModRegistryHelper.registerItem(event, ModItems.LIGHTNING_DYNAMITE);
		ModRegistryHelper.registerItem(event, ModItems.COMPACT_DYNAMITE);

		ModRegistryHelper.registerItem(event, ModItems.COMBAT_DYNAMITE);
		ModRegistryHelper.registerItem(event, ModItems.CUBIC_DYNAMITE);
		ModRegistryHelper.registerItem(event, ModItems.ANIMAL_DYNAMITE);
		ModRegistryHelper.registerItem(event, ModItems.THEP2WKING_DYNAMITE);

		ModRegistryHelper.registerItem(event, ModItems.MULTIPLY_DYNAMITE);
		ModRegistryHelper.registerItem(event, ModItems.GROVE_DYNAMITE);

		ModRegistryHelper.registerItem(event, ModItems.ENDER_DYNAMITE);
		ModRegistryHelper.registerItem(event, ModItems.EASTER_EGG_DYNAMITE);

		ModRegistryHelper.registerItem(event, ModItems.FLAT_DYNAMITE);
		ModRegistryHelper.registerItem(event, ModItems.MINING_FLAT_DYNAMITE);

		ModRegistryHelper.registerItem(event, ModItems.DIGGING_DYNAMITE);
		ModRegistryHelper.registerItem(event, ModItems.DRILLING_DYNAMITE);

		ModRegistryHelper.registerItem(event, ModItems.GRAVEL_FIREWORK_DYNAMITE);		
		ModRegistryHelper.registerItem(event, ModItems.SAND_FIREWORK_DYNAMITE);
		ModRegistryHelper.registerItem(event, ModItems.DYNAMITE_FIREWORK);

		ModRegistryHelper.registerItem(event, ModItems.EGGSPLOSIVE);
		ModRegistryHelper.registerItem(event, ModItems.GRENADE_APPLE);

		ModRegistryHelper.registerItem(event, ModItems.TNT_WRENCH);
		ModRegistryHelper.registerItem(event, ModItems.TNT_DISRUPTOR);
		ModRegistryHelper.registerItem(event, ModItems.PLASTIC);
		ModRegistryHelper.registerItem(event, ModItems.CHIP);
		ModRegistryHelper.registerItem(event, ModItems.DIVIDED_BY_ZERO);
	}

	@SubscribeEvent
	public static void onSoundEventRegister(RegistryEvent.Register<SoundEvent> event) {
		ModLogger.registeredSoundEventsLogger(OedldoedlExplosives.MODID);

		ModRegistryHelper.registerSoundEvent(event, ModSounds.NUKE_ALARM);
		ModRegistryHelper.registerSoundEvent(event, ModSounds.TACTICAL_NUKE);
		ModRegistryHelper.registerSoundEvent(event, ModSounds.BOMB);
		ModRegistryHelper.registerSoundEvent(event, ModSounds.ATOMIC);

		ModRegistryHelper.registerSoundEvent(event, ModSounds.THEP2WKING);
	}
}