package net.thep2wking.oedldoedlexplosives.integration;

import net.thep2wking.oedldoedlcore.api.integration.ModJERPluginBase;
import net.thep2wking.oedldoedlexplosives.OedldoedlExplosives;
import net.thep2wking.oedldoedlexplosives.content.entity.living.EntityGiantTheP2WKing;
import net.thep2wking.oedldoedlexplosives.content.entity.living.EntityTheP2WKing;

import jeresources.api.conditionals.LightLevel;
import net.thep2wking.oedldoedlcore.api.integration.JERPlugin;

@JERPlugin
public class OedldoedlExplosivesJERPlugin extends ModJERPluginBase {
	@Override
	public String getModId() {
		return OedldoedlExplosives.MODID;
	}

	@Override
	public void register() {
		addMob(new EntityTheP2WKing(getWorld()), LightLevel.any, EntityTheP2WKing.EXPERIENCE_VALUE, EntityTheP2WKing.LOOT_TABLE);
		addMob(new EntityGiantTheP2WKing(getWorld()), LightLevel.any, EntityGiantTheP2WKing.EXPERIENCE_VALUE, EntityGiantTheP2WKing.LOOT_TABLE);

		registerMobRenderHook(EntityGiantTheP2WKing.class, ModRenderHooks.GIANT_THEP2WKING);
	}
}