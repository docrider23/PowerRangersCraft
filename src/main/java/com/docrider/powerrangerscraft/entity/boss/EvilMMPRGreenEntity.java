package com.docrider.powerrangerscraft.entity.boss;

import com.docrider.powerrangerscraft.entity.footsoldier.BaseFootsoldierEntity;
import com.docrider.powerrangerscraft.items.CosmicFuryItems;
import com.docrider.powerrangerscraft.items.DinoFuryItems;
import com.docrider.powerrangerscraft.items.MMPRItems;
import com.docrider.powerrangerscraft.items.others.RangerChangerItem;
import com.docrider.powerrangerscraft.items.others.RangerFormChangeItem;
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

public class EvilMMPRGreenEntity extends BaseFootsoldierEntity {

    private final ServerBossEvent bossEvent = (ServerBossEvent)(new ServerBossEvent(Component.translatable(getDisplayName().getString()).withStyle(ChatFormatting.WHITE), BossEvent.BossBarColor.GREEN, BossEvent.BossBarOverlay.PROGRESS));

    public EvilMMPRGreenEntity(EntityType<? extends BaseFootsoldierEntity> type, Level level) {
        super(type, level);
        NAME="evil_mmpr_green";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(MMPRItems.MMPR_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(MMPRItems.MMPR_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(MMPRItems.MMPR_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(MMPRItems.GREEN_POWER_MORPHER.get()));
        this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(MMPRItems.DRAGON_DAGGER.get()));
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MMPRItems.SWORDOFDARKNESS.get()));
        RangerChangerItem.set_Form_Item(this.getItemBySlot(EquipmentSlot.FEET), MMPRItems.DRAGON_POWER_COIN.get(), 2);
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
                .add(Attributes.MOVEMENT_SPEED,(double)0.2F)
                .add(Attributes.ATTACK_DAMAGE, 15.0D)
                .add(Attributes.ARMOR, 4.0D)
                .add(Attributes.MAX_HEALTH, 250.0D);
    }
}