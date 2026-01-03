package com.docrider.powerrangerscraft.items.ninja_steel;

import com.docrider.powerrangerscraft.items.NinjaSteelItems;
import com.docrider.powerrangerscraft.items.others.RangerFormChangeItem;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class NinjaPowerStarItem extends RangerFormChangeItem {

    public NinjaPowerStarItem(Properties properties, int belt, String formName, String ridername, String beltTex, MobEffectInstance... effects) {
        super( properties, belt, formName, ridername, beltTex, effects);
    }

    public InteractionResultHolder<ItemStack> use(Level p_41128_, Player p_41129_, InteractionHand p_41130_) {
        ItemStack itemstack = p_41129_.getItemInHand(p_41130_);

        ItemStack BELT = p_41129_.getItemBySlot(EquipmentSlot.FEET);

        if (p_41129_.getItemBySlot(EquipmentSlot.OFFHAND).getItem()== NinjaSteelItems.NINJA_BATTLE_MORPHER.get())
        {
            if (BELT.isEmpty())
            {
                if (this == NinjaSteelItems.RED_NINJA_POWER_STAR.get())
                {
                    p_41129_.setItemSlot(EquipmentSlot.FEET, new ItemStack(NinjaSteelItems.RED_NINJA_BATTLE_MORPHER.get()));
                }
                if (this == NinjaSteelItems.RED_NINJA_POWER_STAR_SILVER.get())
                {
                    p_41129_.setItemSlot(EquipmentSlot.FEET, new ItemStack(NinjaSteelItems.RED_SILVER_NINJA_BATTLE_MORPHER.get()));
                }

            }
        }
        return InteractionResultHolder.sidedSuccess(itemstack, p_41128_.isClientSide());
    }
}
