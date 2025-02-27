package com.chilllounge.opsheeps.item.custom;

import com.chilllounge.opsheeps.item.OpSetLoot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

import java.util.Random;
import java.util.function.Supplier;

public class LootManager {
	private static final Random random = new Random();
	private static final int NON_OP_MULTIPLIER = 1000;
	private static final int OP_RARE_WEIGHT = 3;

	private record LootEntry(Supplier<ItemStack> stackSupplier, int weight) {
	}

	public static ItemStack[] generateLoot(int opShearVersion, int opDropCount) {
		if (opDropCount <= 0) {
			return new ItemStack[0];
		}

		LootEntry[] lootTable = switch (opShearVersion) {
			case 1 -> generateOverworldLoot();
			case 2 -> generateCaveLoot();
			case 3 -> generateNetherLoot();
			case 4 -> generateEndLoot();
			case 5 -> generateFinalStageLoot();
			case 69 -> generateDeveloperLoot();
			default -> generateFallbackLoot();
		};

		int totalWeight = 0;
		for (LootEntry entry : lootTable) {
			totalWeight += entry.weight;
		}

		ItemStack[] drops = new ItemStack[opDropCount];
		for (int i = 0; i < opDropCount; i++) {
			int rand = random.nextInt(totalWeight);
			int cumulative = 0;
			for (LootEntry entry : lootTable) {
				cumulative += entry.weight;
				if (rand < cumulative) {
					drops[i] = entry.stackSupplier.get();
					break;
				}
			}
		}
		return drops;
	}

	private static LootEntry[] generateOverworldLoot() {
		return new LootEntry[]{
				new LootEntry(() -> new ItemStack(Items.APPLE), 10 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.BREAD), 5 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.WHEAT), 8 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.WHITE_WOOL), 10 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.STICK), 10 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.OAK_LOG), 8 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.STRING), 10 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.IRON_INGOT), 2 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.COAL), 2 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.PUMPKIN), 3 * NON_OP_MULTIPLIER)
		};
	}

	private static LootEntry[] generateCaveLoot() {
		return new LootEntry[]{
				new LootEntry(() -> new ItemStack(Items.COBBLESTONE), 150 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.COAL), 200 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.RAW_GOLD), 15 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.RAW_IRON), 15 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.RAW_COPPER), 15 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.IRON_INGOT), 15 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.GOLD_INGOT), 8 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.REDSTONE), 10 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.LAPIS_LAZULI), 10 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.DIAMOND), 2 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.EMERALD), NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.COPPER_INGOT), 5 * NON_OP_MULTIPLIER)
		};
	}

	private static LootEntry[] generateNetherLoot() {
		return new LootEntry[]{
				new LootEntry(() -> new ItemStack(Items.NETHER_BRICKS), 1500 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.BLAZE_POWDER), 1000 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.GLOWSTONE_DUST), 1000 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.NETHER_WART), 800 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.QUARTZ), 120 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.SOUL_SAND), 100 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.MAGMA_CREAM), 50 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.NETHERITE_SCRAP), 3 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.GOLD_BLOCK), 5 * NON_OP_MULTIPLIER)
		};
	}

	// End loot now carries a couple of OP items—one tool and one armor piece—making it feel rewarding without overloading one table.
	private static LootEntry[] generateEndLoot() {
		return new LootEntry[]{
				new LootEntry(() -> new ItemStack(Items.END_STONE), 1500 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.PURPUR_BLOCK), 1000 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.ENDER_PEARL), 15 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.ENDER_EYE), 10 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.CHORUS_FRUIT), 10 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.POPPED_CHORUS_FRUIT), 8 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.END_ROD), 10 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.SHULKER_SHELL), 5 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.DRAGON_BREATH), 2 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.ELYTRA), NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.NETHERITE_BLOCK), NON_OP_MULTIPLIER),
				// Spread OP items into End loot.
				new LootEntry(() -> new ItemStack(OpSetLoot.OP_PICKAXE_V1), OP_RARE_WEIGHT),
				new LootEntry(() -> new ItemStack(OpSetLoot.OP_HELMET_V2), OP_RARE_WEIGHT)
		};
	}

	// Final Stage loot now contains the majority of the OP armor pieces and a single OP weapon.
	private static LootEntry[] generateFinalStageLoot() {
		return new LootEntry[]{
				new LootEntry(() -> new ItemStack(Items.IRON_INGOT), 5000 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.GOLD_INGOT), 4000 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.DIAMOND), 3000 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.NETHERITE_SCRAP), 300 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.NETHERITE_BLOCK), NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.ENCHANTED_GOLDEN_APPLE), 200 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.TNT), 100 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.POTION), 50 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.ENDER_PEARL), 100 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.BLAZE_POWDER), 100 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.REDSTONE), 150 * NON_OP_MULTIPLIER),
				// Spread OP armor and one OP weapon here.
				new LootEntry(() -> new ItemStack(OpSetLoot.OP_CHESTPLATE_V2), OP_RARE_WEIGHT),
				new LootEntry(() -> new ItemStack(OpSetLoot.OP_LEGGINGS_V2), OP_RARE_WEIGHT),
				new LootEntry(() -> new ItemStack(OpSetLoot.OP_BOOTS_V2), OP_RARE_WEIGHT),
				new LootEntry(() -> new ItemStack(OpSetLoot.OP_SWORD_V2), OP_RARE_WEIGHT)
		};
	}

	// Developer loot now gets the remaining OP tools.
	private static LootEntry[] generateDeveloperLoot() {
		return new LootEntry[]{
				new LootEntry(() -> new ItemStack(Items.NETHERITE_BLOCK), 10 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.NETHERITE_INGOT), 10 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.DIAMOND), 10 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.GOLD_INGOT), 8 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.IRON_INGOT), 6 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.NETHERITE_SCRAP), 4 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.ENCHANTED_GOLDEN_APPLE), 2 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.TNT), 5 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.APPLE), 5 * NON_OP_MULTIPLIER),

				new LootEntry(() -> new ItemStack(OpSetLoot.OP_PICKAXE_V2), OP_RARE_WEIGHT),
				new LootEntry(() -> new ItemStack(OpSetLoot.OP_AXE_V2), OP_RARE_WEIGHT),
				new LootEntry(() -> new ItemStack(OpSetLoot.OP_SHOVEL_V2), OP_RARE_WEIGHT),
				new LootEntry(() -> new ItemStack(OpSetLoot.OP_HOE_V2), OP_RARE_WEIGHT)
		};
	}

	private static LootEntry[] generateFallbackLoot() {
		return new LootEntry[]{
				new LootEntry(() -> new ItemStack(Items.WHITE_WOOL), 10 * NON_OP_MULTIPLIER)
		};
	}
}
