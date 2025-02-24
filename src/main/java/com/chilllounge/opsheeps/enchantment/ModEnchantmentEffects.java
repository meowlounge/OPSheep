package com.chilllounge.opsheeps.enchantment;

import com.chilllounge.opsheeps.Opsheeps;
import com.chilllounge.opsheeps.enchantment.effect.MineralExtractorEnchantmentEffect;
import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModEnchantmentEffects {
	public static final RegistryKey<Enchantment> MINERAL_EXTRACTOR = of("mineral_extractor");
	public static MapCodec<MineralExtractorEnchantmentEffect> MINERAL_EXTRACTOR_EFFECT = register("mineral_extractor_effect", MineralExtractorEnchantmentEffect.CODEC);

	private static RegistryKey<Enchantment> of(String path) {
		Identifier id = Identifier.of(Opsheeps.MOD_ID, path);
		return RegistryKey.of(RegistryKeys.ENCHANTMENT, id);
	}

	private static <T extends EnchantmentEntityEffect> MapCodec<T> register(String id, MapCodec<T> codec) {
		return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.of(Opsheeps.MOD_ID, id), codec);
	}

	public static void registerModEnchantmentEffects() {
		Opsheeps.LOGGER.info("🐑 REGISTER ITEMGROUPS");
	}
}
