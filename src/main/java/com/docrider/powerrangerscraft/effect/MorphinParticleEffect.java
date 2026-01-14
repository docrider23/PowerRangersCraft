package com.docrider.powerrangerscraft.effect;

import com.docrider.powerrangerscraft.particle.ModParticles;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;


public class MorphinParticleEffect extends InstantenousMobEffect {


	public MorphinParticleEffect(MobEffectCategory mobEffectCategory, int color) {
		super(mobEffectCategory, color);
	}

	@Override
	public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {

		pLivingEntity.level().addParticle(ModParticles.GREEN_MORPHIN_PARTICLES.get(), pLivingEntity.getX(), pLivingEntity.getY(), pLivingEntity.getZ(), 0.0D, 0.0D, 0.0D);
		pLivingEntity.level().addParticle(ModParticles.GREEN_MORPHIN_PARTICLES.get(), pLivingEntity.getX(), pLivingEntity.getY() + 1, pLivingEntity.getZ(), 0.0D, 0.0D, 0.0D);
		pLivingEntity.level().addParticle(ModParticles.GREEN_MORPHIN_PARTICLES.get(), pLivingEntity.getX(), pLivingEntity.getY() + 0.5, pLivingEntity.getZ(), 0.0D, 0.0D, 0.0D);
		return true;
	}
}