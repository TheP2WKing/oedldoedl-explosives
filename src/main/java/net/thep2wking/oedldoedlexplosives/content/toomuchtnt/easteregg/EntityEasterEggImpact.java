package net.thep2wking.oedldoedlexplosives.content.toomuchtnt.easteregg;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityImpactTNTBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class EntityEasterEggImpact extends ModEntityImpactTNTBase {
	public EntityEasterEggImpact(World world, double x, double y, double z, EntityLivingBase igniter,
			float explosionStrength, boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(world, x, y, z, igniter, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
	}

	public EntityEasterEggImpact(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
	}

	public EntityEasterEggImpact(World world) {
		super(world);
	}

	@Override
	public void setParticles() {
		world.spawnParticle(EnumParticleTypes.REDSTONE, this.posX, this.posY + 1.0, this.posZ, 4.0, 0.5, 0.0,
				new int[0]);
	}

	@Override
	public ModExplosionBase createTNTExplosion(double x, double y, double z) {
		return new ExplosionEasterEgg(world, ignitor, x, y, z, explosionStrength, spawnFire, blockDamage, dropBlocks,
				smoothness);
	}
}