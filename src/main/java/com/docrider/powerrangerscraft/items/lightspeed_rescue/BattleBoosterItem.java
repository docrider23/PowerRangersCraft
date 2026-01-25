package com.docrider.powerrangerscraft.items.lightspeed_rescue;

import com.docrider.powerrangerscraft.effect.EffectCore;
import com.docrider.powerrangerscraft.items.others.BaseItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BattleBoosterItem extends BaseItem {

    public BattleBoosterItem(Item.Properties prop) {
        super(prop);
    }

    public void inventoryTick(ItemStack p_41404_, Level p_41405_, Entity p_41406_, int p_41407_, boolean p_41408_) {

        if (p_41406_ instanceof Player player) {
            if (player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RescueMorpherItem belt && belt.isTransformed(player)) {
                ItemStack Belt = player.getItemBySlot(EquipmentSlot.FEET);

                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,40,4,true,false));
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST,40,4,true,false));
                player.addEffect(new MobEffectInstance(EffectCore.PUNCH,40,4,true,false));
            }
        }
    }
}