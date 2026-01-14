package com.docrider.powerrangerscraft.effect;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;


public class BeastMorphersBlueWeaknessEffect extends InstantenousMobEffect {


	public BeastMorphersBlueWeaknessEffect(MobEffectCategory mobEffectCategory, int color) {
		super(mobEffectCategory, color);
	}


	@Override
	public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
		if (!pLivingEntity.level().isClientSide()) {
			if (pLivingEntity.level() instanceof ServerLevel level) {
				if (pLivingEntity instanceof Player player) {
					if (player.getFoodData().getFoodLevel()<=5) {
						player.igniteForSeconds(10);
					}
				}
			}
		}
		return true;
	}
}

