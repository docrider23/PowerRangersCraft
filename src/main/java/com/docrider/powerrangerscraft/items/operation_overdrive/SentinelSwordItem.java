package com.docrider.powerrangerscraft.items.operation_overdrive;

import com.docrider.powerrangerscraft.items.OperationOverdriveItems;
import com.docrider.powerrangerscraft.items.OtherItems;
import com.docrider.powerrangerscraft.items.others.BaseItem;
import com.docrider.powerrangerscraft.items.others.RangerChangerItem;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.List;

public class SentinelSwordItem extends RangerChangerItem {
    private Item craftingRemainingItem = null;

    public SentinelSwordItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Item.Properties properties)
    {
        super(material, rider, baseFormItem, head, torso, legs, properties);
    }

    public SentinelSwordItem KeepItem() {
        craftingRemainingItem=this;
        return this;
    }

    public ItemStack getCraftingRemainingItem(ItemStack stack)
    {
        if (stack.getItem() instanceof SentinelSwordItem) {
            if (!hasCraftingRemainingItem(stack))
            {
                return ItemStack.EMPTY;
            }
            return new ItemStack(craftingRemainingItem);
        } else  return new ItemStack(this.getCraftingRemainingItem());
    }


    public boolean hasCraftingRemainingItem(ItemStack stack)
    {
        return ((SentinelSwordItem)stack.getItem()).craftingRemainingItem!=null;
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
