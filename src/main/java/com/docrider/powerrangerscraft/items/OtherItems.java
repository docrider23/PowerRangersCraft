package com.docrider.powerrangerscraft.items;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.effect.EffectCore;
import com.docrider.powerrangerscraft.items.others.BaseDropItem;
import com.docrider.powerrangerscraft.items.others.BaseItem;
import com.docrider.powerrangerscraft.items.others.RangerFormChangeItem;
import com.docrider.powerrangerscraft.sounds.ModSounds;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
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

    public static final DeferredItem<Item> POWER_RANGERS_LOGO = ITEMS.register("power_rangers_logo",
            () -> new RangerFormChangeItem(new Item.Properties(), 0, "", "", "",
                    new MobEffectInstance(EffectCore.BIG, 40, 2,true,false))
                    .ChangeSlot(2).addSwitchForm(BLANK_FORM.get()).AddCompatibilityList(SentaiRobo).AddToTabList(RangerTabs.MISC));

    public static final DeferredItem<Item> GO_GO_POWER_RANGERS_MUSIC_DISC = ITEMS.register("go_go_power_rangers_music_disc",
            () -> new Item(new Item.Properties().jukeboxPlayable(ModSounds.GO_GO_POWER_RANGERS_KEY).stacksTo(1)));

    public static final DeferredItem<Item> GO_GO_ALIEN_RANGERS_MUSIC_DISC = ITEMS.register("go_go_alien_rangers_music_disc",
            () -> new Item(new Item.Properties().jukeboxPlayable(ModSounds.GO_GO_ALIEN_RANGERS_KEY).stacksTo(1)));

    public static final DeferredItem<Item> GIFT = ITEMS.register("gift",
            () -> new BaseDropItem(new Item.Properties().rarity(Rarity.UNCOMMON), ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "items/gift")).AddToList(RangerTabs.MISC));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}