package endurteam.habirance;

import com.mojang.logging.LogUtils;
import endurteam.habirance.block.ModBlocks;
import endurteam.habirance.entity.ModEntityTypes;
import endurteam.habirance.item.ModItems;
import endurteam.habirance.world.biome.ModBiomes;
import endurteam.habirance.world.level.levelgen.feature.ModConfiguredFeatures;
import endurteam.habirance.world.level.levelgen.feature.ModPlacedFeatures;
import endurteam.habirance.world.biome.TropicalCaveRegion;
import endurteam.habirance.world.level.levelgen.feature.ModFeatures;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import terrablender.api.RegionType;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Habirance.MOD_ID)
public class Habirance
{
    public static final String MOD_ID = "habirance";

    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();


    public Habirance()
    {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModBlocks.register(eventBus);
        ModItems.register(eventBus);
        ModEntityTypes.register(eventBus);
        ModConfiguredFeatures.register(eventBus);
        ModPlacedFeatures.register(eventBus);
        ModFeatures.register(eventBus);
        ModBiomes.register(eventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            Regions.register(new TropicalCaveRegion(new ResourceLocation(MOD_ID, "tropical_cave_region"), RegionType.OVERWORLD, 2));

            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, SurfaceRules.sequence());
        });
    }
}
