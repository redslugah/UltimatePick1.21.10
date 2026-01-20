package net.redslugah.ultimatepick;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.item.Item;
import net.minecraft.text.Text;
import net.redslugah.ultimatepick.block.ModBlocks;
import net.redslugah.ultimatepick.item.ModItemGroups;
import net.redslugah.ultimatepick.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UltimatePick implements ModInitializer {
	public static final String MOD_ID = "ultimatepick";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItemGroups.registerItemGroups();
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ItemTooltipCallback.EVENT.register(((itemStack, tooltipContext, tooltipType, list) -> {
            if(itemStack.isOf(ModItems.GOLDEN_CHICKEN)){
                list.add(Text.translatable("tooltip.ultimatepick.golden_chicken.tooltip"));
            }
        }));
		LOGGER.info("Hello Fabric world!");
	}
}