package com.docrider.powerrangerscraft.items;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.items.mmpr.MMPRBeltItem;
import com.docrider.powerrangerscraft.items.others.*;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MMPRItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PowerRangersCraftCore.MODID);

    public static final DeferredItem<Item> MMPR_LOGO = ITEMS.register("mmpr_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.MMPR));

    public static final DeferredItem<Item> TYRANNOSAURUS_POWER_COIN = ITEMS.register("tyrannosaurus_power_coin",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","mmpr_red","mmpr_belt")
                    .ChangeBeltModel("geo/rangerbeltextra.geo.json").AddToTabList(RangerTabs.MMPR));

    public static final DeferredItem<Item> MASTODON_POWER_COIN = ITEMS.register("mastodon_power_coin",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","mmpr_black","mmpr_belt")
                    .ChangeBeltModel("geo/rangerbeltextra.geo.json").AddToTabList(RangerTabs.MMPR));

    public static final DeferredItem<Item> TRICERATOPS_POWER_COIN = ITEMS.register("triceratops_power_coin",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","mmpr_blue","mmpr_belt")
                    .ChangeBeltModel("geo/rangerbeltextra.geo.json").AddToTabList(RangerTabs.MMPR));

    public static final DeferredItem<Item> SABERTOOTH_TIGER_POWER_COIN = ITEMS.register("sabertooth_tiger_power_coin",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","mmpr_yellow","mmpr_belt")
                    .ChangeBeltModel("geo/rangerbeltextra.geo.json").AddToTabList(RangerTabs.MMPR));

    public static final DeferredItem<Item> PTERADACTYL_POWER_COIN = ITEMS.register("pteradactyl_power_coin",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","mmpr_pink","mmpr_belt")
                    .ChangeBeltModel("geo/rangerbeltextra.geo.json").AddToTabList(RangerTabs.MMPR));

    public static final DeferredItem<Item> MMPR_HELMET = ITEMS.register("mmpr_head",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RangerTabs.MMPR).ChangeRepairItem(MMPR_LOGO.get()));
    public static final DeferredItem<Item> MMPR_CHESTPLATE = ITEMS.register("mmpr_torso",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RangerTabs.MMPR).ChangeRepairItem(MMPR_LOGO.get()));
    public static final DeferredItem<Item> MMPR_LEGGINGS = ITEMS.register("mmpr_legs",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RangerTabs.MMPR).ChangeRepairItem(MMPR_LOGO.get()));

    public static final DeferredItem<Item> RED_POWER_MORPHER = ITEMS.register("red_power_morpher",
            () -> new MMPRBeltItem(ArmorMaterials.DIAMOND,"mmpr_red",TYRANNOSAURUS_POWER_COIN,MMPR_HELMET,MMPR_CHESTPLATE,MMPR_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.MMPR).ChangeRepairItem(MMPR_LOGO.get()));
    public static final DeferredItem<Item> BLACK_POWER_MORPHER = ITEMS.register("black_power_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"mmpr_black",MASTODON_POWER_COIN,MMPR_HELMET,MMPR_CHESTPLATE,MMPR_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.MMPR).ChangeRepairItem(MMPR_LOGO.get()));
    public static final DeferredItem<Item> BLUE_POWER_MORPHER = ITEMS.register("blue_power_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"mmpr_blue", TRICERATOPS_POWER_COIN,MMPR_HELMET,MMPR_CHESTPLATE,MMPR_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.MMPR).ChangeRepairItem(MMPR_LOGO.get()));
    public static final DeferredItem<Item> YELLOW_POWER_MORPHER = ITEMS.register("yellow_power_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"mmpr_yellow", SABERTOOTH_TIGER_POWER_COIN,MMPR_HELMET,MMPR_CHESTPLATE,MMPR_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.MMPR).ChangeRepairItem(MMPR_LOGO.get()));
    public static final DeferredItem<Item> PINK_POWER_MORPHER = ITEMS.register("pink_power_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"mmpr_pink", PTERADACTYL_POWER_COIN,MMPR_HELMET,MMPR_CHESTPLATE,MMPR_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.MMPR).ChangeRepairItem(MMPR_LOGO.get()));

    public static final DeferredItem<SwordItem> BLADE_BLASTER = ITEMS.register("blade_blaster",
            () -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.MMPR).ChangeRepairItem(MMPR_LOGO.get()));
/*    public static final DeferredItem<PickaxeItem> DRILL_BUTE = ITEMS.register("drill_bute",
            () -> new BasePickaxeItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.GORANGER).ChangeRepairItem(GORANGER_LOGO.get()));
    public static final DeferredItem<BaseBlasterItem> SILVER_SHOT = ITEMS.register("silver_shot",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.GORANGER).ChangeRepairItem(GORANGER_LOGO.get()));

    public static final DeferredItem<BaseBlasterItem> BLUE_CHERRY = ITEMS.register("blue_cherry",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 2, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.GORANGER).ChangeRepairItem(GORANGER_LOGO.get()));
    public static final DeferredItem<BaseBlasterItem> ULTRA_BLUE_CHERRY = ITEMS.register("ultra_blue_cherry",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.GORANGER).ChangeRepairItem(GORANGER_LOGO.get()));

    public static final DeferredItem<SwordItem> KI_STICKER = ITEMS.register("ki_sticker",
            () -> new BaseDualSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).IsTripleWeapon().AddToTabList(RangerTabs.GORANGER).ChangeRepairItem(GORANGER_LOGO.get()));
    public static final DeferredItem<SwordItem> KI_STICKER_SHORT = ITEMS.register("ki_sticker_short",
            () -> new BaseDualSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).IsTripleWeapon().AddToTabList(RangerTabs.GORANGER).ChangeRepairItem(GORANGER_LOGO.get()));
    public static final DeferredItem<Item> YTC = ITEMS.register("ytc",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.GORANGER));

    public static final DeferredItem<BaseThrowableItem> MOMO_CARD = ITEMS.register("momo_card",
            () -> new BaseThrowableItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).IsShuriken().AddToTabList(RangerTabs.GORANGER).ChangeRepairItem(GORANGER_LOGO.get()));
    public static final DeferredItem<BaseExplosiveItem> EARRING_BOMB = ITEMS.register("earring_bomb",
            () -> new BaseExplosiveItem(new Item.Properties(), 1).AddToTabList(RangerTabs.GORANGER));
    public static final DeferredItem<Item> MOMO_MIRROR = ITEMS.register("momo_mirror",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.GORANGER));

    public static final DeferredItem<BaseBlasterItem> MIDO_PUNCHER = ITEMS.register("mido_puncher",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 2, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.GORANGER).ChangeRepairItem(GORANGER_LOGO.get()));
    public static final DeferredItem<BaseThrowableItem> MIDOMERANG = ITEMS.register("midomerang",
            () -> new BaseThrowableItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.GORANGER).ChangeRepairItem(GORANGER_LOGO.get()));
    public static final DeferredItem<BaseThrowableItem> NEW_MIDOMERANG = ITEMS.register("new_midomerang",
            () -> new BaseThrowableItem(Tiers.DIAMOND, 12, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.GORANGER).ChangeRepairItem(GORANGER_LOGO.get()));
*/
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}