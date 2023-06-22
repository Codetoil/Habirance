package endurteam.habirance.world.entity.ai.attributes;

import endurteam.habirance.Habirance;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Habirance.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntityAttributes
{

	@SubscribeEvent
	public static void registerAttribute(EntityAttributeCreationEvent event)
	{
	}
}
