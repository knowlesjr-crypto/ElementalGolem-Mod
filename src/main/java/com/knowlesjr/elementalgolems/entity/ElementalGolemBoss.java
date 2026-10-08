package com.knowlesjr.elementalgolems.entity;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LightningBolt;

public class ElementalGolemBoss extends IronGolem {
    private ElementalType elementalType = ElementalType.FIRE;

    public ElementalGolemBoss(EntityType<? extends IronGolem> type, Level level) {
        super(type, level);
    }

    public ElementalType getElementalType() {
        return elementalType;
    }

    public void setElementalType(ElementalType elementalType) {
        this.elementalType = elementalType == null ? ElementalType.FIRE : elementalType;
    }

    @Override
    public void aiStep() {
        super.aiStep();

        if (this.level().isClientSide) {
            return;
        }

        if (this.tickCount % 40 != 0) {
            return;
        }

        switch (this.elementalType) {
            case FIRE -> castFirePulse();
            case WATER -> castWaterPulse();
            case EARTH -> castEarthPulse();
            case WIND -> castWindPulse();
            case STORM -> castStormPulse();
        }
    }

    private void castFirePulse() {
        this.setSecondsOnFire(2);
        for (LivingEntity nearby : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(5.0D), target -> target != this && target.isAlive())) {
            nearby.hurt(this.damageSources().onFire(), 6.0F);
        }
    }

    private void castWaterPulse() {
        this.heal(2.0F);
        for (LivingEntity nearby : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(5.5D), target -> target != this && target.isAlive())) {
            nearby.setDeltaMovement(nearby.getDeltaMovement().add(0.0D, 0.35D, 0.0D));
        }
    }

    private void castEarthPulse() {
        this.getAttribute(Attributes.ARMOR).ifPresent(attribute -> attribute.setBaseValue(attribute.getBaseValue() + 0.5D));
        if (this.getHealth() < this.getMaxHealth() * 0.8F) {
            this.heal(1.5F);
        }
    }

    private void castWindPulse() {
        for (LivingEntity nearby : this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(6.0D), target -> target != this && target.isAlive())) {
            float dx = (float) (this.getX() - nearby.getX());
            float dz = (float) (this.getZ() - nearby.getZ());
            nearby.knockback(1.5F, dx, dz);
            nearby.hurt(this.damageSources().mobAttack(this), 4.0F);
        }
    }

    private void castStormPulse() {
        if (this.level().canSeeSky(this.blockPosition())) {
            LightningBolt lightning = new LightningBolt(EntityType.LIGHTNING_BOLT, this.level());
            lightning.setPos(this.getX(), this.getY(), this.getZ());
            this.level().addFreshEntity(lightning);
        }
    }
}
