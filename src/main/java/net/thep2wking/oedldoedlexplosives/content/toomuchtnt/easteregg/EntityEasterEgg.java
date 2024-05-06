package net.thep2wking.oedldoedlexplosives.content.toomuchtnt.easteregg;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityImpactTNTBase;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class EntityEasterEgg extends ModEntityTNTBase {
	public EntityEasterEgg(World world, double x, double y, double z, EntityLivingBase igniter, int fuse,
			float explosionStrength, boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(world, x, y, z, igniter, fuse, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
	}

	public EntityEasterEgg(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
	}

	public EntityEasterEgg(World world) {
		super(world);
	}

	@Override
	public void setParticles() {
		world.spawnParticle(EnumParticleTypes.REDSTONE, this.posX, this.posY + 1.0, this.posZ, 4.0, 0.5, 0.0,
				new int[0]);
	}

	@Override
	public ModExplosionBase createTNTExplosion(double x, double y, double z) {
		return new ExplosionEasterEgg(world, ignitor, x, y, z, 10.0f, true, true, false, 64);
	}

	@Override
	public ModEntityImpactTNTBase createImpactTNTEntity(double x, double y, double z) {
		return new EntityEasterEggImpact(world, x, y, z, ignitor, 10.0f, true, true, false, 64);
	}

	@Override
	public void handleExtraExplosionEffects(double x, double y, double z) {
		spawnImpactTNTX10(1.75f, 2.25f, 1.75f);
		spawnImpactTNTX8(2.75f, 2.75f, 2.75f);
	}
}