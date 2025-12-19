package com.docrider.powerrangerscraft.items;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.effect.EffectCore;
import com.docrider.powerrangerscraft.items.others.RangerFormChangeItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class GamesItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PowerRangersCraftCore.MODID);

    public static final DeferredItem<Item> GAME_CONTROLLER_16_BIT_MMPR_PINK = ITEMS.register("game_controller_16_bit_mmpr_pink",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"_16_bit","mmpr_pink","mmpr_pink_belt").ChangeBeltModel("geo/mmpr_belt.geo.json"));
    public static final DeferredItem<Item> GAME_CONTROLLER_16_BIT_MMPR_YELLOW = ITEMS.register("game_controller_16_bit_mmpr_yellow",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"_16_bit","mmpr_yellow","mmpr_yellow_belt").ChangeBeltModel("geo/mmpr_belt.geo.json").addAlternative(GAME_CONTROLLER_16_BIT_MMPR_PINK.get()));
    public static final DeferredItem<Item> GAME_CONTROLLER_16_BIT_MMPR_BLACK = ITEMS.register("game_controller_16_bit_mmpr_black",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"_16_bit","mmpr_black","mmpr_black_belt").ChangeBeltModel("geo/mmpr_belt.geo.json").addAlternative(GAME_CONTROLLER_16_BIT_MMPR_YELLOW.get()));
    public static final DeferredItem<Item> GAME_CONTROLLER_16_BIT = ITEMS.register("game_controller_16_bit",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"_16_bit","mmpr_blue","mmpr_blue_belt").ChangeBeltModel("geo/mmpr_belt.geo.json").addAlternative(GAME_CONTROLLER_16_BIT_MMPR_BLACK.get()).AddToTabList(RangerTabs.MISC));

    public static final DeferredItem<Item> BATTLE_FOR_THE_GRID_GAME_RANGER_SLAYER = ITEMS.register("battle_for_the_grid_game_ranger_slayer",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"_game","ranger_slayer","ranger_slayer_belt_game").ChangeBeltModel("geo/mmpr_belt.geo.json"));
    public static final DeferredItem<Item> BATTLE_FOR_THE_GRID_GAME_MMPR_WHITE = ITEMS.register("battle_for_the_grid_game_mmpr_white",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"_game","mmpr_white","mmpr_white_belt_game").addAlternative(BATTLE_FOR_THE_GRID_GAME_RANGER_SLAYER.get()));
    public static final DeferredItem<Item> BATTLE_FOR_THE_GRID_GAME_MMPR_GREEN = ITEMS.register("battle_for_the_grid_game_mmpr_green",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"_game","mmpr_green","mmpr_green_belt_game").ChangeBeltModel("geo/mmpr_belt.geo.json").addAlternative(BATTLE_FOR_THE_GRID_GAME_MMPR_WHITE.get()));
    public static final DeferredItem<Item> BATTLE_FOR_THE_GRID_GAME_MMPR_PINK = ITEMS.register("battle_for_the_grid_game_mmpr_pink",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"_game","mmpr_pink","mmpr_pink_belt_game").ChangeBeltModel("geo/mmpr_belt.geo.json").addAlternative(BATTLE_FOR_THE_GRID_GAME_MMPR_GREEN.get()));
    public static final DeferredItem<Item> BATTLE_FOR_THE_GRID_GAME_MMPR_RED = ITEMS.register("battle_for_the_grid_game_mmpr_red",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"_game","mmpr_red","mmpr_red_belt_game").ChangeBeltModel("geo/mmpr_belt.geo.json").addAlternative(BATTLE_FOR_THE_GRID_GAME_MMPR_PINK.get()));
    public static final DeferredItem<Item> BATTLE_FOR_THE_GRID_GAME_REBOOT_BLUE = ITEMS.register("battle_for_the_grid_game_reboot_blue",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"_game","reboot_blue","reboot_blue_belt").IsGlowing().IsBeltGlowing().addAlternative(BATTLE_FOR_THE_GRID_GAME_MMPR_RED.get()));
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

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
