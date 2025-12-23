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

public class JungleFuryItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PowerRangersCraftCore.MODID);

    public static final DeferredItem<Item> JUNGLE_FURY_LOGO = ITEMS.register("jungle_fury_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.JUNGLE_FURY));

    public static final DeferredItem<Item> TIGER_SPIRIT = ITEMS.register("tiger_spirit",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","jungle_fury_red","blank")
                    .AddToTabList(RangerTabs.JUNGLE_FURY));

    public static final DeferredItem<Item> JUNGLE_FURY_HELMET = ITEMS.register("jungle_fury_head",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RangerTabs.JUNGLE_FURY).ChangeRepairItem(JUNGLE_FURY_LOGO.get()));
    public static final DeferredItem<Item> JUNGLE_FURY_CHESTPLATE = ITEMS.register("jungle_fury_torso",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RangerTabs.JUNGLE_FURY).ChangeRepairItem(JUNGLE_FURY_LOGO.get()));
    public static final DeferredItem<Item> JUNGLE_FURY_LEGGINGS = ITEMS.register("jungle_fury_legs",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RangerTabs.JUNGLE_FURY).ChangeRepairItem(JUNGLE_FURY_LOGO.get()));

    public static final DeferredItem<Item> RED_SOLAR_MORPHER = ITEMS.register("red_solar_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"jungle_fury_red",TIGER_SPIRIT,JUNGLE_FURY_HELMET,JUNGLE_FURY_CHESTPLATE,JUNGLE_FURY_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.JUNGLE_FURY).ChangeRepairItem(JUNGLE_FURY_LOGO.get()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
