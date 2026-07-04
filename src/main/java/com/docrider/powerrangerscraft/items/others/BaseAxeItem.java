package com.docrider.powerrangerscraft.items.others;

import com.docrider.powerrangerscraft.items.OtherItems;
import net.minecraft.world.item.*;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BaseAxeItem extends AxeItem {

	private Item RepairItem = OtherItems.GRID_INFUSED_GOLD_INGOT.get();
	private Item craftingRemainingItem = null;

	public BaseAxeItem(Tier toolTier, int Atk, float Spd, Properties prop) {
		super(toolTier, prop.attributes(SwordItem.createAttributes(Tiers.DIAMOND, Atk, Spd)));
	}
	
	public BaseAxeItem ChangeRepairItem(Item item) {
		RepairItem = item;
		return this;
	}

	public boolean isValidRepairItem(@NotNull ItemStack itemStackOne, ItemStack repairItem) {
		return repairItem.getItem() == RepairItem;
	}

	public BaseAxeItem addToList(List<Item> TabList, int num) {
		for (int i = 0; i < num; i++) {
			TabList.add(this);
		}
		return this;
	}

	public BaseAxeItem keepDiffItem(Item item) {
		craftingRemainingItem = item;
		return this;
	}

	public BaseAxeItem keepItem() {
		craftingRemainingItem = this;
		return this;
	}

	public @NotNull ItemStack getCraftingRemainingItem(ItemStack stack) {
		if (stack.getItem() instanceof BaseAxeItem) {
			if (!hasCraftingRemainingItem(stack)) {
				return ItemStack.EMPTY;
			}
			return new ItemStack(craftingRemainingItem);
		}
		return new ItemStack(this.getCraftingRemainingItem());
	}

	public boolean hasCraftingRemainingItem(ItemStack stack) {
		return ((BaseAxeItem) stack.getItem()).craftingRemainingItem != null;
	}

	public BaseAxeItem AddToTabList(List<Item> TabList) {
		TabList.add(this);
		return this;
	}
}