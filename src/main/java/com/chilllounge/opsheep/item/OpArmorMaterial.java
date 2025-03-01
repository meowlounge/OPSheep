package com.chilllounge.opsheep.item;

import com.chilllounge.opsheep.Opsheep;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.Map;

public class OpArmorMaterial {
	public static final RegistryKey<EquipmentAsset> OP_ARMOR_MATERIAL_KEY_V1 = RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(Opsheep.MOD_ID, "op_armor_v1"));
	public static final RegistryKey<EquipmentAsset> OP_ARMOR_MATERIAL_KEY_V2 = RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(Opsheep.MOD_ID, "op_armor_v2"));

	private static final Map<EquipmentType, Integer> DEFENSE_V1 = Map.of(
			EquipmentType.HELMET, 3,
			EquipmentType.CHESTPLATE, 9,
			EquipmentType.LEGGINGS, 7,
			EquipmentType.BOOTS, 4
	);

	private static final Map<EquipmentType, Integer> DEFENSE_V2 = Map.of(
			EquipmentType.HELMET, 6,
			EquipmentType.CHESTPLATE, 12,
			EquipmentType.LEGGINGS, 9,
			EquipmentType.BOOTS, 7
	);

	public static final ArmorMaterial INSTANCE_V1 = new ArmorMaterial(
			4062,
			DEFENSE_V1,
			7,
			SoundEvents.ITEM_ARMOR_EQUIP_CHAIN,
			2.0F,
			0.3F,
			ItemTags.EMERALD_ORES,
			OP_ARMOR_MATERIAL_KEY_V1
	);

	public static final ArmorMaterial INSTANCE_V2 = new ArmorMaterial(
			8062,
			DEFENSE_V2,
			7,
			SoundEvents.ITEM_ARMOR_EQUIP_CHAIN,
			4.0F,
			0.6F,
			ItemTags.EMERALD_ORES,
			OP_ARMOR_MATERIAL_KEY_V2
	);
}
