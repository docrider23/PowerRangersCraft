package com.docrider.powerrangerscraft.blocks.machineBlocks;

import com.docrider.powerrangerscraft.blocks.machineBlocks.MachineBlock;
import com.docrider.powerrangerscraft.blocks.RangerBlocks;
import com.docrider.powerrangerscraft.items.BeastMorphersItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MiniatureMorphXTank extends MachineBlock {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;


	  public static VoxelShape SHAPE = Block.box(0, 0, 0, 16,32, 16);

	public MiniatureMorphXTank(BlockBehaviour.Properties properties, VoxelShape shape ) {
		
		super(properties);
		SHAPE =shape;
	}
	
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


    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_53681_) {
        p_53681_.add(FACING);
     }

     public BlockState getStateForPlacement(BlockPlaceContext p_53679_) {
        return this.defaultBlockState().setValue(FACING, p_53679_.getHorizontalDirection().getOpposite());
     }

     public PushReaction getPistonPushReaction(BlockState p_53683_) {
        return PushReaction.PUSH_ONLY;
     }

	@Override
	protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {

		if (!level.isClientSide()) {
			if (player.getItemInHand(hand).getItem() == RangerBlocks.UNREFINED_MORPH_X.asItem() & player.getInventory().countItem(Items.IRON_INGOT) != 0) {
				player.getInventory().removeItem(player.getInventory().findSlotMatchingItem(new ItemStack(Items.IRON_INGOT)), 1);
				process(player, level, pos, hand, BeastMorphersItems.MORPH_X_CANISTER.asItem());
				return ItemInteractionResult.SUCCESS;
			}

		}
		return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
	}



	public MiniatureMorphXTank AddToTabList(List<Block> TabList) {
		TabList.add(this);
		return this;
	}

}