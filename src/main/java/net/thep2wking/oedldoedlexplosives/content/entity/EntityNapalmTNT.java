package net.thep2wking.oedldoedlexplosives.content.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;
import net.thep2wking.oedldoedlexplosives.config.ExplosivesConfig;

public class EntityNapalmTNT extends ModEntityTNTBase {
	public EntityNapalmTNT(World world, double x, double y, double z, EntityLivingBase igniter) {
		super(world, x, y, z, igniter);
	}

	public EntityNapalmTNT(World world) {
		super(world);
	}

	@Override
	public void explode() {
		this.world.newExplosion(this, this.posX, this.posY + (double) (this.height / 16.0F), this.posZ, 0, false,
				false);
		if (ExplosivesConfig.PROPERTIES.NON_STANDARD_EXPLOSION_DAMAGE) {
			for (int r = 16, x4 = -r; x4 < r; ++x4) {
				for (int y4 = r; y4 > -r; --y4) {
					for (int z4 = -r; z4 < r; ++z4) {
						if (this.world
								.getBlockState(new BlockPos((int) this.posX + x4, (int) this.posY + y4 - 1,
										(int) this.posZ + z4)) != Blocks.AIR.getDefaultState()
								&& this.world.getBlockState(new BlockPos((int) this.posX + x4, (int) this.posY + y4 - 1,
										(int) this.posZ + z4)) != Blocks.LAVA.getDefaultState()) {
							this.world.setBlockState(
									new BlockPos((int) this.posX + x4, (int) this.posY + y4, (int) this.posZ + z4),
									Blocks.LAVA.getDefaultState());
						}
					}
				}
			}
		}
	}
}