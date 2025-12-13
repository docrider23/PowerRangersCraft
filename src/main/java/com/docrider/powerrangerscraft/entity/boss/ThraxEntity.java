package com.docrider.powerrangerscraft.entity.boss;

import com.docrider.powerrangerscraft.entity.footsoldier.BaseFootsoldierEntity;
import com.docrider.powerrangerscraft.items.MobsItems;
import com.docrider.powerrangerscraft.items.OperationOverdriveItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ThraxEntity extends BaseFootsoldierEntity {

    public ThraxEntity(EntityType<? extends BaseFootsoldierEntity> type, Level level) {
        super(type, level);
        NAME="dr_thrax";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(OperationOverdriveItems.OPERATION_OVERDRIVE_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(OperationOverdriveItems.OPERATION_OVERDRIVE_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(OperationOverdriveItems.OPERATION_OVERDRIVE_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(OperationOverdriveItems.THRAX_CODPIECE.get()));
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MobsItems.Z_STAFF_THRAX.get()));
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