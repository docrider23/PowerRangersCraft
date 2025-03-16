package com.docrider.powerrangerscraft.events;

import com.docrider.powerrangerscraft.effect.EffectCore;
import com.docrider.powerrangerscraft.entity.boss.*;
import com.docrider.powerrangerscraft.entity.footsoldier.*;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import com.docrider.powerrangerscraft.entity.MobsCore;

import java.util.Objects;

public class ModCommonEvents {public static class EventHandler {

    @SubscribeEvent
    public void addLivingDamageEvent(LivingDamageEvent.Post event) {

        if (event.getSource().getEntity() instanceof LivingEntity _livEnt) {
            if (event.getSource().is(DamageTypes.PLAYER_ATTACK) || event.getSource().is(DamageTypes.MOB_ATTACK) || event.getSource().is(DamageTypes.MOB_ATTACK_NO_AGGRO)) {

                if (_livEnt.hasEffect(EffectCore.FIREPUNCH)) {
                    if (_livEnt.getMainHandItem().isEmpty()) {
                        event.getEntity().igniteForSeconds(_livEnt.getEffect(EffectCore.FIREPUNCH).getAmplifier()+1);
                    }
                }

                if (_livEnt.hasEffect(EffectCore.THUNDERPUNCH)) {
                    if (_livEnt.getMainHandItem().isEmpty()) {
                        LightningBolt thunder = new LightningBolt(EntityType.LIGHTNING_BOLT,_livEnt.level());
                        thunder.setPos(   event.getEntity().getX(),   event.getEntity().getY(),   event.getEntity().getZ());
                        event.getEntity().level().addFreshEntity(thunder);
                    }

                }

                if (_livEnt.hasEffect(EffectCore.EXPLOSIONPUNCH)) {
                    if (_livEnt.getMainHandItem().isEmpty()) {
                        boolean flag = event.getEntity().level().getLevelData().getGameRules().getRule(GameRules.RULE_MOBGRIEFING).get();
                        event.getEntity().level().explode(null, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), _livEnt.getEffect(EffectCore.EXPLOSIONPUNCH).getAmplifier(), flag, Level.ExplosionInteraction.MOB);
                    }
                }

                if (event.getEntity().hasEffect(EffectCore.REFLECT)) {
                    event.getSource().getEntity().hurt(event.getSource(), (event.getOriginalDamage()) * (1 + event.getEntity().getEffect(EffectCore.REFLECT).getAmplifier() + 1));
                }

                if (_livEnt.hasEffect(EffectCore.FIRESLASH)) {
                    if (_livEnt.getMainHandItem().getItem() instanceof SwordItem) {
                        event.getEntity().igniteForSeconds(_livEnt.getEffect(EffectCore.FIRESLASH).getAmplifier()+1);
                    }
                }

            } else if (event.getSource().is(DamageTypes.ARROW) || event.getSource().is(DamageTypes.MOB_PROJECTILE)) {
                if (_livEnt.hasEffect(EffectCore.FIRESLASH)) {
                    event.getEntity().setRemainingFireTicks(25*(Objects.requireNonNull(_livEnt.getEffect(EffectCore.FIRESLASH)).getAmplifier() + 1));
                }

                if (_livEnt.hasEffect(EffectCore.EXPLOSIONSHOT)) {
                    boolean flag = event.getEntity().level().getLevelData().getGameRules().getRule(GameRules.RULE_MOBGRIEFING).get();
                    event.getEntity().level().explode(null, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), _livEnt.getEffect(EffectCore.EXPLOSIONSHOT).getAmplifier(), flag, Level.ExplosionInteraction.MOB);
                }

                if (_livEnt.hasEffect(EffectCore.THUNDERSHOT)) {

                    LightningBolt thunder = new LightningBolt(EntityType.LIGHTNING_BOLT,_livEnt.level());
                    thunder.setPos(   event.getEntity().getX(),   event.getEntity().getY(),   event.getEntity().getZ());
                    event.getEntity().level().addFreshEntity(thunder);
                }
            }
        }
    }
}

    /*public static class CommonEvents {

        @SubscribeEvent
        public void addCustomTrades(VillagerTradesEvent event) {
            if (event.getType() == VillagerProfession.LIBRARIAN) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(OtherItems.SUPER_SENTAI_BOOK.get(), 1);
                int villagerLevel = 1;

                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemCost(Items.EMERALD, 2),
                        stack, 10, 8, 0.02F));
            }
        }
    }*/

    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        //event.put(MobsCore.PUTTY_PATROLLERS.get(), PuttyPatrollersEntity.setAttributes().build());

        event.put(MobsCore.CHROMITES.get(), ChromitesEntity.setAttributes().build());
        event.put(MobsCore.PIRANHATRONS.get(), PiranhatronsEntity.setAttributes().build());
        event.put(MobsCore.BLUE_SENTURION_EVIL.get(), BlueSenturionEvilEntity.setAttributes().build());

        event.put(MobsCore.SWABBIES.get(), SwabbiesEntity.setAttributes().build());
        event.put(MobsCore.STINGWINGERS.get(), StingwingersEntity.setAttributes().build());
        event.put(MobsCore.MAGNA_DEFENDER.get(), MagnaDefenderEntity.setAttributes().build());

        event.put(MobsCore.PUTRIDS.get(), PutridsEntity.setAttributes().build());
        event.put(MobsCore.ZEN_AKU.get(), ZenAkuEntity.setAttributes().build());

        event.put(MobsCore.MOOGERS.get(), MoogersEntity.setAttributes().build());

        event.put(MobsCore.HENGEMEN.get(), HengemenEntity.setAttributes().build());
        event.put(MobsCore.VOID_KNIGHT.get(), VoidKnightEntity.setAttributes().build());

        event.put(MobsCore.ZENTINELS.get(), ZentinelEntity.setAttributes().build());
        event.put(MobsCore.EVIL_BLUE_DINO_FURY_RANGER.get(), EvilBlueDinoFuryEntity.setAttributes().build());

        event.put(MobsCore.SILVER_SENTRIES.get(), SilverSentryEntity.setAttributes().build());
    }

    @SubscribeEvent
    public static void entitySpawnRestriction(RegisterSpawnPlacementsEvent event) {
        //event.register(MobsCore.PUTTY_PATROLLERS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.CHROMITES.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.PIRANHATRONS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.SWABBIES.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.STINGWINGERS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.PUTRIDS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.MOOGERS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.HENGEMEN.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.ZENTINELS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.SILVER_SENTRIES.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
    }
}