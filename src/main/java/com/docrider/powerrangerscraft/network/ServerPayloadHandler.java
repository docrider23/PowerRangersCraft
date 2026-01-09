package com.docrider.powerrangerscraft.network;

import com.docrider.powerrangerscraft.items.others.RangerChangerItem;
import com.docrider.powerrangerscraft.network.payload.AbilityKeyPayload;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public class ServerPayloadHandler {

    public static void handleAbilityKeyPress(final AbilityKeyPayload data, final IPayloadContext context) {
        handleAbilityKeyPress((ServerPlayer)context.player());
    }

    private static void handleAbilityKeyPress(ServerPlayer player) {

        if (player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RangerChangerItem belt) RangerChangerItem.setUseAbility(player.getItemBySlot(EquipmentSlot.FEET));
    }
}