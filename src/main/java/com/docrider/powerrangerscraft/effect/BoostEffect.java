package com.docrider.powerrangerscraft.effect;

import com.docrider.powerrangerscraft.items.others.RangerChangerItem;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;

public class BoostEffect extends InstantenousMobEffect {


    public BoostEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    @Override
    public boolean applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {

        if (!pLivingEntity.level().isClientSide()) {
            if (pLivingEntity.level() instanceof ServerLevel level) {
                if (pLivingEntity instanceof Player player) {
                    ItemStack stack = pLivingEntity.getItemBySlot(EquipmentSlot.FEET);
                    if (stack.getItem() instanceof RangerChangerItem belt) {
                        if (stack.has(DataComponents.CUSTOM_DATA)) {
                            CompoundTag tag = stack.get(DataComponents.CUSTOM_DATA).getUnsafe();
                            if (tag.getDouble("use_ability") != 0 & pAmplifier != 9) {
                                pLivingEntity.fallDistance = 0.0f;
                                Vec3 look = pLivingEntity.getLookAngle();
                                pLivingEntity.setDeltaMovement(pLivingEntity.getDeltaMovement().add(look.x * (0.1 * (1 + pAmplifier)), look.y * (0.1 * (1 + pAmplifier)) + pLivingEntity.getGravity(), look.z * (0.1 * (1 + pAmplifier))));
                                if (pLivingEntity instanceof Player) {
                                    ((Player) pLivingEntity).hurtMarked = true;
                                }
                                pLivingEntity.level().addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, pLivingEntity.getX(), pLivingEntity.getY(), pLivingEntity.getZ(), 0.0D, 0.0D, 0.0D);
                                pLivingEntity.level().addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, pLivingEntity.getX(), pLivingEntity.getY() + 1, pLivingEntity.getZ(), 0.0D, 0.0D, 0.0D);
                                pLivingEntity.level().addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, pLivingEntity.getX(), pLivingEntity.getY() + 0.5, pLivingEntity.getZ(), 0.0D, 0.0D, 0.0D);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}