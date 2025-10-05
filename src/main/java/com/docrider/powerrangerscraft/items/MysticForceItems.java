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

public class MysticForceItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PowerRangersCraftCore.MODID);

    public static final DeferredItem<Item> MYSTIC_FORCE_LOGO = ITEMS.register("mystic_force_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.MYSTIC_FORCE));

    public static final DeferredItem<Item> GREEN_MYSTIC_MORPHER_PLATE = ITEMS.register("green_mystic_morpher_plate",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","mystic_force_green","mystic_force_belt")
                    .AddToTabList(RangerTabs.MYSTIC_FORCE));

    public static final DeferredItem<Item> MYSTIC_FORCE_HELMET = ITEMS.register("mystic_force_head",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RangerTabs.MYSTIC_FORCE).ChangeRepairItem(MYSTIC_FORCE_LOGO.get()));
    public static final DeferredItem<Item> MYSTIC_FORCE_CHESTPLATE = ITEMS.register("mystic_force_torso",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RangerTabs.MYSTIC_FORCE).ChangeRepairItem(MYSTIC_FORCE_LOGO.get()));
    public static final DeferredItem<Item> MYSTIC_FORCE_LEGGINGS = ITEMS.register("mystic_force_legs",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RangerTabs.MYSTIC_FORCE).ChangeRepairItem(MYSTIC_FORCE_LOGO.get()));

    public static final DeferredItem<Item> GREEN_MYSTIC_MORPHER = ITEMS.register("green_mystic_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"mystic_force_green",GREEN_MYSTIC_MORPHER_PLATE,MYSTIC_FORCE_HELMET,MYSTIC_FORCE_CHESTPLATE,MYSTIC_FORCE_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.MYSTIC_FORCE).ChangeRepairItem(MYSTIC_FORCE_LOGO.get()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
