package com.docrider.powerrangerscraft.items.starranger;

import com.docrider.powerrangerscraft.items.StarrangerItems;
import com.docrider.powerrangerscraft.items.others.BaseBlasterItem;
import com.docrider.powerrangerscraft.items.others.RangerChangerItem;
import com.docrider.powerrangerscraft.items.others.RangerFormChangeItem;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.event.EventHooks;

public class CosmoSaberItem extends BaseBlasterItem {

	public CosmoSaberItem(Tier toolTier, int Atk, float Spd, Item.Properties prop) {
		super(toolTier, Atk, Spd, prop);
	}
	
	public InteractionResultHolder<ItemStack> use(Level p_41128_, Player p_41129_, InteractionHand p_41130_) {

		ItemStack itemstack = p_41129_.getItemInHand(p_41130_);

		ItemStack BELT = p_41129_.getItemBySlot(EquipmentSlot.FEET);

		if (BELT.getItem() instanceof RangerChangerItem belt) {

			if (belt== StarrangerItems.COSMO_SABER_GOLD.get())
			{
				if (this==StarrangerItems.COSMO_SABER.get())
				{
					if (p_41129_.isShiftKeyDown())
					{
						if (RangerChangerItem.get_Form_Item(BELT, 1).getBeltTex()=="starranger_equinox_belt") ((RangerFormChangeItem)belt.Base_Form_Item).use(p_41128_, p_41129_, p_41130_);
						else ((RangerFormChangeItem)StarrangerItems.LUNAR_CONSTELLATION_CARD.get()).use(p_41128_, p_41129_, p_41130_);
						
					}
				}
				
			}
		}

		boolean flag = !p_41129_.getProjectile(itemstack).isEmpty();
		InteractionResultHolder<ItemStack> ret = EventHooks.onArrowNock(itemstack, p_41128_, p_41129_, p_41130_, flag);

		if (ret != null) return ret;
		else {
			p_41129_.startUsingItem(p_41130_);
			return InteractionResultHolder.consume(itemstack);
		}
	}
}