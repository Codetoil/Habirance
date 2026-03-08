/**
 *     Habirance
 *     Copyright (C) 2022-2026  Team Endur
 *
 *     This file is part of Habirance
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package endurteam.habirance.world.biome;

import com.mojang.datafixers.util.Pair;
import endurteam.habirance.platform.Services;
import net.minecraft.SharedConstants;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.OverworldBiomeBuilder;
import terrablender.api.ParameterUtils;

import java.util.List;
import java.util.function.Consumer;

public class TropicalCaveBiomeBuilder extends OverworldBiomeBuilder
{
	@Override
    protected void addBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper)
	{
		super.addBiomes(mapper);
		List<Climate.ParameterPoint> tropicalCavePoints = new ParameterUtils.ParameterPointListBuilder()
				.temperature(ParameterUtils.Temperature.WARM)
				.humidity(ParameterUtils.Humidity.HUMID, ParameterUtils.Humidity.NEUTRAL, ParameterUtils.Humidity.WET)
				.continentalness(
						ParameterUtils.Continentalness.span(ParameterUtils.Continentalness.NEAR_INLAND,
								ParameterUtils.Continentalness.FAR_INLAND))
				.erosion(ParameterUtils.Erosion.FULL_RANGE)
				.depth(Climate.Parameter.span(0.7f, 1.0f))
				.weirdness(ParameterUtils.Weirdness.FULL_RANGE)
				.offset(0L)
				.build();
		if (!SharedConstants.debugGenerateSquareTerrainWithoutNoise) {
			tropicalCavePoints.forEach((point) -> mapper.accept(Pair.of(point,
					Services.PLATFORM.BIOME_TROPICAL_CAVE())));
		}
	}
}
