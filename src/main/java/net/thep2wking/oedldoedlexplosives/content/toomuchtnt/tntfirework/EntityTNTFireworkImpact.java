package net.thep2wking.oedldoedlexplosives.content.toomuchtnt.tntfirework;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityImpactTNTBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class EntityTNTFireworkImpact extends ModEntityImpactTNTBase {
	public EntityTNTFireworkImpact(World world, double x, double y, double z, EntityLivingBase igniter,
			float explosionStrength, boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(world, x, y, z, igniter, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
	}

	public EntityTNTFireworkImpact(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
	}

	public EntityTNTFireworkImpact(World world) {
		super(world);
	}

	@Override
	public ModExplosionBase createTNTExplosion(double x, double y, double z) {
		return new ModExplosionBase(world, ignitor, x, y, z, explosionStrength, spawnFire, blockDamage, dropBlocks,
				smoothness);
	}
}