package com.chilllounge.opsheep.item.custom;

import com.chilllounge.opsheep.item.OpSetLoot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

import java.util.Random;
import java.util.function.Supplier;

public class LootManager {
	private static final Random random = new Random();
	private static final int NON_OP_MULTIPLIER = 1000;
	private static final int OP_RARE_WEIGHT = 10;

	private record LootEntry(Supplier<ItemStack> stackSupplier, int weight) {
	}

	public static ItemStack[] generateLoot(int opShearVersion, int opDropCount) {
		if (opDropCount <= 0) {
			return new ItemStack[0];
		}

		LootEntry[] lootTable = switch (opShearVersion) {
			case 1 -> generateV1Loot();
			case 2 -> generateV2Loot();
			case 3 -> generateV3Loot();
			case 4 -> generateV4Loot();
			case 5 -> generateV5Loot();
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

	private static LootEntry[] generateV1Loot() {
		return new LootEntry[]{
				new LootEntry(() -> new ItemStack(Items.COBBLESTONE), 6000 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.OAK_LOG), 4000 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.APPLE), 3000 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.DIRT), 3500 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.STONE), 3000 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.SAND), 2500 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.GRASS_BLOCK), 2000 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.BREAD), 1500 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.BOOK), 1500 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.LEATHER), 2000 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.COAL), 2500 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.FLINT), 2000 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(OpSetLoot.OP_CHESTPLATE_V1), 1),
				new LootEntry(() -> new ItemStack(OpSetLoot.OP_LEGGINGS_V1), 1),
				new LootEntry(() -> new ItemStack(OpSetLoot.OP_BOOTS_V1), 1),
				new LootEntry(() -> new ItemStack(OpSetLoot.OP_SWORD_V1), 1)
		};
	}

	private static LootEntry[] generateV2Loot() {
		return new LootEntry[]{
				new LootEntry(() -> new ItemStack(Items.IRON_INGOT), 5000 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.GOLD_INGOT), 4000 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.DIAMOND), 3000 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.NETHERITE_SCRAP), 1500 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.TNT), 1000 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.POTION), 800 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.ENDER_PEARL), 1200 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.BLAZE_POWDER), 1200 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.REDSTONE), 1400 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.LAPIS_LAZULI), 1300 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.QUARTZ), 1100 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.EMERALD), 900 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(OpSetLoot.OP_CHESTPLATE_V1), 1),
				new LootEntry(() -> new ItemStack(OpSetLoot.OP_LEGGINGS_V1), 1),
				new LootEntry(() -> new ItemStack(OpSetLoot.OP_BOOTS_V1), 1),
				new LootEntry(() -> new ItemStack(OpSetLoot.OP_SWORD_V1), 1)
		};
	}

	private static LootEntry[] generateV3Loot() {
		return new LootEntry[]{
				new LootEntry(() -> new ItemStack(Items.IRON_INGOT), 3500 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.GOLD_INGOT), 2500 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.DIAMOND), 1500 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.NETHERITE_SCRAP), 1200 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.NETHERITE_INGOT), 1000 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.ENCHANTED_GOLDEN_APPLE), 800 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.TNT), 600 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.POTION), 500 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.ENDER_PEARL), 700 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.BLAZE_POWDER), 700 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.REDSTONE), 900 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.OBSIDIAN), 800 * NON_OP_MULTIPLIER),

				new LootEntry(() -> new ItemStack(OpSetLoot.OP_CHESTPLATE_V1), 1),
				new LootEntry(() -> new ItemStack(OpSetLoot.OP_LEGGINGS_V1), 1),
				new LootEntry(() -> new ItemStack(OpSetLoot.OP_BOOTS_V1), 1),
				new LootEntry(() -> new ItemStack(OpSetLoot.OP_SWORD_V1), 1),
				new LootEntry(() -> new ItemStack(OpSetLoot.OP_CHESTPLATE_V2), OP_RARE_WEIGHT),
				new LootEntry(() -> new ItemStack(OpSetLoot.OP_LEGGINGS_V2), OP_RARE_WEIGHT),
				new LootEntry(() -> new ItemStack(OpSetLoot.OP_BOOTS_V2), OP_RARE_WEIGHT),
				new LootEntry(() -> new ItemStack(OpSetLoot.OP_SWORD_V2), OP_RARE_WEIGHT)
		};
	}

	private static LootEntry[] generateV4Loot() {
		return new LootEntry[]{
				new LootEntry(() -> new ItemStack(Items.IRON_BLOCK), 4500 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.GOLD_BLOCK), 3000 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.DIAMOND_BLOCK), 2000 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.NETHERITE_SCRAP), 500 * NON_OP_MULTIPLIER),

				new LootEntry(() -> new ItemStack(OpSetLoot.OP_CHESTPLATE_V2), OP_RARE_WEIGHT),
				new LootEntry(() -> new ItemStack(OpSetLoot.OP_LEGGINGS_V2), OP_RARE_WEIGHT),
				new LootEntry(() -> new ItemStack(OpSetLoot.OP_BOOTS_V2), OP_RARE_WEIGHT),
				new LootEntry(() -> new ItemStack(OpSetLoot.OP_SWORD_V2), OP_RARE_WEIGHT),
				new LootEntry(() -> new ItemStack(OpSetLoot.OP_PICKAXE_V2), OP_RARE_WEIGHT),
				new LootEntry(() -> new ItemStack(OpSetLoot.OP_AXE_V2), OP_RARE_WEIGHT),
				new LootEntry(() -> new ItemStack(OpSetLoot.OP_SHOVEL_V2), OP_RARE_WEIGHT),
				new LootEntry(() -> new ItemStack(OpSetLoot.OP_HOE_V2), OP_RARE_WEIGHT)
		};
	}

	private static LootEntry[] generateV5Loot() {
		return new LootEntry[]{
				new LootEntry(() -> new ItemStack(Items.IRON_BLOCK), 500 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.GOLD_BLOCK), 200 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.DIAMOND_BLOCK), 1000 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.NETHERITE_SCRAP), 300 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.NETHERITE_BLOCK), NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.ENCHANTED_GOLDEN_APPLE), 200 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.TNT), 100 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.REDSTONE_BLOCK), 150 * NON_OP_MULTIPLIER),

				new LootEntry(() -> new ItemStack(OpSetLoot.OP_CHESTPLATE_V2), OP_RARE_WEIGHT),
				new LootEntry(() -> new ItemStack(OpSetLoot.OP_LEGGINGS_V2), OP_RARE_WEIGHT),
				new LootEntry(() -> new ItemStack(OpSetLoot.OP_BOOTS_V2), OP_RARE_WEIGHT),
				new LootEntry(() -> new ItemStack(OpSetLoot.OP_SWORD_V2), OP_RARE_WEIGHT)
		};
	}

	private static LootEntry[] generateDeveloperLoot() {
		return new LootEntry[]{
				new LootEntry(() -> new ItemStack(Items.IRON_BLOCK), 500 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.GOLD_BLOCK), 200 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.DIAMOND_BLOCK), 1000 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.NETHERITE_SCRAP), 300 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.NETHERITE_BLOCK), NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.ENCHANTED_GOLDEN_APPLE), 200 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.TNT), 100 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.REDSTONE_BLOCK), 150 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(OpSetLoot.OP_CHESTPLATE_V2), OP_RARE_WEIGHT),
				new LootEntry(() -> new ItemStack(OpSetLoot.OP_LEGGINGS_V2), OP_RARE_WEIGHT),
				new LootEntry(() -> new ItemStack(OpSetLoot.OP_BOOTS_V2), OP_RARE_WEIGHT),
				new LootEntry(() -> new ItemStack(OpSetLoot.OP_SWORD_V2), OP_RARE_WEIGHT),
				new LootEntry(() -> new ItemStack(Items.IRON_BLOCK), 4500 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.GOLD_BLOCK), 3000 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.DIAMOND_BLOCK), 2000 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.NETHERITE_SCRAP), 500 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.IRON_INGOT), 3500 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.GOLD_INGOT), 2500 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.DIAMOND), 1500 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.NETHERITE_SCRAP), 1200 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.NETHERITE_INGOT), 1000 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.ENCHANTED_GOLDEN_APPLE), 800 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.TNT), 600 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.ENDER_PEARL), 700 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.BLAZE_POWDER), 700 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.REDSTONE), 900 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(Items.OBSIDIAN), 800 * NON_OP_MULTIPLIER),
				new LootEntry(() -> new ItemStack(OpSetLoot.OP_CHESTPLATE_V1), 1),
				new LootEntry(() -> new ItemStack(OpSetLoot.OP_LEGGINGS_V1), 1),
				new LootEntry(() -> new ItemStack(OpSetLoot.OP_BOOTS_V1), 1),
				new LootEntry(() -> new ItemStack(OpSetLoot.OP_SWORD_V1), 1),
				new LootEntry(() -> new ItemStack(OpSetLoot.OP_PICKAXE_V2), OP_RARE_WEIGHT),
				new LootEntry(() -> new ItemStack(OpSetLoot.OP_AXE_V2), OP_RARE_WEIGHT),
				new LootEntry(() -> new ItemStack(OpSetLoot.OP_SHOVEL_V2), OP_RARE_WEIGHT),
				new LootEntry(() -> new ItemStack(OpSetLoot.OP_HOE_V2), OP_RARE_WEIGHT),
		};
	}

	private static LootEntry[] generateFallbackLoot() {
		return new LootEntry[]{
				new LootEntry(() -> new ItemStack(Items.BARRIER), 100 * NON_OP_MULTIPLIER)
		};
	}
}
