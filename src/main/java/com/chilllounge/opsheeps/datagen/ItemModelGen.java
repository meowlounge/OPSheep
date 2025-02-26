package com.chilllounge.opsheeps.datagen;

import com.chilllounge.opsheeps.Opsheeps;
import com.chilllounge.opsheeps.item.ModItems;
import com.chilllounge.opsheeps.item.OpSetLoot;
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

	final RegistryKey<Registry<EquipmentAsset>> EQUIPMENT_ASSET_REGISTRY = RegistryKey.ofRegistry(Identifier.of(Opsheeps.MOD_ID, "op_equipment"));
	final RegistryKey<EquipmentAsset> HELMET_ASSET = RegistryKey.of(EQUIPMENT_ASSET_REGISTRY, Identifier.of(Opsheeps.MOD_ID, "op_helmet"));
	final RegistryKey<EquipmentAsset> CHESTPLATE_ASSET = RegistryKey.of(EQUIPMENT_ASSET_REGISTRY, Identifier.of(Opsheeps.MOD_ID, "op_chestplate"));
	final RegistryKey<EquipmentAsset> LEGGINGS_ASSET = RegistryKey.of(EQUIPMENT_ASSET_REGISTRY, Identifier.of(Opsheeps.MOD_ID, "op_leggings"));
	final RegistryKey<EquipmentAsset> BOOTS_ASSET = RegistryKey.of(EQUIPMENT_ASSET_REGISTRY, Identifier.of(Opsheeps.MOD_ID, "op_boots"));

	@Override
	public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
	}

	public void generateItemModels(ItemModelGenerator itemModelGenerator) {
		itemModelGenerator.register(ModItems.GROW_BACK, Models.GENERATED);
		itemModelGenerator.register(ModItems.SUPER_DYE, Models.GENERATED);
		itemModelGenerator.register(ModItems.SUPER_SHEAR_V1, Models.GENERATED);
		itemModelGenerator.register(ModItems.SUPER_SHEAR_V2, Models.GENERATED);
		itemModelGenerator.register(ModItems.SUPER_SHEAR_V3, Models.GENERATED);
		itemModelGenerator.register(ModItems.SUPER_SHEAR_V4, Models.GENERATED);
		itemModelGenerator.register(ModItems.SUPER_SHEAR_V5, Models.GENERATED);
		itemModelGenerator.register(ModItems.SUPER_SHEAR_V69, Models.GENERATED);

		itemModelGenerator.register(OpSetLoot.OP_HOE, Models.HANDHELD);
		itemModelGenerator.register(OpSetLoot.OP_SHOVEL, Models.HANDHELD);
		itemModelGenerator.register(OpSetLoot.OP_SWORD, Models.HANDHELD);
		itemModelGenerator.register(OpSetLoot.OP_AXE, Models.HANDHELD);
		itemModelGenerator.register(OpSetLoot.OP_PICKAXE, Models.HANDHELD);
		itemModelGenerator.registerArmor(OpSetLoot.OP_CHESTPLATE, CHESTPLATE_ASSET, "chestplate", false);
		itemModelGenerator.registerArmor(OpSetLoot.OP_HELMET, HELMET_ASSET, "helmet", false);
		itemModelGenerator.registerArmor(OpSetLoot.OP_LEGGINGS, LEGGINGS_ASSET, "leggings", false);
		itemModelGenerator.registerArmor(OpSetLoot.OP_BOOTS, BOOTS_ASSET, "boots", false);
	}
}