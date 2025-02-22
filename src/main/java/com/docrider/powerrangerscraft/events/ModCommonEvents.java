package com.docrider.powerrangerscraft.events;

import com.docrider.powerrangerscraft.effect.EffectCore;
import com.docrider.powerrangerscraft.entity.footsoldier.PuttyPatrollersEntity;
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
        event.put(MobsCore.PUTTY_PATROLLERS.get(), PuttyPatrollersEntity.setAttributes().build());

        /*event.put(MobsCore.CRIMERS.get(), CrimersEntity.setAttributes().build());

        event.put(MobsCore.MACHINEMEN.get(), MachinemenEntity.setAttributes().build());

        event.put(MobsCore.UNGLERS.get(), UnglersEntity.setAttributes().build());

        event.put(MobsCore.WUMPERS.get(), WumpersEntity.setAttributes().build());
        event.put(MobsCore.SIGNALMAN_EVIL.get(), SignalmanEvilEntity.setAttributes().build());

        event.put(MobsCore.YARTOTS.get(), YartotsEntity.setAttributes().build());
        event.put(MobsCore.BLACK_KNIGHT.get(), BlackKnightEntity.setAttributes().build());

        event.put(MobsCore.ORGETTES.get(), OrgettesEntity.setAttributes().build());
        event.put(MobsCore.DUKE_ORG_ROUKI.get(), DukeOrgRoukiEntity.setAttributes().build());

        event.put(MobsCore.NANASHIS.get(), NanashisEntity.setAttributes().build());
        event.put(MobsCore.GEDOU_SHINKEN_RED.get(), GedouShinkenRedEntity.setAttributes().build());

        event.put(MobsCore.PORDERMEN.get(), PordermenEntity.setAttributes().build());

        event.put(MobsCore.DRUNNS.get(), DrunnsEntity.setAttributes().build());
        event.put(MobsCore.GAISOULG.get(), GaisoulgEntity.setAttributes().build());
        event.put(MobsCore.RYUSOUL_MORIA.get(), RyusoulMoriaEntity.setAttributes().build());*/
    }

    @SubscribeEvent
    public static void entitySpawnRestriction(RegisterSpawnPlacementsEvent event) {
        event.register(MobsCore.PUTTY_PATROLLERS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
/*
        event.register(MobsCore.CRIMERS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.MACHINEMEN.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.UNGLERS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.WUMPERS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.YARTOTS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.ORGETTES.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.NANASHIS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.PORDERMEN.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.DRUNNS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

 */
    }
}