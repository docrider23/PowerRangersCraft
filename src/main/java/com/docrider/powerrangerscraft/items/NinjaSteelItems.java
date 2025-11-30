package com.docrider.powerrangerscraft.items;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.items.ninja_steel.NinjaPowerStarItem;
import com.docrider.powerrangerscraft.items.others.*;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class NinjaSteelItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PowerRangersCraftCore.MODID);

    public static final DeferredItem<Item> NINJA_STEEL_LOGO = ITEMS.register("ninja_steel_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.NINJA_STEEL));

    public static final DeferredItem<Item> RED_NINJA_POWER_STAR = ITEMS.register("red_ninja_power_star",
            () -> new NinjaPowerStarItem(new Item.Properties(),0,"","ninja_steel_red","ninja_steel_red_belt")
                    .AddToTabList(RangerTabs.NINJA_STEEL));
    public static final DeferredItem<Item> RED_NINJA_POWER_STAR_SILVER = ITEMS.register("red_ninja_power_star_silver",
            () -> new NinjaPowerStarItem(new Item.Properties(),0,"","ninja_steel_red_silver","ninja_steel_red_alternate_belt")
                    .AddToTabList(RangerTabs.NINJA_STEEL));

    public static final DeferredItem<Item> NINJA_STEEL_HELMET = ITEMS.register("ninja_steel_head",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RangerTabs.NINJA_STEEL).ChangeRepairItem(NINJA_STEEL_LOGO.get()));
    public static final DeferredItem<Item> NINJA_STEEL_CHESTPLATE = ITEMS.register("ninja_steel_torso",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RangerTabs.NINJA_STEEL).ChangeRepairItem(NINJA_STEEL_LOGO.get()));
    public static final DeferredItem<Item> NINJA_STEEL_LEGGINGS = ITEMS.register("ninja_steel_legs",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RangerTabs.NINJA_STEEL).ChangeRepairItem(NINJA_STEEL_LOGO.get()));

    public static final DeferredItem<Item> RED_NINJA_BATTLE_MORPHER = ITEMS.register("red_ninja_battle_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"ninja_steel_red", RED_NINJA_POWER_STAR, NINJA_STEEL_HELMET, NINJA_STEEL_CHESTPLATE, NINJA_STEEL_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.NINJA_STEEL).ChangeRepairItem(NINJA_STEEL_LOGO.get()));
    public static final DeferredItem<Item> RED_SILVER_NINJA_BATTLE_MORPHER = ITEMS.register("red_silver_ninja_battle_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"ninja_steel_red_silver", RED_NINJA_POWER_STAR_SILVER, NINJA_STEEL_HELMET, NINJA_STEEL_CHESTPLATE, NINJA_STEEL_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.NINJA_STEEL).ChangeRepairItem(NINJA_STEEL_LOGO.get()));

    public static final DeferredItem<BaseSwordItem> NINJA_BATTLE_MORPHER = ITEMS.register("ninja_battle_morpher",
            () -> new BaseSwordItem(Tiers.DIAMOND, 12, -2.4F, new Item.Properties()).AddToTabList(PowerRangersCraftCore.FORM_WEAPON_ITEM).AddToTabList(RangerTabs.NINJA_STEEL).ChangeRepairItem(NINJA_STEEL_LOGO.get()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
