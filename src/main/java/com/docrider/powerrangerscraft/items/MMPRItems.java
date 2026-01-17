package com.docrider.powerrangerscraft.items;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.effect.EffectCore;
import com.docrider.powerrangerscraft.items.mmpr.DragonDaggerItem;
import com.docrider.powerrangerscraft.items.mmpr.MMPRBeltItem;
import com.docrider.powerrangerscraft.items.others.*;
import com.docrider.powerrangerscraft.items.samurai.SecretDiscItem;
import com.docrider.powerrangerscraft.particle.ModParticles;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MMPRItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PowerRangersCraftCore.MODID);

    public static String[] RANGERS= new String[] {"mmpr_red","mmpr_blue","mmpr_pink","mmpr_black","mmpr_yellow","mmpr_green","samurai_green"};
    public static String[] NINJA_RANGERS= new String[] {"mmpr_red","mmpr_blue","mmpr_pink","mmpr_black","mmpr_yellow","mmpr_white"};

    public static final DeferredItem<Item> MMPR_LOGO = ITEMS.register("mmpr_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.MMPR));

    public static final DeferredItem<Item> TYRANNOSAURUS_POWER_COIN = ITEMS.register("tyrannosaurus_power_coin",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","mmpr_red","mmpr_red_belt",
                    new MobEffectInstance(EffectCore.SLASH, 40, 1,true,false),
                    new MobEffectInstance(EffectCore.PUNCH, 40, 2,true,false)){
    public void OnTransformation(ItemStack itemstack, LivingEntity player) {
        super.OnTransformation(itemstack,player);
        ((ServerLevel) player.level()).sendParticles(ModParticles.MMPR_MORPHER_PARTICLES.get(),
                player.getX(), player.getY()+1,
                player.getZ(), 1, 0, 0, 0, 1);
        ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                player.getX(), player.getY()+1,
                player.getZ(), 100, 0, 0, 0, 1);
        ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                player.getX(), player.getY()+1,
                player.getZ(), 100, 0, 0, 0, 1);
    }}
                    .ResetFormToBase().ChangeBeltModel("geo/mmpr_belt_weapon.geo.json").AddToTabList(RangerTabs.MMPR));

    public static final DeferredItem<Item> MASTODON_POWER_COIN = ITEMS.register("mastodon_power_coin",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","mmpr_black","mmpr_black_belt",
                    new MobEffectInstance(EffectCore.SLASH, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false))
            {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack,player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.MMPR_MORPHER_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 1, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLACK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.ResetFormToBase().ChangeBeltModel("geo/mmpr_belt_weapon.geo.json").AddToTabList(RangerTabs.MMPR));

    public static final DeferredItem<Item> TRICERATOPS_POWER_COIN = ITEMS.register("triceratops_power_coin",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","mmpr_blue","mmpr_blue_belt",
                    new MobEffectInstance(EffectCore.SLASH, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false))
            {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack,player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.MMPR_MORPHER_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 1, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.ResetFormToBase().ChangeBeltModel("geo/mmpr_belt_weapon.geo.json").AddToTabList(RangerTabs.MMPR));

    public static final DeferredItem<Item> SABERTOOTH_TIGER_POWER_COIN = ITEMS.register("sabertooth_tiger_power_coin",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","mmpr_yellow","mmpr_yellow_belt",
                    new MobEffectInstance(EffectCore.SLASH, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false))
            {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack,player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.MMPR_MORPHER_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 1, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.YELLOW_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.ResetFormToBase().ChangeBeltModel("geo/mmpr_belt_weapon.geo.json").AddToTabList(RangerTabs.MMPR));

    public static final DeferredItem<Item> PTERADACTYL_POWER_COIN = ITEMS.register("pteradactyl_power_coin",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","mmpr_pink","mmpr_pink_belt",
                    new MobEffectInstance(EffectCore.SHOTBOOST, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 2,true,false))
            {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack,player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.MMPR_MORPHER_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 1, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.PINK_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.ResetFormToBase().ChangeBeltModel("geo/mmpr_belt_weapon.geo.json").AddToTabList(RangerTabs.MMPR));


    public static final DeferredItem<Item> DRAGON_POWER_COIN_BASE = ITEMS.register("dragon_power_coin_base",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","mmpr_green","mmpr_green_belt",
                    new MobEffectInstance(EffectCore.SLASH, 40, 1,true,false),
                    new MobEffectInstance(EffectCore.PUNCH, 40, 2,true,false))
            {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack,player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.MMPR_GREEN_WHITE_MORPHER_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 1, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.ChangeBeltModel("geo/mmpr_belt_weapon.geo.json"));
    public static final DeferredItem<Item> DRAGON_POWER_COIN_NO_SHIELD = ITEMS.register("dragon_power_coin_no_shield",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"blank","mmpr_green","mmpr_green_belt")
                    .ChangeSlot(2).ChangeBeltModel("geo/mmpr_belt_weapon.geo.json"));
    public static final DeferredItem<Item> DRAGON_POWER_COIN = ITEMS.register("dragon_power_coin",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"dragon_shield","","",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,40,0,true,true))
            {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack,player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.ChangeSlot(2).addSwitchForm(DRAGON_POWER_COIN_NO_SHIELD.get()).AddCompatibilityList(RANGERS).AddToTabList(RangerTabs.MMPR));

    public static final DeferredItem<Item> WHITE_TIGER_POWER_COIN = ITEMS.register("white_tiger_power_coin",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","mmpr_white","mmpr_white_belt",
                    new MobEffectInstance(EffectCore.SLASH, 40, 1,true,false),
                    new MobEffectInstance(EffectCore.PUNCH, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,40,0,true,true))
            {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack,player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.MMPR_GREEN_WHITE_MORPHER_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 1, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.AddToTabList(RangerTabs.MMPR));

    public static final DeferredItem<Item> NINJOR_COIN_BATTLE_MODE = ITEMS.register("ninjor_coin_battle_mode",
            () -> new RangerFormChangeItem(new Item.Properties().rarity(Rarity.RARE),0,"_battle_mode","ninjor","blank",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 0,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 2,true,false))
            {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack,player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 10, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 10, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 80, 0, 0, 0, 1);
                }
            }.ChangeSlot(2).BackToBase());

    public static final DeferredItem<Item> NINJOR_COIN = ITEMS.register("ninjor_coin",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","ninjor","blank",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 1,true,false))
            {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack,player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GOLD_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 10, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.BLUE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 90, 0, 0, 0, 1);
                }
            }.addSwitchForm(NINJOR_COIN_BATTLE_MODE.get()).AddToTabList(RangerTabs.MMPR));

    public static final DeferredItem<Item> REINDEER_POWER_COIN = ITEMS.register("reindeer_power_coin",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","santa_ranger","santa_ranger_belt",
                    new MobEffectInstance(EffectCore.CHRISTMAS,40,1,true,true))
            {
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack,player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.MMPR_SANTA_MORPHER_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 1, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.RED_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.GREEN_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 100, 0, 0, 0, 1);
                }
            }.SetShowUnder().ChangeBeltModel("geo/mmpr_belt.geo.json").AddToTabList(RangerTabs.MMPR));

    public static final DeferredItem<Item> METALLIC_ARMOR_WHITE = ITEMS.register("metallic_armor_power_coin_white",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"_metallic_armor","mmpr_white","mmpr_white_belt",
                    new MobEffectInstance(EffectCore.SLASH, 40, 1,true,false),
                    new MobEffectInstance(EffectCore.PUNCH, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false))
                    .IsGlowing().BackToBase());


    public static final DeferredItem<Item> METALLIC_ARMOR_PINK = ITEMS.register("metallic_armor_power_coin_pink",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"mmpr_pink_metallic_armor","mmpr_pink","mmpr_pink_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false))
                    .ChangeSlot(2).BackToBase().addAlternative(METALLIC_ARMOR_WHITE.get()));


    public static final DeferredItem<Item> METALLIC_ARMOR_YELLOW = ITEMS.register("metallic_armor_power_coin_yellow",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"mmpr_yellow_metallic_armor","mmpr_yellow","mmpr_yellow_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false))
                    .ChangeSlot(2).BackToBase().addAlternative(METALLIC_ARMOR_PINK.get()));


    public static final DeferredItem<Item> METALLIC_ARMOR_BLUE = ITEMS.register("metallic_armor_power_coin_blue",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"mmpr_blue_metallic_armor","mmpr_blue","mmpr_blue_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false))
                    .ChangeSlot(2).BackToBase().addAlternative(METALLIC_ARMOR_YELLOW.get()));


    public static final DeferredItem<Item> METALLIC_ARMOR_BLACK = ITEMS.register("metallic_armor_power_coin_black",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"mmpr_black_metallic_armor","mmpr_black","mmpr_black_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false))
                    .ChangeSlot(2).BackToBase().addAlternative(METALLIC_ARMOR_BLUE.get()));


    public static final DeferredItem<Item> METALLIC_ARMOR = ITEMS.register("metallic_armor_power_coin",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"mmpr_red_metallic_armor","mmpr_red","mmpr_red_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false))
                    .ChangeSlot(2).BackToBase().addAlternative(METALLIC_ARMOR_BLACK.get()).AddToTabList(RangerTabs.MMPR));



    public static final DeferredItem<Item> MMPR_HELMET = ITEMS.register("mmpr_head",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RangerTabs.MMPR).ChangeRepairItem(MMPR_LOGO.get()));
    public static final DeferredItem<Item> MMPR_CHESTPLATE = ITEMS.register("mmpr_torso",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RangerTabs.MMPR).ChangeRepairItem(MMPR_LOGO.get()));
    public static final DeferredItem<Item> MMPR_LEGGINGS = ITEMS.register("mmpr_legs",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RangerTabs.MMPR).ChangeRepairItem(MMPR_LOGO.get()));

    public static final DeferredItem<Item> RED_POWER_MORPHER = ITEMS.register("red_power_morpher",
            () -> new MMPRBeltItem(ArmorMaterials.DIAMOND,"mmpr_red",TYRANNOSAURUS_POWER_COIN,MMPR_HELMET,MMPR_CHESTPLATE,MMPR_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.MMPR).ChangeRepairItem(MMPR_LOGO.get()));
    public static final DeferredItem<Item> BLACK_POWER_MORPHER = ITEMS.register("black_power_morpher",
            () -> new MMPRBeltItem(ArmorMaterials.DIAMOND,"mmpr_black",MASTODON_POWER_COIN,MMPR_HELMET,MMPR_CHESTPLATE,MMPR_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.MMPR).ChangeRepairItem(MMPR_LOGO.get()));
    public static final DeferredItem<Item> BLUE_POWER_MORPHER = ITEMS.register("blue_power_morpher",
            () -> new MMPRBeltItem(ArmorMaterials.DIAMOND,"mmpr_blue", TRICERATOPS_POWER_COIN,MMPR_HELMET,MMPR_CHESTPLATE,MMPR_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.MMPR).ChangeRepairItem(MMPR_LOGO.get()));
    public static final DeferredItem<Item> YELLOW_POWER_MORPHER = ITEMS.register("yellow_power_morpher",
            () -> new MMPRBeltItem(ArmorMaterials.DIAMOND,"mmpr_yellow", SABERTOOTH_TIGER_POWER_COIN,MMPR_HELMET,MMPR_CHESTPLATE,MMPR_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.MMPR).ChangeRepairItem(MMPR_LOGO.get()));
    public static final DeferredItem<Item> PINK_POWER_MORPHER = ITEMS.register("pink_power_morpher",
            () -> new MMPRBeltItem(ArmorMaterials.DIAMOND,"mmpr_pink", PTERADACTYL_POWER_COIN,MMPR_HELMET,MMPR_CHESTPLATE,MMPR_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.MMPR).ChangeRepairItem(MMPR_LOGO.get()));
    public static final DeferredItem<Item> GREEN_POWER_MORPHER = ITEMS.register("green_power_morpher",
            () -> new MMPRBeltItem(ArmorMaterials.DIAMOND,"mmpr_green", DRAGON_POWER_COIN_BASE,MMPR_HELMET,MMPR_CHESTPLATE,MMPR_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.MMPR).ChangeRepairItem(MMPR_LOGO.get()));
    public static final DeferredItem<Item> WHITE_POWER_MORPHER = ITEMS.register("white_power_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"mmpr_white", WHITE_TIGER_POWER_COIN,MMPR_HELMET,MMPR_CHESTPLATE,MMPR_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.MMPR).ChangeRepairItem(MMPR_LOGO.get()));
    public static final DeferredItem<Item> NINJOR_MORPHER = ITEMS.register("ninjor_morpher",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"ninjor", NINJOR_COIN,MMPR_HELMET,MMPR_CHESTPLATE,MMPR_LEGGINGS,new Item.Properties()).Add_Extra_Base_Form_Items(OtherItems.BLANK_FORM).AddToTabList(RangerTabs.MMPR).ChangeRepairItem(MMPR_LOGO.get()));
    public static final DeferredItem<Item> SANTA_POWER_MORPHER = ITEMS.register("santa_power_morpher",
            () -> new MMPRBeltItem(ArmorMaterials.DIAMOND,"santa_ranger", REINDEER_POWER_COIN,MMPR_HELMET,MMPR_CHESTPLATE,MMPR_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.MMPR).ChangeRepairItem(MMPR_LOGO.get()));

    public static final DeferredItem<SwordItem> BLADE_BLASTER = ITEMS.register("blade_blaster",
            () -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.MMPR).ChangeRepairItem(MMPR_LOGO.get()));

    public static final DeferredItem<SwordItem> POWER_SWORD = ITEMS.register("power_sword",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.MMPR).ChangeRepairItem(MMPR_LOGO.get()));
    public static final DeferredItem<BaseBlasterItem> POWER_AXE = ITEMS.register("power_axe",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 2, -2.4F, new Item.Properties()).IsSwordGun().AddToTabList(RangerTabs.MMPR).ChangeRepairItem(MMPR_LOGO.get()));
    public static final DeferredItem<SwordItem> POWER_LANCE = ITEMS.register("power_lance",
            () -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.MMPR).ChangeRepairItem(MMPR_LOGO.get()));
    public static final DeferredItem<SwordItem> POWER_LANCE_TRIDENT = ITEMS.register("power_lance_trident",
            () -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.MMPR).ChangeRepairItem(MMPR_LOGO.get()));
    public static final DeferredItem<SwordItem> POWER_DAGGER = ITEMS.register("power_dagger",
            () -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.MMPR).ChangeRepairItem(MMPR_LOGO.get()));
    public static final DeferredItem<BaseBlasterItem> POWER_BOW = ITEMS.register("power_bow",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 2, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.MMPR).ChangeRepairItem(MMPR_LOGO.get()));

    public static final DeferredItem<BowItem> DRAGON_DAGGER = ITEMS.register("dragon_dagger",
            () -> new DragonDaggerItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.MMPR).ChangeRepairItem(MMPR_LOGO.get()));
    public static final DeferredItem<SwordItem> SWORD_OF_DARKNESS = ITEMS.register("sword_of_darkness",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.MMPR).ChangeRepairItem(MMPR_LOGO.get()));
    public static final DeferredItem<SwordItem> SABA = ITEMS.register("saba",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.MMPR).ChangeRepairItem(MMPR_LOGO.get()));

    public static final DeferredItem<SwordItem> NINJATO = ITEMS.register("ninjato",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.MMPR).ChangeRepairItem(MMPR_LOGO.get()));

    public static final DeferredItem<Item> Z_EMBLEM_GOLDAR = ITEMS.register("z_emblem_goldar",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","goldar","blank")
                    .ChangeModel("goldar.geo.json"));
    public static final DeferredItem<Item> GOLDAR_BELT = ITEMS.register("goldar_belt",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"goldar", Z_EMBLEM_GOLDAR, MMPR_HELMET, MMPR_CHESTPLATE, MMPR_LEGGINGS,new Item.Properties()).ChangeRepairItem(MMPR_LOGO.get()));
    public static final DeferredItem<Item> Z_EMBLEM_GOLDAR_MAXIMUS = ITEMS.register("z_emblem_goldar_maximus",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"_maximus","goldar","blank")
                    .ChangeModel("goldar_maximus.geo.json"));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}