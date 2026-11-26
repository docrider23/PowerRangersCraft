package com.docrider.powerrangerscraft.items.mmpr;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.items.ComicsItems;
import com.docrider.powerrangerscraft.items.MMPRItems;
import com.docrider.powerrangerscraft.items.OperationOverdriveItems;
import com.docrider.powerrangerscraft.items.others.RangerArmorItem;
import com.docrider.powerrangerscraft.items.others.RangerChangerItem;
import com.docrider.powerrangerscraft.items.others.RangerFormChangeItem;
import com.google.common.collect.Lists;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.List;

public class PowerMorpherItem extends RangerChangerItem {

    public PowerMorpherItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Item.Properties properties)
    {
        super(material, rider, baseFormItem, head, torso, legs, properties);
        Extra_Base_Form_Item = Lists.newArrayList((RangerFormChangeItem) MMPRItems.DRAGON_POWER_COIN_NO_SHIELD.get(), (RangerFormChangeItem) MMPRItems.DRAGON_POWER_COIN_NO_SHIELD.get());
        Num_Base_Form_Item = 2;
        Show_belt_form_info = false;
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        RangerFormChangeItem formItem1 = get_Form_Item(stack, 1);
        boolean isMaster = this == MMPRItems.MASTER_MORPHER.get();
        boolean isUnlimited = formItem1 == ComicsItems.UNLIMITED_COMMUNICATOR.get();

        Has_basic_belt_info = !(isUnlimited || isMaster);

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);


        if (isMaster) {
            tooltipComponents.add(Component.translatable("powerrangerscraft.name." + formItem1.getRangerName(Rider)));
        } else if (isUnlimited) {
            tooltipComponents.add(Component.translatable("powerrangerscraft.name.unlimited_yellow_ranger"));
        } else if (formItem1 != Base_Form_Item) {
            tooltipComponents.add(Component.translatable(formItem1.toString() + ".form"));
        }

        Item formItem2 = this.get_Form_Item(stack, 2);

        if (formItem2 == MMPRItems.DRAGON_POWER_COIN_SHIELD.get()
                ||formItem2 == MMPRItems.METALLIC_ARMOR.get()
                ||formItem2 == MMPRItems.METALLIC_ARMOR_BLACK.get()
                ||formItem2 == MMPRItems.METALLIC_ARMOR_BLUE.get()
                ||formItem2 == MMPRItems.METALLIC_ARMOR_YELLOW.get()
                ||formItem2 == MMPRItems.METALLIC_ARMOR_PINK.get()
                ||formItem2 == MMPRItems.METALLIC_ARMOR_WHITE.get()
                ||formItem2 == OperationOverdriveItems.DEFENDER_VEST.get()) {
            tooltipComponents.add(Component.translatable(formItem2.toString() + ".form"));
        }
    }

    @Override
    public String GET_TEXT(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String rangerName)
    {
        String belt = ((RangerChangerItem)itemstack.getItem()).BELT_TEXT;

        boolean fly = !rider.onGround();

        if (equipmentSlot == EquipmentSlot.FEET) {
            if (!rangerName.equals("mmpr_green") & rider.getMainHandItem().getItem() == MMPRItems.BLADE_BLASTER.get() ||
                rangerName.equals("mmpr_green") & rider.getMainHandItem().getItem() == MMPRItems.DRAGON_DAGGER.get()) {
                belt = get_Form_Item(itemstack,1).getBeltTex()+"_empty";
            }
            else if (((RangerChangerItem)itemstack.getItem()).BELT_TEXT==null) {
                belt = get_Form_Item(itemstack,1).getBeltTex();
            }
            return "belts/"+belt;
        }
        else if (equipmentSlot == EquipmentSlot.HEAD) {
            return get_Form_Item(itemstack,2).getFormName(fly)+get_Form_Item(itemstack,1).getFormName(fly);
        }
        else return get_Form_Item(itemstack,1).getRangerName(rangerName)+get_Form_Item(itemstack,1).getFormName(fly);
    }

    public ResourceLocation getModelResource(ItemStack itemstack, RangerArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
        int num = 1;
        if (slot == EquipmentSlot.HEAD)num=2;

        if (get_Form_Item(itemstack, num).hasWingsIfFlying() & !rider.onGround()){
            return ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "geo/"+get_Form_Item(itemstack, num).getFlyingModel(this.Rider));
        }else
            return ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "geo/"+get_Form_Item(itemstack, num).getModel(this.Rider));

    }

    @Override
    public boolean getPartsForSlot(ItemStack itemstack,EquipmentSlot currentSlot,String  part) {

        switch (currentSlot) {
            case HEAD, LEGS ->{
                return true;
            }
            case CHEST -> {
            }
            default -> {}
        }
        return false;
    }
}