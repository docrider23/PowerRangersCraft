package com.docrider.powerrangerscraft.entity.villagers;


import com.google.common.collect.ImmutableSet;
import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.blocks.RangerBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.util.ObfuscationReflectionHelper;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.lang.reflect.InvocationTargetException;

public class RangerVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(Registries.POINT_OF_INTEREST_TYPE, PowerRangersCraftCore.MODID);

    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS = DeferredRegister.create(Registries.VILLAGER_PROFESSION, PowerRangersCraftCore.MODID);

    public static final DeferredHolder<PoiType,PoiType> COMIC_SHOP_POI = POI_TYPES.register("comic_shop_poi",
            () -> new PoiType(ImmutableSet.copyOf(RangerBlocks.COMIC_SHOP.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final DeferredHolder<VillagerProfession,VillagerProfession> COMICSHOP_VILLAGER = VILLAGER_PROFESSIONS.register("comicshop_villager",
            () -> new VillagerProfession("comicshop_villager",(X) -> X.is(COMIC_SHOP_POI),
                    (X) -> X.is(COMIC_SHOP_POI), ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_FARMER));
    

    public static void registerPOIs() {
        try {
            ObfuscationReflectionHelper.findMethod(PoiType.class,
                    "registerBlockStates", PoiType.class).invoke(null, COMIC_SHOP_POI.get());
        } catch (InvocationTargetException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
    }

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}