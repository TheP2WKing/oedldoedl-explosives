package net.thep2wking.oedldoedlexplosives.util;

import net.thep2wking.oedldoedlexplosives.api.ModTNTRenderer;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityAntimatterBomb;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityArrowTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityButterTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityC4;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityChunkTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityDayTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityDetonatorChainTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityDrillTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityEggTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityFlatTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityIslandTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityLavaTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityMegaNukeTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityNCNuke;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityNapalmTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityNightTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityNukeTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntitySirDerpingtonTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityTNTRain;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityTNTx20;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityTNTx5;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityTrollTNT;
import net.thep2wking.oedldoedlexplosives.init.ModBlocks;

public class ModRendering {
	public static void registerRenderer() {
		ModTNTRenderer.register(EntityC4.class, ModBlocks.C4);
		ModTNTRenderer.register(EntityTNTx5.class, ModBlocks.TNT_X5);
		ModTNTRenderer.register(EntityTNTx20.class, ModBlocks.TNT_X20);

		ModTNTRenderer.register(EntityDrillTNT.class, ModBlocks.DRILL_TNT);
		ModTNTRenderer.register(EntityFlatTNT.class, ModBlocks.FLAT_TNT);

		ModTNTRenderer.register(EntityNukeTNT.class, ModBlocks.NUKE_TNT);

		ModTNTRenderer.register(EntityDetonatorChainTNT.class, ModBlocks.DETONATOR_CHAIN_TNT);
		ModTNTRenderer.register(EntityDayTNT.class, ModBlocks.DAY_TNT);
		ModTNTRenderer.register(EntityNightTNT.class, ModBlocks.NIGHT_TNT);
		ModTNTRenderer.register(EntitySirDerpingtonTNT.class, ModBlocks.SIR_DERPINGTON_TNT);
		ModTNTRenderer.register(EntityTNTRain.class, ModBlocks.TNT_RAIN);

		ModTNTRenderer.register(EntityNapalmTNT.class, ModBlocks.NAPALM_TNT);
		ModTNTRenderer.register(EntityIslandTNT.class, ModBlocks.ISLAND_TNT);

		ModTNTRenderer.register(EntityNCNuke.class, ModBlocks.NUKE);
		ModTNTRenderer.register(EntityTrollTNT.class, ModBlocks.TROLL_TNT);
		ModTNTRenderer.register(EntityChunkTNT.class, ModBlocks.CHUNK_TNT);

		ModTNTRenderer.register(EntityMegaNukeTNT.class, ModBlocks.MEGA_NUKE_TNT);
		ModTNTRenderer.register(EntityAntimatterBomb.class, ModBlocks.ANTIMATTER_BOMB);

		ModTNTRenderer.register(EntityButterTNT.class, ModBlocks.BUTTER_TNT);
		ModTNTRenderer.register(EntityLavaTNT.class, ModBlocks.LAVA_TNT);
		ModTNTRenderer.register(EntityEggTNT.class, ModBlocks.EGG_TNT);
		ModTNTRenderer.register(EntityArrowTNT.class, ModBlocks.ARROW_TNT);
	}
}