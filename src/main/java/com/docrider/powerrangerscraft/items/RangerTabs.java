package com.docrider.powerrangerscraft.items;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.blocks.RangerBlocks;
import com.docrider.powerrangerscraft.entity.MobsCore;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;

public class RangerTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB,
            PowerRangersCraftCore.MODID) ;

    /*public static DeferredItem<CreativeModeTab> RiderblockTab = CREATIVE_MODE_TABS.register("krc_999_blocks_tab", () ->
			CreativeModeTab.builder().icon(() -> new ItemStack(Rider_Blocks.PURE_GAIA_MEMORY_BLOCK.get())).withBackgroundLocation(new ResourceLocation(KamenRiderCraftCore.MODID+"textures/gui/tab_iichigo_items.png"))
			.title(Component.literal("Rider Blocks")).build());*/

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> MMPRTab = CREATIVE_MODE_TABS.register("prc001", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(MMPRItems.MMPR_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID,"textures/gui/tab_mmpr_items.png"))
                    .title(Component.translatable("tab.powerrangerscraft.mmpr")).build());
/*
    public static DeferredHolder<CreativeModeTab, CreativeModeTab> JAKQTab = CREATIVE_MODE_TABS.register("ssc002", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(JAKQItems.JAKQ_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID,"textures/gui/tab_jakq_items.png"))
                    .title(Component.translatable("tab.powerrangerscraft.jakq")).build());

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> SunVulcanTab = CREATIVE_MODE_TABS.register("ssc005", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(SunVulcanItems.SUN_VULCAN_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID,"textures/gui/tab_sun_vulcan_items.png"))
                    .title(Component.translatable("tab.powerrangerscraft.sun_vulcan")).build());
*/
    public static DeferredHolder<CreativeModeTab, CreativeModeTab> TurboTab = CREATIVE_MODE_TABS.register("prc004", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(TurboItems.TURBO_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID,"textures/gui/base_tab_items.png"))
                    .title(Component.translatable("tab.powerrangerscraft.turbo")).build());
/*
    public static DeferredHolder<CreativeModeTab, CreativeModeTab> MaskmanTab = CREATIVE_MODE_TABS.register("ssc011", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(MaskmanItems.MASKMAN_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID,"textures/gui/tab_maskman_items.png"))
                    .title(Component.translatable("tab.powerrangerscraft.maskman")).build());

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> GingamanTab = CREATIVE_MODE_TABS.register("ssc022", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(GingamanItems.GINGAMAN_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID,"textures/gui/tab_gingaman_items.png"))
                    .title(Component.translatable("tab.powerrangerscraft.gingaman")).build());

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> GaorangerTab = CREATIVE_MODE_TABS.register("ssc025", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(GaorangerItems.GAORANGER_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID,"textures/gui/tab_gaoranger_items.png"))
                    .title(Component.translatable("tab.powerrangerscraft.gaoranger")).build());

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> ShinkengerTab = CREATIVE_MODE_TABS.register("ssc033", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ShinkengerItems.SHINKENGER_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID,"textures/gui/tab_shinkenger_items.png"))
                    .title(Component.translatable("tab.powerrangerscraft.shinkenger")).build());

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> LuPatRangerTab = CREATIVE_MODE_TABS.register("ssc042", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(LuPatRangerItems.LUPATRANGER_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID,"textures/gui/tab_lupat_items.png"))
                    .title(Component.translatable("tab.powerrangerscraft.lupat")).build());

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> RyusoulgerTab = CREATIVE_MODE_TABS.register("ssc043", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(RyusoulgerItems.RYUSOULGER_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID,"textures/gui/tab_ryusoulger_items.png"))
                    .title(Component.translatable("tab.powerrangerscraft.ryusoulger")).build());
*/
    public static DeferredHolder<CreativeModeTab, CreativeModeTab> MiscTab = CREATIVE_MODE_TABS.register("ssc900", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(OtherItems.POWER_RANGERS_LOGO.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID,"textures/gui/base_tab_items.png"))
                    .title(Component.translatable("tab.powerrangerscraft.misc")).build());

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> BlockTab = CREATIVE_MODE_TABS.register("ssc901", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(RangerBlocks.RYUSOULGER_ORE.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID,"textures/gui/base_tab_items.png"))
                    .title(Component.translatable("tab.powerrangerscraft.block")).build());

    public static List<Item> MMPR= new ArrayList<Item>();
/*
    public static List<Item> JAKQ= new ArrayList<Item>();

    public static List<Item> SUN_VULCAN= new ArrayList<Item>();
*/
    public static List<Item> TURBO = new ArrayList<Item>();
/*
    public static List<Item> MASKMAN= new ArrayList<Item>();

    public static List<Item> GINGAMAN= new ArrayList<Item>();

    public static List<Item> GAORANGER= new ArrayList<Item>();

    public static List<Item> SHINKENGER= new ArrayList<Item>();

    public static List<Item> LUPATRANGER= new ArrayList<Item>();

    public static List<Item> RYUSOULGER= new ArrayList<Item>();
*/
    public static List<Item> MISC= new ArrayList<Item>();

    public static List<Block> BLOCKS= new ArrayList<Block>();

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

    public static void AddItemsToTabs(BuildCreativeModeTabContentsEvent event){

        if(event.getTab() == RangerTabs.MMPRTab.get()) {
            for (int i = 0; i < RangerTabs.MMPR.size(); i++)
            {
                event.accept( RangerTabs.MMPR.get(i));
            }

        }
/*        else if(event.getTab() == RangerTabs.JAKQTab.get()) {
            for (int i = 0; i < RangerTabs.JAKQ.size(); i++)
            {
                event.accept( RangerTabs.JAKQ.get(i));
            }

        }
        else if(event.getTab() == RangerTabs.SunVulcanTab.get()) {
            for (int i = 0; i < RangerTabs.SUN_VULCAN.size(); i++)
            {
                event.accept( RangerTabs.SUN_VULCAN.get(i));
            }

        }*/
        else if(event.getTab() == RangerTabs.TurboTab.get()) {
            for (int i = 0; i < RangerTabs.TURBO.size(); i++)
            {
                event.accept( RangerTabs.TURBO.get(i));
            }

        }/*
        else if(event.getTab() == RangerTabs.MaskmanTab.get()) {
            for (int i = 0; i < RangerTabs.MASKMAN.size(); i++)
            {
                event.accept( RangerTabs.MASKMAN.get(i));
            }

        }
        else if(event.getTab() == RangerTabs.GingamanTab.get()) {
            for (int i = 0; i < RangerTabs.GINGAMAN.size(); i++)
            {
                event.accept( RangerTabs.GINGAMAN.get(i));
            }

        }
        else if(event.getTab() == RangerTabs.GaorangerTab.get()) {
            for (int i = 0; i < RangerTabs.GAORANGER.size(); i++)
            {
                event.accept( RangerTabs.GAORANGER.get(i));
            }

        }
        else if(event.getTab() == RangerTabs.ShinkengerTab.get()) {
            for (int i = 0; i < RangerTabs.SHINKENGER.size(); i++)
            {
                event.accept( RangerTabs.SHINKENGER.get(i));
            }

        }
        else if(event.getTab() == RangerTabs.LuPatRangerTab.get()) {
            for (int i = 0; i < RangerTabs.LUPATRANGER.size(); i++)
            {
                event.accept( RangerTabs.LUPATRANGER.get(i));
            }

        }
        else if(event.getTab() == RangerTabs.RyusoulgerTab.get()) {
            for (int i = 0; i < RangerTabs.RYUSOULGER.size(); i++)
            {
                event.accept( RangerTabs.RYUSOULGER.get(i));
            }

        }*/
        else if(event.getTab() == RangerTabs.MiscTab.get()) {

            event.accept(MobsCore.PUTTY_PATROLLERS_SPAWN_EGG);
/*
            event.accept(MobsCore.CRIMERS_SPAWN_EGG);

            event.accept(MobsCore.MACHINEMEN_SPAWN_EGG);

            event.accept(MobsCore.UNGLERS_SPAWN_EGG);
*/
            event.accept(MobsCore.CHROMITES_SPAWN_EGG);
            event.accept(MobsCore.BLUE_SENTURION_EVIL_SPAWN_EGG);
/*
            event.accept(MobsCore.YARTOTS_SPAWN_EGG);
            event.accept(MobsCore.BLACK_KNIGHT_SPAWN_EGG);

            event.accept(MobsCore.ORGETTES_SPAWN_EGG);
            event.accept(MobsCore.DUKE_ORG_ROUKI_SPAWN_EGG);

            event.accept(MobsCore.NANASHIS_SPAWN_EGG);
            event.accept(MobsCore.GEDOU_SHINKEN_RED_SPAWN_EGG);

            event.accept(MobsCore.PORDERMEN_SPAWN_EGG);

            event.accept(MobsCore.DRUNNS_SPAWN_EGG);
            event.accept(MobsCore.GAISOULG_SPAWN_EGG);
            event.accept(MobsCore.RYUSOUL_MORIA_SPAWN_EGG);
*/
            for (int i = 0; i < RangerTabs.MISC.size(); i++)
            {
                event.accept( RangerTabs.MISC.get(i));
            }
        }
        else if(event.getTab() == RangerTabs.BlockTab.get()) {
            for (int i = 0; i < RangerTabs.BLOCKS.size(); i++)
            {
                event.accept( RangerTabs.BLOCKS.get(i));
            }

        }



    }

}
