package com.docrider.powerrangerscraft.items;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.items.others.BaseItem;
import com.docrider.powerrangerscraft.items.turbo.TurboMorpherItem;
import com.docrider.powerrangerscraft.items.others.*;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class TurboItems {

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PowerRangersCraftCore.MODID);
    
	public static final DeferredItem<Item> TURBO_LOGO = ITEMS.register("turbo_logo",
    		() -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.TURBO));

	public static final DeferredItem<Item> RED_TURBO_KEY = ITEMS.register("red_turbo_key",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","turbo_red","turbo_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false))
			.ChangeBeltModel("geo/rangerbeltextra.geo.json").AddToTabList(RangerTabs.TURBO));

	public static final DeferredItem<Item> BLUE_TURBO_KEY = ITEMS.register("blue_turbo_key",
			() -> new RangerFormChangeItem(new Item.Properties(),0,"","turbo_blue","turbo_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false))
					.ChangeBeltModel("geo/rangerbeltextra.geo.json").AddToTabList(RangerTabs.TURBO));

	public static final DeferredItem<Item> GREEN_TURBO_KEY = ITEMS.register("green_turbo_key",
			() -> new RangerFormChangeItem(new Item.Properties(),0,"","turbo_green","turbo_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false))
					.ChangeBeltModel("geo/rangerbeltextra.geo.json").AddToTabList(RangerTabs.TURBO));

	public static final DeferredItem<Item> YELLOW_TURBO_KEY = ITEMS.register("yellow_turbo_key",
			() -> new RangerFormChangeItem(new Item.Properties(),0,"","turbo_yellow","turbo_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false))
					.ChangeBeltModel("geo/rangerbeltextra.geo.json").AddToTabList(RangerTabs.TURBO));

	public static final DeferredItem<Item> PINK_TURBO_KEY = ITEMS.register("pink_turbo_key",
			() -> new RangerFormChangeItem(new Item.Properties(),0,"","turbo_pink","turbo_belt",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false))
					.ChangeBeltModel("geo/rangerbeltextra.geo.json").AddToTabList(RangerTabs.TURBO));

	public static final DeferredItem<Item> BLUE_SENTURION_BADGE_EVIL = ITEMS.register("blue_senturion_badge_evil",
			() -> new RangerFormChangeItem(new Item.Properties(),0,"","blue_senturion_evil","blank",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)));
	public static final DeferredItem<Item> BLUE_SENTURION_BADGE = ITEMS.register("blue_senturion_badge",
			() -> new RangerFormChangeItem(new Item.Properties(),0,"","blue_senturion","blank",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)).addAlternative(BLUE_SENTURION_BADGE_EVIL.get()).AddToTabList(RangerTabs.TURBO));

	public static final DeferredItem<Item> POWER_RUBY = ITEMS.register("power_ruby",
			() -> new RangerFormChangeItem(new Item.Properties(),0,"","phantom_ranger","blank",
					new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
					new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
					new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 0,true,false)).AddToTabList(RangerTabs.TURBO));

	public static final DeferredItem<Item> TURBO_HELMET = ITEMS.register("turbo_head",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RangerTabs.TURBO).ChangeRepairItem(TURBO_LOGO.get()));
    public static final DeferredItem<Item> TURBO_CHESTPLATE = ITEMS.register("turbo_torso",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RangerTabs.TURBO).ChangeRepairItem(TURBO_LOGO.get()));
    public static final DeferredItem<Item> TURBO_LEGGINGS = ITEMS.register("turbo_legs",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RangerTabs.TURBO).ChangeRepairItem(TURBO_LOGO.get()));
    
    public static final DeferredItem<Item> RED_TURBO_MORPHER = ITEMS.register("red_turbo_morpher",
    		() -> new TurboMorpherItem(ArmorMaterials.DIAMOND,"turbo_red",RED_TURBO_KEY,TURBO_HELMET,TURBO_CHESTPLATE,TURBO_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.TURBO).ChangeRepairItem(TURBO_LOGO.get()));
	public static final DeferredItem<Item> BLUE_TURBO_MORPHER = ITEMS.register("blue_turbo_morpher",
			() -> new TurboMorpherItem(ArmorMaterials.DIAMOND,"turbo_blue",BLUE_TURBO_KEY,TURBO_HELMET,TURBO_CHESTPLATE,TURBO_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.TURBO).ChangeRepairItem(TURBO_LOGO.get()));
	public static final DeferredItem<Item> GREEN_TURBO_MORPHER = ITEMS.register("green_turbo_morpher",
			() -> new TurboMorpherItem(ArmorMaterials.DIAMOND,"turbo_green",GREEN_TURBO_KEY,TURBO_HELMET,TURBO_CHESTPLATE,TURBO_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.TURBO).ChangeRepairItem(TURBO_LOGO.get()));
	public static final DeferredItem<Item> YELLOW_TURBO_MORPHER = ITEMS.register("yellow_turbo_morpher",
			() -> new TurboMorpherItem(ArmorMaterials.DIAMOND,"turbo_yellow",YELLOW_TURBO_KEY,TURBO_HELMET,TURBO_CHESTPLATE,TURBO_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.TURBO).ChangeRepairItem(TURBO_LOGO.get()));
	public static final DeferredItem<Item> PINK_TURBO_MORPHER = ITEMS.register("pink_turbo_morpher",
			() -> new TurboMorpherItem(ArmorMaterials.DIAMOND,"turbo_pink",PINK_TURBO_KEY,TURBO_HELMET,TURBO_CHESTPLATE,TURBO_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.TURBO).ChangeRepairItem(TURBO_LOGO.get()));

	public static final DeferredItem<Item> SIGNAL_WHISTLE = ITEMS.register("signal_whistle",
			() -> new RangerChangerItem(ArmorMaterials.DIAMOND, "blue_senturion",BLUE_SENTURION_BADGE,TURBO_HELMET,TURBO_CHESTPLATE,TURBO_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.TURBO).ChangeRepairItem(TURBO_LOGO.get()));
	public static final DeferredItem<Item> SIGNAL_WHISTLE_EVIL = ITEMS.register("signal_whistle_evil",
			() -> new RangerChangerItem(ArmorMaterials.DIAMOND, "blue_senturion_evil",BLUE_SENTURION_BADGE_EVIL,TURBO_HELMET,TURBO_CHESTPLATE,TURBO_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.TURBO).ChangeRepairItem(TURBO_LOGO.get()));
	public static final DeferredItem<Item> PHANTOM_RANGER_MODULE = ITEMS.register("phantom_ranger_module",
		() -> new RangerChangerItem(ArmorMaterials.DIAMOND, "phantom_ranger",POWER_RUBY,TURBO_HELMET,TURBO_CHESTPLATE,TURBO_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.TURBO).ChangeRepairItem(TURBO_LOGO.get()));

	public static final DeferredItem<BaseBlasterItem> AUTO_BLASTER = ITEMS.register("auto_blaster",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).IsChargeWeapon().AddToTabList(RangerTabs.TURBO).ChangeRepairItem(TURBO_LOGO.get()));
	public static final DeferredItem<SwordItem> TURBO_BLADE = ITEMS.register("turbo_blade",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.TURBO).ChangeRepairItem(TURBO_LOGO.get()));

	public static final DeferredItem<SwordItem> TURBO_LIGHTNING_SWORD = ITEMS.register("turbo_lightning_sword",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.TURBO).ChangeRepairItem(TURBO_LOGO.get()));
	public static final DeferredItem<BaseBlasterItem> TURBO_HAND_BLASTER = ITEMS.register("turbo_hand_blaster",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 2, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.TURBO).ChangeRepairItem(TURBO_LOGO.get()));
	public static final DeferredItem<BaseBlasterItem> TURBO_THUNDER_CANNON = ITEMS.register("turbo_thunder_cannon",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 2, -2.4F, new Item.Properties()).setProjectileLargeFireball(1).AddToTabList(RangerTabs.TURBO).ChangeRepairItem(TURBO_LOGO.get()));
	public static final DeferredItem<SwordItem> TURBO_STAR_CHARGER = ITEMS.register("turbo_star_charger",
			() -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.TURBO).ChangeRepairItem(TURBO_LOGO.get()));
	public static final DeferredItem<BaseBlasterItem> TURBO_WIND_FIRE = ITEMS.register("turbo_wind_fire",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 2, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.TURBO).ChangeRepairItem(TURBO_LOGO.get()));

	public static final DeferredItem<BaseBlasterItem> TURBO_NAVIGATOR = ITEMS.register("turbo_navigator",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 3, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.TURBO).ChangeRepairItem(TURBO_LOGO.get()));
	public static final DeferredItem<BaseBlasterItem> AUTO_BLAST_DEFENDER = ITEMS.register("auto_blast_defender",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.TURBO).ChangeRepairItem(TURBO_LOGO.get()));

	public static final DeferredItem<BaseBlasterItem> SENTURION_SYNERGIZER = ITEMS.register("senturion_synergizer",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).IsSwordGun().AddToTabList(RangerTabs.TURBO).ChangeRepairItem(TURBO_LOGO.get()));

	/*public static final DeferredItem<BaseBlasterItem> PHANTOM_LASER = ITEMS.register("phantom_laser",
			() -> new BaseBlasterItem(Tiers.DIAMOND,5,-2.4F, new Item.Properties()).AddToTabList(RangerTabs.TURBO).ChangeRepairItem(TURBO_LOGO.get()));*/

	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}

}