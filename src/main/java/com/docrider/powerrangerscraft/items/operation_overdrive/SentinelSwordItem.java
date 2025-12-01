package com.docrider.powerrangerscraft.items.operation_overdrive;

import com.docrider.powerrangerscraft.items.others.BaseItem;
import com.docrider.powerrangerscraft.items.others.RangerChangerItem;
import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredItem;

public class SentinelSwordItem extends RangerChangerItem {
    private Item craftingRemainingItem = null;

    public SentinelSwordItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Item.Properties properties)
    {
        super(material, rider, baseFormItem, head, torso, legs, properties);
        Has_basic_belt_info=false;
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
}
