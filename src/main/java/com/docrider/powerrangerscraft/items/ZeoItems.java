package com.docrider.powerrangerscraft.items;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.items.others.BaseItem;
import com.docrider.powerrangerscraft.items.others.RangerFormChangeItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ZeoItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PowerRangersCraftCore.MODID);

    public static final DeferredItem<Item> ZEO_LOGO = ITEMS.register("zeo_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.MISC));

    public static final DeferredItem<Item> YELLOW_ZEO_SUB_CRYSTAL = ITEMS.register("yellow_zeo_sub_crystal",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","solar_yellow","blank")
                    .AddToTabList(RangerTabs.COMICS));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
