package com.docrider.powerrangerscraft.recipe;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, PowerRangersCraftCore.MODID);
    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, PowerRangersCraftCore.MODID);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<PowerCoinForgeRecipe>> POWER_COIN_FORGE_SERIALIZER =
            SERIALIZERS.register("power_coin_forge", () -> new RecipeSerializer<PowerCoinForgeRecipe>() {
                @Override
                public com.mojang.serialization.MapCodec<PowerCoinForgeRecipe> codec() {
                    return PowerCoinForgeRecipe.CODEC;
                }

                @Override
                public net.minecraft.network.codec.StreamCodec<net.minecraft.network.RegistryFriendlyByteBuf, PowerCoinForgeRecipe> streamCodec() {
                    return PowerCoinForgeRecipe.STREAM_CODEC;
                }
            });
    public static final DeferredHolder<RecipeType<?>, RecipeType<PowerCoinForgeRecipe>> POWER_COIN_FORGE_TYPE =
            TYPES.register("ixa_machine_block", () -> new RecipeType<>() {
                @Override
                public String toString() {
                    return "ixa_machine_block";
                }
            });


    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        TYPES.register(eventBus);
    }
}
