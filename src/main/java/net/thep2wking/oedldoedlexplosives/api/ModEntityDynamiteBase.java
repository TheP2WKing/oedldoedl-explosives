package net.thep2wking.oedldoedlexplosives.api;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.network.play.server.SPacketExplosion;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author TheP2WKing
 */
public class ModEntityDynamiteBase extends EntityThrowable {
	public boolean hasImpacted = false;

	public ModEntityDynamiteBase(World world) {
		super(world);
	}

	public ModEntityDynamiteBase(World world, EntityLivingBase thrower) {
		super(world, thrower);
	}

	public ModEntityDynamiteBase(World world, double x, double y, double z) {
		super(world, x, y, z);
	}

	public Item setParticleItem() {
		return Items.AIR;
	}

	@Override
	public boolean isImmuneToExplosions() {
		return true;
	}

	@Override
	public boolean canBePushed() {
		return false;
	}

	@Override
	public boolean isBurning() {
		return false;
	}

	@Override
	public void onUpdate() {
		super.onUpdate();
		if (this.world.isRemote) {
			this.setParticles();
		}
	}

	public void setParticles() {
		this.world.spawnParticle(this.setParticleType(), this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
	}

	public EnumParticleTypes setParticleType() {
		return EnumParticleTypes.SMOKE_NORMAL;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void handleStatusUpdate(byte id) {
		if (id == 3) {
			for (int i = 0; i < 8; ++i) {
				this.world.spawnParticle(EnumParticleTypes.ITEM_CRACK, this.posX, this.posY, this.posZ, 0.0D, 0.0D,
						0.0D, Item.getIdFromItem(this.setParticleItem()));
			}
		}
	}

	public ModExplosionBase createDynamiteExplosion(double x, double y, double z) {
		return new ModExplosionBase(world, thrower, x, y, z, 4.0f, false, true, true, 16);
	}

	public void explode(double x, double y, double z) {
		ModExplosionBase explosion = this.createDynamiteExplosion(x, y, z);
		this.handleExplosionLogic(explosion);
		this.handleExtraExplosionEffects(x, y, z);
		this.world.setEntityState(this, (byte) 3);
		this.setDead();
	}

	public void handleExtraExplosionEffects(double x, double y, double z) {
	}

	@Override
	public void onImpact(RayTraceResult result) {
		if (this.isDead) {
			return;
		}
		if (result.entityHit != null && result.entityHit instanceof EntityPlayer && result.entityHit.world.isRemote) {
			return;
		}
		if (!world.isRemote) {
			this.explode(this.posX, this.posY, this.posZ);
		}
		this.hasImpacted = true;
	}

	public void handleExplosionLogic(ModExplosionBase explosion) {
		if (ForgeEventFactory.onExplosionStart(world, explosion))
			return;
		explosion.doExplosionA();
		for (EntityPlayer entityplayer : world.playerEntities) {
			if (entityplayer.getDistanceSq(this.posX, this.posY, this.posZ) < 4096.0D) {
				SPacketExplosion packet = new SPacketExplosion(this.posX, this.posY, this.posZ,
						explosion.getExplosionStrength(), explosion.getAffectedBlockPositions(),
						explosion.getPlayerKnockbackMap().get(entityplayer));
				if (entityplayer instanceof EntityPlayerMP) {
					((EntityPlayerMP) entityplayer).connection.sendPacket(packet);
				}
			}
		}
		explosion.doExplosionB(true);
	}

	public ModEntityImpactTNTBase createImpactTNTEntity(double x, double y, double z) {
		return new ModEntityImpactTNTBase(world, x, y, z, thrower, 4.0F, false, true, true, 16);
	}

	public void spawnImpactTNT(float motionX, float motionY, float motionZ) {
		if (!world.isRemote) {
			ModEntityImpactTNTBase entity = this.createImpactTNTEntity(this.posX, this.posY + this.height / 2.0F,
					this.posZ);
			float f = (float) (Math.random() * Math.PI * 2.0);
			entity.motionX = (double) (-((float) Math.sin(f)) * motionX) * Math.random();
			entity.motionY = Math.abs(motionY * Math.random());
			entity.motionZ = (double) (-((float) Math.cos(f)) * motionZ) * Math.random();
			world.spawnEntity(entity);
		}
	}

	public void spawnImpactTNTX2(float motionX, float motionY, float motionZ) {
		spawnImpactTNT(motionX, motionY, motionZ);
		spawnImpactTNT(motionX, motionY, motionZ);
	}

	public void spawnImpactTNTX4(float motionX, float motionY, float motionZ) {
		spawnImpactTNTX2(motionX, motionY, motionZ);
		spawnImpactTNTX2(motionX, motionY, motionZ);
	}

	public void spawnImpactTNTX5(float motionX, float motionY, float motionZ) {
		spawnImpactTNT(motionX, motionY, motionZ);
		spawnImpactTNTX2(motionX, motionY, motionZ);
		spawnImpactTNTX2(motionX, motionY, motionZ);
	}

	public void spawnImpactTNTX8(float motionX, float motionY, float motionZ) {
		spawnImpactTNTX4(motionX, motionY, motionZ);
		spawnImpactTNTX4(motionX, motionY, motionZ);
	}

	public void spawnImpactTNTX10(float motionX, float motionY, float motionZ) {
		spawnImpactTNTX2(motionX, motionY, motionZ);
		spawnImpactTNTX4(motionX, motionY, motionZ);
		spawnImpactTNTX4(motionX, motionY, motionZ);
	}

	public void spawnImpactTNTX20(float motionX, float motionY, float motionZ) {
		spawnImpactTNTX10(motionX, motionY, motionZ);
		spawnImpactTNTX10(motionX, motionY, motionZ);
	}

	public boolean hasImpacted() {
		return hasImpacted;
	}
}