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

public class RPMItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PowerRangersCraftCore.MODID);

    public static final DeferredItem<Item> RPM_LOGO = ITEMS.register("rpm_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.RPM));

    public static final DeferredItem<Item> EAGLE_RACER_ENGINE_CELL = ITEMS.register("eagle_racer_engine_cell",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","rpm_red","rpm_cell_shift_belt")
                    .AddToTabList(RangerTabs.RPM));

    public static final DeferredItem<Item> RPM_HELMET = ITEMS.register("rpm_head",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RangerTabs.RPM).ChangeRepairItem(RPM_LOGO.get()));
    public static final DeferredItem<Item> RPM_CHESTPLATE = ITEMS.register("rpm_torso",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RangerTabs.RPM).ChangeRepairItem(RPM_LOGO.get()));
    public static final DeferredItem<Item> RPM_LEGGINGS = ITEMS.register("rpm_legs",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RangerTabs.RPM).ChangeRepairItem(RPM_LOGO.get()));

    public static final DeferredItem<Item> RED_CELL_SHIFT_MORPHER = ITEMS.register("red_cell_shift_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"rpm_red", EAGLE_RACER_ENGINE_CELL,RPM_HELMET,RPM_CHESTPLATE,RPM_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.RPM).ChangeRepairItem(RPM_LOGO.get()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
