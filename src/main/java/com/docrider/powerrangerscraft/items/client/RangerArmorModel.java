package com.docrider.powerrangerscraft.items.client;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.items.others.RangerArmorItem;
import com.docrider.powerrangerscraft.items.others.RangerChangerItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.model.GeoModel;

public class RangerArmorModel extends GeoModel<RangerArmorItem> {

    private static LivingEntity RIDER;
    private EquipmentSlot slot;

    public RangerArmorModel(LivingEntity livingEntity, EquipmentSlot equipmentSlot) {

        RIDER =  livingEntity;
        slot =  equipmentSlot;
    }

    @Override
    public ResourceLocation getModelResource(RangerArmorItem animatable) {
        if (slot== EquipmentSlot.FEET) {
            if (RIDER.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RangerChangerItem) {
                RangerChangerItem BELT = ((RangerChangerItem)RIDER.getItemBySlot(EquipmentSlot.FEET).getItem());

                return BELT.getBeltModelResource(RIDER.getItemBySlot(EquipmentSlot.FEET),animatable,slot,RIDER);

            }else return ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "geo/rangerbelt.geo.json");
        }else {

            if (RIDER.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RangerChangerItem) {
                RangerChangerItem BELT = ((RangerChangerItem)RIDER.getItemBySlot(EquipmentSlot.FEET).getItem());

                return BELT.getModelResource(RIDER.getItemBySlot(EquipmentSlot.FEET),animatable,slot,RIDER);

            }else return ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "geo/ranger.geo.json");
        }
    }

    @Override
    public ResourceLocation getTextureResource(RangerArmorItem animatable) {


        String FORM="blank";
        ItemStack BELT = RIDER.getItemBySlot(EquipmentSlot.FEET);
        if (BELT.getItem() instanceof RangerChangerItem) {
            FORM=((RangerChangerItem) BELT.getItem()).GET_TEXT(BELT,slot,RIDER,((RangerChangerItem) BELT.getItem()).Rider );
            if (slot == EquipmentSlot.FEET) {

                FORM=((RangerChangerItem) BELT.getItem()).GET_TEXT(BELT,slot ,RIDER,((RangerChangerItem) BELT.getItem()).Rider);
            }else if ( ((RangerChangerItem) BELT.getItem()).HEAD.asItem()!=RIDER.getItemBySlot(EquipmentSlot.HEAD).getItem()||
                    ((RangerChangerItem) BELT.getItem()).TORSO.asItem()!=RIDER.getItemBySlot(EquipmentSlot.CHEST).getItem()||
                    ((RangerChangerItem) BELT.getItem()).LEGS.asItem()!=RIDER.getItemBySlot(EquipmentSlot.LEGS).getItem()) {
                FORM="blank";
            }


        }
        return ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "textures/armor/"+FORM+".png");
    }



    @Override
    public ResourceLocation getAnimationResource(RangerArmorItem animatable) {
        if (slot== EquipmentSlot.FEET) {
            return ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "animations/rangerbelt.animation.json");
        }else {

            if (RIDER.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RangerChangerItem) {
                RangerChangerItem BELT = ((RangerChangerItem)RIDER.getItemBySlot(EquipmentSlot.FEET).getItem());

                return BELT.getAnimationResource(RIDER.getItemBySlot(EquipmentSlot.FEET),animatable,slot);

            }else return ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "animations/ranger.animation.json");
        }

    }
}