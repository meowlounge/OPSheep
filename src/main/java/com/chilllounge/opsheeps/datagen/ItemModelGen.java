package com.chilllounge.opsheeps.datagen;

import com.chilllounge.opsheeps.item.OpSetLoot;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import com.chilllounge.opsheeps.item.ModItems;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
//import net.minecraft.item.ArmorItem;
//import net.minecraft.item.equipment.EquipmentType;

public class ItemModelGen extends FabricModelProvider {
	public ItemModelGen(FabricDataOutput output) {
		super(output);
	}

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

//		itemModelGenerator.registerArmor(((ArmorItem) OPLootTableItems.OP_CHESTPLATE));
//		itemModelGenerator.registerArmor(((ArmorItem) OPLootTableItems.OP_HELMET));
//		itemModelGenerator.registerArmor(((ArmorItem) OPLootTableItems.OP_LEGGINGS));
//		itemModelGenerator.registerArmor(((ArmorItem) OPLootTableItems.OP_BOOTS));
}}