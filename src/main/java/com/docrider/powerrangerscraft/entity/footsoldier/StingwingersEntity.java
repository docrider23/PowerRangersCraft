package com.docrider.powerrangerscraft.entity.footsoldier;

import com.docrider.powerrangerscraft.items.MobsItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class StingwingersEntity extends BaseFootsoldierEntity {

    public StingwingersEntity(EntityType<? extends BaseFootsoldierEntity> type, Level level) {
        super(type, level);
        NAME="stingwinger";
        this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(MobsItems.STINGWINGERS_STINGER.get()));
    }
}
