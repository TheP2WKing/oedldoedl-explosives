package net.thep2wking.oedldoedlexplosives.util.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.meteor.EntityMeteorEpp;

@SideOnly(Side.CLIENT)
public class RenderEntityMeteorEpp extends Render<EntityMeteorEpp> {
	public RenderEntityMeteorEpp(RenderManager renderManager) {
		super(renderManager);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityMeteorEpp entity) {
		return null;
	}

	@Override
	public void doRender(EntityMeteorEpp entity, double x, double y, double z, float entityYaw, float partialTicks) {
		GlStateManager.pushMatrix();
		GlStateManager.translate(x + 1, y, z - 1);
		GlStateManager.scale(12.0F, 12.0F, 12.0F);
		GlStateManager.rotate(45.0F, 1.0F, 1.0F, 1.0F);
		ItemStack obsidianStack = new ItemStack(Blocks.OBSIDIAN);
		Minecraft.getMinecraft().getRenderItem().renderItem(obsidianStack, ItemCameraTransforms.TransformType.GROUND);
		GlStateManager.popMatrix();
	}

	public static final RenderEntityMeteorEpp.Factory FACTORY = new RenderEntityMeteorEpp.Factory();

	public static class Factory implements IRenderFactory<EntityMeteorEpp> {
		@Override
		public Render<? super EntityMeteorEpp> createRenderFor(RenderManager manager) {
			return new RenderEntityMeteorEpp(manager);
		}
	}
}