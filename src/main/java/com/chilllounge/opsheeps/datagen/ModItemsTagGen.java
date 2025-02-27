package com.chilllounge.opsheeps.datagen;

import com.chilllounge.opsheeps.item.OpSetLoot;
import com.chilllounge.opsheeps.item.OpSheepsItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemsTagGen extends FabricTagProvider.ItemTagProvider {
	public ModItemsTagGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
		getOrCreateTagBuilder(ItemTags.SHARP_WEAPON_ENCHANTABLE)
				.add(OpSetLoot.OP_SWORD_V1)
				.add(OpSetLoot.OP_SWORD_V2)
				.add(OpSetLoot.OP_AXE_V1)
				.add(OpSetLoot.OP_AXE_V2);
		getOrCreateTagBuilder(ItemTags.MINING_LOOT_ENCHANTABLE)
				.add(OpSetLoot.OP_SHOVEL_V1)
				.add(OpSetLoot.OP_SHOVEL_V2)
				.add(OpSetLoot.OP_HOE_V1)
				.add(OpSetLoot.OP_HOE_V2)
				.add(OpSetLoot.OP_AXE_V1)
				.add(OpSetLoot.OP_AXE_V2);
		getOrCreateTagBuilder(ItemTags.MINING_ENCHANTABLE)
				.add(OpSheepsItems.SUPER_SHEAR_V1)
				.add(OpSheepsItems.SUPER_SHEAR_V2)
				.add(OpSheepsItems.SUPER_SHEAR_V3)
				.add(OpSheepsItems.SUPER_SHEAR_V4)
				.add(OpSheepsItems.SUPER_SHEAR_V5)
				.add(OpSheepsItems.SUPER_SHEAR_V69)
				.add(OpSetLoot.OP_PICKAXE_V1)
				.add(OpSetLoot.OP_PICKAXE_V2);
		getOrCreateTagBuilder(ItemTags.ARMOR_ENCHANTABLE)
				.add(OpSetLoot.OP_HELMET_V1)
				.add(OpSetLoot.OP_HELMET_V2)
				.add(OpSetLoot.OP_CHESTPLATE_V1)
				.add(OpSetLoot.OP_CHESTPLATE_V2)
				.add(OpSetLoot.OP_BOOTS_V1)
				.add(OpSetLoot.OP_BOOTS_V2);
	}


	@Override
	public String getName() {
		return "ModItemsTagGen";
	}
}
