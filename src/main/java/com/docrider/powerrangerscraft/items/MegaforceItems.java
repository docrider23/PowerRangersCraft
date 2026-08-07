package com.docrider.powerrangerscraft.items;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.items.megaforce.GoseiMorpherItem;
import com.docrider.powerrangerscraft.items.others.*;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MegaforceItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PowerRangersCraftCore.MODID);

    public static final DeferredItem<Item> MEGAFORCE_LOGO = ITEMS.register("megaforce_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.MEGAFORCE));

    public static final DeferredItem<Item> BLANK_POWER_CARD = ITEMS.register("blank_power_card",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.MEGAFORCE));

    public static final DeferredItem<Item> RED_CHANGE_POWER_CARD = ITEMS.register("red_change_power_card",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","megaforce_red","megaforce_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false))
            .ChangeBeltModel("geo/rangerbeltextra.geo.json").AddToTabList(RangerTabs.MEGAFORCE));
    public static final DeferredItem<Item> PINK_CHANGE_POWER_CARD = ITEMS.register("pink_change_power_card",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","megaforce_pink","megaforce_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false))
                    .ChangeBeltModel("geo/rangerbeltextra.geo.json").AddToTabList(RangerTabs.MEGAFORCE));
    public static final DeferredItem<Item> BLACK_CHANGE_POWER_CARD = ITEMS.register("black_change_power_card",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","megaforce_black","megaforce_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false))
                    .ChangeBeltModel("geo/rangerbeltextra.geo.json").AddToTabList(RangerTabs.MEGAFORCE));
    public static final DeferredItem<Item> YELLOW_CHANGE_POWER_CARD = ITEMS.register("yellow_change_power_card",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","megaforce_yellow","megaforce_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false))
                    .ChangeBeltModel("geo/rangerbeltextra.geo.json").AddToTabList(RangerTabs.MEGAFORCE));
    public static final DeferredItem<Item> BLUE_CHANGE_POWER_CARD = ITEMS.register("blue_change_power_card",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","megaforce_blue","megaforce_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false))
                    .ChangeBeltModel("geo/rangerbeltextra.geo.json").AddToTabList(RangerTabs.MEGAFORCE));
    public static final DeferredItem<Item> ROBO_KNIGHT_CHANGE_POWER_CARD_DARK = ITEMS.register("robo_knight_change_power_card_dark",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"_dark","robo_knight","robo_knight_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false)));
    public static final DeferredItem<Item> ROBO_KNIGHT_CHANGE_POWER_CARD = ITEMS.register("robo_knight_change_power_card",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","robo_knight","robo_knight_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false))
                    .addSwitchForm(ROBO_KNIGHT_CHANGE_POWER_CARD_DARK.get()).AddToTabList(RangerTabs.MEGAFORCE));
    public static final DeferredItem<Item> GREEN_CHANGE_POWER_CARD = ITEMS.register("green_change_power_card",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","megaforce_green","megaforce_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false))
                    .ChangeBeltModel("geo/rangerbeltextra.geo.json").AddToTabList(RangerTabs.MEGAFORCE));

    public static final DeferredItem<Item> RED_ULTRA_POWER_CARD = ITEMS.register("red_ultra_power_card",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"_ultra","megaforce_red","megaforce_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false))
                    .ChangeBeltModel("geo/rangerbeltextra.geo.json").AddToTabList(RangerTabs.MEGAFORCE));
    public static final DeferredItem<Item> PINK_ULTRA_POWER_CARD = ITEMS.register("pink_ultra_power_card",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"_ultra","megaforce_pink","megaforce_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false))
                    .ChangeBeltModel("geo/rangerbeltextra.geo.json").AddToTabList(RangerTabs.MEGAFORCE));
    public static final DeferredItem<Item> BLACK_ULTRA_POWER_CARD = ITEMS.register("black_ultra_power_card",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"_ultra","megaforce_black","megaforce_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false))
                    .ChangeBeltModel("geo/rangerbeltextra.geo.json").AddToTabList(RangerTabs.MEGAFORCE));
    public static final DeferredItem<Item> YELLOW_ULTRA_POWER_CARD = ITEMS.register("yellow_ultra_power_card",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"_ultra","megaforce_yellow","megaforce_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false))
                    .ChangeBeltModel("geo/rangerbeltextra.geo.json").AddToTabList(RangerTabs.MEGAFORCE));
    public static final DeferredItem<Item> BLUE_ULTRA_POWER_CARD = ITEMS.register("blue_ultra_power_card",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"_ultra","megaforce_blue","megaforce_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false))
                    .ChangeBeltModel("geo/rangerbeltextra.geo.json").AddToTabList(RangerTabs.MEGAFORCE));

    public static final DeferredItem<Item> MEGAFORCE_HELMET = ITEMS.register("megaforce_head",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RangerTabs.MEGAFORCE).ChangeRepairItem(BLANK_POWER_CARD.get()));
    public static final DeferredItem<Item> MEGAFORCE_CHESTPLATE = ITEMS.register("megaforce_torso",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RangerTabs.MEGAFORCE).ChangeRepairItem(BLANK_POWER_CARD.get()));
    public static final DeferredItem<Item> MEGAFORCE_LEGGINGS = ITEMS.register("megaforce_legs",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RangerTabs.MEGAFORCE).ChangeRepairItem(BLANK_POWER_CARD.get()));

    public static final DeferredItem<Item> RED_GOSEI_MORPHER = ITEMS.register("red_gosei_morpher",
            () -> new GoseiMorpherItem(ArmorMaterials.DIAMOND,"megaforce_red", RED_CHANGE_POWER_CARD,MEGAFORCE_HELMET,MEGAFORCE_CHESTPLATE,MEGAFORCE_LEGGINGS,new Item.Properties())
                    .Add_Extra_Base_Form_Items(OtherItems.BLANK_FORM).AddToTabList(RangerTabs.MEGAFORCE).ChangeRepairItem(BLANK_POWER_CARD.get()));
    public static final DeferredItem<Item> PINK_GOSEI_MORPHER = ITEMS.register("pink_gosei_morpher",
            () -> new GoseiMorpherItem(ArmorMaterials.DIAMOND,"megaforce_pink",PINK_CHANGE_POWER_CARD,MEGAFORCE_HELMET,MEGAFORCE_CHESTPLATE,MEGAFORCE_LEGGINGS,new Item.Properties())
                    .Add_Extra_Base_Form_Items(OtherItems.BLANK_FORM).AddToTabList(RangerTabs.MEGAFORCE).ChangeRepairItem(BLANK_POWER_CARD.get()));
    public static final DeferredItem<Item> BLACK_GOSEI_MORPHER = ITEMS.register("black_gosei_morpher",
            () -> new GoseiMorpherItem(ArmorMaterials.DIAMOND,"megaforce_black",BLACK_CHANGE_POWER_CARD,MEGAFORCE_HELMET,MEGAFORCE_CHESTPLATE,MEGAFORCE_LEGGINGS,new Item.Properties())
                    .Add_Extra_Base_Form_Items(OtherItems.BLANK_FORM).AddToTabList(RangerTabs.MEGAFORCE).ChangeRepairItem(BLANK_POWER_CARD.get()));
    public static final DeferredItem<Item> YELLOW_GOSEI_MORPHER = ITEMS.register("yellow_gosei_morpher",
            () -> new GoseiMorpherItem(ArmorMaterials.DIAMOND,"megaforce_yellow",YELLOW_CHANGE_POWER_CARD,MEGAFORCE_HELMET,MEGAFORCE_CHESTPLATE,MEGAFORCE_LEGGINGS,new Item.Properties())
                    .Add_Extra_Base_Form_Items(OtherItems.BLANK_FORM).AddToTabList(RangerTabs.MEGAFORCE).ChangeRepairItem(BLANK_POWER_CARD.get()));
    public static final DeferredItem<Item> BLUE_GOSEI_MORPHER = ITEMS.register("blue_gosei_morpher",
            () -> new GoseiMorpherItem(ArmorMaterials.DIAMOND,"megaforce_blue",BLUE_CHANGE_POWER_CARD,MEGAFORCE_HELMET,MEGAFORCE_CHESTPLATE,MEGAFORCE_LEGGINGS,new Item.Properties())
                    .Add_Extra_Base_Form_Items(OtherItems.BLANK_FORM).AddToTabList(RangerTabs.MEGAFORCE).ChangeRepairItem(BLANK_POWER_CARD.get()));

    public static final DeferredItem<Item> ROBO_MORPHER = ITEMS.register("robo_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"robo_knight",ROBO_KNIGHT_CHANGE_POWER_CARD,MEGAFORCE_HELMET,MEGAFORCE_CHESTPLATE,MEGAFORCE_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.MEGAFORCE).ChangeRepairItem(BLANK_POWER_CARD.get()));

    public static final DeferredItem<Item> GREEN_GOSEI_MORPHER = ITEMS.register("green_gosei_morpher",
            () -> new GoseiMorpherItem(ArmorMaterials.DIAMOND,"megaforce_green",GREEN_CHANGE_POWER_CARD,MEGAFORCE_HELMET,MEGAFORCE_CHESTPLATE,MEGAFORCE_LEGGINGS,new Item.Properties())
                    .Add_Extra_Base_Form_Items(OtherItems.BLANK_FORM).AddToTabList(RangerTabs.MEGAFORCE).ChangeRepairItem(BLANK_POWER_CARD.get()));

    public static final DeferredItem<BaseBlasterItem> MEGA_BLASTER = ITEMS.register("mega_blaster",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties())
                    .AddToTabList(RangerTabs.MEGAFORCE).ChangeRepairItem(BLANK_POWER_CARD.get()));

    public static final DeferredItem<BaseBlasterItem> MEGA_BLASTER_DRAGON = ITEMS.register("mega_blaster_dragon",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.MEGAFORCE).ChangeRepairItem(BLANK_POWER_CARD.get()));
    public static final DeferredItem<BaseBlasterItem> MEGA_BLASTER_PHOENIX = ITEMS.register("mega_blaster_phoenix",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.MEGAFORCE).ChangeRepairItem(BLANK_POWER_CARD.get()));
    public static final DeferredItem<BaseBlasterItem> MEGA_BLASTER_SNAKE = ITEMS.register("mega_blaster_snake",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.MEGAFORCE).ChangeRepairItem(BLANK_POWER_CARD.get()));
    public static final DeferredItem<BaseBlasterItem> MEGA_BLASTER_TIGER = ITEMS.register("mega_blaster_tiger",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.MEGAFORCE).ChangeRepairItem(BLANK_POWER_CARD.get()));
    public static final DeferredItem<BaseBlasterItem> MEGA_BLASTER_SHARK = ITEMS.register("mega_blaster_shark",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.MEGAFORCE).ChangeRepairItem(BLANK_POWER_CARD.get()));

    public static final DeferredItem<SwordItem> DRAGON_SWORD = ITEMS.register("dragon_sword",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.MEGAFORCE).ChangeRepairItem(BLANK_POWER_CARD.get()));
    public static final DeferredItem<BaseBlasterItem> PHOENIX_SHOT = ITEMS.register("phoenix_shot",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.MEGAFORCE).ChangeRepairItem(BLANK_POWER_CARD.get()));
    public static final DeferredItem<SwordItem> SNAKE_AXE = ITEMS.register("snake_axe",
            () -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.MEGAFORCE).ChangeRepairItem(BLANK_POWER_CARD.get()));
    public static final DeferredItem<SwordItem> TIGER_CLAW = ITEMS.register("tiger_claw",
            () -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.MEGAFORCE).ChangeRepairItem(BLANK_POWER_CARD.get()));
    public static final DeferredItem<BaseBlasterItem> SHARK_BOWGUN = ITEMS.register("shark_bowgun",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.MEGAFORCE).ChangeRepairItem(BLANK_POWER_CARD.get()));

    public static final DeferredItem<BaseBlasterItem> SKY_BLASTER = ITEMS.register("sky_blaster",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).setProjectile(BaseBlasterItem.BlasterProjectile.SMALL_FIREBALL).AddToTabList(RangerTabs.MEGAFORCE).ChangeRepairItem(BLANK_POWER_CARD.get()));
    public static final DeferredItem<BaseBlasterItem> LAND_SEA_BLASTER = ITEMS.register("land_sea_blaster",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).setProjectile(BaseBlasterItem.BlasterProjectile.SMALL_FIREBALL).AddToTabList(RangerTabs.MEGAFORCE).ChangeRepairItem(BLANK_POWER_CARD.get()));
    public static final DeferredItem<BaseBlasterItem> MEGAFORCE_BLASTER = ITEMS.register("megaforce_blaster",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).setProjectile(BaseBlasterItem.BlasterProjectile.LARGE_FIREBALL).AddToTabList(RangerTabs.MEGAFORCE).ChangeRepairItem(BLANK_POWER_CARD.get()));

    public static final DeferredItem<BaseBlasterItem> ROBO_BLADE = ITEMS.register("robo_blade",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).IsSwordGun().AddToTabList(RangerTabs.MEGAFORCE).ChangeRepairItem(BLANK_POWER_CARD.get()));
    public static final DeferredItem<BaseBlasterItem> DYNAMIC_ROBO_BLASTER = ITEMS.register("dynamic_robo_blaster",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).IsSuperGun().AddToTabList(RangerTabs.MEGAFORCE).ChangeRepairItem(BLANK_POWER_CARD.get()));

    public static final DeferredItem<SwordItem> ULTRA_SWORD = ITEMS.register("ultra_sword",
            () -> new BaseDualSwordItem(Tiers.DIAMOND, 16, -2.4F, new Item.Properties().rarity(Rarity.EPIC)).IsDualWeapon().AddToTabList(RangerTabs.MEGAFORCE).ChangeRepairItem(BLANK_POWER_CARD.get()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
