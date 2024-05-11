package net.thep2wking.oedldoedlexplosives.content.entity.living;

import javax.annotation.Nullable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.thep2wking.oedldoedlexplosives.OedldoedlExplosives;
import net.thep2wking.oedldoedlexplosives.init.ModSounds;

public class EntityGiantTheP2WKing extends EntityMob {
	public static final ResourceLocation LOOTTABLE = new ResourceLocation(OedldoedlExplosives.MODID,
			"entities/giant_thep2wking");
	private int attackTimer;

	public EntityGiantTheP2WKing(World worldIn) {
		super(worldIn);
		this.setSize(3F, 12f);
		this.experienceValue = 1000;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void initEntityAI() {
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackMelee(this, 0.5D, false));
		this.tasks.addTask(3, new EntityAIMoveTowardsTarget(this, 0.5D, 24.0F));
		this.tasks.addTask(4, new EntityAIWanderAvoidWater(this, 0.5D));
		this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, new Class[0]));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
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
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(800.0D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(30.0D);
	}

	@Override
	@Nullable
	public ResourceLocation getLootTable() {
		return LOOTTABLE;
	}

	@Override
	public float getEyeHeight() {
		return 10F;
	}

	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		this.attackTimer = 20;
		this.playSound(SoundEvents.ENTITY_PLAYER_ATTACK_STRONG, 1.0F, 1.0F);
		return entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float) (7 + this.rand.nextInt(20)));
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
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
		livingdata = super.onInitialSpawn(difficulty, livingdata);
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
}