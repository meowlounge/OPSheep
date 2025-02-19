package com.dwhincandi.opsheeps.item;

import com.dwhincandi.opsheeps.Opsheeps;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
//d
public class ModItems {

    public static final Item SUPER_DYE = registerItem("super_dye", new Item(new Item.Settings()));
    public static final Item SUPER_SHEAR_V1 = registerItem("super_shear_v1", new Item(new Item.Settings()));
    public static final Item SUPER_SHEAR_V2 = registerItem("super_shear_v2", new Item(new Item.Settings()));
    public static final Item SUPER_SHEAR_V3 = registerItem("super_shear_v3", new Item(new Item.Settings()));
    public static final Item SUPER_SHEAR_V4 = registerItem("super_shear_v4", new Item(new Item.Settings()));
    public static final Item SUPER_SHEAR_V5 = registerItem("super_shear_v5", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        Opsheeps.LOGGER.info("Registering item: " + name);
        return Registry.register(Registries.ITEM, Identifier.of(Opsheeps.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Opsheeps.LOGGER.info("Registering Mod Items for " + Opsheeps.MOD_ID);
    }
}
