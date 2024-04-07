package net.thep2wking.oedldoedlexplosives.content.entity;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.network.play.server.SPacketExplosion;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;

public class EntityMultiplyTNT extends ModEntityTNTBase {
	public EntityMultiplyTNT(World world, double x, double y, double z, EntityLivingBase igniter, int fuse,
			float explosionStrength, boolean spawnFire, boolean blockDamage) {
		super(world, x, y, z, igniter, fuse, explosionStrength, spawnFire, blockDamage);
	}

	public EntityMultiplyTNT(World world) {
		super(world);
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void explode() {
		Explosion explosion = new Explosion(world, this, posX, posY, posZ, explosionStrength, spawnFire, blockDamage);
		explosion.doExplosionA();
		List<BlockPos> affectedBlockPositions = explosion.getAffectedBlockPositions();
		for (BlockPos blockPos : affectedBlockPositions) {
			IBlockState blockState = world.getBlockState(blockPos);
			Block block = blockState.getBlock();
			if (block != Blocks.AIR) {
				block.dropBlockAsItem(world, blockPos, blockState, 0);
				block.dropBlockAsItem(world, blockPos, blockState, 0);
				world.setBlockToAir(blockPos);
			}
		}
		explosion.doExplosionB(true);
		if (!world.isRemote) {
			SPacketExplosion packet = new SPacketExplosion(posX, posY, posZ, explosionStrength, affectedBlockPositions,
					explosion.getPlayerKnockbackMap().get(this));
			for (EntityPlayer player : ((WorldServer) world).getEntityTracker().getTrackingPlayers(this)) {
				if (player instanceof EntityPlayerMP) {
					((EntityPlayerMP) player).connection.sendPacket(packet);
				}
			}
		}
	}
}