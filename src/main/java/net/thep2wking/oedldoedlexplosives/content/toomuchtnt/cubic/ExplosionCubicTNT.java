package net.thep2wking.oedldoedlexplosives.content.toomuchtnt.cubic;

import net.minecraft.entity.Entity;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class ExplosionCubicTNT extends ModExplosionBase {
	public ExplosionCubicTNT(World worldIn, Entity ignitor, double x, double y, double z, float explosionStrength,
			boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(worldIn, ignitor, x, y, z, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
	}

	@Override
	public void doAffectedBlocks() {
		int radius = (int) this.explosionStrength;
		for (int x = -radius; x <= radius; x++) {
			for (int y = -radius; y <= radius; y++) {
				for (int z = -radius; z <= radius; z++) {
					BlockPos blockpos = new BlockPos(this.x + x, this.y + y, this.z + z);
					this.affectedBlockPositions.add(blockpos);
				}
			}
		}
		for (BlockPos blockpos : this.affectedBlockPositions) {
			this.world.playSound(null, blockpos, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.BLOCKS, 4.0F,
			(1.0F + (this.world.rand.nextFloat() - this.world.rand.nextFloat()) * 0.2F) * 0.7F);
			this.world.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, blockpos.getX(), blockpos.getY(),
			blockpos.getZ(), 1.0D, 0.0D, 0.0D);
		}
	}
}