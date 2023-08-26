package net.thep2wking.oedldoedlexplosives.content.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;
import net.thep2wking.oedldoedlexplosives.config.ExplosivesConfig;
import net.thep2wking.oedldoedlexplosives.init.ModBlocks;

public class EntityRainbowTNT extends ModEntityTNTBase {
	public EntityRainbowTNT(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
	}

	public EntityRainbowTNT(World world) {
		super(world);
	}

	@Override
	public void explode() {
		this.world.newExplosion(this, this.posX, this.posY + (double) (this.height / 16.0F), this.posZ, 0, false,
				false);

		if (ExplosivesConfig.PROPERTIES.NON_STANDARD_EXPLOSION_DAMAGE) {
			for (int r = 32, x5 = -r; x5 < r; ++x5) {
				for (int y5 = -r; y5 < r; ++y5) {
					if (Math.pow(x5, 2.0) + Math.pow(y5, 2.0) < Math.pow(r, 2.0)
							&& Math.pow(x5, 2.0) + Math.pow(y5, 2.0) > Math.pow(r - 2, 2.0)
							&& this.world.getBlockState(new BlockPos((int) (x5 + this.posX), (int) (y5 + this.posY),
									(int) this.posZ)) != Blocks.BEDROCK) {
						this.world.setBlockState(
								new BlockPos((int) (x5 + this.posX), (int) (y5 + this.posY), (int) this.posZ),
								ModBlocks.RAINBOW.getDefaultState());
					}
				}
			}
		}
	}
}