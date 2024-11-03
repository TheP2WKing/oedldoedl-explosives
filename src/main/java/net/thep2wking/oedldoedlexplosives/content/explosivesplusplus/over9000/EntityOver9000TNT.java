package net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.over9000;

import java.util.Random;

import mcjty.theoneprobe.api.IProbeHitEntityData;
import mcjty.theoneprobe.api.IProbeInfo;
import mcjty.theoneprobe.api.ProbeMode;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlcore.config.CoreConfig;
import net.thep2wking.oedldoedlcore.integration.top.ITOPEntityInfoProvider;
import net.thep2wking.oedldoedlexplosives.OedldoedlExplosives;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;
import net.thep2wking.oedldoedlexplosives.config.ExplosivesConfig;

public class EntityOver9000TNT extends ModEntityTNTBase implements ITOPEntityInfoProvider {
	private int spawnedTnts;

	public EntityOver9000TNT(World world, double x, double y, double z, EntityLivingBase igniter, int fuse,
			float explosionStrength, boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(world, x, y, z, igniter, fuse, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
	}

	public EntityOver9000TNT(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
	}

	public EntityOver9000TNT(World world) {
		super(world);
	}

	@Override
	public ModExplosionBase createTNTExplosion(double x, double y, double z) {
		return new ModExplosionBase(world, ignitor, x, y, z, 4.0f, false, true, true, 16);
	}

	@Override
	public boolean hasNoGravity() {
		return ExplosivesConfig.CONTENT.OVER_9000_TNT_KEEPS_SPAWNING_TNT;
	}

	@Override
	public boolean isImmuneToExplosions() {
		return ExplosivesConfig.CONTENT.OVER_9000_TNT_KEEPS_SPAWNING_TNT;
	}

	public int getSpawnedTnts() {
		return spawnedTnts;
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setInteger("SpawnedTNTs", this.spawnedTnts);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		this.spawnedTnts = compound.getInteger("SpawnedTNTs");
	}

	@Override
	public void onUpdate() {
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;
		if (!this.hasNoGravity()) {
			this.motionY -= 0.03999999910593033D;
		}
		this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
		this.motionX *= 0.9800000190734863D;
		this.motionY *= 0.9800000190734863D;
		this.motionZ *= 0.9800000190734863D;
		if (this.onGround) {
			this.motionX *= 0.699999988079071D;
			this.motionZ *= 0.699999988079071D;
			this.motionY *= -0.5D;
		}
		if (ExplosivesConfig.CONTENT.OVER_9000_TNT_KEEPS_SPAWNING_TNT) {
			if (this.fuse-- <= 0) {
				if (-this.fuse % 10 == 0) {
					Random random = new Random();
					int rangeMin = -3;
					int rangeMax = 3;
					if (!world.isRemote) {
						EntityTNTPrimed tntPrimed = new EntityTNTPrimed(this.world, this.posX + 0.1f, this.posY + 0.1f,
								this.posZ + 0.1f, this.ignitor);
						tntPrimed.addVelocity(rangeMin + (rangeMax - rangeMin) * random.nextDouble(),
								rangeMin + (rangeMax - rangeMin) * random.nextDouble(),
								rangeMin + (rangeMax - rangeMin) * random.nextDouble());
						this.world.spawnEntity(tntPrimed);
						++spawnedTnts;
					}
				}
				if (this.spawnedTnts >= 9001) {
					this.setDead();
					if (!this.world.isRemote) {
						this.explode();
					}
				}
			}
		} else {
			--this.fuse;
			if (this.fuse <= 0) {
				this.setDead();
				if (!this.world.isRemote) {
					this.explode();
				}
			} else {
				this.handleWaterMovement();
				this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX, this.posY + 0.5D, this.posZ, 0.0D,
						0.0D, 0.0D);
			}
		}
	}

	@Override
	public void addProbeInfo(ProbeMode mode, IProbeInfo probeInfo, EntityPlayer player, World world, Entity entity,
			IProbeHitEntityData data) {
		probeInfo.text(CoreConfig.TOOLTIPS.COLORS.INFORMATION_ANNOTATION_FORMATTING.getColor() + "{*top."
				+ OedldoedlExplosives.MODID + ".spawned_tnts*}" + " " + TextFormatting.YELLOW + this.getSpawnedTnts());
	}
}