package net.thep2wking.oedldoedlexplosives.content.entity.living;

import java.util.Set;

import javax.annotation.Nullable;

import com.google.common.collect.Sets;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIMoveTowardsTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.OedldoedlExplosives;
import net.thep2wking.oedldoedlexplosives.config.ExplosivesConfig;
import net.thep2wking.oedldoedlexplosives.init.ModBlocks;
import net.thep2wking.oedldoedlexplosives.init.ModSounds;

public class EntityTheP2WKing extends EntityAnimal {
	public static final ResourceLocation LOOTTABLE = new ResourceLocation(OedldoedlExplosives.MODID,
			"entities/thep2wking");
	private static final Set<Item> TEMPTATION_ITEMS = Sets.newHashSet(Item.getItemFromBlock(ModBlocks.TROLL_TNT));
	private int attackTimer;

	public EntityTheP2WKing(World worldIn) {
		super(worldIn);
		this.setSize(0.6F, 1.95f);
		this.experienceValue = 200;
	}

	@Override
	public void initEntityAI() {
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackMelee(this, 0.5D, false));
		this.tasks.addTask(3, new EntityAIMate(this, 1.0D));
		this.tasks.addTask(4, new EntityAIFollowParent(this, 1.1D));
		this.tasks.addTask(3, new EntityAIMoveTowardsTarget(this, 0.5D, 32.0F));
		this.tasks.addTask(6, new EntityAIWanderAvoidWater(this, 0.5D));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(8, new EntityAILookIdle(this));
		this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false, new Class[0]));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget<>(this, EntityLiving.class, 4, false, true,
				entity -> entity != null && IMob.VISIBLE_MOB_SELECTOR.apply(entity)));
	}

	@Override
	public boolean isImmuneToExplosions() {
		return true;
	}

	@Override
	public boolean canPickUpLoot() {
		return true;
	}

	@Override
	public boolean canDespawn() {
		return false;
	}

	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		this.updateArmSwingProgress();
		if (this.attackTimer > 0) {
			--this.attackTimer;
		}
	}

	@Override
	public void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(400.0D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(40.0D);
	}

	@Override
	@Nullable
	public ResourceLocation getLootTable() {
		return LOOTTABLE;
	}

	@Override
	public float getEyeHeight() {
		return 1.65F;
	}

	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		this.attackTimer = 10;
		this.playSound(SoundEvents.ENTITY_PLAYER_ATTACK_STRONG, 1.0F, 1.0F);
		return entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float) (7 + this.rand.nextInt(15)));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return ModSounds.THEP2WKING;
	}

	@Override
	public SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_PLAYER_DEATH;
	}

	@Override
	public SoundEvent getAmbientSound() {
		return ModSounds.THEP2WKING;
	}

	@Override
	public boolean isBreedingItem(ItemStack stack) {
		return TEMPTATION_ITEMS.contains(stack.getItem());
	}

	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
		livingdata = super.onInitialSpawn(difficulty, livingdata);
		if (ExplosivesConfig.CONTENT.THEP2WKING_CARRIES_TROLL_TNT) {
			this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(ModBlocks.TROLL_TNT, 1, 0));
		}
		return livingdata;
	}

	@Override
	public void dropEquipment(boolean wasRecentlyHit, int lootingModifier) {
		this.entityDropItem(this.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).copy(), 0.0F);
		this.entityDropItem(this.getItemStackFromSlot(EntityEquipmentSlot.OFFHAND).copy(), 0.0F);
		this.entityDropItem(this.getItemStackFromSlot(EntityEquipmentSlot.HEAD).copy(), 0.0F);
		this.entityDropItem(this.getItemStackFromSlot(EntityEquipmentSlot.CHEST).copy(), 0.0F);
		this.entityDropItem(this.getItemStackFromSlot(EntityEquipmentSlot.LEGS).copy(), 0.0F);
		this.entityDropItem(this.getItemStackFromSlot(EntityEquipmentSlot.FEET).copy(), 0.0F);
	}

	@Override
	@Nullable
	public EntityAgeable createChild(EntityAgeable ageable) {
		return new EntityTheP2WKing(this.world);
	}
}