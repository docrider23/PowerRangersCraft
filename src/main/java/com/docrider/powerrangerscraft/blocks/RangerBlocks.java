package com.docrider.powerrangerscraft.blocks;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.items.OtherItems;
import com.docrider.powerrangerscraft.items.RangerTabs;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
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

    public static final DeferredBlock<Block> ANIMAL_CRYSTAL_ORE = registerBlock("animal_crystal_ore",
            () -> new BaseBlockDropExperience(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops().strength(4.5F, 3.0F), UniformInt.of(2, 6)).AddToTabList(RangerTabs.BLOCKS));

    public static final DeferredBlock<Block> DEEPSLATE_ANIMAL_CRYSTAL_ORE = registerBlock("deepslate_animal_crystal_ore",
            () -> new BaseBlockDropExperience(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops().strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE), UniformInt.of(2, 6)).AddToTabList(RangerTabs.BLOCKS));

    public static final DeferredBlock<Block> POWER_DISC_ORE = registerBlock("power_disc_ore",
            () -> new BaseBlockDropExperience(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops().strength(4.5F, 3.0F), UniformInt.of(2, 6)).AddToTabList(RangerTabs.BLOCKS));

    public static final DeferredBlock<Block> DEEPSLATE_POWER_DISC_ORE = registerBlock("deepslate_power_disc_ore",
            () -> new BaseBlockDropExperience(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops().strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE), UniformInt.of(2, 6)).AddToTabList(RangerTabs.BLOCKS));

    public static final DeferredBlock<Block> DINO_KEY_ORE = registerBlock("dino_key_ore",
            () -> new BaseBlockDropExperience(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops().strength(4.5F, 3.0F), UniformInt.of(2, 6)).AddToTabList(RangerTabs.BLOCKS));

    public static final DeferredBlock<Block> DEEPSLATE_DINO_KEY_ORE = registerBlock("deepslate_dino_key_ore",
            () -> new BaseBlockDropExperience(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops().strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE), UniformInt.of(2, 6)).AddToTabList(RangerTabs.BLOCKS));

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