package com.docrider.powerrangerscraft.items;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.effect.EffectCore;
import com.docrider.powerrangerscraft.items.mmpr.MMPRBeltItem;
import com.docrider.powerrangerscraft.items.others.*;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MMPRItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PowerRangersCraftCore.MODID);

    public static String[] RANGERS= new String[] {"mmpr_red","mmpr_blue","mmpr_pink","mmpr_black","mmpr_yellow","samurai_green"};

    public static final DeferredItem<Item> MMPR_LOGO = ITEMS.register("mmpr_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.MMPR));

    public static final DeferredItem<Item> TYRANNOSAURUS_POWER_COIN = ITEMS.register("tyrannosaurus_power_coin",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","mmpr_red","mmpr_red_belt")
                    .ChangeBeltModel("geo/mmpr_belt.geo.json").AddToTabList(RangerTabs.MMPR));

    public static final DeferredItem<Item> MASTODON_POWER_COIN = ITEMS.register("mastodon_power_coin",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","mmpr_black","mmpr_black_belt")
                    .ChangeBeltModel("geo/mmpr_belt.geo.json").AddToTabList(RangerTabs.MMPR));

    public static final DeferredItem<Item> TRICERATOPS_POWER_COIN = ITEMS.register("triceratops_power_coin",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","mmpr_blue","mmpr_blue_belt")
                    .ChangeBeltModel("geo/mmpr_belt.geo.json").AddToTabList(RangerTabs.MMPR));

    public static final DeferredItem<Item> SABERTOOTH_TIGER_POWER_COIN = ITEMS.register("sabertooth_tiger_power_coin",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","mmpr_yellow","mmpr_yellow_belt")
                    .ChangeBeltModel("geo/mmpr_belt.geo.json").AddToTabList(RangerTabs.MMPR));

    public static final DeferredItem<Item> PTERADACTYL_POWER_COIN = ITEMS.register("pteradactyl_power_coin",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","mmpr_pink","mmpr_pink_belt")
                    .ChangeBeltModel("geo/mmpr_belt.geo.json").AddToTabList(RangerTabs.MMPR));

    public static final DeferredItem<Item> DRAGON_POWER_COIN_OTHERS = ITEMS.register("dragon_power_coin_others",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"dragon_shield","","blank",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,40,1,true,true))
                    .ChangeSlot(2).AddCompatibilityList(RANGERS));
    public static final DeferredItem<Item> DRAGON_POWER_COIN_NO_SHIELD = ITEMS.register("dragon_power_coin_no_shield",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"_no_shield","mmpr_green","mmpr_green_belt")
                    .ChangeBeltModel("geo/mmpr_belt.geo.json").addAlternative(DRAGON_POWER_COIN_OTHERS.get()));
    public static final DeferredItem<Item> DRAGON_POWER_COIN = ITEMS.register("dragon_power_coin",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","mmpr_green","mmpr_green_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,40,1,true,true))
                    .ChangeBeltModel("geo/mmpr_belt.geo.json").addAlternative(DRAGON_POWER_COIN_NO_SHIELD.get()).AddToTabList(RangerTabs.MMPR));

    public static final DeferredItem<Item> WHITE_TIGER_POWER_COIN = ITEMS.register("white_tiger_power_coin",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","mmpr_white","mmpr_white_belt")
                    .AddToTabList(RangerTabs.MMPR));

    public static final DeferredItem<Item> REINDEER_POWER_COIN = ITEMS.register("reindeer_power_coin",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","santa_ranger","santa_ranger_belt",
                    new MobEffectInstance(EffectCore.CHRISTMAS,40,1,true,true))
                    .SetShowUnder().ChangeBeltModel("geo/mmpr_belt.geo.json").AddToTabList(RangerTabs.MMPR));

    public static final DeferredItem<Item> MMPR_HELMET = ITEMS.register("mmpr_head",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RangerTabs.MMPR).ChangeRepairItem(MMPR_LOGO.get()));
    public static final DeferredItem<Item> MMPR_CHESTPLATE = ITEMS.register("mmpr_torso",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RangerTabs.MMPR).ChangeRepairItem(MMPR_LOGO.get()));
    public static final DeferredItem<Item> MMPR_LEGGINGS = ITEMS.register("mmpr_legs",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RangerTabs.MMPR).ChangeRepairItem(MMPR_LOGO.get()));

    public static final DeferredItem<Item> RED_POWER_MORPHER = ITEMS.register("red_power_morpher",
            () -> new MMPRBeltItem(ArmorMaterials.DIAMOND,"mmpr_red",TYRANNOSAURUS_POWER_COIN,MMPR_HELMET,MMPR_CHESTPLATE,MMPR_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.MMPR).ChangeRepairItem(MMPR_LOGO.get()));
    public static final DeferredItem<Item> BLACK_POWER_MORPHER = ITEMS.register("black_power_morpher",
            () -> new MMPRBeltItem(ArmorMaterials.DIAMOND,"mmpr_black",MASTODON_POWER_COIN,MMPR_HELMET,MMPR_CHESTPLATE,MMPR_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.MMPR).ChangeRepairItem(MMPR_LOGO.get()));
    public static final DeferredItem<Item> BLUE_POWER_MORPHER = ITEMS.register("blue_power_morpher",
            () -> new MMPRBeltItem(ArmorMaterials.DIAMOND,"mmpr_blue", TRICERATOPS_POWER_COIN,MMPR_HELMET,MMPR_CHESTPLATE,MMPR_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.MMPR).ChangeRepairItem(MMPR_LOGO.get()));
    public static final DeferredItem<Item> YELLOW_POWER_MORPHER = ITEMS.register("yellow_power_morpher",
            () -> new MMPRBeltItem(ArmorMaterials.DIAMOND,"mmpr_yellow", SABERTOOTH_TIGER_POWER_COIN,MMPR_HELMET,MMPR_CHESTPLATE,MMPR_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.MMPR).ChangeRepairItem(MMPR_LOGO.get()));
    public static final DeferredItem<Item> PINK_POWER_MORPHER = ITEMS.register("pink_power_morpher",
            () -> new MMPRBeltItem(ArmorMaterials.DIAMOND,"mmpr_pink", PTERADACTYL_POWER_COIN,MMPR_HELMET,MMPR_CHESTPLATE,MMPR_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.MMPR).ChangeRepairItem(MMPR_LOGO.get()));
    public static final DeferredItem<Item> GREEN_POWER_MORPHER = ITEMS.register("green_power_morpher",
            () -> new MMPRBeltItem(ArmorMaterials.DIAMOND,"mmpr_green", DRAGON_POWER_COIN,MMPR_HELMET,MMPR_CHESTPLATE,MMPR_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.MMPR).ChangeRepairItem(MMPR_LOGO.get()));
    public static final DeferredItem<Item> WHITE_POWER_MORPHER = ITEMS.register("white_power_morpher",
            () -> new MMPRBeltItem(ArmorMaterials.DIAMOND,"mmpr_white", WHITE_TIGER_POWER_COIN,MMPR_HELMET,MMPR_CHESTPLATE,MMPR_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.MMPR).ChangeRepairItem(MMPR_LOGO.get()));
    public static final DeferredItem<Item> SANTA_POWER_MORPHER = ITEMS.register("santa_power_morpher",
            () -> new MMPRBeltItem(ArmorMaterials.DIAMOND,"santa_ranger", REINDEER_POWER_COIN,MMPR_HELMET,MMPR_CHESTPLATE,MMPR_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.MMPR).ChangeRepairItem(MMPR_LOGO.get()));

    public static final DeferredItem<SwordItem> BLADE_BLASTER = ITEMS.register("blade_blaster",
            () -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.MMPR).ChangeRepairItem(MMPR_LOGO.get()));
/*    public static final DeferredItem<PickaxeItem> DRILL_BUTE = ITEMS.register("drill_bute",
            () -> new BasePickaxeItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.GORANGER).ChangeRepairItem(GORANGER_LOGO.get()));
    public static final DeferredItem<BaseBlasterItem> SILVER_SHOT = ITEMS.register("silver_shot",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.GORANGER).ChangeRepairItem(GORANGER_LOGO.get()));
*/
    public static final DeferredItem<BaseBlasterItem> POWER_AXE = ITEMS.register("power_axe",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 2, -2.4F, new Item.Properties()).IsSwordGun().AddToTabList(RangerTabs.MMPR).ChangeRepairItem(MMPR_LOGO.get()));


    public static final DeferredItem<SwordItem> POWER_LANCE = ITEMS.register("power_lance",
            () -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.MMPR).ChangeRepairItem(MMPR_LOGO.get()));
    public static final DeferredItem<SwordItem> POWER_LANCE_TRIDENT = ITEMS.register("power_lance_trident",
            () -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.MMPR).ChangeRepairItem(MMPR_LOGO.get()));

/*
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