package com.docrider.powerrangerscraft.recipe;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

public record PowerCoinForgeInput(ItemStack primary, ItemStack catalyst) implements RecipeInput {
    @Override
    public ItemStack getItem(int index) {
        return index == 0 ? primary : (index == 1 ? catalyst : ItemStack.EMPTY);
    }

    @Override
    public int size() {
        return 2;
    }

    @Override
    public boolean isEmpty() {
        return primary.isEmpty() && catalyst.isEmpty();
    }

    // CRITICAL FIX: Explicitly enforce value-based equivalence checks.
    // Minecraft's recipe manager cache checks this heavily during the server tick loop!
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PowerCoinForgeInput other)) return false;
        return ItemStack.isSameItemSameComponents(this.primary, other.primary)
                && ItemStack.isSameItemSameComponents(this.catalyst, other.catalyst);
    }

    @Override
    public int hashCode() {
        int result = ItemStack.hashItemAndComponents(primary);
        result = 31 * result + ItemStack.hashItemAndComponents(catalyst);
        return result;
    }
}
