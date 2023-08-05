package net.thep2wking.oedldoedlexplosives.util;

import net.thep2wking.oedldoedlexplosives.api.ModTNTRenderer;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityC4;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityChunkTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityDayTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityDrillTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityFlatTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityNCNuke;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityNightTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityNukeTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntitySirDerpingtonTNT;
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

		ModTNTRenderer.register(EntityDayTNT.class, ModBlocks.DAY_TNT);
		ModTNTRenderer.register(EntityNightTNT.class, ModBlocks.NIGHT_TNT);
		ModTNTRenderer.register(EntitySirDerpingtonTNT.class, ModBlocks.SIR_DERPINGTON_TNT);

		ModTNTRenderer.register(EntityNCNuke.class, ModBlocks.NUKE);
		ModTNTRenderer.register(EntityTrollTNT.class, ModBlocks.TROLL_TNT);
		ModTNTRenderer.register(EntityChunkTNT.class, ModBlocks.CHUNK_TNT);
	}
}