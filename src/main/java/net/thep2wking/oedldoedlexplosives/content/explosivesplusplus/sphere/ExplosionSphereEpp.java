package net.thep2wking.oedldoedlexplosives.content.explosivesplusplus.sphere;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class ExplosionSphereEpp extends ModExplosionBase {
	public ExplosionSphereEpp(World worldIn, Entity ignitor, double x, double y, double z, float explosionStrength,
			boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(worldIn, ignitor, x, y, z, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
	}

	@Override
	public void doAffectedBlocks() {
		int radius = (int) this.explosionStrength;
		for (int r = radius, x3 = -r; x3 < r; ++x3) {
			for (int y3 = -r; y3 < r; ++y3) {
				for (int z3 = -r; z3 < r; ++z3) {
					BlockPos blockpos = new BlockPos(this.x + x3, this.y + y3, this.z + z3);
					IBlockState iblockstate = this.world.getBlockState(blockpos);
					if (iblockstate.getMaterial() != Material.AIR && iblockstate.getBlockHardness(this.world, blockpos) != -1) {
						if (Math.pow(x3, 2.0) + Math.pow(y3, 2.0) + Math.pow(z3, 2.0) < Math.pow(r, 2.0)) {
							this.affectedBlockPositions.add(blockpos);
						}
					}
				}
			}
		}
	}
}