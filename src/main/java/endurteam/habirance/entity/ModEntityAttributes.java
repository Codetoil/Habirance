package endurteam.habirance.entity;

import endurteam.habirance.Habirance;
import endurteam.habirance.entity.custom.UndeadHog;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static endurteam.habirance.Habirance.LOGGER;

@Mod.EventBusSubscriber(modid = Habirance.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntityAttributes {

    @SubscribeEvent
    public static void registerAttribute(EntityAttributeCreationEvent event){
        LOGGER.debug("Registering Entity Attributes...");
        event.put(ModEntityTypes.UNDEAD_HOG.get(), UndeadHog.setAttributes());

    }
}
