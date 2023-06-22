package endurteam.habirance.world.level.block;

import endurteam.habirance.Habirance;
import endurteam.habirance.world.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks
{
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Habirance.MOD_ID);

	public static final RegistryObject<Block> LIMESTONE = registerBlock(
			"limestone",
			() -> new Block(
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(0.75f)
							.explosionResistance(0.75f)
							.sound(SoundType.CALCITE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> LIMESTONE_STAIRS = registerBlock(
			"limestone_stairs",
			() -> new StairBlock(() -> ModBlocks.LIMESTONE.get().defaultBlockState(),
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(0.75f)
							.explosionResistance(0.75f)
							.sound(SoundType.CALCITE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> LIMESTONE_SLAB = registerBlock(
			"limestone_slab",
			() -> new SlabBlock(
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(0.75f)
							.explosionResistance(0.75f)
							.sound(SoundType.CALCITE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> LIMESTONE_WALL = registerBlock(
			"limestone_wall",
			() -> new WallBlock(
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(0.75f)
							.explosionResistance(0.75f)
							.sound(SoundType.CALCITE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> POLISHED_LIMESTONE = registerBlock(
			"polished_limestone",
			() -> new Block(
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(0.75f)
							.explosionResistance(0.75f)
							.sound(SoundType.CALCITE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> POLISHED_LIMESTONE_STAIRS = registerBlock(
			"polished_limestone_stairs",
			() -> new StairBlock(() -> ModBlocks.POLISHED_LIMESTONE.get().defaultBlockState(),
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(0.75f)
							.explosionResistance(0.75f)
							.sound(SoundType.CALCITE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> POLISHED_LIMESTONE_SLAB = registerBlock(
			"polished_limestone_slab",
			() -> new SlabBlock(
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(0.75f)
							.explosionResistance(0.75f)
							.sound(SoundType.CALCITE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> LYCE_ORE = registerBlock(
			"lyce_ore",
			() -> new Block(
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(0.75f)
							.explosionResistance(0.75f)
							.sound(SoundType.CALCITE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> BLOCK_OF_LYCE = registerBlock(
			"block_of_lyce",
			() -> new Block(
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(1.5f)
							.explosionResistance(6f)
							.sound(SoundType.STONE)
							.requiresCorrectToolForDrops())
	);

	public static final RegistryObject<Block> PEBBLE = registerBlock(
			"pebble",
			() -> new PebbleBlock(
					BlockBehaviour.Properties.of(Material.STONE)
							.strength(0.1f)
							.explosionResistance(6.0f)
							.sound(SoundType.STONE)
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
