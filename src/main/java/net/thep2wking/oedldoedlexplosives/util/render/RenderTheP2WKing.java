package net.thep2wking.oedldoedlexplosives.util.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.thep2wking.oedldoedlcore.api.entity.ModEntityRenderBase;
import net.thep2wking.oedldoedlexplosives.OedldoedlExplosives;
import net.thep2wking.oedldoedlexplosives.content.entity.living.EntityTheP2WKing;

public class RenderTheP2WKing extends ModEntityRenderBase<EntityTheP2WKing> {
	public RenderTheP2WKing(String modid, String name, RenderManager renderManager, ModelBase model, float shadowSize) {
		super(modid, name, renderManager, model, shadowSize);
        this.addLayer(new LayerBipedArmor(this));
        this.addLayer(new LayerHeldItem(this));
	}

	public static final RenderTheP2WKing.Factory FACTORY = new RenderTheP2WKing.Factory();

	public static class Factory implements IRenderFactory<EntityTheP2WKing> {
		@Override
		public Render<? super EntityTheP2WKing> createRenderFor(RenderManager manager) {
			return new RenderTheP2WKing(OedldoedlExplosives.MODID, "thep2wking", manager, new ModelPlayer(0f, false), 0.6F);
		}
	}
}