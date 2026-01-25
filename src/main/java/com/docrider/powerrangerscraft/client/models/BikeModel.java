package com.docrider.powerrangerscraft.client.models;


import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.entity.bikes.baseBikeEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class BikeModel extends GeoModel<baseBikeEntity> {
    private long lastRenderedInstance = -1L;

    @Override
    public ResourceLocation getModelResource(baseBikeEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "geo/"+animatable.NAME_MODEL+".geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(baseBikeEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "textures/entities/"+animatable.NAME+".png");
    }

    @Override
    public ResourceLocation getAnimationResource(baseBikeEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "animations/"+animatable.NAME_ANIMATIONS+".animation.json");
    }


    @Override
    public void setCustomAnimations(baseBikeEntity an, long instanceId, AnimationState<baseBikeEntity> state) {


        GeoBone front_fork = this.getAnimationProcessor().getBone("front_fork");
        GeoBone front_fork2 = this.getAnimationProcessor().getBone("front_fork2");
        GeoBone pedals = this.getAnimationProcessor().getBone("pedals");
        GeoBone b_wheel= this.getAnimationProcessor().getBone("b_wheel");
        GeoBone f_wheel = this.getAnimationProcessor().getBone("f_wheel");
        GeoBone f_wheel2 = this.getAnimationProcessor().getBone("f_wheel2");
        EntityModelData entityData = state.getData(DataTickets.ENTITY_MODEL_DATA);
        baseBikeEntity entityData2 = (baseBikeEntity) state.getData(DataTickets.ENTITY);

        baseBikeEntity  animatable= state.getAnimatable();
        if (front_fork != null) front_fork.setRotY(entityData.headPitch());
        if (front_fork2 != null) front_fork2.setRotY(entityData.headPitch());
        if (f_wheel2 != null) f_wheel2.setRotX((float) entityData2.getWheelRotation());
        if (f_wheel != null) f_wheel.setRotX((float) entityData2.getWheelRotation());
        if (b_wheel != null) b_wheel.setRotX((float) entityData2.getWheelRotation());
        if (pedals != null) pedals.setRotX((float) entityData2.getWheelRotation());
    }
}