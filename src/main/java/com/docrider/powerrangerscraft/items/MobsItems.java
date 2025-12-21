package com.docrider.powerrangerscraft.items;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.items.others.BaseBlasterItem;
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

	public static final DeferredItem<SwordItem> COG_SPEAR = ITEMS.register("cog_spear",
			() -> new BaseSwordItem(Tiers.IRON, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.MISC).ChangeRepairItem(Items.IRON_INGOT));

	public static final DeferredItem<SwordItem> CHROMITES_SWORD = ITEMS.register("chromites_sword",
			() -> new BaseSwordItem(Tiers.IRON, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.MISC).ChangeRepairItem(Items.IRON_INGOT));

	public static final DeferredItem<SwordItem> SWABBIES_CUTLASS = ITEMS.register("swabbies_cutlass",
			() -> new BaseSwordItem(Tiers.IRON, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.MISC).ChangeRepairItem(Items.IRON_INGOT));

	public static final DeferredItem<SwordItem> STINGWINGERS_STINGER = ITEMS.register("stingwingers_stinger",
			() -> new BaseSwordItem(Tiers.IRON, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.MISC).ChangeRepairItem(Items.IRON_INGOT));

	public static final DeferredItem<SwordItem> BATLINGS_SWORD = ITEMS.register("batlings_sword",
			() -> new BaseSwordItem(Tiers.IRON, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.MISC).ChangeRepairItem(Items.IRON_INGOT));

	public static final DeferredItem<SwordItem> PUTRIDS_CLUB = ITEMS.register("putrids_club",
			() -> new BaseSwordItem(Tiers.IRON, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.MISC).ChangeRepairItem(Items.IRON_INGOT));

	public static final DeferredItem<SwordItem> CHILLERS_SICKLE = ITEMS.register("chillers_sickle",
			() -> new BaseSwordItem(Tiers.IRON, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.MISC).ChangeRepairItem(Items.IRON_INGOT));

	public static final DeferredItem<SwordItem> LAVA_LIZARD_SWORD = ITEMS.register("lava_lizards_sword",
			() -> new BaseSwordItem(Tiers.IRON, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.MISC).ChangeRepairItem(Items.IRON_INGOT));

	public static final DeferredItem<SwordItem> MOLTOR_SWORD = ITEMS.register("moltor_sword",
			() -> new BaseSwordItem(Tiers.IRON, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.MISC).ChangeRepairItem(Items.IRON_INGOT));

	public static final DeferredItem<BaseBlasterItem> FLURIOUS_STAFF = ITEMS.register("flurious_staff",
			() -> new BaseBlasterItem(Tiers.IRON, 0, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.MISC).ChangeRepairItem(Items.IRON_INGOT));

	public static final DeferredItem<SwordItem> KAMDOR_KATANA = ITEMS.register("kamdor_katana",
			() -> new BaseSwordItem(Tiers.IRON, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.MISC).ChangeRepairItem(Items.IRON_INGOT));

	public static final DeferredItem<BaseBlasterItem> Z_STAFF_THRAX = ITEMS.register("z_staff_thrax",
			() -> new BaseBlasterItem(Tiers.IRON, 0, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.MISC).setProjectile(BaseBlasterItem.BlasterProjectile.SMALL_FIREBALL).ChangeRepairItem(Items.IRON_INGOT));

	public static final DeferredItem<SwordItem> MOOGERS_DAO = ITEMS.register("moogers_dao",
			() -> new BaseSwordItem(Tiers.IRON, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.MISC).ChangeRepairItem(Items.IRON_INGOT));

	public static final DeferredItem<SwordItem> HENGEMEN_SPEAR = ITEMS.register("hengemen_spear",
			() -> new BaseSwordItem(Tiers.IRON, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.MISC).ChangeRepairItem(Items.IRON_INGOT));

    public static final DeferredItem<Item> HENGEMEN_SHIELD = ITEMS.register("hengemen_shield",
			() -> new BaseShieldItem(new Item.Properties()).AddToTabList(RangerTabs.MISC).ChangeRepairItem(Items.IRON_INGOT));

	public static final DeferredItem<BaseBlasterItem> ZENTINELS_KHOPESH_RIFLE = ITEMS.register("zentinels_khopesh_rifle",
			() -> new BaseBlasterItem(Tiers.IRON, 0, -2.4F, new Item.Properties()).IsSwordGun().AddToTabList(RangerTabs.MISC).ChangeRepairItem(Items.IRON_INGOT));

	public static final DeferredItem<SwordItem> NO_ENTRY_SIGN = ITEMS.register("no_entry_sign",
			() -> new BaseSwordItem(Tiers.IRON, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.MISC).ChangeRepairItem(Items.IRON_INGOT));

	public static final DeferredItem<BaseBlasterItem> RITAS_STAFF = ITEMS.register("ritas_staff",
			() -> new BaseBlasterItem(Tiers.IRON, 0, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.MISC).setProjectile(BaseBlasterItem.BlasterProjectile.SMALL_FIREBALL).ChangeRepairItem(Items.GOLD_INGOT));

	public static final DeferredItem<SwordItem> ELTARIAN_STUNSTICK = ITEMS.register("eltarian_stunstick",
			() -> new BaseSwordItem(Tiers.IRON, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.MISC).ChangeRepairItem(Items.IRON_INGOT));

	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}

}