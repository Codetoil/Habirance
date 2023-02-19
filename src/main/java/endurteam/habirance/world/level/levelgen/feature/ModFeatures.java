package endurteam.habirance.world.level.levelgen.feature;

import endurteam.habirance.Habirance;
import endurteam.habirance.world.level.levelgen.feature.configurations.CaveCoverConfiguration;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModFeatures
{
	public static final DeferredRegister<Feature<?>> FEATURES =
			DeferredRegister.create(Registries.FEATURE, Habirance.MOD_ID);


	public static final RegistryObject<Feature<CaveCoverConfiguration>> CAVE_COVER = FEATURES.register("cave_cover", () ->
			new CaveCoverFeature(CaveCoverConfiguration.CODEC));


	public static void register(IEventBus eventBus)
	{
		FEATURES.register(eventBus);
	}
}
