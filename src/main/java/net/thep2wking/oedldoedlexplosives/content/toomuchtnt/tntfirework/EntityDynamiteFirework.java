package net.thep2wking.oedldoedlexplosives.content.toomuchtnt.tntfirework;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityDynamiteBase;
import net.thep2wking.oedldoedlexplosives.api.ModEntityImpactTNTBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;
import net.thep2wking.oedldoedlexplosives.init.ModItems;

public class EntityDynamiteFirework extends ModEntityDynamiteBase {
	private int fuse = 30;

	public EntityDynamiteFirework(World world, double x, double y, double z) {
		super(world, x, y, z);
	}

	public EntityDynamiteFirework(World world, EntityLivingBase thrower) {
		super(world, thrower);
	}

	public EntityDynamiteFirework(World world) {
		super(world);
	}

	@Override
	public Item setParticleItem() {
		return ModItems.DYNAMITE_FIREWORK;
	}

	@Override
	public ModExplosionBase createDynamiteExplosion(double x, double y, double z) {
		return new ExplosionTNTFirework(world, thrower, x, y, z, 4.0f, false, false, false, 0);
	}

	@Override
	public ModEntityImpactTNTBase createImpactTNTEntity(double x, double y, double z) {
		return new EntityTNTFireworkImpact(world, x, y, z, thrower, 3.0f, false, true, true, 16);
	}

	@Override
	public EnumParticleTypes setParticleType() {
		return EnumParticleTypes.FLAME;
	}

	@Override
	public void handleExtraExplosionEffects(double x, double y, double z) {
		spawnImpactTNTX10(0.75f, 1.5f, 0.75f);
		spawnImpactTNTX10(0.75f, 1.5f, 0.75f);
		spawnImpactTNTX10(0.75f, 1.5f, 0.75f);
		spawnImpactTNTX10(0.75f, 1.5f, 0.75f);
		spawnImpactTNTX10(0.75f, 1.5f, 0.75f);
		spawnImpactTNTX10(0.75f, 1.5f, 0.75f);
	}

	@Override
	public void onUpdate() {
		super.onUpdate();
		if (fuse > 0) {
			fuse--;
		}
		if (fuse == 0) {
			if (!world.isRemote) {
				this.explode(this.posX, this.posY, this.posZ);
			}
		}
		float f3 = this.getGravityVelocity();
		this.motionY += (double) f3 * 1.5;
	}
}