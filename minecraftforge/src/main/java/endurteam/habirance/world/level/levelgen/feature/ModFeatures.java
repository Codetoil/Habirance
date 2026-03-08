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

package endurteam.habirance.world.level.levelgen.feature;

import endurteam.habirance.Habirance;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;

import static endurteam.habirance.Constants.MOD_ID;

public class ModFeatures
{
	public static final DeferredRegister<Feature<?>> FEATURES =
			DeferredRegister.create(Registries.FEATURE, MOD_ID);


	public static void register(IEventBus eventBus)
	{
		FEATURES.register(eventBus);
	}
}
