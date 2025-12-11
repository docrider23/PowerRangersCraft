package com.docrider.powerrangerscraft.items;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.items.others.*;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DinoThunderItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PowerRangersCraftCore.MODID);

    public static final DeferredItem<Item> DINO_THUNDER_LOGO = ITEMS.register("dino_thunder_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.DINO_THUNDER));

    public static final DeferredItem<Item> YELLOW_DINO_GEM = ITEMS.register("yellow_dino_gem",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","dino_thunder_yellow","dino_thunder_yellow_belt")
                    .ChangeBeltModel("geo/rangerbeltchanger.geo.json").AddToTabList(RangerTabs.DINO_THUNDER));

    public static final DeferredItem<Item> DINO_THUNDER_HELMET = ITEMS.register("dino_thunder_head",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RangerTabs.DINO_THUNDER).ChangeRepairItem(DINO_THUNDER_LOGO.get()));
    public static final DeferredItem<Item> DINO_THUNDER_CHESTPLATE = ITEMS.register("dino_thunder_torso",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RangerTabs.DINO_THUNDER).ChangeRepairItem(DINO_THUNDER_LOGO.get()));
    public static final DeferredItem<Item> DINO_THUNDER_LEGGINGS = ITEMS.register("dino_thunder_legs",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RangerTabs.DINO_THUNDER).ChangeRepairItem(DINO_THUNDER_LOGO.get()));

    public static final DeferredItem<Item> YELLOW_DINO_MORPHER = ITEMS.register("yellow_dino_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"dino_thunder_yellow",YELLOW_DINO_GEM,DINO_THUNDER_HELMET,DINO_THUNDER_CHESTPLATE,DINO_THUNDER_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.DINO_THUNDER).ChangeRepairItem(DINO_THUNDER_LOGO.get()));

    public static final DeferredItem<BaseBlasterItem> THUNDERMAX_SABER = ITEMS.register("thundermax_saber",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).IsSwordGun().AddToTabList(RangerTabs.DINO_THUNDER).ChangeRepairItem(DINO_THUNDER_LOGO.get()));

    //Tyranno Staff
    //Tricera Shield
    public static final DeferredItem<SwordItem> PTERA_GRIP = ITEMS.register("ptera_grip",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.DINO_THUNDER).ChangeRepairItem(DINO_THUNDER_LOGO.get()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
