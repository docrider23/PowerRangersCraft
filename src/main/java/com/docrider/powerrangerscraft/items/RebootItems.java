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

public class RebootItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PowerRangersCraftCore.MODID);

    public static final DeferredItem<Item> REBOOT_LOGO = ITEMS.register("reboot_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.REBOOT));

    public static final DeferredItem<Item> REBOOT_RED_POWER_COIN = ITEMS.register("reboot_red_power_coin",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","reboot_red","reboot_red_belt")
                    .AddToTabList(RangerTabs.REBOOT));
    public static final DeferredItem<Item> REBOOT_BLACK_POWER_COIN = ITEMS.register("reboot_black_power_coin",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","reboot_black","reboot_black_belt")
                    .AddToTabList(RangerTabs.REBOOT));
    public static final DeferredItem<Item> REBOOT_BLUE_POWER_COIN = ITEMS.register("reboot_blue_power_coin",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","reboot_blue","reboot_blue_belt")
                    .AddToTabList(RangerTabs.REBOOT));
    public static final DeferredItem<Item> REBOOT_YELLOW_POWER_COIN = ITEMS.register("reboot_yellow_power_coin",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","reboot_yellow","reboot_yellow_belt")
                    .AddToTabList(RangerTabs.REBOOT));
    public static final DeferredItem<Item> REBOOT_PINK_POWER_COIN = ITEMS.register("reboot_pink_power_coin",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","reboot_pink","reboot_pink_belt")
                    .AddToTabList(RangerTabs.REBOOT));
    public static final DeferredItem<Item> REBOOT_GREEN_POWER_COIN = ITEMS.register("reboot_green_power_coin",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","reboot_green","reboot_green_belt")
                    .AddToTabList(RangerTabs.REBOOT));

    public static final DeferredItem<Item> REBOOT_HELMET = ITEMS.register("reboot_head",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RangerTabs.REBOOT).ChangeRepairItem(REBOOT_LOGO.get()));
    public static final DeferredItem<Item> REBOOT_CHESTPLATE = ITEMS.register("reboot_torso",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RangerTabs.REBOOT).ChangeRepairItem(REBOOT_LOGO.get()));
    public static final DeferredItem<Item> REBOOT_LEGGINGS = ITEMS.register("reboot_legs",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RangerTabs.REBOOT).ChangeRepairItem(REBOOT_LOGO.get()));

    public static final DeferredItem<Item> REBOOT_RED_POWER_MORPHER = ITEMS.register("reboot_red_power_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"reboot_red", REBOOT_RED_POWER_COIN, REBOOT_HELMET, REBOOT_CHESTPLATE, REBOOT_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.REBOOT).ChangeRepairItem(REBOOT_LOGO.get()));
    public static final DeferredItem<Item> REBOOT_BLACK_POWER_MORPHER = ITEMS.register("reboot_black_power_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"reboot_black", REBOOT_BLACK_POWER_COIN, REBOOT_HELMET, REBOOT_CHESTPLATE, REBOOT_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.REBOOT).ChangeRepairItem(REBOOT_LOGO.get()));
    public static final DeferredItem<Item> REBOOT_BLUE_POWER_MORPHER = ITEMS.register("reboot_blue_power_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"reboot_blue", REBOOT_BLUE_POWER_COIN, REBOOT_HELMET, REBOOT_CHESTPLATE, REBOOT_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.REBOOT).ChangeRepairItem(REBOOT_LOGO.get()));
    public static final DeferredItem<Item> REBOOT_YELLOW_POWER_MORPHER = ITEMS.register("reboot_yellow_power_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"reboot_yellow", REBOOT_YELLOW_POWER_COIN, REBOOT_HELMET, REBOOT_CHESTPLATE, REBOOT_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.REBOOT).ChangeRepairItem(REBOOT_LOGO.get()));
    public static final DeferredItem<Item> REBOOT_PINK_POWER_MORPHER = ITEMS.register("reboot_pink_power_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"reboot_pink", REBOOT_PINK_POWER_COIN, REBOOT_HELMET, REBOOT_CHESTPLATE, REBOOT_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.REBOOT).ChangeRepairItem(REBOOT_LOGO.get()));
    public static final DeferredItem<Item> REBOOT_GREEN_POWER_MORPHER = ITEMS.register("reboot_green_power_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"reboot_green", REBOOT_GREEN_POWER_COIN, REBOOT_HELMET, REBOOT_CHESTPLATE, REBOOT_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.REBOOT).ChangeRepairItem(REBOOT_LOGO.get()));

    public static final DeferredItem<BaseSwordItem> REBOOT_POWER_SWORD = ITEMS.register("reboot_power_sword",
            () -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.REBOOT).ChangeRepairItem(REBOOT_LOGO.get()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
