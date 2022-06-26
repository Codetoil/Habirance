package inferioraccretionteam.inferioraccretion.world.feature;

import inferioraccretionteam.inferioraccretion.InferiorAccretion;
import inferioraccretionteam.inferioraccretion.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.features.CaveFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.VegetationPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
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
            () -> new ConfiguredFeature<>(Feature.ORE,new OreConfiguration(
                    List.of(
                            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.ALABASTER.get().defaultBlockState())
                    ),16)));

    @SuppressWarnings("unused")
    public static final RegistryObject<ConfiguredFeature<?,?>> SERENE = CONFIGURED_FEATURES.register("serene",
            () -> new ConfiguredFeature<>(Feature.ORE,new OreConfiguration(
                    List.of(
                            OreConfiguration.target(new BlockMatchTest(Blocks.SANDSTONE), ModBlocks.SERENE.get().defaultBlockState())
                    ),16)));

    @SuppressWarnings("unused")
    public static final RegistryObject<ConfiguredFeature<?,?>> DRYSTONE = CONFIGURED_FEATURES.register("drystone",
            () -> new ConfiguredFeature<>(Feature.ORE,new OreConfiguration(
                    List.of(
                            OreConfiguration.target(new BlockMatchTest(Blocks.RED_TERRACOTTA), ModBlocks.DRYSTONE.get().defaultBlockState())
                    ),34)));

    @SuppressWarnings("unused")
    public static final RegistryObject<ConfiguredFeature<?,?>> LIMESTONE = CONFIGURED_FEATURES.register("limestone",
            () -> new ConfiguredFeature<>(Feature.ORE,new OreConfiguration(
                    List.of(
                            OreConfiguration.target(OreFeatures.NATURAL_STONE, ModBlocks.LIMESTONE.get().defaultBlockState())
                    ),34)));

    @SuppressWarnings("unused")
    public static final RegistryObject<ConfiguredFeature<?,?>> TROPICAL_MOSS_PATCH = CONFIGURED_FEATURES.register("tropical_moss_patch",
            () -> new ConfiguredFeature<>(Feature.VEGETATION_PATCH, new VegetationPatchConfiguration(
                    BlockTags.MOSS_REPLACEABLE,
                    BlockStateProvider.simple(Blocks.MOSS_BLOCK),
                    PlacementUtils.inlinePlaced(CaveFeatures.MOSS_VEGETATION),
                    CaveSurface.FLOOR,
                    ConstantInt.of(1), 0.0F, 5, 0.8F, UniformInt.of(4, 7), 0.3F)));



    public static void register(IEventBus eventBus){
        CONFIGURED_FEATURES.register(eventBus);
    }
}
