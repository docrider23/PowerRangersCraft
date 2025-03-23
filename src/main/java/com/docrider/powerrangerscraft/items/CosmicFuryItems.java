package com.docrider.powerrangerscraft.items;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.effect.EffectCore;
import com.docrider.powerrangerscraft.items.cosmic_fury.CosmicMorpherItem;
import com.docrider.powerrangerscraft.items.others.*;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CosmicFuryItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PowerRangersCraftCore.MODID);

    public static final DeferredItem<Item> COSMIC_FURY_LOGO = ITEMS.register("cosmic_fury_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.COSMIC_FURY));

    public static final DeferredItem<Item> EMPTY_COSMIC_ORB = ITEMS.register("empty_cosmic_orb",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.COSMIC_FURY));

    public static final DeferredItem<Item> ANKYLO_COSMIC_ORB = ITEMS.register("ankylo_cosmic_orb",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","cosmic_fury_red","cosmic_fury_red_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(EffectCore.SLASH, 40, 2,true,false))
                    .alsoChange2ndSlot(OtherItems.BLANK_FORM.get()).ChangeBeltModel("geo/rangerbeltchanger.geo.json").AddToTabList(RangerTabs.COSMIC_FURY));

    public static final DeferredItem<Item> TRICERA_COSMIC_ORB = ITEMS.register("tricera_cosmic_orb",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","cosmic_fury_blue","cosmic_fury_blue_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
                    new MobEffectInstance(EffectCore.SLASH, 40, 3,true,false))
                    .alsoChange2ndSlot(OtherItems.BLANK_FORM.get()).ChangeBeltModel("geo/rangerbeltchanger.geo.json").AddToTabList(RangerTabs.COSMIC_FURY));

    public static final DeferredItem<Item> TIGER_COSMIC_ORB = ITEMS.register("tiger_cosmic_orb",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","cosmic_fury_green","cosmic_fury_green_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
                    new MobEffectInstance(EffectCore.SLASH, 40, 2,true,false))
                    .alsoChange2ndSlot(OtherItems.BLANK_FORM.get()).ChangeBeltModel("geo/rangerbeltchanger.geo.json").AddToTabList(RangerTabs.COSMIC_FURY));

    public static final DeferredItem<Item> STEGO_COSMIC_ORB = ITEMS.register("stego_cosmic_orb",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","cosmic_fury_black","cosmic_fury_black_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
                    new MobEffectInstance(EffectCore.SLASH, 40, 2,true,false))
                    .alsoChange2ndSlot(OtherItems.BLANK_FORM.get()).ChangeBeltModel("geo/rangerbeltchanger.geo.json").AddToTabList(RangerTabs.COSMIC_FURY));

    public static final DeferredItem<Item> MOSA_COSMIC_ORB = ITEMS.register("mosa_cosmic_orb",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","cosmic_fury_gold","cosmic_fury_gold_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 2,true,false))
                    .alsoChange2ndSlot(OtherItems.BLANK_FORM.get()).ChangeBeltModel("geo/rangerbeltchanger.geo.json").AddToTabList(RangerTabs.COSMIC_FURY));

    public static final DeferredItem<Item> SOLONO_COSMIC_ORB = ITEMS.register("solono_cosmic_orb",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","cosmic_fury_orange","cosmic_fury_orange_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
                    new MobEffectInstance(EffectCore.SLASH, 40, 2,true,false))
                    .alsoChange2ndSlot(OtherItems.BLANK_FORM.get()).ChangeBeltModel("geo/rangerbeltchanger.geo.json").AddToTabList(RangerTabs.COSMIC_FURY));

    public static final DeferredItem<Item> T_REX_COSMIC_ORB = ITEMS.register("t_rex_cosmic_orb",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","cosmic_fury_zenith","cosmic_fury_zenith_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
                    new MobEffectInstance(EffectCore.SLASH, 40, 2,true,false))
                    .alsoChange2ndSlot(OtherItems.BLANK_FORM.get()).ChangeBeltModel("geo/rangerbeltchanger.geo.json").AddToTabList(RangerTabs.COSMIC_FURY));

    public static final DeferredItem<Item> COSMIC_FURY_HELMET = ITEMS.register("cosmic_fury_head",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RangerTabs.COSMIC_FURY).ChangeRepairItem(EMPTY_COSMIC_ORB.get()));
    public static final DeferredItem<Item> COSMIC_FURY_CHESTPLATE = ITEMS.register("cosmic_fury_torso",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RangerTabs.COSMIC_FURY).ChangeRepairItem(EMPTY_COSMIC_ORB.get()));
    public static final DeferredItem<Item> COSMIC_FURY_LEGGINGS = ITEMS.register("cosmic_fury_legs",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RangerTabs.COSMIC_FURY).ChangeRepairItem(EMPTY_COSMIC_ORB.get()));

    public static final DeferredItem<Item> RED_COSMIC_MORPHER = ITEMS.register("red_cosmic_morpher",
            () -> new CosmicMorpherItem(ArmorMaterials.DIAMOND,"cosmic_fury_red", ANKYLO_COSMIC_ORB,COSMIC_FURY_HELMET,COSMIC_FURY_CHESTPLATE,COSMIC_FURY_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.COSMIC_FURY).ChangeRepairItem(EMPTY_COSMIC_ORB.get()));
    public static final DeferredItem<Item> BLUE_COSMIC_MORPHER = ITEMS.register("blue_cosmic_morpher",
            () -> new CosmicMorpherItem(ArmorMaterials.DIAMOND,"cosmic_fury_blue", TRICERA_COSMIC_ORB,COSMIC_FURY_HELMET,COSMIC_FURY_CHESTPLATE,COSMIC_FURY_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.COSMIC_FURY).ChangeRepairItem(EMPTY_COSMIC_ORB.get()));
    public static final DeferredItem<Item> GREEN_COSMIC_MORPHER = ITEMS.register("green_cosmic_morpher",
            () -> new CosmicMorpherItem(ArmorMaterials.DIAMOND,"cosmic_fury_green", TIGER_COSMIC_ORB,COSMIC_FURY_HELMET,COSMIC_FURY_CHESTPLATE,COSMIC_FURY_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.COSMIC_FURY).ChangeRepairItem(EMPTY_COSMIC_ORB.get()));
    public static final DeferredItem<Item> BLACK_COSMIC_MORPHER = ITEMS.register("black_cosmic_morpher",
            () -> new CosmicMorpherItem(ArmorMaterials.DIAMOND,"cosmic_fury_black", STEGO_COSMIC_ORB,COSMIC_FURY_HELMET,COSMIC_FURY_CHESTPLATE,COSMIC_FURY_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.COSMIC_FURY).ChangeRepairItem(EMPTY_COSMIC_ORB.get()));
    public static final DeferredItem<Item> GOLD_COSMIC_MORPHER = ITEMS.register("gold_cosmic_morpher",
            () -> new CosmicMorpherItem(ArmorMaterials.DIAMOND,"cosmic_fury_gold", MOSA_COSMIC_ORB,COSMIC_FURY_HELMET,COSMIC_FURY_CHESTPLATE,COSMIC_FURY_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.COSMIC_FURY).ChangeRepairItem(EMPTY_COSMIC_ORB.get()));
    public static final DeferredItem<Item> ORANGE_COSMIC_MORPHER = ITEMS.register("orange_cosmic_morpher",
            () -> new CosmicMorpherItem(ArmorMaterials.DIAMOND,"cosmic_fury_orange", SOLONO_COSMIC_ORB,COSMIC_FURY_HELMET,COSMIC_FURY_CHESTPLATE,COSMIC_FURY_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.COSMIC_FURY).ChangeRepairItem(EMPTY_COSMIC_ORB.get()));
    public static final DeferredItem<Item> ZENITH_COSMIC_MORPHER = ITEMS.register("zenith_cosmic_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"cosmic_fury_zenith", T_REX_COSMIC_ORB,COSMIC_FURY_HELMET,COSMIC_FURY_CHESTPLATE,COSMIC_FURY_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.COSMIC_FURY).ChangeRepairItem(EMPTY_COSMIC_ORB.get()));

    public static final DeferredItem<BaseBlasterItem> COSMIC_BLASTER = ITEMS.register("cosmic_blaster",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.COSMIC_FURY).ChangeRepairItem(EMPTY_COSMIC_ORB.get()));

    public static final DeferredItem<SwordItem> ANKYLO_HAMMER = ITEMS.register("ankylo_hammer",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.COSMIC_FURY).ChangeRepairItem(EMPTY_COSMIC_ORB.get()));
    public static final DeferredItem<BaseBlasterItem> TRICERA_BLASTER = ITEMS.register("tricera_blaster",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.COSMIC_FURY).ChangeRepairItem(EMPTY_COSMIC_ORB.get()));
    public static final DeferredItem<SwordItem> TIGER_CLAW_DAGGER = ITEMS.register("tiger_claw_dagger",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.COSMIC_FURY).ChangeRepairItem(EMPTY_COSMIC_ORB.get()));
    public static final DeferredItem<SwordItem> STEGO_SPIKE_AXE = ITEMS.register("stego_spike_axe",
            () -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.COSMIC_FURY).ChangeRepairItem(EMPTY_COSMIC_ORB.get()));
    public static final DeferredItem<BaseBlasterItem> MOSA_RAZOR_BLASTER = ITEMS.register("mosa_razor_blaster",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).IsSwordGun().AddToTabList(RangerTabs.COSMIC_FURY).ChangeRepairItem(EMPTY_COSMIC_ORB.get()));
    public static final DeferredItem<SwordItem> SOLONO_CLAW = ITEMS.register("solono_claw",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.COSMIC_FURY).ChangeRepairItem(EMPTY_COSMIC_ORB.get()));

    public static final DeferredItem<BaseBlasterItem> MASTERS_STAFF = ITEMS.register("masters_staff",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).IsSwordGun().AddToTabList(RangerTabs.COSMIC_FURY).KeepItem().ChangeRepairItem(EMPTY_COSMIC_ORB.get()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
