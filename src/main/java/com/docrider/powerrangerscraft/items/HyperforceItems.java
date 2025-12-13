package com.docrider.powerrangerscraft.items;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.effect.EffectCore;
import com.docrider.powerrangerscraft.items.hyperforce.HyperforceMorpherItem;
import com.docrider.powerrangerscraft.items.others.*;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class HyperforceItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PowerRangersCraftCore.MODID);

    public static final DeferredItem<Item> HYPERFORCE_LOGO = ITEMS.register("hyperforce_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.HYPERFORCE));

    public static final DeferredItem<Item> HYPERFORCE_DIE = ITEMS.register("hyperforce_die",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.HYPERFORCE));

    public static final DeferredItem<Item> LION_HYPERFORCE_CARD = ITEMS.register("lion_hyperforce_card",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","hyperforce_red","hyperforce_belt",
                    new MobEffectInstance(EffectCore.SLASH, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 2, true, false))
                    .AddToTabList(RangerTabs.HYPERFORCE));
    public static final DeferredItem<Item> SERPENT_HYPERFORCE_CARD = ITEMS.register("serpent_hyperforce_card",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","hyperforce_blue","hyperforce_belt",
                    new MobEffectInstance(MobEffects.REGENERATION, 40, 1, true, false),
                    new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 1, true, false))
                    .AddToTabList(RangerTabs.HYPERFORCE));
    public static final DeferredItem<Item> RAM_HYPERFORCE_CARD = ITEMS.register("ram_hyperforce_card",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","hyperforce_yellow","hyperforce_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4, true, false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 1, true, false))
                    .AddToTabList(RangerTabs.HYPERFORCE));
    public static final DeferredItem<Item> CERBERUS_HYPERFORCE_CARD = ITEMS.register("cerberus_hyperforce_card",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","hyperforce_black","hyperforce_belt",
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 40, 0, true, false),
                    new MobEffectInstance(EffectCore.SLASH, 40, 2, true, false))
                    .AddToTabList(RangerTabs.HYPERFORCE));
    public static final DeferredItem<Item> PHOENIX_HYPERFORCE_CARD = ITEMS.register("phoenix_hyperforce_card",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","hyperforce_pink","hyperforce_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 3, true, false))
                    .AddToTabList(RangerTabs.HYPERFORCE));
    public static final DeferredItem<Item> HYDRA_HYPERFORCE_CARD = ITEMS.register("hydra_hyperforce_card",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","hyperforce_green","hyperforce_green_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4, true, false),
                    new MobEffectInstance(EffectCore.SLASH, 40, 4, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40 ,4, true, false))
                    .AddToTabList(RangerTabs.HYPERFORCE));

    public static final DeferredItem<Item> PINK_POWER_GEM = ITEMS.register("pink_power_gem",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"_battlizer_mode","hyperforce_pink","blank",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4, true, false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 4, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40 ,3, true, false))
                    .ChangeModel("rangerwing.geo.json").AddToTabList(RangerTabs.HYPERFORCE));

    public static final DeferredItem<Item> HYPERFORCE_HELMET = ITEMS.register("hyperforce_head",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RangerTabs.HYPERFORCE).ChangeRepairItem(HYPERFORCE_DIE.get()));
    public static final DeferredItem<Item> HYPERFORCE_CHESTPLATE = ITEMS.register("hyperforce_torso",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RangerTabs.HYPERFORCE).ChangeRepairItem(HYPERFORCE_DIE.get()));
    public static final DeferredItem<Item> HYPERFORCE_LEGGINGS = ITEMS.register("hyperforce_legs",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RangerTabs.HYPERFORCE).ChangeRepairItem(HYPERFORCE_DIE.get()));

    public static final DeferredItem<Item> RED_HYPERFORCE_MORPHER = ITEMS.register("red_hyperforce_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"hyperforce_red", LION_HYPERFORCE_CARD,HYPERFORCE_HELMET,HYPERFORCE_CHESTPLATE, HYPERFORCE_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.HYPERFORCE).ChangeRepairItem(HYPERFORCE_DIE.get()));
    public static final DeferredItem<Item> BLUE_HYPERFORCE_MORPHER = ITEMS.register("blue_hyperforce_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"hyperforce_blue", SERPENT_HYPERFORCE_CARD,HYPERFORCE_HELMET,HYPERFORCE_CHESTPLATE, HYPERFORCE_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.HYPERFORCE).ChangeRepairItem(HYPERFORCE_DIE.get()));
    public static final DeferredItem<Item> YELLOW_HYPERFORCE_MORPHER = ITEMS.register("yellow_hyperforce_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"hyperforce_yellow", RAM_HYPERFORCE_CARD,HYPERFORCE_HELMET,HYPERFORCE_CHESTPLATE, HYPERFORCE_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.HYPERFORCE).ChangeRepairItem(HYPERFORCE_DIE.get()));
    public static final DeferredItem<Item> BLACK_HYPERFORCE_MORPHER = ITEMS.register("black_hyperforce_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"hyperforce_black", CERBERUS_HYPERFORCE_CARD,HYPERFORCE_HELMET,HYPERFORCE_CHESTPLATE, HYPERFORCE_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.HYPERFORCE).ChangeRepairItem(HYPERFORCE_DIE.get()));
    public static final DeferredItem<Item> PINK_HYPERFORCE_MORPHER = ITEMS.register("pink_hyperforce_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"hyperforce_pink", PHOENIX_HYPERFORCE_CARD,HYPERFORCE_HELMET,HYPERFORCE_CHESTPLATE, HYPERFORCE_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.HYPERFORCE).ChangeRepairItem(HYPERFORCE_DIE.get()));
    public static final DeferredItem<Item> GREEN_HYPERFORCE_MORPHER = ITEMS.register("green_hyperforce_morpher",
            () -> new HyperforceMorpherItem(ArmorMaterials.DIAMOND,"hyperforce_green", HYDRA_HYPERFORCE_CARD,HYPERFORCE_HELMET,HYPERFORCE_CHESTPLATE, HYPERFORCE_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.HYPERFORCE).ChangeRepairItem(HYPERFORCE_DIE.get()));

    public static final DeferredItem<BaseBlasterItem> HYPERFORCE_BLADE_BLASTER = ITEMS.register("hyperforce_blade_blaster",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).IsSwordGun().AddToTabList(RangerTabs.HYPERFORCE).ChangeRepairItem(HYPERFORCE_DIE.get()));

    public static final DeferredItem<BaseBlasterItem> IAPETUS_BLASTER = ITEMS.register("iapetus_blaster",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.HYPERFORCE).ChangeRepairItem(HYPERFORCE_DIE.get()));
    public static final DeferredItem<SwordItem> IAPETUS_CLAW = ITEMS.register("iapetus_claw",
            () -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.HYPERFORCE).ChangeRepairItem(HYPERFORCE_DIE.get()));
    public static final DeferredItem<SwordItem> IAPETUS_CLAW1 = ITEMS.register("iapetus_claw1",
            () -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.HYPERFORCE).ChangeRepairItem(HYPERFORCE_DIE.get()));

    public static final DeferredItem<SwordItem> OCEANUS_TRIDENT = ITEMS.register("oceanus_trident",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.HYPERFORCE).ChangeRepairItem(HYPERFORCE_DIE.get()));
    public static final DeferredItem<SwordItem> OCEANUS_BLADE = ITEMS.register("oceanus_blade",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.HYPERFORCE).ChangeRepairItem(HYPERFORCE_DIE.get()));

    public static final DeferredItem<BaseBlasterItem> CRIUS_HAMMER = ITEMS.register("crius_hammer",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).IsSwordGun().AddToTabList(RangerTabs.HYPERFORCE).ChangeRepairItem(HYPERFORCE_DIE.get()));

    public static final DeferredItem<SwordItem> COEUS_AXE = ITEMS.register("coeus_axe",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.HYPERFORCE).ChangeRepairItem(HYPERFORCE_DIE.get()));
    public static final DeferredItem<ShieldItem> COEUS_SHIELD = ITEMS.register("coeus_shield",
            () -> new BaseShieldItem(new Item.Properties()).AddToTabList(RangerTabs.HYPERFORCE).ChangeRepairItem(HYPERFORCE_DIE.get()));

    public static final DeferredItem<BaseBlasterItem> HYPERION_SCYTHE = ITEMS.register("hyperion_scythe",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).IsSwordGun().AddToTabList(RangerTabs.HYPERFORCE).ChangeRepairItem(HYPERFORCE_DIE.get()));

    public static final DeferredItem<SwordItem> RHEA_SWORD = ITEMS.register("rhea_sword",
            () -> new BaseDualSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).IsDualWeapon().AddToTabList(RangerTabs.HYPERFORCE).ChangeRepairItem(HYPERFORCE_DIE.get()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
