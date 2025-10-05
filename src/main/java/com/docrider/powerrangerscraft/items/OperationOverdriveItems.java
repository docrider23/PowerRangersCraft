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

public class OperationOverdriveItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PowerRangersCraftCore.MODID);

    public static final DeferredItem<Item> OPERATION_OVERDRIVE_LOGO = ITEMS.register("operation_overdrive_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.OPERATION_OVERDRIVE));

    public static final DeferredItem<Item> OVERDRIVE_RED_LOGO = ITEMS.register("overdrive_red_logo",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","overdrive_red","blank").IsGlowing().AddToTabList(RangerTabs.OPERATION_OVERDRIVE));
    public static final DeferredItem<Item> OVERDRIVE_BLACK_LOGO = ITEMS.register("overdrive_black_logo",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","overdrive_black","blank").IsGlowing().AddToTabList(RangerTabs.OPERATION_OVERDRIVE));
    public static final DeferredItem<Item> OVERDRIVE_BLUE_LOGO = ITEMS.register("overdrive_blue_logo",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","overdrive_blue","blank").IsGlowing().AddToTabList(RangerTabs.OPERATION_OVERDRIVE));
    public static final DeferredItem<Item> OVERDRIVE_YELLOW_LOGO = ITEMS.register("overdrive_yellow_logo",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","overdrive_yellow","blank").IsGlowing().AddToTabList(RangerTabs.OPERATION_OVERDRIVE));
    public static final DeferredItem<Item> OVERDRIVE_PINK_LOGO = ITEMS.register("overdrive_pink_logo",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","overdrive_pink","blank").IsGlowing().AddToTabList(RangerTabs.OPERATION_OVERDRIVE));
    public static final DeferredItem<Item> MERCURY_RANGER_LOGO = ITEMS.register("mercury_ranger_logo",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","mercury_ranger","blank").IsGlowing().AddToTabList(RangerTabs.OPERATION_OVERDRIVE));

    public static final DeferredItem<Item> OPERATION_OVERDRIVE_HELMET = ITEMS.register("operation_overdrive_head",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RangerTabs.OPERATION_OVERDRIVE).ChangeRepairItem(OPERATION_OVERDRIVE_LOGO.get()));
    public static final DeferredItem<Item> OPERATION_OVERDRIVE_CHESTPLATE = ITEMS.register("operation_overdrive_torso",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RangerTabs.OPERATION_OVERDRIVE).ChangeRepairItem(OPERATION_OVERDRIVE_LOGO.get()));
    public static final DeferredItem<Item> OPERATION_OVERDRIVE_LEGGINGS = ITEMS.register("operation_overdrive_legs",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RangerTabs.OPERATION_OVERDRIVE).ChangeRepairItem(OPERATION_OVERDRIVE_LOGO.get()));

    public static final DeferredItem<Item> RED_OVERDRIVE_TRACKER = ITEMS.register("red_overdrive_tracker",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"overdrive_red", OVERDRIVE_RED_LOGO, OPERATION_OVERDRIVE_HELMET, OPERATION_OVERDRIVE_CHESTPLATE, OPERATION_OVERDRIVE_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.OPERATION_OVERDRIVE).ChangeRepairItem(OPERATION_OVERDRIVE_LOGO.get()));
    public static final DeferredItem<Item> BLACK_OVERDRIVE_TRACKER = ITEMS.register("black_overdrive_tracker",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"overdrive_black", OVERDRIVE_BLACK_LOGO, OPERATION_OVERDRIVE_HELMET, OPERATION_OVERDRIVE_CHESTPLATE, OPERATION_OVERDRIVE_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.OPERATION_OVERDRIVE).ChangeRepairItem(OPERATION_OVERDRIVE_LOGO.get()));
    public static final DeferredItem<Item> BLUE_OVERDRIVE_TRACKER = ITEMS.register("blue_overdrive_tracker",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"overdrive_blue", OVERDRIVE_BLUE_LOGO, OPERATION_OVERDRIVE_HELMET, OPERATION_OVERDRIVE_CHESTPLATE, OPERATION_OVERDRIVE_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.OPERATION_OVERDRIVE).ChangeRepairItem(OPERATION_OVERDRIVE_LOGO.get()));
    public static final DeferredItem<Item> YELLOW_OVERDRIVE_TRACKER = ITEMS.register("yellow_overdrive_tracker",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"overdrive_yellow", OVERDRIVE_YELLOW_LOGO, OPERATION_OVERDRIVE_HELMET, OPERATION_OVERDRIVE_CHESTPLATE, OPERATION_OVERDRIVE_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.OPERATION_OVERDRIVE).ChangeRepairItem(OPERATION_OVERDRIVE_LOGO.get()));
    public static final DeferredItem<Item> PINK_OVERDRIVE_TRACKER = ITEMS.register("pink_overdrive_tracker",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"overdrive_pink", OVERDRIVE_PINK_LOGO, OPERATION_OVERDRIVE_HELMET, OPERATION_OVERDRIVE_CHESTPLATE, OPERATION_OVERDRIVE_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.OPERATION_OVERDRIVE).ChangeRepairItem(OPERATION_OVERDRIVE_LOGO.get()));
    public static final DeferredItem<Item> MERCURY_MORPHER = ITEMS.register("mercury_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"mercury_ranger", MERCURY_RANGER_LOGO, OPERATION_OVERDRIVE_HELMET, OPERATION_OVERDRIVE_CHESTPLATE, OPERATION_OVERDRIVE_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.OPERATION_OVERDRIVE).ChangeRepairItem(OPERATION_OVERDRIVE_LOGO.get()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
