package com.docrider.powerrangerscraft.items;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.effect.EffectCore;
import com.docrider.powerrangerscraft.items.others.BaseItem;
import com.docrider.powerrangerscraft.items.others.RangerFormChangeItem;
import com.docrider.powerrangerscraft.sounds.ModSounds;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class OtherItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PowerRangersCraftCore.MODID);

    public static String[] SentaiRobo = new String[] {"wild_force_megazord","kongazord","predazord","predazord_blue_moon",
            "isis_megazord","animus","ultimus_megazord"};

    public static final DeferredItem<Item> MECHA_GEAR = ITEMS.register("mecha_gear",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.MISC));

    public static final DeferredItem<Item> TRANSPORTAL_DEVICE = ITEMS.register("transportal_device",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.MISC));

    public static final DeferredItem<Item> BLANK_FORM = ITEMS.register("blank_form",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","",""));

    public static final DeferredItem<Item> POWER_RANGERS_LOGO = ITEMS.register("power_rangers_logo",
            () -> new RangerFormChangeItem(new Item.Properties(), 0, "", "", "",
                    new MobEffectInstance(EffectCore.BIG, 40, 2,true,false))
                    .ChangeSlot(2).addSwitchForm(BLANK_FORM.get()).AddCompatibilityList(SentaiRobo).AddToTabList(RangerTabs.MISC));

    public static final DeferredItem<Item> ALIEN_LOGO = ITEMS.register("alien_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.MISC));

    public static final DeferredItem<Item> ZEO_LOGO = ITEMS.register("zeo_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.MISC));

    public static final DeferredItem<Item> IN_SPACE_LOGO = ITEMS.register("in_space_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.MISC));

    public static final DeferredItem<Item> LIGHTSPEED_RESCUE_LOGO = ITEMS.register("lightspeed_rescue_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.MISC));

    public static final DeferredItem<Item> TIME_FORCE_LOGO = ITEMS.register("time_force_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.MISC));

    public static final DeferredItem<Item> NINJA_STORM_LOGO = ITEMS.register("ninja_storm_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.MISC));

    public static final DeferredItem<Item> DINO_THUNDER_LOGO = ITEMS.register("dino_thunder_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.MISC));

    public static final DeferredItem<Item> SPD_LOGO = ITEMS.register("spd_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.MISC));

    public static final DeferredItem<Item> MYSTIC_FORCE_LOGO = ITEMS.register("mystic_force_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.MISC));

    public static final DeferredItem<Item> OPERATION_OVERDRIVE_LOGO = ITEMS.register("operation_overdrive_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.MISC));

    public static final DeferredItem<Item> JUNGLE_FURY_LOGO = ITEMS.register("jungle_fury_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.MISC));

    public static final DeferredItem<Item> RPM_LOGO = ITEMS.register("rpm_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.MISC));

    public static final DeferredItem<Item> MEGAFORCE_LOGO = ITEMS.register("megaforce_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.MISC));

    public static final DeferredItem<Item> SUPER_MEGAFORCE_LOGO = ITEMS.register("super_megaforce_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.MISC));

    public static final DeferredItem<Item> DINO_CHARGE_LOGO = ITEMS.register("dino_charge_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.MISC));

    public static final DeferredItem<Item> NINJA_STEEL_LOGO = ITEMS.register("ninja_steel_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.MISC));

    public static final DeferredItem<Item> BEAST_MORPHERS_LOGO = ITEMS.register("beast_morphers_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.MISC));

    public static final DeferredItem<Item> GO_GO_POWER_RANGERS_MUSIC_DISC = ITEMS.register("go_go_power_rangers_music_disc",
            () -> new Item(new Item.Properties().jukeboxPlayable(ModSounds.GO_GO_POWER_RANGERS_KEY).stacksTo(1)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}