package com.chilllounge.opsheep.enchantment.effect;

import com.chilllounge.opsheep.enchantment.OpSheepEnchantmentEffects;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;

public class MineralExtractorHandler {

	public static void register() {
		PlayerBlockBreakEvents.AFTER.register((world, player, pos, state, blockEntity) -> {
			if (!world.isClient && world instanceof ServerWorld serverWorld) {
				ItemStack tool = player.getMainHandStack();

				if (player.isCreative()) {
					return;
				}

				if (!state.isIn(BlockTags.PICKAXE_MINEABLE)) {
					return;
				}

				DynamicRegistryManager registryManager = serverWorld.getRegistryManager();
				Registry<Enchantment> enchantmentRegistry = registryManager.getOrThrow(RegistryKeys.ENCHANTMENT);

				RegistryEntry<Enchantment> enchantmentEntry = enchantmentRegistry.getOrThrow(OpSheepEnchantmentEffects.MINERAL_EXTRACTOR);
				Enchantment enchantment = enchantmentEntry.value();

				int level = EnchantmentHelper.getLevel(enchantmentEntry, tool);
				if (level > 0) {
					MineralExtractorEffects.applyBlockEffect(serverWorld, pos, level);
				}
			}
		});
	}
}
