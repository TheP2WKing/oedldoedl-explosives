package net.thep2wking.oedldoedlexplosives.content.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;

public class EntitySphereTNT extends ModEntityTNTBase {
	public EntitySphereTNT(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
	}

	public EntitySphereTNT(World world) {
		super(world);
	}

	@Override
	@SuppressWarnings("unused")
	public void explode() {
		int placed = 0;
		for (int r = 16, x3 = -r; x3 < r; ++x3) {
			for (int y3 = -r; y3 < r; ++y3) {
				for (int z3 = -r; z3 < r; ++z3) {
					if (Math.pow(x3, 2.0) + Math.pow(y3, 2.0) + Math.pow(z3, 2.0) < Math.pow(r, 2.0)
							&& this.world.getBlockState(new BlockPos((int) this.posX + x3, (int) this.posY + y3,
									(int) this.posZ + z3)) != Blocks.BEDROCK) {
						this.world.setBlockState(
								new BlockPos((int) this.posX + x3, (int) this.posY + y3, (int) this.posZ + z3),
								Blocks.AIR.getDefaultState());
						++placed;
					}
				}
			}
		}
		this.world.newExplosion(this, this.posX, this.posY + (double) (this.height / 16.0F), this.posZ, 0.0f, false,
				false);
	}
}