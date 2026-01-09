package com.docrider.powerrangerscraft.client;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.neoforged.neoforge.client.settings.KeyConflictContext;

public class KeyBindings {
    public static final KeyBindings INSTANCE = new KeyBindings();

    private static final String CATEGORY = "key.categories." + PowerRangersCraftCore.MODID;

    public final KeyMapping AbilityKey = new KeyMapping(
            "key."+ PowerRangersCraftCore.MODID +".ability",
            KeyConflictContext.IN_GAME,
            InputConstants.getKey(InputConstants.KEY_V, -1),
            CATEGORY
    );
}


