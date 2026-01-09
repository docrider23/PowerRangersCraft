package com.docrider.powerrangerscraft.items;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.items.others.*;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class SPDItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PowerRangersCraftCore.MODID);

    public static final DeferredItem<Item> SPD_LOGO = ITEMS.register("spd_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.SPD));

    public static final DeferredItem<Item> SPD_RED_BADGE = ITEMS.register("spd_red_badge",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","spd_red","spd_belt")
                    .IsGlowing().AddToTabList(RangerTabs.SPD));

    public static final DeferredItem<Item> SPD_HELMET = ITEMS.register("spd_head",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RangerTabs.SPD).ChangeRepairItem(SPD_LOGO.get()));
    public static final DeferredItem<Item> SPD_CHESTPLATE = ITEMS.register("spd_torso",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RangerTabs.SPD).ChangeRepairItem(SPD_LOGO.get()));
    public static final DeferredItem<Item> SPD_LEGGINGS = ITEMS.register("spd_legs",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RangerTabs.SPD).ChangeRepairItem(SPD_LOGO.get()));

    public static final DeferredItem<Item> RED_DELTA_MORPHER = ITEMS.register("red_delta_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"spd_red",SPD_RED_BADGE,SPD_HELMET,SPD_CHESTPLATE,SPD_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.SPD).ChangeRepairItem(SPD_LOGO.get()));

    public static final DeferredItem<BaseBlasterItem> DELTA_BLASTER_1 = ITEMS.register("delta_blaster_1",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.SPD).ChangeRepairItem(SPD_LOGO.get()));
    public static final DeferredItem<BaseBlasterItem> DELTA_BLASTER_2 = ITEMS.register("delta_blaster_2",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.SPD).ChangeRepairItem(SPD_LOGO.get()));
    public static final DeferredItem<BaseBlasterItem> DELTA_BLASTER_COMBO = ITEMS.register("delta_blaster_combo",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 10, -2.4F, new Item.Properties()).KeepDifItem(DELTA_BLASTER_2.get()).AddToTabList(RangerTabs.SPD).ChangeRepairItem(SPD_LOGO.get()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
