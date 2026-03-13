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

package endurteam.habirance;

import com.mojang.logging.LogUtils;
import endurteam.habirance.world.biome.TropicalCaveRegion;
import endurteam.habirance.world.item.ModItems;
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

import static endurteam.habirance.Constants.MOD_ID;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MOD_ID)
public class Habirance
{
	// Directly reference a slf4j logger
	public static final Logger LOGGER = LogUtils.getLogger();


	public Habirance(FMLJavaModLoadingContext modLoadingContext)
	{
		// Register the setup method for modloading
		modLoadingContext.getModEventBus().addListener(this::setup);

		IEventBus eventBus = modLoadingContext.getModEventBus();

		ModBlocks.register(eventBus);
		ModItems.register(eventBus);
		ModFeatures.register(eventBus);

		// Register ourselves for server and other game events we are interested in
		MinecraftForge.EVENT_BUS.register(this);

		CommonClass.construction();
	}

	private void setup(final FMLCommonSetupEvent event)
	{
		event.enqueueWork(() -> {
			Regions.register(new TropicalCaveRegion(
					ResourceLocation.fromNamespaceAndPath(MOD_ID, "tropical_cave_region"),
					RegionType.OVERWORLD, 2));
			SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID,
					SurfaceRules.state(ModBlocks.LIMESTONE.get().defaultBlockState()));
		});
		CommonClass.setup();
	}
}
