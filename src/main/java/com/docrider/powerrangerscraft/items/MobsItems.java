package com.docrider.powerrangerscraft.items;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.items.others.BaseShieldItem;
import com.docrider.powerrangerscraft.items.others.BaseSwordItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MobsItems {

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PowerRangersCraftCore.MODID);

	public static final DeferredItem<SwordItem> CHROMITES_SWORD = ITEMS.register("chromites_sword",
			() -> new BaseSwordItem(Tiers.IRON, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.MISC).ChangeRepairItem(Items.IRON_INGOT));
/*
	public static final DeferredItem<SwordItem> YARTOTS_SABER = ITEMS.register("yartots_saber",
			() -> new BaseSwordItem(Tiers.IRON, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.MISC).ChangeRepairItem(Items.IRON_INGOT));

	public static final DeferredItem<SwordItem> ORGETTES_CLUB = ITEMS.register("orgettes_club",
			() -> new BaseSwordItem(Tiers.IRON, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.MISC).ChangeRepairItem(Items.IRON_INGOT));

	public static final DeferredItem<SwordItem> NANASHI_DAO = ITEMS.register("nanashi_dao",
			() -> new BaseSwordItem(Tiers.IRON, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.MISC).ChangeRepairItem(Items.IRON_INGOT));

	public static final DeferredItem<SwordItem> PORDERMAN_SWORD = ITEMS.register("porderman_sword",
			() -> new BaseSwordItem(Tiers.IRON, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.MISC).ChangeRepairItem(Items.IRON_INGOT));

	public static final DeferredItem<SwordItem> DRUNN_SPEAR = ITEMS.register("drunn_spear",
			() -> new BaseSwordItem(Tiers.IRON, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.MISC).ChangeRepairItem(Items.IRON_INGOT));
    public static final DeferredItem<Item> DRUNN_SHIELD = ITEMS.register("drunn_shield",
			() -> new BaseShieldItem(new Item.Properties()).AddToTabList(RangerTabs.MISC).ChangeRepairItem(Items.IRON_INGOT));
*/
	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}

}