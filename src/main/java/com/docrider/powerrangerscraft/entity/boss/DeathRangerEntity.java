package com.docrider.powerrangerscraft.entity.boss;

import com.docrider.powerrangerscraft.entity.footsoldier.BaseFootsoldierEntity;
import com.docrider.powerrangerscraft.items.ComicsItems;
import com.docrider.powerrangerscraft.items.others.RangerChangerItem;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.BossEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class DeathRangerEntity extends BaseFootsoldierEntity {

    private final ServerBossEvent bossEvent = (ServerBossEvent)(new ServerBossEvent(Component.translatable(getDisplayName().getString()).withStyle(ChatFormatting.GRAY), BossEvent.BossBarColor.YELLOW, BossEvent.BossBarOverlay.PROGRESS));

    public DeathRangerEntity(EntityType<? extends BaseFootsoldierEntity> type, Level level) {
        super(type, level);
        NAME="dr_death_ranger";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ComicsItems.OMEGA_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(ComicsItems.OMEGA_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(ComicsItems.OMEGA_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(ComicsItems.OMEGA_GOLD_MORPHER.get()));
        RangerChangerItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), ComicsItems.OMEGA_GOLD_LOGO_DEATH.get(), 1);
    }


    protected void customServerAiStep() {
        super.customServerAiStep();
        this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
    }


    public void readAdditionalSaveData(CompoundTag p_31474_) {
        super.readAdditionalSaveData(p_31474_);
        if (this.hasCustomName()) {
            this.bossEvent.setName(this.getDisplayName());
        }
    }

    public void setCustomName(@Nullable Component p_31476_) {
        super.setCustomName(p_31476_);
        this.bossEvent.setName(this.getDisplayName());
    }

    public void startSeenByPlayer(ServerPlayer p_31483_) {
        super.startSeenByPlayer(p_31483_);
        this.bossEvent.addPlayer(p_31483_);
    }

    public void stopSeenByPlayer(ServerPlayer p_31488_) {
        super.stopSeenByPlayer(p_31488_);
        this.bossEvent.removePlayer(p_31488_);
    }


    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 35.0D)
                .add(Attributes.MOVEMENT_SPEED,(double)0.4F)
                .add(Attributes.ATTACK_DAMAGE, 15.0D)
                .add(Attributes.ARMOR, 8.0D)
                .add(Attributes.MAX_HEALTH, 500.0D);
    }
}