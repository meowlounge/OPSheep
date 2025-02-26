package com.chilllounge.opsheeps.datagen.lang;

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
		translationBuilder.add("item.opsheeps.super_dye", "Super Farbe");

		translationBuilder.add("item.opsheeps.super_shear_v1", "Titan Schere 1.0");
		translationBuilder.add("item.opsheeps.super_shear_v2", "Titan Schere 2.0");
		translationBuilder.add("item.opsheeps.super_shear_v3", "Titan Schere 3.0");
		translationBuilder.add("item.opsheeps.super_shear_v4", "Titan Schere 4.0");
		translationBuilder.add("item.opsheeps.super_shear_v5", "Titan Schere 5.0");
		translationBuilder.add("item.opsheeps.super_shear_v69", "Titan Schere");

		translationBuilder.add("item.opsheeps.op_helmet", "OP Helm");
		translationBuilder.add("item.opsheeps.op_chestplate", "OP Harnisch");
		translationBuilder.add("item.opsheeps.op_leggings", "OP Beinschutz");
		translationBuilder.add("item.opsheeps.op_boots", "OP Stiefel");
		translationBuilder.add("item.opsheeps.op_sword", "OP Schwert");
		translationBuilder.add("item.opsheeps.op_pickaxe", "OP Spitzhacke");
		translationBuilder.add("item.opsheeps.op_axe", "OP Axt");
		translationBuilder.add("item.opsheeps.op_shovel", "OP Schaufel");
		translationBuilder.add("item.opsheeps.op_hoe", "OP Hacke");

		translationBuilder.add("item.opsheeps.grow_back", "Wiederwachs");

		translationBuilder.add("itemgroups.opsheeps.super_items", "OP-Schafe");

		translationBuilder.add("rarity.opsheeps.common", "GEWÖHNLICH");
		translationBuilder.add("rarity.opsheeps.uncommon", "UNGEWÖHNLICH");
		translationBuilder.add("rarity.opsheeps.rare", "SELTEN");
		translationBuilder.add("rarity.opsheeps.epic", "EPISCH");
		translationBuilder.add("rarity.opsheeps.legendary", "LEGENDÄR");
		translationBuilder.add("rarity.opsheeps.dev", "ENTWICKLER");

		translationBuilder.add("item.opsheeps.grow_back_description", "Gibt dem angeklickten Schaf sofort seine Wolle wieder.");
		translationBuilder.add("item.opsheeps.shear_drops", "Das Scheren eines OP Schafs lässt %s Gegenstände fallen.");

		translationBuilder.add("enchantment.opsheeps.mineral_extractor", "Mineralien Erschnüfler");

		translationBuilder.add("item.opsheeps.super_dye_description", "Flüster dein Geheimnis, einem Schaf und siehe was passiert...");

		translationBuilder.add("opsheeps.help.page1", "§lWillkommen bei OPSheeps!\n\nEntdecke fortschrittliche Features, die deiner Kreativität Flügel verleihen. OPSheeps vereint Innovation und Spaß für ein einzigartiges Spielerlebnis.");
		translationBuilder.add("opsheeps.help.page2", "§lSchritt 1: SuperFärbemittel herstellen\n\nSammle seltene Zutaten und nutze die Werkbank, um das SuperFärbemittel zu kreieren – der Schlüssel zu außergewöhnlichen Verwandlungen.");
		translationBuilder.add("opsheeps.help.page3", "§lSchritt 2: Verwandle deine Schafe\n\nTrage das SuperFärbemittel auf deine Schafe auf und beobachte, wie sie sich in lebendige, kraftvolle Wesen verwandeln.");
		translationBuilder.add("opsheeps.help.page4", "§lSchritt 3: Titan-Scheren einsetzen\n\nTitan-Scheren sind dein ultimativer Helfer zum Ernten von Ressourcen. Setze sie ein, um Materialien mühelos zu sammeln und deine Ausrüstung zu verbessern.");
		translationBuilder.add("opsheeps.help.page5", "§lLetzte Tipps\n\nProbiere die vielfältigen Funktionen von OPSheeps aus, entdecke neue Möglichkeiten und sammle seltene Ressourcen. Viel Spaß und möge dein Abenteuer episch werden!");

		translationBuilder.add("command.opsheeps.help.client", "Dieser Befehl kann nur von einem Spieler ausgeführt werden.");
		translationBuilder.add("command.opsheeps.help.book_received", "Du hast das OPSheeps-Hilfebuch erhalten!");

		translationBuilder.add("item.opsheeps.supershear_perk_v5", "§6[OPSheeps] §eSchatz Drop: ");
		translationBuilder.add("item.opsheeps.supershear_perk_v4", "§6[OPSheeps] §bAOE Schur! §7(3x3 Bereich)");
		translationBuilder.add("item.opsheeps.supershear_perk_v2", "§6[OPSheeps] §aExtra Schur! §7(Doppelter Drop)");
		translationBuilder.add("item.opsheeps.supershear_perk_v3", "§6[OPSheeps] §dSeltene Drops! §7(25% Chance auf seltene Items)");
	}

	@Override
	public String getName() {
		return "DE Translation Generator";
	}
}
