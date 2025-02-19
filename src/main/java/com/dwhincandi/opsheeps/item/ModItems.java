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
    public static final Item SUPER_SHEARv1 = registerItem("super_shearv1", new Item(new Item.Settings()));
    public static final Item SUPER_SHEARv2 = registerItem("super_shearv2", new Item(new Item.Settings()));
    public static final Item SUPER_SHEARv3 = registerItem("super_shearv3", new Item(new Item.Settings()));
    public static final Item SUPER_SHEARv4 = registerItem("super_shearv4", new Item(new Item.Settings()));
    public static final Item SUPER_SHEARv5 = registerItem("super_shearv5", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        Opsheeps.LOGGER.info("Registering item: " + name);
        return Registry.register(Registries.ITEM, Identifier.of(Opsheeps.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Opsheeps.LOGGER.info("Registering Mod Items for " + Opsheeps.MOD_ID);
    }
}
