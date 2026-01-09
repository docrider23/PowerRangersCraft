package com.docrider.powerrangerscraft.blocks;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.blocks.custom.*;
import com.docrider.powerrangerscraft.blocks.machineBlocks.AnimalDNARepository;
import com.docrider.powerrangerscraft.blocks.machineBlocks.CoronaAuroraCrown;
import com.docrider.powerrangerscraft.entity.MobsCore;
import com.docrider.powerrangerscraft.items.OtherItems;
import com.docrider.powerrangerscraft.items.RangerTabs;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class RangerBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(PowerRangersCraftCore.MODID);

    public static final DeferredBlock<Block> LOGO_ORE = registerBlock("logo_ore",
            () -> new BaseBlockDropExperience(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops().strength(4.5F, 3.0F), UniformInt.of(2, 6)).AddToTabList(RangerTabs.BLOCKS));

    public static final DeferredBlock<Block> DEEPSLATE_LOGO_ORE = registerBlock("deepslate_logo_ore",
            () -> new BaseBlockDropExperience(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops().strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE), UniformInt.of(2, 6)).AddToTabList(RangerTabs.BLOCKS));

    public static final DeferredBlock<Block> DEEPSLATE_MECHA_ORE = registerBlock("deepslate_mecha_ore",
            () -> new BaseBlockDropExperience(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops().strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE), UniformInt.of(2, 6)).AddToTabList(RangerTabs.BLOCKS));

    public static final DeferredBlock<Block> MECHA_NETHER_ORE = registerBlock("mecha_nether_ore",
            () -> new BaseBlockDropExperience(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops().strength(4.5F, 3.0F).sound(SoundType.NETHERRACK), UniformInt.of(2, 6)).AddToTabList(RangerTabs.BLOCKS));

    //public static final DeferredBlock<Block> POWER_COIN_FORGE = registerBlock("power_coin_forge",
    //        () -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).lightLevel((glow) -> 0).strength(2f).dynamicShape()).AddToTabList(RangerTabs.BLOCKS));

    public static final DeferredBlock<Block> SERPENTERA_SCALE_GREEN = registerBlock("serpentera_scale_green",
            () -> new BaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN).strength(5.0F,6.0F)).AddToTabList(RangerTabs.BLOCKS));

    public static final DeferredBlock<Block> SERPENTERA_SCALE_GOLD = registerBlock("serpentera_scale_gold",
            () -> new BaseFacingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                    .strength(5.0F, 6.0F).sound(SoundType.METAL)).AddToTabList(RangerTabs.BLOCKS));

    public static final DeferredBlock<Block> RESCUE_BIRD = registerBlock("rescue_bird",
            () -> new RescueBird(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                    .strength(5.0F, 6.0F).dynamicShape().lightLevel((p_152632_) -> {
                        return 10;}),Block.box(4, 0, 4, 12,16, 12)).AddToTabList(RangerTabs.BLOCKS));

    public static final DeferredBlock<Block> ANIMAL_CRYSTAL_ORE = registerBlock("animal_crystal_ore",
            () -> new BaseBlockDropExperience(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops().strength(4.5F, 3.0F), UniformInt.of(2, 6)).AddToTabList(RangerTabs.BLOCKS));

    public static final DeferredBlock<Block> DEEPSLATE_ANIMAL_CRYSTAL_ORE = registerBlock("deepslate_animal_crystal_ore",
            () -> new BaseBlockDropExperience(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops().strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE), UniformInt.of(2, 6)).AddToTabList(RangerTabs.BLOCKS));

    public static final DeferredBlock<Block> CORONA_AURORA_CROWN = registerBlock("corona_aurora_crown",
            () -> new CoronaAuroraCrown(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.CHIME)
                    .strength(5.0F,6.0F).dynamicShape().lightLevel((p_152632_) -> {
                        return 10;}),Block.box(0,0,0,15,2,15)).AddToTabList(RangerTabs.BLOCKS));

    public static final DeferredBlock<Block> CORONA_AURORA = registerBlock("corona_aurora",
            () -> new HatBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.CHIME)
                    .strength(5.0F,6.0F).dynamicShape().lightLevel((p_152632_) -> {
                        return 10;}),Block.box(4,0,4,12,3,12)).AddToTabList(RangerTabs.BLOCKS));

    public static final DeferredBlock<Block> SWORD_STATUE = registerBlock("sword_statue",
            () -> new SwordStatueBlock(BlockBehaviour.Properties.of().noOcclusion()).AddToTabList(RangerTabs.BLOCKS));

    public static final DeferredBlock<Block> POWER_DISC_ORE = registerBlock("power_disc_ore",
            () -> new BaseBlockDropExperience(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops().strength(4.5F, 3.0F), UniformInt.of(2, 6)).AddToTabList(RangerTabs.BLOCKS));

    public static final DeferredBlock<Block> DEEPSLATE_POWER_DISC_ORE = registerBlock("deepslate_power_disc_ore",
            () -> new BaseBlockDropExperience(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops().strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE), UniformInt.of(2, 6)).AddToTabList(RangerTabs.BLOCKS));

   public static final DeferredBlock<Block> ANIMAL_DNA_REPOSITORY = registerBlock("animal_dna_repository",
            () -> new AnimalDNARepository(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.COW_BELL)
                    .strength(5.0F,6.0F).sound(SoundType.METAL)).AddToTabList(RangerTabs.BLOCKS));

    public static final DeferredBlock<Block> WAREHOUSE_SIDING = registerBlock("warehouse_siding",
            () -> new BaseFacingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                    .strength(2.0F, 6.0F).sound(SoundType.METAL)).AddToTabList(RangerTabs.BLOCKS));

    public static final DeferredBlock<Block> DINO_KEY_ORE = registerBlock("dino_key_ore",
            () -> new BaseBlockDropExperience(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops().strength(4.5F, 3.0F), UniformInt.of(2, 6)).AddToTabList(RangerTabs.BLOCKS));

    public static final DeferredBlock<Block> DEEPSLATE_DINO_KEY_ORE = registerBlock("deepslate_dino_key_ore",
            () -> new BaseBlockDropExperience(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops().strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE), UniformInt.of(2, 6)).AddToTabList(RangerTabs.BLOCKS));

    public static final DeferredBlock<Block> END_SOLAR_CRYSTAL_ORE = registerBlock("end_solar_crystal_ore",
            () -> new BaseBlockDropExperience(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)
                    .strength(2f).requiresCorrectToolForDrops().strength(4.5F, 3.0F), UniformInt.of(2,6)).AddToTabList(RangerTabs.BLOCKS));

    public static final DeferredBlock<Block> END_STARRANGER_ORE = registerBlock("end_starranger_ore",
            () -> new BaseBlockDropExperience(BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)
                    .strength(2f).requiresCorrectToolForDrops().strength(4.5F, 3.0F), UniformInt.of(2,6)).AddToTabList(RangerTabs.BLOCKS));

    public static final DeferredBlock<Block> GENERAL_VENJIX_BOSS_BLOCK = registerBlock("general_venjix_boss_block",
            () -> new BossBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).strength(2f), MobsCore.GENERAL_VENJIX).AddToTabList(RangerTabs.BLOCKS));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        OtherItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}