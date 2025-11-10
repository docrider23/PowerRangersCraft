package com.docrider.powerrangerscraft.entity.footsoldier;

import com.docrider.powerrangerscraft.items.MobsItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BatlingsEntity extends BaseFootsoldierEntity {

    public BatlingsEntity(EntityType<? extends BaseFootsoldierEntity> type, Level level) {
        super(type, level);
        NAME="batlings";
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MobsItems.BATLINGS_SWORD.get()));
    }
}