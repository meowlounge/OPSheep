package com.chilllounge.opsheep;

import com.chilllounge.opsheep.command.HelpCommand;
import com.chilllounge.opsheep.datagen.EnchantmentGen;
import com.chilllounge.opsheep.enchantment.OpSheepEnchantmentEffects;
import com.chilllounge.opsheep.enchantment.effect.MineralExtractorHandler;
import com.chilllounge.opsheep.item.OpSetLoot;
import com.chilllounge.opsheep.item.OpSheepItemGroups;
import com.chilllounge.opsheep.item.OpSheepItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Opsheep implements ModInitializer {
	public static final String MOD_ID = "opsheep";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final boolean DEV_MODE = false;

	@Override
	public void onInitialize() {
		OpSheepItemGroups.registerItemGroups();
		OpSheepItems.registerModItems();
		OpSetLoot.registerLootTableItems();
		OpSheepEnchantmentEffects.registerModEnchantmentEffects();
		EnchantmentGen.registerCustomEnchantments();
		MineralExtractorHandler.register();
		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> HelpCommand.register(dispatcher));
	}
}