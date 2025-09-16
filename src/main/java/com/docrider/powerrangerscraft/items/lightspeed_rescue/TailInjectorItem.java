package com.docrider.powerrangerscraft.items.lightspeed_rescue;

import com.docrider.powerrangerscraft.items.others.BaseBlasterItem;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.event.EventHooks;

public class TailInjectorItem extends BaseBlasterItem {

	public TailInjectorItem(Tier toolTier, int Atk, float Spd, Item.Properties prop) {
		super(toolTier, Atk, Spd, prop);
	}

	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		ItemStack BELT = player.getItemBySlot(EquipmentSlot.FEET);

		if (player.isShiftKeyDown())
		{
			player.addEffect(new MobEffectInstance(MobEffects.REGENERATION,40,2));
		}

		boolean flag = !player.getProjectile(itemstack).isEmpty();
		InteractionResultHolder<ItemStack> ret = EventHooks.onArrowNock(itemstack, level, player, hand, flag);

		if (ret != null) return ret;
		else {
			player.startUsingItem(hand);
			return InteractionResultHolder.consume(itemstack);
		}
	}
}