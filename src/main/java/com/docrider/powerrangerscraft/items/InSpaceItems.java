package com.docrider.powerrangerscraft.items;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.items.others.BaseItem;
import com.docrider.powerrangerscraft.items.others.RangerFormChangeItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class InSpaceItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PowerRangersCraftCore.MODID);

    public static final DeferredItem<Item> IN_SPACE_LOGO = ITEMS.register("in_space_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.MISC));

    public static final DeferredItem<Item> RED_SPACE_DISK = ITEMS.register("red_space_disk",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","solar_red","blank")
                    .AddToTabList(RangerTabs.COMICS));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
