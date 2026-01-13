package com.docrider.powerrangerscraft.events;

import com.docrider.powerrangerscraft.client.KeyBindings;
import com.docrider.powerrangerscraft.effect.EffectCore;
import com.docrider.powerrangerscraft.entity.ally.*;
import com.docrider.powerrangerscraft.entity.bikes.DinoCycleEntity;
import com.docrider.powerrangerscraft.entity.boss.*;
import com.docrider.powerrangerscraft.entity.footsoldier.*;
import com.docrider.powerrangerscraft.items.GamesItems;
import com.docrider.powerrangerscraft.items.OperationOverdriveItems;
import com.docrider.powerrangerscraft.items.OtherItems;
import com.docrider.powerrangerscraft.items.others.RangerChangerItem;
import com.docrider.powerrangerscraft.network.payload.AbilityKeyPayload;
import net.minecraft.client.Minecraft;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import com.docrider.powerrangerscraft.entity.MobsCore;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.event.village.WandererTradesEvent;
import net.neoforged.neoforge.network.PacketDistributor;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class ModCommonEvents {
    public static class EventHandler {

        @SubscribeEvent
        public void clientTick(ClientTickEvent.Post event) {
            if (Minecraft.getInstance().player != null) {
                while (KeyBindings.INSTANCE.AbilityKey.consumeClick()) PacketDistributor.sendToServer(new AbilityKeyPayload(0));
            }
        }

        @SubscribeEvent
        public void onEntityTick(EntityTickEvent.Post event) {
            if (event.getEntity()instanceof LivingEntity entity){
                if (entity.getItemBySlot(EquipmentSlot.FEET).getItem()instanceof RangerChangerItem belt){
                    belt.beltTick(entity.getItemBySlot(EquipmentSlot.FEET),entity.level(),entity,36);
                    belt.giveEffects(entity);
                }
            }
        }

        @SubscribeEvent
    public void onPlayerTick(PlayerTickEvent.Post event) {
        LocalDate localdate = LocalDate.now();
        int day = localdate.getDayOfMonth();
        if (localdate.getMonthValue() == 12 && day >= 22 && day <= 28) {
            event.getEntity().addEffect(new MobEffectInstance(EffectCore.CHRISTMAS, 30, 0, false, false));
        }
    }

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

    public static class CommonEvents {

    @SubscribeEvent
    public void addCustomWandererTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> trades = event.getGenericTrades();
        trades.add((trader,rand) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 2),
                new ItemStack(GamesItems.BATTLE_FOR_THE_GRID_GAME.get(), 1), 10, 8, 0.02F));
        trades.add((trader,rand) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 2),
                new ItemStack(GamesItems.GAME_CONTROLLER_16_BIT.get(), 1), 10, 8, 0.02F));
        trades.add((trader,rand) -> new MerchantOffer(
                new ItemCost(Items.EMERALD,5),
                new ItemStack(OperationOverdriveItems.DRAGON_SCALE.get(), 1), 10, 8, 0.02F));
    }

    @SubscribeEvent
        public void addCustomTrades(VillagerTradesEvent event) {

        }
    }

    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(MobsCore.PUTTY_PATROLLERS.get(), PuttyPatrollersEntity.setAttributes().build());
        event.put(MobsCore.GOLDAR.get(), GoldarEntity.setAttributes().build());
        event.put(MobsCore.EVILMMPRGREEN.get(), EvilMMPRGreenEntity.setAttributes().build());

        event.put(MobsCore.COGS.get(), CogEntity.setAttributes().build());

        event.put(MobsCore.CHROMITES.get(), ChromitesEntity.setAttributes().build());
        event.put(MobsCore.PIRANHATRONS.get(), PiranhatronsEntity.setAttributes().build());
        event.put(MobsCore.BLUE_SENTURION_EVIL.get(), BlueSenturionEvilEntity.setAttributes().build());

        event.put(MobsCore.SWABBIES.get(), SwabbiesEntity.setAttributes().build());
        event.put(MobsCore.STINGWINGERS.get(), StingwingersEntity.setAttributes().build());
        event.put(MobsCore.MAGNA_DEFENDER.get(), MagnaDefenderEntity.setAttributes().build());

        event.put(MobsCore.BATLINGS.get(), BatlingsEntity.setAttributes().build());

        event.put(MobsCore.PUTRIDS.get(), PutridsEntity.setAttributes().build());
        event.put(MobsCore.ZEN_AKU.get(), ZenAkuEntity.setAttributes().build());
        event.put(MobsCore.GENERAL_VENJIX.get(), GeneralVenjixEntity.setAttributes().build());

        event.put(MobsCore.CHILLERS.get(), ChillersEntity.setAttributes().build());
        event.put(MobsCore.LAVA_LIZARDS.get(), LavaLizardsEntity.setAttributes().build());
        event.put(MobsCore.MOLTOR.get(), MoltorEntity.setAttributes().build());
        event.put(MobsCore.FLURIOUS.get(), FluriousEntity.setAttributes().build());
        event.put(MobsCore.KAMDOR.get(), KamdorEntity.setAttributes().build());
        event.put(MobsCore.FEARCATS.get(), FearcatsEntity.setAttributes().build());
        event.put(MobsCore.THRAX.get(), ThraxEntity.setAttributes().build());
        event.put(MobsCore.SENTINEL_KNIGHT.get(), SentinelKnightEntity.setAttributes().build());

        event.put(MobsCore.MOOGERS.get(), MoogersEntity.setAttributes().build());

        event.put(MobsCore.DINO_CYCLE.get(), DinoCycleEntity.setAttributes().build());

        event.put(MobsCore.TRONICS.get(), TronicsEntity.setAttributes().build());
        event.put(MobsCore.CYBERVILLAIN_BLAZE.get(), CybervillainBlazeEntity.setAttributes().build());
        event.put(MobsCore.CYBERVILLAIN_ROXY.get(), CybervillainRoxyEntity.setAttributes().build());

        event.put(MobsCore.HENGEMEN.get(), HengemenEntity.setAttributes().build());
        event.put(MobsCore.VOID_KNIGHT.get(), VoidKnightEntity.setAttributes().build());

        event.put(MobsCore.ZENTINELS.get(), ZentinelEntity.setAttributes().build());
        event.put(MobsCore.EVIL_BLUE_DINO_FURY_RANGER.get(), EvilBlueDinoFuryEntity.setAttributes().build());

        event.put(MobsCore.SILVER_SENTRIES.get(), SilverSentryEntity.setAttributes().build());

        event.put(MobsCore.REBOOT_PUTTY.get(), RebootPuttyEntity.setAttributes().build());
        event.put(MobsCore.REBOOT_RITA.get(), RebootRitaEntity.setAttributes().build());

        event.put(MobsCore.HORRID.get(), HorridEntity.setAttributes().build());
        event.put(MobsCore.DEATH_RANGER.get(), DeathRangerEntity.setAttributes().build());

        event.put(MobsCore.ELTARIAN_GUARD.get(), EltarianGuardEntity.setAttributes().build());

    }

    @SubscribeEvent
    public static void entitySpawnRestriction(RegisterSpawnPlacementsEvent event) {
        event.register(MobsCore.PUTTY_PATROLLERS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(MobsCore.GOLDAR.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(MobsCore.EVILMMPRGREEN.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.COGS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.CHROMITES.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(MobsCore.PIRANHATRONS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.SWABBIES.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(MobsCore.STINGWINGERS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.BATLINGS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.PUTRIDS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.CHILLERS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(MobsCore.LAVA_LIZARDS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.MOOGERS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.TRONICS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.HENGEMEN.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.ZENTINELS.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.SILVER_SENTRIES.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.REBOOT_PUTTY.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.HORRID.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);

        event.register(MobsCore.ELTARIAN_GUARD.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
    }
}