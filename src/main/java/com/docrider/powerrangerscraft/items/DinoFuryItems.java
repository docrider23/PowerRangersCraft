package com.docrider.powerrangerscraft.items;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.effect.EffectCore;
import com.docrider.powerrangerscraft.items.others.*;
import com.docrider.powerrangerscraft.items.dino_fury.*;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DinoFuryItems {

	public static String[] RANGERS= new String[] {"dino_fury_red","dino_fury_blue","dino_fury_pink","dino_fury_green","dino_fury_black","dino_fury_gold","void_knight"};
	public static String[] DINO_FURY= new String[] {"dino_fury_red","dino_fury_blue","dino_fury_pink","dino_fury_green","dino_fury_black","dino_fury_gold"};

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PowerRangersCraftCore.MODID);
    
	public static final DeferredItem<Item> DINO_FURY_LOGO = ITEMS.register("dino_fury_logo",
    		() -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.DINO_FURY));
    
	public static final DeferredItem<Item> BLANK_DINO_KEY = ITEMS.register("blank_dino_key",
    		() -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.DINO_FURY));
    
	public static final DeferredItem<Item> DINO_KEY = ITEMS.register("dino_key",
    		() -> new BlankDinoKeyItem(new Item.Properties()));

	public static final DeferredItem<Item> T_REX_DINO_KEY_ZENITH = ITEMS.register("t_rex_dino_key_zenith",
			() -> new RangerFormChangeItem(new Item.Properties(),0,"","dino_fury_zenith","dino_fury_red_belt").alsoChange2ndSlot(OtherItems.BLANK_FORM.get()).HasCape().ChangeBeltModel("geo/dino_fury_belt.geo.json").ChangeModel("dino_master.geo.json"));

	public static final DeferredItem<Item> T_REX_DINO_KEY = ITEMS.register("t_rex_dino_key",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","dino_fury_red","dino_fury_red_belt",
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
            		new MobEffectInstance(EffectCore.SLASH, 40, 2,true,false))
			.alsoChange2ndSlot(OtherItems.BLANK_FORM.get()).addAlternative(T_REX_DINO_KEY_ZENITH.get()).HasCape().ChangeBeltModel("geo/dino_fury_belt.geo.json").AddToTabList(RangerTabs.DINO_FURY));

	public static final DeferredItem<Item> TRICERA_DINO_KEY = ITEMS.register("tricera_dino_key",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","dino_fury_blue","dino_fury_blue_belt",
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
            		new MobEffectInstance(EffectCore.SLASH, 40, 3,true,false))
			.alsoChange2ndSlot(OtherItems.BLANK_FORM.get()).HasCape().ChangeBeltModel("geo/dino_fury_belt.geo.json").AddToTabList(RangerTabs.DINO_FURY));
    
	public static final DeferredItem<Item> ANKYLO_DINO_KEY = ITEMS.register("ankylo_dino_key",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","dino_fury_pink","dino_fury_pink_belt",
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
            		new MobEffectInstance(EffectCore.SLASH, 40, 2,true,false))
			.alsoChange2ndSlot(OtherItems.BLANK_FORM.get()).HasCape().ChangeBeltModel("geo/dino_fury_belt.geo.json").AddToTabList(RangerTabs.DINO_FURY));
    
	public static final DeferredItem<Item> TIGER_DINO_KEY = ITEMS.register("tiger_dino_key",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","dino_fury_green","dino_fury_green_belt",
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
            		new MobEffectInstance(EffectCore.SLASH, 40, 2,true,false))
			.alsoChange2ndSlot(OtherItems.BLANK_FORM.get()).HasCape().ChangeBeltModel("geo/dino_fury_belt.geo.json").AddToTabList(RangerTabs.DINO_FURY));
    
	public static final DeferredItem<Item> STEGO_DINO_KEY = ITEMS.register("stego_dino_key",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","dino_fury_black","dino_fury_black_belt",
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
            		new MobEffectInstance(EffectCore.SLASH, 40, 2,true,false))
			.alsoChange2ndSlot(OtherItems.BLANK_FORM.get()).HasCape().ChangeBeltModel("geo/dino_fury_belt.geo.json").AddToTabList(RangerTabs.DINO_FURY));

	public static final DeferredItem<Item> MOSA_DINO_KEY = ITEMS.register("mosa_dino_key",
			() -> new DinoKeyItem(new Item.Properties(),0,"","dino_fury_gold","dino_fury_gold_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 2,true,false))
					.alsoChange2ndSlot(OtherItems.BLANK_FORM.get()).HasCape().AddToTabList(RangerTabs.DINO_FURY));
    
	public static final DeferredItem<Item> VOID_KNIGHT_KEY = ITEMS.register("void_knight_key",
            () -> new DinoKeyItem(new Item.Properties(),0,"","void_knight","blank",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
            		new MobEffectInstance(EffectCore.SLASH, 40, 2,true,false))
			.alsoChange2ndSlot(OtherItems.BLANK_FORM.get()).AddToTabList(RangerTabs.DINO_FURY));

	public static final DeferredItem<Item> EVIL_TRICERA_DINO_KEY = ITEMS.register("evil_tricera_dino_key",
			() -> new RangerFormChangeItem(new Item.Properties(),0,"","evil_dino_fury_blue","evil_dino_fury_blue_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(EffectCore.SLASH, 40, 3,true,false))
					.alsoChange2ndSlot(OtherItems.BLANK_FORM.get()).ChangeBeltModel("geo/rangerbeltchanger.geo.json").AddToTabList(RangerTabs.DINO_FURY));
    
	public static final DeferredItem<Item> HYPER_DINO_KEY = ITEMS.register("hyper_dino_key",
            () -> new DinoKeyItem(new Item.Properties(),0,"hyper_boost","","blank",
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
            		new MobEffectInstance(EffectCore.SLASH, 40, 4,true,false))
            .ChangeSlot(2).ResetFormToBase().AddCompatibilityList(RANGERS).AddToTabList(RangerTabs.DINO_FURY).AddToTabList(BlankDinoKeyItem.DINO_KEY, 1));
    
	public static final DeferredItem<Item> ELASTO_DINO_KEY = ITEMS.register("elasto_dino_key",
            () -> new DinoKeyItem(new Item.Properties(),0,"elasto_boost","","blank",
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.REGENERATION, 40, 1,true,false))
            .ChangeSlot(2).ResetFormToBase().AddCompatibilityList(RANGERS).AddToTabList(RangerTabs.DINO_FURY).AddToTabList(BlankDinoKeyItem.DINO_KEY, 1));
    
	public static final DeferredItem<Item> GRAVI_DINO_KEY = ITEMS.register("gravi_dino_key",
            () -> new DinoKeyItem(new Item.Properties(),0,"gravi_boost","","blank",
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 1,true,false))
            .ChangeSlot(2).ResetFormToBase().AddCompatibilityList(RANGERS).AddToTabList(RangerTabs.DINO_FURY).AddToTabList(BlankDinoKeyItem.DINO_KEY, 1));
    
	public static final DeferredItem<Item> SPRINT_DINO_KEY = ITEMS.register("sprint_dino_key",
            () -> new DinoKeyItem(new Item.Properties(),0,"sprint_boost","","blank",
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 4,true,false))
            .ChangeSlot(2).ResetFormToBase().AddCompatibilityList(RANGERS).AddToTabList(RangerTabs.DINO_FURY).AddToTabList(BlankDinoKeyItem.DINO_KEY, 1));
    
	public static final DeferredItem<Item> SHIELD_DINO_KEY = ITEMS.register("shield_dino_key",
            () -> new DinoKeyItem(new Item.Properties(),0,"shield_boost","","blank",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.REGENERATION, 40, 0,true,false))
            .ChangeSlot(2).ResetFormToBase().AddCompatibilityList(RANGERS).AddToTabList(RangerTabs.DINO_FURY).AddToTabList(BlankDinoKeyItem.DINO_KEY, 1));
    
	public static final DeferredItem<Item> SONIC_DINO_KEY = ITEMS.register("sonic_dino_key",
            () -> new DinoKeyItem(new Item.Properties(),0,"sonic_boost","","blank")
            .ChangeSlot(2).ResetFormToBase().AddCompatibilityList(RANGERS).AddToTabList(RangerTabs.DINO_FURY).AddToTabList(BlankDinoKeyItem.DINO_KEY, 1));
    
	public static final DeferredItem<Item> STINK_DINO_KEY = ITEMS.register("stink_dino_key",
            () -> new DinoKeyItem(new Item.Properties(),0,"stink_boost","","blank",
            		new MobEffectInstance(EffectCore.SMOKE, 40, 2,true,false))
            .ChangeSlot(2).ResetFormToBase().AddCompatibilityList(RANGERS).AddToTabList(RangerTabs.DINO_FURY).AddToTabList(BlankDinoKeyItem.DINO_KEY, 1));
    
	public static final DeferredItem<Item> VISION_DINO_KEY = ITEMS.register("vision_dino_key",
            () -> new DinoKeyItem(new Item.Properties(),0,"vision_boost","","blank",
            		new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 2,true,false))
            .ChangeSlot(2).ResetFormToBase().AddCompatibilityList(RANGERS).AddToTabList(RangerTabs.DINO_FURY).AddToTabList(BlankDinoKeyItem.DINO_KEY, 1));
    
	public static final DeferredItem<Item> MUSCLE_DINO_KEY = ITEMS.register("muscle_dino_key",
            () -> new DinoKeyItem(new Item.Properties(),0,"muscle_boost","","blank",
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false))
            .ChangeSlot(2).ResetFormToBase().AddCompatibilityList(RANGERS).AddToTabList(RangerTabs.DINO_FURY).AddToTabList(BlankDinoKeyItem.DINO_KEY, 1));
    
	public static final DeferredItem<Item> GROW_DINO_KEY = ITEMS.register("grow_dino_key",
            () -> new DinoKeyItem(new Item.Properties(),0,"grow_boost","","blank",
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
            		new MobEffectInstance(EffectCore.SMALL, 40, 2,true,false))
            .ChangeSlot(2).ResetFormToBase().AddCompatibilityList(RANGERS).AddToTabList(RangerTabs.DINO_FURY).AddToTabList(BlankDinoKeyItem.DINO_KEY, 1));
    
	public static final DeferredItem<Item> FLARE_DINO_KEY = ITEMS.register("flare_dino_key",
            () -> new DinoKeyItem(new Item.Properties(),0,"flare_boost","","blank",
            		new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 2,true,false))
            .ChangeSlot(2).ResetFormToBase().AddCompatibilityList(RANGERS).AddToTabList(RangerTabs.DINO_FURY).AddToTabList(BlankDinoKeyItem.DINO_KEY, 1));
    
	public static final DeferredItem<Item> MIST_DINO_KEY = ITEMS.register("mist_dino_key",
            () -> new DinoKeyItem(new Item.Properties(),0,"mist_boost","","blank",
            		new MobEffectInstance(EffectCore.SMOKE, 40, 2,true,false))
            .ChangeSlot(2).ResetFormToBase().AddCompatibilityList(RANGERS).AddToTabList(RangerTabs.DINO_FURY).AddToTabList(BlankDinoKeyItem.DINO_KEY, 1));
    
	public static final DeferredItem<Item> HOVER_DINO_KEY = ITEMS.register("hover_dino_key",
            () -> new DinoKeyItem(new Item.Properties(),0,"hover_boost","","blank",
            		new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
            		new MobEffectInstance(MobEffects.SLOW_FALLING, 40, 3,true,false))
            .ChangeSlot(2).ResetFormToBase().AddCompatibilityList(RANGERS).AddToTabList(RangerTabs.DINO_FURY).AddToTabList(BlankDinoKeyItem.DINO_KEY, 1));
    
	public static final DeferredItem<Item> FIX_IT_DINO_KEY = ITEMS.register("fix_it_dino_key",
            () -> new DinoKeyItem(new Item.Properties(),0,"fix_it_boost","","blank",
            		new MobEffectInstance(MobEffects.REGENERATION, 40, 3,true,false),
            		new MobEffectInstance(MobEffects.SATURATION, 40, 3,true,false))
            .ChangeSlot(2).ResetFormToBase().AddCompatibilityList(RANGERS).AddToTabList(RangerTabs.DINO_FURY).AddToTabList(BlankDinoKeyItem.DINO_KEY, 1));
    
	public static final DeferredItem<Item> SLICK_DINO_KEY = ITEMS.register("slick_dino_key",
            () -> new DinoKeyItem(new Item.Properties(),0,"slick_boost","","blank",
            		new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 2,true,false))
            .ChangeSlot(2).ResetFormToBase().AddCompatibilityList(RANGERS).AddToTabList(RangerTabs.DINO_FURY).AddToTabList(BlankDinoKeyItem.DINO_KEY, 1));
    
	public static final DeferredItem<Item> BALLOON_DINO_KEY = ITEMS.register("balloon_dino_key",
            () -> new DinoKeyItem(new Item.Properties(),0,"balloon_boost","","blank",
            		new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
            		new MobEffectInstance(MobEffects.SLOW_FALLING, 40, 3,true,false))
            .ChangeSlot(2).ResetFormToBase().AddCompatibilityList(RANGERS).AddToTabList(RangerTabs.DINO_FURY).AddToTabList(BlankDinoKeyItem.DINO_KEY, 1));
    
	public static final DeferredItem<Item> INVISI_DINO_KEY = ITEMS.register("invisi_dino_key",
            () -> new DinoKeyItem(new Item.Properties(),0,"invisi_boost","","blank",
            		new MobEffectInstance(MobEffects.INVISIBILITY, 40, 2,true,false))
            .ChangeSlot(2).ResetFormToBase().AddCompatibilityList(RANGERS).AddToTabList(RangerTabs.DINO_FURY).AddToTabList(BlankDinoKeyItem.DINO_KEY, 1));
    
	public static final DeferredItem<Item> DOUBLE_DINO_KEY = ITEMS.register("double_dino_key",
            () -> new DinoKeyItem(new Item.Properties(),0,"double_boost","","blank")
            .ChangeSlot(2).ResetFormToBase().AddCompatibilityList(RANGERS).AddToTabList(RangerTabs.DINO_FURY).AddToTabList(BlankDinoKeyItem.DINO_KEY, 1));
    
	public static final DeferredItem<Item> SNOOZE_DINO_KEY = ITEMS.register("snooze_dino_key",
            () -> new DinoKeyItem(new Item.Properties(),0,"snooze_boost","","blank")
            .ChangeSlot(2).ResetFormToBase().AddCompatibilityList(RANGERS).AddToTabList(RangerTabs.DINO_FURY).AddToTabList(BlankDinoKeyItem.DINO_KEY, 1));
    
	public static final DeferredItem<Item> SPIN_DINO_KEY = ITEMS.register("spin_dino_key",
            () -> new DinoKeyItem(new Item.Properties(),0,"spin_boost","","blank",
            		new MobEffectInstance(MobEffects.CONFUSION, 40, 2,true,false))
            .ChangeSlot(2).ResetFormToBase().AddCompatibilityList(RANGERS).AddToTabList(RangerTabs.DINO_FURY).AddToTabList(BlankDinoKeyItem.DINO_KEY, 1));
    
	public static final DeferredItem<Item> CUSHION_DINO_KEY = ITEMS.register("cushion_dino_key",
            () -> new DinoKeyItem(new Item.Properties(),0,"cushion_boost","","blank")
            .ChangeSlot(2).ResetFormToBase().AddCompatibilityList(RANGERS).AddToTabList(RangerTabs.DINO_FURY).AddToTabList(BlankDinoKeyItem.DINO_KEY, 1));
    
	public static final DeferredItem<Item> BLAZING_DINO_KEY = ITEMS.register("blazing_dino_key",
            () -> new DinoKeyItem(new Item.Properties(),0,"blazing_battle_armor","","blank",
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 2,true,false),
            		new MobEffectInstance(EffectCore.FIREPUNCH, 40, 2,true,false),
            		new MobEffectInstance(EffectCore.FIRESLASH, 40, 2,true,false))
            .ChangeSlot(2).ResetFormToBase().AddCompatibilityList(RANGERS).AddToTabList(RangerTabs.DINO_FURY));
    
	public static final DeferredItem<Item> ELECTRO_DINO_KEY = ITEMS.register("electro_dino_key",
            () -> new DinoKeyItem(new Item.Properties(),0,"electro_battle_armor","","blank",
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
            		new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 2,true,false),
            		new MobEffectInstance(EffectCore.FIRESLASH, 40, 2,true,false))
            .ChangeSlot(2).ResetFormToBase().AddCompatibilityList(RANGERS).AddToTabList(RangerTabs.DINO_FURY));
    
	public static final DeferredItem<Item> SHADOW_DINO_KEY = ITEMS.register("shadow_dino_key",
            () -> new DinoKeyItem(new Item.Properties(),0,"shadow_battle_armor","","blank",
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 2,true,false),
            		new MobEffectInstance(MobEffects.REGENERATION, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.SATURATION, 40, 2,true,false),
            		new MobEffectInstance(EffectCore.SHOTBOOST, 40, 2,true,false))
            .ChangeSlot(2).ResetFormToBase().AddCompatibilityList(RANGERS).AddToTabList(RangerTabs.DINO_FURY));
    
	public static final DeferredItem<Item> LIGHT_DINO_KEY = ITEMS.register("light_dino_key",
            () -> new DinoKeyItem(new Item.Properties(),0,"light_battle_armor","","blank",
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 2,true,false),
            		new MobEffectInstance(MobEffects.REGENERATION, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.SATURATION, 40, 2,true,false),
            		new MobEffectInstance(EffectCore.SHOTBOOST, 40, 2,true,false))
            .ChangeSlot(2).ResetFormToBase().AddCompatibilityList(RANGERS).AddToTabList(RangerTabs.DINO_FURY));
    
	public static final DeferredItem<Item> COSMIC_DINO_KEY = ITEMS.register("cosmic_dino_key",
            () -> new DinoKeyItem(new Item.Properties(),0,"cosmic_battle_armor","","blank",
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
            		new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 3,true,false),
            		new MobEffectInstance(MobEffects.REGENERATION, 40, 3,true,false),
            		new MobEffectInstance(MobEffects.SATURATION, 40, 3,true,false),
            		new MobEffectInstance(EffectCore.SHOTBOOST, 40, 3,true,false))
            .ChangeSlot(2).ResetFormToBase().AddCompatibilityList(RANGERS).AddToTabList(RangerTabs.DINO_FURY));
    
	public static final DeferredItem<Item> SMASH_DINO_KEY = ITEMS.register("smash_dino_key",
            () -> new DinoKeyItem(new Item.Properties(),0,"smash_battle_armor","","blank",
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0,true,false),
            		new MobEffectInstance(MobEffects.REGENERATION, 40, 3,true,false),
            		new MobEffectInstance(EffectCore.PUNCH, 40, 5,true,false))
            .ChangeSlot(2).ResetFormToBase().AddCompatibilityList(RANGERS).AddToTabList(RangerTabs.DINO_FURY));
    
	public static final DeferredItem<Item> FREEZE_DINO_KEY = ITEMS.register("freeze_dino_key",
            () -> new DinoKeyItem(new Item.Properties(),0,"freeze_battle_armor","","blank",
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
            		new MobEffectInstance(EffectCore.SLASH, 40, 4,true,false),
            		new MobEffectInstance(EffectCore.FLYING, 40, 5,true,false),
            		new MobEffectInstance(EffectCore.FROSTWALKER, 40, 0,true,false))
            .ChangeSlot(2).ResetFormToBase().ChangeModel("rangerwing.geo.json").hasFlyingWings("rangerwing.geo.json").AddCompatibilityList(RANGERS).AddToTabList(RangerTabs.DINO_FURY));
    
	public static final DeferredItem<Item> DINO_KNIGHT_KEY = ITEMS.register("dino_knight_key",
            () -> new DinoKeyItem(new Item.Properties(),0,"_dino_knight","dino_fury_red","dino_fury_red_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 1,true,false),
            		new MobEffectInstance(EffectCore.SLASH, 40, 3,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false))
			.alsoChange2ndSlot(OtherItems.BLANK_FORM.get()).ChangeBeltModel("geo/dino_fury_belt.geo.json").AddToTabList(RangerTabs.DINO_FURY));
    
	public static final DeferredItem<Item> DINO_MASTER_KEY = ITEMS.register("dino_master_key",
            () -> new DinoKeyItem(new Item.Properties(),0,"dino_master_mode","","blank",
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 5,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 5,true,false),
            		new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 2,true,false),
            		new MobEffectInstance(EffectCore.SLASH, 40, 5,true,false),
            		new MobEffectInstance(MobEffects.REGENERATION, 40, 5,true,false))
            .ChangeSlot(2).ResetFormToBase().AddCompatibilityList(DINO_FURY).ChangeModel("dino_master.geo.json"));

	public static final DeferredItem<Item> UNFINISHED_DINO_MASTER_SABER = ITEMS.register("unfinished_dino_master_saber",
    		() -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.DINO_FURY));

	public static final DeferredItem<Item> ROBOTIC_ARM = ITEMS.register("robotic_arm",
			() -> new RangerFormChangeItem(new Item.Properties(),0,"_robotic_arm","dino_fury_black","dino_fury_black_belt",
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(EffectCore.SLASH, 40, 2,true,false))
					.alsoChange2ndSlot(OtherItems.BLANK_FORM.get()).ChangeBeltModel("geo/dino_fury_belt.geo.json").AddToTabList(RangerTabs.DINO_FURY));
    
    public static final DeferredItem<Item> DINO_FURY_HELMET = ITEMS.register("dino_fury_head",
    		() -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RangerTabs.DINO_FURY).ChangeRepairItem(BLANK_DINO_KEY.get()));
    public static final DeferredItem<Item> DINO_FURY_CHESTPLATE = ITEMS.register("dino_fury_torso",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RangerTabs.DINO_FURY).ChangeRepairItem(BLANK_DINO_KEY.get()));
    public static final DeferredItem<Item> DINO_FURY_LEGGINGS = ITEMS.register("dino_fury_legs",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RangerTabs.DINO_FURY).ChangeRepairItem(BLANK_DINO_KEY.get()));
    
    public static final DeferredItem<Item> RED_DINO_FURY_MORPHER = ITEMS.register("red_dino_fury_morpher",
    		() -> new DinoFuryMorpherItem(ArmorMaterials.DIAMOND,"dino_fury_red", T_REX_DINO_KEY,DINO_FURY_HELMET,DINO_FURY_CHESTPLATE,DINO_FURY_LEGGINGS,new Item.Properties())
    		.Add_Extra_Base_Form_Items(OtherItems.BLANK_FORM).AddToTabList(RangerTabs.DINO_FURY).ChangeRepairItem(BLANK_DINO_KEY.get()));
    public static final DeferredItem<Item> BLUE_DINO_FURY_MORPHER = ITEMS.register("blue_dino_fury_morpher",
    		() -> new DinoFuryMorpherItem(ArmorMaterials.DIAMOND,"dino_fury_blue", TRICERA_DINO_KEY,DINO_FURY_HELMET,DINO_FURY_CHESTPLATE,DINO_FURY_LEGGINGS,new Item.Properties())
    		.Add_Extra_Base_Form_Items(OtherItems.BLANK_FORM).AddToTabList(RangerTabs.DINO_FURY).ChangeRepairItem(BLANK_DINO_KEY.get()));
    public static final DeferredItem<Item> PINK_DINO_FURY_MORPHER = ITEMS.register("pink_dino_fury_morpher",
    		() -> new DinoFuryMorpherItem(ArmorMaterials.DIAMOND,"dino_fury_pink", ANKYLO_DINO_KEY,DINO_FURY_HELMET,DINO_FURY_CHESTPLATE,DINO_FURY_LEGGINGS,new Item.Properties())
    		.Add_Extra_Base_Form_Items(OtherItems.BLANK_FORM).AddToTabList(RangerTabs.DINO_FURY).ChangeRepairItem(BLANK_DINO_KEY.get()));
    public static final DeferredItem<Item> GREEN_DINO_FURY_MORPHER = ITEMS.register("green_dino_fury_morpher",
    		() -> new DinoFuryMorpherItem(ArmorMaterials.DIAMOND,"dino_fury_green", TIGER_DINO_KEY,DINO_FURY_HELMET,DINO_FURY_CHESTPLATE,DINO_FURY_LEGGINGS,new Item.Properties())
    		.Add_Extra_Base_Form_Items(OtherItems.BLANK_FORM).AddToTabList(RangerTabs.DINO_FURY).ChangeRepairItem(BLANK_DINO_KEY.get()));
    public static final DeferredItem<Item> BLACK_DINO_FURY_MORPHER = ITEMS.register("black_dino_fury_morpher",
    		() -> new DinoFuryMorpherItem(ArmorMaterials.DIAMOND,"dino_fury_black", STEGO_DINO_KEY,DINO_FURY_HELMET,DINO_FURY_CHESTPLATE,DINO_FURY_LEGGINGS,new Item.Properties())
    		.Add_Extra_Base_Form_Items(OtherItems.BLANK_FORM).AddToTabList(RangerTabs.DINO_FURY).ChangeRepairItem(BLANK_DINO_KEY.get()));
	public static final DeferredItem<Item> GOLD_MOSA_BLASTER = ITEMS.register("gold_mosa_blaster",
			() -> new MosaBlasterItem(ArmorMaterials.DIAMOND,"dino_fury_gold",MOSA_DINO_KEY,DINO_FURY_HELMET,DINO_FURY_CHESTPLATE,DINO_FURY_LEGGINGS,new Item.Properties())
					.Add_Extra_Base_Form_Items(OtherItems.BLANK_FORM).AddToTabList(RangerTabs.DINO_FURY).ChangeRepairItem(BLANK_DINO_KEY.get()));
	public static final DeferredItem<Item> ZENITH_DINO_FURY_MORPHER = ITEMS.register("zenith_dino_fury_morpher",
			() -> new DinoFuryMorpherItem(ArmorMaterials.DIAMOND,"dino_fury_zenith", T_REX_DINO_KEY_ZENITH,DINO_FURY_HELMET,DINO_FURY_CHESTPLATE,DINO_FURY_LEGGINGS,new Item.Properties())
					.Add_Extra_Base_Form_Items(OtherItems.BLANK_FORM).AddToTabList(RangerTabs.DINO_FURY).ChangeRepairItem(BLANK_DINO_KEY.get()));
	public static final DeferredItem<Item> CORRUPTED_BLUE_DINO_FURY_MORPHER = ITEMS.register("corrupted_blue_dino_fury_morpher",
			() -> new DinoFuryMorpherItem(ArmorMaterials.DIAMOND,"evil_dino_fury_blue",EVIL_TRICERA_DINO_KEY,DINO_FURY_HELMET,DINO_FURY_CHESTPLATE,DINO_FURY_LEGGINGS,new Item.Properties())
					.Add_Extra_Base_Form_Items(OtherItems.BLANK_FORM).AddToTabList(RangerTabs.DINO_FURY).ChangeRepairItem(BLANK_DINO_KEY.get()));
    
    public static final DeferredItem<Item> VOID_KNIGHT_CHANGER = ITEMS.register("void_knight_changer",
    		() -> new VoidSaberItem(ArmorMaterials.DIAMOND,"void_knight", VOID_KNIGHT_KEY,DINO_FURY_HELMET,DINO_FURY_CHESTPLATE,DINO_FURY_LEGGINGS,new Item.Properties())
    		.Add_Extra_Base_Form_Items(OtherItems.BLANK_FORM).AddToTabList(RangerTabs.DINO_FURY).ChangeRepairItem(BLANK_DINO_KEY.get()));
    
    public static final DeferredItem<SwordItem> CHROMAFURY_SABER = ITEMS.register("chromafury_saber",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.DINO_FURY).ChangeRepairItem(BLANK_DINO_KEY.get()));
    
    public static final DeferredItem<BaseBlasterItem> MOSA_BLASTER = ITEMS.register("mosa_blaster",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).AddToTabList(PowerRangersCraftCore.FORM_WEAPON_ITEM).AddToTabList(RangerTabs.DINO_FURY).ChangeRepairItem(BLANK_DINO_KEY.get()));
	public static final DeferredItem<SwordItem> MOSA_BLADE = ITEMS.register("mosa_blade",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.DINO_FURY).ChangeRepairItem(BLANK_DINO_KEY.get()));
    public static final DeferredItem<BaseBlasterItem> GOLD_FURY_BLADE_BLASTER = ITEMS.register("gold_fury_blade_blaster",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).KeepDifItem(MOSA_BLADE.get()).AddToTabList(RangerTabs.DINO_FURY).ChangeRepairItem(BLANK_DINO_KEY.get()));
    
    public static final DeferredItem<SwordItem> VOID_SABER = ITEMS.register("void_saber",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.DINO_FURY).ChangeRepairItem(BLANK_DINO_KEY.get()));
    public static final DeferredItem<Item> DINO_KNIGHT_SHIELD = ITEMS.register("dino_knight_shield",
			() -> new BaseShieldItem(new Item.Properties()).AddToTabList(RangerTabs.DINO_FURY).ChangeRepairItem(BLANK_DINO_KEY.get()));
    
    public static final DeferredItem<SwordItem> DINO_KNIGHT_MORPHER = ITEMS.register("dino_knight_morpher",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(PowerRangersCraftCore.FORM_WEAPON_ITEM).AddToTabList(RangerTabs.DINO_FURY).ChangeRepairItem(BLANK_DINO_KEY.get()));
    
    public static final DeferredItem<BaseSwordItem> DINO_MASTER_SABER = ITEMS.register("dino_master_saber",
			() -> new DinoMasterSaberItem(Tiers.DIAMOND, 12, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.DINO_FURY).ChangeRepairItem(BLANK_DINO_KEY.get()));

	public static final DeferredItem<BaseSwordItem> MEGA_FURY_SABER = ITEMS.register("mega_fury_saber",
			() -> new BaseSwordItem(Tiers.NETHERITE,10,-2.4F, new Item.Properties()).AddToTabList(RangerTabs.DINO_FURY).ChangeRepairItem(BLANK_DINO_KEY.get()));

	public static final DeferredItem<SwordItem> CORRUPTED_CHROMAFURY_SABER = ITEMS.register("corrupted_chromafury_saber",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.DINO_FURY).ChangeRepairItem(BLANK_DINO_KEY.get()));

	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}

}