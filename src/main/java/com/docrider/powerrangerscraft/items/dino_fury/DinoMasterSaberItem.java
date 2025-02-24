package com.docrider.powerrangerscraft.items.dino_fury;

import com.docrider.powerrangerscraft.items.DinoFuryItems;
import com.docrider.powerrangerscraft.items.others.BaseSwordItem;
import com.docrider.powerrangerscraft.items.others.RangerChangerItem;
import com.docrider.powerrangerscraft.items.others.RangerFormChangeItem;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
public class DinoMasterSaberItem extends BaseSwordItem {
	
	public DinoMasterSaberItem(Tier toolTier, int Atk, float Spd, Properties prop) {
		super(toolTier, Atk, Spd, prop);
	}
	
	public InteractionResultHolder<ItemStack> use(Level p_41128_, Player p_41129_, InteractionHand p_41130_) {

		ItemStack itemstack = p_41129_.getItemInHand(p_41130_);

		ItemStack BELT = p_41129_.getItemBySlot(EquipmentSlot.FEET);

		if (BELT.getItem() instanceof RangerChangerItem belt) {
			
			if (this==DinoFuryItems.DINO_MASTER_SABER.get())
			{
				if (p_41129_.isShiftKeyDown())
				{
					if (RangerChangerItem.get_Form_Item(BELT, 2).getFormName(false)=="dino_master_mode") ((RangerFormChangeItem)belt.Base_Form_Item).use(p_41128_, p_41129_, p_41130_);
					else ((RangerFormChangeItem)DinoFuryItems.DINO_MASTER_KEY.get()).use(p_41128_, p_41129_, p_41130_);
						
				}
			}
		}
		return InteractionResultHolder.sidedSuccess(itemstack, p_41128_.isClientSide());
	}
}