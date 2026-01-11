package com.docrider.powerrangerscraft.items;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.blocks.machineBlocks.AnimalDNARepository;
import com.docrider.powerrangerscraft.effect.EffectCore;
import com.docrider.powerrangerscraft.items.beast_morphers.MorphXKeyItem;
import com.docrider.powerrangerscraft.items.others.*;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BeastMorphersItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PowerRangersCraftCore.MODID);

    public static final DeferredItem<Item> BEAST_MORPHERS_LOGO = ITEMS.register("beast_morphers_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.BEAST_MORPHERS));

    public static final DeferredItem<Item> MORPH_X_CANISTER = ITEMS.register("morph_x_canister",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.BEAST_MORPHERS));
    public static final DeferredItem<Item> BLANK_MORPH_X_KEY = ITEMS.register("blank_morph_x_key",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.BEAST_MORPHERS));

    public static final DeferredItem<Item> RED_MORPH_X_KEY = ITEMS.register("red_morph_x_key",
            () -> new MorphXKeyItem(new Item.Properties(),0,"","beast_morphers_red","beast_morphers_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false))
                    .ChangeBeltModel("geo/rangerbelt1.geo.json").AddToTabList(RangerTabs.BEAST_MORPHERS).AddToList(AnimalDNARepository.ANIMAL_DNA_REPOSITORY, 10));
    public static final DeferredItem<Item> BLUE_MORPH_X_KEY = ITEMS.register("blue_morph_x_key",
            () -> new MorphXKeyItem(new Item.Properties(),0,"","beast_morphers_blue","beast_morphers_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false))
                    .ChangeBeltModel("geo/rangerbelt1.geo.json").AddToTabList(RangerTabs.BEAST_MORPHERS).AddToList(AnimalDNARepository.ANIMAL_DNA_REPOSITORY, 10));
    public static final DeferredItem<Item> YELLOW_MORPH_X_KEY = ITEMS.register("yellow_morph_x_key",
            () -> new MorphXKeyItem(new Item.Properties(),0,"","beast_morphers_yellow","beast_morphers_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
                    .ChangeBeltModel("geo/rangerbelt1.geo.json").AddToTabList(RangerTabs.BEAST_MORPHERS).AddToList(AnimalDNARepository.ANIMAL_DNA_REPOSITORY, 10));
    public static final DeferredItem<Item> GOLD_MORPH_X_KEY = ITEMS.register("gold_morph_x_key",
            () -> new MorphXKeyItem(new Item.Properties(),0,"","beast_morphers_gold","beast_morphers_gold_silver_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false))
                    .AddToTabList(RangerTabs.BEAST_MORPHERS).AddToList(AnimalDNARepository.ANIMAL_DNA_REPOSITORY, 10));
    public static final DeferredItem<Item> SILVER_MORPH_X_KEY = ITEMS.register("silver_morph_x_key",
            () -> new MorphXKeyItem(new Item.Properties(),0,"","beast_morphers_silver","beast_morphers_gold_silver_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false))
                    .AddToTabList(RangerTabs.BEAST_MORPHERS).AddToList(AnimalDNARepository.ANIMAL_DNA_REPOSITORY, 10));
    public static final DeferredItem<Item> ORANGE_MORPH_X_KEY = ITEMS.register("orange_morph_x_key",
            () -> new MorphXKeyItem(new Item.Properties(),0,"","beast_morphers_orange","beast_morphers_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
                    new MobEffectInstance(EffectCore.FLYING, 40, 2,true,false))
                    .ChangeBeltModel("geo/rangerbelt1.geo.json").AddToTabList(RangerTabs.BEAST_MORPHERS).AddToList(AnimalDNARepository.ANIMAL_DNA_REPOSITORY, 1));

    public static final DeferredItem<Item> RED_FURY_MORPH_X_KEY = ITEMS.register("red_fury_morph_x_key",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"_fury","beast_morphers_red","beast_morphers_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false))
                    .ChangeBeltModel("geo/rangerbelt1.geo.json").AddToTabList(RangerTabs.BEAST_MORPHERS));

    public static final DeferredItem<Item> CRUISE_MORPH_X_KEY = ITEMS.register("cruise_morph_x_key",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.BEAST_MORPHERS));
    public static final DeferredItem<Item> SMASH_MORPH_X_KEY = ITEMS.register("smash_morph_x_key",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.BEAST_MORPHERS));
    public static final DeferredItem<Item> JAX_MORPH_X_KEY = ITEMS.register("jax_morph_x_key",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.BEAST_MORPHERS));

    public static final DeferredItem<Item> BEAST_X_VISOR_Y = ITEMS.register("beast_x_visor_y",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"_beast_x","beast_morphers_yellow","beast_morphers_belt_beast_x_visor",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false))
                    .ChangeBeltModel("geo/rangerbelt1.geo.json"));
    public static final DeferredItem<Item> BEAST_X_VISOR_B = ITEMS.register("beast_x_visor_b",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"_beast_x","beast_morphers_blue","beast_morphers_belt_beast_x_visor",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 6,true,false))
                    .addAlternative(BEAST_X_VISOR_Y.get()).ChangeBeltModel("geo/rangerbelt1.geo.json"));
    public static final DeferredItem<Item> BEAST_X_VISOR = ITEMS.register("beast_x_visor",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"_beast_x","beast_morphers_red","beast_morphers_belt_beast_x_visor",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 6,true,false))
                    .addAlternative(BEAST_X_VISOR_B.get()).ChangeBeltModel("geo/rangerbelt1.geo.json").AddToTabList(RangerTabs.BEAST_MORPHERS));

    public static final DeferredItem<Item> BEAST_X_KING_MORPH_X_KEY = ITEMS.register("beast_x_king_morph_x_key",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.BEAST_MORPHERS));

    public static final DeferredItem<Item> BEAST_X_KING_ACTIVATOR = ITEMS.register("beast_x_king_activator",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"_beast_x_king","beast_morphers_red","beast_morphers_belt_beast_x_king",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 6,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 6,true,false))
                    .AddToTabList(RangerTabs.BEAST_MORPHERS));

    public static final DeferredItem<Item> BLAZE_MORPH_X_KEY = ITEMS.register("blaze_morph_x_key",
            () -> new MorphXKeyItem(new Item.Properties(),0,"","cybervillain_blaze","cybervillain_blaze_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false))
                    .ChangeBeltModel("geo/rangerbelt1.geo.json").AddToTabList(RangerTabs.BEAST_MORPHERS));
    public static final DeferredItem<Item> ROXY_MORPH_X_KEY = ITEMS.register("roxy_morph_x_key",
            () -> new MorphXKeyItem(new Item.Properties(),0,"","cybervillain_roxy","blank",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false))
                    .ChangeModel("roxy.geo.json").AddToTabList(RangerTabs.BEAST_MORPHERS));
    public static final DeferredItem<Item> ROBO_BLAZE_MORPH_X_KEY = ITEMS.register("robo_blaze_morph_x_key",
            () -> new MorphXKeyItem(new Item.Properties(),0,"","cybervillain_robo_blaze","blank",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false))
                    .AddToTabList(RangerTabs.BEAST_MORPHERS));
    public static final DeferredItem<Item> ROBO_ROXY_MORPH_X_KEY = ITEMS.register("robo_roxy_morph_x_key",
            () -> new MorphXKeyItem(new Item.Properties(),0,"","cybervillain_robo_roxy","blank",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false))
                    .ChangeModel("roxy.geo.json").AddToTabList(RangerTabs.BEAST_MORPHERS));

    public static final DeferredItem<Item> BEAST_MORPHERS_HELMET = ITEMS.register("beast_morphers_head",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RangerTabs.BEAST_MORPHERS).ChangeRepairItem(BEAST_MORPHERS_LOGO.get()));
    public static final DeferredItem<Item> BEAST_MORPHERS_CHESTPLATE = ITEMS.register("beast_morphers_torso",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RangerTabs.BEAST_MORPHERS).ChangeRepairItem(BEAST_MORPHERS_LOGO.get()));
    public static final DeferredItem<Item> BEAST_MORPHERS_LEGGINGS = ITEMS.register("beast_morphers_legs",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RangerTabs.BEAST_MORPHERS).ChangeRepairItem(BEAST_MORPHERS_LOGO.get()));

    public static final DeferredItem<Item> RED_BEAST_X_MORPHER = ITEMS.register("red_beast_x_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"beast_morphers_red", RED_MORPH_X_KEY,BEAST_MORPHERS_HELMET,BEAST_MORPHERS_CHESTPLATE, BEAST_MORPHERS_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.BEAST_MORPHERS).ChangeRepairItem(BEAST_MORPHERS_LOGO.get()));
    public static final DeferredItem<Item> BLUE_BEAST_X_MORPHER = ITEMS.register("blue_beast_x_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"beast_morphers_blue", BLUE_MORPH_X_KEY,BEAST_MORPHERS_HELMET,BEAST_MORPHERS_CHESTPLATE, BEAST_MORPHERS_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.BEAST_MORPHERS).ChangeRepairItem(BEAST_MORPHERS_LOGO.get()));
    public static final DeferredItem<Item> YELLOW_BEAST_X_MORPHER = ITEMS.register("yellow_beast_x_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"beast_morphers_yellow", YELLOW_MORPH_X_KEY,BEAST_MORPHERS_HELMET,BEAST_MORPHERS_CHESTPLATE, BEAST_MORPHERS_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.BEAST_MORPHERS).ChangeRepairItem(BEAST_MORPHERS_LOGO.get()));
    public static final DeferredItem<Item> GOLD_STRIKER_MORPHER = ITEMS.register("gold_striker_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"beast_morphers_gold", GOLD_MORPH_X_KEY,BEAST_MORPHERS_HELMET,BEAST_MORPHERS_CHESTPLATE, BEAST_MORPHERS_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.BEAST_MORPHERS).ChangeRepairItem(BEAST_MORPHERS_LOGO.get()));
    public static final DeferredItem<Item> SILVER_STRIKER_MORPHER = ITEMS.register("silver_striker_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"beast_morphers_silver", SILVER_MORPH_X_KEY,BEAST_MORPHERS_HELMET,BEAST_MORPHERS_CHESTPLATE, BEAST_MORPHERS_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.BEAST_MORPHERS).ChangeRepairItem(BEAST_MORPHERS_LOGO.get()));
    public static final DeferredItem<Item> ORANGE_BEAST_X_MORPHER = ITEMS.register("orange_beast_x_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"beast_morphers_orange", ORANGE_MORPH_X_KEY,BEAST_MORPHERS_HELMET,BEAST_MORPHERS_CHESTPLATE, BEAST_MORPHERS_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.BEAST_MORPHERS).ChangeRepairItem(BEAST_MORPHERS_LOGO.get()));

    public static final DeferredItem<Item> BLAZE_EVOX_BEAST_X_MORPHER = ITEMS.register("blaze_evox_beast_x_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"cybervillain_blaze", BLAZE_MORPH_X_KEY,BEAST_MORPHERS_HELMET,BEAST_MORPHERS_CHESTPLATE, BEAST_MORPHERS_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.BEAST_MORPHERS).ChangeRepairItem(BEAST_MORPHERS_LOGO.get()));
    public static final DeferredItem<Item> ROXY_EVOX_BEAST_X_MORPHER = ITEMS.register("roxy_evox_beast_x_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"cybervillain_roxy", ROXY_MORPH_X_KEY,BEAST_MORPHERS_HELMET,BEAST_MORPHERS_CHESTPLATE, BEAST_MORPHERS_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.BEAST_MORPHERS).ChangeRepairItem(BEAST_MORPHERS_LOGO.get()));
    public static final DeferredItem<Item> ROBO_BLAZE_EVOX_BEAST_X_MORPHER = ITEMS.register("robo_blaze_evox_beast_x_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"cybervillain_robo_blaze", ROBO_BLAZE_MORPH_X_KEY,BEAST_MORPHERS_HELMET,BEAST_MORPHERS_CHESTPLATE, BEAST_MORPHERS_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.BEAST_MORPHERS).ChangeRepairItem(BEAST_MORPHERS_LOGO.get()));
    public static final DeferredItem<Item> ROBO_ROXY_EVOX_BEAST_X_MORPHER = ITEMS.register("robo_roxy_evox_beast_x_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"cybervillain_robo_roxy", ROBO_ROXY_MORPH_X_KEY,BEAST_MORPHERS_HELMET,BEAST_MORPHERS_CHESTPLATE, BEAST_MORPHERS_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.BEAST_MORPHERS).ChangeRepairItem(BEAST_MORPHERS_LOGO.get()));

    public static final DeferredItem<SwordItem> BEAST_X_SABER = ITEMS.register("beast_x_saber",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.BEAST_MORPHERS).ChangeRepairItem(MORPH_X_CANISTER.get()));
    public static final DeferredItem<BaseBlasterItem> BEAST_X_BLASTER = ITEMS.register("beast_x_blaster",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.BEAST_MORPHERS).ChangeRepairItem(MORPH_X_CANISTER.get()));
    public static final DeferredItem<BaseBlasterItem> BEAST_X_CANNON = ITEMS.register("beast_x_cannon",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).IsSuperGun().KeepDifItem(BEAST_X_SABER.get()).AddToTabList(RangerTabs.BEAST_MORPHERS).ChangeRepairItem(MORPH_X_CANISTER.get()));

    public static final DeferredItem<BaseBlasterItem> CHEETAH_BEAST_BLASTER = ITEMS.register("cheetah_beast_blaster",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).IsSuperGun().AddToTabList(RangerTabs.BEAST_MORPHERS).ChangeRepairItem(MORPH_X_CANISTER.get()));
    public static final DeferredItem<SwordItem> CHEETAH_CLAW = ITEMS.register("cheetah_claw",
            () -> new BaseSwordItem(Tiers.DIAMOND, 7, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.BEAST_MORPHERS).ChangeRepairItem(MORPH_X_CANISTER.get()));

    public static final DeferredItem<BaseBlasterItem> BEAST_X_ULTRA_BLASTER = ITEMS.register("beast_x_ultra_blaster",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).IsSuperGun().AddToTabList(RangerTabs.BEAST_MORPHERS).ChangeRepairItem(MORPH_X_CANISTER.get()));
    public static final DeferredItem<BaseBlasterItem> BEAST_X_ULTRA_BOW = ITEMS.register("beast_x_ultra_bow",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).IsSuperGun().AddToTabList(RangerTabs.BEAST_MORPHERS).ChangeRepairItem(MORPH_X_CANISTER.get()));
    public static final DeferredItem<BaseBlasterItem> BEAST_X_ULTRA_CANNON = ITEMS.register("beast_x_ultra_cannon",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).IsHyperGun().KeepDifItem(BEAST_X_ULTRA_BOW.get()).AddToTabList(RangerTabs.BEAST_MORPHERS).ChangeRepairItem(MORPH_X_CANISTER.get()));

    public static final DeferredItem<SwordItem> BEAST_X_KING_SPIN_SABER = ITEMS.register("beast_x_king_spin_saber",
            () -> new BaseSwordItem(Tiers.DIAMOND, 7, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.BEAST_MORPHERS).ChangeRepairItem(MORPH_X_CANISTER.get()));

    public static final DeferredItem<BaseBlasterItem> STRIKER_MORPHER = ITEMS.register("striker_morpher",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.BEAST_MORPHERS).ChangeRepairItem(BEAST_MORPHERS_LOGO.get()));
    public static final DeferredItem<SwordItem> STRIKER_SABER = ITEMS.register("striker_saber",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.BEAST_MORPHERS).ChangeRepairItem(MORPH_X_CANISTER.get()));

    public static final DeferredItem<SwordItem> CYBERVILLAIN_BLAZE_SWORD = ITEMS.register("cybervillain_blaze_sword",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.BEAST_MORPHERS).ChangeRepairItem(MORPH_X_CANISTER.get()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
