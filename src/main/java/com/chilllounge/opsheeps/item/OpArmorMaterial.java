package com.chilllounge.opsheeps.item;

import com.chilllounge.opsheeps.Opsheeps;
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
	public static final RegistryKey<EquipmentAsset> OP_ARMOR_MATERIAL_KEY = RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(Opsheeps.MOD_ID, "op_armor_material"));

	private static final Map<EquipmentType, Integer> DEFENSE = Map.of(
			EquipmentType.HELMET, 5,
			EquipmentType.CHESTPLATE, 12,
			EquipmentType.LEGGINGS, 8,
			EquipmentType.BOOTS, 6
	);

	public static final ArmorMaterial INSTANCE = new ArmorMaterial(
			6062,
			DEFENSE,
			10,
			SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
			3.0F,
			0.2F,
			ItemTags.GOLD_ORES,
			OP_ARMOR_MATERIAL_KEY
	);
}
