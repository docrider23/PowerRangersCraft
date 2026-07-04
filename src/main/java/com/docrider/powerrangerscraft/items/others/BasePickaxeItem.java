package com.docrider.powerrangerscraft.items.others;

import com.docrider.powerrangerscraft.items.MMPRItems;
import com.docrider.powerrangerscraft.items.OtherItems;
import net.minecraft.world.item.*;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BasePickaxeItem extends PickaxeItem {

	private Item RepairItem = OtherItems.GRID_INFUSED_GOLD_INGOT.get();
	
	public BasePickaxeItem(Tier toolTier, int Atk, float Spd, Properties prop) {
		super(toolTier, prop.attributes(SwordItem.createAttributes(Tiers.DIAMOND, Atk, Spd)));
	}
	
	public BasePickaxeItem ChangeRepairItem(Item item) {
		RepairItem = item;
		return this;
	}

	public boolean isValidRepairItem(@NotNull ItemStack itemStackOne, ItemStack repairItem) {
		return repairItem.getItem() == RepairItem;
	}

	public BasePickaxeItem addToList(List<Item> TabList, int num) {
		for (int i = 0; i < num; i++) {
			TabList.add(this);
		}
		return this;
	}
	
	public BasePickaxeItem AddToTabList(List<Item> TabList) {
		TabList.add(this);
		return this;
	}
}