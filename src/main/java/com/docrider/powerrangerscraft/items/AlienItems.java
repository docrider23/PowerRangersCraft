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

public class AlienItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PowerRangersCraftCore.MODID);

    public static final DeferredItem<Item> ALIEN_LOGO = ITEMS.register("alien_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.ALIEN));

    public static final DeferredItem<Item> RED_ALIEN_POWER_COIN = ITEMS.register("red_alien_power_coin",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","alien_red","alien_red_belt")
                    .AddToTabList(RangerTabs.ALIEN));

    public static final DeferredItem<Item> ALIEN_HELMET = ITEMS.register("alien_head",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RangerTabs.ALIEN).ChangeRepairItem(ALIEN_LOGO.get()));
    public static final DeferredItem<Item> ALIEN_CHESTPLATE = ITEMS.register("alien_torso",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RangerTabs.ALIEN).ChangeRepairItem(ALIEN_LOGO.get()));
    public static final DeferredItem<Item> ALIEN_LEGGINGS = ITEMS.register("alien_legs",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RangerTabs.ALIEN).ChangeRepairItem(ALIEN_LOGO.get()));

    public static final DeferredItem<Item> RED_ALIEN_MORPHER = ITEMS.register("red_alien_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"alien_red",RED_ALIEN_POWER_COIN,ALIEN_HELMET,ALIEN_CHESTPLATE,ALIEN_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.ALIEN).ChangeRepairItem(ALIEN_LOGO.get()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
