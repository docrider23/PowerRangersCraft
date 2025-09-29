package com.docrider.powerrangerscraft.items.wild_force;

import com.docrider.powerrangerscraft.items.WildForceItems;
import com.docrider.powerrangerscraft.items.others.BaseSwordItem;
import com.docrider.powerrangerscraft.items.others.MechaGattaiItem;
import com.docrider.powerrangerscraft.items.others.RangerFormChangeItem;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public class FluteKnifeItem extends BaseSwordItem {

	public FluteKnifeItem(Tier toolTier, int Atk, float Spd, Properties prop) {
		super(toolTier, Atk, Spd, prop);
	}
	
	public InteractionResultHolder<ItemStack> use(Level p_41128_, Player p_41129_, InteractionHand p_41130_) {

		ItemStack itemstack = p_41129_.getItemInHand(p_41130_);

		ItemStack BELT = p_41129_.getItemBySlot(EquipmentSlot.HEAD);

		/*if (BELT.getItem() instanceof MechaGattaiItem belt) {
			
			if (this==WildForceItems.FLUTE_KNIFE.get())
			{
				if (belt==WildForceItems.PREDAZORD_HELMET.get())
				{
					if (p_41129_.isShiftKeyDown())
					{
						if (MechaGattaiItem.get_Form_Item(BELT, 1).getFormName(false)=="_evil") ((RangerFormChangeItem)belt.Base_Form_Item).use(p_41128_, p_41129_, p_41130_);
						else ((RangerFormChangeItem)WildForceItems.ALLIGATOR_ANIMAL_CRYSTAL_EVIL.get()).use(p_41128_, p_41129_, p_41130_);
					}
				}
				if (belt==WildForceItems.PREDAZORD_BLUE_MOON_HELMET.get())
				{
					if (p_41129_.isShiftKeyDown())
					{
						if (MechaGattaiItem.get_Form_Item(BELT, 1).getFormName(false)=="_evil") ((RangerFormChangeItem)belt.Base_Form_Item).use(p_41128_, p_41129_, p_41130_);
						else ((RangerFormChangeItem)WildForceItems.ALLIGATOR_ANIMAL_CRYSTAL_BLUE_MOON_EVIL.get()).use(p_41128_, p_41129_, p_41130_);
					}
				}
			}
		}*/
		return InteractionResultHolder.sidedSuccess(itemstack, p_41128_.isClientSide());
	}
}