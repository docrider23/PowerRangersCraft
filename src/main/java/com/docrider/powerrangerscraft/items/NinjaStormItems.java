package com.docrider.powerrangerscraft.items;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.items.others.BaseItem;
import com.docrider.powerrangerscraft.items.others.RangerFormChangeItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class NinjaStormItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PowerRangersCraftCore.MODID);

    public static final DeferredItem<Item> NINJA_STORM_LOGO = ITEMS.register("ninja_storm_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.MISC));

    public static final DeferredItem<Item> GREEN_SAMURAI_NINJA_DISK = ITEMS.register("green_samurai_ninja_disk",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","solar_green","blank")
                    .AddToTabList(RangerTabs.COMICS));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
