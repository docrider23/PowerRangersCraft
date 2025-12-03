package com.docrider.powerrangerscraft.blocks.machineBlocks;


import com.docrider.powerrangerscraft.items.OperationOverdriveItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.List;


public class CoronaAuroraCrown extends MachineBlock implements Equipable {
	
	  public static List<Item> CORONA_AURORA_CROWN = new ArrayList<>();
		 
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public CoronaAuroraCrown(Properties properties, VoxelShape shape) {
        super(properties);
    }



    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_53681_) {
        p_53681_.add(FACING);
     }

     public BlockState getStateForPlacement(BlockPlaceContext p_53679_) {
        return this.defaultBlockState().setValue(FACING, p_53679_.getHorizontalDirection().getOpposite());
     }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {

        if (!level.isClientSide()) {
            if (player.getItemInHand(hand).getItem() == OperationOverdriveItems.BROWNBEARDS_LUCKY_PEARL.get()) {
                process(player, level, pos, hand,  OperationOverdriveItems.BLACK_JEWEL.get());
                return ItemInteractionResult.SUCCESS;
            }
            else if (player.getItemInHand(hand).getItem() == OperationOverdriveItems.TORU_DIAMOND.get()) {
                process(player, level, pos, hand,  OperationOverdriveItems.YELLOW_JEWEL.get());
                return ItemInteractionResult.SUCCESS;
            }
            else if (player.getItemInHand(hand).getItem() == OperationOverdriveItems.BLUE_SAPPHIRE.get()) {
                process(player, level, pos, hand,  OperationOverdriveItems.BLUE_JEWEL.get());
                return ItemInteractionResult.SUCCESS;
            }
            else if (player.getItemInHand(hand).getItem() == OperationOverdriveItems.STAR_OF_ISIS.get()) {
                process(player, level, pos, hand,  OperationOverdriveItems.RED_JEWEL.get());
                return ItemInteractionResult.SUCCESS;
            }
            else if (player.getItemInHand(hand).getItem() == OperationOverdriveItems.PINK_EMERALD.get()) {
                process(player, level, pos, hand,  OperationOverdriveItems.PINK_JEWEL.get());
                return ItemInteractionResult.SUCCESS;
            }
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

	public CoronaAuroraCrown AddToTabList(List<Block> TabList) {
		TabList.add(this);
		return this;
	}
    public static VoxelShape SHAPE = Block.box(4, 0, 6, 12,16, 10);

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    public static boolean isShapeFullBlock(VoxelShape p_49917_) {
        return false;
    }
    @Override
    public EquipmentSlot getEquipmentSlot() {
        return EquipmentSlot.HEAD;
    }
}