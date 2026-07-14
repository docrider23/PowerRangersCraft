package com.docrider.powerrangerscraft.items;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.items.others.BaseItem;
import com.docrider.powerrangerscraft.items.others.RangerArmorItem;
import com.docrider.powerrangerscraft.items.others.RangerChangerItem;
import com.docrider.powerrangerscraft.items.others.RangerFormChangeItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
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
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"megaforce_red", RED_CHANGE_POWER_CARD,MEGAFORCE_HELMET,MEGAFORCE_CHESTPLATE,MEGAFORCE_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.MEGAFORCE).ChangeRepairItem(BLANK_POWER_CARD.get()));
    public static final DeferredItem<Item> PINK_GOSEI_MORPHER = ITEMS.register("pink_gosei_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"megaforce_pink",PINK_CHANGE_POWER_CARD,MEGAFORCE_HELMET,MEGAFORCE_CHESTPLATE,MEGAFORCE_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.MEGAFORCE).ChangeRepairItem(BLANK_POWER_CARD.get()));
    public static final DeferredItem<Item> BLACK_GOSEI_MORPHER = ITEMS.register("black_gosei_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"megaforce_black",BLACK_CHANGE_POWER_CARD,MEGAFORCE_HELMET,MEGAFORCE_CHESTPLATE,MEGAFORCE_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.MEGAFORCE).ChangeRepairItem(BLANK_POWER_CARD.get()));
    public static final DeferredItem<Item> YELLOW_GOSEI_MORPHER = ITEMS.register("yellow_gosei_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"megaforce_yellow",YELLOW_CHANGE_POWER_CARD,MEGAFORCE_HELMET,MEGAFORCE_CHESTPLATE,MEGAFORCE_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.MEGAFORCE).ChangeRepairItem(BLANK_POWER_CARD.get()));
    public static final DeferredItem<Item> BLUE_GOSEI_MORPHER = ITEMS.register("blue_gosei_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"megaforce_blue",BLUE_CHANGE_POWER_CARD,MEGAFORCE_HELMET,MEGAFORCE_CHESTPLATE,MEGAFORCE_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.MEGAFORCE).ChangeRepairItem(BLANK_POWER_CARD.get()));

    public static final DeferredItem<Item> ROBO_MORPHER = ITEMS.register("robo_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"robo_knight",ROBO_KNIGHT_CHANGE_POWER_CARD,MEGAFORCE_HELMET,MEGAFORCE_CHESTPLATE,MEGAFORCE_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.MEGAFORCE).ChangeRepairItem(BLANK_POWER_CARD.get()));

    public static final DeferredItem<Item> GREEN_GOSEI_MORPHER = ITEMS.register("green_gosei_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"megaforce_green",GREEN_CHANGE_POWER_CARD,MEGAFORCE_HELMET,MEGAFORCE_CHESTPLATE,MEGAFORCE_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.MEGAFORCE).ChangeRepairItem(BLANK_POWER_CARD.get()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
