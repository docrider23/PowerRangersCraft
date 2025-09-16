package com.docrider.powerrangerscraft.items;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.items.others.*;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ComicsItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PowerRangersCraftCore.MODID);

    //Shattered Grid
    public static final DeferredItem<Item> RANGER_SLAYER_POWER_COIN = ITEMS.register("ranger_slayer_power_coin",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","solar_pink","blank")
                    .AddToTabList(RangerTabs.COMICS));

    //Solar Rangers
    public static final DeferredItem<Item> SOLAR_LOGO = ITEMS.register("solar_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.COMICS));

    public static final DeferredItem<Item> BLANK_SOLAR_CRYSTAL = ITEMS.register("blank_solar_crystal",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.COMICS));

    public static final DeferredItem<Item> PURPLE_SOLAR_CRYSTAL = ITEMS.register("purple_solar_crystal",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","solar_purple","blank")
                    .AddToTabList(RangerTabs.COMICS));
    public static final DeferredItem<Item> ORANGE_SOLAR_CRYSTAL = ITEMS.register("orange_solar_crystal",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","solar_orange","blank")
                    .AddToTabList(RangerTabs.COMICS));

    public static final DeferredItem<Item> SOLAR_HELMET = ITEMS.register("solar_head",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(BLANK_SOLAR_CRYSTAL.get()));
    public static final DeferredItem<Item> SOLAR_CHESTPLATE = ITEMS.register("solar_torso",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(BLANK_SOLAR_CRYSTAL.get()));
    public static final DeferredItem<Item> SOLAR_LEGGINGS = ITEMS.register("solar_legs",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(BLANK_SOLAR_CRYSTAL.get()));

    public static final DeferredItem<Item> PURPLE_SOLARIX = ITEMS.register("purple_solarix",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"solar_purple", PURPLE_SOLAR_CRYSTAL, SOLAR_HELMET, SOLAR_CHESTPLATE, SOLAR_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(BLANK_SOLAR_CRYSTAL.get()));
    public static final DeferredItem<Item> ORANGE_SOLARIX = ITEMS.register("orange_solarix",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"solar_orange", ORANGE_SOLAR_CRYSTAL, SOLAR_HELMET, SOLAR_CHESTPLATE, SOLAR_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(BLANK_SOLAR_CRYSTAL.get()));
    public static final DeferredItem<Item> RED_SOLARIX = ITEMS.register("red_solarix",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"solar_red", InSpaceItems.RED_SPACE_DISK, SOLAR_HELMET, SOLAR_CHESTPLATE, SOLAR_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(BLANK_SOLAR_CRYSTAL.get()));
    public static final DeferredItem<Item> BLACK_SOLARIX = ITEMS.register("black_solarix",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"solar_black", LostGalaxyItems.MAGNA_DEFENDER_CORE_SOLAR, SOLAR_HELMET, SOLAR_CHESTPLATE, SOLAR_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(BLANK_SOLAR_CRYSTAL.get()));
    public static final DeferredItem<Item> BLUE_SOLARIX = ITEMS.register("blue_solarix",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"solar_blue", DinoChargeItems.SPINOSAURUS_DINO_CHARGER_SOLAR, SOLAR_HELMET, SOLAR_CHESTPLATE, SOLAR_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(BLANK_SOLAR_CRYSTAL.get()));
    public static final DeferredItem<Item> YELLOW_SOLARIX = ITEMS.register("yellow_solarix",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"solar_yellow", ZeoItems.YELLOW_ZEO_SUB_CRYSTAL, SOLAR_HELMET, SOLAR_CHESTPLATE, SOLAR_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(BLANK_SOLAR_CRYSTAL.get()));
    public static final DeferredItem<Item> GREEN_SOLARIX = ITEMS.register("green_solarix",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"solar_green", NinjaStormItems.GREEN_SAMURAI_NINJA_POWER_DISK, SOLAR_HELMET, SOLAR_CHESTPLATE, SOLAR_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(BLANK_SOLAR_CRYSTAL.get()));
    public static final DeferredItem<Item> PINK_SOLARIX = ITEMS.register("pink_solarix",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"solar_pink", RANGER_SLAYER_POWER_COIN, SOLAR_HELMET, SOLAR_CHESTPLATE, SOLAR_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(BLANK_SOLAR_CRYSTAL.get()));

    public static final DeferredItem<BaseSwordItem> SOLAR_CHAKRAM = ITEMS.register("solar_chakram",
            () -> new BaseSwordItem(Tiers.DIAMOND, 8, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(BLANK_SOLAR_CRYSTAL.get()));
    public static final DeferredItem<BaseSwordItem> SOLAR_BATON = ITEMS.register("solar_baton",
            () -> new BaseSwordItem(Tiers.DIAMOND, 7, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(BLANK_SOLAR_CRYSTAL.get()));
    public static final DeferredItem<BaseSwordItem> SOLAR_SWORD = ITEMS.register("solar_sword",
            () -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(BLANK_SOLAR_CRYSTAL.get()));
    public static final DeferredItem<BaseSwordItem> SOLAR_GREATSWORD = ITEMS.register("solar_greatsword",
            () -> new BaseSwordItem(Tiers.DIAMOND, 12, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(BLANK_SOLAR_CRYSTAL.get()));
    public static final DeferredItem<BaseSwordItem> SOLAR_KATANA = ITEMS.register("solar_katana",
            () -> new BaseSwordItem(Tiers.DIAMOND, 8, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(BLANK_SOLAR_CRYSTAL.get()));
    public static final DeferredItem<SwordItem> SOLAR_ENERGY_BOOMERANG = ITEMS.register("solar_energy_boomerang",
            () -> new BaseThrowableItem(Tiers.DIAMOND, 12, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(BLANK_SOLAR_CRYSTAL.get()));
    public static final DeferredItem<BaseBlasterItem> SOLAR_ENERGY_BOW = ITEMS.register("solar_energy_bow",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(BLANK_SOLAR_CRYSTAL.get()));
    public static final DeferredItem<BaseSwordItem> SOLAR_CHUKS = ITEMS.register("solar_chuks",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(BLANK_SOLAR_CRYSTAL.get()));

    //Omega Rangers
    public static final DeferredItem<Item> OMEGA_LOGO = ITEMS.register("omega_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.COMICS));

    public static final DeferredItem<Item> OMEGA_RED_LOGO = ITEMS.register("omega_red_logo",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","omega_red","blank")
                    .AddToTabList(RangerTabs.COMICS));
    public static final DeferredItem<Item> OMEGA_BLUE_LOGO = ITEMS.register("omega_blue_logo",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","omega_blue","blank")
                    .AddToTabList(RangerTabs.COMICS));
    public static final DeferredItem<Item> OMEGA_YELLOW_LOGO = ITEMS.register("omega_yellow_logo",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","omega_yellow","blank")
                    .AddToTabList(RangerTabs.COMICS));
    public static final DeferredItem<Item> OMEGA_BLACK_LOGO = ITEMS.register("omega_black_logo",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","omega_black","blank")
                    .AddToTabList(RangerTabs.COMICS));
    public static final DeferredItem<Item> OMEGA_GOLD_LOGO_DEATH = ITEMS.register("omega_gold_logo_death",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"_death","omega_gold","blank"));
    public static final DeferredItem<Item> OMEGA_GOLD_LOGO = ITEMS.register("omega_gold_logo",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","omega_gold","blank")
                    .addSwitchForm(OMEGA_GOLD_LOGO_DEATH.get()).AddToTabList(RangerTabs.COMICS));

    public static final DeferredItem<Item> OMEGA_HELMET = ITEMS.register("omega_head",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(OMEGA_LOGO.get()));
    public static final DeferredItem<Item> OMEGA_CHESTPLATE = ITEMS.register("omega_torso",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(OMEGA_LOGO.get()));
    public static final DeferredItem<Item> OMEGA_LEGGINGS = ITEMS.register("omega_legs",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(OMEGA_LOGO.get()));

    public static final DeferredItem<Item> OMEGA_RED_MORPHER = ITEMS.register("omega_red_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"omega_red", OMEGA_RED_LOGO, OMEGA_HELMET, OMEGA_CHESTPLATE, OMEGA_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(OMEGA_LOGO.get()));
    public static final DeferredItem<Item> OMEGA_BLUE_MORPHER = ITEMS.register("omega_blue_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"omega_blue", OMEGA_BLUE_LOGO, OMEGA_HELMET, OMEGA_CHESTPLATE, OMEGA_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(OMEGA_LOGO.get()));
    public static final DeferredItem<Item> OMEGA_YELLOW_MORPHER = ITEMS.register("omega_yellow_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"omega_yellow", OMEGA_YELLOW_LOGO, OMEGA_HELMET, OMEGA_CHESTPLATE, OMEGA_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(OMEGA_LOGO.get()));
    public static final DeferredItem<Item> OMEGA_BLACK_MORPHER = ITEMS.register("omega_black_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"omega_black", OMEGA_BLACK_LOGO, OMEGA_HELMET, OMEGA_CHESTPLATE, OMEGA_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(OMEGA_LOGO.get()));
    public static final DeferredItem<Item> OMEGA_GOLD_MORPHER = ITEMS.register("omega_gold_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"omega_gold", OMEGA_GOLD_LOGO, OMEGA_HELMET, OMEGA_CHESTPLATE, OMEGA_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(OMEGA_LOGO.get()));

    public static final DeferredItem<BaseSwordItem> OMEGA_KATANA = ITEMS.register("omega_katana",
            () -> new BaseSwordItem(Tiers.DIAMOND, 8, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(OMEGA_LOGO.get()));
    public static final DeferredItem<BaseSwordItem> OMEGA_HAMMER = ITEMS.register("omega_hammer",
            () -> new BaseSwordItem(Tiers.DIAMOND, 12, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(OMEGA_LOGO.get()));
    public static final DeferredItem<BaseSwordItem> OMEGA_KAMA = ITEMS.register("omega_kama",
            () -> new BaseSwordItem(Tiers.DIAMOND, 8, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(OMEGA_LOGO.get()));
    public static final DeferredItem<SwordItem> OMEGA_TRIDENT = ITEMS.register("omega_trident",
            () -> new BaseThrowableItem(Tiers.DIAMOND, 12, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(OMEGA_LOGO.get()));

    //Prime Rangers
    public static final DeferredItem<Item> PRIME_RITAS_WAND = ITEMS.register("prime_ritas_wand",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.COMICS));

    public static final DeferredItem<Item> RED_RIB = ITEMS.register("red_rib",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","prime_red","prime_red_belt")
                    .AddToTabList(RangerTabs.COMICS));
    public static final DeferredItem<Item> BLACK_SCALE = ITEMS.register("black_scale",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","prime_black","prime_black_belt")
                    .AddToTabList(RangerTabs.COMICS));
    public static final DeferredItem<Item> BLUE_BONE = ITEMS.register("blue_bone",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","prime_blue","prime_blue_belt")
                    .AddToTabList(RangerTabs.COMICS));
    public static final DeferredItem<Item> YELLOW_TALON = ITEMS.register("yellow_talon",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","prime_yellow","prime_yellow_belt")
                    .AddToTabList(RangerTabs.COMICS));
    public static final DeferredItem<Item> PINK_GEM = ITEMS.register("pink_gem",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","prime_pink","prime_pink_belt")
                    .AddToTabList(RangerTabs.COMICS));
    public static final DeferredItem<Item> GREEN_SPHERE = ITEMS.register("green_sphere",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","prime_green","prime_green_belt")
                    .AddToTabList(RangerTabs.COMICS));

    public static final DeferredItem<Item> PRIME_HELMET = ITEMS.register("prime_head",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(PRIME_RITAS_WAND.get()));
    public static final DeferredItem<Item> PRIME_CHESTPLATE = ITEMS.register("prime_torso",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(PRIME_RITAS_WAND.get()));
    public static final DeferredItem<Item> PRIME_LEGGINGS = ITEMS.register("prime_legs",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(PRIME_RITAS_WAND.get()));

    public static final DeferredItem<Item> RED_PRIME_COIN = ITEMS.register("red_prime_coin",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"prime_red", RED_RIB, PRIME_HELMET, PRIME_CHESTPLATE, PRIME_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(PRIME_RITAS_WAND.get()));
    public static final DeferredItem<Item> BLACK_PRIME_COIN = ITEMS.register("black_prime_coin",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"prime_black", BLACK_SCALE, PRIME_HELMET, PRIME_CHESTPLATE, PRIME_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(PRIME_RITAS_WAND.get()));
    public static final DeferredItem<Item> BLUE_PRIME_COIN = ITEMS.register("blue_prime_coin",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"prime_blue", BLUE_BONE, PRIME_HELMET, PRIME_CHESTPLATE, PRIME_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(PRIME_RITAS_WAND.get()));
    public static final DeferredItem<Item> YELLOW_PRIME_COIN = ITEMS.register("yellow_prime_coin",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"prime_yellow", YELLOW_TALON, PRIME_HELMET, PRIME_CHESTPLATE, PRIME_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(PRIME_RITAS_WAND.get()));
    public static final DeferredItem<Item> PINK_PRIME_COIN = ITEMS.register("pink_prime_coin",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"prime_pink", PINK_GEM, PRIME_HELMET, PRIME_CHESTPLATE, PRIME_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(PRIME_RITAS_WAND.get()));
    public static final DeferredItem<Item> GREEN_PRIME_COIN = ITEMS.register("green_prime_coin",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"prime_green", GREEN_SPHERE, PRIME_HELMET, PRIME_CHESTPLATE, PRIME_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(PRIME_RITAS_WAND.get()));

    public static final DeferredItem<BaseSwordItem> PRIME_RED_SWORD_BLADE = ITEMS.register("prime_red_sword_blade",
            () -> new BaseSwordItem(Tiers.DIAMOND, 8, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(PRIME_RITAS_WAND.get()));
    public static final DeferredItem<BaseSwordItem> PRIME_YELLOW_DAGGER_BLADE = ITEMS.register("prime_yellow_dagger_blade",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(PRIME_RITAS_WAND.get()));
    public static final DeferredItem<BaseSwordItem> PRIME_BLACK_STAFF = ITEMS.register("prime_black_staff",
            () -> new BaseSwordItem(Tiers.DIAMOND, 8, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(PRIME_RITAS_WAND.get()));
    public static final DeferredItem<BaseSwordItem> PRIME_PINK_MACE = ITEMS.register("prime_pink_mace",
            () -> new BaseSwordItem(Tiers.DIAMOND, 8, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.COMICS).ChangeRepairItem(PRIME_RITAS_WAND.get()));
    public static final DeferredItem<BaseBlasterItem> PRIME_RITA_STAFF = ITEMS.register("prime_rita_staff",
            () -> new BaseBlasterItem(Tiers.IRON, 0, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.MISC).setProjectile(BaseBlasterItem.BlasterProjectile.SMALL_FIREBALL).ChangeRepairItem(PRIME_RITAS_WAND.get()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
