package com.docrider.powerrangerscraft.blocks.entity;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.blocks.RangerBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, PowerRangersCraftCore.MODID);

    public static final Supplier<BlockEntityType<SwordStatueBlockEntity>> SWORD_STATUE_BE =
            BLOCK_ENTITIES.register("sword_statue_be", () -> BlockEntityType.Builder.of(
                    SwordStatueBlockEntity::new, RangerBlocks.SWORD_STATUE.get()).build(null));

    public static final Supplier<BlockEntityType<GridEnergyInfuserBlockEntity>> GRID_ENERGY_INFUSER_BE =
            BLOCK_ENTITIES.register("grid_energy_infuser_be", () -> BlockEntityType.Builder.of(
                    GridEnergyInfuserBlockEntity::new, RangerBlocks.GRID_ENERGY_INFUSER.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
