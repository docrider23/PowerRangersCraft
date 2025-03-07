package com.docrider.powerrangerscraft.items;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.items.others.BaseItem;
import com.docrider.powerrangerscraft.items.others.RangerArmorItem;
import com.docrider.powerrangerscraft.items.others.RangerChangerItem;
import com.docrider.powerrangerscraft.items.others.RangerFormChangeItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class HyperforceItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PowerRangersCraftCore.MODID);

    public static final DeferredItem<Item> HYPERFORCE_LOGO = ITEMS.register("hyperforce_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.HYPERFORCE));

    public static final DeferredItem<Item> LION_HYPERFORCE_CARD = ITEMS.register("lion_hyperforce_card",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","hyperforce_red","hyperforce_belt")
                    .AddToTabList(RangerTabs.HYPERFORCE));
    public static final DeferredItem<Item> SERPENT_HYPERFORCE_CARD = ITEMS.register("serpent_hyperforce_card",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","hyperforce_blue","hyperforce_belt")
                    .AddToTabList(RangerTabs.HYPERFORCE));
    public static final DeferredItem<Item> RAM_HYPERFORCE_CARD = ITEMS.register("ram_hyperforce_card",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","hyperforce_yellow","hyperforce_belt")
                    .AddToTabList(RangerTabs.HYPERFORCE));
    public static final DeferredItem<Item> CERBERUS_HYPERFORCE_CARD = ITEMS.register("cerberus_hyperforce_card",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","hyperforce_black","hyperforce_belt")
                    .AddToTabList(RangerTabs.HYPERFORCE));
    public static final DeferredItem<Item> PHOENIX_HYPERFORCE_CARD = ITEMS.register("phoenix_hyperforce_card",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","hyperforce_pink","hyperforce_belt")
                    .AddToTabList(RangerTabs.HYPERFORCE));
    public static final DeferredItem<Item> HYDRA_HYPERFORCE_CARD = ITEMS.register("hydra_hyperforce_card",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","hyperforce_green","hyperforce_green_belt")
                    .AddToTabList(RangerTabs.HYPERFORCE));

    public static final DeferredItem<Item> PINK_POWER_GEM = ITEMS.register("pink_power_gem",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"_battlizer_mode","hyperforce_pink","")
                    .AddToTabList(RangerTabs.HYPERFORCE));

    public static final DeferredItem<Item> HYPERFORCE_HELMET = ITEMS.register("hyperforce_head",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RangerTabs.HYPERFORCE).ChangeRepairItem(HYPERFORCE_LOGO.get()));
    public static final DeferredItem<Item> HYPERFORCE_CHESTPLATE = ITEMS.register("hyperforce_torso",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RangerTabs.HYPERFORCE).ChangeRepairItem(HYPERFORCE_LOGO.get()));
    public static final DeferredItem<Item> HYPERFORCE_LEGGINGS = ITEMS.register("hyperforce_legs",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RangerTabs.HYPERFORCE).ChangeRepairItem(HYPERFORCE_LOGO.get()));

    public static final DeferredItem<Item> RED_HYPERFORCE_MORPHER = ITEMS.register("red_hyperforce_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"hyperforce_red", LION_HYPERFORCE_CARD,HYPERFORCE_HELMET,HYPERFORCE_CHESTPLATE, HYPERFORCE_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.HYPERFORCE).ChangeRepairItem(HYPERFORCE_LOGO.get()));
    public static final DeferredItem<Item> BLUE_HYPERFORCE_MORPHER = ITEMS.register("blue_hyperforce_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"hyperforce_blue", SERPENT_HYPERFORCE_CARD,HYPERFORCE_HELMET,HYPERFORCE_CHESTPLATE, HYPERFORCE_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.HYPERFORCE).ChangeRepairItem(HYPERFORCE_LOGO.get()));
    public static final DeferredItem<Item> YELLOW_HYPERFORCE_MORPHER = ITEMS.register("yellow_hyperforce_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"hyperforce_yellow", RAM_HYPERFORCE_CARD,HYPERFORCE_HELMET,HYPERFORCE_CHESTPLATE, HYPERFORCE_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.HYPERFORCE).ChangeRepairItem(HYPERFORCE_LOGO.get()));
    public static final DeferredItem<Item> BLACK_HYPERFORCE_MORPHER = ITEMS.register("black_hyperforce_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"hyperforce_black", CERBERUS_HYPERFORCE_CARD,HYPERFORCE_HELMET,HYPERFORCE_CHESTPLATE, HYPERFORCE_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.HYPERFORCE).ChangeRepairItem(HYPERFORCE_LOGO.get()));
    public static final DeferredItem<Item> PINK_HYPERFORCE_MORPHER = ITEMS.register("pink_hyperforce_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"hyperforce_pink", PHOENIX_HYPERFORCE_CARD,HYPERFORCE_HELMET,HYPERFORCE_CHESTPLATE, HYPERFORCE_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.HYPERFORCE).ChangeRepairItem(HYPERFORCE_LOGO.get()));
    public static final DeferredItem<Item> GREEN_HYPERFORCE_MORPHER = ITEMS.register("green_hyperforce_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"hyperforce_green", HYDRA_HYPERFORCE_CARD,HYPERFORCE_HELMET,HYPERFORCE_CHESTPLATE, HYPERFORCE_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.HYPERFORCE).ChangeRepairItem(HYPERFORCE_LOGO.get()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
