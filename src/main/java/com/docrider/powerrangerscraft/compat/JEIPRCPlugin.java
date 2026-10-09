package com.docrider.powerrangerscraft.compat;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.client.gui.PowerCoinForgeGuiScreen;
import com.docrider.powerrangerscraft.recipe.ModRecipes;
import com.docrider.powerrangerscraft.recipe.PowerCoinForgeRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

@JeiPlugin
public class JEIPRCPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new PowerCoinForgeRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<PowerCoinForgeRecipe> powerCoinForgeRecipes = recipeManager.getAllRecipesFor(ModRecipes.POWER_COIN_FORGE_TYPE.get()).stream().map(RecipeHolder::value).toList();
        registration.addRecipes(PowerCoinForgeRecipeCategory.POWER_COIN_FORGE_RECIPE_RECIPE_TYPE, powerCoinForgeRecipes);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(PowerCoinForgeGuiScreen.class, 48, 40, 20, 14, PowerCoinForgeRecipeCategory.POWER_COIN_FORGE_RECIPE_RECIPE_TYPE);
    }
}
