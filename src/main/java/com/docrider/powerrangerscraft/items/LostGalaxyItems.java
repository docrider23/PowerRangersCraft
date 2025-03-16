package com.docrider.powerrangerscraft.items;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.effect.EffectCore;
import com.docrider.powerrangerscraft.items.lost_galaxy.TransmorpherItem;
import com.docrider.powerrangerscraft.items.others.RangerChangerItem;
import com.docrider.powerrangerscraft.items.others.*;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import javax.print.attribute.standard.MediaSize;

public class LostGalaxyItems {

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PowerRangersCraftCore.MODID);
    
	public static final DeferredItem<Item> LOST_GALAXY_LOGO = ITEMS.register("lost_galaxy_logo",
    		() -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.LOST_GALAXY));

	public static final DeferredItem<Item> LION_MIRINOI_MEDAL = ITEMS.register("lion_mirinoi_medal",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","galaxy_red","lost_galaxy_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
            		new MobEffectInstance(EffectCore.SLASH, 40, 2,true,false))
			.alsoChange2ndSlot(OtherItems.BLANK_FORM.get()).ChangeBeltModel("geo/rangerbeltextra.geo.json").AddToTabList(RangerTabs.LOST_GALAXY));
    
	public static final DeferredItem<Item> EAGLE_MIRINOI_MEDAL = ITEMS.register("eagle_mirinoi_medal",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","galaxy_green","lost_galaxy_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
            		new MobEffectInstance(EffectCore.SLASH, 40, 2,true,false),
            		new MobEffectInstance(EffectCore.FLYING, 40, 2,true,false))
			.alsoChange2ndSlot(OtherItems.BLANK_FORM.get()).ChangeBeltModel("geo/rangerbeltextra.geo.json").AddToTabList(RangerTabs.LOST_GALAXY));
    
	public static final DeferredItem<Item> GORILLA_MIRINOI_MEDAL = ITEMS.register("gorilla_mirinoi_medal",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","galaxy_blue","lost_galaxy_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
            		new MobEffectInstance(EffectCore.SLASH, 40, 2,true,false))
			.alsoChange2ndSlot(OtherItems.BLANK_FORM.get()).ChangeBeltModel("geo/rangerbeltextra.geo.json").AddToTabList(RangerTabs.LOST_GALAXY));
    
	public static final DeferredItem<Item> WOLF_MIRINOI_MEDAL = ITEMS.register("wolf_mirinoi_medal",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","galaxy_yellow","lost_galaxy_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
            		new MobEffectInstance(EffectCore.SLASH, 40, 2,true,false))
			.alsoChange2ndSlot(OtherItems.BLANK_FORM.get()).ChangeBeltModel("geo/rangerbeltextra.geo.json").AddToTabList(RangerTabs.LOST_GALAXY));
    
	public static final DeferredItem<Item> WILDCAT_MIRINOI_MEDAL = ITEMS.register("wildcat_mirinoi_medal",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","galaxy_pink","lost_galaxy_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
            		new MobEffectInstance(EffectCore.SLASH, 40, 2,true,false))
			.alsoChange2ndSlot(OtherItems.BLANK_FORM.get()).ChangeBeltModel("geo/rangerbeltextra.geo.json").AddToTabList(RangerTabs.LOST_GALAXY));
    
	public static final DeferredItem<Item> MAGNA_DEFENDER_CORE = ITEMS.register("magna_defender_core",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","magna_defender","magna_defender_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
            		new MobEffectInstance(EffectCore.SLASH, 40, 2,true,false))
            .ChangeModel("geo/magna_defender.geo.json").ChangeBeltModel("geo/magna_defender_belt.geo.json").AddToTabList(RangerTabs.LOST_GALAXY));
    
    public static final DeferredItem<Item> LIGHTS_OF_ORION = ITEMS.register("lights_of_orion",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"_lights_of_orion","galaxy_red","lights_of_orion_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false),
            		new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 4,true,false),
            		new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 4,true,false),
            		new MobEffectInstance(MobEffects.JUMP, 400, 3,true,false))
            .ChangeSlot(2).ChangeBeltModel("geo/rangerbeltextra.geo.json")
            .AddCompatibilityList(new String[] {"galaxy_green","galaxy_blue","galaxy_yellow","galaxy_pink"}).AddToTabList(RangerTabs.LOST_GALAXY));

	public static final DeferredItem<Item> GALACTIC_KEY = ITEMS.register("galactic_key",
			() -> new RangerFormChangeItem(new Item.Properties(),0,"_armored","galaxy_red","lights_of_orion_belt").ChangeModel("geo/dino_master.geo.json").ChangeBeltModel("geo/rangerbeltextra.geo.json").AddToTabList(RangerTabs.LOST_GALAXY));
    
    public static final DeferredItem<Item> LOST_GALAXY_HELMET = ITEMS.register("lost_galaxy_head",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RangerTabs.LOST_GALAXY).ChangeRepairItem(LOST_GALAXY_LOGO.get()));
    public static final DeferredItem<Item> LOST_GALAXY_CHESTPLATE = ITEMS.register("lost_galaxy_torso",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RangerTabs.LOST_GALAXY).ChangeRepairItem(LOST_GALAXY_LOGO.get()));
    public static final DeferredItem<Item> LOST_GALAXY_LEGGINGS = ITEMS.register("lost_galaxy_legs",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RangerTabs.LOST_GALAXY).ChangeRepairItem(LOST_GALAXY_LOGO.get()));
    
    public static final DeferredItem<Item> RED_TRANSMORPHER = ITEMS.register("red_transmorpher",
    		() -> new TransmorpherItem(ArmorMaterials.DIAMOND,"galaxy_red",LION_MIRINOI_MEDAL,LOST_GALAXY_HELMET,LOST_GALAXY_CHESTPLATE,LOST_GALAXY_LEGGINGS,new Item.Properties())
    		.Add_Extra_Base_Form_Items(OtherItems.BLANK_FORM).AddToTabList(RangerTabs.LOST_GALAXY).ChangeRepairItem(LOST_GALAXY_LOGO.get()));
    public static final DeferredItem<Item> GREEN_TRANSMORPHER = ITEMS.register("green_transmorpher",
    		() -> new TransmorpherItem(ArmorMaterials.DIAMOND,"galaxy_green",EAGLE_MIRINOI_MEDAL,LOST_GALAXY_HELMET,LOST_GALAXY_CHESTPLATE,LOST_GALAXY_LEGGINGS,new Item.Properties())
    		.Add_Extra_Base_Form_Items(OtherItems.BLANK_FORM).AddToTabList(RangerTabs.LOST_GALAXY).ChangeRepairItem(LOST_GALAXY_LOGO.get()));
    public static final DeferredItem<Item> BLUE_TRANSMORPHER = ITEMS.register("blue_transmorpher",
    		() -> new TransmorpherItem(ArmorMaterials.DIAMOND,"galaxy_blue",GORILLA_MIRINOI_MEDAL,LOST_GALAXY_HELMET,LOST_GALAXY_CHESTPLATE,LOST_GALAXY_LEGGINGS,new Item.Properties())
    		.Add_Extra_Base_Form_Items(OtherItems.BLANK_FORM).AddToTabList(RangerTabs.LOST_GALAXY).ChangeRepairItem(LOST_GALAXY_LOGO.get()));
    public static final DeferredItem<Item> YELLOW_TRANSMORPHER = ITEMS.register("yellow_transmorpher",
    		() -> new TransmorpherItem(ArmorMaterials.DIAMOND,"galaxy_yellow",WOLF_MIRINOI_MEDAL,LOST_GALAXY_HELMET,LOST_GALAXY_CHESTPLATE,LOST_GALAXY_LEGGINGS,new Item.Properties())
    		.Add_Extra_Base_Form_Items(OtherItems.BLANK_FORM).AddToTabList(RangerTabs.LOST_GALAXY).ChangeRepairItem(LOST_GALAXY_LOGO.get()));
    public static final DeferredItem<Item> PINK_TRANSMORPHER = ITEMS.register("pink_transmorpher",
    		() -> new TransmorpherItem(ArmorMaterials.DIAMOND,"galaxy_pink",WILDCAT_MIRINOI_MEDAL,LOST_GALAXY_HELMET,LOST_GALAXY_CHESTPLATE,LOST_GALAXY_LEGGINGS,new Item.Properties())
    		.Add_Extra_Base_Form_Items(OtherItems.BLANK_FORM).AddToTabList(RangerTabs.LOST_GALAXY).ChangeRepairItem(LOST_GALAXY_LOGO.get()));

    public static final DeferredItem<Item> MAGNA_DEFENDER_MORPHER = ITEMS.register("magna_defender_morpher",
    		() -> new RangerChangerItem(ArmorMaterials.DIAMOND,"magna_defender",MAGNA_DEFENDER_CORE,LOST_GALAXY_HELMET,LOST_GALAXY_CHESTPLATE,LOST_GALAXY_LEGGINGS,new Item.Properties())
    		.AddToTabList(RangerTabs.LOST_GALAXY).ChangeRepairItem(LOST_GALAXY_LOGO.get()));
    
    public static final DeferredItem<SwordItem> QUASAR_SABER = ITEMS.register("quasar_saber",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(PowerRangersCraftCore.FORM_WEAPON_ITEM).AddToTabList(RangerTabs.LOST_GALAXY).ChangeRepairItem(LOST_GALAXY_LOGO.get()));
    
    public static final DeferredItem<SwordItem> MAGNA_TALON = ITEMS.register("magna_talon",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.LOST_GALAXY).ChangeRepairItem(LOST_GALAXY_LOGO.get()));
    public static final DeferredItem<BaseBlasterItem> TRANS_BLASTER = ITEMS.register("trans_blaster",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 0, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.LOST_GALAXY).ChangeRepairItem(LOST_GALAXY_LOGO.get()));
    public static final DeferredItem<SwordItem> COSMA_CLAW = ITEMS.register("cosma_claw",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.LOST_GALAXY).ChangeRepairItem(LOST_GALAXY_LOGO.get()));
    public static final DeferredItem<SwordItem> DELTA_DAGGER = ITEMS.register("delta_dagger",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.LOST_GALAXY).ChangeRepairItem(LOST_GALAXY_LOGO.get()));
    public static final DeferredItem<BaseBlasterItem> BETA_BOW = ITEMS.register("beta_bow",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 2, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.LOST_GALAXY).ChangeRepairItem(LOST_GALAXY_LOGO.get()));
	
    public static final DeferredItem<BaseBlasterItem> QUASAR_LAUNCHER_RED = ITEMS.register("quasar_launcher_red",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 10, -2.4F, new Item.Properties()).setProjectileLargeFireball(1).AddToTabList(PowerRangersCraftCore.FORM_WEAPON_ITEM).AddToTabList(PowerRangersCraftCore.FORM_WEAPON_ITEM).AddToTabList(RangerTabs.LOST_GALAXY).ChangeRepairItem(LOST_GALAXY_LOGO.get()));
    public static final DeferredItem<BaseBlasterItem> QUASAR_LAUNCHER_GREEN = ITEMS.register("quasar_launcher_green",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 10, -2.4F, new Item.Properties()).setProjectileLargeFireball(1).AddToTabList(PowerRangersCraftCore.FORM_WEAPON_ITEM).AddToTabList(RangerTabs.LOST_GALAXY).ChangeRepairItem(LOST_GALAXY_LOGO.get()));
    public static final DeferredItem<BaseBlasterItem> QUASAR_LAUNCHER_BLUE = ITEMS.register("quasar_launcher_blue",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 10, -2.4F, new Item.Properties()).setProjectileLargeFireball(1).AddToTabList(PowerRangersCraftCore.FORM_WEAPON_ITEM).AddToTabList(RangerTabs.LOST_GALAXY).ChangeRepairItem(LOST_GALAXY_LOGO.get()));
    public static final DeferredItem<BaseBlasterItem> QUASAR_LAUNCHER_YELLOW = ITEMS.register("quasar_launcher_yellow",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 10, -2.4F, new Item.Properties()).setProjectileLargeFireball(1).AddToTabList(PowerRangersCraftCore.FORM_WEAPON_ITEM).AddToTabList(RangerTabs.LOST_GALAXY).ChangeRepairItem(LOST_GALAXY_LOGO.get()));
    public static final DeferredItem<BaseBlasterItem> QUASAR_LAUNCHER_PINK = ITEMS.register("quasar_launcher_pink",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 10, -2.4F, new Item.Properties()).setProjectileLargeFireball(1).AddToTabList(PowerRangersCraftCore.FORM_WEAPON_ITEM).AddToTabList(RangerTabs.LOST_GALAXY).ChangeRepairItem(LOST_GALAXY_LOGO.get()));
	
    public static final DeferredItem<BaseBlasterItem> MAGNA_SWORD = ITEMS.register("magna_sword",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).IsSwordGun().AddToTabList(RangerTabs.LOST_GALAXY).ChangeRepairItem(LOST_GALAXY_LOGO.get()));

	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}

}