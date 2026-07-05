package com.docrider.powerrangerscraft.items.mmpr;

import com.docrider.powerrangerscraft.items.MMPRItems;
import com.docrider.powerrangerscraft.items.others.BaseItem;
import com.docrider.powerrangerscraft.items.others.RangerChangerItem;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class PowerCoinItem extends BaseItem {

    public PowerCoinItem(Item.Properties prop) {
        super(prop);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        if (!level.isClientSide) {
            ItemStack itemstack = player.getItemInHand(usedHand);
            ItemStack belt = player.getItemBySlot(EquipmentSlot.FEET);

            if (belt.getItem() == MMPRItems.MASTER_MORPHER.get()) {
                RangerChangerItem.set_Form_Item(belt,MMPRItems.DRAGON_POWER_COIN_MMPR_GREEN_BASE.get(),2);
            }
            else new ItemStack(MMPRItems.DRAGON_POWER_COIN_SHIELD.get()).use(level, player, usedHand);
        }
        return InteractionResultHolder.pass(player.getItemInHand(usedHand));
    }
}
