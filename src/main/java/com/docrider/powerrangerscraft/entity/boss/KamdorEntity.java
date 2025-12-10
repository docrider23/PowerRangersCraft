package com.docrider.powerrangerscraft.entity.boss;

import com.docrider.powerrangerscraft.entity.footsoldier.BaseFootsoldierEntity;
import com.docrider.powerrangerscraft.items.MobsItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class KamdorEntity extends BaseFootsoldierEntity {

    public KamdorEntity(EntityType<? extends BaseFootsoldierEntity> type, Level level) {
        super(type, level);
        NAME="kamdor";
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MobsItems.KAMDOR_KATANA.get()));
        this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(MobsItems.KAMDOR_KATANA.get()));
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