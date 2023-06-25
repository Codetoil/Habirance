package endurteam.habirance.world.level.block;

import endurteam.habirance.Habirance;
import endurteam.habirance.world.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks
{
	public static final DeferredRegister<Block> BLOCKS =
			DeferredRegister.create(ForgeRegistries.BLOCKS, Habirance.MOD_ID);

	public static final RegistryObject<Block> LIMESTONE = registerBlock(
			"limestone",
			() -> new Block(
					BlockBehaviour.Properties.of()
							.sound(SoundType.CALCITE)
							.instrument(NoteBlockInstrument.BASEDRUM)
							.strength(0.75f, 0.75f)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> LIMESTONE_STAIRS = registerBlock(
			"limestone_stairs",
			() -> new StairBlock(() -> ModBlocks.LIMESTONE.get().defaultBlockState(),
					BlockBehaviour.Properties.copy(LIMESTONE.get()))
	);

	public static final RegistryObject<Block> LIMESTONE_SLAB = registerBlock(
			"limestone_slab",
			() -> new SlabBlock(
					BlockBehaviour.Properties.copy(LIMESTONE.get()))
	);

	public static final RegistryObject<Block> LIMESTONE_WALL = registerBlock(
			"limestone_wall",
			() -> new WallBlock(
					BlockBehaviour.Properties.copy(LIMESTONE.get()))
	);

	public static final RegistryObject<Block> POLISHED_LIMESTONE = registerBlock(
			"polished_limestone",
			() -> new Block(BlockBehaviour.Properties.copy(LIMESTONE.get()))
	);

	public static final RegistryObject<Block> POLISHED_LIMESTONE_STAIRS = registerBlock(
			"polished_limestone_stairs",
			() -> new StairBlock(() -> ModBlocks.POLISHED_LIMESTONE.get().defaultBlockState(),
					BlockBehaviour.Properties.copy(POLISHED_LIMESTONE.get()))
	);

	public static final RegistryObject<Block> POLISHED_LIMESTONE_SLAB = registerBlock(
			"polished_limestone_slab",
			() -> new SlabBlock(
					BlockBehaviour.Properties.copy(POLISHED_LIMESTONE.get()))
	);

	public static final RegistryObject<Block> ALABASTER = registerBlock(
			"alabaster",
			() -> new Block(
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(1.5f)
							.explosionResistance(6f)
							.sound(SoundType.STONE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> ALABASTER_STAIRS = registerBlock(
			"alabaster_stairs",
			() -> new StairBlock(() -> ModBlocks.ALABASTER.get().defaultBlockState(),
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(1.5f)
							.explosionResistance(6f)
							.sound(SoundType.STONE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> ALABASTER_SLAB = registerBlock(
			"alabaster_slab",
			() -> new SlabBlock(
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(1.5f)
							.explosionResistance(6f)
							.sound(SoundType.STONE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> ALABASTER_WALL = registerBlock(
			"alabaster_wall",
			() -> new WallBlock(
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(1.5f)
							.explosionResistance(6f)
							.sound(SoundType.STONE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> POLISHED_ALABASTER = registerBlock(
			"polished_alabaster",
			() -> new Block(
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(1.5f)
							.explosionResistance(6f)
							.sound(SoundType.STONE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> POLISHED_ALABASTER_STAIRS = registerBlock(
			"polished_alabaster_stairs",
			() -> new StairBlock(() -> ModBlocks.POLISHED_ALABASTER.get().defaultBlockState(),
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(1.5f)
							.explosionResistance(6f)
							.sound(SoundType.STONE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> POLISHED_ALABASTER_SLAB = registerBlock(
			"polished_alabaster_slab",
			() -> new SlabBlock(
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(1.5f)
							.explosionResistance(6f)
							.sound(SoundType.STONE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> TRAVERTINE = registerBlock(
			"travertine",
			() -> new Block(
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(1.5f)
							.explosionResistance(6f)
							.sound(SoundType.TUFF)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> TRAVERTINE_STAIRS = registerBlock(
			"travertine_stairs",
			() -> new StairBlock(() -> ModBlocks.TRAVERTINE.get().defaultBlockState(),
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(1.5f)
							.explosionResistance(6f)
							.sound(SoundType.TUFF)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> TRAVERTINE_SLAB = registerBlock(
			"travertine_slab",
			() -> new SlabBlock(
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(1.5f)
							.explosionResistance(6f)
							.sound(SoundType.TUFF)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> TRAVERTINE_WALL = registerBlock(
			"travertine_wall",
			() -> new WallBlock(
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(1.5f)
							.explosionResistance(6f)
							.sound(SoundType.TUFF)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> TRAVERTINE_PILLAR = registerBlock(
			"travertine_pillar",
			() -> new RotatedPillarBlock(
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(1.5f)
							.explosionResistance(6f)
							.sound(SoundType.TUFF)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> POLISHED_TRAVERTINE = registerBlock(
			"polished_travertine",
			() -> new Block(
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(1.5f)
							.explosionResistance(6f)
							.sound(SoundType.TUFF)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> POLISHED_TRAVERTINE_STAIRS = registerBlock(
			"polished_travertine_stairs",
			() -> new StairBlock(() -> ModBlocks.POLISHED_TRAVERTINE.get().defaultBlockState(),
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(1.5f)
							.explosionResistance(6f)
							.sound(SoundType.TUFF)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> POLISHED_TRAVERTINE_SLAB = registerBlock(
			"polished_travertine_slab",
			() -> new SlabBlock(
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(1.5f)
							.explosionResistance(6f)
							.sound(SoundType.TUFF)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> TRAVERTINE_BRICKS = registerBlock(
			"travertine_bricks",
			() -> new Block(
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(1.5f)
							.explosionResistance(6f)
							.sound(SoundType.TUFF)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> TRAVERTINE_BRICK_STAIRS = registerBlock(
			"travertine_brick_stairs",
			() -> new StairBlock(() -> ModBlocks.TRAVERTINE_BRICKS.get().defaultBlockState(),
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(1.5f)
							.explosionResistance(6f)
							.sound(SoundType.TUFF)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> TRAVERTINE_BRICK_SLAB = registerBlock(
			"travertine_brick_slab",
			() -> new SlabBlock(
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(1.5f)
							.explosionResistance(6f)
							.sound(SoundType.TUFF)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> TRAVERTINE_BRICK_WALL = registerBlock(
			"travertine_brick_wall",
			() -> new WallBlock(
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(1.5f)
							.explosionResistance(6f)
							.sound(SoundType.TUFF)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> RUSSET = registerBlock(
			"russet",
			() -> new Block(
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(1.5f)
							.explosionResistance(6f)
							.sound(SoundType.STONE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> RUSSET_STAIRS = registerBlock(
			"russet_stairs",
			() -> new StairBlock(() -> ModBlocks.RUSSET.get().defaultBlockState(),
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(1.5f)
							.explosionResistance(6f)
							.sound(SoundType.STONE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> RUSSET_SLAB = registerBlock(
			"russet_slab",
			() -> new SlabBlock(
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(1.5f)
							.explosionResistance(6f)
							.sound(SoundType.STONE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> RUSSET_WALL = registerBlock(
			"russet_wall",
			() -> new WallBlock(
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(1.5f)
							.explosionResistance(6f)
							.sound(SoundType.STONE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> POLISHED_RUSSET = registerBlock(
			"polished_russet",
			() -> new Block(
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(1.5f)
							.explosionResistance(6f)
							.sound(SoundType.STONE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> POLISHED_RUSSET_STAIRS = registerBlock(
			"polished_russet_stairs",
			() -> new StairBlock(() -> ModBlocks.POLISHED_RUSSET.get().defaultBlockState(),
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(1.5f)
							.explosionResistance(6f)
							.sound(SoundType.STONE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> POLISHED_RUSSET_SLAB = registerBlock(
			"polished_russet_slab",
			() -> new SlabBlock(
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(1.5f)
							.explosionResistance(6f)
							.sound(SoundType.STONE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> RUSSET_BRICKS = registerBlock(
			"russet_bricks",
			() -> new Block(
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(1.5f)
							.explosionResistance(6f)
							.sound(SoundType.STONE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> RUSSET_BRICK_STAIRS = registerBlock(
			"russet_brick_stairs",
			() -> new StairBlock(() -> ModBlocks.RUSSET_BRICKS.get().defaultBlockState(),
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(1.5f)
							.explosionResistance(6f)
							.sound(SoundType.STONE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> RUSSET_BRICK_SLAB = registerBlock(
			"russet_brick_slab",
			() -> new SlabBlock(
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(1.5f)
							.explosionResistance(6f)
							.sound(SoundType.STONE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> RUSSET_BRICK_WALL = registerBlock(
			"russet_brick_wall",
			() -> new WallBlock(
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(1.5f)
							.explosionResistance(6f)
							.sound(SoundType.STONE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> CRACKED_RUSSET_BRICKS = registerBlock(
			"cracked_russet_bricks",
			() -> new Block(
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(1.5f)
							.explosionResistance(6f)
							.sound(SoundType.STONE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> CHISELED_RUSSET_BRICKS = registerBlock(
			"chiseled_russet_bricks",
			() -> new Block(
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(1.5f)
							.explosionResistance(6f)
							.sound(SoundType.STONE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> SERENE = registerBlock(
			"serene",
			() -> new Block(
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(0.8f)
							.explosionResistance(0.8f)
							.sound(SoundType.STONE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> SERENE_STAIRS = registerBlock(
			"serene_stairs",
			() -> new StairBlock(() -> ModBlocks.SERENE.get().defaultBlockState(),
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(0.8f)
							.explosionResistance(0.8f)
							.sound(SoundType.STONE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> SERENE_SLAB = registerBlock(
			"serene_slab",
			() -> new SlabBlock(
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(0.8f)
							.explosionResistance(0.8f)
							.sound(SoundType.STONE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> SERENE_WALL = registerBlock(
			"serene_wall",
			() -> new WallBlock(
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(0.8f)
							.explosionResistance(0.8f)
							.sound(SoundType.STONE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> CUT_SERENE = registerBlock(
			"cut_serene",
			() -> new RotatedPillarBlock(
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(0.8f)
							.explosionResistance(0.8f)
							.sound(SoundType.STONE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> CUT_SERENE_SLAB = registerBlock(
			"cut_serene_slab",
			() -> new SlabBlock(
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(0.8f)
							.explosionResistance(0.8f)
							.sound(SoundType.STONE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> SMOOTH_SERENE = registerBlock(
			"smooth_serene",
			() -> new Block(
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(6f)
							.explosionResistance(6f)
							.sound(SoundType.STONE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> SMOOTH_SERENE_STAIRS = registerBlock(
			"smooth_serene_stairs",
			() -> new StairBlock(() -> ModBlocks.SMOOTH_SERENE.get().defaultBlockState(),
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(6f)
							.explosionResistance(6f)
							.sound(SoundType.STONE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> SMOOTH_SERENE_SLAB = registerBlock(
			"smooth_serene_slab",
			() -> new SlabBlock(
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(6f)
							.explosionResistance(6f)
							.sound(SoundType.STONE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> CHISELED_SERENE = registerBlock(
			"chiseled_serene",
			() -> new Block(
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(0.8f)
							.explosionResistance(0.8f)
							.sound(SoundType.STONE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> DRYSTONE = registerBlock(
			"drystone",
			() -> new Block(
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(1.25f)
							.explosionResistance(4.2f)
							.sound(SoundType.STONE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> DRYSTONE_STAIRS = registerBlock(
			"drystone_stairs",
			() -> new StairBlock(() -> ModBlocks.DRYSTONE.get().defaultBlockState(),
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(1.25f)
							.explosionResistance(4.2f)
							.sound(SoundType.STONE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> DRYSTONE_SLAB = registerBlock(
			"drystone_slab",
			() -> new SlabBlock(
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(1.25f)
							.explosionResistance(4.2f)
							.sound(SoundType.STONE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> DRYSTONE_WALL = registerBlock(
			"drystone_wall",
			() -> new WallBlock(
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(1.25f)
							.explosionResistance(4.2f)
							.sound(SoundType.STONE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> POLISHED_DRYSTONE = registerBlock(
			"polished_drystone",
			() -> new Block(
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(1.25f)
							.explosionResistance(4.2f)
							.sound(SoundType.STONE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> POLISHED_DRYSTONE_STAIRS = registerBlock(
			"polished_drystone_stairs",
			() -> new StairBlock(() -> ModBlocks.POLISHED_DRYSTONE.get().defaultBlockState(),
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(1.25f)
							.explosionResistance(4.2f)
							.sound(SoundType.STONE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> POLISHED_DRYSTONE_SLAB = registerBlock(
			"polished_drystone_slab",
			() -> new SlabBlock(
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(1.25f)
							.explosionResistance(4.2f)
							.sound(SoundType.STONE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> CHISELED_DRYSTONE_BRICKS = registerBlock(
			"chiseled_drystone_bricks",
			() -> new Block(
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(1.25f)
							.explosionResistance(4.2f)
							.sound(SoundType.STONE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> DRYSTONE_BRICKS = registerBlock(
			"drystone_bricks",
			() -> new Block(
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(1.25f)
							.explosionResistance(4.2f)
							.sound(SoundType.STONE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> DRYSTONE_BRICK_STAIRS = registerBlock(
			"drystone_brick_stairs",
			() -> new StairBlock(() -> ModBlocks.DRYSTONE_BRICKS.get().defaultBlockState(),
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(1.25f)
							.explosionResistance(4.2f)
							.sound(SoundType.STONE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> DRYSTONE_BRICK_SLAB = registerBlock(
			"drystone_brick_slab",
			() -> new SlabBlock(
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(1.25f)
							.explosionResistance(4.2f)
							.sound(SoundType.STONE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> DRYSTONE_BRICK_WALL = registerBlock(
			"drystone_brick_wall",
			() -> new WallBlock(
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(1.25f)
							.explosionResistance(4.2f)
							.sound(SoundType.STONE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> DRYSTONE_TILES = registerBlock(
			"drystone_tiles",
			() -> new Block(
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(1.25f)
							.explosionResistance(4.2f)
							.sound(SoundType.STONE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> DRYSTONE_TILE_STAIRS = registerBlock(
			"drystone_tile_stairs",
			() -> new StairBlock(() -> ModBlocks.DRYSTONE_TILES.get().defaultBlockState(),
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(1.25f)
							.explosionResistance(4.2f)
							.sound(SoundType.STONE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> DRYSTONE_TILE_SLAB = registerBlock(
			"drystone_tile_slab",
			() -> new SlabBlock(
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(1.25f)
							.explosionResistance(4.2f)
							.sound(SoundType.STONE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> LYCE_ORE = registerBlock(
			"lyce_ore",
			() -> new Block(
					BlockBehaviour.Properties.copy(LIMESTONE.get()))
	);

	public static final RegistryObject<Block> LYCE_BLOCK = registerBlock(
			"lyce_block",
			() -> new Block(
					BlockBehaviour.Properties.of()
							.strength(1.5f, 6.0f)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> PEBBLE = registerBlock(
			"pebble",
			() -> new PebbleBlock(
					BlockBehaviour.Properties.of()
							.strength(0.1f, 6.0f)
			)
	);

	@SuppressWarnings("SameParameterValue")
	private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block)
	{
		RegistryObject<T> blockRegistryObject = registerBlockWithoutItem(name, block);
		registerBlockItem(name, blockRegistryObject);
		return blockRegistryObject;
	}

	@SuppressWarnings("SameParameterValue")
	private static <T extends Block> RegistryObject<T> registerBlockWithoutItem(String name, Supplier<T> block)
	{
		return BLOCKS.register(name, block);
	}

	private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block)
	{
		ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
	}

	public static void register(IEventBus eventBus)
	{
		BLOCKS.register(eventBus);
	}
}
