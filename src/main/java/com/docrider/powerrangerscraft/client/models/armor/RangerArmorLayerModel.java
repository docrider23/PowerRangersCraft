package com.docrider.powerrangerscraft.client.models.armor;


import com.docrider.powerrangerscraft.items.others.RangerArmorItem;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoRenderer;

public class RangerArmorLayerModel<T extends RangerArmorItem> extends RangerArmorModel<T> {
    public RangerArmorLayerModel() {
    }

    @Override
    public ResourceLocation getModelResource(T animatable, @Nullable GeoRenderer<T> renderer) {
        return getModelResource(animatable);
    }
}