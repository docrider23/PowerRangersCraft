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

public class ZeoItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PowerRangersCraftCore.MODID);

    public static final DeferredItem<Item> ZEO_LOGO = ITEMS.register("zeo_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.ZEO));

    public static final DeferredItem<Item> ZEO_CRYSTAL_SHARD = ITEMS.register("zeo_crystal_shard",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.ZEO));

    public static final DeferredItem<Item> RED_ZEO_SUB_CRYSTAL = ITEMS.register("red_zeo_sub_crystal",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","zeo_red","zeo_belt")
                    .AddToTabList(RangerTabs.ZEO));

    public static final DeferredItem<Item> YELLOW_ZEO_SUB_CRYSTAL_SOLAR = ITEMS.register("yellow_zeo_sub_crystal_solar",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","solar_yellow","blank")
                    .IsGlowing());
    public static final DeferredItem<Item> YELLOW_ZEO_SUB_CRYSTAL = ITEMS.register("yellow_zeo_sub_crystal",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","zeo_yellow","zeo_belt")
                    .addAlternative(YELLOW_ZEO_SUB_CRYSTAL_SOLAR.get()).AddToTabList(RangerTabs.ZEO));

    public static final DeferredItem<Item> ZEO_HELMET = ITEMS.register("zeo_head",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RangerTabs.ZEO).ChangeRepairItem(ZEO_CRYSTAL_SHARD.get()));
    public static final DeferredItem<Item> ZEO_CHESTPLATE = ITEMS.register("zeo_torso",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RangerTabs.ZEO).ChangeRepairItem(ZEO_CRYSTAL_SHARD.get()));
    public static final DeferredItem<Item> ZEO_LEGGINGS = ITEMS.register("zeo_legs",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RangerTabs.ZEO).ChangeRepairItem(ZEO_CRYSTAL_SHARD.get()));

    public static final DeferredItem<Item> RED_ZEONIZER = ITEMS.register("red_zeonizer",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"zeo_red",RED_ZEO_SUB_CRYSTAL,ZEO_HELMET,ZEO_CHESTPLATE,ZEO_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.ZEO).ChangeRepairItem(ZEO_CRYSTAL_SHARD.get()));
    public static final DeferredItem<Item> YELLOW_ZEONIZER = ITEMS.register("yellow_zeonizer",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"zeo_yellow",YELLOW_ZEO_SUB_CRYSTAL,ZEO_HELMET,ZEO_CHESTPLATE,ZEO_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.ZEO).ChangeRepairItem(ZEO_CRYSTAL_SHARD.get()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
