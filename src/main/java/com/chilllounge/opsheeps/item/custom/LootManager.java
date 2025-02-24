package com.chilllounge.opsheeps.item.custom;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

import java.util.Random;
import java.util.function.Supplier;

public class LootManager {

    private static final Random random = new Random();
    private record LootEntry(Supplier<ItemStack> stackSupplier, int weight) {}

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
                new LootEntry(() -> new ItemStack(Items.APPLE), 10),
                new LootEntry(() -> new ItemStack(Items.BREAD), 5),
                new LootEntry(() -> new ItemStack(Items.WHEAT), 8),
                new LootEntry(() -> new ItemStack(Items.WHITE_WOOL), 10),
                new LootEntry(() -> new ItemStack(Items.STICK), 10),
                new LootEntry(() -> new ItemStack(Items.OAK_LOG), 8),
                new LootEntry(() -> new ItemStack(Items.STRING), 10),
                new LootEntry(() -> new ItemStack(Items.IRON_INGOT), 2),
                new LootEntry(() -> new ItemStack(Items.COAL), 2),
                new LootEntry(() -> new ItemStack(Items.PUMPKIN), 3)
        };
    }

    private static LootEntry[] generateCaveLoot() {
        return new LootEntry[]{
                new LootEntry(() -> new ItemStack(Items.COBBLESTONE), 150),
                new LootEntry(() -> new ItemStack(Items.COAL), 200),
                new LootEntry(() -> new ItemStack(Items.RAW_GOLD), 15),
                new LootEntry(() -> new ItemStack(Items.RAW_IRON), 15),
                new LootEntry(() -> new ItemStack(Items.RAW_COPPER), 15),
                new LootEntry(() -> new ItemStack(Items.IRON_INGOT), 15),
                new LootEntry(() -> new ItemStack(Items.GOLD_INGOT), 8),
                new LootEntry(() -> new ItemStack(Items.REDSTONE), 10),
                new LootEntry(() -> new ItemStack(Items.LAPIS_LAZULI), 10),
                new LootEntry(() -> new ItemStack(Items.DIAMOND), 2),
                new LootEntry(() -> new ItemStack(Items.EMERALD), 1),
                new LootEntry(() -> new ItemStack(Items.COPPER_INGOT), 5)
        };
    }

    private static LootEntry[] generateNetherLoot() {
        return new LootEntry[]{
                new LootEntry(() -> new ItemStack(Items.NETHER_BRICKS), 1500),
                new LootEntry(() -> new ItemStack(Items.BLAZE_POWDER), 1000),
                new LootEntry(() -> new ItemStack(Items.GLOWSTONE_DUST), 1000),
                new LootEntry(() -> new ItemStack(Items.NETHER_WART), 800),
                new LootEntry(() -> new ItemStack(Items.QUARTZ), 120),
                new LootEntry(() -> new ItemStack(Items.SOUL_SAND), 100),
                new LootEntry(() -> new ItemStack(Items.MAGMA_CREAM), 50),
                new LootEntry(() -> new ItemStack(Items.NETHERITE_SCRAP), 3),
                new LootEntry(() -> new ItemStack(Items.GOLD_BLOCK), 5)
        };
    }

    private static LootEntry[] generateEndLoot() {
        return new LootEntry[]{
                new LootEntry(() -> new ItemStack(Items.END_STONE), 1500),
                new LootEntry(() -> new ItemStack(Items.PURPUR_BLOCK), 1000),
                new LootEntry(() -> new ItemStack(Items.ENDER_PEARL), 15),
                new LootEntry(() -> new ItemStack(Items.ENDER_EYE), 10),
                new LootEntry(() -> new ItemStack(Items.CHORUS_FRUIT), 10),
                new LootEntry(() -> new ItemStack(Items.POPPED_CHORUS_FRUIT), 8),
                new LootEntry(() -> new ItemStack(Items.END_ROD), 10),
                new LootEntry(() -> new ItemStack(Items.SHULKER_SHELL), 5),
                new LootEntry(() -> new ItemStack(Items.DRAGON_BREATH), 2),
                new LootEntry(() -> new ItemStack(Items.ELYTRA), 1),
                new LootEntry(() -> new ItemStack(Items.NETHERITE_BLOCK), 1)
        };
    }

    // 5. Final Stage loot: a mix of items from all themes with much more op loot.
    private static LootEntry[] generateFinalStageLoot() {
        return new LootEntry[]{
                new LootEntry(() -> new ItemStack(Items.IRON_INGOT), 5000),
                new LootEntry(() -> new ItemStack(Items.GOLD_INGOT), 4000),
                new LootEntry(() -> new ItemStack(Items.DIAMOND), 3000),
                new LootEntry(() -> new ItemStack(Items.NETHERITE_SCRAP), 300),
                // Netherite block stays extremely rare.
                new LootEntry(() -> new ItemStack(Items.NETHERITE_BLOCK), 1),
                new LootEntry(() -> new ItemStack(Items.ENCHANTED_GOLDEN_APPLE), 200),
                new LootEntry(() -> new ItemStack(Items.TNT), 100),
                new LootEntry(() -> new ItemStack(Items.POTION), 50),
                // Include some thematic items from other dimensions.
                new LootEntry(() -> new ItemStack(Items.ENDER_PEARL), 100),
                new LootEntry(() -> new ItemStack(Items.BLAZE_POWDER), 100),
                new LootEntry(() -> new ItemStack(Items.REDSTONE), 150)
        };
    }

    // Developer loot: intentionally overpowered and varied for testing purposes.
    private static LootEntry[] generateDeveloperLoot() {
        return new LootEntry[]{
                new LootEntry(() -> new ItemStack(Items.NETHERITE_BLOCK), 10),
                new LootEntry(() -> new ItemStack(Items.NETHERITE_INGOT), 10),
                new LootEntry(() -> new ItemStack(Items.DIAMOND), 10),
                new LootEntry(() -> new ItemStack(Items.GOLD_INGOT), 8),
                new LootEntry(() -> new ItemStack(Items.IRON_INGOT), 6),
                new LootEntry(() -> new ItemStack(Items.NETHERITE_SCRAP), 4),
                new LootEntry(() -> new ItemStack(Items.ENCHANTED_GOLDEN_APPLE), 2),
                new LootEntry(() -> new ItemStack(Items.TNT), 5),
                new LootEntry(() -> new ItemStack(Items.APPLE), 5)
        };
    }

    // Fallback loot: a basic item in case of an unknown version.
    private static LootEntry[] generateFallbackLoot() {
        return new LootEntry[]{
                new LootEntry(() -> new ItemStack(Items.WHITE_WOOL), 10)
        };
    }
}
