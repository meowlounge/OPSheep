package com.chilllounge.opsheeps.item;

import com.chilllounge.opsheeps.Opsheeps;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.EnchantableComponent;
import net.minecraft.component.type.UnbreakableComponent;
import net.minecraft.item.*;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

public class OpSetLoot {
	public static final ToolMaterial OP_TOOL_MATERIAL_V1 = new ToolMaterial(
			BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 4062, 30.0F, 0.0F, 14, ItemTags.NETHERITE_TOOL_MATERIALS
	);
	public static final ToolMaterial OP_TOOL_MATERIAL_V2 = new ToolMaterial(
			BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 8062, 999.0F, 8.0F, 30, ItemTags.NETHERITE_TOOL_MATERIALS
	);

	public static final ArmorMaterial OP_ARMOR_MATERIAL_V1 = OpArmorMaterial.INSTANCE_V1;
	public static final ArmorMaterial OP_ARMOR_MATERIAL_V2 = OpArmorMaterial.INSTANCE_V2;

	public static final RegistryKey<Item> OP_HELMET_V1_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Opsheeps.MOD_ID, "op_helmet_v1"));
	public static final RegistryKey<Item> OP_CHESTPLATE_V1_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Opsheeps.MOD_ID, "op_chestplate_v1"));
	public static final RegistryKey<Item> OP_LEGGINGS_V1_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Opsheeps.MOD_ID, "op_leggings_v1"));
	public static final RegistryKey<Item> OP_BOOTS_V1_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Opsheeps.MOD_ID, "op_boots_v1"));
	public static final RegistryKey<Item> OP_SWORD_V1_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Opsheeps.MOD_ID, "op_sword_v1"));
	public static final RegistryKey<Item> OP_AXE_V1_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Opsheeps.MOD_ID, "op_axe_v1"));
	public static final RegistryKey<Item> OP_PICKAXE_V1_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Opsheeps.MOD_ID, "op_pickaxe_v1"));
	public static final RegistryKey<Item> OP_SHOVEL_V1_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Opsheeps.MOD_ID, "op_shovel_v1"));
	public static final RegistryKey<Item> OP_HOE_V1_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Opsheeps.MOD_ID, "op_hoe_v1"));

	public static final RegistryKey<Item> OP_HELMET_V2_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Opsheeps.MOD_ID, "op_helmet_v2"));
	public static final RegistryKey<Item> OP_CHESTPLATE_V2_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Opsheeps.MOD_ID, "op_chestplate_v2"));
	public static final RegistryKey<Item> OP_LEGGINGS_V2_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Opsheeps.MOD_ID, "op_leggings_v2"));
	public static final RegistryKey<Item> OP_BOOTS_V2_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Opsheeps.MOD_ID, "op_boots_v2"));
	public static final RegistryKey<Item> OP_SWORD_V2_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Opsheeps.MOD_ID, "op_sword_v2"));
	public static final RegistryKey<Item> OP_AXE_V2_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Opsheeps.MOD_ID, "op_axe_v2"));
	public static final RegistryKey<Item> OP_PICKAXE_V2_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Opsheeps.MOD_ID, "op_pickaxe_v2"));
	public static final RegistryKey<Item> OP_SHOVEL_V2_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Opsheeps.MOD_ID, "op_shovel_v2"));
	public static final RegistryKey<Item> OP_HOE_V2_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Opsheeps.MOD_ID, "op_hoe_v2"));

	public static final Item OP_HELMET_V1 = registerItem(OP_HELMET_V1_KEY,
			new ArmorItem(OP_ARMOR_MATERIAL_V1, EquipmentType.HELMET,
					new Item.Settings()
							.registryKey(OP_HELMET_V1_KEY)
							.component(DataComponentTypes.ENCHANTABLE, new EnchantableComponent(13))
							.component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(false))
							.component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)
							.component(DataComponentTypes.CUSTOM_NAME, Text.translatable("item.opsheeps.op_helmet_v1")
									.setStyle(Style.EMPTY.withColor(Formatting.RED)
											.withBold(true)
											.withItalic(false)))
			)
	);

	public static final Item OP_CHESTPLATE_V1 = registerItem(OP_CHESTPLATE_V1_KEY,
			new ArmorItem(OP_ARMOR_MATERIAL_V1, EquipmentType.CHESTPLATE,
					new Item.Settings()
							.registryKey(OP_CHESTPLATE_V1_KEY)
							.component(DataComponentTypes.ENCHANTABLE, new EnchantableComponent(13))
							.component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(false))
							.component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)
							.component(DataComponentTypes.CUSTOM_NAME, Text.translatable("item.opsheeps.op_chestplate_v1")
									.setStyle(Style.EMPTY.withColor(Formatting.RED)
											.withBold(true)
											.withItalic(false)))
			)
	);

	public static final Item OP_LEGGINGS_V1 = registerItem(OP_LEGGINGS_V1_KEY,
			new ArmorItem(OP_ARMOR_MATERIAL_V1, EquipmentType.LEGGINGS,
					new Item.Settings()
							.registryKey(OP_LEGGINGS_V1_KEY)
							.component(DataComponentTypes.ENCHANTABLE, new EnchantableComponent(13))
							.component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(false))
							.component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)
							.component(DataComponentTypes.CUSTOM_NAME, Text.translatable("item.opsheeps.op_leggings_v1")
									.setStyle(Style.EMPTY.withColor(Formatting.RED)
											.withBold(true)
											.withItalic(false)))
			)
	);

	public static final Item OP_BOOTS_V1 = registerItem(OP_BOOTS_V1_KEY,
			new ArmorItem(OP_ARMOR_MATERIAL_V1, EquipmentType.BOOTS,
					new Item.Settings()
							.registryKey(OP_BOOTS_V1_KEY)
							.component(DataComponentTypes.ENCHANTABLE, new EnchantableComponent(13))
							.component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(false))
							.component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)
							.component(DataComponentTypes.CUSTOM_NAME, Text.translatable("item.opsheeps.op_boots_v1")
									.setStyle(Style.EMPTY.withColor(Formatting.RED)
											.withBold(true)
											.withItalic(false)))
			)
	);

	public static final Item OP_SWORD_V1 = registerItem(OP_SWORD_V1_KEY,
			new SwordItem(OP_TOOL_MATERIAL_V1, 6, -1.4F,
					new Item.Settings()
							.registryKey(OP_SWORD_V1_KEY)
							.component(DataComponentTypes.ENCHANTABLE, new EnchantableComponent(13))
							.component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(false))
							.component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)
							.component(DataComponentTypes.CUSTOM_NAME, Text.translatable("item.opsheeps.op_sword_v1")
									.setStyle(Style.EMPTY.withColor(Formatting.RED)
											.withBold(true)
											.withItalic(false)))
			)
	);

	public static final Item OP_AXE_V1 = registerItem(OP_AXE_V1_KEY,
			new AxeItem(OP_TOOL_MATERIAL_V1, 11, -3.0F,
					new Item.Settings()
							.registryKey(OP_AXE_V1_KEY)
							.component(DataComponentTypes.ENCHANTABLE, new EnchantableComponent(13))
							.component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(false))
							.component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)
							.component(DataComponentTypes.CUSTOM_NAME, Text.translatable("item.opsheeps.op_axe_v1")
									.setStyle(Style.EMPTY.withColor(Formatting.RED)
											.withBold(true)
											.withItalic(false)))
			)
	);

	public static final Item OP_PICKAXE_V1 = registerItem(OP_PICKAXE_V1_KEY,
			new PickaxeItem(OP_TOOL_MATERIAL_V1, -3, -2.8F,
					new Item.Settings()
							.registryKey(OP_PICKAXE_V1_KEY)
							.component(DataComponentTypes.ENCHANTABLE, new EnchantableComponent(12))
							.component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(false))
							.component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)
							.component(DataComponentTypes.CUSTOM_NAME, Text.translatable("item.opsheeps.op_pickaxe_v1")
									.setStyle(Style.EMPTY.withColor(Formatting.RED)
											.withBold(true)
											.withItalic(false)))
			)
	);

	public static final Item OP_SHOVEL_V1 = registerItem(OP_SHOVEL_V1_KEY,
			new ShovelItem(OP_TOOL_MATERIAL_V1, -3.5F, -3.0F,
					new Item.Settings()
							.registryKey(OP_SHOVEL_V1_KEY)
							.component(DataComponentTypes.ENCHANTABLE, new EnchantableComponent(15))
							.component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(false))
							.component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)
							.component(DataComponentTypes.CUSTOM_NAME, Text.translatable("item.opsheeps.op_shovel_v1")
									.setStyle(Style.EMPTY.withColor(Formatting.RED)
											.withBold(true)
											.withItalic(false)))
			)
	);

	public static final Item OP_HOE_V1 = registerItem(OP_HOE_V1_KEY,
			new HoeItem(OP_TOOL_MATERIAL_V1, -10, -1.0F,
					new Item.Settings()
							.registryKey(OP_HOE_V1_KEY)
							.component(DataComponentTypes.ENCHANTABLE, new EnchantableComponent(8))
							.component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(false))
							.component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)
							.component(DataComponentTypes.CUSTOM_NAME, Text.translatable("item.opsheeps.op_hoe_v1")
									.setStyle(Style.EMPTY.withColor(Formatting.RED)
											.withBold(true)
											.withItalic(false)))
			)
	);

	public static final Item OP_HELMET_V2 = registerItem(OP_HELMET_V2_KEY,
			new ArmorItem(OP_ARMOR_MATERIAL_V2, EquipmentType.HELMET,
					new Item.Settings()
							.registryKey(OP_HELMET_V2_KEY)
							.component(DataComponentTypes.ENCHANTABLE, new EnchantableComponent(5))
							.component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(false))
							.component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)
							.component(DataComponentTypes.CUSTOM_NAME, Text.translatable("item.opsheeps.op_helmet_v2")
									.setStyle(Style.EMPTY.withColor(Formatting.LIGHT_PURPLE)
											.withBold(true)
											.withItalic(false)))
			)
	);

	public static final Item OP_CHESTPLATE_V2 = registerItem(OP_CHESTPLATE_V2_KEY,
			new ArmorItem(OP_ARMOR_MATERIAL_V2, EquipmentType.CHESTPLATE,
					new Item.Settings()
							.registryKey(OP_CHESTPLATE_V2_KEY)
							.component(DataComponentTypes.ENCHANTABLE, new EnchantableComponent(8))
							.component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(false))
							.component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)
							.component(DataComponentTypes.CUSTOM_NAME, Text.translatable("item.opsheeps.op_chestplate_v2")
									.setStyle(Style.EMPTY.withColor(Formatting.LIGHT_PURPLE)
											.withBold(true)
											.withItalic(false)))
			)
	);

	public static final Item OP_LEGGINGS_V2 = registerItem(OP_LEGGINGS_V2_KEY,
			new ArmorItem(OP_ARMOR_MATERIAL_V2, EquipmentType.LEGGINGS,
					new Item.Settings()
							.registryKey(OP_LEGGINGS_V2_KEY)
							.component(DataComponentTypes.ENCHANTABLE, new EnchantableComponent(4))
							.component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(false))
							.component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)
							.component(DataComponentTypes.CUSTOM_NAME, Text.translatable("item.opsheeps.op_leggings_v2")
									.setStyle(Style.EMPTY.withColor(Formatting.LIGHT_PURPLE)
											.withBold(true)
											.withItalic(false)))
			)
	);

	public static final Item OP_BOOTS_V2 = registerItem(OP_BOOTS_V2_KEY,
			new ArmorItem(OP_ARMOR_MATERIAL_V2, EquipmentType.BOOTS,
					new Item.Settings()
							.registryKey(OP_BOOTS_V2_KEY)
							.component(DataComponentTypes.ENCHANTABLE, new EnchantableComponent(2))
							.component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(false))
							.component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)
							.component(DataComponentTypes.CUSTOM_NAME, Text.translatable("item.opsheeps.op_boots_v2")
									.setStyle(Style.EMPTY.withColor(Formatting.LIGHT_PURPLE)
											.withBold(true)
											.withItalic(false)))
			)
	);

	public static final Item OP_SWORD_V2 = registerItem(OP_SWORD_V2_KEY,
			new SwordItem(OP_TOOL_MATERIAL_V2, 6, -1.4F,
					new Item.Settings()
							.registryKey(OP_SWORD_V2_KEY)
							.component(DataComponentTypes.ENCHANTABLE, new EnchantableComponent(12))
							.component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(false))
							.component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)
							.component(DataComponentTypes.CUSTOM_NAME, Text.translatable("item.opsheeps.op_sword_v2")
									.setStyle(Style.EMPTY.withColor(Formatting.LIGHT_PURPLE)
											.withBold(true)
											.withItalic(false)))
			)
	);

	public static final Item OP_AXE_V2 = registerItem(OP_AXE_V2_KEY,
			new AxeItem(OP_TOOL_MATERIAL_V2, 11, -3.0F,
					new Item.Settings()
							.registryKey(OP_AXE_V2_KEY)
							.component(DataComponentTypes.ENCHANTABLE, new EnchantableComponent(16))
							.component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(false))
							.component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)
							.component(DataComponentTypes.CUSTOM_NAME, Text.translatable("item.opsheeps.op_axe_v2")
									.setStyle(Style.EMPTY.withColor(Formatting.LIGHT_PURPLE)
											.withBold(true)
											.withItalic(false)))
			)
	);

	public static final Item OP_PICKAXE_V2 = registerItem(OP_PICKAXE_V2_KEY,
			new PickaxeItem(OP_TOOL_MATERIAL_V2, -3, -2.8F,
					new Item.Settings()
							.registryKey(OP_PICKAXE_V2_KEY)
							.component(DataComponentTypes.ENCHANTABLE, new EnchantableComponent(6))
							.component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(false))
							.component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)
							.component(DataComponentTypes.CUSTOM_NAME, Text.translatable("item.opsheeps.op_pickaxe_v2")
									.setStyle(Style.EMPTY.withColor(Formatting.LIGHT_PURPLE)
											.withBold(true)
											.withItalic(false)))
			)
	);

	public static final Item OP_SHOVEL_V2 = registerItem(OP_SHOVEL_V2_KEY,
			new ShovelItem(OP_TOOL_MATERIAL_V2, -3.5F, -3.0F,
					new Item.Settings()
							.registryKey(OP_SHOVEL_V2_KEY)
							.component(DataComponentTypes.ENCHANTABLE, new EnchantableComponent(9))
							.component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(false))
							.component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)
							.component(DataComponentTypes.CUSTOM_NAME, Text.translatable("item.opsheeps.op_shovel_v2")
									.setStyle(Style.EMPTY.withColor(Formatting.LIGHT_PURPLE)
											.withBold(true)
											.withItalic(false)))
			)
	);

	public static final Item OP_HOE_V2 = registerItem(OP_HOE_V2_KEY,
			new HoeItem(OP_TOOL_MATERIAL_V2, -10, -1.0F,
					new Item.Settings()
							.registryKey(OP_HOE_V2_KEY)
							.component(DataComponentTypes.ENCHANTABLE, new EnchantableComponent(12))
							.component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(false))
							.component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)
							.component(DataComponentTypes.CUSTOM_NAME, Text.translatable("item.opsheeps.op_hoe_v2")
									.setStyle(Style.EMPTY.withColor(Formatting.LIGHT_PURPLE)
											.withBold(true)
											.withItalic(false)))
			)
	);

	private static Item registerItem(RegistryKey<Item> key, Item item) {
		return Registry.register(Registries.ITEM, key.getValue(), item);
	}

	public static void registerLootTableItems() {
		Opsheeps.LOGGER.info("🐑 REGISTER OP LOOTTABLE ITEMS");
	}
}