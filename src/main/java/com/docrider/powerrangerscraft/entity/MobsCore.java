package com.docrider.powerrangerscraft.entity;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.entity.boss.*;
import com.docrider.powerrangerscraft.entity.footsoldier.*;
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

    //01 MMPR
    public static final DeferredHolder<EntityType<?>, EntityType<PuttyPatrollersEntity>> PUTTY_PATROLLERS = MOBLIST.register("putty_patroller",
            () -> EntityType.Builder.of(PuttyPatrollersEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(PowerRangersCraftCore.MODID + ":putty_patroller"));

    public static final DeferredItem<DeferredSpawnEggItem> PUTTY_PATROLLERS_SPAWN_EGG = ITEMS.register("putty_patroller_spawn_egg",
            () -> new DeferredSpawnEggItem(PUTTY_PATROLLERS, 0x121212, 0xa1a1a1, new Item.Properties()));

    //02 Alien

    //03 Zeo

    //04 Turbo
    public static final DeferredHolder<EntityType<?>, EntityType<ChromitesEntity>> CHROMITES = MOBLIST.register("chromite",
            () -> EntityType.Builder.of(ChromitesEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(PowerRangersCraftCore.MODID + ":chromite"));

    public static final DeferredItem<DeferredSpawnEggItem> CHROMITES_SPAWN_EGG = ITEMS.register("chromite_spawn_egg",
            () -> new DeferredSpawnEggItem(CHROMITES, 0x03a9f4, 0xbd66a6, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<BlueSenturionEvilEntity>> BLUE_SENTURION_EVIL = MOBLIST.register("blue_senturion_evil",
            () -> EntityType.Builder.of(BlueSenturionEvilEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(PowerRangersCraftCore.MODID + ":blue_senturion_evil"));

    public static final DeferredItem<DeferredSpawnEggItem> BLUE_SENTURION_EVIL_SPAWN_EGG = ITEMS.register("blue_senturion_evil_spawn_egg",
            () -> new DeferredSpawnEggItem(BLUE_SENTURION_EVIL, 0x1323af, 0xffffff, new Item.Properties()));
/*
    //22 Gingaman
    public static final DeferredHolder<EntityType<?>, EntityType<YartotsEntity>> YARTOTS = MOBLIST.register("yartots",
            () -> EntityType.Builder.of(YartotsEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(PowerRangersCraftCore.MODID + ":yartots"));

    public static final DeferredItem<DeferredSpawnEggItem> YARTOTS_SPAWN_EGG = ITEMS.register("yartots_spawn_egg",
            () -> new DeferredSpawnEggItem(YARTOTS, 0xde7002, 0x2e1100, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<BlackKnightEntity>> BLACK_KNIGHT = MOBLIST.register("black_knight",
            () -> EntityType.Builder.of(BlackKnightEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(PowerRangersCraftCore.MODID + ":black_knight"));

    public static final DeferredItem<DeferredSpawnEggItem> BLACK_KNIGHT_SPAWN_EGG = ITEMS.register("black_knight_spawn_egg",
            () -> new DeferredSpawnEggItem(BLACK_KNIGHT, 0x0b0b0b, 0xff9900, new Item.Properties()));

    //25 Gaoranger
    public static final DeferredHolder<EntityType<?>, EntityType<OrgettesEntity>> ORGETTES = MOBLIST.register("orgettes",
            () -> EntityType.Builder.of(OrgettesEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(PowerRangersCraftCore.MODID + ":orgettes"));

    public static final DeferredItem<DeferredSpawnEggItem> ORGETTES_SPAWN_EGG = ITEMS.register("orgettes_spawn_egg",
            () -> new DeferredSpawnEggItem(ORGETTES, 0x334a33, 0x8a1e34, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<DukeOrgRoukiEntity>> DUKE_ORG_ROUKI = MOBLIST.register("duke_org_rouki",
            () -> EntityType.Builder.of(DukeOrgRoukiEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(PowerRangersCraftCore.MODID + ":duke_org_rouki"));

    public static final DeferredItem<DeferredSpawnEggItem> DUKE_ORG_ROUKI_SPAWN_EGG = ITEMS.register("duke_org_rouki_spawn_egg",
            () -> new DeferredSpawnEggItem(DUKE_ORG_ROUKI, 0x0b0b0b, 0x7d7d7d, new Item.Properties()));

    //33 Shinkenger
    public static final DeferredHolder<EntityType<?>, EntityType<NanashisEntity>> NANASHIS = MOBLIST.register("nanashi",
            () -> EntityType.Builder.of(NanashisEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(PowerRangersCraftCore.MODID + ":nanashi"));

    public static final DeferredItem<DeferredSpawnEggItem> NANASHIS_SPAWN_EGG = ITEMS.register("nanashi_spawn_egg",
            () -> new DeferredSpawnEggItem(NANASHIS, 0xd6ba00, 0xa61a0b, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<GedouShinkenRedEntity>> GEDOU_SHINKEN_RED = MOBLIST.register("gedou_shinken_red",
            () -> EntityType.Builder.of(GedouShinkenRedEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(PowerRangersCraftCore.MODID + ":gedou_shinken_red"));

    public static final DeferredItem<DeferredSpawnEggItem> GEDOU_SHINKEN_RED_SPAWN_EGG = ITEMS.register("gedou_shinken_red_spawn_egg",
            () -> new DeferredSpawnEggItem(GEDOU_SHINKEN_RED, 0x0f0f0f, 0xf00000, new Item.Properties()));

    //42 LuPat
    public static final DeferredHolder<EntityType<?>, EntityType<PordermenEntity>> PORDERMEN = MOBLIST.register("porderman",
            () -> EntityType.Builder.of(PordermenEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(PowerRangersCraftCore.MODID + ":porderman"));

    public static final DeferredItem<DeferredSpawnEggItem> PORDERMEN_SPAWN_EGG = ITEMS.register("porderman_spawn_egg",
            () -> new DeferredSpawnEggItem(PORDERMEN, 0x369e86, 0xe8e8e7, new Item.Properties()));


    //43 Ryusoulger
    public static final DeferredHolder<EntityType<?>, EntityType<DrunnsEntity>> DRUNNS = MOBLIST.register("drunn",
            () -> EntityType.Builder.of(DrunnsEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(PowerRangersCraftCore.MODID + ":drunn"));

    public static final DeferredItem<DeferredSpawnEggItem> DRUNNS_SPAWN_EGG = ITEMS.register("drunn_spawn_egg",
            () -> new DeferredSpawnEggItem(DRUNNS, 0xbfbcb9, 0xc1a800, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<GaisoulgEntity>> GAISOULG = MOBLIST.register("gaisoulg",
            () -> EntityType.Builder.of(GaisoulgEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(PowerRangersCraftCore.MODID + ":gaisoulg"));

    public static final DeferredItem<DeferredSpawnEggItem> GAISOULG_SPAWN_EGG = ITEMS.register("gaisoulg_spawn_egg",
            () -> new DeferredSpawnEggItem(GAISOULG, 0x56007f, 0x9c9c9c, new Item.Properties()));

    public static final DeferredHolder<EntityType<?>, EntityType<RyusoulMoriaEntity>> RYUSOUL_MORIA = MOBLIST.register("ryusoul_moria",
            () -> EntityType.Builder.of(RyusoulMoriaEntity::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build(PowerRangersCraftCore.MODID + ":ryusoul_moria"));

    public static final DeferredItem<DeferredSpawnEggItem> RYUSOUL_MORIA_SPAWN_EGG = ITEMS.register("ryusoul_moria_spawn_egg",
            () -> new DeferredSpawnEggItem(RYUSOUL_MORIA, 0x795548, 0x416e26, new Item.Properties()));


    public static final DeferredHolder<EntityType<?>, EntityType<ExplosiveProjectileEntity>> EXPLOSIVE_PROJECTILE =
            MOBLIST.register("explosive_projectile",() -> EntityType.Builder.<ExplosiveProjectileEntity>of(ExplosiveProjectileEntity::new, MobCategory.MISC)
                    .sized(1F, 1F).clientTrackingRange(8).build(PowerRangersCraftCore.MODID + ":explosive_projectile"));

    public static final DeferredHolder<EntityType<?>, EntityType<WeaponProjectileEntity>> WEAPON_PROJECTILE =
            MOBLIST.register("weapon_projectile",() -> EntityType.Builder.<WeaponProjectileEntity>of(WeaponProjectileEntity::new, MobCategory.MISC)
                    .sized(1F, 1F).clientTrackingRange(8).build(PowerRangersCraftCore.MODID + ":weapon_projectile"));

    public static final DeferredHolder<EntityType<?>, EntityType<ShurikenProjectileEntity>> SHURIKEN_PROJECTILE =
            MOBLIST.register("shuriken_projectile",() -> EntityType.Builder.<ShurikenProjectileEntity>of(ShurikenProjectileEntity::new, MobCategory.MISC)
                    .sized(1F, 1F).clientTrackingRange(8).build(PowerRangersCraftCore.MODID + ":shuriken_projectile"));
*/
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
