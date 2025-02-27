package com.chilllounge.opsheeps.item;

import com.chilllounge.opsheeps.Opsheeps;
import com.chilllounge.opsheeps.item.custom.GrowBackItem;
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

import java.util.List;

public class OpSheepsItems {
	public static final RegistryKey<Item> SUPER_DYE_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Opsheeps.MOD_ID, "super_dye"));
	public static final RegistryKey<Item> SUPER_SHEAR_V1_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Opsheeps.MOD_ID, "super_shear_v1"));
	public static final RegistryKey<Item> SUPER_SHEAR_V2_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Opsheeps.MOD_ID, "super_shear_v2"));
	public static final RegistryKey<Item> SUPER_SHEAR_V3_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Opsheeps.MOD_ID, "super_shear_v3"));
	public static final RegistryKey<Item> SUPER_SHEAR_V4_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Opsheeps.MOD_ID, "super_shear_v4"));
	public static final RegistryKey<Item> SUPER_SHEAR_V5_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Opsheeps.MOD_ID, "super_shear_v5"));
	public static final RegistryKey<Item> SUPER_SHEAR_V69_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Opsheeps.MOD_ID, "super_shear_v69"));
	public static final RegistryKey<Item> GROW_BACK_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Opsheeps.MOD_ID, "grow_back"));

	public static final Item SUPER_DYE = registerItem(SUPER_DYE_KEY, new SuperDyeItem(new Item.Settings()
			.maxCount(1)
			.registryKey(SUPER_DYE_KEY)
			.component(DataComponentTypes.CUSTOM_NAME, Text.translatable("item.opsheeps.super_dye").setStyle(Style.EMPTY.withColor(Formatting.WHITE).withBold(true).withItalic(false)))
			.component(DataComponentTypes.LORE, new LoreComponent(List.of(Text.translatable("item.opsheeps.super_dye_description").setStyle(Style.EMPTY.withColor(Formatting.GRAY))))))
	);
	public static final Item SUPER_SHEAR_V1 = registerItem(
			SUPER_SHEAR_V1_KEY,
			new SuperShearItem(
					new Item.Settings()
							.maxDamage(64)
							.registryKey(SUPER_SHEAR_V1_KEY)
							.component(DataComponentTypes.CUSTOM_NAME, Text.translatable("item.opsheeps.super_shear_v1").setStyle(Style.EMPTY.withColor(Formatting.WHITE).withBold(true).withItalic(false)))
							.component(DataComponentTypes.LORE, new LoreComponent(List.of(Text.translatable("item.opsheeps.shear_drops", Text.literal("4").setStyle(Style.EMPTY.withColor(Formatting.GOLD).withBold(true))).setStyle(Style.EMPTY).withColor(11184810)))),
					4,
					1
			)
	);
	public static final Item SUPER_SHEAR_V2 = registerItem(
			SUPER_SHEAR_V2_KEY,
			new SuperShearItem(
					new Item.Settings()
							.maxDamage(128)
							.registryKey(SUPER_SHEAR_V2_KEY)
							.component(DataComponentTypes.CUSTOM_NAME, Text.translatable("item.opsheeps.super_shear_v2").setStyle(Style.EMPTY.withColor(Formatting.WHITE).withBold(true).withItalic(false)))
							.component(DataComponentTypes.LORE, new LoreComponent(List.of(Text.translatable("item.opsheeps.shear_drops", Text.literal("8").setStyle(Style.EMPTY.withColor(Formatting.GOLD).withBold(true))).setStyle(Style.EMPTY).withColor(11184810)))),
					8,
					2
			)
	);
	public static final Item SUPER_SHEAR_V3 = registerItem(
			SUPER_SHEAR_V3_KEY,
			new SuperShearItem(
					new Item.Settings()
							.maxDamage(256)
							.registryKey(SUPER_SHEAR_V3_KEY)
							.component(DataComponentTypes.CUSTOM_NAME, Text.translatable("item.opsheeps.super_shear_v3").setStyle(Style.EMPTY.withColor(Formatting.WHITE).withBold(true).withItalic(false)))
							.component(DataComponentTypes.LORE, new LoreComponent(List.of(Text.translatable("item.opsheeps.shear_drops", Text.literal("32").setStyle(Style.EMPTY.withColor(Formatting.GOLD).withBold(true))).setStyle(Style.EMPTY).withColor(11184810)))),
					32,
					3
			)
	);
	public static final Item SUPER_SHEAR_V4 = registerItem(
			SUPER_SHEAR_V4_KEY,
			new SuperShearItem(
					new Item.Settings()
							.maxDamage(512)
							.registryKey(SUPER_SHEAR_V4_KEY)
							.component(DataComponentTypes.CUSTOM_NAME, Text.translatable("item.opsheeps.super_shear_v4").setStyle(Style.EMPTY.withColor(Formatting.WHITE).withBold(true).withItalic(false)))
							.component(DataComponentTypes.LORE, new LoreComponent(List.of(Text.translatable("item.opsheeps.shear_drops", Text.literal("64").setStyle(Style.EMPTY.withColor(Formatting.GOLD).withBold(true))).setStyle(Style.EMPTY).withColor(11184810)))),
					64,
					4
			)
	);
	public static final Item SUPER_SHEAR_V5 = registerItem(
			SUPER_SHEAR_V5_KEY,
			new SuperShearItem(
					new Item.Settings()
							.maxDamage(1024)
							.registryKey(SUPER_SHEAR_V5_KEY)
							.component(DataComponentTypes.CUSTOM_NAME, Text.translatable("item.opsheeps.super_shear_v5").setStyle(Style.EMPTY.withColor(Formatting.WHITE).withBold(true).withItalic(false)))
							.component(DataComponentTypes.LORE, new LoreComponent(List.of(Text.translatable("item.opsheeps.shear_drops", Text.literal("128").setStyle(Style.EMPTY.withColor(Formatting.GOLD).withBold(true))).setStyle(Style.EMPTY).withColor(11184810)))),
					128,
					5
			)
	);
//	public static final Item SUPER_SHEAR_V69 = registerItem(
//			SUPER_SHEAR_V69_KEY,
//			new SuperShearItem(
//					new Item.Settings()
//							.maxDamage(-1)
//							.registryKey(SUPER_SHEAR_V69_KEY)
//							.component(DataComponentTypes.CUSTOM_NAME, Text.translatable("item.opsheeps.super_shear_v69").setStyle(Style.EMPTY.withColor(Formatting.DARK_RED).withBold(true).withItalic(false)))
//							.component(DataComponentTypes.LORE, new LoreComponent(List.of(Text.translatable("item.opsheeps.shear_drops", Text.literal("512").setStyle(Style.EMPTY.withColor(Formatting.GOLD).withBold(true))).setStyle(Style.EMPTY).withColor(11184810)))),
//					512,
//					69
//			)
//	);
//	public static final Item GROW_BACK = registerItem(GROW_BACK_KEY,
//			new GrowBackItem(
//					new Item.Settings()
//							.maxDamage(-1)
//							.registryKey(GROW_BACK_KEY)
//							.component(DataComponentTypes.LORE, new LoreComponent(List.of(Text.translatable("item.opsheeps.grow_back_description").setStyle(Style.EMPTY.withColor(Formatting.GRAY)))))
//							.component(DataComponentTypes.CUSTOM_NAME, Text.translatable("item.opsheeps.grow_back").setStyle(Style.EMPTY.withColor(Formatting.WHITE).withBold(true).withItalic(false))))
//	);

	private static Item registerItem(RegistryKey<Item> key, Item item) {
		return Registry.register(Registries.ITEM, key.getValue(), item);
	}

	public static void registerModItems() {
		Opsheeps.LOGGER.info("🐑 REGISTER MODITEMS");
	}
}
