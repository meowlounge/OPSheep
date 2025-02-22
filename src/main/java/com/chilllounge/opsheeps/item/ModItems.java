package com.chilllounge.opsheeps.item;

import com.chilllounge.opsheeps.Opsheeps;
import com.chilllounge.opsheeps.item.custom.SuperDyeItem;
import com.chilllounge.opsheeps.item.custom.SuperShearItem;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.LoreComponent;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.List;

public class ModItems {
    public static final Item SUPER_DYE = registerItem("super_dye", new SuperDyeItem(new Item.Settings()
            .maxCount(99)
            .component(DataComponentTypes.LORE, new LoreComponent(List.of(
                    Text.literal("Whisper its secret to a sheep, and witness the impossible.")
                            .setStyle(Style.EMPTY.withColor(Formatting.DARK_PURPLE).withItalic(true))
            ))))
    );
    public static final Item SUPER_SHEAR_V1 = registerItem("super_shear_v1",
            new SuperShearItem(
                    (new Item.Settings()
                            .maxDamage(64)
                            .rarity(Rarity.COMMON)
                            .component(DataComponentTypes.LORE, new LoreComponent(List.of(
                                    Text.literal("A simple, yet effective shear.").setStyle(Style.EMPTY.withColor(Formatting.GRAY)),
                                    Text.literal("Shearing an OP Sheep drops ").setStyle(Style.EMPTY)
                                            .append(Text.literal("2").setStyle(Style.EMPTY.withColor(Formatting.LIGHT_PURPLE).withBold(true)))
                                            .append(" items.")
                            )))
                    ),
                    2, 1
            )
    );
    public static final Item SUPER_SHEAR_V2 = registerItem("super_shear_v2",
            new SuperShearItem(
                    (new Item.Settings()
                            .maxDamage(128)
                            .rarity(Rarity.COMMON)
                            .component(DataComponentTypes.LORE, new LoreComponent(List.of(
                                    Text.literal("Sharper and more durable.").setStyle(Style.EMPTY.withColor(Formatting.YELLOW)),
                                    Text.literal("Shearing an OP Sheep drops ").setStyle(Style.EMPTY)
                                            .append(Text.literal("5").setStyle(Style.EMPTY.withColor(Formatting.LIGHT_PURPLE).withBold(true)))
                                            .append(" items.")
                            )))
                    ),
                    5, 2
            )
    );
    public static final Item SUPER_SHEAR_V3 = registerItem("super_shear_v3",
            new SuperShearItem(
                    (new Item.Settings()
                            .maxDamage(256)
                            .rarity(Rarity.UNCOMMON)
                            .component(DataComponentTypes.LORE, new LoreComponent(List.of(
                                    Text.literal("Forged by skilled artisans.").setStyle(Style.EMPTY.withColor(Formatting.GREEN)),
                                    Text.literal("Shearing an OP Sheep drops ").setStyle(Style.EMPTY)
                                            .append(Text.literal("10").setStyle(Style.EMPTY.withColor(Formatting.LIGHT_PURPLE).withBold(true)))
                                            .append(" items.")
                            )))
                    ),
                    10, 3
            )
    );
    public static final Item SUPER_SHEAR_V4 = registerItem("super_shear_v4",
            new SuperShearItem(
                    (new Item.Settings()
                            .maxDamage(512)
                            .rarity(Rarity.UNCOMMON)
                            .component(DataComponentTypes.LORE, new LoreComponent(List.of(
                                    Text.literal("Infused with arcane energy.").setStyle(Style.EMPTY.withColor(Formatting.BLUE)),
                                    Text.literal("Shearing an OP Sheep drops ").setStyle(Style.EMPTY)
                                            .append(Text.literal("30").setStyle(Style.EMPTY.withColor(Formatting.LIGHT_PURPLE).withBold(true)))
                                            .append(" items.")
                            )))
                    ),
                    30, 4
            )
    );
    public static final Item SUPER_SHEAR_V5 = registerItem("super_shear_v5",
            new SuperShearItem(
                    (new Item.Settings()
                            .maxDamage(1024)
                            .rarity(Rarity.EPIC)
                            .component(DataComponentTypes.LORE, new LoreComponent(List.of(
                                    Text.literal("A legendary tool of the Shear Masters.").setStyle(Style.EMPTY.withColor(Formatting.DARK_PURPLE)),
                                    Text.literal("Shearing an OP Sheep drops ").setStyle(Style.EMPTY)
                                            .append(Text.literal("100").setStyle(Style.EMPTY.withColor(Formatting.LIGHT_PURPLE).withBold(true)))
                                            .append(" items.")
                            )))
                    ),
                    100, 5
            )
    );
    public static final Item SUPER_SHEAR_V69 = registerItem("super_shear_v69",
            new SuperShearItem(
                    (new Item.Settings()
                            .maxDamage(-1)
                            .rarity(Rarity.EPIC)
                            .component(DataComponentTypes.LORE, new LoreComponent(List.of(
                                    Text.literal("DEVELOPER ITEM").setStyle(Style.EMPTY.withColor(Formatting.RED)),
                                    Text.literal("Shearing an OP Sheep drops ").setStyle(Style.EMPTY)
                                            .append(Text.literal("250").setStyle(Style.EMPTY.withColor(Formatting.LIGHT_PURPLE).withBold(true)))
                                            .append(" items.")
                            )))
                    ),
                    250, 69
            )
    );
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Opsheeps.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Opsheeps.LOGGER.info("Registering Mod Items for " + Opsheeps.MOD_ID);
    }
}
