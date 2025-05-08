package com.docrider.powerrangerscraft.items;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.items.others.*;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ComicsItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PowerRangersCraftCore.MODID);

    //Shattered Grid
    public static final DeferredItem<Item> RANGER_SLAYER_POWER_COIN = ITEMS.register("ranger_slayer_power_coin",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","solar_pink","blank")
                    .AddToTabList(RangerTabs.COMICS));

    //Solar Rangers
    public static final DeferredItem<Item> SOLAR_LOGO = ITEMS.register("solar_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.COMICS));

    public static final DeferredItem<Item> BLANK_SOLAR_CRYSTAL = ITEMS.register("blank_solar_crystal",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.COMICS));

    public static final DeferredItem<Item> PURPLE_SOLAR_CRYSTAL = ITEMS.register("purple_solar_crystal",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","solar_purple","blank")
                    .AddToTabList(RangerTabs.COMICS));
    public static final DeferredItem<Item> ORANGE_SOLAR_CRYSTAL = ITEMS.register("orange_solar_crystal",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","solar_orange","blank")
                    .AddToTabList(RangerTabs.COMICS));

    public static final DeferredItem<Item> SOLAR_HELMET = ITEMS.register("solar_head",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(BLANK_SOLAR_CRYSTAL.get()));
    public static final DeferredItem<Item> SOLAR_CHESTPLATE = ITEMS.register("solar_torso",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(BLANK_SOLAR_CRYSTAL.get()));
    public static final DeferredItem<Item> SOLAR_LEGGINGS = ITEMS.register("solar_legs",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(BLANK_SOLAR_CRYSTAL.get()));

    public static final DeferredItem<Item> PURPLE_SOLARIX = ITEMS.register("purple_solarix",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"solar_purple", PURPLE_SOLAR_CRYSTAL, SOLAR_HELMET, SOLAR_CHESTPLATE, SOLAR_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(BLANK_SOLAR_CRYSTAL.get()));
    public static final DeferredItem<Item> ORANGE_SOLARIX = ITEMS.register("orange_solarix",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"solar_orange", ORANGE_SOLAR_CRYSTAL, SOLAR_HELMET, SOLAR_CHESTPLATE, SOLAR_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(BLANK_SOLAR_CRYSTAL.get()));
    public static final DeferredItem<Item> RED_SOLARIX = ITEMS.register("red_solarix",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"solar_red", InSpaceItems.RED_SPACE_DISK, SOLAR_HELMET, SOLAR_CHESTPLATE, SOLAR_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(BLANK_SOLAR_CRYSTAL.get()));
    public static final DeferredItem<Item> BLACK_SOLARIX = ITEMS.register("black_solarix",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"solar_black", LostGalaxyItems.MAGNA_DEFENDER_CORE_SOLAR, SOLAR_HELMET, SOLAR_CHESTPLATE, SOLAR_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(BLANK_SOLAR_CRYSTAL.get()));
    public static final DeferredItem<Item> BLUE_SOLARIX = ITEMS.register("blue_solarix",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"solar_blue", DinoChargeItems.SPINOSAURUS_DINO_CHARGER_SOLAR, SOLAR_HELMET, SOLAR_CHESTPLATE, SOLAR_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(BLANK_SOLAR_CRYSTAL.get()));
    public static final DeferredItem<Item> YELLOW_SOLARIX = ITEMS.register("yellow_solarix",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"solar_yellow", ZeoItems.YELLOW_ZEO_SUB_CRYSTAL, SOLAR_HELMET, SOLAR_CHESTPLATE, SOLAR_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(BLANK_SOLAR_CRYSTAL.get()));
    public static final DeferredItem<Item> GREEN_SOLARIX = ITEMS.register("green_solarix",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"solar_green", NinjaStormItems.GREEN_SAMURAI_NINJA_DISK, SOLAR_HELMET, SOLAR_CHESTPLATE, SOLAR_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(BLANK_SOLAR_CRYSTAL.get()));
    public static final DeferredItem<Item> PINK_SOLARIX = ITEMS.register("pink_solarix",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"solar_pink", RANGER_SLAYER_POWER_COIN, SOLAR_HELMET, SOLAR_CHESTPLATE, SOLAR_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(BLANK_SOLAR_CRYSTAL.get()));

    public static final DeferredItem<BaseSwordItem> SOLAR_CHAKRAM = ITEMS.register("solar_chakram",
            () -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(BLANK_SOLAR_CRYSTAL.get()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
