package com.docrider.powerrangerscraft.items;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.items.lightspeed_rescue.RescueMorpherItem;
import com.docrider.powerrangerscraft.items.lightspeed_rescue.TailInjectorItem;
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
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)).ChangeBeltModel("geo/rangerbeltextra.geo.json").AddToTabList(RangerTabs.LIGHTSPEED_RESCUE));

    public static final DeferredItem<Item> LIGHTSPEED_BLUE_BADGE = ITEMS.register("lightspeed_blue_badge",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","lightspeed_blue","lightspeed_blue_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)).ChangeBeltModel("geo/rangerbeltextra.geo.json").AddToTabList(RangerTabs.LIGHTSPEED_RESCUE));

    public static final DeferredItem<Item> LIGHTSPEED_GREEN_BADGE = ITEMS.register("lightspeed_green_badge",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","lightspeed_green","lightspeed_green_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)).ChangeBeltModel("geo/rangerbeltextra.geo.json").AddToTabList(RangerTabs.LIGHTSPEED_RESCUE));

    public static final DeferredItem<Item> LIGHTSPEED_YELLOW_BADGE = ITEMS.register("lightspeed_yellow_badge",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","lightspeed_yellow","lightspeed_yellow_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)).ChangeBeltModel("geo/rangerbeltextra.geo.json").AddToTabList(RangerTabs.LIGHTSPEED_RESCUE));

    public static final DeferredItem<Item> LIGHTSPEED_PINK_BADGE = ITEMS.register("lightspeed_pink_badge",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","lightspeed_pink","lightspeed_pink_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)).ChangeBeltModel("geo/rangerbeltextra.geo.json").AddToTabList(RangerTabs.LIGHTSPEED_RESCUE));

    public static final DeferredItem<Item> TITANIUM_BADGE = ITEMS.register("titanium_badge",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","titanium_ranger","titanium_ranger_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)).ChangeBeltModel("geo/rangerbeltextra.geo.json").AddToTabList(RangerTabs.LIGHTSPEED_RESCUE));

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

    public static final DeferredItem<SwordItem> CLAW_ANCHOR = ITEMS.register("claw_anchor",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));
    public static final DeferredItem<BaseBlasterItem> BUILD_DISCHARGER = ITEMS.register("build_discharger",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));
    public static final DeferredItem<SwordItem> WING_SPREADER = ITEMS.register("wing_spreader",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));
    public static final DeferredItem<PickaxeItem> BEAK_DRILLER = ITEMS.register("beak_driller",
            () -> new BasePickaxeItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));
    public static final DeferredItem<BaseBlasterItem> TAIL_INJECTOR = ITEMS.register("tail_injector",
            () -> new TailInjectorItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));

    public static final DeferredItem<BaseBlasterItem> RESCUE_BIRD_UNILASER_MODE = ITEMS.register("rescue_bird_unilaser_mode",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 10, -2.4F, new Item.Properties()).setProjectile(BaseBlasterItem.BlasterProjectile.LARGE_FIREBALL).AddToTabList(RangerTabs.LIGHTSPEED_RESCUE).ChangeRepairItem(LIGHTSPEED_RESCUE_LOGO.get()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
