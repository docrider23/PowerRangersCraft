package com.docrider.powerrangerscraft.effect;

import com.docrider.powerrangerscraft.items.others.RangerChangerItem;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;


public class BeastMorphersYellowBeastXEffect extends InstantenousMobEffect {


	public BeastMorphersYellowBeastXEffect(MobEffectCategory mobEffectCategory, int color) {
		super(mobEffectCategory, color);
	}


	@Override
	public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
		pLivingEntity.fallDistance=0;

		if (!pLivingEntity.level().isClientSide()) {
			if (pLivingEntity.level() instanceof ServerLevel level) {
				if (pLivingEntity instanceof Player player) {
					ItemStack stack = pLivingEntity.getItemBySlot(EquipmentSlot.FEET);
					if (stack.getItem() instanceof RangerChangerItem belt) {
						if (stack.has(DataComponents.CUSTOM_DATA)) {
							CompoundTag tag = stack.get(DataComponents.CUSTOM_DATA).getUnsafe();
							if (tag.getDouble("use_ability") != 0  & pAmplifier != 9) {
								player.addEffect(new MobEffectInstance(EffectCore.LOW_GRAVITY, 10, 9, true, false));
							}
						}
					}
				}
			}
		}
		return true;
	}
}

