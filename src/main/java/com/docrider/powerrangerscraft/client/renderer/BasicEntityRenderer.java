package com.docrider.powerrangerscraft.client.renderer;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.client.models.BasicMobModel;
import com.docrider.powerrangerscraft.entity.FootSoldierModel;
import com.docrider.powerrangerscraft.entity.footsoldier.BaseFootsoldierEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;

public class BasicEntityRenderer extends HumanoidMobRenderer<BaseFootsoldierEntity, BasicMobModel<BaseFootsoldierEntity>> {


    public BasicEntityRenderer(EntityRendererProvider.Context ctx) {
        this(ctx, ModelLayers.PLAYER);
    }


    public BasicEntityRenderer(EntityRendererProvider.Context ctx, ModelLayerLocation ModelLayer) {
        super(ctx, new BasicMobModel<>(ctx.bakeLayer(ModelLayer)),1,1,1,1);
        this.addLayer(new HumanoidArmorLayer<>(this, new FootSoldierModel<>(ctx.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new FootSoldierModel<>(ctx.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), ctx.getModelManager()));

    }

    @Override
    public ResourceLocation getTextureLocation(BaseFootsoldierEntity p_114482_) {

        return ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "textures/entities/"+p_114482_.NAME+".png");
    }
}