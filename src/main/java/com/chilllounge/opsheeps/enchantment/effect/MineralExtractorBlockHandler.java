package com.chilllounge.opsheeps.enchantment.effect;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import com.chilllounge.opsheeps.enchantment.ModEnchantmentEffects;

public class MineralExtractorBlockHandler {
    public static void register() {
        PlayerBlockBreakEvents.AFTER.register((world, player, pos, state, blockEntity) -> {
            if (!world.isClient && world instanceof ServerWorld serverWorld) {
                ItemStack tool = player.getMainHandStack();

                // Holt die Enchantment-Registry
                DynamicRegistryManager registryManager = serverWorld.getRegistryManager();
                Registry<Enchantment> enchantmentRegistry = registryManager.getOrThrow(RegistryKeys.ENCHANTMENT);

                // Holt das Enchantment als RegistryEntry und extrahiert das Enchantment-Objekt
                RegistryEntry<Enchantment> enchantmentEntry = enchantmentRegistry.getOrThrow(ModEnchantmentEffects.MINERAL_EXTRACTOR);
                Enchantment enchantment = enchantmentEntry.value(); // <--- HIER DER FIX

                // Enchantment-Level aus dem Tool abrufen
                int level = EnchantmentHelper.getLevel(enchantmentEntry, tool);
                if (level > 0) {
                    MineralExtractorEffects.applyBlockEffect(serverWorld, pos, level);
                }
            }
        });
    }
}
