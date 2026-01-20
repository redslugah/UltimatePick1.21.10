package net.redslugah.ultimatepick.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipData;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.redslugah.ultimatepick.UltimatePick;
import net.redslugah.ultimatepick.item.custom.ChiselItem;

import java.util.Optional;
import java.util.function.Consumer;

public class ModItems {

//    public static final Item ULTIMATE_GEM = registerItem("ultimate_gem");
    public static final Item RAW_ULTIMATE_GEM = registerItem("raw_ultimate_gem", new Item(new Item.Settings()
        .registryKey(RegistryKey.of(RegistryKeys.ITEM,Identifier.of(UltimatePick.MOD_ID,"raw_ultimate_gem")))));

    public static final Item ULTIMATE_GEM = registerItem("ultimate_gem", new Item(new Item.Settings().
            registryKey(RegistryKey.of(RegistryKeys.ITEM,Identifier.of(UltimatePick.MOD_ID,"ultimate_gem")))));

    public static final Item CHISEL = registerItem("chisel", new ChiselItem(new Item.Settings().maxDamage(32).
            registryKey(RegistryKey.of(RegistryKeys.ITEM,Identifier.of(UltimatePick.MOD_ID,"chisel")))));

    public static final Item GOLDEN_CHICKEN = registerItem("golden_chicken", new Item(new Item.Settings().food(ModFoodComponents.GOLDEN_CHICKEN).
            registryKey(RegistryKey.of(RegistryKeys.ITEM,Identifier.of(UltimatePick.MOD_ID, "golden_chicken")))));


    private static Item registerItem(String name, Item item){
//        Identifier id = Identifier.of(UltimatePick.MOD_ID, name);
//        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM,id);
//        Item.Settings settings = new Item.Settings().registryKey(key);
//        return Registry.register(Registries.ITEM, key, new Item(settings));
        return Registry.register(Registries.ITEM, Identifier.of(UltimatePick.MOD_ID, name), item);
    }

    public static void registerModItems(){
        UltimatePick.LOGGER.info("Registering Mod Items for " + UltimatePick.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ULTIMATE_GEM);
            fabricItemGroupEntries.add(RAW_ULTIMATE_GEM);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(GOLDEN_CHICKEN);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(CHISEL);
        });
    }
}