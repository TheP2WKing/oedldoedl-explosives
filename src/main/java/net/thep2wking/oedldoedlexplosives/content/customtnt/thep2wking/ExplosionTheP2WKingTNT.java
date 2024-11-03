package net.thep2wking.oedldoedlexplosives.content.customtnt.thep2wking;

import java.util.Random;
import java.util.Set;
import com.google.common.collect.Sets;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;
import net.thep2wking.oedldoedlexplosives.init.ModBlocks;

public class ExplosionTheP2WKingTNT extends ModExplosionBase {
	public ExplosionTheP2WKingTNT(World worldIn, Entity ignitor, double x, double y, double z, float explosionStrength,
			boolean spawnFire, boolean blockDamage, boolean dropBlocks, int smoothness) {
		super(worldIn, ignitor, x, y, z, explosionStrength, spawnFire, blockDamage, dropBlocks, smoothness);
	}

	@Override
	public void doExplosionA() {
		this.doAffectedBlocks();
		this.doDamageAndKnockback(false);
	}

	@Override
	public void doExplosionBlockDamage(boolean spawnParticles) {
		super.doExplosionBlockDamage(spawnParticles);
		EntityLivingBase entity = this.getKingSize();
		if (!world.isRemote) {
			Random random = new Random();
			entity.setLocationAndAngles(this.x, this.y, this.z, random.nextFloat() * 360.0f, 0);
			entity.setHeldItem(EnumHand.MAIN_HAND, this.getTNTItem());
			this.world.spawnEntity(entity);
		}
	}

	@Override
	public void doAffectedBlocks() {
		Set<BlockPos> set = Sets.<BlockPos>newHashSet();
		for (int j = 0; j < this.smoothness; ++j) {
			for (int k = 0; k < this.smoothness; ++k) {
				for (int l = 0; l < this.smoothness; ++l) {
					if (j == 0 || j == (this.smoothness - 1) || k == 0 || k == (this.smoothness - 1) || l == 0
							|| l == (this.smoothness - 1)) {
						double d0 = (double) ((float) j / (this.smoothness - 1) * 2.0F - 1.0F);
						double d1 = (double) ((float) k / (this.smoothness - 1) * 2.0F - 1.0F);
						double d2 = (double) ((float) l / (this.smoothness - 1) * 2.0F - 1.0F);
						double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
						d0 = d0 / d3;
						d1 = d1 / d3;
						d2 = d2 / d3;
						float f = this.explosionStrength * (0.7F + this.world.rand.nextFloat() * 0.6F);
						double d4 = this.x;
						double d6 = this.y;
						double d8 = this.z;
						for (@SuppressWarnings("unused")
						float f1 = 0.3F; f > 0.0F; f -= 0.22500001F) {
							BlockPos blockpos = new BlockPos(d4, d6, d8);
							IBlockState iblockstate = this.world.getBlockState(blockpos);
							if (iblockstate.getMaterial() == Material.AIR) {
								set.add(blockpos);
							}
							d4 += d0 * 0.30000001192092896D;
							d6 += d1 * 0.30000001192092896D;
							d8 += d2 * 0.30000001192092896D;
						}
					}
				}
			}
		}
		this.affectedBlockPositions.addAll(set);
	}

	@Override
	public void doExplosionSpawnFire() {
		if (this.spawnFire) {
		}
	}

	public EntityLivingBase getKingSize() {
		EntityLivingBase entity;
		if (this.spawnFire) {
			entity = new EntityGiantTheP2WKing(this.world);
		} else {
			entity = new EntityTheP2WKing(this.world);
		}
		return entity;
	}

	public ItemStack getTNTItem() {
		ItemStack item;
		if (this.spawnFire) {
			item = ItemStack.EMPTY;
		} else {
			item = new ItemStack(ModBlocks.TROLL_TNT, 1, 0);
		}
		return item;
	}
}