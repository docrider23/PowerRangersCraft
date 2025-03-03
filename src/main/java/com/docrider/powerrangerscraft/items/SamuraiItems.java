package com.docrider.powerrangerscraft.items;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.effect.EffectCore;
import com.docrider.powerrangerscraft.items.others.*;
import com.docrider.powerrangerscraft.items.samurai.SamuraizerItem;
import com.docrider.powerrangerscraft.items.samurai.SecretDiscItem;
import com.docrider.powerrangerscraft.items.samurai.ShodoPhoneItem;
import com.docrider.powerrangerscraft.items.samurai.SamuraiMorpherItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class SamuraiItems {

	public static String[] SAMURAI= new String[] {"samurai_red","samurai_blue","samurai_pink","samurai_green","samurai_yellow","princess_samurai_red","samurai_gold"};

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PowerRangersCraftCore.MODID);
    
	public static final DeferredItem<Item> SAMURAI_LOGO = ITEMS.register("samurai_logo",
    		() -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.SAMURAI));
    
	public static final DeferredItem<Item> SAMURAI_DISC = ITEMS.register("samurai_disc",
    		() -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.SAMURAI));

	public static final DeferredItem<Item> LION_DISC = ITEMS.register("lion_disc",
            () -> new SecretDiscItem(new Item.Properties(),0,"","samurai_red","samurai_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 2,true,false),
            		new MobEffectInstance(EffectCore.SLASH, 40, 2,true,false),
            		new MobEffectInstance(EffectCore.FIRESLASH, 40, 2,true,false))
			.alsoChange2ndSlot(OtherItems.BLANK_FORM.get()).ChangeBeltModel("geo/rangerbeltweapon.geo.json").AddCompatibilityList(new String[] {"princess_samurai_red"}).AddToTabList(RangerTabs.SAMURAI));

	public static final DeferredItem<Item> DRAGON_DISC = ITEMS.register("dragon_disc",
            () -> new SecretDiscItem(new Item.Properties(),0,"","samurai_blue","samurai_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 2,true,false),
            		new MobEffectInstance(EffectCore.SLASH, 40, 2,true,false))
			.alsoChange2ndSlot(OtherItems.BLANK_FORM.get()).ChangeBeltModel("geo/rangerbeltweapon.geo.json").AddToTabList(RangerTabs.SAMURAI));

	public static final DeferredItem<Item> TURTLE_DISC = ITEMS.register("turtle_disc",
            () -> new SecretDiscItem(new Item.Properties(),0,"","samurai_pink","samurai_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false),
            		new MobEffectInstance(EffectCore.SLASH, 40, 2,true,false))
			.alsoChange2ndSlot(OtherItems.BLANK_FORM.get()).ChangeBeltModel("geo/rangerbeltweapon.geo.json").AddToTabList(RangerTabs.SAMURAI));

	public static final DeferredItem<Item> BEAR_DISC = ITEMS.register("bear_disc",
            () -> new SecretDiscItem(new Item.Properties(),0,"","samurai_green","samurai_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
            		new MobEffectInstance(EffectCore.SLASH, 40, 2,true,false))
			.alsoChange2ndSlot(OtherItems.BLANK_FORM.get()).ChangeBeltModel("geo/rangerbeltweapon.geo.json").AddToTabList(RangerTabs.SAMURAI));

	public static final DeferredItem<Item> APE_DISC = ITEMS.register("ape_disc",
            () -> new SecretDiscItem(new Item.Properties(),0,"","samurai_yellow","samurai_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
            		new MobEffectInstance(EffectCore.SLASH, 40, 2,true,false))
			.alsoChange2ndSlot(OtherItems.BLANK_FORM.get()).ChangeBeltModel("geo/rangerbeltweapon.geo.json").AddToTabList(RangerTabs.SAMURAI));
    
	public static final DeferredItem<Item> CORAL_DISC = ITEMS.register("coral_disc",
            () -> new SecretDiscItem(new Item.Properties(),0,"","samurai_gold","samurai_gold_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
            		new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 3,true,false),
            		new MobEffectInstance(EffectCore.SLASH, 40, 2,true,false))
			.alsoChange2ndSlot(OtherItems.BLANK_FORM.get()).ChangeBeltModel("geo/rangerbeltweapon.geo.json").AddToTabList(RangerTabs.SAMURAI));


    
	public static final DeferredItem<Item> BLACK_BOX = ITEMS.register("black_box",
    		() -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.SAMURAI));
	
	public static final DeferredItem<Item> SUPER_SAMURAI_DISC = ITEMS.register("super_samurai_disc",
            () -> new SecretDiscItem(new Item.Properties(),0,"super_samurai_mode","","samurai_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 4,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 4,true,false),
            		new MobEffectInstance(MobEffects.JUMP, 40, 3,true,false),
            		new MobEffectInstance(EffectCore.SLASH, 40, 4,true,false),
            		new MobEffectInstance(EffectCore.FLYING, 40, 4,true,false))
            .ChangeSlot(2).BackToBase().addNeedItem(BLACK_BOX.get()).AddCompatibilityList(SAMURAI).AddToTabList(RangerTabs.SAMURAI));
    
	public static final DeferredItem<Item> SHARK_DISC = ITEMS.register("shark_disc",
            () -> new SecretDiscItem(new Item.Properties(),0,"shark_attack_mode","","samurai_belt",
            		new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 5,true,false),
            		new MobEffectInstance(MobEffects.DIG_SPEED, 40, 5,true,false),
            		new MobEffectInstance(MobEffects.JUMP, 40, 4,true,false),
            		new MobEffectInstance(EffectCore.SLASH, 40, 5,true,false),
            		new MobEffectInstance(EffectCore.FLYING, 40, 5,true,false))
            .ChangeSlot(2).BackToBase().AddCompatibilityList(SAMURAI).AddToTabList(RangerTabs.SAMURAI));

	public static final DeferredItem<Item> SHARK_ATTACK_MEGA_MODE_DISC = ITEMS.register("shark_attack_mega_mode_disc",
			() -> new SecretDiscItem(new Item.Properties(),0,"_shark_attack_mega_mode","","samurai_super_mega_mode_belt").ChangeSlot(2).BackToBase().addNeedForm(SHARK_DISC.get(),2).AddCompatibilityList(SAMURAI));
	public static final DeferredItem<Item> SUPER_MEGA_MODE_DISC = ITEMS.register("super_mega_mode_disc",
			() -> new SecretDiscItem(new Item.Properties(),0,"_super_mega_mode","","samurai_super_mega_mode_belt")
					.alsoChange2ndSlot(OtherItems.BLANK_FORM.get()).ChangeBeltModel("geo/rangerbelt.geo.json").AddCompatibilityList(SAMURAI));
	public static final DeferredItem<Item> MEGA_MODE_DISC = ITEMS.register("mega_mode_disc",
			() -> new SecretDiscItem(new Item.Properties(),0,"_mega_mode","","samurai_belt").addAlternative(SUPER_MEGA_MODE_DISC.get()).ChangeBeltModel("geo/rangerbeltweapon.geo.json").AddCompatibilityList(SAMURAI).AddToTabList(RangerTabs.SAMURAI));
/*
	public static final DeferredItem<Item> SHOGUN_DISC_GOLD = ITEMS.register("shogun_disc_gold",
			() -> new SecretDiscItem(new Item.Properties(),0,"_shogun_mode","samurai_gold","shogun_gold_belt").BackToBase());
	public static final DeferredItem<Item> SHOGUN_DISC_YELLOW = ITEMS.register("shogun_disc_yellow",
			() -> new SecretDiscItem(new Item.Properties(),0,"_shogun_mode","samurai_yellow","shogun_yellow_belt").BackToBase());
	public static final DeferredItem<Item> SHOGUN_DISC_GREEN = ITEMS.register("shogun_disc_green",
			() -> new SecretDiscItem(new Item.Properties(),0,"_shogun_mode","samurai_green","shogun_green_belt").BackToBase());
	public static final DeferredItem<Item> SHOGUN_DISC_PINK = ITEMS.register("shogun_disc_pink",
			() -> new SecretDiscItem(new Item.Properties(),0,"_shogun_mode","samurai_pink","shogun_pink_belt").BackToBase());
	public static final DeferredItem<Item> SHOGUN_DISC_BLUE = ITEMS.register("shogun_disc_blue",
			() -> new SecretDiscItem(new Item.Properties(),0,"_shogun_mode","samurai_blue","shogun_blue_belt").BackToBase());
	public static final DeferredItem<Item> SHOGUN_DISC = ITEMS.register("shogun_disc",
			() -> new SecretDiscItem(new Item.Properties(),0,"_shogun_mode","samurai_red","shogun_red_belt").BackToBase().addNeedForm(SUPER_MEGA_MODE_DISC.get(),2).addAlternative(SHOGUN_DISC_PINK.get()).addAlternative(SHOGUN_DISC_BLUE.get()).addAlternative(SHOGUN_DISC_GREEN.get()).addAlternative(SHOGUN_DISC_YELLOW.get()).addAlternative(SHOGUN_DISC_GOLD.get()).AddToTabList(RangerTabs.SAMURAI));
    */
    public static final DeferredItem<Item> SAMURAI_HELMET = ITEMS.register("samurai_head",
    		() -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RangerTabs.SAMURAI).ChangeRepairItem(SAMURAI_DISC.get()));
    public static final DeferredItem<Item> SAMURAI_CHESTPLATE = ITEMS.register("samurai_torso",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RangerTabs.SAMURAI).ChangeRepairItem(SAMURAI_DISC.get()));
    public static final DeferredItem<Item> SAMURAI_LEGGINGS = ITEMS.register("samurai_legs",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RangerTabs.SAMURAI).ChangeRepairItem(SAMURAI_DISC.get()));
    
    public static final DeferredItem<Item> RED_SAMURAIZER = ITEMS.register("red_samuraizer",
    		() -> new SamuraizerItem(ArmorMaterials.DIAMOND,"samurai_red", LION_DISC,SAMURAI_HELMET,SAMURAI_CHESTPLATE,SAMURAI_LEGGINGS,new Item.Properties())
    		.Add_Extra_Base_Form_Items(OtherItems.BLANK_FORM).AddToTabList(RangerTabs.SAMURAI).ChangeRepairItem(SAMURAI_DISC.get()));
    public static final DeferredItem<Item> BLUE_SAMURAIZER = ITEMS.register("blue_samuraizer",
    		() -> new SamuraizerItem(ArmorMaterials.DIAMOND,"samurai_blue", DRAGON_DISC,SAMURAI_HELMET,SAMURAI_CHESTPLATE,SAMURAI_LEGGINGS,new Item.Properties())
    		.Add_Extra_Base_Form_Items(OtherItems.BLANK_FORM).AddToTabList(RangerTabs.SAMURAI).ChangeRepairItem(SAMURAI_DISC.get()));
    public static final DeferredItem<Item> PINK_SAMURAIZER = ITEMS.register("pink_samuraizer",
    		() -> new SamuraizerItem(ArmorMaterials.DIAMOND,"samurai_pink",TURTLE_DISC,SAMURAI_HELMET,SAMURAI_CHESTPLATE,SAMURAI_LEGGINGS,new Item.Properties())
    		.Add_Extra_Base_Form_Items(OtherItems.BLANK_FORM).AddToTabList(RangerTabs.SAMURAI).ChangeRepairItem(SAMURAI_DISC.get()));
    public static final DeferredItem<Item> GREEN_SAMURAIZER = ITEMS.register("green_samuraizer",
    		() -> new SamuraizerItem(ArmorMaterials.DIAMOND,"samurai_green", BEAR_DISC,SAMURAI_HELMET,SAMURAI_CHESTPLATE,SAMURAI_LEGGINGS,new Item.Properties())
    		.Add_Extra_Base_Form_Items(OtherItems.BLANK_FORM).AddToTabList(RangerTabs.SAMURAI).ChangeRepairItem(SAMURAI_DISC.get()));
    public static final DeferredItem<Item> YELLOW_SAMURAIZER = ITEMS.register("yellow_samuraizer",
    		() -> new SamuraizerItem(ArmorMaterials.DIAMOND,"samurai_yellow", APE_DISC,SAMURAI_HELMET,SAMURAI_CHESTPLATE,SAMURAI_LEGGINGS,new Item.Properties())
    		.Add_Extra_Base_Form_Items(OtherItems.BLANK_FORM).AddToTabList(RangerTabs.SAMURAI).ChangeRepairItem(SAMURAI_DISC.get()));
    public static final DeferredItem<Item> SAMURAI_MORPHER = ITEMS.register("samurai_morpher",
    		() -> new SamuraiMorpherItem(ArmorMaterials.DIAMOND,"samurai_gold", CORAL_DISC,SAMURAI_HELMET,SAMURAI_CHESTPLATE,SAMURAI_LEGGINGS,new Item.Properties())
    		.Add_Extra_Base_Form_Items(OtherItems.BLANK_FORM).AddToTabList(RangerTabs.SAMURAI).ChangeRepairItem(SAMURAI_DISC.get()));
    public static final DeferredItem<Item> PRINCESS_SAMURAIZER = ITEMS.register("princess_samuraizer",
    		() -> new ShodoPhoneItem(ArmorMaterials.DIAMOND,"princess_samurai_red", LION_DISC,SAMURAI_HELMET,SAMURAI_CHESTPLATE,SAMURAI_LEGGINGS,new Item.Properties())
    		.Add_Extra_Base_Form_Items(OtherItems.BLANK_FORM).AddToTabList(RangerTabs.SAMURAI).ChangeRepairItem(SAMURAI_DISC.get()));
    
    public static final DeferredItem<SwordItem> SPIN_SWORD = ITEMS.register("spin_sword",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.SAMURAI).ChangeRepairItem(SAMURAI_DISC.get()));
	public static final DeferredItem<SwordItem> MEGA_BLADE = ITEMS.register("mega_blade",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.SAMURAI).ChangeRepairItem(SAMURAI_DISC.get()));
    
    public static final DeferredItem<SwordItem> FIRE_SMASHER = ITEMS.register("fire_smasher",
			() -> new BaseSwordItem(Tiers.DIAMOND, 12, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.SAMURAI).ChangeRepairItem(SAMURAI_DISC.get()));
    public static final DeferredItem<BaseBlasterItem> HYDRO_BOW = ITEMS.register("hydro_bow",
			() -> new BaseBlasterItem(Tiers.DIAMOND, 2, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.SAMURAI).ChangeRepairItem(SAMURAI_DISC.get()));
    public static final DeferredItem<SwordItem> SKY_FAN = ITEMS.register("sky_fan",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.SAMURAI).ChangeRepairItem(SAMURAI_DISC.get()));
    public static final DeferredItem<SwordItem> FOREST_SPEAR = ITEMS.register("forest_spear",
			() -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.SAMURAI).ChangeRepairItem(SAMURAI_DISC.get()));
    public static final DeferredItem<BaseThrowableItem> EARTH_SLICER = ITEMS.register("earth_slicer",
			() -> new BaseThrowableItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.SAMURAI).ChangeRepairItem(SAMURAI_DISC.get()));
    public static final DeferredItem<SwordItem> BARRACUDA_BLADE = ITEMS.register("barracuda_blade",
			() -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.SAMURAI).ChangeRepairItem(SAMURAI_DISC.get()));
    
    public static final DeferredItem<SwordItem> SUPER_SPIN_SWORD = ITEMS.register("super_spin_sword",
			() -> new BaseSwordItem(Tiers.DIAMOND, 12, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.SAMURAI).ChangeRepairItem(SAMURAI_DISC.get()));
	public static final DeferredItem<SwordItem> SUPER_MEGA_BLADE = ITEMS.register("super_mega_blade",
			() -> new BaseSwordItem(Tiers.DIAMOND, 12, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.SAMURAI).ChangeRepairItem(SAMURAI_DISC.get()));
    
    public static final DeferredItem<SwordItem> SHARK_SWORD = ITEMS.register("shark_sword",
			() -> new BaseSwordItem(Tiers.DIAMOND, 16, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.SAMURAI).ChangeRepairItem(SAMURAI_DISC.get()));
    
    public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}

}