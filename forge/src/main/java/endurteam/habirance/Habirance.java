package endurteam.habirance;

import com.mojang.logging.LogUtils;
import endurteam.habirance.world.entity.ModEntityTypes;
import endurteam.habirance.world.item.ModItems;
import endurteam.habirance.world.biome.ModBiomes;
import endurteam.habirance.world.level.block.ModBlocks;
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
		ModFeatures.register(eventBus);

		// Register ourselves for server and other game events we are interested in
		MinecraftForge.EVENT_BUS.register(this);
	}

	private void setup(final FMLCommonSetupEvent event)
	{
		event.enqueueWork(() -> {
			SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, SurfaceRules.sequence());
		});
	}
}
