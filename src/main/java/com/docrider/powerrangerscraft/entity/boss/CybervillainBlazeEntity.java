package com.docrider.powerrangerscraft.entity.boss;

import com.docrider.powerrangerscraft.entity.footsoldier.BaseFootsoldierEntity;
import com.docrider.powerrangerscraft.items.*;
import com.docrider.powerrangerscraft.items.others.RangerChangerItem;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.Random;

public class CybervillainBlazeEntity extends BaseFootsoldierEntity {

    private final ServerBossEvent bossEvent = (ServerBossEvent)(new ServerBossEvent(Component.translatable(getDisplayName().getString()).withStyle(ChatFormatting.GRAY), BossEvent.BossBarColor.RED, BossEvent.BossBarOverlay.PROGRESS));

    public CybervillainBlazeEntity(EntityType<? extends BaseFootsoldierEntity> type, Level level) {
        super(type, level);
        NAME="cybervillain_blaze";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(BeastMorphersItems.BEAST_MORPHERS_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(BeastMorphersItems.BEAST_MORPHERS_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(BeastMorphersItems.BEAST_MORPHERS_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(BeastMorphersItems.BLAZE_EVOX_BEAST_X_MORPHER.get()));
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MobsItems.CYBERVILLAIN_BLAZE_SWORD.get()));
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

    @Override
    public void actuallyHurt(DamageSource source, float amount) {
        super.actuallyHurt(source, amount);
        if(!this.level().isClientSide() && source.getEntity() instanceof Player playerIn && this.getHealth()<25
                && this.getItemBySlot(EquipmentSlot.FEET).getItem()==BeastMorphersItems.BLAZE_EVOX_BEAST_X_MORPHER.get()) {

            Inventory Inventory = playerIn.getInventory();
            boolean hasVisor = Inventory.countItem(BeastMorphersItems.BEAST_X_VISOR.get()) != 0;

            if (hasVisor) {
                this.setItemSlot(EquipmentSlot.FEET, new ItemStack(BeastMorphersItems.ROBO_BLAZE_EVOX_BEAST_X_MORPHER.get()));
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MobsItems.CYBERVILLAIN_ROBO_BLAZE_RAPIER.get()));
                this.bossEvent.setName(Component.translatable("entity.powerrangerscraft.cybervillain_robo_blaze").withStyle(ChatFormatting.GOLD));
                this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.4);
                this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(10.0D);
                this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(150.0D);
                this.heal(125);
            }
        }
    }

    public void remove(RemovalReason p_149847_) {

        if ( this.isDeadOrDying()) {
            if(!this.level().isClientSide() && this.getItemBySlot(EquipmentSlot.FEET).getItem()==BeastMorphersItems.ROBO_BLAZE_EVOX_BEAST_X_MORPHER.get())
            {
                Random generator = new Random();
                int randomInt = generator.nextInt(3);

                if (randomInt == 0) {
                    ItemEntity key = new ItemEntity(level(), getX(), getY(), getZ(), new ItemStack(BeastMorphersItems.ROBO_BLAZE_MORPH_X_KEY.get(), 1), 0, 0, 0);
                    key.setPickUpDelay(0);
                    level().addFreshEntity(key);
                }
                else if (randomInt == 1) {
                    ItemEntity key = new ItemEntity(level(), getX(), getY(), getZ(), new ItemStack(BeastMorphersItems.RED_FURY_MORPH_X_KEY.get(), 1), 0, 0, 0);
                    key.setPickUpDelay(0);
                    level().addFreshEntity(key);
                }
                else if (randomInt == 2) {
                    ItemEntity key = new ItemEntity(level(), getX(), getY(), getZ(), new ItemStack(BeastMorphersItems.MORPH_X_CANISTER.get(), 2), 0, 0, 0);
                    key.setPickUpDelay(0);
                    level().addFreshEntity(key);
                }
            }
        }
        super.remove(p_149847_);
    }

    public static AttributeSupplier.Builder setAttributes() {

        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 35.0D)
                .add(Attributes.MOVEMENT_SPEED,(double)0.2F)
                .add(Attributes.ATTACK_DAMAGE, 15.0D)
                .add(Attributes.ARMOR, 4.0D)
                .add(Attributes.MAX_HEALTH, 100.0D);
    }
}