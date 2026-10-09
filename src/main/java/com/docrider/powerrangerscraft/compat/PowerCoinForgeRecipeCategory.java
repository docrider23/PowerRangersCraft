package com.docrider.powerrangerscraft.compat;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.blocks.RangerBlocks;
import com.docrider.powerrangerscraft.recipe.PowerCoinForgeRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PowerCoinForgeRecipeCategory implements IRecipeCategory<PowerCoinForgeRecipe> {
    public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "power_coin_forge");
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "textures/gui/power_coin_forge_gui.png");

    public static final RecipeType<PowerCoinForgeRecipe> POWER_COIN_FORGE_RECIPE_RECIPE_TYPE = new RecipeType<>(ID, PowerCoinForgeRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public PowerCoinForgeRecipeCategory(IGuiHelper guiHelper) {
        this.background = guiHelper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(RangerBlocks.POWER_COIN_FORGE));
    }

    @Override
    public RecipeType<PowerCoinForgeRecipe> getRecipeType() {
        return POWER_COIN_FORGE_RECIPE_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.powerrangerscraft.power_coin_forge");
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return icon;
    }

    @Override
    public @Nullable IDrawable getBackground() {
        return background;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, PowerCoinForgeRecipe recipe, IFocusGroup focuses) {
        if (recipe.primaryInput() != null && !recipe.primaryInput().isEmpty()) {
            builder.addSlot(RecipeIngredientRole.INPUT, 19, 21).addIngredients(recipe.primaryInput());
        }

        if (recipe.optionalInput() != null && recipe.optionalInput().isPresent()) {
            Ingredient optionalIngredient = recipe.optionalInput().get();
            if (!optionalIngredient.isEmpty()) {
                builder.addSlot(RecipeIngredientRole.CATALYST, 19, 57).addIngredients(optionalIngredient);
            }
        }

        List<ItemStack> possibleOutputs = recipe.outputs().stream().map(PowerCoinForgeRecipe.WeightedOutput::stack).toList();
        builder.addSlot(RecipeIngredientRole.OUTPUT, 94, 21).addItemStacks(possibleOutputs);
    }
}
