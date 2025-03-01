package com.chilllounge.opsheep.datagen;

import com.chilllounge.opsheep.Opsheep;
import com.chilllounge.opsheep.item.OpSetLoot;
import com.chilllounge.opsheep.item.OpSheepItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ItemModelGen extends FabricModelProvider {
	public ItemModelGen(FabricDataOutput output) {
		super(output);
	}

	final RegistryKey<Registry<EquipmentAsset>> EQUIPMENT_ASSET_REGISTRY_V1 = RegistryKey.ofRegistry(Identifier.of(Opsheep.MOD_ID, "op_equipment_v1"));
	final RegistryKey<EquipmentAsset> HELMET_ASSET_V1 = RegistryKey.of(EQUIPMENT_ASSET_REGISTRY_V1, Identifier.of(Opsheep.MOD_ID, "op_helmet_v1"));
	final RegistryKey<EquipmentAsset> CHESTPLATE_ASSET_V1 = RegistryKey.of(EQUIPMENT_ASSET_REGISTRY_V1, Identifier.of(Opsheep.MOD_ID, "op_chestplate_v1"));
	final RegistryKey<EquipmentAsset> LEGGINGS_ASSET_V1 = RegistryKey.of(EQUIPMENT_ASSET_REGISTRY_V1, Identifier.of(Opsheep.MOD_ID, "op_leggings_v1"));
	final RegistryKey<EquipmentAsset> BOOTS_ASSET_V1 = RegistryKey.of(EQUIPMENT_ASSET_REGISTRY_V1, Identifier.of(Opsheep.MOD_ID, "op_boots_v1"));

	final RegistryKey<Registry<EquipmentAsset>> EQUIPMENT_ASSET_REGISTRY_V2 = RegistryKey.ofRegistry(Identifier.of(Opsheep.MOD_ID, "op_equipment_v2"));
	final RegistryKey<EquipmentAsset> HELMET_ASSET_V2 = RegistryKey.of(EQUIPMENT_ASSET_REGISTRY_V2, Identifier.of(Opsheep.MOD_ID, "op_helmet_v2"));
	final RegistryKey<EquipmentAsset> CHESTPLATE_ASSET_V2 = RegistryKey.of(EQUIPMENT_ASSET_REGISTRY_V2, Identifier.of(Opsheep.MOD_ID, "op_chestplate_v2"));
	final RegistryKey<EquipmentAsset> LEGGINGS_ASSET_V2 = RegistryKey.of(EQUIPMENT_ASSET_REGISTRY_V2, Identifier.of(Opsheep.MOD_ID, "op_leggings_v2"));
	final RegistryKey<EquipmentAsset> BOOTS_ASSET_V2 = RegistryKey.of(EQUIPMENT_ASSET_REGISTRY_V2, Identifier.of(Opsheep.MOD_ID, "op_boots_v2"));

	@Override
	public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
	}

	public void generateItemModels(ItemModelGenerator itemModelGenerator) {
//		itemModelGenerator.register(opsheepItems.GROW_BACK, Models.GENERATED);
		itemModelGenerator.register(OpSheepItems.SUPER_DYE, Models.GENERATED);
		itemModelGenerator.register(OpSheepItems.SUPER_SHEAR_V1, Models.GENERATED);
		itemModelGenerator.register(OpSheepItems.SUPER_SHEAR_V2, Models.GENERATED);
		itemModelGenerator.register(OpSheepItems.SUPER_SHEAR_V3, Models.GENERATED);
		itemModelGenerator.register(OpSheepItems.SUPER_SHEAR_V4, Models.GENERATED);
		itemModelGenerator.register(OpSheepItems.SUPER_SHEAR_V5, Models.GENERATED);
//		itemModelGenerator.register(opsheepItems.SUPER_SHEAR_V69, Models.GENERATED);

		itemModelGenerator.register(OpSetLoot.OP_HOE_V1, Models.HANDHELD);
		itemModelGenerator.register(OpSetLoot.OP_SHOVEL_V1, Models.HANDHELD);
		itemModelGenerator.register(OpSetLoot.OP_SWORD_V1, Models.HANDHELD);
		itemModelGenerator.register(OpSetLoot.OP_AXE_V1, Models.HANDHELD);
		itemModelGenerator.register(OpSetLoot.OP_PICKAXE_V1, Models.HANDHELD);
		itemModelGenerator.registerArmor(OpSetLoot.OP_CHESTPLATE_V1, CHESTPLATE_ASSET_V1, "chestplate", false);
		itemModelGenerator.registerArmor(OpSetLoot.OP_HELMET_V1, HELMET_ASSET_V1, "helmet", false);
		itemModelGenerator.registerArmor(OpSetLoot.OP_LEGGINGS_V1, LEGGINGS_ASSET_V1, "leggings", false);
		itemModelGenerator.registerArmor(OpSetLoot.OP_BOOTS_V1, BOOTS_ASSET_V1, "boots", false);

		itemModelGenerator.register(OpSetLoot.OP_HOE_V2, Models.HANDHELD);
		itemModelGenerator.register(OpSetLoot.OP_SHOVEL_V2, Models.HANDHELD);
		itemModelGenerator.register(OpSetLoot.OP_SWORD_V2, Models.HANDHELD);
		itemModelGenerator.register(OpSetLoot.OP_AXE_V2, Models.HANDHELD);
		itemModelGenerator.register(OpSetLoot.OP_PICKAXE_V2, Models.HANDHELD);
		itemModelGenerator.registerArmor(OpSetLoot.OP_CHESTPLATE_V2, CHESTPLATE_ASSET_V2, "chestplate", false);
		itemModelGenerator.registerArmor(OpSetLoot.OP_HELMET_V2, HELMET_ASSET_V2, "helmet", false);
		itemModelGenerator.registerArmor(OpSetLoot.OP_LEGGINGS_V2, LEGGINGS_ASSET_V2, "leggings", false);
		itemModelGenerator.registerArmor(OpSetLoot.OP_BOOTS_V2, BOOTS_ASSET_V2, "boots", false);
	}
}