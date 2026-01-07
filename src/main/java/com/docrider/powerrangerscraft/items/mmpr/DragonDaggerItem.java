package com.docrider.powerrangerscraft.items.mmpr;

import com.docrider.powerrangerscraft.items.MMPRItems;
import com.docrider.powerrangerscraft.items.others.BaseSwordItem;
import com.docrider.powerrangerscraft.sounds.ModSounds;
import com.google.common.collect.ImmutableMultimap;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import java.util.List;

public class DragonDaggerItem extends BowItem {
    private Item RepairItem = MMPRItems.MMPR_LOGO.get();

    private Item craftingRemainingItem = null;

    public DragonDaggerItem(Tier toolTier, int Atk, float Spd, Properties prop) {
        super(prop.durability(toolTier.getUses()).attributes(SwordItem.createAttributes(Tiers.DIAMOND, Atk, Spd)));
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
    }

    public DragonDaggerItem ChangeRepairItem(Item item) {
        RepairItem = item;
        return this;
    }

    public boolean isValidRepairItem(ItemStack p_40392_, ItemStack p_40393_) {
        return p_40393_.getItem()== RepairItem;
    }

    public DragonDaggerItem AddToTabList(List<Item> TabList) {
        TabList.add(this);
        return this;
    }

    public DragonDaggerItem KeepDifItem(Item Dif) {
        craftingRemainingItem=Dif;
        return this;
    }

    public DragonDaggerItem KeepItem() {
        craftingRemainingItem=this;
        return this;
    }

    public ItemStack getCraftingRemainingItem(ItemStack stack)
    {
        if (stack.getItem() instanceof DragonDaggerItem) {
            if (!hasCraftingRemainingItem(stack))
            {
                return ItemStack.EMPTY;
            }
            return new ItemStack(craftingRemainingItem);
        } else  return new ItemStack(this.getCraftingRemainingItem());
    }


    public boolean hasCraftingRemainingItem(ItemStack stack)
    {
        return ((DragonDaggerItem)stack.getItem()).craftingRemainingItem!=null;
    }

    public void releaseUsing(ItemStack stack, Level level, LivingEntity entityLiving, int timeLeft) {
        if (entityLiving instanceof Player player && level instanceof ServerLevel serverlevel) {
            level.playSound((Player)null, player.getX(), player.getY(), player.getZ(), ModSounds.DRAGON_DAGGER_GOAT_HORN.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
        }
    }
}