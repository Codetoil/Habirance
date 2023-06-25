package endurteam.habirance.world.level.block;

import endurteam.habirance.world.level.block.state.properties.ModBlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class PebbleBlock extends Block
{
	public static final IntegerProperty PEBBLES = ModBlockStateProperties.PEBBLES;
	private static final VoxelShape ONE_AABB = Block.box(6.0D, 0.0D, 6.0D, 10.0D, 2.0D, 10.0D);
	private static final VoxelShape TWO_AABB = Block.box(2.0D, 0.0D, 2.0D, 12.0D, 6.0D, 12.0D);
	private static final VoxelShape THREE_AABB = Block.box(2.0D, 0.0D, 2.0D, 13.0D, 6.0D, 14.0D);
	private static final VoxelShape FOUR_AABB = Block.box(2.0D, 0.0D, 2.0D, 13.0D, 8.0D, 14.0D);

	public PebbleBlock(BlockBehaviour.Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(PEBBLES, 1));
	}

	@SuppressWarnings("deprecation")
	public boolean canBeReplaced(@NotNull BlockState pState, @NotNull BlockPlaceContext pUseContext) {
		return !pUseContext.isSecondaryUseActive() && pUseContext.getItemInHand().getItem() == this.asItem()
				&& pState.getValue(PEBBLES) < 4 || super.canBeReplaced(pState, pUseContext);
	}

	public BlockState getStateForPlacement(@NotNull BlockPlaceContext pContext) {
		BlockState blockstate = pContext.getLevel().getBlockState(pContext.getClickedPos());
		if (blockstate.is(this)) {
			return blockstate.cycle(PEBBLES);
		} else {
			return super.getStateForPlacement(pContext);
		}
	}

	@SuppressWarnings("deprecation")
	public @NotNull VoxelShape getShape(@NotNull BlockState pState, @NotNull BlockGetter pLevel,
										@NotNull BlockPos pPos, @NotNull CollisionContext pContext) {
		return switch (pState.getValue(PEBBLES))
				{
					case 2 -> TWO_AABB;
					case 3 -> THREE_AABB;
					case 4 -> FOUR_AABB;
					default -> ONE_AABB;
				};
	}

	protected void createBlockStateDefinition(@NotNull StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(PEBBLES);
	}

	@SuppressWarnings("deprecation")
	public boolean canSurvive(@NotNull BlockState pState, @NotNull LevelReader pLevel, @NotNull BlockPos pPos) {
		return Block.canSupportCenter(pLevel, pPos.below(), Direction.UP);
	}
}
