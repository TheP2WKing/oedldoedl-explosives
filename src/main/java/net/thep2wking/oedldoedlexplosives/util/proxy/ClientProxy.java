package net.thep2wking.oedldoedlexplosives.util.proxy;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTRender;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityChunkTNT;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityNuke;
import net.thep2wking.oedldoedlexplosives.content.entity.EntityTrollTNT;
import net.thep2wking.oedldoedlexplosives.init.ModBlocks;

public class ClientProxy extends CommonProxy {
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
	}

	public void init(FMLInitializationEvent event) {
		super.init(event);
	}

	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	}

	@Override
	@SuppressWarnings("deprecation")
	public void render() {
		RenderingRegistry.registerEntityRenderingHandler(EntityNuke.class,
				new ModEntityTNTRender(Minecraft.getMinecraft().getRenderManager(), ModBlocks.NUKE));

		RenderingRegistry.registerEntityRenderingHandler(EntityTrollTNT.class,
				new ModEntityTNTRender(Minecraft.getMinecraft().getRenderManager(), ModBlocks.TROLL_TNT));

		RenderingRegistry.registerEntityRenderingHandler(EntityChunkTNT.class,
				new ModEntityTNTRender(Minecraft.getMinecraft().getRenderManager(), ModBlocks.CHUNK_TNT));
	}
}