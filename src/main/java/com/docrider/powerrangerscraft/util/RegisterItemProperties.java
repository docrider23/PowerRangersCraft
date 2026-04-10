package com.docrider.powerrangerscraft.util;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.items.*;
import com.docrider.powerrangerscraft.items.dino_fury.DinoFuryMorpherItem;
import com.docrider.powerrangerscraft.items.dino_fury.MosaBlasterItem;
import com.docrider.powerrangerscraft.items.lost_galaxy.TransmorpherItem;
import com.docrider.powerrangerscraft.items.others.BaseBlasterItem;
import com.docrider.powerrangerscraft.items.others.BaseDualSwordItem;
import com.docrider.powerrangerscraft.items.others.BaseSwordItem;
import com.docrider.powerrangerscraft.items.others.RangerChangerItem;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import static com.docrider.powerrangerscraft.PowerRangersCraftCore.*;

public class RegisterItemProperties {
    public static void addCustomItemProperties() {
        registerShieldItems();
        registerSwordItems();
        registerMultiItems();
        registerChargedItems();
    }

    private static void registerShieldItems() {
        ResourceLocation BLOCKING_PROPERTY_RESLOC = ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "blocking");

        for (int i = 0; i < SHIELD_ITEM.size(); i++) {
            ItemProperties.register(SHIELD_ITEM.get(i), BLOCKING_PROPERTY_RESLOC, ($itemStack, $level, $entity, $seed) -> {
                return $entity != null && $entity.isUsingItem() && $entity.getUseItem() == $itemStack ? 1.0F : 0.0F;
            });
        }
    }

    public static void registerSwordItems() {
        for (int i = 0; i < SWORD_GUN_ITEM.size(); i++) {
            ItemProperties.register(SWORD_GUN_ITEM.get(i), ResourceLocation.parse("change"), ($itemStack, $level, $entity, $seed) -> {
                if ($entity == null) {
                    return 0.0F;
                } else {
                    return $entity.getUseItem() != $itemStack ? 0.0F : (float)($itemStack.getUseDuration($entity) - $entity.getUseItemRemainingTicks()) / 1.0F;
                }
            });
        }
    }

    public static void registerMultiItems() {
        for (int i = 0; i < MULTI_WEAPON_ITEM.size(); i++) {
            ItemProperties.register(MULTI_WEAPON_ITEM.get(i), ResourceLocation.parse("change"), ($itemStack, $level, $entity, $seed) -> {
                return BaseDualSwordItem.get_mode($itemStack);
            });
        }

        for (int i = 0; i < FORM_WEAPON_ITEM.size(); i++) {
            ItemProperties.register(FORM_WEAPON_ITEM.get(i), ResourceLocation.parse("change"), ($itemStack, $level, $entity, $seed) -> {
                if ($entity == null) {
                    return 0.0F;
                }
                else if ($entity.getItemBySlot(EquipmentSlot.FEET)!= null) {
                    ItemStack belt = $entity.getItemBySlot(EquipmentSlot.FEET);
                    if ($entity.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof TransmorpherItem) {
                        if ($itemStack.getItem() == LostGalaxyItems.QUASAR_LAUNCHER_RED.get()||$itemStack.getItem() == LostGalaxyItems.QUASAR_LAUNCHER_GREEN.get()||$itemStack.getItem() == LostGalaxyItems.QUASAR_LAUNCHER_BLUE.get()||$itemStack.getItem() == LostGalaxyItems.QUASAR_LAUNCHER_YELLOW.get()||$itemStack.getItem() == LostGalaxyItems.QUASAR_LAUNCHER_PINK.get()) {
                            if (TransmorpherItem.get_Form_Item(belt, 2).getBeltTex()=="lights_of_orion_belt") return $entity.getUseItem() != $itemStack ? 2.0F : 3.0F;
                            else return $entity.getUseItem() != $itemStack ? 0.0F : 1.0F;
                        }
                        if ($itemStack.getItem() == LostGalaxyItems.QUASAR_SABER.get()) {
                            if (TransmorpherItem.get_Form_Item(belt, 2).getBeltTex()=="lights_of_orion_belt") return 1;
                            else return 0;
                        }
                            /*if ($entity.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof VSChangerItem) {
                                if ($itemStack.getItem() == LuPatRangerItems.VS_CHANGER.get()) {
                                    if (VSChangerItem.get_Form_Item(belt,2).getFormName(false)=="_tricolor") return 7;
                                    else if (VSChangerItem.get_Form_Item(belt,2).getFormName(false)=="_ugou") return 8;
                                    else if (VSChangerItem.get_Form_Item(belt,2).getFormName(false)=="lupat_scissor") return 9;
                                    else if (VSChangerItem.get_Form_Item(belt,2).getFormName(false)=="lupat_crane") return 10;
                                    else if (VSChangerItem.get_Form_Item(belt,2).getFormName(false)=="lupat_magic") return 11;
                                    else if (VSChangerItem.get_Form_Item(belt,2).getFormName(false)=="lupat_splash") return 12;
                                    else if (VSChangerItem.get_Form_Item(belt,2).getFormName(false)=="_super") return 13;
                                    else if (VSChangerItem.get_Form_Item(belt,2).getFormName(false)=="lupat_siren") return 14;
                                    else if (VSChangerItem.get_Form_Item(belt,2).getFormName(false)=="lupat_gold") return 15;
                                    else if (VSChangerItem.get_Form_Item(belt,2).getFormName(false)=="") {
                                        if ($entity.getItemBySlot(EquipmentSlot.FEET).getItem()==LuPatRangerItems.RED_VS_CHANGER.get()) return 1;
                                        else if ($entity.getItemBySlot(EquipmentSlot.FEET).getItem()==LuPatRangerItems.BLUE_VS_CHANGER.get()) return 2;
                                        else if ($entity.getItemBySlot(EquipmentSlot.FEET).getItem()==LuPatRangerItems.YELLOW_VS_CHANGER.get()) return 3;
                                        else if ($entity.getItemBySlot(EquipmentSlot.FEET).getItem()==LuPatRangerItems.ICHIGOU_VS_CHANGER.get()) return 4;
                                        else if ($entity.getItemBySlot(EquipmentSlot.FEET).getItem()==LuPatRangerItems.NIGOU_VS_CHANGER.get()) return 5;
                                        else if ($entity.getItemBySlot(EquipmentSlot.FEET).getItem()==LuPatRangerItems.SANGOU_VS_CHANGER.get()) return 6;
                                    }
                                    else return 0;
                                }
                            }*/
                        if ($entity.getItemBySlot(EquipmentSlot.FEET).getItem()==StarrangerItems.COSMO_SABER_GOLD.get()) {
                            if ($itemStack.getItem() == StarrangerItems.COSMO_SABER.get()){
                                if (RangerChangerItem.get_Form_Item(belt, 1) == StarrangerItems.LUNAR_CONSTELLATION_CARD.get()) return 1;
                                else return 0;
                            }
                        }
                    }
                    if ($entity.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof DinoFuryMorpherItem) {
                        if ($itemStack.getItem() == DinoFuryItems.DINO_KNIGHT_MORPHER.get()) {
                            if (DinoFuryMorpherItem.get_Form_Item(belt, 1).getFormName(false)=="_dino_knight") return 1;
                            else return 0;
                        }
                    }
                    if ($entity.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof MosaBlasterItem) {

                        if ($itemStack.getItem() == DinoFuryItems.MOSA_BLASTER.get()) {
                            if ($entity.getItemBySlot(EquipmentSlot.FEET).getItem()==DinoFuryItems.GOLD_MOSA_BLASTER.get()){
                                if (MosaBlasterItem.get_Form_Item(belt, 2).getFormName(false)!="") return 2;
                                else return 1;
                            }
                            else return 0;
                        }
                    }
                    else {
                        return $entity.getUseItem() != $itemStack ? 0.0F : 1.0F;
                    }
                    return $entity.getUseItem() != $itemStack ? 0.0F : 1.0F;
                }
                return $entity.getUseItem() != $itemStack ? 0.0F : 1.0F;
                //return p_174637_.getUseItem() != p_174635_ ? 0.0F : (float)(p_174635_.getUseDuration() - p_174637_.getUseItemRemainingTicks()) / 1.0F;
            });
        }
        for (int i = 0; i < CHANGE_CHANGER_TEXTURE.size(); i++) {
            ItemProperties.register(CHANGE_CHANGER_TEXTURE.get(i), ResourceLocation.parse("change"), ($itemStack, $level, $entity, $seed) -> {
                if ($entity == null) {
                    return 0.0F;
                } else {
                    if ($itemStack.getItem() == StarrangerItems.COSMO_SABER_GOLD.get()) {
                        if (RangerChangerItem.get_Form_Item($itemStack, 1) == StarrangerItems.LUNAR_CONSTELLATION_CARD.get()) return 1;
                        else return 0;
                    }
                }
                return $entity.getUseItem() != $itemStack ? 0.0F : 1.0F;
                //return p_174637_.getUseItem() != p_174635_ ? 0.0F : (float)(p_174635_.getUseDuration() - p_174637_.getUseItemRemainingTicks()) / 1.0F;
            });
        }
    }

    public static void registerChargedItems() {
        for (int i = 0; i < CHARGED_WEAPON.size(); i++) {
            ItemProperties.register(CHARGED_WEAPON.get(i), ResourceLocation.parse("change"), ($itemStack, $level, $entity, $seed) -> {
                if (BaseBlasterItem.get_mode($itemStack) == 30) return 1;
                return 0;
            });
        }
    }
}