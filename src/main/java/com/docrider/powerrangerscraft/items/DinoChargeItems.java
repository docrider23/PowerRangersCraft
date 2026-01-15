package com.docrider.powerrangerscraft.items;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.items.dino_charge.DinoChargeMorpherItem;
import com.docrider.powerrangerscraft.items.others.*;
import com.docrider.powerrangerscraft.entity.MobsCore;
import net.minecraft.world.entity.animal.TropicalFish;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DinoChargeItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PowerRangersCraftCore.MODID);

    public static final DeferredItem<Item> DINO_CHARGE_LOGO = ITEMS.register("dino_charge_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.DINO_CHARGE));

    public static final DeferredItem<Item> EMPTY_DINO_CHARGER = ITEMS.register("empty_dino_charger",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.DINO_CHARGE));

    public static final DeferredItem<Item> SPINOSAURUS_DINO_CHARGER_SOLAR = ITEMS.register("spinosaurus_dino_charger_solar",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","solar_blue","blank").IsGlowing());
    public static final DeferredItem<Item> SPINOSAURUS_DINO_CHARGER = ITEMS.register("spinosaurus_dino_charger",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","dino_charge_dark","dino_charge_silver_belt")
                    .addAlternative(SPINOSAURUS_DINO_CHARGER_SOLAR.get()).AddToTabList(RangerTabs.DINO_CHARGE));
    public static final DeferredItem<Item> TYRANNOSAURUS_REX_DINO_CHARGER = ITEMS.register("tyrannosaurus_rex_dino_charger",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","dino_charge_red","dino_charge_belt")
                    .AddToTabList(RangerTabs.DINO_CHARGE));
    public static final DeferredItem<Item> DINO_CYCLE_CHARGER = ITEMS.register("dino_cycle_charger",
            () -> new SummonBikeItem(new Item.Properties(), MobsCore.DINO_CYCLE)
                    .AddToList(RangerTabs.DINO_CHARGE));

    public static final DeferredItem<Item> DINO_CHARGE_HELMET = ITEMS.register("dino_charge_head",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RangerTabs.DINO_CHARGE).ChangeRepairItem(EMPTY_DINO_CHARGER.get()));
    public static final DeferredItem<Item> DINO_CHARGE_CHESTPLATE = ITEMS.register("dino_charge_torso",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RangerTabs.DINO_CHARGE).ChangeRepairItem(EMPTY_DINO_CHARGER.get()));
    public static final DeferredItem<Item> DINO_CHARGE_LEGGINGS = ITEMS.register("dino_charge_legs",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RangerTabs.DINO_CHARGE).ChangeRepairItem(EMPTY_DINO_CHARGER.get()));

    public static final DeferredItem<Item> RED_DINO_CHARGE_MORPHER = ITEMS.register("red_dino_charge_morpher",
            () -> new DinoChargeMorpherItem(ArmorMaterials.DIAMOND,"dino_charge_red", TYRANNOSAURUS_REX_DINO_CHARGER,DINO_CHARGE_HELMET,DINO_CHARGE_CHESTPLATE,DINO_CHARGE_LEGGINGS,new Item.Properties()).Add_Extra_Base_Form_Items(OtherItems.BLANK_FORM).AddToTabList(RangerTabs.DINO_CHARGE).ChangeRepairItem(EMPTY_DINO_CHARGER.get()));
    public static final DeferredItem<Item> DARK_SPINO_BOOMERANG = ITEMS.register("dark_spino_boomerang",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"dino_charge_dark", SPINOSAURUS_DINO_CHARGER,DINO_CHARGE_HELMET,DINO_CHARGE_CHESTPLATE,DINO_CHARGE_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.DINO_CHARGE).ChangeRepairItem(EMPTY_DINO_CHARGER.get()));

    public static final DeferredItem<BaseBlasterItem> DINO_CHARGE_MORPHER = ITEMS.register("dino_charge_morpher",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 12, -2.4F, new Item.Properties()).AddToTabList(PowerRangersCraftCore.FORM_WEAPON_ITEM).AddToTabList(RangerTabs.DINO_CHARGE).ChangeRepairItem(EMPTY_DINO_CHARGER.get()));
    public static final DeferredItem<SwordItem> DINO_SABER = ITEMS.register("dino_saber",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.DINO_CHARGE).ChangeRepairItem(EMPTY_DINO_CHARGER.get()));
    public static final DeferredItem<BaseBlasterItem> DINO_BLADE_BLASTER = ITEMS.register("dino_blade_blaster",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 12, -2.4F, new Item.Properties()).KeepDifItem(DINO_SABER.get()).IsSuperGun().IsDualWeapon().AddToTabList(RangerTabs.DINO_CHARGE).ChangeRepairItem(EMPTY_DINO_CHARGER.get()));

    public static final DeferredItem<SwordItem> T_REX_SMASHER = ITEMS.register("t_rex_smasher",
            () -> new BaseSwordItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.DINO_CHARGE).ChangeRepairItem(EMPTY_DINO_CHARGER.get()));
    public static final DeferredItem<SwordItem> SPINO_BOOMERANG = ITEMS.register("spino_boomerang",
            () -> new BaseThrowableItem(Tiers.DIAMOND, 12, -2.4F, new Item.Properties()).isChanger(DARK_SPINO_BOOMERANG.get()).AddToTabList(PowerRangersCraftCore.FORM_WEAPON_ITEM).AddToTabList(RangerTabs.DINO_CHARGE).ChangeRepairItem(EMPTY_DINO_CHARGER.get()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
