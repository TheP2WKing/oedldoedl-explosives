package net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.derpy;

import java.util.ArrayList;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.play.server.SPacketExplosion;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class EntityDerpyTNT extends ModEntityTNTBase {
	private double newX;
	private double newY;
	private double newZ;

	public EntityDerpyTNT(World world, double x, double y, double z, EntityLivingBase igniter, int fuse,
			float explosionStrength, boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(world, x, y, z, igniter, fuse, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
	}

	public EntityDerpyTNT(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
	}

	public EntityDerpyTNT(World world) {
		super(world);
	}

	public int getRandomX() {
		int min = -10;
		int max = 10;
		return min + (int) (Math.random() * (max - min + 1));
	}

	public int getRandomY() {
		int min = -10;
		int max = 10;
		return min + (int) (Math.random() * (max - min + 1));
	}

	public int getRandomZ() {
		int min = -10;
		int max = 10;
		return min + (int) (Math.random() * (max - min + 1));
	}

	public void setNewPos() {
		this.newX = this.posX + this.getRandomX();
		this.newY = this.posY + this.getRandomY();
		this.newZ = this.posZ + this.getRandomZ();
	}

	@Override
	public ModExplosionBase createTNTExplosion(double x, double y, double z) {
		return new ModExplosionBase(world, ignitor, x, y, z, 4.0f, false, true, true, 16);
	}

	@Override
	public void explode() {
		this.setNewPos();
		this.handleExplosion(newX, newY, newZ);
		this.handleExtraExplosionEffects(newX, newY, newZ);
	}

	@Override
	public void handleExplosionLogic(ModExplosionBase explosion) {
		if (ForgeEventFactory.onExplosionStart(world, explosion))
			return;
		explosion.doExplosionA();
		for (EntityPlayer entityplayer : world.playerEntities) {
			if (entityplayer.getDistanceSq(newX, newY, newZ) < 4096.0D) {
				SPacketExplosion packet = new SPacketExplosion(newX, newY, newZ,
						explosion.getExplosionStrength(),
						(explosion.doBlockDamage() ? explosion.getAffectedBlockPositions()
								: new ArrayList<BlockPos>()),
						explosion.getPlayerKnockbackMap().get(entityplayer));
				if (entityplayer instanceof EntityPlayerMP) {
					((EntityPlayerMP) entityplayer).connection.sendPacket(packet);
				}
			}
		}
		explosion.doExplosionB(true);
	}
}