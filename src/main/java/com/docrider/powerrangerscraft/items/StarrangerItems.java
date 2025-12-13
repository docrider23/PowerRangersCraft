package com.docrider.powerrangerscraft.items;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.effect.EffectCore;
import com.docrider.powerrangerscraft.items.others.*;
import com.docrider.powerrangerscraft.items.starranger.CosmoSaberItem;
import com.docrider.powerrangerscraft.items.starranger.MastarChangeItem;
import com.docrider.powerrangerscraft.particle.ModParticles;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class StarrangerItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PowerRangersCraftCore.MODID);

    public static final DeferredItem<Item> STARRANGER_LOGO = ITEMS.register("starranger_logo",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.STARRANGER));

    public static final DeferredItem<Item> BLANK_CONSTELLATION_CARD = ITEMS.register("blank_constellation_card",
            () -> new BaseItem(new Item.Properties()).AddToTabList(RangerTabs.STARRANGER));

    public static final DeferredItem<Item> FIRE_CONSTELLATION_CARD = ITEMS.register("fire_constellation_card",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","star_red","starranger_belt",
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 3, true, false),new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true, false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 300, 0, 0, 0, 0.1);
                    ((ServerLevel) player.level()).sendParticles(ParticleTypes.FLAME,
                            player.getX(), player.getY()+1,
                            player.getZ(), 300, 0, 0, 0, 0.2);
                }
            }
                    .IsGlowing().ChangeBeltModel("geo/rangerbeltchanger.geo.json").AddToTabList(RangerTabs.STARRANGER));

    public static final DeferredItem<Item> WATER_CONSTELLATION_CARD = ITEMS.register("water_constellation_card",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","star_blue","starranger_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true, false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 300, 0, 0, 0, 0.1);
                    ((ServerLevel) player.level()).sendParticles(ParticleTypes.SPLASH,
                            player.getX(), player.getY()+1,
                            player.getZ(), 300, 0, 0, 0, 0.2);
                }
            }
                    .IsGlowing().ChangeBeltModel("geo/rangerbeltchanger.geo.json").AddToTabList(RangerTabs.STARRANGER));

    public static final DeferredItem<Item> EARTH_CONSTELLATION_CARD = ITEMS.register("earth_constellation_card",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","star_green","starranger_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true, false),
                    new MobEffectInstance(EffectCore.FLYING, 40, 5, true, false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 200, 2, true, false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 300, 0, 0, 0, 0.1);
                    ((ServerLevel) player.level()).sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, Blocks.DIRT.defaultBlockState()),
                            player.getX(), player.getY()+1,
                            player.getZ(), 300, 0, 0, 0, 0.2);
                }
            }
                    .IsGlowing().ChangeBeltModel("geo/rangerbeltchanger.geo.json").AddToTabList(RangerTabs.STARRANGER));

    public static final DeferredItem<Item> AIR_CONSTELLATION_CARD = ITEMS.register("air_constellation_card",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","star_white","starranger_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true, false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 300, 0, 0, 0, 0.1);
                    ((ServerLevel) player.level()).sendParticles(ParticleTypes.GUST,
                            player.getX(), player.getY()+1,
                            player.getZ(), 300, 0, 0, 0, 0.2);
                }
            }
                    .IsGlowing().ChangeBeltModel("geo/rangerbeltchanger.geo.json").AddToTabList(RangerTabs.STARRANGER));

    public static final DeferredItem<Item> LIGHTNING_CONSTELLATION_CARD = ITEMS.register("lightning_constellation_card",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","star_lightning","starranger_lightning_belt",
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 1,true,false),
                    new MobEffectInstance(MobEffects.JUMP, 40, 1,true, false)){
                public void OnTransformation(ItemStack itemstack, LivingEntity player) {
                    super.OnTransformation(itemstack, player);
                    ((ServerLevel) player.level()).sendParticles(ModParticles.WHITE_SPARK_PARTICLES.get(),
                            player.getX(), player.getY()+1,
                            player.getZ(), 300, 0, 0, 0, 0.1);
                    LightningBolt thunder = new LightningBolt(EntityType.LIGHTNING_BOLT,player.level());
                    thunder.setVisualOnly(true);
                    thunder.setPos( player.getX(),  -1 + player.getY(),  player.getZ() );
                    player.level().addFreshEntity(thunder);

                }
            }
                    .IsGlowing().ChangeBeltModel("geo/rangerbeltchanger.geo.json").AddToTabList(RangerTabs.STARRANGER));

    public static final DeferredItem<Item> SOLAR_CONSTELLATION_CARD = ITEMS.register("solar_constellation_card",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","taiyou_gold","starranger_equinox_belt",
                    new MobEffectInstance(EffectCore.FLYING, 40, 5, true,false),
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 3, true, false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST,40,5,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN,40,1,true,false))
                    .IsGlowing().ChangeModel("dino_master.geo.json").ChangeBeltModel("geo/rangerbeltweapon.geo.json").AddToTabList(RangerTabs.STARRANGER));

    public static final DeferredItem<Item> LUNAR_CONSTELLATION_CARD = ITEMS.register("lunar_constellation_card",
            () -> new RangerFormChangeItem(new Item.Properties(),0,"","taiyou_gold","starranger_equinox_belt",
                    new MobEffectInstance(EffectCore.FROSTWALKER, 40, 5,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 2,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST,40,3,true,false))
                    .IsGlowing().ChangeBeltModel("geo/rangerbeltweapon.geo.json").ChangeRangerName("tsuki_silver").AddToTabList(RangerTabs.STARRANGER));


    public static final DeferredItem<Item> OPHIUCHUS_CONSTELLATION_CARD = ITEMS.register("ophiuchus_constellation_card",
            () -> new MastarChangeItem(new Item.Properties(),0,"","zodiac_mastar","starranger_mastar_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 2,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 5,true,false),
                    new MobEffectInstance(EffectCore.SLASH, 40, 4,true,false))
                    .IsGlowing().AddToTabList(RangerTabs.STARRANGER));

    public static final DeferredItem<Item> COSMIC_HEART = ITEMS.register("cosmic_heart",
            () -> new MastarChangeItem(new Item.Properties(),0,"","cosmic_mastar","starranger_mastar_belt",
                    new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.DIG_SPEED, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 400, 2,true,false),
                    new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 3,true,false),
                    new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 4,true,false),
                    new MobEffectInstance(EffectCore.SLASH, 40, 4,true,false),
                    new MobEffectInstance(EffectCore.FLYING, 40, 5,true,false),
                    new MobEffectInstance(EffectCore.FROSTWALKER, 40, 5,true,false))
                    .IsGlowing().AddToTabList(RangerTabs.STARRANGER));

    public static final DeferredItem<Item> STARRANGER_HELMET = ITEMS.register("starranger_head",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RangerTabs.STARRANGER).ChangeRepairItem(STARRANGER_LOGO.get()));
    public static final DeferredItem<Item> STARRANGER_CHESTPLATE = ITEMS.register("starranger_torso",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RangerTabs.STARRANGER).ChangeRepairItem(STARRANGER_LOGO.get()));
    public static final DeferredItem<Item> STARRANGER_LEGGINGS = ITEMS.register("starranger_legs",
            () -> new RangerArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RangerTabs.STARRANGER).ChangeRepairItem(STARRANGER_LOGO.get()));

    public static final DeferredItem<Item> RED_ZODIAC_BRACE = ITEMS.register("red_zodiac_brace",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"star_red",FIRE_CONSTELLATION_CARD, STARRANGER_HELMET, STARRANGER_CHESTPLATE, STARRANGER_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.STARRANGER).ChangeRepairItem(STARRANGER_LOGO.get()));
    public static final DeferredItem<Item> BLUE_ZODIAC_BRACE = ITEMS.register("blue_zodiac_brace",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"star_blue", WATER_CONSTELLATION_CARD, STARRANGER_HELMET, STARRANGER_CHESTPLATE, STARRANGER_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.STARRANGER).ChangeRepairItem(STARRANGER_LOGO.get()));
    public static final DeferredItem<Item> GREEN_ZODIAC_BRACE = ITEMS.register("green_zodiac_brace",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"star_green", EARTH_CONSTELLATION_CARD, STARRANGER_HELMET, STARRANGER_CHESTPLATE, STARRANGER_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.STARRANGER).ChangeRepairItem(STARRANGER_LOGO.get()));
    public static final DeferredItem<Item> WHITE_ZODIAC_BRACE = ITEMS.register("white_zodiac_brace",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"star_white", AIR_CONSTELLATION_CARD, STARRANGER_HELMET, STARRANGER_CHESTPLATE, STARRANGER_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.STARRANGER).ChangeRepairItem(STARRANGER_LOGO.get()));
    public static final DeferredItem<Item> YELLOW_LIGHTNING_BRACE = ITEMS.register("yellow_lightning_brace",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"star_lightning", LIGHTNING_CONSTELLATION_CARD, STARRANGER_HELMET, STARRANGER_CHESTPLATE, STARRANGER_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.STARRANGER).ChangeRepairItem(STARRANGER_LOGO.get()));

    public static final DeferredItem<Item> COSMO_SABER_GOLD = ITEMS.register("cosmo_saber_gold",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"taiyou_gold", SOLAR_CONSTELLATION_CARD, STARRANGER_HELMET, STARRANGER_CHESTPLATE, STARRANGER_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.STARRANGER).ChangeRepairItem(STARRANGER_LOGO.get()));

    public static final DeferredItem<Item> OPHIUCHUS_STAFF_MASTAR = ITEMS.register("ophiuchus_staff_mastar",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"zodiac_mastar", OPHIUCHUS_CONSTELLATION_CARD, STARRANGER_HELMET, STARRANGER_CHESTPLATE, STARRANGER_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.STARRANGER).ChangeRepairItem(STARRANGER_LOGO.get()));
    public static final DeferredItem<Item> COSMIC_STAFF_MASTAR = ITEMS.register("cosmic_staff_mastar",
            () -> new RangerChangerItem(ArmorMaterials.DIAMOND,"cosmic_mastar", COSMIC_HEART, STARRANGER_HELMET, STARRANGER_CHESTPLATE, STARRANGER_LEGGINGS,new Item.Properties()).AddToTabList(RangerTabs.STARRANGER).ChangeRepairItem(STARRANGER_LOGO.get()));

    public static final DeferredItem<SwordItem> FLAME_SWORD = ITEMS.register("flame_sword",
        () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.STARRANGER).ChangeRepairItem(STARRANGER_LOGO.get()));
    public static final DeferredItem<BaseBlasterItem> WATER_BOW = ITEMS.register("water_bow",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 2, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.STARRANGER).ChangeRepairItem(STARRANGER_LOGO.get()));
    public static final DeferredItem<SwordItem> EARTH_AXE = ITEMS.register("earth_axe",
            () -> new BaseSwordItem(Tiers.DIAMOND, 6, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.STARRANGER).ChangeRepairItem(STARRANGER_LOGO.get()));
    public static final DeferredItem<SwordItem> AIR_STAFF = ITEMS.register("air_staff",
            () -> new BaseSwordItem(Tiers.DIAMOND, 4, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.STARRANGER).ChangeRepairItem(STARRANGER_LOGO.get()));
    public static final DeferredItem<BaseSwordItem> LIGHTNING_KATANA = ITEMS.register("lightning_katana",
            () -> new BaseSwordItem(Tiers.DIAMOND, 8, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.STARRANGER).ChangeRepairItem(STARRANGER_LOGO.get()));

    public static final DeferredItem<BaseBlasterItem> COSMO_SABER = ITEMS.register("cosmo_saber",
            () -> new CosmoSaberItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).isChanger(COSMO_SABER_GOLD.get()).AddToTabList(PowerRangersCraftCore.FORM_WEAPON_ITEM).AddToTabList(RangerTabs.STARRANGER).ChangeRepairItem(STARRANGER_LOGO.get()));
    public static final DeferredItem<BaseSwordItem> SOLAR_BATTLEAXE = ITEMS.register("solar_battleaxe",
            () -> new BaseSwordItem(Tiers.DIAMOND, 8, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.STARRANGER).ChangeRepairItem(STARRANGER_LOGO.get()));
    public static final DeferredItem<BaseSwordItem> LUNAR_SCYTHE = ITEMS.register("lunar_scythe",
            () -> new BaseSwordItem(Tiers.DIAMOND, 8, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.STARRANGER).ChangeRepairItem(STARRANGER_LOGO.get()));

    public static final DeferredItem<SwordItem> OPHIUCHUS_STAFF = ITEMS.register("ophiuchus_staff",
            () -> new BaseSwordItem(Tiers.DIAMOND, 5, -2.4F, new Item.Properties()).AddToTabList(RangerTabs.STARRANGER).ChangeRepairItem(STARRANGER_LOGO.get()));
    public static final DeferredItem<BaseBlasterItem> COSMIC_STAFF = ITEMS.register("cosmic_staff",
            () -> new BaseBlasterItem(Tiers.DIAMOND, 2, -2.4F, new Item.Properties()).setProjectile(BaseBlasterItem
					.BlasterProjectile.SMALL_FIREBALL).AddToTabList(RangerTabs.STARRANGER).ChangeRepairItem(STARRANGER_LOGO.get()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
