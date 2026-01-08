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

public class SuperMegaforceItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PowerRangersCraftCore.MODID);

    public static final DeferredItem<Item> SUPER_MEGAFORCE_LOGO = ITEMS.register("super_megaforce_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.SUPER_MEGAFORCE));

    public static final DeferredItem<Item> BLANK_RANGER_KEY = ITEMS.register("blank_ranger_key",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.SUPER_MEGAFORCE));

    public static final DeferredItem<Item> SUPER_MEGAFORCE_RED_KEY = ITEMS.register("super_megaforce_red_key",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","super_megaforce_red","super_megaforce_belt")
                    .AddToTabList(RangerTabs.SUPER_MEGAFORCE));

    public static final DeferredItem<Item> SUPER_MEGAFORCE_HELMET = ITEMS.register("super_megaforce_head",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RangerTabs.SUPER_MEGAFORCE).ChangeRepairItem(BLANK_RANGER_KEY.get()));
    public static final DeferredItem<Item> SUPER_MEGAFORCE_CHESTPLATE = ITEMS.register("super_megaforce_torso",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RangerTabs.SUPER_MEGAFORCE).ChangeRepairItem(BLANK_RANGER_KEY.get()));
    public static final DeferredItem<Item> SUPER_MEGAFORCE_LEGGINGS = ITEMS.register("super_megaforce_legs",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RangerTabs.SUPER_MEGAFORCE).ChangeRepairItem(BLANK_RANGER_KEY.get()));

    public static final DeferredItem<Item> RED_LEGENDARY_MORPHER = ITEMS.register("red_legendary_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"super_megaforce_red", SUPER_MEGAFORCE_RED_KEY,SUPER_MEGAFORCE_HELMET,SUPER_MEGAFORCE_CHESTPLATE,SUPER_MEGAFORCE_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.SUPER_MEGAFORCE).ChangeRepairItem(BLANK_RANGER_KEY.get()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
