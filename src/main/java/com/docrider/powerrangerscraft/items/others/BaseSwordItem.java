package com.docrider.powerrangerscraft.items.others;

import com.docrider.powerrangerscraft.items.MMPRItems;
import net.minecraft.world.item.*;

import java.util.List;

public class BaseSwordItem extends SwordItem {

	private Item RepairItem = MMPRItems.MMPR_LOGO.get();
	private Item ChangerItem = MMPRItems.MMPR_LOGO.get();

	private Boolean Changer = false;

	private Item craftingRemainingItem = null;
	
	public BaseSwordItem(Tier toolTier, int Atk, float Spd, Properties prop) {
		super(toolTier, prop.attributes(SwordItem.createAttributes(Tiers.DIAMOND, Atk, Spd)));

	}

	public BaseSwordItem ChangeRepairItem(Item item) {
		RepairItem = item;
		return this;
	}
	
	public boolean isValidRepairItem(ItemStack p_40392_, ItemStack p_40393_) {
		return p_40393_.getItem()== RepairItem;
	}

	public BaseSwordItem AddToTabList(List<Item> TabList) {
		TabList.add(this);
		return this;
	}

	public BaseSwordItem KeepDifItem(Item Dif) {
		craftingRemainingItem=Dif;
		return this;
	}

	public BaseSwordItem KeepItem() {
		craftingRemainingItem=this;
		return this;
	}

	public ItemStack getCraftingRemainingItem(ItemStack stack)
	{
		if (stack.getItem() instanceof BaseSwordItem) {
			if (!hasCraftingRemainingItem(stack))
			{
				return ItemStack.EMPTY;
			}
			return new ItemStack(craftingRemainingItem);
		} else  return new ItemStack(this.getCraftingRemainingItem());
	}


	public boolean hasCraftingRemainingItem(ItemStack stack)
	{
		return ((BaseSwordItem)stack.getItem()).craftingRemainingItem!=null;
	}

	public BaseSwordItem isChanger(Item item) {
		ChangerItem = item;
		Changer = true;
		return this;
	}
}