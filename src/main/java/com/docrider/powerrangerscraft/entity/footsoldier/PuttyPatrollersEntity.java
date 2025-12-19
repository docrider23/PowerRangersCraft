package com.docrider.powerrangerscraft.entity.footsoldier;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class PuttyPatrollersEntity extends BaseFootsoldierEntity {

    public PuttyPatrollersEntity(EntityType<? extends BaseFootsoldierEntity> type, Level level) {
        super(type, level);
        NAME="putty_patroller";
    }
}