// EnchantmentGenerator.java
package com.chilllounge.opsheeps.datagen;

import com.chilllounge.opsheeps.Opsheeps;
import com.chilllounge.opsheeps.enchantment.ModEnchantmentEffects;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class EnchantmentGen extends FabricDynamicRegistryProvider {
	public EnchantmentGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
		register(entries, ModEnchantmentEffects.MINERAL_EXTRACTOR, Enchantment.builder(
						Enchantment.definition(
								registries.getOrThrow(RegistryKeys.ITEM).getOrThrow(ItemTags.PICKAXES),
								3,
								7,
								Enchantment.leveledCost(1, 12),
								Enchantment.leveledCost(1, 18),
								16,
								AttributeModifierSlot.HAND
						)
				)
		);
	}

	private void register(Entries entries, RegistryKey<Enchantment> key, Enchantment.Builder builder, ResourceCondition... resourceConditions) {
		entries.add(key, builder.build(key.getValue()));
	}

	@Override
	public String getName() {
		return "EnchantmentGen";
	}

	public static void registerMineralExtractor() {
		Opsheeps.LOGGER.info("🐑 REGISTER MINERAL EXTRACTOR");
	}
}