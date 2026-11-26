package com.docrider.powerrangerscraft.items.in_space;

import com.docrider.powerrangerscraft.items.InSpaceItems;
import com.docrider.powerrangerscraft.items.others.BaseItem;
import com.docrider.powerrangerscraft.items.others.RangerChangerItem;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BattlizerGauntletItem extends BaseItem {

    public BattlizerGauntletItem(Item.Properties prop) {
        super(prop);
    }

    public void inventoryTick(ItemStack p_41404_, Level p_41405_, Entity p_41406_, int p_41407_, boolean p_41408_) {

        if (p_41406_ instanceof Player player) {
            if (player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof AstroMorpherItem belt && belt.isTransformed(player)) {
                ItemStack Belt = player.getItemBySlot(EquipmentSlot.FEET);

                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST,40,4,true,false));
            }
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        if (!level.isClientSide) {
            ItemStack itemstack = player.getItemInHand(usedHand);
            ItemStack belt = player.getItemBySlot(EquipmentSlot.FEET);

            if (belt.getItem() == InSpaceItems.RED_ASTRO_MORPHER.get() && player.isCrouching()) {
                RangerChangerItem.setFormItem(belt,InSpaceItems.BATTLIZER_DATA_CARD.get(),2);
            }
        }
        return InteractionResultHolder.pass(player.getItemInHand(usedHand));
    }
}