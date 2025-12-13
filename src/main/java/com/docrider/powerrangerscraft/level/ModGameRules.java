package com.docrider.powerrangerscraft.level;

import net.minecraft.world.level.GameRules;
import net.neoforged.bus.api.IEventBus;

public class ModGameRules {
    public static GameRules.Key<GameRules.IntegerValue> RULE_BOSS_SPAWN_PERCENTAGE;

    public static void register(IEventBus eventBus) {
                RULE_BOSS_SPAWN_PERCENTAGE = GameRules.register(
                "bossSpawnPercentage_PRC", GameRules.Category.SPAWNING, GameRules.IntegerValue.create(10));
    }
}
