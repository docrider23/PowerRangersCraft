package com.docrider.powerrangerscraft.items;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.effect.EffectCore;
import com.docrider.powerrangerscraft.items.in_space.AstroMorpherItem;
import com.docrider.powerrangerscraft.items.in_space.BattlizerGauntletItem;
import com.docrider.powerrangerscraft.items.others.*;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class InSpaceItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PowerRangersCraftCore.MODID);

    public static final DeferredItem<Item> IN_SPACE_LOGO = ITEMS.register("in_space_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.IN_SPACE));
    public static final DeferredItem<Item> PSYCHO_RANGER_LOGO = ITEMS.register("psycho_ranger_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.IN_SPACE));

    public static final DeferredItem<Item> DATA_CARD = ITEMS.register("data_card",
            () -> new RangerFormChangeItem(new Item.Properties(),"","in_space_silver","psycho_silver_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false))
                    .ChangeRangerName("psycho_silver").AddToTabList(RangerTabs.IN_SPACE));

    public static final DeferredItem<Item> RED_DATA_CARD_SOLAR = ITEMS.register("red_data_card_solar",
            () -> new RangerFormChangeItem(new Item.Properties(),"","solar_red","blank",
                    new MobEffectInstance(EffectCore.SLASH, 40, 1,true,false),
                    new MobEffectInstance(EffectCore.PUNCH, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
                    .isGlowing());
    public static final DeferredItem<Item> RED_DATA_CARD = ITEMS.register("red_data_card",
            () -> new RangerFormChangeItem(new Item.Properties(),"","in_space_red","in_space_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
                    .ResetFormToBase().ChangeBeltModel("geo/rangerbeltextra.geo.json").addAlternative(RED_DATA_CARD_SOLAR.get()).AddToTabList(RangerTabs.IN_SPACE));
    public static final DeferredItem<Item> BLACK_DATA_CARD = ITEMS.register("black_data_card",
            () -> new RangerFormChangeItem(new Item.Properties(),"","in_space_black","in_space_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
                    .ResetFormToBase().ChangeBeltModel("geo/rangerbeltextra.geo.json").AddToTabList(RangerTabs.IN_SPACE));
    public static final DeferredItem<Item> BLUE_DATA_CARD = ITEMS.register("blue_data_card",
            () -> new RangerFormChangeItem(new Item.Properties(),"","mega_blue","in_space_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false))
                    .ResetFormToBase().ChangeBeltModel("geo/rangerbeltextra.geo.json").AddToTabList(RangerTabs.IN_SPACE));
    public static final DeferredItem<Item> YELLOW_DATA_CARD = ITEMS.register("yellow_data_card",
            () -> new RangerFormChangeItem(new Item.Properties(),"","in_space_yellow","in_space_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false))
                    .ResetFormToBase().ChangeBeltModel("geo/rangerbeltextra.geo.json").AddToTabList(RangerTabs.IN_SPACE));
    public static final DeferredItem<Item> PINK_DATA_CARD = ITEMS.register("pink_data_card",
            () -> new RangerFormChangeItem(new Item.Properties(),"","in_space_pink","in_space_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false))
                    .ResetFormToBase().ChangeBeltModel("geo/rangerbeltextra.geo.json").AddToTabList(RangerTabs.IN_SPACE));
    public static final DeferredItem<Item> SILVER_DATA_CARD = ITEMS.register("silver_data_card",
            () -> new RangerFormChangeItem(new Item.Properties(),"","in_space_silver","in_space_silver_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)).AddToTabList(RangerTabs.IN_SPACE));

    public static final DeferredItem<Item> STEALTH_DATA_CARD = ITEMS.register("stealth_data_card",
            () -> new RangerFormChangeItem(new Item.Properties(), "_stealth", "in_space_red", "in_space_belt_stealth").AddToTabList(RangerTabs.IN_SPACE));
    public static final DeferredItem<Item> BATTLIZER_DATA_CARD = ITEMS.register("battlizer_data_card",
            () -> new RangerFormChangeItem(new Item.Properties(),"_battlizer","in_space_red","in_space_belt_battlizer"));

    public static final DeferredItem<Item> IN_SPACE_HELMET = ITEMS.register("in_space_head",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RangerTabs.IN_SPACE).ChangeRepairItem(IN_SPACE_LOGO.get()));
    public static final DeferredItem<Item> IN_SPACE_CHESTPLATE = ITEMS.register("in_space_torso",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RangerTabs.IN_SPACE).ChangeRepairItem(IN_SPACE_LOGO.get()));
    public static final DeferredItem<Item> IN_SPACE_LEGGINGS = ITEMS.register("in_space_legs",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RangerTabs.IN_SPACE).ChangeRepairItem(IN_SPACE_LOGO.get()));

    public static final DeferredItem<Item> RED_ASTRO_MORPHER = ITEMS.register("red_astro_morpher",
            () -> new AstroMorpherItem(ArmorMaterials.DIAMOND,"in_space_red",RED_DATA_CARD,IN_SPACE_HELMET,IN_SPACE_CHESTPLATE,IN_SPACE_LEGGINGS,new Item.Properties()).Add_Extra_Base_Form_Items(OtherItems.BLANK_FORM).AddToTabList(RangerTabs.IN_SPACE).ChangeRepairItem(IN_SPACE_LOGO.get()));
    public static final DeferredItem<Item> BLACK_ASTRO_MORPHER = ITEMS.register("black_astro_morpher",
            () -> new AstroMorpherItem(ArmorMaterials.DIAMOND,"in_space_black",BLACK_DATA_CARD,IN_SPACE_HELMET,IN_SPACE_CHESTPLATE,IN_SPACE_LEGGINGS,new Item.Properties())
                    .Add_Extra_Base_Form_Items(OtherItems.BLANK_FORM).AddToTabList(RangerTabs.IN_SPACE).ChangeRepairItem(IN_SPACE_LOGO.get()));
    public static final DeferredItem<Item> BLUE_ASTRO_MORPHER = ITEMS.register("blue_astro_morpher",
            () -> new AstroMorpherItem(ArmorMaterials.DIAMOND,"in_space_blue",BLUE_DATA_CARD,IN_SPACE_HELMET,IN_SPACE_CHESTPLATE,IN_SPACE_LEGGINGS,new Item.Properties())
                    .Add_Extra_Base_Form_Items(OtherItems.BLANK_FORM).AddToTabList(RangerTabs.IN_SPACE).ChangeRepairItem(IN_SPACE_LOGO.get()));
    public static final DeferredItem<Item> YELLOW_ASTRO_MORPHER = ITEMS.register("yellow_astro_morpher",
            () -> new AstroMorpherItem(ArmorMaterials.DIAMOND,"in_space_yellow",YELLOW_DATA_CARD,IN_SPACE_HELMET,IN_SPACE_CHESTPLATE,IN_SPACE_LEGGINGS,new Item.Properties())
                    .Add_Extra_Base_Form_Items(OtherItems.BLANK_FORM).AddToTabList(RangerTabs.IN_SPACE).ChangeRepairItem(IN_SPACE_LOGO.get()));
    public static final DeferredItem<Item> PINK_ASTRO_MORPHER = ITEMS.register("pink_astro_morpher",
            () -> new AstroMorpherItem(ArmorMaterials.DIAMOND,"in_space_pink",PINK_DATA_CARD,IN_SPACE_HELMET,IN_SPACE_CHESTPLATE,IN_SPACE_LEGGINGS,new Item.Properties())
                    .Add_Extra_Base_Form_Items(OtherItems.BLANK_FORM).AddToTabList(RangerTabs.IN_SPACE).ChangeRepairItem(IN_SPACE_LOGO.get()));
    public static final DeferredItem<Item> DIGIMORPHER = ITEMS.register("digimorpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"in_space_silver",SILVER_DATA_CARD,IN_SPACE_HELMET,IN_SPACE_CHESTPLATE,IN_SPACE_LEGGINGS,new Item.Properties()).Dont_show_belt_form_info().AddToTabList(RangerTabs.IN_SPACE).ChangeRepairItem(IN_SPACE_LOGO.get()));

    public static final DeferredItem<Item> BATTLIZER_GAUNTLET = ITEMS.register("battlizer_gauntlet",
            () -> new BattlizerGauntletItem(new Item.Properties()).AddToTabList(RangerTabs.IN_SPACE));

    public static final DeferredItem<BaseBlasterItem> ASTRO_MAGNUM = ITEMS.register("astro_magnum",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.IN_SPACE).ChangeRepairItem(IN_SPACE_LOGO.get()));
    public static final DeferredItem<BaseBlasterItem> ASTRO_SHOT = ITEMS.register("astro_shot",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.IN_SPACE).ChangeRepairItem(IN_SPACE_LOGO.get()));
    public static final DeferredItem<BaseBlasterItem> ASTRO_BLASTER = ITEMS.register("astro_blaster",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 10, -2.4F, new Item.Properties()).KeepDifItem(ASTRO_SHOT.get()).AddToTabList(RangerTabs.IN_SPACE).ChangeRepairItem(IN_SPACE_LOGO.get()));

    public static final DeferredItem<SwordItem> SPIRAL_SABER = ITEMS.register("spiral_saber",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.IN_SPACE).ChangeRepairItem(IN_SPACE_LOGO.get()));
    public static final DeferredItem<SwordItem> LUNAR_LANCE = ITEMS.register("lunar_lance",
            () -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.IN_SPACE).ChangeRepairItem(IN_SPACE_LOGO.get()));
    public static final DeferredItem<SwordItem> ASTRO_AXE = ITEMS.register("astro_axe",
            () -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.IN_SPACE).ChangeRepairItem(IN_SPACE_LOGO.get()));
    public static final DeferredItem<BaseBlasterItem> STAR_SLINGER = ITEMS.register("star_slinger",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.IN_SPACE).ChangeRepairItem(IN_SPACE_LOGO.get()));
    public static final DeferredItem<BaseBlasterItem> SATELLITE_STUNNER = ITEMS.register("satellite_stunner",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.IN_SPACE).ChangeRepairItem(IN_SPACE_LOGO.get()));

    public static final DeferredItem<BaseBlasterItem> SPIRAL_SABER_BOOSTER = ITEMS.register("spiral_saber_booster",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).IsSuperGun().AddToTabList(RangerTabs.IN_SPACE).ChangeRepairItem(IN_SPACE_LOGO.get()));
    public static final DeferredItem<BaseBlasterItem> LUNAR_LANCE_BOOSTER = ITEMS.register("lunar_lance_booster",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).IsSuperGun().AddToTabList(RangerTabs.IN_SPACE).ChangeRepairItem(IN_SPACE_LOGO.get()));
    public static final DeferredItem<BaseBlasterItem> ASTRO_AXE_BOOSTER = ITEMS.register("astro_axe_booster",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).IsSuperGun().AddToTabList(RangerTabs.IN_SPACE).ChangeRepairItem(IN_SPACE_LOGO.get()));
    public static final DeferredItem<BaseBlasterItem> STAR_SLINGER_BOOSTER = ITEMS.register("star_slinger_booster",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).IsSuperGun().AddToTabList(RangerTabs.IN_SPACE).ChangeRepairItem(IN_SPACE_LOGO.get()));
    public static final DeferredItem<BaseBlasterItem> SATELLITE_STUNNER_BOOSTER = ITEMS.register("satellite_stunner_booster",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).IsSuperGun().AddToTabList(RangerTabs.IN_SPACE).ChangeRepairItem(IN_SPACE_LOGO.get()));

    public static final DeferredItem<BaseBlasterItem> SPIRAL_SABER_BOOSTER_TWIN_BARREL = ITEMS.register("spiral_saber_booster_twin_barrel",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).setProjectile(BaseBlasterItem.BlasterProjectile.LARGE_FIREBALL).AddToTabList(RangerTabs.IN_SPACE).ChangeRepairItem(IN_SPACE_LOGO.get()));
    public static final DeferredItem<BaseBlasterItem> QUADRO_BLASTER = ITEMS.register("quadro_blaster",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).setProjectile(BaseBlasterItem.BlasterProjectile.LARGE_FIREBALL).AddToTabList(RangerTabs.IN_SPACE).ChangeRepairItem(IN_SPACE_LOGO.get()));

    public static final DeferredItem<BaseBlasterItem> SUPER_SILVERIZER = ITEMS.register("super_silverizer",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).IsSwordGun().AddToTabList(RangerTabs.IN_SPACE).ChangeRepairItem(IN_SPACE_LOGO.get()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
