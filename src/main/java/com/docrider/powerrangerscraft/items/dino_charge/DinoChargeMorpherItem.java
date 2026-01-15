package com.docrider.powerrangerscraft.items.dino_charge;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.items.DinoChargeItems;
import com.docrider.powerrangerscraft.items.OtherItems;
import com.docrider.powerrangerscraft.items.others.RangerArmorItem;
import com.docrider.powerrangerscraft.items.others.RangerChangerItem;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.List;

public class DinoChargeMorpherItem extends RangerChangerItem {
    public DinoChargeMorpherItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Properties properties)
    {
        super(material, rider, baseFormItem, head, torso, legs, properties);
        Has_basic_belt_info=false;
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {

        Item formItem = this.get_Form_Item(stack, 1);
        Item formItem2 = this.get_Form_Item(stack, 2);

        if (formItem2== OtherItems.BLANK_FORM.get()) tooltipComponents.add(Component.literal("Ranger: " + Component.translatable(formItem.toString() + ".form").getString()));
        else {
            tooltipComponents.add(Component.literal("Ranger: " + Component.translatable(formItem.toString() + ".form").getString()));
            tooltipComponents.add(Component.literal(Component.translatable(formItem2.toString() + ".form").getString()));
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

    @Override
    public String GET_TEXT(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String rangerName)
    {
        String belt = ((RangerChangerItem)itemstack.getItem()).BELT_TEXT;

        boolean fly = rider instanceof Player player && player.getAbilities().flying;

        if (equipmentSlot == EquipmentSlot.FEET) {
            if (((RangerChangerItem)itemstack.getItem()).BELT_TEXT==null) {
                belt = get_Form_Item(itemstack,1).getBeltTex();
            }
            return "belts/"+belt;
        }
        else if (equipmentSlot == EquipmentSlot.HEAD) {
            if (rider.getMainHandItem().getItem() == DinoChargeItems.T_REX_SMASHER.get()) {
                return "dino_steel_armor";
            }
            else if (get_Form_Item(itemstack, 2).getFormName(fly) == "") return "blank";
            {
                return get_Form_Item(itemstack, 2).getFormName(fly);
            }
        }
        else return get_Form_Item(itemstack,1).getRangerName(rangerName)+get_Form_Item(itemstack,1).getFormName(fly);
    }

    public ResourceLocation getModelResource(ItemStack itemstack, RangerArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
        int num = 1;
        if (slot == EquipmentSlot.HEAD)num=2;

        if (get_Form_Item(itemstack, num).HasWingsIfFlying() & !rider.onGround()){
            return ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "geo/"+get_Form_Item(itemstack, num).get_FlyingModel(this.Rider));
        }else
            return ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "geo/"+get_Form_Item(itemstack, num).get_Model(this.Rider));

    }

    public  boolean getPartsForSlot(EquipmentSlot currentSlot, String  part) {

        switch (currentSlot) {
            case HEAD ->{
                if (part =="head") return true;
                if (part =="body") return true;
                if (part =="rightArm") return true;
                if (part =="leftArm") return true;
                if (part =="rightLeg") return true;
                if (part =="leftLeg") return true;
            }
            case CHEST -> {
                if (part =="head") return true;
                if (part =="body") return true;
                if (part =="rightArm") return true;
                if (part =="leftArm") return true;
            }
            case LEGS -> {
                if (part =="rightLeg") return true;
                if (part =="leftLeg") return true;
            }
            default -> {}
        }
        return false;
    }
}
