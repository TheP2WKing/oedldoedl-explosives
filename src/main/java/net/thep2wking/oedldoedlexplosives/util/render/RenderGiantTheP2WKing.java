package net.thep2wking.oedldoedlexplosives.util.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.thep2wking.oedldoedlcore.api.entity.ModEntityRenderBase;
import net.thep2wking.oedldoedlexplosives.OedldoedlExplosives;
import net.thep2wking.oedldoedlexplosives.content.entity.living.EntityGiantTheP2WKing;

public class RenderGiantTheP2WKing extends ModEntityRenderBase<EntityGiantTheP2WKing> {
	public RenderGiantTheP2WKing(String modid, String name, RenderManager renderManager, ModelBase model, float shadowSize) {
		super(modid, name, renderManager, model, shadowSize);
        this.addLayer(new LayerBipedArmor(this));
        this.addLayer(new LayerHeldItem(this));
	}

	public static final RenderGiantTheP2WKing.Factory FACTORY = new RenderGiantTheP2WKing.Factory();

	public static class Factory implements IRenderFactory<EntityGiantTheP2WKing> {
		@Override
		public Render<? super EntityGiantTheP2WKing> createRenderFor(RenderManager manager) {
			return new RenderGiantTheP2WKing(OedldoedlExplosives.MODID, "thep2wking", manager, new ModelPlayer(0f, false), 3.0F);
		}
	}

	@Override
	public void preRenderCallback(EntityGiantTheP2WKing entitylivingbaseIn, float partialTickTime)
    {
        GlStateManager.scale(6f, 6f, 6f);
    }
}