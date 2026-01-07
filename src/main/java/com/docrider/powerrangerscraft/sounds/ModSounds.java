package com.docrider.powerrangerscraft.sounds;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, PowerRangersCraftCore.MODID);

    public static final Supplier<SoundEvent> DRAGON_DAGGER_GOAT_HORN = registerSoundEvent("dragon_dagger_goat_horn");

    public static final Supplier<SoundEvent> GO_GO_POWER_RANGERS = registerSoundEvent("go_go_power_rangers");
    public static final ResourceKey<JukeboxSong> GO_GO_POWER_RANGERS_KEY = createSong("go_go_power_rangers");

    public static final Supplier<SoundEvent> GO_GO_ALIEN_RANGERS = registerSoundEvent("go_go_alien_rangers");
    public static final ResourceKey<JukeboxSong> GO_GO_ALIEN_RANGERS_KEY = createSong("go_go_alien_rangers");

    private static ResourceKey<JukeboxSong> createSong(String name) {
        return ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, name));
    }

    private static Supplier<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {SOUND_EVENTS.register(eventBus);}
}
