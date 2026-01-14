package com.docrider.powerrangerscraft.effect;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;


public class BeastMorphersYellowWeaknessEffect extends InstantenousMobEffect {


	public BeastMorphersYellowWeaknessEffect(MobEffectCategory mobEffectCategory, int color) {
		super(mobEffectCategory, color);
	}


	@Override
	public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
		if (!pLivingEntity.level().isClientSide()) {
			if (pLivingEntity.level() instanceof ServerLevel level) {
				if (pLivingEntity instanceof Player player) {
					if (player.getFoodData().getFoodLevel()<=5) {
						player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 3, 8, true, true));
						player.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 3, 8, true, true));
					}
				}
			}
		}
		return true;
	}
}

