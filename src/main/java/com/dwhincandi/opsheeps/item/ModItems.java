package com.dwhincandi.opsheeps.item;

import com.dwhincandi.opsheeps.Opsheeps;
import com.dwhincandi.opsheeps.item.custom.SuperDyeItem;
import com.dwhincandi.opsheeps.item.custom.SuperShearItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item SUPER_DYE = registerItem("super_dye", new SuperDyeItem(new Item.Settings()));
    public static final Item SUPER_SHEAR_V1 = registerItem("super_shear_v1", new SuperShearItem(new Item.Settings().maxDamage(-1), 2));
    public static final Item SUPER_SHEAR_V2 = registerItem("super_shear_v2", new SuperShearItem(new Item.Settings().maxDamage(-1), 5));
    public static final Item SUPER_SHEAR_V3 = registerItem("super_shear_v3", new SuperShearItem(new Item.Settings().maxDamage(-1), 10));
    public static final Item SUPER_SHEAR_V4 = registerItem("super_shear_v4", new SuperShearItem(new Item.Settings().maxDamage(-1), 30));
    public static final Item SUPER_SHEAR_V5 = registerItem("super_shear_v5", new SuperShearItem(new Item.Settings().maxDamage(-1), 100));
    public static final Item SUPER_SHEAR_V69 = registerItem("super_shear_v69", new SuperShearItem(new Item.Settings().maxDamage(-1), 250));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Opsheeps.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Opsheeps.LOGGER.info("Registering Mod Items for " + Opsheeps.MOD_ID);
    }
}
