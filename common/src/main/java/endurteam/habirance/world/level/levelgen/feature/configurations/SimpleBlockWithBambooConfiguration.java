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

package endurteam.habirance.world.level.levelgen.feature.configurations;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public record SimpleBlockWithBambooConfiguration(Float probability, BlockStateProvider toPlace)
        implements FeatureConfiguration
{
    public static final Codec<SimpleBlockWithBambooConfiguration> CODEC = RecordCodecBuilder.create((instance) ->
            instance.group(
                            Codec.floatRange(0.0F, 1.0F).fieldOf("probability")
                                    .forGetter((configuration) -> configuration.probability),
                            BlockStateProvider.CODEC.fieldOf("to_place")
                                    .forGetter((configuration) -> configuration.toPlace))
                    .apply(instance, SimpleBlockWithBambooConfiguration::new));
}
