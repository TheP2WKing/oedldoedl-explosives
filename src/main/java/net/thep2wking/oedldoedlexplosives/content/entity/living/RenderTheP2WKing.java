package net.thep2wking.oedldoedlexplosives.content.entity.living;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.oedldoedlexplosives.OedldoedlExplosives;

@SideOnly(Side.CLIENT)
public class RenderTheP2WKing extends RenderLiving<EntityTheP2WKing> {
	private ResourceLocation texture = new ResourceLocation(OedldoedlExplosives.MODID, "textures/entity/thep2wking.png");

	public RenderTheP2WKing(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelPlayer(0f, false), 0.6F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityTheP2WKing entity) {
		return texture;
	}

	public static final RenderTheP2WKing.Factory FACTORY = new RenderTheP2WKing.Factory();

	public static class Factory implements IRenderFactory<EntityTheP2WKing> {
		@Override
		public Render<? super EntityTheP2WKing> createRenderFor(RenderManager manager) {
			return new RenderTheP2WKing(manager);
		}
	}
}