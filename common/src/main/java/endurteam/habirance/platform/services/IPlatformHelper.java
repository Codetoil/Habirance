package endurteam.habirance.platform.services;

import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public interface IPlatformHelper
{

	/**
	 * Gets the name of the current platform
	 *
	 * @return The name of the current platform.
	 */
	String getPlatformName();

	/**
	 * Checks if a mod with the given id is loaded.
	 *
	 * @param modId The mod to check if it is loaded.
	 * @return True if the mod is loaded, false otherwise.
	 */
	boolean isModLoaded(String modId);

	/**
	 * Check if the game is currently in a development environment.
	 *
	 * @return True if in a development environment, false otherwise.
	 */
	boolean isDevelopmentEnvironment();

	/**
	 * Gets the name of the environment type as a string.
	 *
	 * @return The name of the environment type.
	 */
	default String getEnvironmentName() {

		return isDevelopmentEnvironment() ? "development":"production";
	}

	TagKey<Block> BLOCK_TAG_TROPICAL_MOSS_REPLACEABLE();
	ResourceKey<Biome> BIOME_TROPICAL_CAVE();
	Supplier<Item> ITEM_LYCE();
	Supplier<Block> BLOCK_LIMESTONE();
	Supplier<Block> BLOCK_LIMESTONE_STAIRS();
	Supplier<Block> BLOCK_LIMESTONE_SLAB();
	Supplier<Block> BLOCK_LIMESTONE_WALL();
	Supplier<Block> BLOCK_POLISHED_LIMESTONE();
	Supplier<Block> BLOCK_POLISHED_LIMESTONE_STAIRS();
	Supplier<Block> BLOCK_POLISHED_LIMESTONE_SLAB();
	Supplier<Block> BLOCK_ALABASTER();
	Supplier<Block> BLOCK_ALABASTER_STAIRS();
	Supplier<Block> BLOCK_ALABASTER_SLAB();
	Supplier<Block> BLOCK_ALABASTER_WALL();
	Supplier<Block> BLOCK_POLISHED_ALABASTER();
	Supplier<Block> BLOCK_POLISHED_ALABASTER_STAIRS();
	Supplier<Block> BLOCK_POLISHED_ALABASTER_SLAB();
	Supplier<Block> BLOCK_TRAVERTINE();
	Supplier<Block> BLOCK_TRAVERTINE_STAIRS();
	Supplier<Block> BLOCK_TRAVERTINE_SLAB();
	Supplier<Block> BLOCK_TRAVERTINE_WALL();
	Supplier<Block> BLOCK_TRAVERTINE_PILLAR();
	Supplier<Block> BLOCK_POLISHED_TRAVERTINE();
	Supplier<Block> BLOCK_POLISHED_TRAVERTINE_STAIRS();
	Supplier<Block> BLOCK_POLISHED_TRAVERTINE_SLAB();
	Supplier<Block> BLOCK_TRAVERTINE_BRICKS();
	Supplier<Block> BLOCK_TRAVERTINE_BRICK_STAIRS();
	Supplier<Block> BLOCK_TRAVERTINE_BRICK_SLAB();
	Supplier<Block> BLOCK_TRAVERTINE_BRICK_WALL();
	Supplier<Block> BLOCK_RUSSET();
	Supplier<Block> BLOCK_RUSSET_STAIRS();
	Supplier<Block> BLOCK_RUSSET_SLAB();
	Supplier<Block> BLOCK_RUSSET_WALL();
	Supplier<Block> BLOCK_POLISHED_RUSSET();
	Supplier<Block> BLOCK_POLISHED_RUSSET_STAIRS();
	Supplier<Block> BLOCK_POLISHED_RUSSET_SLAB();
	Supplier<Block> BLOCK_RUSSET_BRICKS();
	Supplier<Block> BLOCK_RUSSET_BRICK_STAIRS();
	Supplier<Block> BLOCK_RUSSET_BRICK_SLAB();
	Supplier<Block> BLOCK_RUSSET_BRICK_WALL();
	Supplier<Block> BLOCK_CRACKED_RUSSET_BRICKS();
	Supplier<Block> BLOCK_CHISELED_RUSSET_BRICKS();
	Supplier<Block> BLOCK_SERENE();
	Supplier<Block> BLOCK_SERENE_STAIRS();
	Supplier<Block> BLOCK_SERENE_SLAB();
	Supplier<Block> BLOCK_SERENE_WALL();
	Supplier<Block> BLOCK_CUT_SERENE();
	Supplier<Block> BLOCK_CUT_SERENE_SLAB();
	Supplier<Block> BLOCK_SMOOTH_SERENE();
	Supplier<Block> BLOCK_SMOOTH_SERENE_STAIRS();
	Supplier<Block> BLOCK_SMOOTH_SERENE_SLAB();
	Supplier<Block> BLOCK_CHISELED_SERENE();
	Supplier<Block> BLOCK_DRYSTONE();
	Supplier<Block> BLOCK_DRYSTONE_STAIRS();
	Supplier<Block> BLOCK_DRYSTONE_SLAB();
	Supplier<Block> BLOCK_DRYSTONE_WALL();
	Supplier<Block> BLOCK_POLISHED_DRYSTONE();
	Supplier<Block> BLOCK_POLISHED_DRYSTONE_STAIRS();
	Supplier<Block> BLOCK_POLISHED_DRYSTONE_SLAB();
	Supplier<Block> BLOCK_CHISELED_DRYSTONE_BRICKS();
	Supplier<Block> BLOCK_DRYSTONE_BRICKS();
	Supplier<Block> BLOCK_DRYSTONE_BRICK_STAIRS();
	Supplier<Block> BLOCK_DRYSTONE_BRICK_SLAB();
	Supplier<Block> BLOCK_DRYSTONE_BRICK_WALL();
	Supplier<Block> BLOCK_DRYSTONE_TILES();
	Supplier<Block> BLOCK_DRYSTONE_TILE_STAIRS();
	Supplier<Block> BLOCK_DRYSTONE_TILE_SLAB();
	Supplier<Block> BLOCK_LYCE_ORE();
	Supplier<Block> BLOCK_LYCE_BLOCK();
	Supplier<Block> BLOCK_PEBBLE();
	
}