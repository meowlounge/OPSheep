package com.chilllounge.opsheep.datagen.lang;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class DeTranslationGen extends FabricLanguageProvider {
	public DeTranslationGen(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
		super(dataOutput, "de_de", registryLookup);
	}

	@Override
	public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
		translationBuilder.add("item.opsheep.super_dye", "Super Farbe");

		translationBuilder.add("item.opsheep.super_shear_v1", "Titan Schere 1.0");
		translationBuilder.add("item.opsheep.super_shear_v2", "Titan Schere 2.0");
		translationBuilder.add("item.opsheep.super_shear_v3", "Titan Schere 3.0");
		translationBuilder.add("item.opsheep.super_shear_v4", "Titan Schere 4.0");
		translationBuilder.add("item.opsheep.super_shear_v5", "Titan Schere 5.0");
		translationBuilder.add("item.opsheep.super_shear_v69", "Titan Schere");

		translationBuilder.add("item.opsheep.op_helmet_v1", "OP Helm");
		translationBuilder.add("item.opsheep.op_chestplate_v1", "OP Harnisch");
		translationBuilder.add("item.opsheep.op_leggings_v1", "OP Beinschutz");
		translationBuilder.add("item.opsheep.op_boots_v1", "OP Stiefel");
		translationBuilder.add("item.opsheep.op_sword_v1", "OP Schwert");
		translationBuilder.add("item.opsheep.op_pickaxe_v1", "OP Spitzhacke");
		translationBuilder.add("item.opsheep.op_axe_v1", "OP Axt");
		translationBuilder.add("item.opsheep.op_shovel_v1", "OP Schaufel");
		translationBuilder.add("item.opsheep.op_hoe_v1", "OP Hacke");

		translationBuilder.add("item.opsheep.op_helmet_v2", "ULTRA OP Helm");
		translationBuilder.add("item.opsheep.op_chestplate_v2", "ULTRA OP Harnisch");
		translationBuilder.add("item.opsheep.op_leggings_v2", "ULTRA OP Beinschutz");
		translationBuilder.add("item.opsheep.op_boots_v2", "ULTRA OP Stiefel");
		translationBuilder.add("item.opsheep.op_sword_v2", "ULTRA OP Schwert");
		translationBuilder.add("item.opsheep.op_pickaxe_v2", "ULTRA OP Spitzhacke");
		translationBuilder.add("item.opsheep.op_axe_v2", "ULTRA OP Axt");
		translationBuilder.add("item.opsheep.op_shovel_v2", "ULTRA OP Schaufel");
		translationBuilder.add("item.opsheep.op_hoe_v2", "ULTRA OP Hacke");

		translationBuilder.add("item.opsheep.grow_back", "Wiederwachs");

		translationBuilder.add("itemgroups.opsheep.super_items", "OP-Schafe");

		translationBuilder.add("rarity.opsheep.common", "GEWÖHNLICH");
		translationBuilder.add("rarity.opsheep.uncommon", "UNGEWÖHNLICH");
		translationBuilder.add("rarity.opsheep.rare", "SELTEN");
		translationBuilder.add("rarity.opsheep.epic", "EPISCH");
		translationBuilder.add("rarity.opsheep.legendary", "LEGENDÄR");
		translationBuilder.add("rarity.opsheep.dev", "ENTWICKLER");

		translationBuilder.add("item.opsheep.grow_back_description", "Gibt dem angeklickten Schaf sofort seine Wolle wieder.");
		translationBuilder.add("item.opsheep.shear_drops", "Das Scheren eines OP Schafs lässt %s Gegenstände fallen.");

		translationBuilder.add("enchantment.opsheep.mineral_extractor", "Mineralien Erschnüfler");

		translationBuilder.add("item.opsheep.super_dye_description", "Flüster dein Geheimnis, einem Schaf und siehe was passiert...");

		translationBuilder.add("opsheep.help.page1", "§lWillkommen bei opsheep!\n\nEntdecke fortschrittliche Features, die deiner Kreativität Flügel verleihen. opsheep vereint Innovation und Spaß für ein einzigartiges Spielerlebnis.");
		translationBuilder.add("opsheep.help.page2", "§lSchritt 1: SuperFärbemittel herstellen\n\nSammle seltene Zutaten und nutze die Werkbank, um das SuperFärbemittel zu kreieren – der Schlüssel zu außergewöhnlichen Verwandlungen.");
		translationBuilder.add("opsheep.help.page3", "§lSchritt 2: Verwandle deine Schafe\n\nTrage das SuperFärbemittel auf deine Schafe auf und beobachte, wie sie sich in lebendige, kraftvolle Wesen verwandeln.");
		translationBuilder.add("opsheep.help.page4", "§lSchritt 3: Titan-Scheren einsetzen\n\nTitan-Scheren sind dein ultimativer Helfer zum Ernten von Ressourcen. Setze sie ein, um Materialien mühelos zu sammeln und deine Ausrüstung zu verbessern.");
		translationBuilder.add("opsheep.help.page5", "§lLetzte Tipps\n\nProbiere die vielfältigen Funktionen von opsheep aus, entdecke neue Möglichkeiten und sammle seltene Ressourcen. Viel Spaß und möge dein Abenteuer episch werden!");

		translationBuilder.add("command.opsheep.help.client", "Dieser Befehl kann nur von einem Spieler ausgeführt werden.");
		translationBuilder.add("command.opsheep.help.book_received", "Du hast das opsheep-Hilfebuch erhalten!");

		translationBuilder.add("item.opsheep.supershear_perk_v5", "§6[opsheep] §eSchatz Drop: ");
		translationBuilder.add("item.opsheep.supershear_perk_v4", "§6[opsheep] §bAOE Schur! §7(3x3 Bereich)");
		translationBuilder.add("item.opsheep.supershear_perk_v2", "§6[opsheep] §aExtra Schur! §7(Doppelter Drop)");
		translationBuilder.add("item.opsheep.supershear_perk_v3", "§6[opsheep] §dSeltene Drops! §7(25% Chance auf seltene Items)");
	}

	@Override
	public String getName() {
		return "DE Translation Generator";
	}
}
