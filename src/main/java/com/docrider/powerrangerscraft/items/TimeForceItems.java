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

public class TimeForceItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PowerRangersCraftCore.MODID);

    public static final DeferredItem<Item> TIME_FORCE_LOGO = ITEMS.register("time_force_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.TIME_FORCE));

    public static final DeferredItem<Item> TIME_FORCE_RED_BADGE = ITEMS.register("time_force_red_badge",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","time_force_red","time_force_belt")
                    .ChangeBeltModel("geo/rangerbelt1.geo.json").AddToTabList(RangerTabs.TIME_FORCE));
    public static final DeferredItem<Item> QUANTUM_RANGER_BADGE = ITEMS.register("quantum_ranger_badge",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","quantum_ranger","quantum_ranger_belt")
                    .ChangeBeltModel("geo/rangerbelt1.geo.json").AddToTabList(RangerTabs.TIME_FORCE));

    public static final DeferredItem<Item> TIME_FORCE_HELMET = ITEMS.register("time_force_head",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RangerTabs.TIME_FORCE).ChangeRepairItem(TIME_FORCE_LOGO.get()));
    public static final DeferredItem<Item> TIME_FORCE_CHESTPLATE = ITEMS.register("time_force_torso",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RangerTabs.TIME_FORCE).ChangeRepairItem(TIME_FORCE_LOGO.get()));
    public static final DeferredItem<Item> TIME_FORCE_LEGGINGS = ITEMS.register("time_force_legs",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RangerTabs.TIME_FORCE).ChangeRepairItem(TIME_FORCE_LOGO.get()));

    public static final DeferredItem<Item> RED_CHRONO_MORPHER = ITEMS.register("red_chrono_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"time_force_red",TIME_FORCE_RED_BADGE,TIME_FORCE_HELMET,TIME_FORCE_CHESTPLATE,TIME_FORCE_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.TIME_FORCE));
    public static final DeferredItem<Item> QUANTUM_MORPHER = ITEMS.register("quantum_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"quantum_ranger",QUANTUM_RANGER_BADGE,TIME_FORCE_HELMET,TIME_FORCE_CHESTPLATE,TIME_FORCE_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.TIME_FORCE));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
