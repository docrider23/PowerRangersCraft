package com.docrider.powerrangerscraft.items.starranger;

import com.docrider.powerrangerscraft.items.BeastMorphersItems;
import com.docrider.powerrangerscraft.items.StarrangerItems;
import com.docrider.powerrangerscraft.items.others.RangerChangerItem;
import com.docrider.powerrangerscraft.items.others.RangerFormChangeItem;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ConstellationCardItem extends RangerFormChangeItem {

    public ConstellationCardItem(Properties properties, int belt, String formName, String ridername, String beltTex, MobEffectInstance... effects) {
        super( properties, belt, formName, ridername, beltTex, effects);
    }

    public InteractionResultHolder<ItemStack> use(Level p_41128_, Player p_41129_, InteractionHand p_41130_) {
        ItemStack itemstack = p_41129_.getItemInHand(p_41130_);

        ItemStack BELT = p_41129_.getItemBySlot(EquipmentSlot.FEET);

        if (p_41129_.getItemBySlot(EquipmentSlot.OFFHAND).getItem()== StarrangerItems.COSMO_SABER.get())
        {
            if (BELT.isEmpty())
            {
                if (this == StarrangerItems.SOLAR_CONSTELLATION_CARD.get())
                {
                    p_41129_.setItemSlot(EquipmentSlot.FEET, new ItemStack(StarrangerItems.COSMO_SABER_GOLD.get()));
                }
                if (this == StarrangerItems.LUNAR_CONSTELLATION_CARD.get())
                {
                    ItemStack itemstack1 = new ItemStack(StarrangerItems.COSMO_SABER_GOLD.get(), 1);
                    RangerChangerItem.set_Form_Item(itemstack1, StarrangerItems.LUNAR_CONSTELLATION_CARD.get(), 1);
                    p_41129_.setItemSlot(EquipmentSlot.FEET, itemstack1);
                }

            }
        }
        return InteractionResultHolder.sidedSuccess(itemstack, p_41128_.isClientSide());
    }
}
