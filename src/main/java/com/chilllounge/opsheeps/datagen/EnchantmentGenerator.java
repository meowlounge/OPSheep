package com.chilllounge.opsheeps.datagen;

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

//import com.chilllounge.opsheeps.enchantment.effect.MineralExtractorEnchantmentEffect;
//import net.minecraft.component.EnchantmentEffectComponentTypes;
//import net.minecraft.enchantment.EnchantmentLevelBasedValue;
//import net.minecraft.enchantment.effect.EnchantmentEffectTarget;

public class EnchantmentGenerator extends FabricDynamicRegistryProvider {
	public EnchantmentGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
		System.out.println("REGISTERING ENCHANTS");
	}

	@Override
	protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
		register(entries, ModEnchantmentEffects.MINERAL_EXTRACTOR, Enchantment.builder(
								Enchantment.definition(
										registries.getOrThrow(RegistryKeys.ITEM).getOrThrow(ItemTags.PICKAXES),
										8,
										5,
										Enchantment.leveledCost(1, 12),
										Enchantment.leveledCost(1, 18),
										6,
										AttributeModifierSlot.HAND
								)
						)
//						.addEffect(
//								EnchantmentEffectComponentTypes.POST_ATTACK,
//								EnchantmentEffectTarget.ATTACKER,
//								EnchantmentEffectTarget.VICTIM,
//								new MineralExtractorEnchantmentEffect(EnchantmentLevelBasedValue.linear(1.0f, 1.0f))
//						)
		);
	}

	private void register(Entries entries, RegistryKey<Enchantment> key, Enchantment.Builder builder, ResourceCondition... resourceConditions) {
		entries.add(key, builder.build(key.getValue()));
	}

	@Override
	public String getName() {
		return "ReferenceDocEnchantmentGenerator";
	}
}
