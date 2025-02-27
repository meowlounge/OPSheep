package com.chilllounge.opsheeps.enchantment;

import com.chilllounge.opsheeps.Opsheeps;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class OpSheepsEnchantmentEffects {
	public static final RegistryKey<Enchantment> MINERAL_EXTRACTOR = of("mineral_extractor");

	private static RegistryKey<Enchantment> of(String path) {
		Identifier id = Identifier.of(Opsheeps.MOD_ID, path);
		return RegistryKey.of(RegistryKeys.ENCHANTMENT, id);
	}

	public static void registerModEnchantmentEffects() {
		Opsheeps.LOGGER.info("🐑 REGISTERING CUSTOM ENCHANTMENTS");
	}
}
