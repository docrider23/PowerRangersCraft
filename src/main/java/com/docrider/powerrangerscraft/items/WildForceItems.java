package com.docrider.powerrangerscraft.items;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.effect.EffectCore;
import com.docrider.powerrangerscraft.items.wild_force.*;
import com.docrider.powerrangerscraft.items.others.*;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;

public class WildForceItems {

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PowerRangersCraftCore.MODID);

	public static String[] ARMS= new String[] {"kongazord","predazord","predazord_blue_moon","isis_megazord","animus","ultimus_megazord"};
	public static String[] LEGS= new String[] {"kongazord","ultimus_megazord","isis_megazord","animus"};
	public static String[] LEGS_BISON= new String[] {"isis_megazord","animus"};
	public static String[] LEGS_EAGLE= new String[] {"kongazord","ultimus_megazord"};

	public static List<Item> GaoStriker= new ArrayList<Item>();

	public static final DeferredItem<Item> WILD_FORCE_LOGO = ITEMS.register("wild_force_logo",
			() -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.WILD_FORCE));
    
	public static final DeferredItem<Item> EMPTY_ANIMAL_CRYSTAL = ITEMS.register("empty_animal_crystal",
    		() -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.WILD_FORCE));

	public static final DeferredItem<Item> UNFINISHED_ANIMUS_CRYSTAL = ITEMS.register("unfinished_animus_crystal",
			() -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.WILD_FORCE));
	public static final DeferredItem<Item> EMPTY_ANIMUS_CRYSTAL = ITEMS.register("empty_animus_crystal",
			() -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.WILD_FORCE));

	public static final DeferredItem<Item> LION_ANIMAL_CRYSTAL_MEGAZORD = ITEMS.register("lion_animal_crystal_megazord",
			() -> new RangerFormChangeItem(new Item.Properties(),0,"","wild_force_megazord","blank",
					new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)));

	public static final DeferredItem<Item> LION_ANIMAL_CRYSTAL = ITEMS.register("lion_animal_crystal",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","wild_force_red","wild_force_red_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false))
					.addAlternative(LION_ANIMAL_CRYSTAL_MEGAZORD.get()).ChangeBeltModel("geo/rangerbeltweapon.geo.json").AddToTabList(RangerTabs.WILD_FORCE));

	public static final DeferredItem<Item> EAGLE_ANIMAL_CRYSTAL = ITEMS.register("eagle_animal_crystal",
			() -> new RangerFormChangeItem(new Item.Properties(),0,"","wild_force_yellow","wild_force_yellow_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)).ChangeBeltModel("geo/rangerbeltweapon.geo.json").AddToTabList(RangerTabs.WILD_FORCE));

	public static final DeferredItem<Item> SHARK_ANIMAL_CRYSTAL_MEGAZORD = ITEMS.register("shark_animal_crystal_megazord",
			() -> new RangerFormChangeItem(new Item.Properties(),0,"shark_wildzord","wild_force_megazord","blank")
					.ChangeSlot(3).AddCompatibilityList(ARMS));

	public static final DeferredItem<Item> SHARK_ANIMAL_CRYSTAL = ITEMS.register("shark_animal_crystal",
			() -> new RangerFormChangeItem(new Item.Properties(),0,"","wild_force_blue","wild_force_blue_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
					new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0,true,false))
					.addAlternative(SHARK_ANIMAL_CRYSTAL_MEGAZORD.get()).ChangeBeltModel("geo/rangerbeltweapon.geo.json").AddToTabList(RangerTabs.WILD_FORCE));

	public static final DeferredItem<Item> BISON_ANIMAL_CRYSTAL_MEGAZORD = ITEMS.register("bison_animal_crystal_megazord",
			() -> new RangerFormChangeItem(new Item.Properties(),0,"bison_wildzord","wild_force_megazord","blank")
					.ChangeSlot(5).AddCompatibilityList(LEGS_BISON));

	public static final DeferredItem<Item> BISON_ANIMAL_CRYSTAL_OTHERS = ITEMS.register("bison_animal_crystal_others",
			() -> new RangerFormChangeItem(new Item.Properties(),0,"eagle_bison_wildzord","kongazord","blank")
					.ChangeSlot(5).AddCompatibilityList(LEGS_EAGLE));

	public static final DeferredItem<Item> BISON_ANIMAL_CRYSTAL = ITEMS.register("bison_animal_crystal",
			() -> new RangerFormChangeItem(new Item.Properties(),0,"","wild_force_black","wild_force_black_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false))
					.addAlternative(BISON_ANIMAL_CRYSTAL_MEGAZORD.get()).addAlternative(BISON_ANIMAL_CRYSTAL_OTHERS.get())
					.ChangeBeltModel("geo/rangerbeltweapon.geo.json").AddToTabList(RangerTabs.WILD_FORCE));

	public static final DeferredItem<Item> TIGER_ANIMAL_CRYSTAL_MEGAZORD = ITEMS.register("tiger_animal_crystal_megazord",
			() -> new RangerFormChangeItem(new Item.Properties(),0,"tiger_wildzord","wild_force_megazord","blank")
					.ChangeSlot(4).AddCompatibilityList(ARMS));

	public static final DeferredItem<Item> TIGER_ANIMAL_CRYSTAL = ITEMS.register("tiger_animal_crystal",
			() -> new RangerFormChangeItem(new Item.Properties(),0,"","wild_force_white","wild_force_white_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
					.addAlternative(TIGER_ANIMAL_CRYSTAL_MEGAZORD.get()).ChangeBeltModel("geo/rangerbeltweapon.geo.json").AddToTabList(RangerTabs.WILD_FORCE));

	public static final DeferredItem<Item> WOLF_ANIMAL_CRYSTAL_MEGAZORD = ITEMS.register("wolf_animal_crystal_megazord",
			() -> new RangerFormChangeItem(new Item.Properties(),0,"wolf_wildzord","wild_force_megazord","blank")
					.ChangeSlot(4).AddCompatibilityList(ARMS));

	public static final DeferredItem<Item> WOLF_ANIMAL_CRYSTAL = ITEMS.register("wolf_animal_crystal",
			() -> new RangerFormChangeItem(new Item.Properties(),0,"","wild_force_silver","wild_force_silver_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false))
					.addAlternative(WOLF_ANIMAL_CRYSTAL_MEGAZORD.get()).ChangeBeltModel("geo/rangerbeltweapon.geo.json").AddToTabList(RangerTabs.WILD_FORCE));

	public static final DeferredItem<Item> ELEPHANT_ANIMAL_CRYSTAL = ITEMS.register("elephant_animal_crystal",
			() -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.WILD_FORCE));

	public static final DeferredItem<Item> GIRAFFE_ANIMAL_CRYSTAL = ITEMS.register("giraffe_animal_crystal",
			() -> new RangerFormChangeItem(new Item.Properties(),0,"giraffe_wildzord","wild_force_megazord","blank",
					new MobEffectInstance(EffectCore.SLASH, 40, 3,true,false),
					new MobEffectInstance(EffectCore.PUNCH, 40, 2,true,false))
					.ChangeSlot(3).AddCompatibilityList(ARMS).AddToTabList(RangerTabs.WILD_FORCE));

	public static final DeferredItem<Item> BLACK_BEAR_ANIMAL_CRYSTAL = ITEMS.register("black_bear_animal_crystal",
			() -> new RangerFormChangeItem(new Item.Properties(),0,"black_bear_wildzord","wild_force_megazord","blank",
					new MobEffectInstance(EffectCore.PUNCH, 40, 4,true,false))
					.ChangeSlot(4).AddCompatibilityList(ARMS).AddToTabList(RangerTabs.WILD_FORCE));

	public static final DeferredItem<Item> POLAR_BEAR_ANIMAL_CRYSTAL = ITEMS.register("polar_bear_animal_crystal",
			() -> new RangerFormChangeItem(new Item.Properties(),0,"polar_bear_wildzord","wild_force_megazord","blank",
					new MobEffectInstance(EffectCore.PUNCH, 40, 4,true,false))
					.ChangeSlot(3).AddCompatibilityList(ARMS).AddToTabList(RangerTabs.WILD_FORCE));

	public static final DeferredItem<Item> GORILLA_ANIMAL_CRYSTAL = ITEMS.register("gorilla_animal_crystal",
			() -> new RangerFormChangeItem(new Item.Properties(),0,"","kongazord", "blank",
					new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)).AddToTabList(RangerTabs.WILD_FORCE));

	public static final DeferredItem<Item> HAMMERHEAD_SHARK_ANIMAL_CRYSTAL = ITEMS.register("hammerhead_shark_animal_crystal",
			() -> new RangerFormChangeItem(new Item.Properties(),0,"hammerhead_shark_wildzord","wild_force_megazord","blank")
					.ChangeSlot(3).AddCompatibilityList(ARMS).AddToTabList(RangerTabs.WILD_FORCE));

	public static final DeferredItem<Item> ALLIGATOR_ANIMAL_CRYSTAL_BLUE_MOON = ITEMS.register("alligator_animal_crystal_blue_moon",
			() -> new RangerFormChangeItem(new Item.Properties(),0,"","predazord_blue_moon", "alligator_blade_blue_moon",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 5,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(EffectCore.PUNCH, 40, 3,true,false)).ChangeBeltModel("geo/predazord.geo.json"));

	public static final DeferredItem<Item> ALLIGATOR_ANIMAL_CRYSTAL = ITEMS.register("alligator_animal_crystal",
			() -> new RangerFormChangeItem(new Item.Properties(),0,"","predazord", "alligator_blade",
					new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false))
					.ChangeBeltModel("geo/predazord.geo.json").addAlternative(ALLIGATOR_ANIMAL_CRYSTAL_BLUE_MOON.get()).AddToTabList(RangerTabs.WILD_FORCE));

	public static final DeferredItem<Item> ALLIGATOR_ANIMAL_CRYSTAL_BLUE_MOON_EVIL = ITEMS.register("alligator_animal_crystal_blue_moon_evil",
			() -> new RangerFormChangeItem(new Item.Properties(),0,"_evil","predazord_blue_moon", "alligator_blade_blue_moon",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 5,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(EffectCore.PUNCH, 40, 3,true,false)).ChangeBeltModel("geo/predazord.geo.json"));

	public static final DeferredItem<Item> ALLIGATOR_ANIMAL_CRYSTAL_EVIL = ITEMS.register("alligator_animal_crystal_evil",
			() -> new RangerFormChangeItem(new Item.Properties(),0,"_evil","predazord", "alligator_blade",
					new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false)).ChangeBeltModel("geo/predazord.geo.json"));

	public static final DeferredItem<Item> RHINO_ANIMAL_CRYSTAL = ITEMS.register("rhino_animal_crystal",
			() -> new RangerFormChangeItem(new Item.Properties(),0,"striker_mode","wild_force_megazord","blank",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 6,true,false))
					.ChangeSlot(5).AddCompatibilityList(ARMS).AddToList(GaoStriker).AddToTabList(RangerTabs.WILD_FORCE));

	public static final DeferredItem<Item> ARMADILLO_ANIMAL_CRYSTAL = ITEMS.register("armadillo_animal_crystal",
			() -> new RangerFormChangeItem(new Item.Properties(),0,"striker_mode","wild_force_megazord","blank",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 6,true,false))
					.ChangeSlot(5).AddCompatibilityList(ARMS).AddToList(GaoStriker).AddToTabList(RangerTabs.WILD_FORCE));

	public static final DeferredItem<Item> RED_GORILLA_ANIMAL_CRYSTAL = ITEMS.register("red_gorilla_animal_crystal",
			() -> new RangerFormChangeItem(new Item.Properties(),0,"","ultimus_megazord", "blank",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 5,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 5,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)).AddToTabList(RangerTabs.WILD_FORCE));

	public static final DeferredItem<Item> DEER_ANIMAL_CRYSTAL = ITEMS.register("deer_animal_crystal",
			() -> new RangerFormChangeItem(new Item.Properties(),0,"deer_wildzord","wild_force_megazord","blank",
					new MobEffectInstance(EffectCore.SLASH, 40, 3,true,false),
					new MobEffectInstance(EffectCore.PUNCH, 40, 3,true,false),
					new MobEffectInstance(MobEffects.INVISIBILITY, 40, 0,true,false))
					.ChangeSlot(4).AddCompatibilityList(ARMS).AddToTabList(RangerTabs.WILD_FORCE));

	public static final DeferredItem<Item> FALCON_ANIMAL_CRYSTAL = ITEMS.register("falcon_animal_crystal",
			() -> new RangerFormChangeItem(new Item.Properties(),0,"","isis_megazord", "isis_megazord_wings",
					new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(EffectCore.PUNCH, 40, 3,true,false),
					new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false),
					new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false)).ChangeBeltModel("geo/rangerwingbelt.geo.json").AddToTabList(RangerTabs.WILD_FORCE));

	public static final DeferredItem<Item> BLACK_LION_ANIMAL_CRYSTAL = ITEMS.register("black_lion_animal_crystal",
			() -> new RangerFormChangeItem(new Item.Properties(),0,"","animus", "blank",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 6,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 6,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false),
					new MobEffectInstance(EffectCore.SLASH, 40, 3,true,false),
					new MobEffectInstance(EffectCore.PUNCH, 40, 3,true,false)).AddToTabList(RangerTabs.WILD_FORCE));

	public static final DeferredItem<Item> CONDOR_ANIMAL_CRYSTAL = ITEMS.register("condor_animal_crystal",
			() -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.WILD_FORCE));

	public static final DeferredItem<Item> SAWSHARK_ANIMAL_CRYSTAL = ITEMS.register("sawshark_animal_crystal",
			() -> new RangerFormChangeItem(new Item.Properties(),0,"sawshark_wildzord","wild_force_megazord","blank")
					.ChangeSlot(3).AddCompatibilityList(ARMS).AddToTabList(RangerTabs.WILD_FORCE));

	public static final DeferredItem<Item> BUFFALO_ANIMAL_CRYSTAL = ITEMS.register("buffalo_animal_crystal",
			() -> new RangerFormChangeItem(new Item.Properties(),0,"buffalo_wildzord","wild_force_megazord","blank")
					.ChangeSlot(5).AddCompatibilityList(LEGS).AddToTabList(RangerTabs.WILD_FORCE));

	public static final DeferredItem<Item> JAGUAR_ANIMAL_CRYSTAL = ITEMS.register("jaguar_animal_crystal",
			() -> new RangerFormChangeItem(new Item.Properties(),0,"jaguar_wildzord","wild_force_megazord","blank")
					.ChangeSlot(4).AddCompatibilityList(ARMS).AddToTabList(RangerTabs.WILD_FORCE));

	public static final DeferredItem<Item> PANDA_ANIMAL_CRYSTAL = ITEMS.register("panda_animal_crystal",
			() -> new RangerFormChangeItem(new Item.Properties(),0,"panda_wildzord","wild_force_megazord","blank",
					new MobEffectInstance(EffectCore.PUNCH, 40, 4,true,false))
					.ChangeSlot(3).AddCompatibilityList(ARMS).AddToTabList(RangerTabs.WILD_FORCE));

	public static final DeferredItem<Item> APE_ANIMAL_CRYSTAL = ITEMS.register("ape_animal_crystal",
			() -> new RangerFormChangeItem(new Item.Properties(),0,"_ape","ultimus_megazord", "blank",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 5,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 5,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)).AddToTabList(RangerTabs.WILD_FORCE));

	public static final DeferredItem<Item> LION_ANIMAL_CRYSTAL_BLUE = ITEMS.register("lion_blue_animal_crystal",
			() -> new RangerFormChangeItem(new Item.Properties(),0,"_blue","wild_force_megazord","blank",
					new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)).AddToTabList(RangerTabs.WILD_FORCE));

	public static final DeferredItem<Item> LION_ANIMAL_CRYSTAL_BLACK = ITEMS.register("lion_black_animal_crystal",
			() -> new RangerFormChangeItem(new Item.Properties(),0,"_black","wild_force_megazord","blank",
					new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)).AddToTabList(RangerTabs.WILD_FORCE));

	public static final DeferredItem<Item> LION_ANIMAL_CRYSTAL_WHITE = ITEMS.register("lion_white_animal_crystal",
			() -> new RangerFormChangeItem(new Item.Properties(),0,"_white","wild_force_megazord","blank",
					new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false),
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false)).AddToTabList(RangerTabs.WILD_FORCE));

	public static final DeferredItem<Item> ANIMARIUM_BUCKLE = ITEMS.register("animarium_buckle",
			() -> new RangerFormChangeItem(new Item.Properties(),0,"_savage","wild_force_red","wild_force_red_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
					new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
					new MobEffectInstance(EffectCore.FLYING, 40, 0,true,false))
					.ChangeModel("geo/dino_master.geo.json").ChangeBeltModel("geo/rangerbeltweapon.geo.json").AddToTabList(RangerTabs.WILD_FORCE));

	public static final DeferredItem<Item> WILD_FORCE_HELMET = ITEMS.register("wild_force_head",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RangerTabs.WILD_FORCE).ChangeRepairItem(EMPTY_ANIMAL_CRYSTAL.get()));
    public static final DeferredItem<Item> WILD_FORCE_CHESTPLATE = ITEMS.register("wild_force_torso",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RangerTabs.WILD_FORCE).ChangeRepairItem(EMPTY_ANIMAL_CRYSTAL.get()));
    public static final DeferredItem<Item> WILD_FORCE_LEGGINGS = ITEMS.register("wild_force_legs",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RangerTabs.WILD_FORCE).ChangeRepairItem(EMPTY_ANIMAL_CRYSTAL.get()));
    
    public static final DeferredItem<Item> RED_GROWL_PHONE = ITEMS.register("red_growl_phone",
    		() -> new GrowlPhoneItem(ArmorMaterials.DIAMOND,"wild_force_red", LION_ANIMAL_CRYSTAL, WILD_FORCE_HELMET, WILD_FORCE_CHESTPLATE, WILD_FORCE_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.WILD_FORCE).ChangeRepairItem(EMPTY_ANIMAL_CRYSTAL.get()));
	public static final DeferredItem<Item> YELLOW_GROWL_PHONE = ITEMS.register("yellow_growl_phone",
			() -> new GrowlPhoneItem(ArmorMaterials.DIAMOND,"wild_force_yellow", EAGLE_ANIMAL_CRYSTAL, WILD_FORCE_HELMET, WILD_FORCE_CHESTPLATE, WILD_FORCE_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.WILD_FORCE).ChangeRepairItem(EMPTY_ANIMAL_CRYSTAL.get()));
	public static final DeferredItem<Item> BLUE_GROWL_PHONE = ITEMS.register("blue_growl_phone",
			() -> new GrowlPhoneItem(ArmorMaterials.DIAMOND,"wild_force_blue", SHARK_ANIMAL_CRYSTAL, WILD_FORCE_HELMET, WILD_FORCE_CHESTPLATE, WILD_FORCE_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.WILD_FORCE).ChangeRepairItem(EMPTY_ANIMAL_CRYSTAL.get()));
	public static final DeferredItem<Item> BLACK_GROWL_PHONE = ITEMS.register("black_growl_phone",
			() -> new GrowlPhoneItem(ArmorMaterials.DIAMOND,"wild_force_black", BISON_ANIMAL_CRYSTAL, WILD_FORCE_HELMET, WILD_FORCE_CHESTPLATE, WILD_FORCE_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.WILD_FORCE).ChangeRepairItem(EMPTY_ANIMAL_CRYSTAL.get()));
	public static final DeferredItem<Item> WHITE_GROWL_PHONE = ITEMS.register("white_growl_phone",
			() -> new GrowlPhoneItem(ArmorMaterials.DIAMOND,"wild_force_white", TIGER_ANIMAL_CRYSTAL, WILD_FORCE_HELMET, WILD_FORCE_CHESTPLATE, WILD_FORCE_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.WILD_FORCE).ChangeRepairItem(EMPTY_ANIMAL_CRYSTAL.get()));
	public static final DeferredItem<Item> LUNAR_CALLER = ITEMS.register("lunar_caller",
			() -> new LunarCallerItem(ArmorMaterials.DIAMOND,"wild_force_silver", WOLF_ANIMAL_CRYSTAL, WILD_FORCE_HELMET, WILD_FORCE_CHESTPLATE, WILD_FORCE_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.WILD_FORCE).ChangeRepairItem(EMPTY_ANIMAL_CRYSTAL.get()));

    public static final DeferredItem<SwordItem> CRYSTAL_SABER = ITEMS.register("crystal_saber",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.WILD_FORCE).ChangeRepairItem(EMPTY_ANIMAL_CRYSTAL.get()));

	public static final DeferredItem<SwordItem> CRYSTAL_SABER_LION = ITEMS.register("lion_crystal_saber",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.WILD_FORCE).ChangeRepairItem(EMPTY_ANIMAL_CRYSTAL.get()));
	public static final DeferredItem<SwordItem> CRYSTAL_SABER_EAGLE = ITEMS.register("eagle_crystal_saber",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.WILD_FORCE).ChangeRepairItem(EMPTY_ANIMAL_CRYSTAL.get()));
	public static final DeferredItem<SwordItem> CRYSTAL_SABER_SHARK = ITEMS.register("shark_crystal_saber",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.WILD_FORCE).ChangeRepairItem(EMPTY_ANIMAL_CRYSTAL.get()));
	public static final DeferredItem<SwordItem> CRYSTAL_SABER_BISON = ITEMS.register("bison_crystal_saber",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.WILD_FORCE).ChangeRepairItem(EMPTY_ANIMAL_CRYSTAL.get()));
	public static final DeferredItem<SwordItem> CRYSTAL_SABER_TIGER = ITEMS.register("tiger_crystal_saber",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.WILD_FORCE).ChangeRepairItem(EMPTY_ANIMAL_CRYSTAL.get()));

	public static final DeferredItem<SwordItem> RED_LION_FANG = ITEMS.register("red_lion_fang",
			() -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.WILD_FORCE).ChangeRepairItem(EMPTY_ANIMAL_CRYSTAL.get()));
	public static final DeferredItem<SwordItem> RED_LION_FANG_CLAW = ITEMS.register("red_lion_fang_claw",
			() -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.WILD_FORCE).ChangeRepairItem(EMPTY_ANIMAL_CRYSTAL.get()));
	public static final DeferredItem<SwordItem> RED_LION_FANG_CLAW1 = ITEMS.register("red_lion_fang_claw1",
			() -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.WILD_FORCE).ChangeRepairItem(EMPTY_ANIMAL_CRYSTAL.get()));

	public static final DeferredItem<BaseBlasterItem> LION_BLASTER = ITEMS.register("lion_blaster",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).IsChargeWeapon().AddToTabList(RangerTabs.WILD_FORCE).ChangeRepairItem(EMPTY_ANIMAL_CRYSTAL.get()));

	public static final DeferredItem<SwordItem> GOLDEN_EAGLE_SWORD = ITEMS.register("golden_eagle_sword",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.WILD_FORCE).ChangeRepairItem(EMPTY_ANIMAL_CRYSTAL.get()));

	public static final DeferredItem<SwordItem> BLUE_SHARK_FIGHTING_FIN = ITEMS.register("blue_shark_fighting_fin",
			() -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.WILD_FORCE).ChangeRepairItem(EMPTY_ANIMAL_CRYSTAL.get()));

	public static final DeferredItem<SwordItem> BLACK_BISON_AXE = ITEMS.register("black_bison_axe",
			() -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.WILD_FORCE).ChangeRepairItem(EMPTY_ANIMAL_CRYSTAL.get()));

	public static final DeferredItem<SwordItem> WHITE_TIGER_BATON = ITEMS.register("white_tiger_baton",
			() -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.WILD_FORCE).ChangeRepairItem(EMPTY_ANIMAL_CRYSTAL.get()));

	public static final DeferredItem<SwordItem> JUNGLE_SWORD = ITEMS.register("jungle_sword",
			() -> new BaseSwordItem(Tiers.NETHERITE, 30, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.WILD_FORCE).ChangeRepairItem(EMPTY_ANIMAL_CRYSTAL.get()));

	public static final DeferredItem<BaseBlasterItem> LUNAR_CUE = ITEMS.register("lunar_cue",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).IsSwordGun().AddToTabList(RangerTabs.WILD_FORCE).ChangeRepairItem(EMPTY_ANIMAL_CRYSTAL.get()));

	public static final DeferredItem<BaseBlasterItem> FALCON_SUMMONER = ITEMS.register("falcon_summoner",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).IsChargeWeapon().AddToTabList(RangerTabs.WILD_FORCE).ChangeRepairItem(EMPTY_ANIMAL_CRYSTAL.get()));

	public static final DeferredItem<BaseBlasterItem> FALCONATOR = ITEMS.register("falconator",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.WILD_FORCE).ChangeRepairItem(EMPTY_ANIMAL_CRYSTAL.get()));

	public static final DeferredItem<BaseThrowableItem> ARMADILLO_PUCK = ITEMS.register("armadillo_puck",
			() -> new BaseThrowableItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.WILD_FORCE).ChangeRepairItem(EMPTY_ANIMAL_CRYSTAL.get()));

	public static final DeferredItem<BaseSwordItem> SWORD_OF_PARDOLIS = ITEMS.register("sword_of_pardolis",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.WILD_FORCE).ChangeRepairItem(EMPTY_ANIMAL_CRYSTAL.get()));

	public static final DeferredItem<BaseBlasterItem> RHINO_SHOOTER = ITEMS.register("rhino_shooter",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.WILD_FORCE).ChangeRepairItem(EMPTY_ANIMAL_CRYSTAL.get()));

	public static final DeferredItem<BaseSwordItem> DEER_CLUTCHER = ITEMS.register("deer_clutcher",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.WILD_FORCE).ChangeRepairItem(EMPTY_ANIMAL_CRYSTAL.get()));

	public static final DeferredItem<BaseBlasterItem> JUNGLE_BLASTER = ITEMS.register("jungle_blaster",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 30, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.WILD_FORCE).ChangeRepairItem(EMPTY_ANIMAL_CRYSTAL.get()));

	public static final DeferredItem<SwordItem> CRESCENT_BLADE = ITEMS.register("crescent_blade",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.WILD_FORCE).ChangeRepairItem(EMPTY_ANIMAL_CRYSTAL.get()));
	public static final DeferredItem<SwordItem> FLUTE_KNIFE = ITEMS.register("flute_knife",
			() -> new FluteKnifeItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.WILD_FORCE).ChangeRepairItem(EMPTY_ANIMAL_CRYSTAL.get()));

	public static final DeferredItem<Item> WILD_FORCE_MEGAZORD_BOOTS = ITEMS.register("wild_force_megazord_boots",
            () -> new MechaArmorItem(ArmorMaterials.NETHERITE, ArmorItem.Type.BOOTS, new Item.Properties()).AddToTabList(RangerTabs.WILD_FORCE).ChangeRepairItem(OtherItems.MECHA_GEAR.get()));
    public static final DeferredItem<Item> WILD_FORCE_MEGAZORD_LEGGINGS = ITEMS.register("wild_force_megazord_legs",
            () -> new MechaArmorItem(ArmorMaterials.NETHERITE, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RangerTabs.WILD_FORCE).ChangeRepairItem(OtherItems.MECHA_GEAR.get()));
    public static final DeferredItem<Item> WILD_FORCE_MEGAZORD_CHESTPLATE = ITEMS.register("wild_force_megazord_torso",
            () -> new MechaArmorItem(ArmorMaterials.NETHERITE, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RangerTabs.WILD_FORCE).ChangeRepairItem(OtherItems.MECHA_GEAR.get()));

    public static final DeferredItem<Item> WILD_FORCE_MEGAZORD_HELMET = ITEMS.register("wild_force_megazord_head",
            () -> new WildForceMegazordItem(ArmorMaterials.NETHERITE,"wild_force_megazord",LION_ANIMAL_CRYSTAL_MEGAZORD,WILD_FORCE_MEGAZORD_CHESTPLATE,WILD_FORCE_MEGAZORD_LEGGINGS,WILD_FORCE_MEGAZORD_BOOTS, new Item.Properties())
					.Add_Extra_Base_Form_Items(OtherItems.BLANK_FORM,SHARK_ANIMAL_CRYSTAL_MEGAZORD, TIGER_ANIMAL_CRYSTAL_MEGAZORD, BISON_ANIMAL_CRYSTAL_MEGAZORD).AddToTabList(RangerTabs.WILD_FORCE).ChangeRepairItem(OtherItems.MECHA_GEAR.get()));
	public static final DeferredItem<Item> KONGAZORD_HELMET = ITEMS.register("kongazord_head",
			() -> new WildForceMegazordItem(ArmorMaterials.NETHERITE,"kongazord",GORILLA_ANIMAL_CRYSTAL,WILD_FORCE_MEGAZORD_CHESTPLATE,WILD_FORCE_MEGAZORD_LEGGINGS,WILD_FORCE_MEGAZORD_BOOTS, new Item.Properties())
					.Add_Extra_Base_Form_Items(OtherItems.BLANK_FORM,POLAR_BEAR_ANIMAL_CRYSTAL,BLACK_BEAR_ANIMAL_CRYSTAL,BISON_ANIMAL_CRYSTAL_OTHERS).AddToTabList(RangerTabs.WILD_FORCE).ChangeRepairItem(OtherItems.MECHA_GEAR.get()));

	public static final DeferredItem<Item> PREDAZORD_HELMET = ITEMS.register("predazord_head",
			() -> new PredazordItem(ArmorMaterials.NETHERITE,"predazord",ALLIGATOR_ANIMAL_CRYSTAL,WILD_FORCE_MEGAZORD_CHESTPLATE,WILD_FORCE_MEGAZORD_LEGGINGS,WILD_FORCE_MEGAZORD_BOOTS, new Item.Properties())
					.Add_Extra_Base_Form_Items(OtherItems.BLANK_FORM,HAMMERHEAD_SHARK_ANIMAL_CRYSTAL, WOLF_ANIMAL_CRYSTAL_MEGAZORD).AddToTabList(RangerTabs.WILD_FORCE).ChangeRepairItem(OtherItems.MECHA_GEAR.get()));
	public static final DeferredItem<Item> PREDAZORD_BLUE_MOON_HELMET = ITEMS.register("predazord_blue_moon_head",
			() -> new PredazordItem(ArmorMaterials.NETHERITE,"predazord_blue_moon",ALLIGATOR_ANIMAL_CRYSTAL_BLUE_MOON,WILD_FORCE_MEGAZORD_CHESTPLATE,WILD_FORCE_MEGAZORD_LEGGINGS,WILD_FORCE_MEGAZORD_BOOTS, new Item.Properties())
					.Add_Extra_Base_Form_Items(OtherItems.BLANK_FORM,HAMMERHEAD_SHARK_ANIMAL_CRYSTAL, WOLF_ANIMAL_CRYSTAL_MEGAZORD).AddToTabList(RangerTabs.WILD_FORCE).ChangeRepairItem(OtherItems.MECHA_GEAR.get()));

	public static final DeferredItem<Item> ISIS_MEGAZORD_HELMET = ITEMS.register("isis_megazord_head",
			() -> new WildForceMegazordItem(ArmorMaterials.NETHERITE,"isis_megazord",FALCON_ANIMAL_CRYSTAL,WILD_FORCE_MEGAZORD_CHESTPLATE,WILD_FORCE_MEGAZORD_LEGGINGS,WILD_FORCE_MEGAZORD_BOOTS, new Item.Properties())
					.Add_Extra_Base_Form_Items(OtherItems.BLANK_FORM,GIRAFFE_ANIMAL_CRYSTAL,DEER_ANIMAL_CRYSTAL,RHINO_ANIMAL_CRYSTAL).AddToTabList(RangerTabs.WILD_FORCE).ChangeRepairItem(OtherItems.MECHA_GEAR.get()));

	public static final DeferredItem<Item> ANIMUS_HELMET = ITEMS.register("animus_head",
			() -> new WildForceMegazordItem(ArmorMaterials.NETHERITE,"animus",BLACK_LION_ANIMAL_CRYSTAL,WILD_FORCE_MEGAZORD_CHESTPLATE,WILD_FORCE_MEGAZORD_LEGGINGS,WILD_FORCE_MEGAZORD_BOOTS, new Item.Properties())
					.Add_Extra_Base_Form_Items(OtherItems.BLANK_FORM,SAWSHARK_ANIMAL_CRYSTAL,JAGUAR_ANIMAL_CRYSTAL,BUFFALO_ANIMAL_CRYSTAL).AddToTabList(RangerTabs.WILD_FORCE).ChangeRepairItem(OtherItems.MECHA_GEAR.get()));

	public static final DeferredItem<Item> ULTIMUS_MEGAZORD_HELMET = ITEMS.register("ultimus_megazord_head",
			() -> new WildForceMegazordItem(ArmorMaterials.NETHERITE,"ultimus_megazord",RED_GORILLA_ANIMAL_CRYSTAL,WILD_FORCE_MEGAZORD_CHESTPLATE,WILD_FORCE_MEGAZORD_LEGGINGS,WILD_FORCE_MEGAZORD_BOOTS, new Item.Properties())
					.Add_Extra_Base_Form_Items(OtherItems.BLANK_FORM,SHARK_ANIMAL_CRYSTAL_MEGAZORD, TIGER_ANIMAL_CRYSTAL_MEGAZORD,BISON_ANIMAL_CRYSTAL_OTHERS).AddToTabList(RangerTabs.WILD_FORCE).ChangeRepairItem(OtherItems.MECHA_GEAR.get()));

    public static final DeferredItem<SwordItem> FIN_BLADE = ITEMS.register("fin_blade",
			() -> new BaseSwordItem(Tiers.NETHERITE, 30, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.WILD_FORCE).ChangeRepairItem(OtherItems.MECHA_GEAR.get()));

	public static final DeferredItem<SwordItem> ELEPHANT_SWORD = ITEMS.register("elephant_sword",
			() -> new BaseSwordItem(Tiers.NETHERITE, 30, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.WILD_FORCE).ChangeRepairItem(OtherItems.MECHA_GEAR.get()));
	public static final DeferredItem<Item> ELEPHANT_SHIELD = ITEMS.register("elephant_shield",
			() -> new BaseShieldItem(new Item.Properties()).AddToTabList(RangerTabs.WILD_FORCE).ChangeRepairItem(OtherItems.MECHA_GEAR.get()));

	public static final DeferredItem<SwordItem> SWINGING_ANCHOR = ITEMS.register("swinging_anchor",
			() -> new BaseSwordItem(Tiers.NETHERITE, 30, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.WILD_FORCE).ChangeRepairItem(OtherItems.MECHA_GEAR.get()));

	public static final DeferredItem<SwordItem> GATOR_STAFF = ITEMS.register("gator_staff",
			() -> new BaseSwordItem(Tiers.NETHERITE, 30, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.WILD_FORCE).ChangeRepairItem(OtherItems.MECHA_GEAR.get()));
	public static final DeferredItem<SwordItem> GATOR_STAFF_BLUE_MOON = ITEMS.register("gator_staff_blue_moon",
			() -> new BaseSwordItem(Tiers.NETHERITE, 30, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.WILD_FORCE).ChangeRepairItem(OtherItems.MECHA_GEAR.get()));

	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}

}