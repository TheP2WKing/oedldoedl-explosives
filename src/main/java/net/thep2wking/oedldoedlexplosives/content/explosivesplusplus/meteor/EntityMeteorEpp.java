package net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.meteor;

import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketExplosion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class EntityMeteorEpp extends Entity {
    public Entity igniter;

    public EntityMeteorEpp(World worldIn) {
        super(worldIn);
        this.setSize(2.98F, 2.98F);
    }

    public EntityMeteorEpp(World worldIn, double x, double y, double z, Entity igniter) {
        this(worldIn);
        this.setPosition(x, y, z);
        this.igniter = igniter;
    }

    @Override
    public void entityInit() {
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
    }

    public void handleExplosion(double x, double y, double z) {
        ModExplosionBase explosion = new ModExplosionBase(world, igniter, posX, posY, posZ, 64.0f, false, true, true,
                32);
        this.handleExplosionLogic(explosion);
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

    @Override
    public void onUpdate() {
        super.onUpdate();
        this.motionY -= 0.08;
        this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
        if (this.motionY < 0) {
            for (int i = 0; i < 5; i++) {
                double offsetX = (this.rand.nextDouble() - 0.5) * 0.2;
                double offsetY = (this.rand.nextDouble() - 0.5) * 0.2;
                double offsetZ = (this.rand.nextDouble() - 0.5) * 0.2;
                this.world.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, this.posX + offsetX, this.posY + offsetY,
                        this.posZ + offsetZ, 0, 0, 0);
            }
        }
        if (this.onGround) {
            this.setDead();
            this.explode();
        }
    }

    public void explode() {
        if (!world.isRemote) {
            this.handleExplosion(this.posX, this.posY, this.posZ);
        }
    }

    @Override
    public boolean isEntityInvulnerable(DamageSource source) {
        return true;
    }

    @Override
    public boolean canBePushed() {
        return false;
    }
}