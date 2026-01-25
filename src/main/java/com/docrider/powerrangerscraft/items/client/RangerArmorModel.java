package com.docrider.powerrangerscraft.items.client;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.items.others.RangerArmorItem;
import com.docrider.powerrangerscraft.items.others.RangerChangerItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.model.GeoModel;

public class RangerArmorModel extends GeoModel<RangerArmorItem> {

    private static LivingEntity RIDER;
    private final EquipmentSlot slot;

    public RangerArmorModel(LivingEntity livingEntity, EquipmentSlot equipmentSlot) {

        RIDER =  livingEntity;
        slot =  equipmentSlot;
    }

    @Override
    public ResourceLocation getModelResource(RangerArmorItem animatable) {
        if (RIDER.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RangerChangerItem BELT) {
            if (slot== EquipmentSlot.FEET) return BELT.getBeltModelResource(RIDER.getItemBySlot(EquipmentSlot.FEET),animatable,slot,RIDER);
            else return BELT.getModelResource(RIDER.getItemBySlot(EquipmentSlot.FEET),animatable,slot,RIDER);
        }
        return ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "geo/ranger.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RangerArmorItem animatable) {
        ItemStack BELT = RIDER.getItemBySlot(EquipmentSlot.FEET);
        if (BELT.getItem() instanceof RangerChangerItem DRIVER && (slot == EquipmentSlot.FEET || DRIVER.isTransformed(RIDER))) {
            return ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "textures/armor/"+DRIVER.GET_TEXT(BELT,slot,RIDER,DRIVER.Rider)+".png");
        }
        return ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "textures/armor/blank.png");
    }


    @Override
    public ResourceLocation getAnimationResource(RangerArmorItem animatable) {
        if (slot== EquipmentSlot.FEET) {
            return ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "animations/rangerbelt.animation.json");
        } else if (RIDER.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RangerChangerItem BELT) {
            return BELT.getAnimationResource(RIDER.getItemBySlot(EquipmentSlot.FEET),animatable,slot);
        }
        return  ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "animations/ranger.animation.json");
    }

    @Override
    public void setCustomAnimations(RangerArmorItem an, long instanceId, AnimationState<RangerArmorItem> state) {

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

        if (front_fork != null)
            front_fork.setRotY(RangerArmorItem.GetBallRotation(RIDER.getItemBySlot(EquipmentSlot.FEET)));
        if (front_fork2 != null)
            front_fork2.setRotY(RangerArmorItem.GetBallRotation(RIDER.getItemBySlot(EquipmentSlot.FEET)));

        if (f_wheel != null) f_wheel.setRotX(RangerArmorItem.GetWheelRotation(RIDER.getItemBySlot(EquipmentSlot.FEET)));
        if (f_wheel2 != null)
            f_wheel2.setRotX(RangerArmorItem.GetWheelRotation(RIDER.getItemBySlot(EquipmentSlot.FEET)));
        if (b_wheel != null) b_wheel.setRotX(RangerArmorItem.GetWheelRotation(RIDER.getItemBySlot(EquipmentSlot.FEET)));
        if (ball != null) {
            ball.setRotX(RangerArmorItem.GetWheelRotation(RIDER.getItemBySlot(EquipmentSlot.FEET)));
            ball.setRotZ(RangerArmorItem.GetBallRotation(RIDER.getItemBySlot(EquipmentSlot.FEET)));
        }
    }
}