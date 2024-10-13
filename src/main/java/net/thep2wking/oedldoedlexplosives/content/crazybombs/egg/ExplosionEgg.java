package net.thep2wking.oedldoedlexplosives.content.crazybombs.egg;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class ExplosionEgg extends ModExplosionBase {
	public ExplosionEgg(World worldIn, Entity ignitor, double x, double y, double z, float explosionStrength,
			boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(worldIn, ignitor, x, y, z, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
	}

	@Override
	public void doExplosionA() {
		this.doAffectedBlocks();
		this.doDamageAndKnockback(false);
	}

	@Override
	public void doExplosionSpawnFire() {
		if (this.spawnFire) {
			for (BlockPos blockpos1 : this.affectedBlockPositions) {
				IBlockState blockState = this.world.getBlockState(blockpos1);
				if ((blockState.getMaterial() == Material.AIR
						|| blockState.getBlock().isReplaceable(this.world, blockpos1))
						&& this.world.getBlockState(blockpos1.down()).isFullBlock()) {
					if (!world.isRemote) {
						if (this.random.nextInt(5) == 3) {
							EntityChicken chicken = new EntityChicken(this.world);
							chicken.setPosition(blockpos1.getX() + 0.5, blockpos1.getY() + 0.1,
									blockpos1.getZ() + 0.5);
							this.world.spawnEntity(chicken);
						} else {
							EntityItem item = new EntityItem(this.world, blockpos1.getX() + 0.5,
									blockpos1.getY() + 0.1, blockpos1.getZ() + 0.5, new ItemStack(Items.EGG, 1));
							this.world.spawnEntity(item);
						}
					}
				}
			}
		}
	}
}