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

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> TurboTab = CREATIVE_MODE_TABS.register("prc005", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(TurboItems.TURBO_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID,"textures/gui/tab_turbo_items.png"))
                    .title(Component.translatable("tab.powerrangerscraft.turbo")).build());

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> LostGalaxyTab = CREATIVE_MODE_TABS.register("prc007", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(LostGalaxyItems.LOST_GALAXY_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID,"textures/gui/tab_lost_galaxy_items.png"))
                    .title(Component.translatable("tab.powerrangerscraft.lost_galaxy")).build());

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> WildForceTab = CREATIVE_MODE_TABS.register("prc010", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(WildForceItems.WILD_FORCE_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID,"textures/gui/tab_wild_force_items.png"))
                    .title(Component.translatable("tab.powerrangerscraft.wild_force")).build());

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> SamuraiTab = CREATIVE_MODE_TABS.register("prc017", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(SamuraiItems.SAMURAI_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID,"textures/gui/tab_samurai_items.png"))
                    .title(Component.translatable("tab.powerrangerscraft.samurai")).build());

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> DinoChargeTab = CREATIVE_MODE_TABS.register("prc021", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(DinoChargeItems.DINO_CHARGE_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID,"textures/gui/tab_dino_charge_items.png"))
                    .title(Component.translatable("tab.powerrangerscraft.dino_charge")).build());

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> DinoFuryTab = CREATIVE_MODE_TABS.register("prc028", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(DinoFuryItems.DINO_FURY_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID,"textures/gui/tab_dino_fury_items.png"))
                    .title(Component.translatable("tab.powerrangerscraft.dino_fury")).build());

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> CosmicFuryTab = CREATIVE_MODE_TABS.register("prc029", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(CosmicFuryItems.COSMIC_FURY_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath
             (PowerRangersCraftCore.MODID,"textures/gui/tab_cosmic_fury_items.png"))
                    .title(Component.translatable("tab.powerrangerscraft.cosmic_fury")).build());

   public static DeferredHolder<CreativeModeTab, CreativeModeTab> HyperforceTab = CREATIVE_MODE_TABS.register("prc030", () ->
           CreativeModeTab.builder().icon(() -> new ItemStack(HyperforceItems.HYPERFORCE_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath
                          (PowerRangersCraftCore.MODID,"textures/gui/tab_hyperforce_items.png"))
                    .title(Component.translatable("tab.powerrangerscraft.hyperforce")).build());

   public static DeferredHolder<CreativeModeTab, CreativeModeTab> ComicsTab = CREATIVE_MODE_TABS.register("prc031", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ComicsItems.SOLAR_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath
                            (PowerRangersCraftCore.MODID,"textures/gui/tab_misc_items.png"))
                    .title(Component.translatable("tab.powerrangerscraft.comics")).build());

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> RebootTab = CREATIVE_MODE_TABS.register("prc899", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(RebootItems.REBOOT_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath
                            (PowerRangersCraftCore.MODID,"textures/gui/tab_reboot_items.png"))
                    .title(Component.translatable("tab.powerrangerscraft.reboot")).build());

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> MiscTab = CREATIVE_MODE_TABS.register("prc900", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(OtherItems.POWER_RANGERS_LOGO.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID,"textures/gui/tab_misc_items.png"))
                    .title(Component.translatable("tab.powerrangerscraft.misc")).build());

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> BlockTab = CREATIVE_MODE_TABS.register("prc901", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(RangerBlocks.LOGO_ORE.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID,"textures/gui/tab_misc_items.png"))
                    .title(Component.translatable("tab.powerrangerscraft.block")).build());

    public static DeferredHolder<CreativeModeTab, CreativeModeTab> StarrangerTab = CREATIVE_MODE_TABS.register("prc999", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(StarrangerItems.STARRANGER_HELMET.get())).backgroundTexture(ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID,"textures/gui/tab_misc_items.png")).title(Component.translatable("tab.powerrangerscraft.starranger")).build());

    public static List<Item> MMPR= new ArrayList<Item>();

    public static List<Item> TURBO = new ArrayList<Item>();

    public static List<Item> LOST_GALAXY= new ArrayList<Item>();

    public static List<Item> WILD_FORCE= new ArrayList<Item>();

    public static List<Item> SAMURAI= new ArrayList<Item>();

    public static List<Item> DINO_CHARGE= new ArrayList<Item>();

    public static List<Item> DINO_FURY= new ArrayList<Item>();

    public static List<Item> COSMIC_FURY= new ArrayList<Item>();

    public static List<Item> HYPERFORCE= new ArrayList<Item>();

    public static List<Item> REBOOT= new ArrayList<Item>();

    public static List<Item> COMICS= new ArrayList<Item>();

    public static List<Item> MISC= new ArrayList<Item>();

    public static List<Block> BLOCKS= new ArrayList<Block>();

    public static List<Item> STARRANGER= new ArrayList<Item>();

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
        else if(event.getTab() == RangerTabs.TurboTab.get()) {
            for (int i = 0; i < RangerTabs.TURBO.size(); i++)
            {
                event.accept( RangerTabs.TURBO.get(i));
            }

        }
        else if(event.getTab() == RangerTabs.LostGalaxyTab.get()) {
            for (int i = 0; i < RangerTabs.LOST_GALAXY.size(); i++)
            {
                event.accept( RangerTabs.LOST_GALAXY.get(i));
            }

        }
        else if(event.getTab() == RangerTabs.WildForceTab.get()) {
            for (int i = 0; i < RangerTabs.WILD_FORCE.size(); i++)
            {
                event.accept( RangerTabs.WILD_FORCE.get(i));
            }

        }
        else if(event.getTab() == RangerTabs.SamuraiTab.get()) {
            for (int i = 0; i < RangerTabs.SAMURAI.size(); i++)
            {
                event.accept( RangerTabs.SAMURAI.get(i));
            }

        }
        else if(event.getTab() == RangerTabs.DinoChargeTab.get()) {
            for (int i = 0; i < RangerTabs.DINO_CHARGE.size(); i++)
            {
                event.accept( RangerTabs.DINO_CHARGE.get(i));
            }

        }
        else if(event.getTab() == RangerTabs.DinoFuryTab.get()) {
            for (int i = 0; i < RangerTabs.DINO_FURY.size(); i++)
            {
                event.accept( RangerTabs.DINO_FURY.get(i));
            }

        }
        else if(event.getTab() == RangerTabs.CosmicFuryTab.get()) {
            for (int i = 0; i < RangerTabs.COSMIC_FURY.size(); i++)
            {
                event.accept( RangerTabs.COSMIC_FURY.get(i));
            }

        }
        else if(event.getTab() == RangerTabs.HyperforceTab.get()) {
            for (int i = 0; i < RangerTabs.HYPERFORCE.size(); i++)
            {
                event.accept( RangerTabs.HYPERFORCE.get(i));
            }

        }
        else if(event.getTab() == RangerTabs.ComicsTab.get()) {
            for (int i = 0; i < RangerTabs.COMICS.size(); i++)
            {
                event.accept( RangerTabs.COMICS.get(i));
            }

        }
        else if(event.getTab() == RangerTabs.RebootTab.get()) {
            for (int i = 0; i < RangerTabs.REBOOT.size(); i++)
            {
                event.accept( RangerTabs.REBOOT.get(i));
            }

        }
        else if(event.getTab() == RangerTabs.StarrangerTab.get()) {
            for (int i = 0; i < RangerTabs.STARRANGER.size(); i++)
            {
                event.accept( RangerTabs.STARRANGER.get(i));
            }

        }
        else if(event.getTab() == RangerTabs.MiscTab.get()) {

            //event.accept(MobsCore.PUTTY_PATROLLERS_SPAWN_EGG);

            event.accept(MobsCore.CHROMITES_SPAWN_EGG);
            event.accept(MobsCore.PIRANHATRONS_SPAWN_EGG);
            event.accept(MobsCore.BLUE_SENTURION_EVIL_SPAWN_EGG);

            event.accept(MobsCore.SWABBIES_SPAWN_EGG);
            event.accept(MobsCore.STINGWINGERS_SPAWN_EGG);
            event.accept(MobsCore.MAGNA_DEFENDER_SPAWN_EGG);

            event.accept(MobsCore.PUTRIDS_SPAWN_EGG);
            event.accept(MobsCore.ZEN_AKU_SPAWN_EGG);

            event.accept(MobsCore.MOOGERS_SPAWN_EGG);

            event.accept(MobsCore.HENGEMEN_SPAWN_EGG);
            event.accept(MobsCore.VOID_KNIGHT_SPAWN_EGG);

            event.accept(MobsCore.ZENTINEL_SPAWN_EGG);
            event.accept(MobsCore.EVIL_BLUE_DINO_FURY_RANGER_SPAWN_EGG);

            event.accept(MobsCore.SILVER_SENTRY_SPAWN_EGG);

            event.accept(OtherItems.GO_GO_POWER_RANGERS_MUSIC_DISC);

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
