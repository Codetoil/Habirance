package endurteam.habirance.world.entity;

import endurteam.habirance.Habirance;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes
{
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Habirance.MOD_ID);

	public static void register(IEventBus eventBus)
	{
		ENTITY_TYPES.register(eventBus);
	}
}
