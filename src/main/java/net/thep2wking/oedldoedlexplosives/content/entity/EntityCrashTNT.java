package net.thep2wking.oedldoedlexplosives.content.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.thep2wking.oedldoedlcore.util.ModLogger;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;

public class EntityCrashTNT extends ModEntityTNTBase {
	public EntityCrashTNT(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
	}

	public EntityCrashTNT(World world) {
		super(world);
	}

	@Override
	public void explode() {
		this.world.newExplosion(this, this.posX, this.posY + (double) (this.height / 16.0F), this.posZ, 0, false,
				false);
		ModLogger.LOGGER.warn(">>>>>>>> THIS CRASH IS INTENDED! <<<<<<<<");
		FMLCommonHandler.instance().exitJava(0, true);
	}
}