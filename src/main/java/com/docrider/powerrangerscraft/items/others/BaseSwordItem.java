package com.docrider.powerrangerscraft.items.others;

import com.docrider.powerrangerscraft.items.MMPRItems;
import net.minecraft.world.item.*;

import java.util.List;

public class BaseSwordItem extends SwordItem {

	private Item RepairItem = MMPRItems.MMPR_LOGO.get();
	
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
}