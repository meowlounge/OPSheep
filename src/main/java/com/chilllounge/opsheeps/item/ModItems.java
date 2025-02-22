package com.chilllounge.opsheeps.item;

import com.chilllounge.opsheeps.Opsheeps;
import com.chilllounge.opsheeps.item.custom.SuperDyeItem;
import com.chilllounge.opsheeps.item.custom.SuperShearItem;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.LoreComponent;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.List;

public class ModItems {
    public static final RegistryKey<Item> SUPER_DYE_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Opsheeps.MOD_ID, "super_dye"));
    public static final RegistryKey<Item> SUPER_SHEAR_V1_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Opsheeps.MOD_ID, "super_shear_v1"));
    public static final RegistryKey<Item> SUPER_SHEAR_V2_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Opsheeps.MOD_ID, "super_shear_v2"));
    public static final RegistryKey<Item> SUPER_SHEAR_V3_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Opsheeps.MOD_ID, "super_shear_v3"));
    public static final RegistryKey<Item> SUPER_SHEAR_V4_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Opsheeps.MOD_ID, "super_shear_v4"));
    public static final RegistryKey<Item> SUPER_SHEAR_V5_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Opsheeps.MOD_ID, "super_shear_v5"));
    public static final RegistryKey<Item> SUPER_SHEAR_V69_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Opsheeps.MOD_ID, "super_shear_v69"));

    public static final Item SUPER_DYE = registerItem(SUPER_DYE_KEY, new SuperDyeItem(new Item.Settings()
            .maxCount(99)
            .registryKey(SUPER_DYE_KEY)
            .component(DataComponentTypes.LORE, new LoreComponent(List.of(
                    Text.literal("Whisper its secret to a sheep, and witness the impossible.")
                            .setStyle(Style.EMPTY.withColor(Formatting.DARK_PURPLE).withItalic(true))
            ))))
    );
    public static final Item SUPER_SHEAR_V1 = registerItem(SUPER_SHEAR_V1_KEY, new SuperShearItem(
            new Item.Settings()
                    .maxDamage(64)
                    .rarity(Rarity.COMMON)
                    .registryKey(SUPER_SHEAR_V1_KEY)
                    .component(DataComponentTypes.LORE, new LoreComponent(List.of(
                            Text.literal("A simple, yet effective shear.").setStyle(Style.EMPTY.withColor(Formatting.GRAY)),
                            Text.literal("Shearing an OP Sheep drops ").setStyle(Style.EMPTY)
                                    .append(Text.literal("2").setStyle(Style.EMPTY.withColor(Formatting.LIGHT_PURPLE).withBold(true)))
                                    .append(" items.")
                    ))),
            2, 1
    ));

    public static final Item SUPER_SHEAR_V2 = registerItem(SUPER_SHEAR_V2_KEY, new SuperShearItem(
            new Item.Settings()
                    .maxDamage(128)
                    .rarity(Rarity.COMMON)
                    .registryKey(SUPER_SHEAR_V2_KEY)
                    .component(DataComponentTypes.LORE, new LoreComponent(List.of(
                            Text.literal("Sharper and more durable.").setStyle(Style.EMPTY.withColor(Formatting.YELLOW)),
                            Text.literal("Shearing an OP Sheep drops ").setStyle(Style.EMPTY)
                                    .append(Text.literal("5").setStyle(Style.EMPTY.withColor(Formatting.LIGHT_PURPLE).withBold(true)))
                                    .append(" items.")
                    ))),
            5, 2
    ));
    public static final Item SUPER_SHEAR_V3 = registerItem(SUPER_SHEAR_V3_KEY, new SuperShearItem(
            new Item.Settings()
                    .maxDamage(256)
                    .rarity(Rarity.UNCOMMON)
                    .registryKey(SUPER_SHEAR_V3_KEY)
                    .component(DataComponentTypes.LORE, new LoreComponent(List.of(
                            Text.literal("Forged by skilled artisans.").setStyle(Style.EMPTY.withColor(Formatting.GREEN)),
                            Text.literal("Shearing an OP Sheep drops ").setStyle(Style.EMPTY)
                                    .append(Text.literal("10").setStyle(Style.EMPTY.withColor(Formatting.LIGHT_PURPLE).withBold(true)))
                                    .append(" items.")
                    ))),
            10, 3
    ));
    public static final Item SUPER_SHEAR_V4 = registerItem(SUPER_SHEAR_V4_KEY, new SuperShearItem(
            new Item.Settings()
                    .maxDamage(512)
                    .rarity(Rarity.UNCOMMON)
                    .registryKey(SUPER_SHEAR_V4_KEY)
                    .component(DataComponentTypes.LORE, new LoreComponent(List.of(
                            Text.literal("Infused with arcane energy.").setStyle(Style.EMPTY.withColor(Formatting.BLUE)),
                            Text.literal("Shearing an OP Sheep drops ").setStyle(Style.EMPTY)
                                    .append(Text.literal("30").setStyle(Style.EMPTY.withColor(Formatting.LIGHT_PURPLE).withBold(true)))
                                    .append(" items.")
                    ))),
            30, 4
    ));
    public static final Item SUPER_SHEAR_V5 = registerItem(SUPER_SHEAR_V5_KEY, new SuperShearItem(
            new Item.Settings()
                    .maxDamage(1024)
                    .rarity(Rarity.EPIC)
                    .registryKey(SUPER_SHEAR_V5_KEY)
                    .component(DataComponentTypes.LORE, new LoreComponent(List.of(
                            Text.literal("A legendary tool of the Shear Masters.").setStyle(Style.EMPTY.withColor(Formatting.DARK_PURPLE)),
                            Text.literal("Shearing an OP Sheep drops ").setStyle(Style.EMPTY)
                                    .append(Text.literal("100").setStyle(Style.EMPTY.withColor(Formatting.LIGHT_PURPLE).withBold(true)))
                                    .append(" items.")
                    ))),
            100, 5
    ));
    public static final Item SUPER_SHEAR_V69 = registerItem(SUPER_SHEAR_V69_KEY, new SuperShearItem(
            new Item.Settings()
                    .maxDamage(-1)
                    .rarity(Rarity.EPIC)
                    .registryKey(SUPER_SHEAR_V69_KEY)
                    .component(DataComponentTypes.LORE, new LoreComponent(List.of(
                            Text.literal("DEVELOPER ITEM").setStyle(Style.EMPTY.withColor(Formatting.RED)),
                            Text.literal("Shearing an OP Sheep drops ").setStyle(Style.EMPTY)
                                    .append(Text.literal("250").setStyle(Style.EMPTY.withColor(Formatting.LIGHT_PURPLE).withBold(true)))
                                    .append(" items.")
                    ))),
            250, 69
    ));

    private static Item registerItem(RegistryKey<Item> key, Item item) {
        return Registry.register(Registries.ITEM, key.getValue(), item);
    }

    public static void registerModItems() {
        Opsheeps.LOGGER.info("Registering Mod Items for " + Opsheeps.MOD_ID);
    }
}
