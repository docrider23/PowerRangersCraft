package com.docrider.powerrangerscraft.loot;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.mojang.serialization.MapCodec;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModLootModifiers {

    public static DeferredRegister<MapCodec<? extends IGlobalLootModifier>> LOOT_MODIFIERS = DeferredRegister.create(NeoForgeRegistries.GLOBAL_LOOT_MODIFIER_SERIALIZERS, PowerRangersCraftCore.MODID);

    public static final DeferredHolder<MapCodec<? extends IGlobalLootModifier>, MapCodec<AddItemModifier>> ADD_ITEM_MODIFIER = LOOT_MODIFIERS.register("add_item", AddItemModifier.CODEC_SUPPLIER);
    public static final DeferredHolder<MapCodec<? extends IGlobalLootModifier>, MapCodec<AddSusSandItemModifier>> ADD_SUS_SAND_ITEM_MODIFIER = LOOT_MODIFIERS.register("add_sus_sand_item", AddSusSandItemModifier.CODEC_SUPPLIER);

    public static void register(IEventBus eventBus) {
        LOOT_MODIFIERS.register(eventBus);
    }
}
