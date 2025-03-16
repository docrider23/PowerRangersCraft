package com.docrider.powerrangerscraft.entity.footsoldier;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class SilverSentryEntity extends BaseFootsoldierEntity {

    public SilverSentryEntity(EntityType<? extends BaseFootsoldierEntity> type, Level level) {
        super(type, level);
        NAME="silver_sentry";
    }
}
