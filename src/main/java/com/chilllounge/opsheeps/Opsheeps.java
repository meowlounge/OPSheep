package com.chilllounge.opsheeps;

import com.chilllounge.opsheeps.command.HelpCommand;
import com.chilllounge.opsheeps.enchantment.ModEnchantmentEffects;
import com.chilllounge.opsheeps.enchantment.effect.MineralExtractorHandler;
import com.chilllounge.opsheeps.item.ModItemGroups;
import com.chilllounge.opsheeps.item.ModItems;
import com.chilllounge.opsheeps.item.OpSetLoot;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Opsheeps implements ModInitializer {
	public static final String MOD_ID = "opsheeps";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final boolean DEV_MODE = false;

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		OpSetLoot.registerLootTableItems();
		ModEnchantmentEffects.registerModEnchantmentEffects();
		MineralExtractorHandler.register();

		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> HelpCommand.register(dispatcher));
	}
}