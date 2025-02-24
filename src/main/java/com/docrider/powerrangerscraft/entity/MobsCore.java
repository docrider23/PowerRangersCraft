package com.docrider.powerrangerscraft.entity;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
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
            () -> new DeferredSpawnEggItem(PUTTY_PATROLLERS, 0x121212, 0xa1a1a1, new Item.Properties()));

    //03 Alien

    //04 Zeo

    //05 Turbo
    public static final DeferredHolder<EntityType<?>, EntityType<ChromitesEntity>> CHROMITES = MOBLIST.register("chromite",
            () -> EntityType.Builder.of(ChromitesEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(PowerRangersCraftCore.MODID + ":chromite"));

    public static final DeferredItem<DeferredSpawnEggItem> CHROMITES_SPAWN_EGG = ITEMS.register("chromite_spawn_egg",
            () -> new DeferredSpawnEggItem(CHROMITES, 0x03a9f4, 0xbd66a6, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<BlueSenturionEvilEntity>> BLUE_SENTURION_EVIL = MOBLIST.register("blue_senturion_evil",
            () -> EntityType.Builder.of(BlueSenturionEvilEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(PowerRangersCraftCore.MODID + ":blue_senturion_evil"));

    public static final DeferredItem<DeferredSpawnEggItem> BLUE_SENTURION_EVIL_SPAWN_EGG = ITEMS.register("blue_senturion_evil_spawn_egg",
            () -> new DeferredSpawnEggItem(BLUE_SENTURION_EVIL, 0x1323af, 0xffffff, new Item.Properties()));
    
    //06 In Space

    //07 Gingaman
    public static final DeferredHolder<EntityType<?>, EntityType<SwabbiesEntity>> SWABBIES = MOBLIST.register("swabbies",
            () -> EntityType.Builder.of(SwabbiesEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(PowerRangersCraftCore.MODID + ":swabbies"));

    public static final DeferredItem<DeferredSpawnEggItem> SWABBIES_SPAWN_EGG = ITEMS.register("swabbies_spawn_egg",
            () -> new DeferredSpawnEggItem(SWABBIES, 0xde7002, 0x2e1100, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<MagnaDefenderEntity>> MAGNA_DEFENDER = MOBLIST.register("magna_defender",
            () -> EntityType.Builder.of(MagnaDefenderEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(PowerRangersCraftCore.MODID + ":magna_defender"));

    public static final DeferredItem<DeferredSpawnEggItem> MAGNA_DEFENDER_SPAWN_EGG = ITEMS.register("magna_defender_spawn_egg",
            () -> new DeferredSpawnEggItem(MAGNA_DEFENDER, 0x0b0b0b, 0xff9900, new Item.Properties()));
    
    //08 Lightspeed Rescue
    
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
    
    //11 Ninja Storm
    
    //12 Dino Thunder
    
    //13 SPD
    
    //14 Mystic Force
    
    //15 Operation Overdrive
    
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
    
    //EX Hyperforce

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
