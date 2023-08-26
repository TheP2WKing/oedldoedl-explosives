package net.thep2wking.oedldoedlexplosives.content.entity;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModEntityTNTBase;
import net.thep2wking.oedldoedlexplosives.config.ExplosivesConfig;

public class EntityRandomBlocksTNT extends ModEntityTNTBase {
    public EntityRandomBlocksTNT(World world, double x, double y, double z, EntityLivingBase igniter) {
        super(world, x, y, z, igniter);
    }

    public EntityRandomBlocksTNT(World world) {
        super(world);
    }

    public static void setBlock(World w, int x, int y, int z, BlockPos pos, Block b) {
        w.setBlockState(pos.add(x - pos.getX(), y - pos.getY(), z - pos.getZ()), b.getDefaultState());
    }

    @Override
    public void explode() {
        this.world.newExplosion(this, this.posX, this.posY + (double) (this.height / 16.0F), this.posZ, 0, false,
                false);
        Random random = new Random();

        if (ExplosivesConfig.PROPERTIES.NON_STANDARD_EXPLOSION_DAMAGE) {
            for (int i2 = (int) this.posX - 5; i2 < (int) this.posX + 5; ++i2) {
                for (int j2 = (int) this.posY; j2 < (int) this.posY + 10; ++j2) {
                    for (int k2 = (int) this.posZ - 5; k2 < (int) this.posZ + 5; ++k2) {
                        if (random.nextInt(5) != 1)
                            continue;
                        BlockPos pos = new BlockPos(i2, j2, k2);
                        int randomblockid = random.nextInt(ExplosivesConfig.CONTENT.RANDOM_BLOCKS_TNT_MAX_ID);
                        Block randomblock = Block.getBlockById((int) randomblockid);
                        if (!randomblock.canPlaceBlockAt(this.world, pos) || randomblock == Blocks.WATER
                                || randomblock == Blocks.LAVA || randomblock == Blocks.FLOWING_WATER
                                || randomblock == Blocks.FLOWING_LAVA)
                            continue;
                        setBlock(this.world, i2, j2, k2, pos, randomblock);
                        if (randomblock != Blocks.STANDING_SIGN)
                            continue;
                    }
                }
            }
        }
    }
}