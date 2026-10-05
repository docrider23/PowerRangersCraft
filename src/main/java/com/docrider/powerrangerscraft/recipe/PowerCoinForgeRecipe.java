package com.docrider.powerrangerscraft.recipe;

import com.docrider.powerrangerscraft.recipe.PowerCoinForgeInput;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Optional;

public record PowerCoinForgeRecipe(Ingredient primaryInput, Optional<Ingredient> optionalInput, List<WeightedOutput> outputs) implements Recipe<PowerCoinForgeInput> {

    public static final MapCodec<PowerCoinForgeRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            Ingredient.CODEC.fieldOf("primary_input").forGetter(PowerCoinForgeRecipe::primaryInput),

            Ingredient.CODEC.optionalFieldOf("optional_input").forGetter(PowerCoinForgeRecipe::optionalInput),

            WeightedOutput.CODEC.listOf().fieldOf("outputs").forGetter(PowerCoinForgeRecipe::outputs)
    ).apply(inst, PowerCoinForgeRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, PowerCoinForgeRecipe> STREAM_CODEC = StreamCodec.composite(
            Ingredient.CONTENTS_STREAM_CODEC, PowerCoinForgeRecipe::primaryInput,
            ByteBufCodecs.optional(Ingredient.CONTENTS_STREAM_CODEC), PowerCoinForgeRecipe::optionalInput,
            WeightedOutput.STREAM_CODEC.apply(ByteBufCodecs.list()), PowerCoinForgeRecipe::outputs,
            PowerCoinForgeRecipe::new
    );

    @Override
    public boolean matches(PowerCoinForgeInput input, Level level) {
        if (input.size() < 2) return false;
        ItemStack slot0 = input.getItem(0);
        ItemStack slot1 = input.getItem(1);

        if (!this.primaryInput.test(slot0)) return false;

        if (this.optionalInput.isPresent()) {
            return this.optionalInput.get().test(slot1);
        } else {
            return slot1.isEmpty();
        }
    }

    @Override
    public ItemStack assemble(PowerCoinForgeInput input, HolderLookup.Provider provider) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canCraftInDimensions(int i, int i1) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return ItemStack.EMPTY;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.POWER_COIN_FORGE_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.POWER_COIN_FORGE_TYPE.get();
    }

    public record WeightedOutput(ItemStack stack, int weight) {
        public static final Codec<WeightedOutput> CODEC = RecordCodecBuilder.create(inst -> inst.group(
                ItemStack.STRICT_CODEC.fieldOf("result").forGetter(WeightedOutput::stack),
                Codec.INT.fieldOf("weight").forGetter(WeightedOutput::weight)
        ).apply(inst, WeightedOutput::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, WeightedOutput> STREAM_CODEC = StreamCodec.composite(
                ItemStack.STREAM_CODEC, WeightedOutput::stack,
                ByteBufCodecs.INT, WeightedOutput::weight,
                WeightedOutput::new
        );
    }
}

