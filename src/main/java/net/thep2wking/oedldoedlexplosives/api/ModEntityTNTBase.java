package net.thep2wking.oedldoedlexplosives.api;

import java.util.ArrayList;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.play.server.SPacketExplosion;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;

/**
 * @author TheP2WKing
 */
public class ModEntityTNTBase extends EntityTNTPrimed {
	public static final DataParameter<Integer> FUSE = EntityDataManager.<Integer>createKey(ModEntityTNTBase.class,
			DataSerializers.VARINT);
	public int fuse = 80;
	public EntityLivingBase ignitor;
	public float explosionStrength = 4.0f;
	public boolean spawnFire;
	public boolean blockDamage;
	public boolean dropBlocks;
	public int smoothness = 16;

	/**
	 * @author TheP2WKing
	 * @param world             {@link World}
	 * @param x                 double
	 * @param y                 double
	 * @param z                 double
	 * @param igniter           {@link EntityLivingBase}
	 * @param fuse              int
	 * @param explosionStrength float
	 * @param spawnFire         boolean
	 * @param blockDamage       boolean
	 * @param dropBlocks        boolean
	 * @param smoothness        int
	 */
	public ModEntityTNTBase(World world, double x, double y, double z, EntityLivingBase igniter, int fuse,
			float explosionStrength, boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(world);
		this.ignitor = igniter;
		this.fuse = fuse;
		this.explosionStrength = explosionStrength;
		this.spawnFire = spawnFire;
		this.blockDamage = blockDamage;
		this.dropBlocks = dropBlocks;
		this.smoothness = smoothness;
		this.setPosition(x, y, z);
		float f = (float) (Math.random() * (Math.PI * 2D));
		this.motionX = (double) (-((float) Math.sin((double) f)) * 0.02F);
		this.motionY = 0.20000000298023224D;
		this.motionZ = (double) (-((float) Math.cos((double) f)) * 0.02F);
		this.setFuse(this.fuse);
		this.prevPosX = x;
		this.prevPosY = y;
		this.prevPosZ = z;
	}

	/**
	 * @author TheP2WKing
	 * @param world             {@link World}
	 * @param x                 double
	 * @param y                 double
	 * @param z                 double
	 * @param igniter           {@link EntityLivingBase}
	 * @param fuse              int
	 * @param explosionStrength float
	 * @param spawnFire         boolean
	 * @param blockDamage       boolean
	 */
	public ModEntityTNTBase(World world, double x, double y, double z, EntityLivingBase igniter, int fuse,
			float explosionStrength, boolean spawnFire, boolean blockDamage) {
		super(world);
		this.ignitor = igniter;
		this.fuse = fuse;
		this.explosionStrength = explosionStrength;
		this.spawnFire = spawnFire;
		this.blockDamage = blockDamage;
		this.setPosition(x, y, z);
		float f = (float) (Math.random() * (Math.PI * 2D));
		this.motionX = (double) (-((float) Math.sin((double) f)) * 0.02F);
		this.motionY = 0.20000000298023224D;
		this.motionZ = (double) (-((float) Math.cos((double) f)) * 0.02F);
		this.setFuse(this.fuse);
		this.prevPosX = x;
		this.prevPosY = y;
		this.prevPosZ = z;
	}

	/**
	 * @author TheP2WKing
	 * @param world   {@link World}
	 * @param x       double
	 * @param y       double
	 * @param z       double
	 * @param igniter {@link EntityLivingBase}
	 */
	public ModEntityTNTBase(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world);
		this.setPosition(x, y, z);
		float f = (float) (Math.random() * (Math.PI * 2D));
		this.motionX = (double) (-((float) Math.sin((double) f)) * 0.02F);
		this.motionY = 0.20000000298023224D;
		this.motionZ = (double) (-((float) Math.cos((double) f)) * 0.02F);
		this.setFuse(this.fuse);
		this.prevPosX = x;
		this.prevPosY = y;
		this.prevPosZ = z;
		this.ignitor = igniter;
	}

	/**
	 * @author TheP2WKing
	 * @param world   {@link World}
	 * @param x       double
	 * @param y       double
	 * @param z       double
	 * @param igniter {@link EntityLivingBase}
	 * @param fuse    int
	 */
	public ModEntityTNTBase(World world, double x, double y, double z, EntityLivingBase igniter, int fuse) {
		super(world);
		this.setPosition(x, y, z);
		float f = (float) (Math.random() * (Math.PI * 2D));
		this.motionX = (double) (-((float) Math.sin((double) f)) * 0.02F);
		this.motionY = 0.20000000298023224D;
		this.motionZ = (double) (-((float) Math.cos((double) f)) * 0.02F);
		this.setFuse(this.fuse);
		this.prevPosX = x;
		this.prevPosY = y;
		this.prevPosZ = z;
		this.ignitor = igniter;
	}

	/**
	 * @author TheP2WKing
	 * @param world {@link World}
	 */
	public ModEntityTNTBase(World world) {
		super(world);
		this.preventEntitySpawning = true;
		this.isImmuneToFire = true;
		this.setSize(0.98F, 0.98F);
	}

	@Override
	public void entityInit() {
		this.dataManager.register(FUSE, Integer.valueOf(this.fuse));
	}

	@Override
	public boolean canTriggerWalking() {
		return false;
	}

	@Override
	public boolean canBeCollidedWith() {
		return !this.isDead;
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
		if (!world.isRemote) {
			this.customUpdate();
		}
		--this.fuse;
		if (this.fuse <= 0) {
			this.setDead();
			if (!world.isRemote) {
				this.explode();
			}
		} else {
			this.handleWaterMovement();
			this.setParticles();
		}
	}

	public void customUpdate() {
	}

	public void setParticles() {
		this.world.spawnParticle(this.setParticleType(), this.posX, this.posY + 0.5D, this.posZ, 0.0D, 0.0D, 0.0D);
	}

	public EnumParticleTypes setParticleType() {
		return EnumParticleTypes.SMOKE_NORMAL;
	}

	public void explode() {
		this.handleExplosion(this.posX, this.posY, this.posZ);
		this.handleExtraExplosionEffects(this.posX, this.posY, this.posZ);
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		compound.setShort("Fuse", (short) this.getFuse());
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		this.setFuse(compound.getShort("Fuse"));
	}

	@Override
	public EntityLivingBase getTntPlacedBy() {
		return this.ignitor;
	}

	@Override
	public float getEyeHeight() {
		return 0.0F;
	}

	@Override
	public void setFuse(int fuseIn) {
		this.dataManager.set(FUSE, Integer.valueOf(fuseIn));
		this.fuse = fuseIn;
	}

	@Override
	public void notifyDataManagerChange(DataParameter<?> key) {
		if (FUSE.equals(key)) {
			this.fuse = this.getFuseDataManager();
		}
	}

	@Override
	public int getFuseDataManager() {
		return ((Integer) this.dataManager.get(FUSE)).intValue();
	}

	@Override
	public int getFuse() {
		return this.fuse;
	}

	public float getExplosionStrength() {
		return this.explosionStrength;
	}

	public boolean doesSpawnFire() {
		return this.spawnFire;
	}

	public boolean doesBlockDamage() {
		return this.blockDamage;
	}

	public void handleExtraExplosionEffects(double x, double y, double z) {
	}

	public ModExplosionBase createTNTExplosion(double x, double y, double z) {
		return new ModExplosionBase(world, ignitor, x, y, z, 4.0f, false, true, true, 16);
	}

	public void handleExplosion(double x, double y, double z) {
		ModExplosionBase explosion = this.createTNTExplosion(x, y, z);
		this.handleExplosionLogic(explosion);
	}

	public void handleExplosionLogic(ModExplosionBase explosion) {
		if (ForgeEventFactory.onExplosionStart(world, explosion))
			return;
		explosion.doExplosionA();
		for (EntityPlayer entityplayer : world.playerEntities) {
			if (entityplayer.getDistanceSq(this.posX, this.posY, this.posZ) < 4096.0D) {
				SPacketExplosion packet = new SPacketExplosion(this.posX, this.posY, this.posZ,
						explosion.getExplosionStrength(), (explosion.doBlockDamage() ? explosion.getAffectedBlockPositions()
								: new ArrayList<BlockPos>()),
						explosion.getPlayerKnockbackMap().get(entityplayer));
				if (entityplayer instanceof EntityPlayerMP) {
					((EntityPlayerMP) entityplayer).connection.sendPacket(packet);
				}
			}
		}
		explosion.doExplosionB(true);
	}

	public ModEntityImpactTNTBase createImpactTNTEntity(double x, double y, double z) {
		return new ModEntityImpactTNTBase(world, x, y, z, ignitor, 4.0f, false, true, true, 16);
	}

	public void spawnImpactTNT(float motionX, float motionY, float motionZ) {
		if (!this.world.isRemote) {
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
}