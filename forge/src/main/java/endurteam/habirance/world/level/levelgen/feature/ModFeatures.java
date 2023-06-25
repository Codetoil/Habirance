package endurteam.habirance.world.level.levelgen.feature;

import endurteam.habirance.Habirance;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;

public class ModFeatures
{
	public static final DeferredRegister<Feature<?>> FEATURES =
			DeferredRegister.create(Registries.FEATURE, Habirance.MOD_ID);


	public static void register(IEventBus eventBus)
	{
		FEATURES.register(eventBus);
	}
}
