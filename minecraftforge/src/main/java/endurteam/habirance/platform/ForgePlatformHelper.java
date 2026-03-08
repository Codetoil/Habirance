package endurteam.habirance.platform;

import endurteam.habirance.platform.services.IPlatformHelper;
import endurteam.habirance.tags.ModTags;
import endurteam.habirance.world.biome.ModBiomes;
import endurteam.habirance.world.item.ModItems;
import endurteam.habirance.world.level.block.ModBlocks;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLLoader;

import java.util.function.Supplier;

public class ForgePlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {

        return "Forge";
    }

    @Override
    public boolean isModLoaded(String modId) {

        return ModList.get().isLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {

        return !FMLLoader.isProduction();
    }

    @Override
    public TagKey<Block> BLOCK_TAG_TROPICAL_MOSS_REPLACEABLE() {
        return ModTags.TROPICAL_MOSS_REPLACEABLE;
    }

    @Override
    public ResourceKey<Biome> BIOME_TROPICAL_CAVE() {
        return ModBiomes.TROPICAL_CAVE;
    }

    @Override
    public Supplier<Item> ITEM_LYCE() {
        return ModItems.LYCE;
    }

    @Override
    public Supplier<Block> BLOCK_LIMESTONE() {
        return ModBlocks.LIMESTONE;
    }

    @Override
    public Supplier<Block> BLOCK_LIMESTONE_STAIRS() {
        return ModBlocks.LIMESTONE_STAIRS;
    }

    @Override
    public Supplier<Block> BLOCK_LIMESTONE_SLAB() {
        return ModBlocks.LIMESTONE_SLAB;
    }

    @Override
    public Supplier<Block> BLOCK_LIMESTONE_WALL() {
        return ModBlocks.LIMESTONE_WALL;
    }

    @Override
    public Supplier<Block> BLOCK_POLISHED_LIMESTONE() {
        return ModBlocks.POLISHED_LIMESTONE;
    }

    @Override
    public Supplier<Block> BLOCK_POLISHED_LIMESTONE_STAIRS() {
        return ModBlocks.POLISHED_LIMESTONE_STAIRS;
    }

    @Override
    public Supplier<Block> BLOCK_POLISHED_LIMESTONE_SLAB() {
        return ModBlocks.POLISHED_LIMESTONE_SLAB;
    }

    @Override
    public Supplier<Block> BLOCK_ALABASTER() {
        return ModBlocks.ALABASTER;
    }

    @Override
    public Supplier<Block> BLOCK_ALABASTER_STAIRS() {
        return ModBlocks.ALABASTER_STAIRS;
    }

    @Override
    public Supplier<Block> BLOCK_ALABASTER_SLAB() {
        return ModBlocks.ALABASTER_SLAB;
    }

    @Override
    public Supplier<Block> BLOCK_ALABASTER_WALL() {
        return ModBlocks.ALABASTER_WALL;
    }

    @Override
    public Supplier<Block> BLOCK_POLISHED_ALABASTER() {
        return ModBlocks.POLISHED_ALABASTER;
    }

    @Override
    public Supplier<Block> BLOCK_POLISHED_ALABASTER_STAIRS() {
        return ModBlocks.POLISHED_ALABASTER_STAIRS;
    }

    @Override
    public Supplier<Block> BLOCK_POLISHED_ALABASTER_SLAB() {
        return ModBlocks.POLISHED_ALABASTER_SLAB;
    }

    @Override
    public Supplier<Block> BLOCK_TRAVERTINE() {
        return ModBlocks.TRAVERTINE;
    }

    @Override
    public Supplier<Block> BLOCK_TRAVERTINE_STAIRS() {
        return ModBlocks.TRAVERTINE_STAIRS;
    }

    @Override
    public Supplier<Block> BLOCK_TRAVERTINE_SLAB() {
        return ModBlocks.TRAVERTINE_SLAB;
    }

    @Override
    public Supplier<Block> BLOCK_TRAVERTINE_WALL() {
        return ModBlocks.TRAVERTINE_WALL;
    }

    @Override
    public Supplier<Block> BLOCK_TRAVERTINE_PILLAR() {
        return ModBlocks.TRAVERTINE_PILLAR;
    }

    @Override
    public Supplier<Block> BLOCK_POLISHED_TRAVERTINE() {
        return ModBlocks.POLISHED_TRAVERTINE;
    }

    @Override
    public Supplier<Block> BLOCK_POLISHED_TRAVERTINE_STAIRS() {
        return ModBlocks.POLISHED_TRAVERTINE_STAIRS;
    }

    @Override
    public Supplier<Block> BLOCK_POLISHED_TRAVERTINE_SLAB() {
        return ModBlocks.POLISHED_TRAVERTINE_SLAB;
    }

    @Override
    public Supplier<Block> BLOCK_TRAVERTINE_BRICKS() {
        return ModBlocks.TRAVERTINE_BRICKS;
    }

    @Override
    public Supplier<Block> BLOCK_TRAVERTINE_BRICK_STAIRS() {
        return ModBlocks.TRAVERTINE_BRICK_STAIRS;
    }

    @Override
    public Supplier<Block> BLOCK_TRAVERTINE_BRICK_SLAB() {
        return ModBlocks.TRAVERTINE_BRICK_SLAB;
    }

    @Override
    public Supplier<Block> BLOCK_TRAVERTINE_BRICK_WALL() {
        return ModBlocks.TRAVERTINE_BRICK_WALL;
    }

    @Override
    public Supplier<Block> BLOCK_RUSSET() {
        return ModBlocks.RUSSET;
    }

    @Override
    public Supplier<Block> BLOCK_RUSSET_STAIRS() {
        return ModBlocks.RUSSET_STAIRS;
    }

    @Override
    public Supplier<Block> BLOCK_RUSSET_SLAB() {
        return ModBlocks.RUSSET_SLAB;
    }

    @Override
    public Supplier<Block> BLOCK_RUSSET_WALL() {
        return ModBlocks.RUSSET_WALL;
    }

    @Override
    public Supplier<Block> BLOCK_POLISHED_RUSSET() {
        return ModBlocks.POLISHED_RUSSET;
    }

    @Override
    public Supplier<Block> BLOCK_POLISHED_RUSSET_STAIRS() {
        return ModBlocks.POLISHED_RUSSET_STAIRS;
    }

    @Override
    public Supplier<Block> BLOCK_POLISHED_RUSSET_SLAB() {
        return ModBlocks.POLISHED_RUSSET_SLAB;
    }

    @Override
    public Supplier<Block> BLOCK_RUSSET_BRICKS() {
        return ModBlocks.RUSSET_BRICKS;
    }

    @Override
    public Supplier<Block> BLOCK_RUSSET_BRICK_STAIRS() {
        return ModBlocks.RUSSET_BRICK_STAIRS;
    }

    @Override
    public Supplier<Block> BLOCK_RUSSET_BRICK_SLAB() {
        return ModBlocks.RUSSET_BRICK_SLAB;
    }

    @Override
    public Supplier<Block> BLOCK_RUSSET_BRICK_WALL() {
        return ModBlocks.RUSSET_BRICK_WALL;
    }

    @Override
    public Supplier<Block> BLOCK_CRACKED_RUSSET_BRICKS() {
        return ModBlocks.CRACKED_RUSSET_BRICKS;
    }

    @Override
    public Supplier<Block> BLOCK_CHISELED_RUSSET_BRICKS() {
        return ModBlocks.CHISELED_RUSSET_BRICKS;
    }

    @Override
    public Supplier<Block> BLOCK_SERENE() {
        return ModBlocks.SERENE;
    }

    @Override
    public Supplier<Block> BLOCK_SERENE_STAIRS() {
        return ModBlocks.SERENE_STAIRS;
    }

    @Override
    public Supplier<Block> BLOCK_SERENE_SLAB() {
        return ModBlocks.SERENE_SLAB;
    }

    @Override
    public Supplier<Block> BLOCK_SERENE_WALL() {
        return ModBlocks.SERENE_WALL;
    }

    @Override
    public Supplier<Block> BLOCK_CUT_SERENE() {
        return ModBlocks.CUT_SERENE;
    }

    @Override
    public Supplier<Block> BLOCK_CUT_SERENE_SLAB() {
        return ModBlocks.CUT_SERENE_SLAB;
    }

    @Override
    public Supplier<Block> BLOCK_SMOOTH_SERENE() {
        return ModBlocks.SMOOTH_SERENE;
    }

    @Override
    public Supplier<Block> BLOCK_SMOOTH_SERENE_STAIRS() {
        return ModBlocks.SMOOTH_SERENE_STAIRS;
    }

    @Override
    public Supplier<Block> BLOCK_SMOOTH_SERENE_SLAB() {
        return ModBlocks.SMOOTH_SERENE_SLAB;
    }

    @Override
    public Supplier<Block> BLOCK_CHISELED_SERENE() {
        return ModBlocks.CHISELED_SERENE;
    }

    @Override
    public Supplier<Block> BLOCK_DRYSTONE() {
        return ModBlocks.DRYSTONE;
    }

    @Override
    public Supplier<Block> BLOCK_DRYSTONE_STAIRS() {
        return ModBlocks.DRYSTONE_STAIRS;
    }

    @Override
    public Supplier<Block> BLOCK_DRYSTONE_SLAB() {
        return ModBlocks.DRYSTONE_SLAB;
    }

    @Override
    public Supplier<Block> BLOCK_DRYSTONE_WALL() {
        return ModBlocks.DRYSTONE_WALL;
    }

    @Override
    public Supplier<Block> BLOCK_POLISHED_DRYSTONE() {
        return ModBlocks.POLISHED_DRYSTONE;
    }

    @Override
    public Supplier<Block> BLOCK_POLISHED_DRYSTONE_STAIRS() {
        return ModBlocks.POLISHED_DRYSTONE_STAIRS;
    }

    @Override
    public Supplier<Block> BLOCK_POLISHED_DRYSTONE_SLAB() {
        return ModBlocks.POLISHED_DRYSTONE_SLAB;
    }

    @Override
    public Supplier<Block> BLOCK_CHISELED_DRYSTONE_BRICKS() {
        return ModBlocks.CHISELED_DRYSTONE_BRICKS;
    }

    @Override
    public Supplier<Block> BLOCK_DRYSTONE_BRICKS() {
        return ModBlocks.DRYSTONE_BRICKS;
    }

    @Override
    public Supplier<Block> BLOCK_DRYSTONE_BRICK_STAIRS() {
        return ModBlocks.DRYSTONE_BRICK_STAIRS;
    }

    @Override
    public Supplier<Block> BLOCK_DRYSTONE_BRICK_SLAB() {
        return ModBlocks.DRYSTONE_BRICK_SLAB;
    }

    @Override
    public Supplier<Block> BLOCK_DRYSTONE_BRICK_WALL() {
        return ModBlocks.DRYSTONE_BRICK_WALL;
    }

    @Override
    public Supplier<Block> BLOCK_DRYSTONE_TILES() {
        return ModBlocks.DRYSTONE_TILES;
    }

    @Override
    public Supplier<Block> BLOCK_DRYSTONE_TILE_STAIRS() {
        return ModBlocks.DRYSTONE_TILE_STAIRS;
    }

    @Override
    public Supplier<Block> BLOCK_DRYSTONE_TILE_SLAB() {
        return ModBlocks.DRYSTONE_TILE_SLAB;
    }

    @Override
    public Supplier<Block> BLOCK_LYCE_ORE() {
        return ModBlocks.LYCE_ORE;
    }

    @Override
    public Supplier<Block> BLOCK_LYCE_BLOCK() {
        return ModBlocks.LYCE_BLOCK;
    }

    @Override
    public Supplier<Block> BLOCK_PEBBLE() {
        return ModBlocks.PEBBLE;
    }
}