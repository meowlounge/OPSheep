package com.chilllounge.opsheeps.datagen.lang;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class EnTranslationGen extends FabricLanguageProvider {
	public EnTranslationGen(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
		super(dataOutput, "en_us", registryLookup);
	}

	@Override
	public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
		translationBuilder.add("item.opsheeps.super_dye", "Super Dye");

		translationBuilder.add("item.opsheeps.super_shear_v1", "Titan Shear 1.0");
		translationBuilder.add("item.opsheeps.super_shear_v2", "Titan Shear 2.0");
		translationBuilder.add("item.opsheeps.super_shear_v3", "Titan Shear 3.0");
		translationBuilder.add("item.opsheeps.super_shear_v4", "Titan Shear 4.0");
		translationBuilder.add("item.opsheeps.super_shear_v5", "Titan Shear 5.0");
		translationBuilder.add("item.opsheeps.super_shear_v69", "Titan Shear");

		translationBuilder.add("item.opsheeps.op_helmet_v1", "OP Helmet");
		translationBuilder.add("item.opsheeps.op_chestplate_v1", "OP Chestplate");
		translationBuilder.add("item.opsheeps.op_leggings_v1", "OP Leggings");
		translationBuilder.add("item.opsheeps.op_boots_v1", "OP Boots");
		translationBuilder.add("item.opsheeps.op_sword_v1", "OP Sword");
		translationBuilder.add("item.opsheeps.op_pickaxe_v1", "OP Pickaxe");
		translationBuilder.add("item.opsheeps.op_axe_v1", "OP Axe");
		translationBuilder.add("item.opsheeps.op_shovel_v1", "OP Shovel");
		translationBuilder.add("item.opsheeps.op_hoe_v1", "OP Hoe");

		translationBuilder.add("item.opsheeps.op_helmet_v2", "ULTRA OP Helmet");
		translationBuilder.add("item.opsheeps.op_chestplate_v2", "ULTRA OP Chestplate");
		translationBuilder.add("item.opsheeps.op_leggings_v2", "ULTRA OP Leggings");
		translationBuilder.add("item.opsheeps.op_boots_v2", "ULTRA OP Boots");
		translationBuilder.add("item.opsheeps.op_sword_v2", "ULTRA OP Sword");
		translationBuilder.add("item.opsheeps.op_pickaxe_v2", "ULTRA OP Pickaxe");
		translationBuilder.add("item.opsheeps.op_axe_v2", "ULTRA OP Axe");
		translationBuilder.add("item.opsheeps.op_shovel_v2", "ULTRA OP Shovel");
		translationBuilder.add("item.opsheeps.op_hoe_v2", "ULTRA OP Hoe");

		translationBuilder.add("item.opsheeps.grow_back", "Grow Back");

		translationBuilder.add("itemgroups.opsheeps.super_items", "OP Sheeps");

		translationBuilder.add("rarity.opsheeps.common", "COMMON");
		translationBuilder.add("rarity.opsheeps.uncommon", "UNCOMMON");
		translationBuilder.add("rarity.opsheeps.rare", "RARE");
		translationBuilder.add("rarity.opsheeps.epic", "EPIC");
		translationBuilder.add("rarity.opsheeps.legendary", "LEGENDARY");
		translationBuilder.add("rarity.opsheeps.dev", "DEVELOPER");

		translationBuilder.add("item.opsheeps.grow_back_description", "Instantly give the Clicked Sheep its Wool Back.");
		translationBuilder.add("item.opsheeps.shear_drops", "Shearing an OP Sheep drops %s items.");

		translationBuilder.add("enchantment.opsheeps.mineral_extractor", "Mineral Extractor");

		translationBuilder.add("item.opsheeps.super_dye_description", "Whisper its secret to a sheep, and witness the impossible...");

		translationBuilder.add("opsheeps.help.page1", "§lWelcome to OPSheeps!\n\nDiscover advanced features that empower your creativity. OPSheeps blends innovation and fun, offering you a unique gameplay experience.");
		translationBuilder.add("opsheeps.help.page2", "§lStep 1: Craft the SuperDye\n\nCollect rare ingredients and use your crafting table to create SuperDye – the essential ingredient for unlocking extraordinary transformations.");
		translationBuilder.add("opsheeps.help.page3", "§lStep 2: Transform Your Sheep\n\nApply SuperDye to your sheep and watch as they undergo a stunning metamorphosis into vibrant, powerful creatures.");
		translationBuilder.add("opsheeps.help.page4", "§lStep 3: Wield the Titan Shears\n\nTitan Shears are your ultimate tool for harvesting resources. Use them to gather materials effortlessly and enhance your gear.");
		translationBuilder.add("opsheeps.help.page5", "§lFinal Tips\n\nExperiment with OPSheeps' features, explore creative possibilities, and collect rare resources. Enjoy your adventure and may your journeys be epic!");

		translationBuilder.add("command.opsheeps.help.client", "This command can only be executed by a server player.");
		translationBuilder.add("command.opsheeps.help.book_received", "You have received the OPSheeps help book!");

		translationBuilder.add("item.opsheeps.supershear_perk_v5", "§6[OPSheeps] §eTreasure Drop: ");
		translationBuilder.add("item.opsheeps.supershear_perk_v4", "§6[OPSheeps] §bAOE Shear! §7(3x3 Area)");
		translationBuilder.add("item.opsheeps.supershear_perk_v2", "§6[OPSheeps] §aExtra Shear! §7(Double Drop)");
		translationBuilder.add("item.opsheeps.supershear_perk_v3", "§6[OPSheeps] §dRare Drops! §7(25% chance for rare items)");

	}

	@Override
	public String getName() {
		return "EN Translation Generator";
	}
}
