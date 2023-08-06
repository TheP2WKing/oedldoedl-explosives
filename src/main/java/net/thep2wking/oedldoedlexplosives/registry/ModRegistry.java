package net.thep2wking.oedldoedlexplosives.registry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.SoundEvent;
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
	public static void onBlockRegister(RegistryEvent.Register<Block> event) {
		ModLogger.registeredBlocksLogger(OedldoedlExplosives.MODID);
		ModRegistryHelper.registerBlock(event, ModBlocks.C4);
		ModRegistryHelper.registerBlock(event, ModBlocks.TNT_X5);
		ModRegistryHelper.registerBlock(event, ModBlocks.TNT_X20);

		ModRegistryHelper.registerBlock(event, ModBlocks.DRILL_TNT);
		ModRegistryHelper.registerBlock(event, ModBlocks.FLAT_TNT);

		ModRegistryHelper.registerBlock(event, ModBlocks.NUKE_TNT);

		ModRegistryHelper.registerBlock(event, ModBlocks.DETONATOR_CHAIN_TNT);
		ModRegistryHelper.registerBlock(event, ModBlocks.DAY_TNT);
		ModRegistryHelper.registerBlock(event, ModBlocks.NIGHT_TNT);
		ModRegistryHelper.registerBlock(event, ModBlocks.SIR_DERPINGTON_TNT);
		ModRegistryHelper.registerBlock(event, ModBlocks.TNT_RAIN);

		ModRegistryHelper.registerBlock(event, ModBlocks.NAPALM_TNT);
		ModRegistryHelper.registerBlock(event, ModBlocks.ISLAND_TNT);

		ModRegistryHelper.registerBlock(event, ModBlocks.NUKE);
		ModRegistryHelper.registerBlock(event, ModBlocks.TROLL_TNT);
		ModRegistryHelper.registerBlock(event, ModBlocks.CHUNK_TNT);

		ModRegistryHelper.registerBlock(event, ModBlocks.MEGA_NUKE_TNT);
		ModRegistryHelper.registerBlock(event, ModBlocks.ANTIMATTER_BOMB);

		ModRegistryHelper.registerBlock(event, ModBlocks.BUTTER_TNT);
		ModRegistryHelper.registerBlock(event, ModBlocks.LAVA_TNT);
		ModRegistryHelper.registerBlock(event, ModBlocks.EGG_TNT);
		ModRegistryHelper.registerBlock(event, ModBlocks.ARROW_TNT);
	}

	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {
		ModLogger.registeredItemsLogger(OedldoedlExplosives.MODID);
		ModRegistryHelper.registerItemBlock(event, ModItems.C4);
		ModRegistryHelper.registerItemBlock(event, ModItems.TNT_X5);
		ModRegistryHelper.registerItemBlock(event, ModItems.TNT_X20);

		ModRegistryHelper.registerItemBlock(event, ModItems.DRILL_TNT);
		ModRegistryHelper.registerItemBlock(event, ModItems.FLAT_TNT);

		ModRegistryHelper.registerItemBlock(event, ModItems.NUKE_TNT);

		ModRegistryHelper.registerItemBlock(event, ModItems.DETONATOR_CHAIN_TNT);
		ModRegistryHelper.registerItemBlock(event, ModItems.DAY_TNT);
		ModRegistryHelper.registerItemBlock(event, ModItems.NIGHT_TNT);
		ModRegistryHelper.registerItemBlock(event, ModItems.SIR_DERPINGTON_TNT);
		ModRegistryHelper.registerItemBlock(event, ModItems.TNT_RAIN);

		ModRegistryHelper.registerItemBlock(event, ModItems.NAPALM_TNT);
		ModRegistryHelper.registerItemBlock(event, ModItems.ISLAND_TNT);

		ModRegistryHelper.registerItemBlock(event, ModItems.NUKE);
		ModRegistryHelper.registerItemBlock(event, ModItems.TROLL_TNT);
		ModRegistryHelper.registerItemBlock(event, ModItems.CHUNK_TNT);

		ModRegistryHelper.registerItemBlock(event, ModItems.MEGA_NUKE_TNT);
		ModRegistryHelper.registerItemBlock(event, ModItems.ANTIMATTER_BOMB);

		ModRegistryHelper.registerItemBlock(event, ModItems.BUTTER_TNT);
		ModRegistryHelper.registerItemBlock(event, ModItems.LAVA_TNT);
		ModRegistryHelper.registerItemBlock(event, ModItems.EGG_TNT);
		ModRegistryHelper.registerItemBlock(event, ModItems.ARROW_TNT);
	}

	@SubscribeEvent
	public static void onSoundEventRegister(RegistryEvent.Register<SoundEvent> event) {
		ModLogger.registeredSoundEventsLogger(OedldoedlExplosives.MODID);

		ModRegistryHelper.registerSoundEvent(event, ModSounds.NUKE_ALARM);
		ModRegistryHelper.registerSoundEvent(event, ModSounds.TACTICAL_NUKE);
		ModRegistryHelper.registerSoundEvent(event, ModSounds.BOMB);
		ModRegistryHelper.registerSoundEvent(event, ModSounds.ATOMIC);
	}
}