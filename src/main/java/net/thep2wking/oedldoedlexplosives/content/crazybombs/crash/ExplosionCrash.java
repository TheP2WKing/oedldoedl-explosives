package net.thep2wking.oedldoedlexplosives.content.crazybombs.crash;

import net.minecraft.entity.Entity;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.OedldoedlExplosives;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;
import net.thep2wking.oedldoedlexplosives.config.ExplosivesConfig;

public class ExplosionCrash extends ModExplosionBase {
	public ExplosionCrash(World worldIn, Entity ignitor, double x, double y, double z, float explosionStrength,
			boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(worldIn, ignitor, x, y, z, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
	}

	@Override
	public void doExplosionA() {
		this.doAffectedBlocks();
		this.doDamageAndKnockback(false);
	}

	@Override
	public void doExplosionSpawnFire() {
		if (this.spawnFire) {
			if (ExplosivesConfig.CONTENT.INTENDED_GAME_CRASHING) {
				TextComponentTranslation crashMessage = new TextComponentTranslation(
						"tile." + OedldoedlExplosives.MODID + ".crash_tnt.runtime_exception");
				throw new RuntimeException("[" + OedldoedlExplosives.NAME + "] " + crashMessage.getUnformattedText());
			}
		}
	}
}