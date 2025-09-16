package com.docrider.powerrangerscraft.items.others;

import com.docrider.powerrangerscraft.items.MMPRItems;
import net.minecraft.world.item.*;

import java.util.List;

public class BasePickaxeItem extends PickaxeItem {

	private Item RepairItem = MMPRItems.MMPR_LOGO.get();
	
	public BasePickaxeItem(Tier toolTier, int Atk, float Spd, Properties prop) {
		super(toolTier, prop.attributes(SwordItem.createAttributes(Tiers.DIAMOND, Atk, Spd)));
	}
	
	public BasePickaxeItem ChangeRepairItem(Item item) {
		RepairItem = item;
		return this;
	}

	public boolean isValidRepairItem(ItemStack p_40392_, ItemStack p_40393_) {
		return p_40393_.getItem()== RepairItem;
	}
	
	public BasePickaxeItem AddToTabList(List<Item> TabList) {
		TabList.add(this);
		return this;
	}
}