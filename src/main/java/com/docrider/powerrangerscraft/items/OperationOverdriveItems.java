package com.docrider.powerrangerscraft.items;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.effect.EffectCore;
import com.docrider.powerrangerscraft.entity.MobsCore;
import com.docrider.powerrangerscraft.items.operation_overdrive.*;
import com.docrider.powerrangerscraft.items.others.*;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class OperationOverdriveItems {
    public static String[] RANGERS = new String[] {"overdrive_red","overdrive_black","overdrive_blue","overdrive_yellow","overdrive_pink","mercury_ranger","mmpr_black"};

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PowerRangersCraftCore.MODID);

    public static final DeferredItem<Item> OPERATION_OVERDRIVE_LOGO = ITEMS.register("operation_overdrive_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.OPERATION_OVERDRIVE));

    public static final DeferredItem<Item> OVERDRIVE_RED_LOGO = ITEMS.register("overdrive_red_logo",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","overdrive_red","operation_overdrive_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false))
                    .alsoChange2ndSlot(OtherItems.BLANK_FORM.get()).ChangeBeltModel("geo/rangerbeltextra.geo.json").IsGlowing().AddToTabList(RangerTabs.OPERATION_OVERDRIVE));
    public static final DeferredItem<Item> OVERDRIVE_BLACK_LOGO = ITEMS.register("overdrive_black_logo",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","overdrive_black","operation_overdrive_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false))
                    .alsoChange2ndSlot(OtherItems.BLANK_FORM.get()).ChangeBeltModel("geo/rangerbeltextra.geo.json").IsGlowing().AddToTabList(RangerTabs.OPERATION_OVERDRIVE));
    public static final DeferredItem<Item> OVERDRIVE_BLUE_LOGO = ITEMS.register("overdrive_blue_logo",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","overdrive_blue","operation_overdrive_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
                    new MobEffectInstance(EffectCore.SHOTBOOST, 40, 2,true,false))
                    .alsoChange2ndSlot(OtherItems.BLANK_FORM.get()).ChangeBeltModel("geo/rangerbeltextra.geo.json").IsGlowing().AddToTabList(RangerTabs.OPERATION_OVERDRIVE));
    public static final DeferredItem<Item> OVERDRIVE_YELLOW_LOGO = ITEMS.register("overdrive_yellow_logo",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","overdrive_yellow","operation_overdrive_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false))
                    .alsoChange2ndSlot(OtherItems.BLANK_FORM.get()).ChangeBeltModel("geo/rangerbeltextra.geo.json").IsGlowing().AddToTabList(RangerTabs.OPERATION_OVERDRIVE));
    public static final DeferredItem<Item> OVERDRIVE_PINK_LOGO = ITEMS.register("overdrive_pink_logo",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","overdrive_pink","operation_overdrive_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 2,true,false))
                    .alsoChange2ndSlot(OtherItems.BLANK_FORM.get()).ChangeBeltModel("geo/rangerbeltextra.geo.json").IsGlowing().AddToTabList(RangerTabs.OPERATION_OVERDRIVE));
    public static final DeferredItem<Item> MERCURY_RANGER_LOGO = ITEMS.register("mercury_ranger_logo",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","mercury_ranger","mercury_ranger_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 2,true,false))
                    .alsoChange2ndSlot(OtherItems.BLANK_FORM.get()).ChangeBeltModel("geo/rangerbeltextra1.geo.json").IsGlowing().AddToTabList(RangerTabs.OPERATION_OVERDRIVE));

    public static final DeferredItem<Item> UNFINISHED_SENTINEL_SWORD = ITEMS.register("unfinished_sentinel_sword",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","sentinel_knight","blank",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 2,true,false)).AddToTabList(RangerTabs.OPERATION_OVERDRIVE));

    public static final DeferredItem<Item> DRAGON_SCALE = ITEMS.register("dragon_scale",
            () -> new BaseItem(new Item.Properties().rarity(Rarity.RARE)).AddToTabList(RangerTabs.OPERATION_OVERDRIVE));

        public static final DeferredItem<Item> DEFENDER_VEST = ITEMS.register("defender_vest",
            () -> new RangerFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"overdrive_defender_vest","","operation_overdrive_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false))
                    .ChangeSlot(2).BackToBase().AddCompatibilityList(RANGERS).AddToTabList(RangerTabs.OPERATION_OVERDRIVE));

    public static final DeferredItem<Item> OPERATION_OVERDRIVE_HELMET = ITEMS.register("operation_overdrive_head",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RangerTabs.OPERATION_OVERDRIVE).ChangeRepairItem(OPERATION_OVERDRIVE_LOGO.get()));
    public static final DeferredItem<Item> OPERATION_OVERDRIVE_CHESTPLATE = ITEMS.register("operation_overdrive_torso",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RangerTabs.OPERATION_OVERDRIVE).ChangeRepairItem(OPERATION_OVERDRIVE_LOGO.get()));
    public static final DeferredItem<Item> OPERATION_OVERDRIVE_LEGGINGS = ITEMS.register("operation_overdrive_legs",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RangerTabs.OPERATION_OVERDRIVE).ChangeRepairItem(OPERATION_OVERDRIVE_LOGO.get()));

    public static final DeferredItem<Item> RED_OVERDRIVE_TRACKER = ITEMS.register("red_overdrive_tracker",
            () -> new OverdriveTrackerItem(ArmorMaterials.DIAMOND,"overdrive_red", OVERDRIVE_RED_LOGO, OPERATION_OVERDRIVE_HELMET, OPERATION_OVERDRIVE_CHESTPLATE, OPERATION_OVERDRIVE_LEGGINGS,new Item.Properties())
                    .Add_Extra_Base_Form_Items(OtherItems.BLANK_FORM).AddToTabList(RangerTabs.OPERATION_OVERDRIVE).ChangeRepairItem(OPERATION_OVERDRIVE_LOGO.get()));
    public static final DeferredItem<Item> BLACK_OVERDRIVE_TRACKER = ITEMS.register("black_overdrive_tracker",
            () -> new OverdriveTrackerItem(ArmorMaterials.DIAMOND,"overdrive_black", OVERDRIVE_BLACK_LOGO, OPERATION_OVERDRIVE_HELMET, OPERATION_OVERDRIVE_CHESTPLATE, OPERATION_OVERDRIVE_LEGGINGS,new Item.Properties())
                    .Add_Extra_Base_Form_Items(OtherItems.BLANK_FORM).AddToTabList(RangerTabs.OPERATION_OVERDRIVE).ChangeRepairItem(OPERATION_OVERDRIVE_LOGO.get()));
    public static final DeferredItem<Item> BLUE_OVERDRIVE_TRACKER = ITEMS.register("blue_overdrive_tracker",
            () -> new OverdriveTrackerItem(ArmorMaterials.DIAMOND,"overdrive_blue", OVERDRIVE_BLUE_LOGO, OPERATION_OVERDRIVE_HELMET, OPERATION_OVERDRIVE_CHESTPLATE, OPERATION_OVERDRIVE_LEGGINGS,new Item.Properties())
                    .Add_Extra_Base_Form_Items(OtherItems.BLANK_FORM).AddToTabList(RangerTabs.OPERATION_OVERDRIVE).ChangeRepairItem(OPERATION_OVERDRIVE_LOGO.get()));
    public static final DeferredItem<Item> YELLOW_OVERDRIVE_TRACKER = ITEMS.register("yellow_overdrive_tracker",
            () -> new OverdriveTrackerItem(ArmorMaterials.DIAMOND,"overdrive_yellow", OVERDRIVE_YELLOW_LOGO, OPERATION_OVERDRIVE_HELMET, OPERATION_OVERDRIVE_CHESTPLATE, OPERATION_OVERDRIVE_LEGGINGS,new Item.Properties())
                    .Add_Extra_Base_Form_Items(OtherItems.BLANK_FORM).AddToTabList(RangerTabs.OPERATION_OVERDRIVE).ChangeRepairItem(OPERATION_OVERDRIVE_LOGO.get()));
    public static final DeferredItem<Item> PINK_OVERDRIVE_TRACKER = ITEMS.register("pink_overdrive_tracker",
            () -> new OverdriveTrackerItem(ArmorMaterials.DIAMOND,"overdrive_pink", OVERDRIVE_PINK_LOGO, OPERATION_OVERDRIVE_HELMET, OPERATION_OVERDRIVE_CHESTPLATE, OPERATION_OVERDRIVE_LEGGINGS,new Item.Properties())
                    .Add_Extra_Base_Form_Items(OtherItems.BLANK_FORM).AddToTabList(RangerTabs.OPERATION_OVERDRIVE).ChangeRepairItem(OPERATION_OVERDRIVE_LOGO.get()));
    public static final DeferredItem<Item> MERCURY_MORPHER = ITEMS.register("mercury_morpher",
            () -> new MercuryMorpherItem(ArmorMaterials.DIAMOND,"mercury_ranger", MERCURY_RANGER_LOGO, OPERATION_OVERDRIVE_HELMET, OPERATION_OVERDRIVE_CHESTPLATE, OPERATION_OVERDRIVE_LEGGINGS,new Item.Properties())
                    .Add_Extra_Base_Form_Items(OtherItems.BLANK_FORM).AddToTabList(RangerTabs.OPERATION_OVERDRIVE).ChangeRepairItem(OPERATION_OVERDRIVE_LOGO.get()));
    public static final DeferredItem<Item> SENTINEL_KNIGHT_CHESTPIECE = ITEMS.register("sentinel_knight_chestpiece",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"sentinel_knight",UNFINISHED_SENTINEL_SWORD,OPERATION_OVERDRIVE_HELMET,OPERATION_OVERDRIVE_CHESTPLATE,OPERATION_OVERDRIVE_LEGGINGS,new Item.Properties())
                    .Add_Extra_Base_Form_Items(OtherItems.BLANK_FORM).AddToTabList(RangerTabs.OPERATION_OVERDRIVE).ChangeRepairItem(OPERATION_OVERDRIVE_LOGO.get()));

    public static final DeferredItem<Item> SENTINEL_MORPHER_HYPERFORCE = ITEMS.register("sentinel_morpher_hyperforce",
            () -> new RangerFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"_sentinel","hyperforce_black","blank",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false))
                    .ChangeModel("sentinel_ranger.geo.json"));
    public static final DeferredItem<Item> SENTINEL_MORPHER = ITEMS.register("sentinel_morpher",
            () -> new RangerFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"_sentinel","overdrive_red","blank",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false))
                    .BackToBase().addAlternative(SENTINEL_MORPHER_HYPERFORCE.get())
                    .ChangeModel("sentinel_ranger.geo.json").KeepItem().AddToTabList(RangerTabs.OPERATION_OVERDRIVE));

    public static final DeferredItem<BaseBlasterItem> DRIVE_DEFENDER = ITEMS.register("drive_defender",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).IsSwordGun().AddToTabList(RangerTabs.OPERATION_OVERDRIVE).ChangeRepairItem(OPERATION_OVERDRIVE_LOGO.get()));

    public static final DeferredItem<SwordItem> DRIVE_LANCE = ITEMS.register("drive_lance",
            () -> new BaseDualSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).IsDualWeapon().AddToTabList(RangerTabs.OPERATION_OVERDRIVE).ChangeRepairItem(OPERATION_OVERDRIVE_LOGO.get()));

    public static final DeferredItem<SwordItem> DRIVE_SLAMMER = ITEMS.register("drive_slammer",
            () -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.OPERATION_OVERDRIVE).ChangeRepairItem(OPERATION_OVERDRIVE_LOGO.get()));

    public static final DeferredItem<BaseBlasterItem> DRIVE_VORTEX = ITEMS.register("drive_vortex",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).setProjectile(BaseBlasterItem.BlasterProjectile.WIND_CHARGE).AddToTabList(RangerTabs.OPERATION_OVERDRIVE).ChangeRepairItem(OPERATION_OVERDRIVE_LOGO.get()));

    public static final DeferredItem<SwordItem> DRIVE_CLAW = ITEMS.register("drive_claw",
            () -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.OPERATION_OVERDRIVE).ChangeRepairItem(OPERATION_OVERDRIVE_LOGO.get()));
    public static final DeferredItem<SwordItem> DRIVE_CLAW1 = ITEMS.register("drive_claw1",
            () -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.OPERATION_OVERDRIVE).ChangeRepairItem(OPERATION_OVERDRIVE_LOGO.get()));

    public static final DeferredItem<BaseBlasterItem> DRIVE_GEYSER = ITEMS.register("drive_geyser",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.OPERATION_OVERDRIVE).ChangeRepairItem(OPERATION_OVERDRIVE_LOGO.get()));

    public static final DeferredItem<BaseBlasterItem> DRIVE_DETECTOR = ITEMS.register("drive_detector_spear",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).IsSwordGun().AddToTabList(RangerTabs.OPERATION_OVERDRIVE).ChangeRepairItem(OPERATION_OVERDRIVE_LOGO.get()));

    public static final DeferredItem<BaseBlasterItem> DRILL_BLASTER = ITEMS.register("drill_blaster_mixer",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).IsSuperGun().IsDualWeapon().AddToTabList(RangerTabs.OPERATION_OVERDRIVE).ChangeRepairItem(OPERATION_OVERDRIVE_LOGO.get()));

    public static final DeferredItem<SwordItem> SENTINEL_SWORD = ITEMS.register("sentinel_sword",
            () -> new SentinelSwordItem(Tiers.DIAMOND, 12, -2.4F, new Item.Properties(), MobsCore.SENTINEL_KNIGHT).KeepItem().AddToTabList(RangerTabs.OPERATION_OVERDRIVE).ChangeRepairItem(OPERATION_OVERDRIVE_LOGO.get()));

    public static final DeferredItem<SwordItem> SENTINEL_RANGER_SWORD = ITEMS.register("sentinel_ranger_sword",
            () -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.OPERATION_OVERDRIVE).ChangeRepairItem(OPERATION_OVERDRIVE_LOGO.get()));
    public static final DeferredItem<SwordItem> SENTINEL_RANGER_SWORD1 = ITEMS.register("sentinel_ranger_sword1",
            () -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.OPERATION_OVERDRIVE).ChangeRepairItem(OPERATION_OVERDRIVE_LOGO.get()));

    public static final DeferredItem<Item> BROWNBEARDS_LUCKY_PEARL = ITEMS.register("brownbeards_lucky_pearl",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.OPERATION_OVERDRIVE));
    public static final DeferredItem<Item> TORU_DIAMOND = ITEMS.register("toru_diamond",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.OPERATION_OVERDRIVE));
    public static final DeferredItem<Item> BLUE_SAPPHIRE = ITEMS.register("blue_sapphire",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.OPERATION_OVERDRIVE));
    public static final DeferredItem<Item> STAR_OF_ISIS = ITEMS.register("star_of_isis",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.OPERATION_OVERDRIVE));
    public static final DeferredItem<Item> PINK_EMERALD = ITEMS.register("pink_emerald",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.OPERATION_OVERDRIVE));

    public static final DeferredItem<Item> BLACK_JEWEL = ITEMS.register("black_jewel",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.OPERATION_OVERDRIVE));
    public static final DeferredItem<Item> YELLOW_JEWEL = ITEMS.register("yellow_jewel",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.OPERATION_OVERDRIVE));
    public static final DeferredItem<Item> BLUE_JEWEL = ITEMS.register("blue_jewel",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.OPERATION_OVERDRIVE));
    public static final DeferredItem<Item> RED_JEWEL = ITEMS.register("red_jewel",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.OPERATION_OVERDRIVE));
    public static final DeferredItem<Item> PINK_JEWEL = ITEMS.register("pink_jewel",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.OPERATION_OVERDRIVE));

    public static final DeferredItem<Item> Z_EMBLEM_THRAX = ITEMS.register("z_emblem_thrax",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","thrax","blank")
                    .ChangeModel("thrax.geo.json"));
    public static final DeferredItem<Item> THRAX_CODPIECE = ITEMS.register("thrax_codpiece",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"thrax", Z_EMBLEM_THRAX, OPERATION_OVERDRIVE_HELMET, OPERATION_OVERDRIVE_CHESTPLATE, OPERATION_OVERDRIVE_LEGGINGS,new Item.Properties()).ChangeRepairItem(OPERATION_OVERDRIVE_LOGO.get()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
