package com.docrider.powerrangerscraft.blocks.custom;


import com.docrider.powerrangerscraft.blocks.entity.SwordStatueBlockEntity;
import com.docrider.powerrangerscraft.items.OperationOverdriveItems;
import com.docrider.powerrangerscraft.items.others.BaseBlasterItem;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.List;

public class SwordStatueBlock extends BaseEntityBlock {

	public static VoxelShape SHAPE = Block.box(2, 0, 4, 14,32, 12);
	public static final MapCodec<SwordStatueBlock> CODEC = simpleCodec(SwordStatueBlock::new);
	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;


	public static final TagKey<Item> SWORDS = TagKey.create(
			Registries.ITEM,
			ResourceLocation.fromNamespaceAndPath("c", "tools/melee_weapons"));

	public SwordStatueBlock(Properties properties) {
		super(properties);
	      this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
	}


	@Override
	protected MapCodec<? extends BaseEntityBlock> codec() {
		return CODEC;
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

	public BlockState rotate(BlockState p_48722_, Rotation p_48723_) {
		return p_48722_.setValue(FACING, p_48723_.rotate(p_48722_.getValue(FACING)));
	}

	public SwordStatueBlock AddToTabList(List<Block> TabList) {
		TabList.add(this);
		return this;
	}

	@Override
	public RenderShape getRenderShape(BlockState pState) {
		return RenderShape.MODEL;
	}

	public static boolean isShapeFullBlock(VoxelShape p_49917_) {
		return false;
	}


	@Nullable
	@Override
	public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
		return new SwordStatueBlockEntity(blockPos, blockState);
	}

	@Override
	protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
		if(state.getBlock() != newState.getBlock()) {
			if(level.getBlockEntity(pos) instanceof SwordStatueBlockEntity swordStatueBlockEntity) {
				swordStatueBlockEntity.drops();
				level.updateNeighbourForOutputSignal(pos,this);
			}
		}
		super.onRemove(state, level, pos, newState, movedByPiston);
	}

	@Override
	protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
		if(level.getBlockEntity(pos) instanceof SwordStatueBlockEntity swordStatueBlockEntity) {
			if(swordStatueBlockEntity.inventory.getStackInSlot(0).isEmpty() && stack.getItem() instanceof TieredItem||
					swordStatueBlockEntity.inventory.getStackInSlot(0).isEmpty() && stack.getItem() instanceof BaseBlasterItem||
			swordStatueBlockEntity.inventory.getStackInSlot(0).isEmpty() && stack.getItem() == OperationOverdriveItems.UNFINISHED_SENTINEL_SWORD.get())  {
				swordStatueBlockEntity.inventory.insertItem(0, stack.copy(), false);
				stack.shrink(1);
				level.playSound(player, pos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, 1f, 2f);
			} else if (stack.isEmpty()) {
				ItemStack stackOnSwordStatue = swordStatueBlockEntity.inventory.extractItem(0,1, false);
				player.setItemInHand(InteractionHand.MAIN_HAND, stackOnSwordStatue);
				swordStatueBlockEntity.clearContents();
				level.playSound(player, pos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, 1f, 1f);
			}
		}
		return ItemInteractionResult.SUCCESS;
	}



}