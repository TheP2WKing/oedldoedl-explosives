package net.thep2wking.oedldoedlexplosives.integration;

import jeresources.api.render.IMobRenderHook;
import net.minecraft.client.renderer.GlStateManager;

@SuppressWarnings("rawtypes")
public class ModRenderHooks {
	public static final IMobRenderHook GIANT_THEP2WKING = (renderInfo, entity) -> {
		GlStateManager.translate(0.0F, -2.0F, 0.0F);
		GlStateManager.scale(0.7F, 0.7F, 0.7F);
		return renderInfo;
	 };
}