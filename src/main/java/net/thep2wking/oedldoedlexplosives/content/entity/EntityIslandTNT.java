package net.thep2wking.oedldoedlexplosives.content.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;
import net.thep2wking.oedldoedlexplosives.config.ExplosivesConfig;

public class EntityIslandTNT extends ModEntityTNTBase {
	public EntityIslandTNT(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
	}

	public EntityIslandTNT(World world) {
		super(world);
	}

	@Override
	public void explode() {
		this.world.newExplosion(this, this.posX, this.posY + (double) (this.height / 16.0F), this.posZ, 0, false,
				false);

		if (ExplosivesConfig.PROPERTIES.NON_STANDARD_EXPLOSION_DAMAGE) {
			for (int r = (int) 20, x4 = -r; x4 < r; ++x4) {
				for (int y4 = -r; y4 < r; ++y4) {
					for (int z4 = -r; z4 < r; ++z4) {
						if (Math.pow(x4, 2.0) + Math.pow(y4, 2.0) + Math.pow(z4, 2.0) < Math.pow(r, 2.0)
								&& this.world.getBlockState(new BlockPos((int) this.posX + x4, (int) this.posY + y4,
										(int) this.posZ + z4)) != Blocks.BEDROCK.getDefaultState()) {
							this.world.setBlockState(
									new BlockPos((int) this.posX + x4, (int) this.posY + y4 + r + 20,
											(int) this.posZ + z4),
									this.world.getBlockState(new BlockPos((int) this.posX + x4, (int) this.posY + y4,
											(int) this.posZ + z4)),
									2);
							this.world.setBlockState(
									new BlockPos((int) this.posX + x4, (int) this.posY + y4, (int) this.posZ + z4),
									Blocks.AIR.getDefaultState());
						}
					}
				}
			}
		}
	}
}