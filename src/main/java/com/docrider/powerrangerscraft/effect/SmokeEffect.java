package com.docrider.powerrangerscraft.effect;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class SmokeEffect extends MobEffect {


    public SmokeEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {

        pLivingEntity.level().addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, pLivingEntity.getX(), pLivingEntity.getY(), pLivingEntity.getZ(), 0.0D, 0.0D, 0.0D);
        pLivingEntity.level().addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, pLivingEntity.getX(), pLivingEntity.getY() + 1, pLivingEntity.getZ(), 0.0D, 0.0D, 0.0D);
        pLivingEntity.level().addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, pLivingEntity.getX(), pLivingEntity.getY() + 0.5, pLivingEntity.getZ(), 0.0D, 0.0D, 0.0D);
        return true;
    }
}