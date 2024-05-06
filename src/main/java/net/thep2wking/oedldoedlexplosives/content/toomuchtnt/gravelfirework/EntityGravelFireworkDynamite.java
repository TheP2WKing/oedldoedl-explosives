package net.thep2wking.oedldoedlexplosives.content.toomuchtnt.gravelfirework;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityDynamiteBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;
import net.thep2wking.oedldoedlexplosives.init.ModItems;

public class EntityGravelFireworkDynamite extends ModEntityDynamiteBase {
	private int fuse = 30;

	public EntityGravelFireworkDynamite(World world, double x, double y, double z) {
		super(world, x, y, z);
	}

	public EntityGravelFireworkDynamite(World world, EntityLivingBase thrower) {
		super(world, thrower);
	}

	public EntityGravelFireworkDynamite(World world) {
		super(world);
	}

	@Override
	public Item setParticleItem() {
		return ModItems.GRAVEL_FIREWORK_DYNAMITE;
	}

	@Override
	public ModExplosionBase createDynamiteExplosion(double x, double y, double z) {
		return new ExplosionGravelFirework(world, thrower, x, y, z, 4.0f, false, false, false, 0);
	}

	@Override
	public void setParticles() {
		int[] params = { Block.getStateId(Blocks.GRAVEL.getDefaultState()) };
		this.world.spawnParticle(EnumParticleTypes.FALLING_DUST, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D,
				params);
	}

	@Override
	public void handleExtraExplosionEffects(double x, double y, double z) {
		spawnFallingBlockX10(0.75f, 1.5f, 0.75f);
		spawnFallingBlockX10(0.75f, 1.5f, 0.75f);
		spawnFallingBlockX10(0.75f, 1.5f, 0.75f);
		spawnFallingBlockX10(0.75f, 1.5f, 0.75f);
		spawnFallingBlockX10(0.75f, 1.5f, 0.75f);
		spawnFallingBlockX10(0.75f, 1.5f, 0.75f);
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

	public void spawnFallingBlock(float motionX, float motionY, float motionZ) {
		if (!this.world.isRemote) {
			EntityFallingBlock entity = new EntityFallingBlock(world, this.posX, this.posY + this.height / 2.0F,
					this.posZ, Blocks.GRAVEL.getDefaultState());
			float f = (float) (Math.random() * Math.PI * 2.0);
			entity.fallTime = 1;
			entity.motionX = (double) (-((float) Math.sin(f)) * motionX) * Math.random();
			entity.motionY = Math.abs(motionY * Math.random());
			entity.motionZ = (double) (-((float) Math.cos(f)) * motionZ) * Math.random();
			world.spawnEntity(entity);
		}
	}

	public void spawnFallingBlockX2(float motionX, float motionY, float motionZ) {
		spawnFallingBlock(motionX, motionY, motionZ);
		spawnFallingBlock(motionX, motionY, motionZ);
	}

	public void spawnFallingBlockX4(float motionX, float motionY, float motionZ) {
		spawnFallingBlockX2(motionX, motionY, motionZ);
		spawnFallingBlockX2(motionX, motionY, motionZ);
	}

	public void spawnFallingBlockX5(float motionX, float motionY, float motionZ) {
		spawnFallingBlock(motionX, motionY, motionZ);
		spawnFallingBlockX2(motionX, motionY, motionZ);
		spawnFallingBlockX2(motionX, motionY, motionZ);
	}

	public void spawnFallingBlockX8(float motionX, float motionY, float motionZ) {
		spawnFallingBlockX4(motionX, motionY, motionZ);
		spawnFallingBlockX4(motionX, motionY, motionZ);
	}

	public void spawnFallingBlockX10(float motionX, float motionY, float motionZ) {
		spawnFallingBlockX2(motionX, motionY, motionZ);
		spawnFallingBlockX4(motionX, motionY, motionZ);
		spawnFallingBlockX4(motionX, motionY, motionZ);
	}

	public void spawnFallingBlockX20(float motionX, float motionY, float motionZ) {
		spawnFallingBlockX10(motionX, motionY, motionZ);
		spawnFallingBlockX10(motionX, motionY, motionZ);
	}
}