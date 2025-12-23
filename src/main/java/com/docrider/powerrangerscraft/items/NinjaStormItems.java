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

public class NinjaStormItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PowerRangersCraftCore.MODID);

    public static final DeferredItem<Item> NINJA_STORM_LOGO = ITEMS.register("ninja_storm_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.NINJA_STORM));

    public static final DeferredItem<Item> RED_WIND_NINJA_POWER_DISK = ITEMS.register("red_wind_ninja_power_disk",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","ninja_storm_red","ninja_storm_red_belt")
                    .ChangeBeltModel("geo/rangerbelt1.geo.json").AddToTabList(RangerTabs.NINJA_STORM));
    public static final DeferredItem<Item> BLUE_WIND_NINJA_POWER_DISK = ITEMS.register("blue_wind_ninja_power_disk",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","ninja_storm_blue","ninja_storm_blue_belt")
                    .ChangeBeltModel("geo/rangerbelt1.geo.json").AddToTabList(RangerTabs.NINJA_STORM));
    public static final DeferredItem<Item> GREEN_SAMURAI_NINJA_POWER_DISK_SOLAR = ITEMS.register("green_samurai_ninja_power_disk_solar",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","solar_green","blank")
                    .IsGlowing());
    public static final DeferredItem<Item> GREEN_SAMURAI_NINJA_POWER_DISK = ITEMS.register("green_samurai_ninja_power_disk",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","green_samurai_ranger","green_samurai_ranger_belt")
                    .addAlternative(GREEN_SAMURAI_NINJA_POWER_DISK_SOLAR.get()).AddToTabList(RangerTabs.NINJA_STORM));

    public static final DeferredItem<Item> NINJA_STORM_HELMET = ITEMS.register("ninja_storm_head",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RangerTabs.NINJA_STORM).ChangeRepairItem(NINJA_STORM_LOGO.get()));
    public static final DeferredItem<Item> NINJA_STORM_CHESTPLATE = ITEMS.register("ninja_storm_torso",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RangerTabs.NINJA_STORM).ChangeRepairItem(NINJA_STORM_LOGO.get()));
    public static final DeferredItem<Item> NINJA_STORM_LEGGINGS = ITEMS.register("ninja_storm_legs",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RangerTabs.NINJA_STORM).ChangeRepairItem(NINJA_STORM_LOGO.get()));

    public static final DeferredItem<Item> RED_WIND_MORPHER = ITEMS.register("red_wind_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"ninja_storm_red",RED_WIND_NINJA_POWER_DISK,NINJA_STORM_HELMET,NINJA_STORM_CHESTPLATE,NINJA_STORM_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.NINJA_STORM).ChangeRepairItem(NINJA_STORM_LOGO.get()));
    public static final DeferredItem<Item> BLUE_WIND_MORPHER = ITEMS.register("blue_wind_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"ninja_storm_blue",BLUE_WIND_NINJA_POWER_DISK,NINJA_STORM_HELMET,NINJA_STORM_CHESTPLATE,NINJA_STORM_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.NINJA_STORM).ChangeRepairItem(NINJA_STORM_LOGO.get()));
    public static final DeferredItem<Item> SAMURAI_CYCLONE_MORPHER = ITEMS.register("samurai_cyclone_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"green_samurai_ranger",GREEN_SAMURAI_NINJA_POWER_DISK,NINJA_STORM_HELMET,NINJA_STORM_CHESTPLATE,NINJA_STORM_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.NINJA_STORM).ChangeRepairItem(NINJA_STORM_LOGO.get()));

    public static final DeferredItem<BaseBlasterItem> NINJA_SWORD = ITEMS.register("ninja_sword",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).IsSwordGun().AddToTabList(RangerTabs.NINJA_STORM).ChangeRepairItem(NINJA_STORM_LOGO.get()));
    //Thunder Staff

    //Hawk Blaster
    public static final DeferredItem<BaseBlasterItem> SONIC_FIN = ITEMS.register("sonic_fin",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).setProjectile(BaseBlasterItem.BlasterProjectile.WIND_CHARGE).AddToTabList(RangerTabs.NINJA_STORM).ChangeRepairItem(NINJA_STORM_LOGO.get()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
