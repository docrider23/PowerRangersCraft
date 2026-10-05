package com.docrider.powerrangerscraft.world.inventory;

import com.docrider.powerrangerscraft.blocks.RangerBlocks;
import com.docrider.powerrangerscraft.blocks.entity.PowerCoinForgeBlockEntity;
import com.docrider.powerrangerscraft.init.ModMenus;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.SlotItemHandler;

public class PowerCoinForgeGuiMenu extends AbstractContainerMenu {
    private final PowerCoinForgeBlockEntity bEntity;
    private final Level level;
    private final ContainerData data;

    public PowerCoinForgeGuiMenu(int containerId, Inventory playerInventory, FriendlyByteBuf extraData) {
        this(containerId, playerInventory,
                playerInventory.player.level().getBlockEntity(extraData.readBlockPos()),
                new SimpleContainerData(2));
    }

    public PowerCoinForgeGuiMenu(int containerId, Inventory playerInventory, BlockEntity blockEntity, ContainerData data) {
        super(ModMenus.POWER_COIN_FORGE_GUI.get(), containerId);
        checkContainerDataCount(data, 2);
        this.bEntity = (PowerCoinForgeBlockEntity) blockEntity;
        this.level = playerInventory.player.level();
        this.data = data;

        addDataSlots(data);

        IItemHandler inventory = null;
        if (blockEntity != null && blockEntity.getLevel() != null) {
            inventory = blockEntity.getLevel().getCapability(Capabilities.ItemHandler.BLOCK, blockEntity.getBlockPos(), null);
        }

        if (inventory == null && blockEntity instanceof PowerCoinForgeBlockEntity forgeEntity) {
            inventory = forgeEntity.getInventory();
        }

        if (inventory == null) {
            inventory = new net.neoforged.neoforge.items.ItemStackHandler(14);
        }

        this.addSlot(new SlotItemHandler(inventory, 0, 19, 21));
        this.addSlot(new SlotItemHandler(inventory, 1, 19, 57));

        int slotIndex = 2;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 4; col++) {
                this.addSlot(new SlotItemHandler(inventory, slotIndex, 94 + (col * 18), 21 + (row * 18)));
                slotIndex++;
            }
        }

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        Slot sourceSlot = slots.get(index);
        if (sourceSlot == null || !sourceSlot.hasItem()) return ItemStack.EMPTY;

        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyStack = sourceStack.copy();

        if (index < 14) {
            if (!this.moveItemStackTo(sourceStack, 14, 50, true)) {
                return ItemStack.EMPTY;
            }
        } else {
            if (!this.moveItemStackTo(sourceStack, 0, 2, false)) {
                return ItemStack.EMPTY;
            }
        }

        if (sourceStack.isEmpty()) {
            sourceSlot.setByPlayer(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }

        if (sourceStack.getCount() == copyStack.getCount()) {
            return ItemStack.EMPTY;
        }

        sourceSlot.onTake(player, sourceStack);
        return copyStack;
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(ContainerLevelAccess.create(level, bEntity.getBlockPos()), player, RangerBlocks.POWER_COIN_FORGE.get());
    }

    public boolean isCrafting() {
        return data.get(0) > 0;
    }

    public int getScaledArrowProgress() {
        int progress = this.data.get(0);
        int maxProgress = this.data.get(1);
        int arrowPixelSize = 24;

        return maxProgress != 0 && progress != 0 ? progress * arrowPixelSize / maxProgress : 0;
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; i++) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }
}
