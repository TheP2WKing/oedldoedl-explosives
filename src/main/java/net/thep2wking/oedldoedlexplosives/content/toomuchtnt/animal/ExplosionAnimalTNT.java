package net.thep2wking.oedldoedlexplosives.content.toomuchtnt.animal;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.collect.Sets;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.api.ModExplosionBase;

public class ExplosionAnimalTNT extends ModExplosionBase {
	public ExplosionAnimalTNT(World worldIn, Entity ignitor, double x, double y, double z, float explosionStrength,
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
		Set<ResourceLocation> entityList = EntityList.getEntityNameList();
		String modid = "minecraft";
		List<String> blacklist = Arrays.asList("minecraft:armor_stand", "minecraft:wither", "minecraft:ender_dragon",
				"minecraft:giant", "minecraft:ghast", "minecraft:elder_guardian", "minecraft:illusion_illager",
				"minecraft:shulker");
		List<ResourceLocation> entityRL = entityList.stream()
				.filter(entity -> entity.getResourceDomain().equals(modid))
				.filter(entity -> EntityList.createEntityByIDFromName(entity, this.world) instanceof EntityLivingBase)
				.filter(entity -> !blacklist.contains(entity.toString()))
				.collect(Collectors.toList());
		for (int i = 0; i < (this.explosionStrength * 2); i++) {
			int index = this.world.rand.nextInt(entityRL.size());
			ResourceLocation chosenEntity = entityRL.get(index);
			EntityLivingBase entity = (EntityLivingBase) EntityList.createEntityByIDFromName(chosenEntity, this.world);
			double radius = this.explosionStrength;
			double angle = Math.random() * Math.PI * 2;
			double randomRadius = Math.sqrt(Math.random()) * radius;
			double dx = this.x + randomRadius * Math.cos(angle);
			double dz = this.z + randomRadius * Math.sin(angle);
			int dy = this.world.getHeight(new BlockPos(dx, this.y, dz)).getY();
			double distance = Math.sqrt(Math.pow(dx - this.x, 2) + Math.pow(dy - this.y, 2) + Math.pow(dz - this.z, 2));
			if (dy >= 0 && dy <= this.world.getHeight() && distance <= radius * 2) {
				entity.setPosition(dx, dy, dz);
				this.world.spawnEntity(entity);
			}
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
}