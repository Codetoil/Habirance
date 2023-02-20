package endurteam.habirance.world.biome;

import endurteam.habirance.Habirance;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.util.Mth;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

public class ModBiomes
{
	public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, Habirance.MOD_ID);

	private static @NotNull MobSpawnSettings.Builder createBuilderWithDefaultSpawns()
	{
		MobSpawnSettings.Builder builder = new MobSpawnSettings.Builder();
		BiomeDefaultFeatures.commonSpawns(builder);
		return builder;
	}

	@SuppressWarnings("SameParameterValue")
	private static int calculateSkyColor(float temperature)
	{
		float $$1 = temperature / 3.0F;
		$$1 = Mth.clamp($$1, -1.0F, 1.0F);
		return Mth.hsvToRgb(0.62222224F - $$1 * 0.05F, 0.5F + $$1 * 0.1F, 1.0F);
	}

	public static void register(IEventBus eventBus)
	{
		BIOMES.register(eventBus);
	}

}
