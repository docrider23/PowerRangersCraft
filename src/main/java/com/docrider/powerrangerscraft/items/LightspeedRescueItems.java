package com.docrider.powerrangerscraft.items;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.effect.EffectCore;
import com.docrider.powerrangerscraft.items.lightspeed_rescue.BattleBoosterItem;
import com.docrider.powerrangerscraft.items.lightspeed_rescue.RescueMorpherItem;
import com.docrider.powerrangerscraft.items.lightspeed_rescue.RescueInjectorItem;
import com.docrider.powerrangerscraft.items.others.*;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class LightspeedRescueItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PowerRangersCraftCore.MODID);

    public static final DeferredItem<Item> LIGHTSPEED_RESCUE_LOGO = ITEMS.register("lightspeed_rescue_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE));

    public static final DeferredItem<Item> LIGHTSPEED_RED_BADGE = ITEMS.register("lightspeed_red_badge",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","lightspeed_red","lightspeed_red_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)).IsGlowing().ChangeBeltModel("geo/rangerbeltextra.geo.json").AddToTabList(RangerTabs.LIGHTSPEED_RESCUE));

    public static final DeferredItem<Item> LIGHTSPEED_BLUE_BADGE = ITEMS.register("lightspeed_blue_badge",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","lightspeed_blue","lightspeed_blue_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)).IsGlowing().ChangeBeltModel("geo/rangerbeltextra.geo.json").AddToTabList(RangerTabs.LIGHTSPEED_RESCUE));

    public static final DeferredItem<Item> LIGHTSPEED_GREEN_BADGE = ITEMS.register("lightspeed_green_badge",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","lightspeed_green","lightspeed_green_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)).IsGlowing().ChangeBeltModel("geo/rangerbeltextra.geo.json").AddToTabList(RangerTabs.LIGHTSPEED_RESCUE));

    public static final DeferredItem<Item> LIGHTSPEED_YELLOW_BADGE = ITEMS.register("lightspeed_yellow_badge",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","lightspeed_yellow","lightspeed_yellow_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)).IsGlowing().ChangeBeltModel("geo/rangerbeltextra.geo.json").AddToTabList(RangerTabs.LIGHTSPEED_RESCUE));

    public static final DeferredItem<Item> LIGHTSPEED_PINK_BADGE = ITEMS.register("lightspeed_pink_badge",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","lightspeed_pink","lightspeed_pink_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)).IsGlowing().ChangeBeltModel("geo/rangerbeltextra.geo.json").AddToTabList(RangerTabs.LIGHTSPEED_RESCUE));

    public static final DeferredItem<Item> TITANIUM_BADGE = ITEMS.register("titanium_badge",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","titanium_ranger","titanium_ranger_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
                    .IsGlowing().AddToTabList(RangerTabs.LIGHTSPEED_RESCUE));

    public static final DeferredItem<Item> TRANS_ARMOR_BADGE = ITEMS.register("trans_armor_badge",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"_trans_armor","lightspeed_red","lightspeed_red_belt",
                    new MobEffectInstance(EffectCore.SHOTBOOST,40,2,true,false))
                    .ChangeModel("trans_armor.geo.json").ChangeBeltModel("geo/rangerbeltextra.geo.json").AddToTabList(RangerTabs.LIGHTSPEED_RESCUE));

    public static final DeferredItem<Item> LIGHTSPEED_RESCUE_HELMET = ITEMS.register("lightspeed_rescue_head",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));
    public static final DeferredItem<Item> LIGHTSPEED_RESCUE_CHESTPLATE = ITEMS.register("lightspeed_rescue_torso",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));
    public static final DeferredItem<Item> LIGHTSPEED_RESCUE_LEGGINGS = ITEMS.register("lightspeed_rescue_legs",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));

    public static final DeferredItem<Item> RED_RESCUE_MORPHER = ITEMS.register("red_rescue_morpher",
            () -> new RescueMorpherItem(ArmorMaterials.DIAMOND,"lightspeed_red",LIGHTSPEED_RED_BADGE,LIGHTSPEED_RESCUE_HELMET,LIGHTSPEED_RESCUE_CHESTPLATE,LIGHTSPEED_RESCUE_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));
    public static final DeferredItem<Item> BLUE_RESCUE_MORPHER = ITEMS.register("blue_rescue_morpher",
            () -> new RescueMorpherItem(ArmorMaterials.DIAMOND,"lightspeed_blue",LIGHTSPEED_BLUE_BADGE,LIGHTSPEED_RESCUE_HELMET,LIGHTSPEED_RESCUE_CHESTPLATE,LIGHTSPEED_RESCUE_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));
    public static final DeferredItem<Item> GREEN_RESCUE_MORPHER = ITEMS.register("green_rescue_morpher",
            () -> new RescueMorpherItem(ArmorMaterials.DIAMOND,"lightspeed_green",LIGHTSPEED_GREEN_BADGE,LIGHTSPEED_RESCUE_HELMET,LIGHTSPEED_RESCUE_CHESTPLATE,LIGHTSPEED_RESCUE_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));
    public static final DeferredItem<Item> YELLOW_RESCUE_MORPHER = ITEMS.register("yellow_rescue_morpher",
            () -> new RescueMorpherItem(ArmorMaterials.DIAMOND,"lightspeed_yellow",LIGHTSPEED_YELLOW_BADGE,LIGHTSPEED_RESCUE_HELMET,LIGHTSPEED_RESCUE_CHESTPLATE,LIGHTSPEED_RESCUE_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));
    public static final DeferredItem<Item> PINK_RESCUE_MORPHER = ITEMS.register("pink_rescue_morpher",
            () -> new RescueMorpherItem(ArmorMaterials.DIAMOND,"lightspeed_pink",LIGHTSPEED_PINK_BADGE,LIGHTSPEED_RESCUE_HELMET,LIGHTSPEED_RESCUE_CHESTPLATE,LIGHTSPEED_RESCUE_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));

    public static final DeferredItem<Item> TITANIUM_MORPHER = ITEMS.register("titanium_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"titanium_ranger",TITANIUM_BADGE,LIGHTSPEED_RESCUE_HELMET,LIGHTSPEED_RESCUE_CHESTPLATE,LIGHTSPEED_RESCUE_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));

    public static final DeferredItem<Item> BATTLE_BOOSTER = ITEMS.register("battle_booster",
            () -> new BattleBoosterItem(new Item.Properties()).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE));

    public static final DeferredItem<Item> BLASTER_GRIP_RED = ITEMS.register("blaster_grip_red",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE));
    public static final DeferredItem<Item> BLASTER_GRIP_BLUE = ITEMS.register("blaster_grip_blue",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE));
    public static final DeferredItem<Item> BLASTER_GRIP_GREEN = ITEMS.register("blaster_grip_green",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE));
    public static final DeferredItem<Item> BLASTER_GRIP_YELLOW = ITEMS.register("blaster_grip_yellow",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE));
    public static final DeferredItem<Item> BLASTER_GRIP_PINK = ITEMS.register("blaster_grip_pink",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE));

    public static final DeferredItem<BaseBlasterItem> RESCUE_BLASTER_RED = ITEMS.register("rescue_blaster_red",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).IsSwordGun().AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));
    public static final DeferredItem<BaseBlasterItem> RESCUE_BLASTER_BLUE = ITEMS.register("rescue_blaster_blue",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).IsSwordGun().AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));
    public static final DeferredItem<BaseBlasterItem> RESCUE_BLASTER_GREEN = ITEMS.register("rescue_blaster_green",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).IsSwordGun().AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));
    public static final DeferredItem<BaseBlasterItem> RESCUE_BLASTER_YELLOW = ITEMS.register("rescue_blaster_yellow",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).IsSwordGun().AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));
    public static final DeferredItem<BaseBlasterItem> RESCUE_BLASTER_PINK = ITEMS.register("rescue_blaster_pink",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).IsSwordGun().AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));

    public static final DeferredItem<BaseThrowableItem> V_BOOMERANG_RED = ITEMS.register("v_boomerang_red",
            () -> new BaseThrowableItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));
    public static final DeferredItem<BaseThrowableItem> V_BOOMERANG_BLUE = ITEMS.register("v_boomerang_blue",
            () -> new BaseThrowableItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));
    public static final DeferredItem<BaseThrowableItem> V_BOOMERANG_GREEN = ITEMS.register("v_boomerang_green",
            () -> new BaseThrowableItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));
    public static final DeferredItem<BaseThrowableItem> V_BOOMERANG_YELLOW = ITEMS.register("v_boomerang_yellow",
            () -> new BaseThrowableItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));
    public static final DeferredItem<BaseThrowableItem> V_BOOMERANG_PINK = ITEMS.register("v_boomerang_pink",
            () -> new BaseThrowableItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));

    public static final DeferredItem<SwordItem> V_LANCER_RED = ITEMS.register("v_lancer_red",
            () -> new BaseSwordItem(Tiers.DIAMOND, 12, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));
    public static final DeferredItem<SwordItem> V_LANCER_BLUE = ITEMS.register("v_lancer_blue",
            () -> new BaseSwordItem(Tiers.DIAMOND, 12, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));
    public static final DeferredItem<SwordItem> V_LANCER_GREEN = ITEMS.register("v_lancer_green",
            () -> new BaseSwordItem(Tiers.DIAMOND, 12, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));
    public static final DeferredItem<SwordItem> V_LANCER_YELLOW = ITEMS.register("v_lancer_yellow",
            () -> new BaseSwordItem(Tiers.DIAMOND, 12, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));
    public static final DeferredItem<SwordItem> V_LANCER_PINK = ITEMS.register("v_lancer_pink",
            () -> new BaseSwordItem(Tiers.DIAMOND, 12, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));

    public static final DeferredItem<BaseBlasterItem> V_BLASTER_RED = ITEMS.register("v_blaster_red",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 12, -2.4F, new Item.Properties()).setProjectile(BaseBlasterItem.BlasterProjectile.LARGE_FIREBALL).KeepDifItem(V_LANCER_RED.get()).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));
    public static final DeferredItem<BaseBlasterItem> V_BLASTER_BLUE = ITEMS.register("v_blaster_blue",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 12, -2.4F, new Item.Properties()).setProjectile(BaseBlasterItem.BlasterProjectile.LARGE_FIREBALL).KeepDifItem(V_LANCER_BLUE.get()).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));
    public static final DeferredItem<BaseBlasterItem> V_BLASTER_GREEN = ITEMS.register("v_blaster_green",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 12, -2.4F, new Item.Properties()).setProjectile(BaseBlasterItem.BlasterProjectile.LARGE_FIREBALL).KeepDifItem(V_LANCER_GREEN.get()).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));
    public static final DeferredItem<BaseBlasterItem> V_BLASTER_YELLOW = ITEMS.register("v_blaster_yellow",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 12, -2.4F, new Item.Properties()).setProjectile(BaseBlasterItem.BlasterProjectile.LARGE_FIREBALL).KeepDifItem(V_LANCER_YELLOW.get()).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));
    public static final DeferredItem<BaseBlasterItem> V_BLASTER_PINK = ITEMS.register("v_blaster_pink",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 12, -2.4F, new Item.Properties()).setProjectile(BaseBlasterItem.BlasterProjectile.LARGE_FIREBALL).KeepDifItem(V_LANCER_PINK.get()).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));

    public static final DeferredItem<BaseBlasterItem> THERMO_BLASTER_RED = ITEMS.register("thermo_blaster",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));
    public static final DeferredItem<BaseBlasterItem> THERMO_BLASTER_BLUE = ITEMS.register("thermo_blaster_blue",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));
    public static final DeferredItem<BaseBlasterItem> THERMO_BLASTER_GREEN = ITEMS.register("thermo_blaster_green",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));
    public static final DeferredItem<BaseBlasterItem> THERMO_BLASTER_YELLOW = ITEMS.register("thermo_blaster_yellow",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));
    public static final DeferredItem<BaseBlasterItem> THERMO_BLASTER_PINK = ITEMS.register("thermo_blaster_pink",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));

    public static final DeferredItem<BaseBlasterItem> THERMO_BLASTER_HYPER_RED = ITEMS.register("thermo_blaster_hyper",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).IsSuperGun().KeepDifItem(THERMO_BLASTER_RED.get()).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));
    public static final DeferredItem<BaseBlasterItem> THERMO_BLASTER_HYPER_BLUE = ITEMS.register("thermo_blaster_hyper_blue",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).IsSuperGun().KeepDifItem(THERMO_BLASTER_BLUE.get()).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));
    public static final DeferredItem<BaseBlasterItem> THERMO_BLASTER_HYPER_GREEN = ITEMS.register("thermo_blaster_hyper_green",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).IsSuperGun().KeepDifItem(THERMO_BLASTER_GREEN.get()).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));
    public static final DeferredItem<BaseBlasterItem> THERMO_BLASTER_HYPER_YELLOW = ITEMS.register("thermo_blaster_hyper_yellow",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).IsSuperGun().KeepDifItem(THERMO_BLASTER_YELLOW.get()).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));
    public static final DeferredItem<BaseBlasterItem> THERMO_BLASTER_HYPER_PINK = ITEMS.register("thermo_blaster_hyper_pink",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).IsSuperGun().KeepDifItem(THERMO_BLASTER_PINK.get()).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));

    public static final DeferredItem<SwordItem> RESCUE_CLAW = ITEMS.register("rescue_claw",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));
    public static final DeferredItem<BaseBlasterItem> RESCUE_SPRAY = ITEMS.register("rescue_spray",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));
    public static final DeferredItem<SwordItem> RESCUE_CUTTER = ITEMS.register("rescue_cutter",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));
    public static final DeferredItem<PickaxeItem> RESCUE_DRILL = ITEMS.register("rescue_drill",
            () -> new BasePickaxeItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));
    public static final DeferredItem<BaseBlasterItem> RESCUE_INJECTOR = ITEMS.register("rescue_injector",
            () -> new RescueInjectorItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));

    public static final DeferredItem<BaseBlasterItem> RESCUE_BIRD_UNILASER_MODE = ITEMS.register("rescue_bird_unilaser_mode",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 10, -2.4F, new Item.Properties()).setProjectile(BaseBlasterItem.BlasterProjectile.LARGE_FIREBALL).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));

    public static final DeferredItem<BaseBlasterItem> TITANIUM_AXE = ITEMS.register("titanium_axe",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 10, -2.4F, new Item.Properties()).IsSwordGun().setProjectile(BaseBlasterItem.BlasterProjectile.LARGE_FIREBALL).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
