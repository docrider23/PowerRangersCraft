package com.docrider.powerrangerscraft.items;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.effect.EffectCore;
import com.docrider.powerrangerscraft.items.others.BaseItem;
import com.docrider.powerrangerscraft.items.others.RangerFormChangeItem;
import com.docrider.powerrangerscraft.sounds.ModSounds;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class OtherItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PowerRangersCraftCore.MODID);

    public static String[] SentaiRobo = new String[] {"wild_force_megazord","kongazord","predazord","predazord_blue_moon",
            "isis_megazord","animus","ultimus_megazord","sentinel_knight"};

    public static final DeferredItem<Item> BLANK_FORM = ITEMS.register("blank_form",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","",""));

    public static final DeferredItem<Item> BASE_SWORD = ITEMS.register("base_sword",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.MISC));

    public static final DeferredItem<Item> MECHA_GEAR = ITEMS.register("mecha_gear",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.MISC));

    public static final DeferredItem<Item> BASE_MECHA_SWORD = ITEMS.register("base_mecha_sword",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.MISC));

    public static final DeferredItem<Item> TRANSPORTAL_DEVICE = ITEMS.register("transportal_device",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.MISC));

    public static final DeferredItem<Item> BATTLE_FOR_THE_GRID_GAME_REBOOT_BLUE = ITEMS.register("battle_for_the_grid_game_reboot_blue",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"_game","reboot_blue","reboot_blue_belt").IsGlowing().IsBeltGlowing());
    public static final DeferredItem<Item> BATTLE_FOR_THE_GRID_GAME_MAGNA_DEFENDER = ITEMS.register("battle_for_the_grid_game_magna_defender",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"_game","magna_defender","magna_defender_belt_game",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
                    new MobEffectInstance(EffectCore.SLASH, 40, 2,true,false)).ChangeModel("magna_defender.geo.json").ChangeBeltModel("geo/magna_defender_belt.geo.json").addAlternative(BATTLE_FOR_THE_GRID_GAME_REBOOT_BLUE.get()));
    public static final DeferredItem<Item> BATTLE_FOR_THE_GRID_GAME = ITEMS.register("battle_for_the_grid_game",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"_game","princess_samurai_red","samurai_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(EffectCore.SLASH, 40, 2,true,false),
                    new MobEffectInstance(EffectCore.FIRESLASH, 40, 2,true,false)).alsoChange2ndSlot(OtherItems.BLANK_FORM.get()).ChangeBeltModel("geo/rangerbeltweapon.geo.json").addAlternative(BATTLE_FOR_THE_GRID_GAME_MAGNA_DEFENDER.get()).AddToTabList(RangerTabs.MISC));

    public static final DeferredItem<Item> POWER_RANGERS_LOGO = ITEMS.register("power_rangers_logo",
            () -> new RangerFormChangeItem(new Item.Properties(), 0, "", "", "",
                    new MobEffectInstance(EffectCore.BIG, 40, 2,true,false))
                    .ChangeSlot(2).addSwitchForm(BLANK_FORM.get()).AddCompatibilityList(SentaiRobo).AddToTabList(RangerTabs.MISC));

    public static final DeferredItem<Item> ALIEN_LOGO = ITEMS.register("alien_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.MISC));

    public static final DeferredItem<Item> TIME_FORCE_LOGO = ITEMS.register("time_force_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.MISC));

    public static final DeferredItem<Item> JUNGLE_FURY_LOGO = ITEMS.register("jungle_fury_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.MISC));

    public static final DeferredItem<Item> RPM_LOGO = ITEMS.register("rpm_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.MISC));

    public static final DeferredItem<Item> MEGAFORCE_LOGO = ITEMS.register("megaforce_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.MISC));

    public static final DeferredItem<Item> SUPER_MEGAFORCE_LOGO = ITEMS.register("super_megaforce_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.MISC));

    public static final DeferredItem<Item> BEAST_MORPHERS_LOGO = ITEMS.register("beast_morphers_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.MISC));

    public static final DeferredItem<Item> GO_GO_POWER_RANGERS_MUSIC_DISC = ITEMS.register("go_go_power_rangers_music_disc",
            () -> new Item(new Item.Properties().jukeboxPlayable(ModSounds.GO_GO_POWER_RANGERS_KEY).stacksTo(1)));

    public static final DeferredItem<Item> GO_GO_ALIEN_RANGERS_MUSIC_DISC = ITEMS.register("go_go_alien_rangers_music_disc",
            () -> new Item(new Item.Properties().jukeboxPlayable(ModSounds.GO_GO_ALIEN_RANGERS_KEY).stacksTo(1)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}