package com.docrider.powerrangerscraft.items.client;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.items.others.RangerArmorItem;
import com.docrider.powerrangerscraft.items.others.RangerChangerItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;

public class RangerArmorModel extends GeoModel<RangerArmorItem> {

    public RangerArmorModel() {
    }

    @Override
    public ResourceLocation getModelResource(RangerArmorItem animatable, @Nullable GeoRenderer<RangerArmorItem> renderer) {
        if (renderer instanceof RangerArmorRenderer rangerRenderer) {
            LivingEntity RANGER = rangerRenderer.GetEntity();
            EquipmentSlot slot= rangerRenderer.getCurrentSlot();
            if (RANGER.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RangerChangerItem BELT) {
                if (slot == EquipmentSlot.FEET)
                    return BELT.getBeltModelResource(RANGER.getItemBySlot(EquipmentSlot.FEET), animatable, slot, RANGER);
                else return BELT.getModelResource(RANGER.getItemBySlot(EquipmentSlot.FEET), animatable, slot, RANGER);
            }
        }
        return ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "geo/ranger.geo.json");
    }

    @Override
    public ResourceLocation getModelResource(RangerArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "geo/ranger.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RangerArmorItem animatable, @Nullable GeoRenderer<RangerArmorItem> renderer) {
        if (renderer instanceof RangerArmorRenderer riderRenderer) {
            LivingEntity RIDER = riderRenderer.GetEntity();
            EquipmentSlot slot = riderRenderer.getCurrentSlot();
            ItemStack BELT = RIDER.getItemBySlot(EquipmentSlot.FEET);
            if (BELT.getItem() instanceof RangerChangerItem DRIVER && (slot == EquipmentSlot.FEET || DRIVER.isTransformed(RIDER))) {
                return ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "textures/armor/" + DRIVER.GET_TEXT(BELT, slot, RIDER, DRIVER.Rider) + ".png");
            }
        }
        return ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "textures/armor/blank.png");
    }

    @Override
    public ResourceLocation getTextureResource(RangerArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "textures/armor/blank.png");
    }

    @Override
    public ResourceLocation getAnimationResource(RangerArmorItem animatable) {
        return  ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "animations/ranger.animation.json");
    }

    @Override
    public void setCustomAnimations(RangerArmorItem an, long instanceId, AnimationState<RangerArmorItem> state) {

        Entity entity = state.getData(DataTickets.ENTITY);
        if (entity instanceof LivingEntity RIDER) {
        GeoBone front_fork = this.getAnimationProcessor().getBone("front_fork");
        GeoBone front_fork2 = this.getAnimationProcessor().getBone("front_fork2");
        GeoBone b_wheel = this.getAnimationProcessor().getBone("b_wheel");
        GeoBone f_wheel = this.getAnimationProcessor().getBone("f_wheel");
        GeoBone f_wheel2 = this.getAnimationProcessor().getBone("f_wheel2");
        GeoBone ball = this.getAnimationProcessor().getBone("ball");

        GeoBone cape = this.getAnimationProcessor().getBone("cape");
            if (cape != null & RangerArmorItem.GetCapeRotation(RIDER.getItemBySlot(EquipmentSlot.FEET)) < 0)
                cape.setRotX(RangerArmorItem.GetCapeRotation(RIDER.getItemBySlot(EquipmentSlot.FEET)));
            if (cape != null & RangerArmorItem.GetBallRotation(RIDER.getItemBySlot(EquipmentSlot.FEET)) != 0)
                cape.setRotY(RangerArmorItem.GetBallRotation(RIDER.getItemBySlot(EquipmentSlot.FEET)));

            if (front_fork != null) front_fork.setRotY(RangerArmorItem.GetBallRotation(RIDER.getItemBySlot(EquipmentSlot.FEET)));
            if (front_fork2 != null)
                front_fork2.setRotY(RangerArmorItem.GetBallRotation(RIDER.getItemBySlot(EquipmentSlot.FEET)));

            if (f_wheel != null) f_wheel.setRotX(RangerArmorItem.GetWheelRotation(RIDER.getItemBySlot(EquipmentSlot.FEET)));
            if (f_wheel2 != null) f_wheel2.setRotX(RangerArmorItem.GetWheelRotation(RIDER.getItemBySlot(EquipmentSlot.FEET)));
            if (b_wheel != null) b_wheel.setRotX(RangerArmorItem.GetWheelRotation(RIDER.getItemBySlot(EquipmentSlot.FEET)));
            if (ball != null) {
                ball.setRotX(RangerArmorItem.GetWheelRotation(RIDER.getItemBySlot(EquipmentSlot.FEET)));
                ball.setRotZ(RangerArmorItem.GetBallRotation(RIDER.getItemBySlot(EquipmentSlot.FEET)));
            }
        }
    }
}