package com.docrider.powerrangerscraft.items.starranger;

import com.docrider.powerrangerscraft.items.DinoFuryItems;
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

public class MastarChangeItem extends RangerFormChangeItem {

	public MastarChangeItem(Properties properties, int belt, String formName, String ridername, String beltTex, MobEffectInstance... effects) {
		super( properties, belt, formName, ridername, beltTex, effects);
	}
	
	public InteractionResultHolder<ItemStack> use(Level p_41128_, Player p_41129_, InteractionHand p_41130_) {

		ItemStack itemstack = p_41129_.getItemInHand(p_41130_);

		ItemStack BELT = p_41129_.getItemBySlot(EquipmentSlot.FEET);

		if (BELT.getItem() instanceof RangerChangerItem belt) {

			if (getSHIFT_ITEM() instanceof RangerFormChangeItem & p_41129_.isShiftKeyDown()) {
				((RangerFormChangeItem)getSHIFT_ITEM()).use(p_41128_, p_41129_, p_41130_);
			}
			else if (CanChange(p_41129_,belt,BELT)) {
				if (getAlsoChange2ndSlot() !=null)RangerChangerItem.set_Form_Item(p_41129_.getItemBySlot(EquipmentSlot.FEET),getAlsoChange2ndSlot(), 2);
				if (getRESET_FORM())RangerChangerItem.reset_Form_Item(p_41129_.getItemBySlot(EquipmentSlot.FEET));
				else RangerChangerItem.set_Form_Item(BELT,this, getSlot());
			
			}else if(!getAlternative().isEmpty()){

				for (int i = 0; i < getAlternative().size(); i++)
				{
					RangerFormChangeItem alternativeItem_form_change = getAlternative().get(i);
					alternativeItem_form_change.use(p_41128_, p_41129_, p_41130_);
				}
			}
		}
		if (p_41129_.getItemBySlot(EquipmentSlot.OFFHAND).getItem()== StarrangerItems.OPHIUCHUS_STAFF.get())
		{
			if (BELT.isEmpty())
			{
				if (this == StarrangerItems.OPHIUCHUS_CONSTELLATION_CARD.get())
				{
					p_41129_.setItemSlot(EquipmentSlot.FEET, new ItemStack(StarrangerItems.OPHIUCHUS_STAFF_MASTAR.get()));
				}
			}
		}
		if (p_41129_.getItemBySlot(EquipmentSlot.OFFHAND).getItem()==StarrangerItems.COSMIC_STAFF.get())
		{
			if (BELT.isEmpty())
			{
				if (this == StarrangerItems.COSMIC_HEART.get())
				{
					p_41129_.setItemSlot(EquipmentSlot.FEET, new ItemStack(StarrangerItems.COSMIC_STAFF_MASTAR.get()));
				}
			}
		}
		return InteractionResultHolder.sidedSuccess(itemstack, p_41128_.isClientSide());
	}
}