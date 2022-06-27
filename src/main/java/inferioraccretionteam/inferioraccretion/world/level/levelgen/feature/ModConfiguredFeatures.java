package inferioraccretionteam.inferioraccretion.world.level.levelgen.feature;

import inferioraccretionteam.inferioraccretion.InferiorAccretion;
import inferioraccretionteam.inferioraccretion.block.ModBlocks;
import inferioraccretionteam.inferioraccretion.world.level.levelgen.feature.configurations.CaveCoverConfiguration;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.features.CaveFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ClampedNormalInt;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.VegetationPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModConfiguredFeatures {

    public static final DeferredRegister<ConfiguredFeature<?,?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, InferiorAccretion.MOD_ID);



    //TODO: should spawn next to deepslate diamond instead, improvement needed
    @SuppressWarnings("unused")
    public static final RegistryObject<ConfiguredFeature<?,?>> ALABASTER = CONFIGURED_FEATURES.register("alabaster",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(
                    List.of(
                            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.ALABASTER.get().defaultBlockState())
                    ),16)));

    @SuppressWarnings("unused")
    public static final RegistryObject<ConfiguredFeature<?,?>> SERENE = CONFIGURED_FEATURES.register("serene",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(
                    List.of(
                            OreConfiguration.target(new BlockMatchTest(Blocks.SANDSTONE), ModBlocks.SERENE.get().defaultBlockState())
                    ),16)));

    @SuppressWarnings("unused")
    public static final RegistryObject<ConfiguredFeature<?,?>> DRYSTONE = CONFIGURED_FEATURES.register("drystone",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(
                    List.of(
                            OreConfiguration.target(new BlockMatchTest(Blocks.RED_TERRACOTTA), ModBlocks.DRYSTONE.get().defaultBlockState())
                    ),34)));

    @SuppressWarnings("unused")
    public static final RegistryObject<ConfiguredFeature<?,?>> LIMESTONE_CAVE_COVER = CONFIGURED_FEATURES.register("limestone",
            () -> new ConfiguredFeature<>(ModFeatures.CAVE_COVER.get(), new CaveCoverConfiguration(
                    ModBlocks.LIMESTONE.get().defaultBlockState(), ClampedNormalInt.of(12.0f, 3.0f, 8, 16))));


    public static final RegistryObject<ConfiguredFeature<?,?>> TROPICAL_MOSS_VEGETATION = CONFIGURED_FEATURES.register("tropical_moss_vegetation",
            () -> new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
                    new WeightedStateProvider(
                            SimpleWeightedRandomList.<BlockState>builder()
                                    .add(Blocks.MOSS_CARPET.defaultBlockState(), 22)
                                    .add(Blocks.GRASS.defaultBlockState(), 44)
                                    .add(Blocks.TALL_GRASS.defaultBlockState(), 8)
                                    .add(Blocks.BAMBOO_SAPLING.defaultBlockState(), 10)))));

    @SuppressWarnings("unused")
    public static final RegistryObject<ConfiguredFeature<?,?>> TROPICAL_MOSS_PATCH = CONFIGURED_FEATURES.register("tropical_moss_patch",
            () -> new ConfiguredFeature<>(Feature.VEGETATION_PATCH, new VegetationPatchConfiguration(
                    BlockTags.MOSS_REPLACEABLE,
                    BlockStateProvider.simple(Blocks.MOSS_BLOCK),
                    PlacementUtils.inlinePlaced(ModConfiguredFeatures.TROPICAL_MOSS_VEGETATION.getHolder().get()),
                    CaveSurface.FLOOR,
                    ConstantInt.of(1), 0.0F, 5, 0.8F, UniformInt.of(4, 7), 0.3F)));

    /*
    public static final RegistryObject<ConfiguredFeature<?,?>> TROPICAL_BAMBOO = CONFIGURED_FEATURES.register("tropical_bamboo",
            () -> new ConfiguredFeature<>(Feature.BAMBOO, new ProbabilityFeatureConfiguration(0.0F)));
    */


    public static void register(IEventBus eventBus){
        CONFIGURED_FEATURES.register(eventBus);
    }
}
