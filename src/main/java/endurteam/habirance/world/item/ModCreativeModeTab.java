package endurteam.habirance.world.item;

import endurteam.habirance.Habirance;
import endurteam.habirance.world.level.block.ModBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

@Mod.EventBusSubscriber(modid = Habirance.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTab
{
    @SubscribeEvent
    public static void buildContents(CreativeModeTabEvent.@NotNull Register event)
    {
		event.registerCreativeModeTab(new ResourceLocation(Habirance.MOD_ID, "tab"), builder ->
				builder.title(Component.translatable("item_group." + Habirance.MOD_ID + ".tab"))
					.icon(() -> new ItemStack(ModBlocks.LIMESTONE.get()))
					.displayItems((pEnabledFeatures, pOutput, pDisplayOperatorCreativeTab) -> {
						pOutput.accept(ModBlocks.LIMESTONE.get());
						pOutput.accept(ModBlocks.LIMESTONE_STAIRS.get());
						pOutput.accept(ModBlocks.LIMESTONE_SLAB.get());
						pOutput.accept(ModBlocks.LIMESTONE_WALL.get());
						pOutput.accept(ModBlocks.POLISHED_LIMESTONE.get());
						pOutput.accept(ModBlocks.POLISHED_LIMESTONE_STAIRS.get());
						pOutput.accept(ModBlocks.POLISHED_LIMESTONE_SLAB.get());
						pOutput.accept(ModBlocks.LYCE_ORE.get());
						pOutput.accept(ModBlocks.BLOCK_OF_LYCE.get());
						pOutput.accept(ModItems.LYCE.get());
						pOutput.accept(ModBlocks.PEBBLE.get());
					}));
    }
}
