package com.docrider.powerrangerscraft.init;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.world.inventory.GridEnergyInfuserGuiMenu;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModMenus {
    public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, PowerRangersCraftCore.MODID);

    public static final DeferredHolder<MenuType<?>, MenuType<GridEnergyInfuserGuiMenu>> GRID_ENERGY_INFUSED_GUI = REGISTRY.register("grid_energy_infuser_gui", () -> IMenuTypeExtension.create(GridEnergyInfuserGuiMenu::new));

    public static void register(IEventBus eventBus) {REGISTRY.register(eventBus);}
}
