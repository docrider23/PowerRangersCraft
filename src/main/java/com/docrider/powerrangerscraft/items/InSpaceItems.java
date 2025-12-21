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

public class InSpaceItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PowerRangersCraftCore.MODID);

    public static final DeferredItem<Item> IN_SPACE_LOGO = ITEMS.register("in_space_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.IN_SPACE));

    public static final DeferredItem<Item> RED_SPACE_DISK_SOLAR = ITEMS.register("red_space_disk_solar",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","solar_red","blank")
                    .IsGlowing());
    public static final DeferredItem<Item> RED_SPACE_DISK = ITEMS.register("red_space_disk",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","in_space_red","in_space_belt")
                    .addAlternative(RED_SPACE_DISK_SOLAR.get()).AddToTabList(RangerTabs.IN_SPACE));

    public static final DeferredItem<Item> IN_SPACE_HELMET = ITEMS.register("in_space_head",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RangerTabs.IN_SPACE).ChangeRepairItem(IN_SPACE_LOGO.get()));
    public static final DeferredItem<Item> IN_SPACE_CHESTPLATE = ITEMS.register("in_space_torso",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RangerTabs.IN_SPACE).ChangeRepairItem(IN_SPACE_LOGO.get()));
    public static final DeferredItem<Item> IN_SPACE_LEGGINGS = ITEMS.register("in_space_legs",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RangerTabs.IN_SPACE).ChangeRepairItem(IN_SPACE_LOGO.get()));

    public static final DeferredItem<Item> RED_ASTRO_MORPHER = ITEMS.register("red_astro_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"in_space_red",RED_SPACE_DISK,IN_SPACE_HELMET,IN_SPACE_CHESTPLATE,IN_SPACE_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.IN_SPACE));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
