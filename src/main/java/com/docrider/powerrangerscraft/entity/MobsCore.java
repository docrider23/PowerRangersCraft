package com.docrider.powerrangerscraft.entity;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.entity.ally.*;
import com.docrider.powerrangerscraft.entity.bikes.DinoCycleEntity;
import com.docrider.powerrangerscraft.entity.boss.*;
import com.docrider.powerrangerscraft.entity.footsoldier.*;
import com.docrider.powerrangerscraft.entity.projectile.ShurikenProjectileEntity;
import com.docrider.powerrangerscraft.entity.projectile.WeaponProjectileEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MobsCore {public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PowerRangersCraftCore.MODID);
    public static final DeferredRegister<EntityType<?>> MOBLIST = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, PowerRangersCraftCore.MODID);

    //01-02 MMPR
    public static final DeferredHolder<EntityType<?>, EntityType<PuttyPatrollersEntity>> PUTTY_PATROLLERS = MOBLIST.register("putty_patroller",
            () -> EntityType.Builder.of(PuttyPatrollersEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(PowerRangersCraftCore.MODID + ":putty_patroller"));

    public static final DeferredItem<DeferredSpawnEggItem> PUTTY_PATROLLERS_SPAWN_EGG = ITEMS.register("putty_patroller_spawn_egg",
            () -> new DeferredSpawnEggItem(PUTTY_PATROLLERS, 0xa3a2a2, 0xa1a1a1, new Item.Properties()));

    //03 Alien

    //04 Zeo
    public static final DeferredHolder<EntityType<?>, EntityType<CogEntity>> COGS = MOBLIST.register("cog",
            () -> EntityType.Builder.of(CogEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(PowerRangersCraftCore.MODID + ":cog"));

    public static final DeferredItem<DeferredSpawnEggItem> COGS_SPAWN_EGG = ITEMS.register("cog_spawn_egg",
            () -> new DeferredSpawnEggItem(COGS, 0xa3a2a2, 0xa1a1a1, new Item.Properties()));

    //05 Turbo
    public static final DeferredHolder<EntityType<?>, EntityType<ChromitesEntity>> CHROMITES = MOBLIST.register("chromite",
            () -> EntityType.Builder.of(ChromitesEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(PowerRangersCraftCore.MODID + ":chromite"));

    public static final DeferredItem<DeferredSpawnEggItem> CHROMITES_SPAWN_EGG = ITEMS.register("chromite_spawn_egg",
            () -> new DeferredSpawnEggItem(CHROMITES, 0x03a9f4, 0xbd66a6, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<PiranhatronsEntity>> PIRANHATRONS = MOBLIST.register("piranhatron",
            () -> EntityType.Builder.of(PiranhatronsEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(PowerRangersCraftCore.MODID + ":piranhatrons"));

    public static final DeferredItem<DeferredSpawnEggItem> PIRANHATRONS_SPAWN_EGG = ITEMS.register("piranhatron_spawn_egg",
            () -> new DeferredSpawnEggItem(PIRANHATRONS, 0x8b7a82, 0x8f6462, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<BlueSenturionEvilEntity>> BLUE_SENTURION_EVIL = MOBLIST.register("blue_senturion_evil",
            () -> EntityType.Builder.of(BlueSenturionEvilEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(PowerRangersCraftCore.MODID + ":blue_senturion_evil"));

    public static final DeferredItem<DeferredSpawnEggItem> BLUE_SENTURION_EVIL_SPAWN_EGG = ITEMS.register("blue_senturion_evil_spawn_egg",
            () -> new DeferredSpawnEggItem(BLUE_SENTURION_EVIL, 0x1323af, 0xffffff, new Item.Properties()));
    
    //06 In Space

    //07 Lost Galaxy
    public static final DeferredHolder<EntityType<?>, EntityType<SwabbiesEntity>> SWABBIES = MOBLIST.register("swabbies",
            () -> EntityType.Builder.of(SwabbiesEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(PowerRangersCraftCore.MODID + ":swabbies"));

    public static final DeferredItem<DeferredSpawnEggItem> SWABBIES_SPAWN_EGG = ITEMS.register("swabbies_spawn_egg",
            () -> new DeferredSpawnEggItem(SWABBIES, 0xde7002, 0x2e1100, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<StingwingersEntity>> STINGWINGERS = MOBLIST.register("stingwinger",
            () -> EntityType.Builder.of(StingwingersEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(PowerRangersCraftCore.MODID + ":stingwinger"));

    public static final DeferredItem<DeferredSpawnEggItem> STINGWINGERS_SPAWN_EGG = ITEMS.register("stingwingers_spawn_egg",
            () -> new DeferredSpawnEggItem(STINGWINGERS, 0x49513e, 0x4a3a56, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<MagnaDefenderEntity>> MAGNA_DEFENDER = MOBLIST.register("magna_defender",
            () -> EntityType.Builder.of(MagnaDefenderEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(PowerRangersCraftCore.MODID + ":magna_defender"));

    public static final DeferredItem<DeferredSpawnEggItem> MAGNA_DEFENDER_SPAWN_EGG = ITEMS.register("magna_defender_spawn_egg",
            () -> new DeferredSpawnEggItem(MAGNA_DEFENDER, 0x0b0b0b, 0xff9900, new Item.Properties()));
    
    //08 Lightspeed Rescue
    public static final DeferredHolder<EntityType<?>, EntityType<BatlingsEntity>> BATLINGS = MOBLIST.register("batlings",
            () -> EntityType.Builder.of(BatlingsEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(PowerRangersCraftCore.MODID + ":batlings"));

    public static final DeferredItem<DeferredSpawnEggItem> BATLINGS_SPAWN_EGG = ITEMS.register("batlings_spawn_egg",
            () -> new DeferredSpawnEggItem(BATLINGS,0xffffff, 0x151515, new Item.Properties()));
    
    //09 Time Force

    //10 Wild Force
    public static final DeferredHolder<EntityType<?>, EntityType<PutridsEntity>> PUTRIDS = MOBLIST.register("putrids",
            () -> EntityType.Builder.of(PutridsEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(PowerRangersCraftCore.MODID + ":putrids"));

    public static final DeferredItem<DeferredSpawnEggItem> PUTRIDS_SPAWN_EGG = ITEMS.register("putrids_spawn_egg",
            () -> new DeferredSpawnEggItem(PUTRIDS, 0x334a33, 0x8a1e34, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<ZenAkuEntity>> ZEN_AKU = MOBLIST.register("zen_aku",
            () -> EntityType.Builder.of(ZenAkuEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(PowerRangersCraftCore.MODID + ":zen_aku"));

    public static final DeferredItem<DeferredSpawnEggItem> ZEN_AKU_SPAWN_EGG = ITEMS.register("zen_aku_spawn_egg",
            () -> new DeferredSpawnEggItem(ZEN_AKU, 0x0b0b0b, 0x7d7d7d, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<GeneralVenjixEntity>> GENERAL_VENJIX = MOBLIST.register("general_venjix",
            () -> EntityType.Builder.of(GeneralVenjixEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(PowerRangersCraftCore.MODID + ":general_venjix"));

    public static final DeferredItem<DeferredSpawnEggItem> GENERAL_VENJIX_SPAWN_EGG = ITEMS.register("general_venjix_spawn_egg",
            () -> new DeferredSpawnEggItem(GENERAL_VENJIX, 0x0b0b0b, 0xd6ba00, new Item.Properties()));
    
    //11 Ninja Storm
    
    //12 Dino Thunder
    
    //13 SPD
    
    //14 Mystic Force
    
    //15 Operation Overdrive
    public static final DeferredHolder<EntityType<?>, EntityType<ChillersEntity>> CHILLERS = MOBLIST.register("chiller",
            () -> EntityType.Builder.of(ChillersEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(PowerRangersCraftCore.MODID + ":chiller"));

    public static final DeferredItem<DeferredSpawnEggItem> CHILLERS_SPAWN_EGG = ITEMS.register("chiller_spawn_egg",
            () -> new DeferredSpawnEggItem(CHILLERS,0xffffff, 0x151515, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<LavaLizardsEntity>> LAVA_LIZARDS = MOBLIST.register("lava_lizard",
            () -> EntityType.Builder.of(LavaLizardsEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(PowerRangersCraftCore.MODID + ":lava_lizard"));

    public static final DeferredItem<DeferredSpawnEggItem> LAVA_LIZARDS_SPAWN_EGG = ITEMS.register("lava_lizard_spawn_egg",
            () -> new DeferredSpawnEggItem(LAVA_LIZARDS,0xa61a0b, 0x8a1e34, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<MoltorEntity>> MOLTOR = MOBLIST.register("moltor",
            () -> EntityType.Builder.of(MoltorEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(PowerRangersCraftCore.MODID + ":moltor"));

    public static final DeferredItem<DeferredSpawnEggItem> MOLTOR_SPAWN_EGG = ITEMS.register("moltor_spawn_egg",
            () -> new DeferredSpawnEggItem(MOLTOR,0xffffff, 0x151515, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<FluriousEntity>> FLURIOUS = MOBLIST.register("flurious",
            () -> EntityType.Builder.of(FluriousEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(PowerRangersCraftCore.MODID + ":flurious"));

    public static final DeferredItem<DeferredSpawnEggItem> FLURIOUS_SPAWN_EGG = ITEMS.register("flurious_spawn_egg",
            () -> new DeferredSpawnEggItem(FLURIOUS,0x03a9f4, 0xbfefff, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<KamdorEntity>> KAMDOR = MOBLIST.register("kamdor",
            () -> EntityType.Builder.of(KamdorEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(PowerRangersCraftCore.MODID + ":kamdor"));

    public static final DeferredItem<DeferredSpawnEggItem> KAMDOR_SPAWN_EGG = ITEMS.register("kamdor_spawn_egg",
            () -> new DeferredSpawnEggItem(KAMDOR,0x3037fc, 0x4a752a, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<FearcatsEntity>> FEARCATS = MOBLIST.register("fearcats",
            () -> EntityType.Builder.of(FearcatsEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(PowerRangersCraftCore.MODID + ":fearcats"));

    public static final DeferredItem<DeferredSpawnEggItem> FEARCATS_SPAWN_EGG = ITEMS.register("fearcats_spawn_egg",
            () -> new DeferredSpawnEggItem(FEARCATS,0xd6ba00, 0x32dc32, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<ThraxEntity>> THRAX = MOBLIST.register("thrax",
            () -> EntityType.Builder.of(ThraxEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(PowerRangersCraftCore.MODID + ":thrax"));

    public static final DeferredItem<DeferredSpawnEggItem> THRAX_SPAWN_EGG = ITEMS.register("thrax_spawn_egg",
            () -> new DeferredSpawnEggItem(THRAX,0x8a1e34, 0xc0c0c0, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<SentinelKnightEntity>> SENTINEL_KNIGHT = MOBLIST.register("sentinel_knight",
            () -> EntityType.Builder.of(SentinelKnightEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(PowerRangersCraftCore.MODID + ":sentinel_knight"));

    public static final DeferredItem<DeferredSpawnEggItem> SENTINEL_KNIGHT_SPAWN_EGG = ITEMS.register("sentinel_knight_spawn_egg",
            () -> new DeferredSpawnEggItem(SENTINEL_KNIGHT,0xffffff, 0x151515, new Item.Properties()));
    
    //16 Jungle Fury
    
    //17 RPM

    //18-19 Samurai/Super Samurai
    public static final DeferredHolder<EntityType<?>, EntityType<MoogersEntity>> MOOGERS = MOBLIST.register("mooger",
            () -> EntityType.Builder.of(MoogersEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(PowerRangersCraftCore.MODID + ":mooger"));

    public static final DeferredItem<DeferredSpawnEggItem> MOOGERS_SPAWN_EGG = ITEMS.register("mooger_spawn_egg",
            () -> new DeferredSpawnEggItem(MOOGERS, 0xd6ba00, 0xa61a0b, new Item.Properties()));
            
    //20 Megaforce
    
    //21 Super Megaforce
    
    //22-23 Dino Charge/Dino Supercharge
    public static final DeferredHolder<EntityType<?>, EntityType<DinoCycleEntity>> DINO_CYCLE = MOBLIST.register("dino_cycle",
            () -> EntityType.Builder.of(DinoCycleEntity::new, MobCategory.MISC).clientTrackingRange(10).sized(0.6F, 1.25F).build( PowerRangersCraftCore.MODID + ":dino_cycle"));
    
    //24-25 Ninja Steel/Super Ninja Steel
    
    //26-27 Beast Morphers

    //28 Dino Fury
    public static final DeferredHolder<EntityType<?>, EntityType<HengemenEntity>> HENGEMEN = MOBLIST.register("hengemen",
            () -> EntityType.Builder.of(HengemenEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(PowerRangersCraftCore.MODID + ":hengemen"));

    public static final DeferredItem<DeferredSpawnEggItem> HENGEMEN_SPAWN_EGG = ITEMS.register("hengemen_spawn_egg",
            () -> new DeferredSpawnEggItem(HENGEMEN, 0xbfbcb9, 0xc1a800, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<VoidKnightEntity>> VOID_KNIGHT = MOBLIST.register("void_knight",
            () -> EntityType.Builder.of(VoidKnightEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(PowerRangersCraftCore.MODID + ":void_knight"));

    public static final DeferredItem<DeferredSpawnEggItem> VOID_KNIGHT_SPAWN_EGG = ITEMS.register("void_knight_spawn_egg",
            () -> new DeferredSpawnEggItem(VOID_KNIGHT, 0x56007f, 0x9c9c9c, new Item.Properties()));

    //29 Cosmic Fury
    public static final DeferredHolder<EntityType<?>, EntityType<ZentinelEntity>> ZENTINELS = MOBLIST.register("zentinel",
            () -> EntityType.Builder.of(ZentinelEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8)
                    .build(PowerRangersCraftCore.MODID + ":zentinel"));

    public static final DeferredItem<DeferredSpawnEggItem> ZENTINEL_SPAWN_EGG = ITEMS.register("zentinel_spawn_egg",
            () -> new DeferredSpawnEggItem(ZENTINELS, 0xa3a2a2, 0x414242, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<EvilBlueDinoFuryEntity>> EVIL_BLUE_DINO_FURY_RANGER = MOBLIST.register("evil_blue_dino_fury_ranger",
            () -> EntityType.Builder.of(EvilBlueDinoFuryEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8)
                    .build(PowerRangersCraftCore.MODID + ":evil_blue_dino_fury"));

    public static final DeferredItem<DeferredSpawnEggItem> EVIL_BLUE_DINO_FURY_RANGER_SPAWN_EGG = ITEMS.register("evil_blue_dino_fury_ranger_spawn_egg",
            () -> new DeferredSpawnEggItem(EVIL_BLUE_DINO_FURY_RANGER, 0x0a21f2, 0x000000, new Item.Properties()));
    
    //EX Hyperforce
    public static final DeferredHolder<EntityType<?>, EntityType<SilverSentryEntity>> SILVER_SENTRIES = MOBLIST.register("silver_sentry",
            () -> EntityType.Builder.of(SilverSentryEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8)
                    .build(PowerRangersCraftCore.MODID + ":silver_sentry"));

    public static final DeferredItem<DeferredSpawnEggItem> SILVER_SENTRY_SPAWN_EGG = ITEMS.register("silver_sentry_spawn_egg",
            () -> new DeferredSpawnEggItem(SILVER_SENTRIES, 0x8ca9a4, 0x272727, new Item.Properties()));

    //EX Power Rangers (2017)
    public static final DeferredHolder<EntityType<?>, EntityType<RebootPuttyEntity>> REBOOT_PUTTY = MOBLIST.register("reboot_putty",
            () -> EntityType.Builder.of(RebootPuttyEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8)
                    .build(PowerRangersCraftCore.MODID + ":reboot_putty"));

    public static final DeferredItem<DeferredSpawnEggItem> REBOOT_PUTTY_SPAWN_EGG = ITEMS.register("reboot_putty_spawn_egg",
            () -> new DeferredSpawnEggItem(REBOOT_PUTTY, 0xa3a2a2, 0x414242, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<RebootRitaEntity>> REBOOT_RITA = MOBLIST.register("reboot_rita",
            () -> EntityType.Builder.of(RebootRitaEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8)
                    .build(PowerRangersCraftCore.MODID + ":reboot_rita"));

    public static final DeferredItem<DeferredSpawnEggItem> REBOOT_RITA_SPAWN_EGG = ITEMS.register("reboot_rita_spawn_egg",
            () -> new DeferredSpawnEggItem(REBOOT_RITA, 0x17350e, 0xfc9804, new Item.Properties()));

    //EX Comics: Omega Rangers
    public static final DeferredHolder<EntityType<?>, EntityType<HorridEntity>> HORRID = MOBLIST.register("horrid",
            () -> EntityType.Builder.of(HorridEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8)
                    .build(PowerRangersCraftCore.MODID + ":horrid"));

    public static final DeferredItem<DeferredSpawnEggItem> HORRID_SPAWN_EGG = ITEMS.register("horrid_spawn_egg",
            () -> new DeferredSpawnEggItem(HORRID, 0x9b9aca, 0xb46383, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<DeathRangerEntity>> DEATH_RANGER = MOBLIST.register("death_ranger",
            () -> EntityType.Builder.of(DeathRangerEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8)
                    .build(PowerRangersCraftCore.MODID + ":death_ranger"));

    public static final DeferredItem<DeferredSpawnEggItem> DEATH_RANGER_SPAWN_EGG = ITEMS.register("death_ranger_spawn_egg",
            () -> new DeferredSpawnEggItem(DEATH_RANGER, 0x4b4e49, 0xf1a622, new Item.Properties()));

    //EX Comics: Prime Rangers
    public static final DeferredHolder<EntityType<?>, EntityType<EltarianGuardEntity>> ELTARIAN_GUARD = MOBLIST.register("eltarian_guard",
            () -> EntityType.Builder.of(EltarianGuardEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8)
                    .build(PowerRangersCraftCore.MODID + ":eltarian_guard"));

    public static final DeferredItem<DeferredSpawnEggItem> ELTARIAN_GUARD_SPAWN_EGG = ITEMS.register("eltarian_guard_spawn_egg",
            () -> new DeferredSpawnEggItem(ELTARIAN_GUARD, 0x9b9aca, 0xb46383, new Item.Properties()));

    //Projectiles
    /*public static final DeferredHolder<EntityType<?>, EntityType<ExplosiveProjectileEntity>> EXPLOSIVE_PROJECTILE =
            MOBLIST.register("explosive_projectile",() -> EntityType.Builder.<ExplosiveProjectileEntity>of(ExplosiveProjectileEntity::new, MobCategory.MISC)
                    .sized(1F, 1F).clientTrackingRange(8).build(PowerRangersCraftCore.MODID + ":explosive_projectile"));
*/
    public static final DeferredHolder<EntityType<?>, EntityType<WeaponProjectileEntity>> WEAPON_PROJECTILE =
            MOBLIST.register("weapon_projectile",() -> EntityType.Builder.<WeaponProjectileEntity>of(WeaponProjectileEntity::new, MobCategory.MISC)
                    .sized(1F, 1F).clientTrackingRange(8).build(PowerRangersCraftCore.MODID + ":weapon_projectile"));

    public static final DeferredHolder<EntityType<?>, EntityType<ShurikenProjectileEntity>> SHURIKEN_PROJECTILE =
            MOBLIST.register("shuriken_projectile",() -> EntityType.Builder.<ShurikenProjectileEntity>of(ShurikenProjectileEntity::new, MobCategory.MISC)
                    .sized(1F, 1F).clientTrackingRange(8).build(PowerRangersCraftCore.MODID + ":shuriken_projectile"));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
