package endurteam.habirance.world.biome;

import endurteam.habirance.Habirance;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class ModBiomes
{

	public static final ResourceKey<Biome> TROPICAL_CAVE = register("tropical_cave");


	private static ResourceKey<Biome> register(String name) {
		return ResourceKey.create(Registries.BIOME, new ResourceLocation(Habirance.MOD_ID, name));
	}
}
