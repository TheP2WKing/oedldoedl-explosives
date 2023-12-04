package net.thep2wking.oedldoedlexplosives.content.entity.throwable;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.oedldoedlexplosives.config.ExplosivesConfig;

public class EntityCubicDynamite extends EntityThrowable {
	public EntityCubicDynamite(World worldIn) {
		super(worldIn);
	}

	public EntityCubicDynamite(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
	}

	public EntityCubicDynamite(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void handleStatusUpdate(byte id) {
		if (id == 3) {
			for (int i = 0; i < 8; ++i) {
				this.world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, this.posX, this.posY, this.posZ, 0.0D, 0.0D,
						0.0D);
			}
		}
	}

	@Override
	public void onImpact(RayTraceResult result) {
		IBlockState air = Blocks.AIR.getDefaultState();

		if (result.entityHit != null && !this.world.isRemote
				&& ExplosivesConfig.PROPERTIES.NON_STANDARD_EXPLOSION_DAMAGE) {
			int resPosX = result.entityHit.getPosition().getX();
			int resPosY = result.entityHit.getPosition().getY();
			int resPosZ = result.entityHit.getPosition().getZ();
			// y = 0
			world.setBlockState(new BlockPos(resPosX, resPosY, resPosZ), air);
			world.newExplosion(null, resPosX, resPosY, resPosZ, 0, false, false);
			world.setBlockState(new BlockPos(resPosX + 1, resPosY, resPosZ), air);
			world.newExplosion(null, resPosX + 1, resPosY, resPosZ, 0, false, false);
			world.setBlockState(new BlockPos(resPosX - 1, resPosY, resPosZ), air);
			world.newExplosion(null, resPosX - 1, resPosY, resPosZ, 0, false, false);

			world.setBlockState(new BlockPos(resPosX, resPosY, resPosZ + 1), air);
			world.newExplosion(null, resPosX, resPosY, resPosZ + 1, 0, false, false);
			world.setBlockState(new BlockPos(resPosX + 1, resPosY, resPosZ + 1), air);
			world.newExplosion(null, resPosX + 1, resPosY, resPosZ + 1, 0, false, false);
			world.setBlockState(new BlockPos(resPosX - 1, resPosY, resPosZ + 1), air);
			world.newExplosion(null, resPosX - 1, resPosY, resPosZ + 1, 0, false, false);

			world.setBlockState(new BlockPos(resPosX, resPosY, resPosZ - 1), air);
			world.newExplosion(null, resPosX, resPosY, resPosZ - 1, 0, false, false);
			world.setBlockState(new BlockPos(resPosX + 1, resPosY, resPosZ - 1), air);
			world.newExplosion(null, resPosX + 1, resPosY, resPosZ - 1, 0, false, false);
			world.setBlockState(new BlockPos(resPosX - 1, resPosY, resPosZ - 1), air);
			world.newExplosion(null, resPosX - 1, resPosY, resPosZ - 1, 0, false, false);

			// y = +1
			world.setBlockState(new BlockPos(resPosX, resPosY + 1, resPosZ), air);
			world.newExplosion(null, resPosX, resPosY + 1, resPosZ, 0, false, false);
			world.setBlockState(new BlockPos(resPosX + 1, resPosY + 1, resPosZ), air);
			world.newExplosion(null, resPosX + 1, resPosY + 1, resPosZ, 0, false, false);
			world.setBlockState(new BlockPos(resPosX - 1, resPosY + 1, resPosZ), air);
			world.newExplosion(null, resPosX - 1, resPosY + 1, resPosZ, 0, false, false);

			world.setBlockState(new BlockPos(resPosX, resPosY + 1, resPosZ + 1), air);
			world.newExplosion(null, resPosX, resPosY + 1, resPosZ + 1, 0, false, false);
			world.setBlockState(new BlockPos(resPosX + 1, resPosY + 1, resPosZ + 1), air);
			world.newExplosion(null, resPosX + 1, resPosY + 1, resPosZ + 1, 0, false, false);
			world.setBlockState(new BlockPos(resPosX - 1, resPosY + 1, resPosZ + 1), air);
			world.newExplosion(null, resPosX - 1, resPosY + 1, resPosZ + 1, 0, false, false);

			world.setBlockState(new BlockPos(resPosX, resPosY + 1, resPosZ - 1), air);
			world.newExplosion(null, resPosX, resPosY + 1, resPosZ - 1, 0, false, false);
			world.setBlockState(new BlockPos(resPosX + 1, resPosY + 1, resPosZ - 1), air);
			world.newExplosion(null, resPosX + 1, resPosY + 1, resPosZ - 1, 0, false, false);
			world.setBlockState(new BlockPos(resPosX - 1, resPosY + 1, resPosZ - 1), air);
			world.newExplosion(null, resPosX - 1, resPosY + 1, resPosZ - 1, 0, false, false);

			// y = -1
			world.setBlockState(new BlockPos(resPosX, resPosY - 1, resPosZ), air);
			world.newExplosion(null, resPosX, resPosY - 1, resPosZ, 0, false, false);
			world.setBlockState(new BlockPos(resPosX + 1, resPosY - 1, resPosZ), air);
			world.newExplosion(null, resPosX + 1, resPosY - 1, resPosZ, 0, false, false);
			world.setBlockState(new BlockPos(resPosX - 1, resPosY - 1, resPosZ), air);
			world.newExplosion(null, resPosX - 1, resPosY - 1, resPosZ, 0, false, false);

			world.setBlockState(new BlockPos(resPosX, resPosY - 1, resPosZ + 1), air);
			world.newExplosion(null, resPosX, resPosY - 1, resPosZ + 1, 0, false, false);
			world.setBlockState(new BlockPos(resPosX + 1, resPosY - 1, resPosZ + 1), air);
			world.newExplosion(null, resPosX + 1, resPosY - 1, resPosZ + 1, 0, false, false);
			world.setBlockState(new BlockPos(resPosX - 1, resPosY - 1, resPosZ + 1), air);
			world.newExplosion(null, resPosX - 1, resPosY - 1, resPosZ + 1, 0, false, false);

			world.setBlockState(new BlockPos(resPosX, resPosY - 1, resPosZ - 1), air);
			world.newExplosion(null, resPosX, resPosY - 1, resPosZ - 1, 0, false, false);
			world.setBlockState(new BlockPos(resPosX + 1, resPosY - 1, resPosZ - 1), air);
			world.newExplosion(null, resPosX + 1, resPosY - 1, resPosZ - 1, 0, false, false);
			world.setBlockState(new BlockPos(resPosX - 1, resPosY - 1, resPosZ - 1), air);
			world.newExplosion(null, resPosX - 1, resPosY - 1, resPosZ - 1, 0, false, false);

			result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0);
		}
		if (!this.world.isRemote && ExplosivesConfig.PROPERTIES.NON_STANDARD_EXPLOSION_DAMAGE) {
			int thisPosX = this.getPosition().getX();
			int thisPosY = this.getPosition().getY();
			int thisPosZ = this.getPosition().getZ();
			this.world.setEntityState(this, (byte) 3);

			// y = 0
			this.world.setBlockState(new BlockPos(thisPosX, thisPosY, thisPosZ), air);
			this.world.newExplosion(null, thisPosX, thisPosY, thisPosZ, 0, false, false);
			this.world.setBlockState(new BlockPos(thisPosX + 1, thisPosY, thisPosZ), air);
			this.world.newExplosion(null, thisPosX + 1, thisPosY, thisPosZ, 0, false, false);
			this.world.setBlockState(new BlockPos(thisPosX - 1, thisPosY, thisPosZ), air);
			this.world.newExplosion(null, thisPosX - 1, thisPosY, thisPosZ, 0, false, false);

			this.world.setBlockState(new BlockPos(thisPosX, thisPosY, thisPosZ + 1), air);
			this.world.newExplosion(null, thisPosX, thisPosY, thisPosZ + 1, 0, false, false);
			this.world.setBlockState(new BlockPos(thisPosX + 1, thisPosY, thisPosZ + 1), air);
			this.world.newExplosion(null, thisPosX + 1, thisPosY, thisPosZ + 1, 0, false, false);
			this.world.setBlockState(new BlockPos(thisPosX - 1, thisPosY, thisPosZ + 1), air);
			this.world.newExplosion(null, thisPosX - 1, thisPosY, thisPosZ + 1, 0, false, false);

			this.world.setBlockState(new BlockPos(thisPosX, thisPosY, thisPosZ - 1), air);
			this.world.newExplosion(null, thisPosX, thisPosY, thisPosZ - 1, 0, false, false);
			this.world.setBlockState(new BlockPos(thisPosX + 1, thisPosY, thisPosZ - 1), air);
			this.world.newExplosion(null, thisPosX + 1, thisPosY, thisPosZ - 1, 0, false, false);
			this.world.setBlockState(new BlockPos(thisPosX - 1, thisPosY, thisPosZ - 1), air);
			this.world.newExplosion(null, thisPosX - 1, thisPosY, thisPosZ - 1, 0, false, false);

			// y = +1
			this.world.setBlockState(new BlockPos(thisPosX, thisPosY + 1, thisPosZ), air);
			this.world.newExplosion(null, thisPosX, thisPosY + 1, thisPosZ, 0, false, false);
			this.world.setBlockState(new BlockPos(thisPosX + 1, thisPosY + 1, thisPosZ), air);
			this.world.newExplosion(null, thisPosX + 1, thisPosY + 1, thisPosZ, 0, false, false);
			this.world.setBlockState(new BlockPos(thisPosX - 1, thisPosY + 1, thisPosZ), air);
			this.world.newExplosion(null, thisPosX - 1, thisPosY + 1, thisPosZ, 0, false, false);

			this.world.setBlockState(new BlockPos(thisPosX, thisPosY + 1, thisPosZ + 1), air);
			this.world.newExplosion(null, thisPosX, thisPosY + 1, thisPosZ + 1, 0, false, false);
			this.world.setBlockState(new BlockPos(thisPosX + 1, thisPosY + 1, thisPosZ + 1), air);
			this.world.newExplosion(null, thisPosX + 1, thisPosY + 1, thisPosZ + 1, 0, false, false);
			this.world.setBlockState(new BlockPos(thisPosX - 1, thisPosY + 1, thisPosZ + 1), air);
			this.world.newExplosion(null, thisPosX - 1, thisPosY + 1, thisPosZ + 1, 0, false, false);

			this.world.setBlockState(new BlockPos(thisPosX, thisPosY + 1, thisPosZ - 1), air);
			this.world.newExplosion(null, thisPosX, thisPosY + 1, thisPosZ - 1, 0, false, false);
			this.world.setBlockState(new BlockPos(thisPosX + 1, thisPosY + 1, thisPosZ - 1), air);
			this.world.newExplosion(null, thisPosX + 1, thisPosY + 1, thisPosZ - 1, 0, false, false);
			this.world.setBlockState(new BlockPos(thisPosX - 1, thisPosY + 1, thisPosZ - 1), air);
			this.world.newExplosion(null, thisPosX - 1, thisPosY + 1, thisPosZ - 1, 0, false, false);

			// y = -1
			this.world.setBlockState(new BlockPos(thisPosX, thisPosY - 1, thisPosZ), air);
			this.world.newExplosion(null, thisPosX, thisPosY - 1, thisPosZ, 0, false, false);
			this.world.setBlockState(new BlockPos(thisPosX + 1, thisPosY - 1, thisPosZ), air);
			this.world.newExplosion(null, thisPosX + 1, thisPosY - 1, thisPosZ, 0, false, false);
			this.world.setBlockState(new BlockPos(thisPosX - 1, thisPosY - 1, thisPosZ), air);
			this.world.newExplosion(null, thisPosX - 1, thisPosY - 1, thisPosZ, 0, false, false);

			this.world.setBlockState(new BlockPos(thisPosX, thisPosY - 1, thisPosZ + 1), air);
			this.world.newExplosion(null, thisPosX, thisPosY - 1, thisPosZ + 1, 0, false, false);
			this.world.setBlockState(new BlockPos(thisPosX + 1, thisPosY - 1, thisPosZ + 1), air);
			this.world.newExplosion(null, thisPosX + 1, thisPosY - 1, thisPosZ + 1, 0, false, false);
			this.world.setBlockState(new BlockPos(thisPosX - 1, thisPosY - 1, thisPosZ + 1), air);
			this.world.newExplosion(null, thisPosX - 1, thisPosY - 1, thisPosZ + 1, 0, false, false);

			this.world.setBlockState(new BlockPos(thisPosX, thisPosY - 1, thisPosZ - 1), air);
			this.world.newExplosion(null, thisPosX, thisPosY - 1, thisPosZ - 1, 0, false, false);
			this.world.setBlockState(new BlockPos(thisPosX + 1, thisPosY - 1, thisPosZ - 1), air);
			this.world.newExplosion(null, thisPosX + 1, thisPosY - 1, thisPosZ - 1, 0, false, false);
			this.world.setBlockState(new BlockPos(thisPosX - 1, thisPosY - 1, thisPosZ - 1), air);
			this.world.newExplosion(null, thisPosX - 1, thisPosY - 1, thisPosZ - 1, 0, false, false);

			this.setDead();
		}
	}
}