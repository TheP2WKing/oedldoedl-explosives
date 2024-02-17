package net.thep2wking.oedldoedlexplosives.util;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.oedldoedlcore.util.ModRenderHelper;
import net.thep2wking.oedldoedlexplosives.api.ModTNTRenderer;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityAnimalTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityAntimatterBomb;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityArrowTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityBundledTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityButterTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityC4;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityChunkTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityCombatTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityConfigureableTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityCrashTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityCubicTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityDayTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityDerpyTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityDetonatorChainTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityDrillTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityEggTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityEntityFirework;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityFakeTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityFlatTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityFlowerPower;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityHTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityIncenditaryTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityIslandTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityLOLXDTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityLavaTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityMegaNukeTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityMeteorTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityMiniNukeTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityNCNuke;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityNapalmTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityNightTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityNukeTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityOver9000TNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityRainbowTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityRandomBlocksTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityTNTFireworkCustomTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntitySirDerpingtonTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntitySnowTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntitySphereTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntitySupersonicTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityTNTFirework;
import net.thep2wking.oedldoedlexplosives.content.entity.EntitySandFirework;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityTNTRain;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityTNTTree;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityTNTx20;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityTNTx5;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityTheP2WKingTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityTrollTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityWoolTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.living.EntityTheP2WKing;
import net.thep2wking.oedldoedlexplosives.content.entity.living.RenderTheP2WKing;
import net.thep2wking.oedldoedlexplosives.content.entity.throwable.EntityAnimalDynamite;
import net.thep2wking.oedldoedlexplosives.content.entity.throwable.EntityCombatDynamite;
import net.thep2wking.oedldoedlexplosives.content.entity.throwable.EntityCubicDynamite;
import net.thep2wking.oedldoedlexplosives.content.entity.throwable.EntityDynamite;
import net.thep2wking.oedldoedlexplosives.content.entity.throwable.EntityDynamiteX20;
import net.thep2wking.oedldoedlexplosives.content.entity.throwable.EntityDynamiteX5;
import net.thep2wking.oedldoedlexplosives.content.entity.throwable.EntityEggsplosive;
import net.thep2wking.oedldoedlexplosives.content.entity.throwable.EntityGrenadeApple;
import net.thep2wking.oedldoedlexplosives.content.entity.throwable.EntityTheP2WKingDynamite;
import net.thep2wking.oedldoedlexplosives.init.ModBlocks;
import net.thep2wking.oedldoedlexplosives.init.ModItems;

public class ModRenderer {
	public static void registerRenderer() {
		ModTNTRenderer.register(EntityFakeTNT.class, ModBlocks.FAKE_TNT);
		ModTNTRenderer.register(EntityCombatTNT.class, ModBlocks.COMBAT_TNT);

		ModTNTRenderer.register(EntityC4.class, ModBlocks.C4);
		ModTNTRenderer.register(EntityTNTx5.class, ModBlocks.TNT_X5);
		ModTNTRenderer.register(EntityTNTx20.class, ModBlocks.TNT_X20);

		ModTNTRenderer.register(EntityDrillTNT.class, ModBlocks.DRILL_TNT);
		ModTNTRenderer.register(EntityFlatTNT.class, ModBlocks.FLAT_TNT);

		ModTNTRenderer.register(EntityNukeTNT.class, ModBlocks.NUKE_TNT);
		ModTNTRenderer.register(EntityHTNT.class, ModBlocks.H_TNT);

		ModTNTRenderer.register(EntityMeteorTNT.class, ModBlocks.METEOR_TNT);
		ModTNTRenderer.register(EntitySphereTNT.class, ModBlocks.SPHERE_TNT);
		ModTNTRenderer.register(EntityDerpyTNT.class, ModBlocks.DERPY_TNT);
		ModTNTRenderer.register(EntityIncenditaryTNT.class, ModBlocks.INCENDITARY_TNT);

		ModTNTRenderer.register(EntityDetonatorChainTNT.class, ModBlocks.DETONATOR_CHAIN_TNT);
		ModTNTRenderer.register(EntityDayTNT.class, ModBlocks.DAY_TNT);
		ModTNTRenderer.register(EntityNightTNT.class, ModBlocks.NIGHT_TNT);
		ModTNTRenderer.register(EntitySirDerpingtonTNT.class, ModBlocks.SIR_DERPINGTON_TNT);
		ModTNTRenderer.register(EntityTNTRain.class, ModBlocks.TNT_RAIN);

		ModTNTRenderer.register(EntityNapalmTNT.class, ModBlocks.NAPALM_TNT);
		ModTNTRenderer.register(EntityIslandTNT.class, ModBlocks.ISLAND_TNT);
		ModTNTRenderer.register(EntityWoolTNT.class, ModBlocks.WOOL_TNT);

		ModTNTRenderer.register(EntitySnowTNT.class, ModBlocks.SNOW_TNT);
		ModTNTRenderer.register(EntityBundledTNT.class, ModBlocks.BUNDLED_TNT);
		ModTNTRenderer.register(EntitySupersonicTNT.class, ModBlocks.SUPERSONIC_TNT);
		ModTNTRenderer.register(EntityRainbowTNT.class, ModBlocks.RAINBOW_TNT);

		ModTNTRenderer.register(EntityNCNuke.class, ModBlocks.NUKE_NC);
		ModTNTRenderer.register(EntityTrollTNT.class, ModBlocks.TROLL_TNT);
		ModTNTRenderer.register(EntityChunkTNT.class, ModBlocks.CHUNK_TNT);

		ModTNTRenderer.register(EntityMiniNukeTNT.class, ModBlocks.MINI_NUKE_TNT);
		ModTNTRenderer.register(EntityMegaNukeTNT.class, ModBlocks.MEGA_NUKE_TNT);
		ModTNTRenderer.register(EntityAntimatterBomb.class, ModBlocks.ANTIMATTER_BOMB);

		ModTNTRenderer.register(EntityButterTNT.class, ModBlocks.BUTTER_TNT);
		ModTNTRenderer.register(EntityLavaTNT.class, ModBlocks.LAVA_TNT);

		ModTNTRenderer.register(EntityEggTNT.class, ModBlocks.EGG_TNT);
		ModTNTRenderer.register(EntityArrowTNT.class, ModBlocks.ARROW_TNT);

		ModTNTRenderer.register(EntityRandomBlocksTNT.class, ModBlocks.RANDOM_BLOCKS_TNT);
		ModTNTRenderer.register(EntityCrashTNT.class, ModBlocks.CRASH_TNT);
		ModTNTRenderer.register(EntityLOLXDTNT.class, ModBlocks.LOLXD_TNT);

		ModTNTRenderer.register(EntityTNTTree.class, ModBlocks.TNT_TREE);
		ModTNTRenderer.register(EntityConfigureableTNT.class, ModBlocks.CONFIGUREABLE_TNT);

		ModTNTRenderer.register(EntityFlowerPower.class, ModBlocks.FLOWER_POWER);
		ModTNTRenderer.register(EntityCubicTNT.class, ModBlocks.CUBIC_TNT);
		ModTNTRenderer.register(EntityAnimalTNT.class, ModBlocks.ANIMAL_TNT);
		ModTNTRenderer.register(EntitySandFirework.class, ModBlocks.SAND_FIREWORK);
		ModTNTRenderer.register(EntityTNTFirework.class, ModBlocks.TNT_FIREWORK);
		ModTNTRenderer.register(EntityEntityFirework.class, ModBlocks.ENTITY_FIREWORK);

		ModTNTRenderer.register(EntityTNTFireworkCustomTNT.class, Blocks.TNT);

		ModTNTRenderer.register(EntityOver9000TNT.class, ModBlocks.OVER_9000_TNT);
		ModTNTRenderer.register(EntityTheP2WKingTNT.class, ModBlocks.THEP2WKING_TNT);

		ModRenderHelper.addThrowableRender(EntityDynamite.class, ModItems.DYNAMITE);
		ModRenderHelper.addThrowableRender(EntityDynamiteX5.class, ModItems.DYNAMITE_X5);
		ModRenderHelper.addThrowableRender(EntityDynamiteX20.class, ModItems.DYNAMITE_X20);
		ModRenderHelper.addThrowableRender(EntityCombatDynamite.class, ModItems.COMBAT_DYNAMITE);
		ModRenderHelper.addThrowableRender(EntityCubicDynamite.class, ModItems.CUBIC_DYNAMITE);
		ModRenderHelper.addThrowableRender(EntityAnimalDynamite.class, ModItems.ANIMAL_DYNAMITE);
		ModRenderHelper.addThrowableRender(EntityTheP2WKingDynamite.class, ModItems.THEP2WKING_DYNAMITE);

		ModRenderHelper.addThrowableRender(EntityEggsplosive.class, ModItems.EGGSPLOSIVE);
		ModRenderHelper.addThrowableRender(EntityGrenadeApple.class, ModItems.GRENADE_APPLE);
	}

	@SideOnly(Side.CLIENT)
	public static void registerEntityRender() {
		RenderingRegistry.registerEntityRenderingHandler(EntityTheP2WKing.class, RenderTheP2WKing.FACTORY);
	}
}