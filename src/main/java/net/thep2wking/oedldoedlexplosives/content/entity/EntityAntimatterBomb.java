package net.thep2wking.oedldoedlexplosives.content.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;

public class EntityAntimatterBomb extends ModEntityTNTBase {
	public EntityAntimatterBomb(World world, double x, double y, double z, EntityLivingBase igniter, int fuse,
			float explosionStrength, boolean spawnFire, boolean blockDamage) {
		super(world, x, y, z, igniter, fuse, explosionStrength, spawnFire, blockDamage);
	}

	public EntityAntimatterBomb(World world) {
		super(world);
	}

	public static Block getBlock(World w, int x, int y, int z, BlockPos pos) {
		return w.getBlockState(pos.add(x - pos.getX(), y - pos.getY(), z - pos.getZ())).getBlock();
	}

	public static void setBlock(World w, int x, int y, int z, BlockPos pos, Block b) {
		w.setBlockState(pos.add(x - pos.getX(), y - pos.getY(), z - pos.getZ()), b.getDefaultState());
	}

	@Override
	public void explode() {
		this.world.newExplosion(this, this.posX, this.posY + (double) (this.height / 16.0F), this.posZ,
				this.explosionStrength, this.spawnFire, this.blockDamage);
		this.world.newExplosion(this, this.posX + 20, this.posY + (double) (this.height / 16.0F), this.posZ,
				this.explosionStrength, this.spawnFire, this.blockDamage);
		this.world.newExplosion(this, this.posX - 20, this.posY + (double) (this.height / 16.0F), this.posZ,
				this.explosionStrength, this.spawnFire, this.blockDamage);
		this.world.newExplosion(this, this.posX, this.posY + (double) (this.height / 16.0F), this.posZ + 20,
				this.explosionStrength, this.spawnFire, this.blockDamage);
		this.world.newExplosion(this, this.posX, this.posY + (double) (this.height / 16.0F), this.posZ - 20,
				this.explosionStrength, this.spawnFire, this.blockDamage);
		this.world.newExplosion(this, this.posX + 20, this.posY + (double) (this.height / 16.0F), this.posZ + 20,
				this.explosionStrength, this.spawnFire, this.blockDamage);
		this.world.newExplosion(this, this.posX + 20, this.posY + (double) (this.height / 16.0F), this.posZ - 20,
				this.explosionStrength, this.spawnFire, this.blockDamage);
		this.world.newExplosion(this, this.posX - 20, this.posY + (double) (this.height / 16.0F), this.posZ - 20,
				this.explosionStrength, this.spawnFire, this.blockDamage);
		this.world.newExplosion(this, this.posX - 20, this.posY + (double) (this.height / 16.0F), this.posZ + 20,
				this.explosionStrength, this.spawnFire, this.blockDamage);

		this.world.newExplosion(this, this.posX, this.posY + (double) (this.height / 16.0F) - 15, this.posZ,
				this.explosionStrength, this.spawnFire, this.blockDamage);
		this.world.newExplosion(this, this.posX + 20, this.posY + (double) (this.height / 16.0F) - 15, this.posZ,
				this.explosionStrength, this.spawnFire, this.blockDamage);
		this.world.newExplosion(this, this.posX - 20, this.posY + (double) (this.height / 16.0F) - 15, this.posZ,
				this.explosionStrength, this.spawnFire, this.blockDamage);
		this.world.newExplosion(this, this.posX, this.posY + (double) (this.height / 16.0F) - 15, this.posZ + 20,
				this.explosionStrength, this.spawnFire, this.blockDamage);
		this.world.newExplosion(this, this.posX, this.posY + (double) (this.height / 16.0F) - 15, this.posZ - 20,
				this.explosionStrength, this.spawnFire, this.blockDamage);

		this.world.newExplosion(this, this.posX + 20, this.posY + (double) (this.height / 16.0F) - 20, this.posZ + 20,
				this.explosionStrength, this.spawnFire, this.blockDamage);
		this.world.newExplosion(this, this.posX + 20, this.posY + (double) (this.height / 16.0F) - 20, this.posZ - 20,
				this.explosionStrength, this.spawnFire, this.blockDamage);
		this.world.newExplosion(this, this.posX - 20, this.posY + (double) (this.height / 16.0F) - 20, this.posZ - 20,
				this.explosionStrength, this.spawnFire, this.blockDamage);
		this.world.newExplosion(this, this.posX - 20, this.posY + (double) (this.height / 16.0F) - 20, this.posZ + 20,
				this.explosionStrength, this.spawnFire, this.blockDamage);
	}
}