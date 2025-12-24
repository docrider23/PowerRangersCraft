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

public class MegaforceItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PowerRangersCraftCore.MODID);

    public static final DeferredItem<Item> MEGAFORCE_LOGO = ITEMS.register("megaforce_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.MEGAFORCE));

    public static final DeferredItem<Item> RED_CHANGE_POWER_CARD = ITEMS.register("red_change_power_card",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","megaforce_red","megaforce_belt")
                    .AddToTabList(RangerTabs.MEGAFORCE));

    public static final DeferredItem<Item> MEGAFORCE_HELMET = ITEMS.register("megaforce_head",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RangerTabs.MEGAFORCE).ChangeRepairItem(MEGAFORCE_LOGO.get()));
    public static final DeferredItem<Item> MEGAFORCE_CHESTPLATE = ITEMS.register("megaforce_torso",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RangerTabs.MEGAFORCE).ChangeRepairItem(MEGAFORCE_LOGO.get()));
    public static final DeferredItem<Item> MEGAFORCE_LEGGINGS = ITEMS.register("megaforce_legs",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RangerTabs.MEGAFORCE).ChangeRepairItem(MEGAFORCE_LOGO.get()));

    public static final DeferredItem<Item> RED_GOSEI_MORPHER = ITEMS.register("red_gosei_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"megaforce_red", RED_CHANGE_POWER_CARD,MEGAFORCE_HELMET,MEGAFORCE_CHESTPLATE,MEGAFORCE_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.MEGAFORCE).ChangeRepairItem(MEGAFORCE_LOGO.get()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
