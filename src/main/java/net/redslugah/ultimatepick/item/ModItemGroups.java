package net.redslugah.ultimatepick.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.redslugah.ultimatepick.UltimatePick;
import net.redslugah.ultimatepick.block.ModBlocks;

public class ModItemGroups {

    public static final ItemGroup ULTIMATE_PICK_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(UltimatePick.MOD_ID, "ultimate_pick_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.ULTIMATE_GEM))
                    .displayName(Text.translatable("itemgroup.ultimatepick.ultimate_pick_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.RAW_ULTIMATE_GEM);
                        entries.add(ModItems.ULTIMATE_GEM);
                        entries.add(ModItems.CHISEL);
                        entries.add(ModItems.GOLDEN_CHICKEN);
                    }).build());

    public static final ItemGroup ULTIMATE_PICK_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(UltimatePick.MOD_ID, "ultimate_pick_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.ULTIMATE_GEM))
                    .displayName(Text.translatable("itemgroup.ultimatepick.ultimate_pick_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.RAW_ULTIMATE_GEM_BLOCK);
                        entries.add(ModBlocks.ULTIMATE_GEM_BLOCK);
                        entries.add(ModBlocks.ULTIMATE_GEM_ORE);
                        entries.add(ModBlocks.ULTIMATE_GEM_DEEPSLATE_ORE);
                        entries.add(ModBlocks.MAGIC_BLOCK);
                    }).build());


    public static void registerItemGroups(){

        UltimatePick.LOGGER.info("Registering Item Groups for " + UltimatePick.MOD_ID);
    }
}
