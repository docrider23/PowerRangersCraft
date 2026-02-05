package com.docrider.powerrangerscraft.items;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.effect.EffectCore;
import com.docrider.powerrangerscraft.items.others.*;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AlienItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PowerRangersCraftCore.MODID);

    public static final DeferredItem<Item> ALIEN_LOGO = ITEMS.register("alien_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.ALIEN));

    public static final DeferredItem<Item> AQUITIAN_ENERGY = ITEMS.register("aquitian_energy",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.ALIEN));

    public static final DeferredItem<Item> RED_ALIEN_POWER_COIN = ITEMS.register("red_alien_power_coin",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","alien_red","alien_red_belt",
                    new MobEffectInstance(EffectCore.SLASH, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false))
                    .AddToTabList(RangerTabs.ALIEN));

    public static final DeferredItem<Item> ALIEN_HELMET = ITEMS.register("alien_head",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RangerTabs.ALIEN).ChangeRepairItem(ALIEN_LOGO.get()));
    public static final DeferredItem<Item> ALIEN_CHESTPLATE = ITEMS.register("alien_torso",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RangerTabs.ALIEN).ChangeRepairItem(ALIEN_LOGO.get()));
    public static final DeferredItem<Item> ALIEN_LEGGINGS = ITEMS.register("alien_legs",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RangerTabs.ALIEN).ChangeRepairItem(ALIEN_LOGO.get()));

    public static final DeferredItem<Item> RED_ALIEN_MORPHER = ITEMS.register("red_alien_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"alien_red",RED_ALIEN_POWER_COIN,ALIEN_HELMET,ALIEN_CHESTPLATE,ALIEN_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.ALIEN).ChangeRepairItem(ALIEN_LOGO.get()));

    public static final DeferredItem<SwordItem> AQUITIAN_SABER = ITEMS.register("aquitian_saber",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.ALIEN).ChangeRepairItem(ALIEN_LOGO.get()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
