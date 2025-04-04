package com.docrider.powerrangerscraft.items;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.items.others.BaseItem;
import com.docrider.powerrangerscraft.items.others.RangerArmorItem;
import com.docrider.powerrangerscraft.items.others.RangerChangerItem;
import com.docrider.powerrangerscraft.items.others.RangerFormChangeItem;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class StarrangerItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PowerRangersCraftCore.MODID);

    public static final DeferredItem<Item> STARRANGER_LOGO = ITEMS.register("starranger_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.STARRANGER));

    public static final DeferredItem<Item> BLANK_CONSTELLATION_CARD = ITEMS.register("blank_constellation_card",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.STARRANGER));

    public static final DeferredItem<Item> FIRE_CONSTELLATION_CARD = ITEMS.register("fire_constellation_card",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","star_red","starranger_belt")
                    .ChangeBeltModel("geo/rangerbeltchangerweapon.geo.json").AddToTabList(RangerTabs.STARRANGER));

    public static final DeferredItem<Item> WATER_CONSTELLATION_CARD = ITEMS.register("water_constellation_card",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","star_blue","starranger_belt")
                    .ChangeBeltModel("geo/rangerbeltchangerweapon.geo.json").AddToTabList(RangerTabs.STARRANGER));

    public static final DeferredItem<Item> EARTH_CONSTELLATION_CARD = ITEMS.register("earth_constellation_card",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","star_green","starranger_belt")
                    .ChangeBeltModel("geo/rangerbeltchangerweapon.geo.json").AddToTabList(RangerTabs.STARRANGER));

    public static final DeferredItem<Item> AIR_CONSTELLATION_CARD = ITEMS.register("air_constellation_card",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","star_white","starranger_belt")
                    .ChangeBeltModel("geo/rangerbeltchangerweapon.geo.json").AddToTabList(RangerTabs.STARRANGER));

    public static final DeferredItem<Item> LIGHTNING_CONSTELLATION_CARD = ITEMS.register("lightning_constellation_card",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","star_lightning","starranger_lightning_belt")
                    .ChangeBeltModel("geo/rangerbeltchangerweapon.geo.json").AddToTabList(RangerTabs.STARRANGER));

    /*
    public static final DeferredItem<Item> SOLAR_CONSTELLATION_CARD = ITEMS.register("solar_constellation_card",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","taiyou_gold","starranger_equinox_belt")
                    .ChangeBeltModel("geo/rangerbeltweapon.geo.json").AddToTabList(RangerTabs.STARRANGER));

    public static final DeferredItem<Item> LUNAR_CONSTELLATION_CARD = ITEMS.register("lunar_constellation_card",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","tsuki_silver","starranger_equinox_belt")
                    .ChangeBeltModel("geo/rangerbeltweapon.geo.json").AddToTabList(RangerTabs.STARRANGER));
     */

    public static final DeferredItem<Item> OPHIUCHUS_CONSTELLATION_CARD = ITEMS.register("ophiuchus_constellation_card",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","zodiac_mastar","starranger_mastar_belt")
                    .AddToTabList(RangerTabs.STARRANGER));

    public static final DeferredItem<Item> COSMIC_HEART = ITEMS.register("cosmic_heart",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","cosmic_mastar","starranger_mastar_belt")
                    .AddToTabList(RangerTabs.STARRANGER));

    public static final DeferredItem<Item> STARRANGER_HELMET = ITEMS.register("starranger_head",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RangerTabs.STARRANGER).ChangeRepairItem(STARRANGER_LOGO.get()));
    public static final DeferredItem<Item> STARRANGER_CHESTPLATE = ITEMS.register("starranger_torso",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RangerTabs.STARRANGER).ChangeRepairItem(STARRANGER_LOGO.get()));
    public static final DeferredItem<Item> STARRANGER_LEGGINGS = ITEMS.register("starranger_legs",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RangerTabs.STARRANGER).ChangeRepairItem(STARRANGER_LOGO.get()));

    public static final DeferredItem<Item> RED_ZODIAC_BRACE = ITEMS.register("red_zodiac_brace",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"star_red",FIRE_CONSTELLATION_CARD, STARRANGER_HELMET, STARRANGER_CHESTPLATE, STARRANGER_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.STARRANGER).ChangeRepairItem(STARRANGER_LOGO.get()));
    public static final DeferredItem<Item> BLUE_ZODIAC_BRACE = ITEMS.register("blue_zodiac_brace",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"star_blue", WATER_CONSTELLATION_CARD, STARRANGER_HELMET, STARRANGER_CHESTPLATE, STARRANGER_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.STARRANGER).ChangeRepairItem(STARRANGER_LOGO.get()));
    public static final DeferredItem<Item> GREEN_ZODIAC_BRACE = ITEMS.register("green_zodiac_brace",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"star_green", EARTH_CONSTELLATION_CARD, STARRANGER_HELMET, STARRANGER_CHESTPLATE, STARRANGER_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.STARRANGER).ChangeRepairItem(STARRANGER_LOGO.get()));
    public static final DeferredItem<Item> WHITE_ZODIAC_BRACE = ITEMS.register("white_zodiac_brace",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"star_white", AIR_CONSTELLATION_CARD, STARRANGER_HELMET, STARRANGER_CHESTPLATE, STARRANGER_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.STARRANGER).ChangeRepairItem(STARRANGER_LOGO.get()));
    public static final DeferredItem<Item> YELLOW_LIGHTNING_BRACE = ITEMS.register("yellow_lightning_brace",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"star_lightning", LIGHTNING_CONSTELLATION_CARD, STARRANGER_HELMET, STARRANGER_CHESTPLATE, STARRANGER_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.STARRANGER).ChangeRepairItem(STARRANGER_LOGO.get()));
    /*
    public static final DeferredItem<Item> COSMO_SABER_GOLD = ITEMS.register("cosmo_saber_gold",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"taiyou_gold", SOLAR_CONSTELLATION_CARD, STARRANGER_HELMET, STARRANGER_CHESTPLATE, STARRANGER_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.STARRANGER).ChangeRepairItem(STARRANGER_LOGO.get()));
    public static final DeferredItem<Item> COSMO_BUSTER_SILVER = ITEMS.register("cosmo_buster_silver",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"tsuki_silver", LUNAR_CONSTELLATION_CARD, STARRANGER_HELMET, STARRANGER_CHESTPLATE, STARRANGER_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.STARRANGER).ChangeRepairItem(STARRANGER_LOGO.get()));
     */
    public static final DeferredItem<Item> OPHIUCHUS_STAFF_MASTAR = ITEMS.register("ophiuchus_staff_mastar",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"zodiac_mastar", OPHIUCHUS_CONSTELLATION_CARD, STARRANGER_HELMET, STARRANGER_CHESTPLATE, STARRANGER_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.STARRANGER).ChangeRepairItem(STARRANGER_LOGO.get()));
    public static final DeferredItem<Item> COSMIC_STAFF_MASTAR = ITEMS.register("cosmic_staff_mastar",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"cosmic_mastar", COSMIC_HEART, STARRANGER_HELMET, STARRANGER_CHESTPLATE, STARRANGER_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.STARRANGER).ChangeRepairItem(STARRANGER_LOGO.get()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
