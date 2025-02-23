package com.docrider.powerrangerscraft;

import com.docrider.powerrangerscraft.client.renderer.BasicEntityRenderer;
//import com.docrider.powerrangerscraft.client.renderer.ThrownShurikenRenderer;
//import com.docrider.powerrangerscraft.client.renderer.ThrownWeaponRenderer;
import com.docrider.powerrangerscraft.events.ModClientEvents;
import com.docrider.powerrangerscraft.blocks.RangerBlocks;
import com.docrider.powerrangerscraft.effect.EffectCore;
import com.docrider.powerrangerscraft.entity.MobsCore;
import com.docrider.powerrangerscraft.events.ModCommonEvents;
import com.docrider.powerrangerscraft.items.*;
//import com.docrider.powerrangerscraft.items.gingaman.GingaBraceItem;
//import com.docrider.powerrangerscraft.items.lupatranger.VSChangerItem;
//import com.docrider.powerrangerscraft.items.others.*;
//import com.docrider.powerrangerscraft.items.ryusoulger.MosaChangerItem;
//import com.docrider.powerrangerscraft.items.ryusoulger.RyusoulChangerItem;
import com.docrider.powerrangerscraft.items.others.BaseBlasterItem;
import com.docrider.powerrangerscraft.loot.ModLootModifiers;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

@Mod(PowerRangersCraftCore.MODID)
public class PowerRangersCraftCore {

    public static final String MODID="powerrangerscraft";
    private static final Logger LOGGER = LogUtils.getLogger();

    private static final ResourceLocation BLOCKING_PROPERTY_RESLOC = ResourceLocation.parse("blocking");

    public static List<Item> SWORD_GUN_ITEM= new ArrayList<Item>();

    public static List<Item> SHIELD_ITEM= new ArrayList<Item>();

    public static List<Item> MULTI_WEAPON_ITEM= new ArrayList<Item>();

    public static List<Item> CHARGED_WEAPON= new ArrayList<Item>();

    public static List<Item> FORM_WEAPON_ITEM= new ArrayList<Item>();

    public static List<Item> CHANGE_CHANGER_TEXTURE= new ArrayList<Item>();

    public PowerRangersCraftCore(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        //NeoForge.EVENT_BUS.register(new ModCommonEvents.CommonEvents());
        NeoForge.EVENT_BUS.register(new ModCommonEvents.EventHandler());

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);
        EffectCore.register(modEventBus);

        OtherItems.register(modEventBus);

        MMPRItems.register(modEventBus);
        //AlienItems.register(modEventBus);
        //ZeoItems.register(modEventBus);
        TurboItems.register(modEventBus);
        //InSpaceItems.register(modEventBus);
        //LostGalaxyItems.register(modEventBus);
        //LightspeedRescueItems.register(modEventBus);
        //TimeForceItems.register(modEventBus);
        //WildForceItems.register(modEventBus);
        //NinjaStormItems.register(modEventBus);
        //DinoThunderItems.register(modEventBus);
        //SPDItems.register(modEventBus);
        //MysticForceItems.register(modEventBus);
        //OperationOverdriveItems.register(modEventBus);
        //JungleFuryItems.register(modEventBus);
        //RPMItems.register(modEventBus);
        //SamuraiItems.register(modEventBus);
        //MegaforceItems.register(modEventBus);
        //SuperMegaforceItems.register(modEventBus);
        //DinoChargeItems.register(modEventBus);
        //NinjaSteelItems.register(modEventBus);
        //BeastMorphersItems.register(modEventBus);
        //DinoFuryItems.register(modEventBus);
        //CosmicFuryItems.register(modEventBus);
        //HyperforceItems.register(modEventBus);
        //ComicsItems.register(modEventBus);

        RangerBlocks.register(modEventBus);

        MobsCore.register(modEventBus);
        MobsCore.MOBLIST.register(modEventBus);
        //MobsItems.register(modEventBus);
        RangerTabs.register(modEventBus);
        ModLootModifiers.register(modEventBus);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
        modEventBus.addListener(ModCommonEvents::entityAttributeEvent);
        modEventBus.addListener(ModCommonEvents::entitySpawnRestriction);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        RangerTabs.AddItemsToTabs(event);
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            NeoForge.EVENT_BUS.register(new ModClientEvents.ClientEvents());

            for (int i = 0; i < SWORD_GUN_ITEM.size(); i++) {
                ItemProperties.register(SWORD_GUN_ITEM.get(i), ResourceLocation.parse("change"), ($itemStack, $level, $entity, $seed) -> {
                    if ($entity == null) {
                        return 0.0F;
                    } else {
                        return $entity.getUseItem() != $itemStack ? 0.0F : (float)($itemStack.getUseDuration($entity) - $entity.getUseItemRemainingTicks()) / 1.0F;
                    }

                });
            }

            for (int i = 0; i < SHIELD_ITEM.size(); i++) {
                ItemProperties.register(SHIELD_ITEM.get(i), BLOCKING_PROPERTY_RESLOC, ($itemStack, $level, $entity, $seed) -> {
                    return $entity != null && $entity.isUsingItem() && $entity.getUseItem() == $itemStack ? 1.0F : 0.0F;
                });
            }

            /*for (int i = 0; i < MULTI_WEAPON_ITEM.size(); i++) {
                ItemProperties.register(MULTI_WEAPON_ITEM.get(i), ResourceLocation.parse("change"), ($itemStack, $level, $entity, $seed) -> {
                    return BaseDualSwordItem.get_mode($itemStack);
                });
            }*/

            for (int i = 0; i < CHARGED_WEAPON.size(); i++) {
                ItemProperties.register(CHARGED_WEAPON.get(i), ResourceLocation.parse("change"), ($itemStack, $level, $entity, $seed) -> {
                    if (BaseBlasterItem.get_mode($itemStack) == 30) return 1;
                    return 0;
                });
            }
/*
            for (int i = 0; i < FORM_WEAPON_ITEM.size(); i++) {
                ItemProperties.register(FORM_WEAPON_ITEM.get(i), ResourceLocation.parse("change"), ($itemStack, $level, $entity, $seed) -> {
                    if ($entity == null) {
                        return 0.0F;
                    }
                    else if ($entity.getItemBySlot(EquipmentSlot.FEET)!= null) {
                        ItemStack belt = $entity.getItemBySlot(EquipmentSlot.FEET);
                        if ($entity.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof GingaBraceItem) {
                            if ($itemStack.getItem() == GingamanItems.JUUGEKIBOU_RED.get()||$itemStack.getItem() == GingamanItems.JUUGEKIBOU_GREEN.get()||$itemStack.getItem() == GingamanItems.JUUGEKIBOU_BLUE.get()||$itemStack.getItem() == GingamanItems.JUUGEKIBOU_YELLOW.get()||$itemStack.getItem() == GingamanItems.JUUGEKIBOU_PINK.get()) {
                                if (GingaBraceItem.get_Form_Item(belt, 2).getBeltTex()=="beast_armor_shine_belt") return $entity.getUseItem() != $itemStack ? 2.0F : 3.0F;
                                else return $entity.getUseItem() != $itemStack ? 0.0F : 1.0F;
                            }
                            if ($itemStack.getItem() == GingamanItems.SEIJUUKEN.get()) {
                                if (GingaBraceItem.get_Form_Item(belt, 2).getBeltTex()=="beast_armor_shine_belt") return 1;
                                else return 0;
                            }
                        }
                        if ($entity.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof VSChangerItem) {
                            if ($itemStack.getItem() == LuPatRangerItems.VS_CHANGER.get()) {
                                if (VSChangerItem.get_Form_Item(belt,2).getFormName(false)=="_tricolor") return 7;
                                else if (VSChangerItem.get_Form_Item(belt,2).getFormName(false)=="_ugou") return 8;
                                else if (VSChangerItem.get_Form_Item(belt,2).getFormName(false)=="lupat_scissor") return 9;
                                else if (VSChangerItem.get_Form_Item(belt,2).getFormName(false)=="lupat_crane") return 10;
                                else if (VSChangerItem.get_Form_Item(belt,2).getFormName(false)=="lupat_magic") return 11;
                                else if (VSChangerItem.get_Form_Item(belt,2).getFormName(false)=="lupat_splash") return 12;
                                else if (VSChangerItem.get_Form_Item(belt,2).getFormName(false)=="_super") return 13;
                                else if (VSChangerItem.get_Form_Item(belt,2).getFormName(false)=="lupat_siren") return 14;
                                else if (VSChangerItem.get_Form_Item(belt,2).getFormName(false)=="lupat_gold") return 15;
                                else if (VSChangerItem.get_Form_Item(belt,2).getFormName(false)=="") {
                                    if ($entity.getItemBySlot(EquipmentSlot.FEET).getItem()==LuPatRangerItems.RED_VS_CHANGER.get()) return 1;
                                    else if ($entity.getItemBySlot(EquipmentSlot.FEET).getItem()==LuPatRangerItems.BLUE_VS_CHANGER.get()) return 2;
                                    else if ($entity.getItemBySlot(EquipmentSlot.FEET).getItem()==LuPatRangerItems.YELLOW_VS_CHANGER.get()) return 3;
                                    else if ($entity.getItemBySlot(EquipmentSlot.FEET).getItem()==LuPatRangerItems.ICHIGOU_VS_CHANGER.get()) return 4;
                                    else if ($entity.getItemBySlot(EquipmentSlot.FEET).getItem()==LuPatRangerItems.NIGOU_VS_CHANGER.get()) return 5;
                                    else if ($entity.getItemBySlot(EquipmentSlot.FEET).getItem()==LuPatRangerItems.SANGOU_VS_CHANGER.get()) return 6;
                                }
                                else return 0;
                            }
                        }
                        if ($entity.getItemBySlot(EquipmentSlot.FEET).getItem()==LuPatRangerItems.LUPAT_X_CHANGER.get()) {
                            if ($itemStack.getItem() == LuPatRangerItems.X_CHANGER.get()){
                                if (RangerChangerItem.get_Form_Item(belt, 1).getBeltTex()=="lupinranger_belt") return 1;
                                else return 0;
                            }
                        }
                        if ($entity.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RyusoulChangerItem) {
                            if ($itemStack.getItem() == RyusoulgerItems.MAX_RYUSOUL_CHANGER.get()) {
                                if (RyusoulChangerItem.get_Form_Item(belt, 2).getFormName(false)=="_max") return 1;
                                else return 0;
                            }
                        }
                        if ($entity.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof MosaChangerItem) {

                            if ($itemStack.getItem() == RyusoulgerItems.MOSA_CHANGER.get()) {
                                if ($entity.getItemBySlot(EquipmentSlot.FEET).getItem()==RyusoulgerItems.GOLD_MOSA_CHANGER.get()){
                                    if (MosaChangerItem.get_Form_Item(belt, 2).getFormName(false)!="") return 2;
                                    else return 1;
                                }
                                else return 0;
                            }
                        }
                        else {
                            return $entity.getUseItem() != $itemStack ? 0.0F : 1.0F;
                        }
                        return $entity.getUseItem() != $itemStack ? 0.0F : 1.0F;
                    }
                    return $entity.getUseItem() != $itemStack ? 0.0F : 1.0F;
                    //return p_174637_.getUseItem() != p_174635_ ? 0.0F : (float)(p_174635_.getUseDuration() - p_174637_.getUseItemRemainingTicks()) / 1.0F;
                });
            }

            for (int i = 0; i < CHANGE_CHANGER_TEXTURE.size(); i++) {
                ItemProperties.register(CHANGE_CHANGER_TEXTURE.get(i), ResourceLocation.parse("change"), ($itemStack, $level, $entity, $seed) -> {
                    if ($entity == null) {
                        return 0.0F;
                    } else {
                        if ($itemStack.getItem() == LuPatRangerItems.LUPAT_X_CHANGER.get()) {
                            if (RangerChangerItem.get_Form_Item($itemStack, 1).getBeltTex() == "lupinranger_belt") return 1;
                            else return 0;
                        }
                    }
                    return $entity.getUseItem() != $itemStack ? 0.0F : 1.0F;
                    //return p_174637_.getUseItem() != p_174635_ ? 0.0F : (float)(p_174635_.getUseDuration() - p_174637_.getUseItemRemainingTicks()) / 1.0F;
                });
            }*/
        }

        @SubscribeEvent
        public static void entityRenderers(EntityRenderersEvent.RegisterRenderers event) {
            event.registerEntityRenderer(MobsCore.PUTTY_PATROLLERS.get(), BasicEntityRenderer::new);

            //event.registerEntityRenderer(MobsCore.CRIMERS.get(), BasicEntityRenderer::new);

            //event.registerEntityRenderer(MobsCore.MACHINEMEN.get(), BasicEntityRenderer::new);

            //event.registerEntityRenderer(MobsCore.UNGLERS.get(), BasicEntityRenderer::new);

            //event.registerEntityRenderer(MobsCore.WUMPERS.get(), BasicEntityRenderer::new);
            //event.registerEntityRenderer(MobsCore.SIGNALMAN_EVIL.get(), BasicEntityRenderer::new);

            //event.registerEntityRenderer(MobsCore.YARTOTS.get(), BasicEntityRenderer::new);
            //event.registerEntityRenderer(MobsCore.BLACK_KNIGHT.get(), BasicEntityRenderer::new);

            //event.registerEntityRenderer(MobsCore.ORGETTES.get(), BasicEntityRenderer::new);
            //event.registerEntityRenderer(MobsCore.DUKE_ORG_ROUKI.get(), BasicEntityRenderer::new);

            //event.registerEntityRenderer(MobsCore.NANASHIS.get(), BasicEntityRenderer::new);
            //event.registerEntityRenderer(MobsCore.GEDOU_SHINKEN_RED.get(), BasicEntityRenderer::new);

            //event.registerEntityRenderer(MobsCore.PORDERMEN.get(), BasicEntityRenderer::new);

            //event.registerEntityRenderer(MobsCore.DRUNNS.get(), BasicEntityRenderer::new);
            //event.registerEntityRenderer(MobsCore.GAISOULG.get(), BasicEntityRenderer::new);
            //event.registerEntityRenderer(MobsCore.RYUSOUL_MORIA.get(), BasicEntityRenderer::new);

            //event.registerEntityRenderer(MobsCore.EXPLOSIVE_PROJECTILE.get(), ThrownItemRenderer::new);
            //event.registerEntityRenderer(MobsCore.WEAPON_PROJECTILE.get(), ThrownWeaponRenderer::new);
            //event.registerEntityRenderer(MobsCore.SHURIKEN_PROJECTILE.get(), ThrownShurikenRenderer::new);
        }
    }
}