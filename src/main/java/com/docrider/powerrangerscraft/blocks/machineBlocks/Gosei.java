package com.docrider.powerrangerscraft.blocks.machineBlocks;

import com.docrider.powerrangerscraft.items.MegaforceItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
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
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Gosei extends MachineBlock
{
    public static List<Item> MAIN_CARD = new ArrayList<>();
    public static List<Item> RED_CARD = new ArrayList<>();
    public static List<Item> PINK_CARD = new ArrayList<>();
    public static List<Item> BLACK_CARD = new ArrayList<>();
    public static List<Item> YELLOW_CARD = new ArrayList<>();
    public static List<Item> BLUE_CARD = new ArrayList<>();
    public static List<Item> KNIGHT_CARD = new ArrayList<>();

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

	public Gosei(Properties properties, VoxelShape shape)
	{
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
            if (player.getItemInHand(hand).getItem() == MegaforceItems.BLANK_POWER_CARD.asItem()) {
                process(player, level, pos, hand, getCardDrop(0));
            }
            else if (player.getItemInHand(hand).getItem() == MegaforceItems.RED_CHANGE_POWER_CARD.asItem()) {
                process(player, level, pos, hand, getCardDrop(1));
            }
            else if (player.getItemInHand(hand).getItem() == MegaforceItems.PINK_CHANGE_POWER_CARD.asItem()) {
                process(player, level, pos, hand, getCardDrop(2));
            }
            else if (player.getItemInHand(hand).getItem() == MegaforceItems.BLACK_CHANGE_POWER_CARD.asItem()) {
                process(player, level, pos, hand, getCardDrop(3));
            }
            else if (player.getItemInHand(hand).getItem() == MegaforceItems.YELLOW_CHANGE_POWER_CARD.asItem()) {
                process(player, level, pos, hand, getCardDrop(4));
            }
            else if (player.getItemInHand(hand).getItem() == MegaforceItems.BLUE_CHANGE_POWER_CARD.asItem()) {
                process(player, level, pos, hand, getCardDrop(5));
            }
            else if (player.getItemInHand(hand).getItem() == MegaforceItems.ROBO_KNIGHT_CHANGE_POWER_CARD.asItem()) {
                process(player, level, pos, hand, getCardDrop(6));
            }
            return ItemInteractionResult.SUCCESS;
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    public Gosei AddToTabList(List<Block> TabList) {
        TabList.add(this);
        return this;
    }

    public static VoxelShape SHAPE_NORTH = Block.box(-2,-5,10,17,29,15);
    public static VoxelShape SHAPE_SOUTH = Block.box(-2,-5,1,17,29,6);
    public static VoxelShape SHAPE_EAST = Block.box(0,-5,-1,5,29,18);
    public static VoxelShape SHAPE_WEST = Block.box(10,-5,-1,15,29,18);

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        switch (pState.getValue(FACING)) {
            case NORTH:
            default:
                return SHAPE_NORTH;
            case SOUTH:
                return SHAPE_SOUTH;
            case WEST:
                return SHAPE_WEST;
            case EAST:
                return SHAPE_EAST;
        }

    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    public static boolean isShapeFullBlock(VoxelShape p_49917_) {
        return false;
    }

    private Item getCardDrop(int num) {
        Random generator = new Random();

        if (num == 1) {
            int rand = generator.nextInt(RED_CARD.size());
            return RED_CARD.get(rand);
        } else if (num == 2) {
            int rand = generator.nextInt(PINK_CARD.size());
            return PINK_CARD.get(rand);
        } else if (num == 3) {
            int rand = generator.nextInt(BLACK_CARD.size());
            return BLACK_CARD.get(rand);
        } else if (num == 4) {
            int rand = generator.nextInt(YELLOW_CARD.size());
            return YELLOW_CARD.get(rand);
        } else if (num == 5) {
            int rand = generator.nextInt(BLUE_CARD.size());
            return BLUE_CARD.get(rand);
        } else if (num == 6) {
            int rand = generator.nextInt(KNIGHT_CARD.size());
            return KNIGHT_CARD.get(rand);
        } else {
            int rand = generator.nextInt(MAIN_CARD.size());
            return MAIN_CARD.get(rand);
        }
    }
}
