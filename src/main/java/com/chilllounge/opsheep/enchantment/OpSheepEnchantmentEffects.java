package com.chilllounge.opsheep.enchantment;

import com.chilllounge.opsheep.Opsheep;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class OpSheepEnchantmentEffects {
	public static final RegistryKey<Enchantment> MINERAL_EXTRACTOR = of("mineral_extractor");

	private static RegistryKey<Enchantment> of(String path) {
		Identifier id = Identifier.of(Opsheep.MOD_ID, path);
		return RegistryKey.of(RegistryKeys.ENCHANTMENT, id);
	}

	public static void registerModEnchantmentEffects() {
		Opsheep.LOGGER.info("🐑 REGISTERING CUSTOM ENCHANTMENTS");
	}
}
