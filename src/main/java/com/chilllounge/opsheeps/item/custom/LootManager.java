package com.chilllounge.opsheeps.item.custom;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

import java.util.Random;

public class LootManager {

    private static final Random random = new Random();

    public static ItemStack[] generateLoot(int opShearVersion, int opDropCount) {
        ItemStack[] lootTable = switch (opShearVersion) {
            case 1 -> generateEarlyGameLoot();  // Expected to drop 4 items
            case 2 -> generateMidTierLoot();    // Expected to drop 8 items
            case 3 -> generateLateGameLoot();   // Expected to drop 32 items
            case 4 -> generateHighTierLoot();   // Expected to drop 64 items
            case 5 -> generateUltraTierLoot();  // Expected to drop 128 items
            case 69 -> generateDeveloperLoot(); // Expected to drop 512 items (Developer/Test loot)
            default -> generateFallbackLoot();
        };

        ItemStack[] drops = new ItemStack[opDropCount];
        for (int i = 0; i < opDropCount; i++) {
            drops[i] = lootTable[random.nextInt(lootTable.length)];
        }

        return drops;
    }

    private static ItemStack[] generateEarlyGameLoot() {
        // Early game: modest quantities (4 drops expected)
        return new ItemStack[]{
                new ItemStack(Items.STRING, random.nextInt(3) + 2),   // 2-4
                new ItemStack(Items.LEATHER, random.nextInt(2) + 1),  // 1-2
                new ItemStack(Items.FEATHER, random.nextInt(3) + 2),  // 2-4
                new ItemStack(Items.WHEAT, random.nextInt(3) + 1),    // 1-3
                new ItemStack(Items.COAL, random.nextInt(2) + 1)      // 1-2
        };
    }

    private static ItemStack[] generateMidTierLoot() {
        // Mid-tier: slightly higher but still conservative amounts (8 drops expected)
        return new ItemStack[]{
                new ItemStack(Items.IRON_INGOT, random.nextInt(2) + 1),         // 1-2
                new ItemStack(Items.GOLD_INGOT, random.nextInt(2) + 1),           // 1-2
                new ItemStack(Items.EXPERIENCE_BOTTLE, random.nextInt(6) + 4),      // 4-9
                new ItemStack(Items.EMERALD, random.nextInt(2) + 1),              // 1-2
                new ItemStack(Items.LAPIS_LAZULI, random.nextInt(4) + 2),         // 2-5
                new ItemStack(Items.REDSTONE, random.nextInt(4) + 3),             // 3-6
                new ItemStack(Items.COPPER_INGOT, random.nextInt(3) + 2)          // 2-4
        };
    }

    private static ItemStack[] generateLateGameLoot() {
        // Late game: lower ranges per drop to account for many (32) drops
        return new ItemStack[]{
                new ItemStack(Items.DIAMOND, random.nextInt(2) + 1),           // 1-2
                new ItemStack(Items.NETHERITE_SCRAP, random.nextInt(2) + 1),     // 1-2
                new ItemStack(Items.TOTEM_OF_UNDYING),                           // Fixed 1
                new ItemStack(Items.GOLDEN_CARROT, random.nextInt(3) + 2),       // 2-4
                new ItemStack(Items.ENDER_PEARL, random.nextInt(2) + 1),         // 1-2
                new ItemStack(Items.BLAZE_POWDER, random.nextInt(3) + 2),        // 2-4
                new ItemStack(Items.OBSIDIAN, random.nextInt(2) + 1)             // 1-2
        };
    }

    private static ItemStack[] generateHighTierLoot() {
        // High tier: with 64 drops expected, duplicate common items to weight down ultra-powerful items.
        return new ItemStack[]{
                // Rare/op items (appear only once)
                new ItemStack(Items.NETHERITE_INGOT),
                new ItemStack(Items.ELYTRA),
                new ItemStack(Items.TURTLE_HELMET),

                // More common items (duplicated for higher chance)
                new ItemStack(Items.SHULKER_SHELL, random.nextInt(3) + 1),   // 1-3
                new ItemStack(Items.SHULKER_SHELL, random.nextInt(3) + 1),

                new ItemStack(Items.BLAZE_ROD, random.nextInt(3) + 2),       // 2-4
                new ItemStack(Items.BLAZE_ROD, random.nextInt(3) + 2),

                new ItemStack(Items.PHANTOM_MEMBRANE, random.nextInt(2) + 1),  // 1-2
                new ItemStack(Items.PHANTOM_MEMBRANE, random.nextInt(2) + 1),

                new ItemStack(Items.CHORUS_FRUIT, random.nextInt(4) + 3),      // 3-6
                new ItemStack(Items.CHORUS_FRUIT, random.nextInt(4) + 3),

                new ItemStack(Items.END_ROD, random.nextInt(2) + 1),           // 1-2
                new ItemStack(Items.END_ROD, random.nextInt(2) + 1)
        };
    }

    private static ItemStack[] generateUltraTierLoot() {
        // Ultra tier: with 128 drops expected, rare items are only in a few entries while common items are duplicated.
        return new ItemStack[]{
                // Rare/op items (appear only once)
                new ItemStack(Items.BEACON),
                new ItemStack(Items.NETHERITE_BLOCK),
                new ItemStack(Items.NETHER_STAR),
                new ItemStack(Items.ENCHANTED_GOLDEN_APPLE),

                // More common items (duplicated)
                new ItemStack(Items.END_CRYSTAL, random.nextInt(2) + 1),       // 1-2
                new ItemStack(Items.END_CRYSTAL, random.nextInt(2) + 1),

                new ItemStack(Items.DRAGON_BREATH, random.nextInt(4) + 4),       // 4-7
                new ItemStack(Items.DRAGON_BREATH, random.nextInt(4) + 4),

                new ItemStack(Items.SHULKER_SHELL, random.nextInt(3) + 3),       // 3-5
                new ItemStack(Items.SHULKER_SHELL, random.nextInt(3) + 3),

                new ItemStack(Items.TOTEM_OF_UNDYING, random.nextInt(1) + 1),      // Fixed 1
                new ItemStack(Items.TOTEM_OF_UNDYING, random.nextInt(1) + 1),

                new ItemStack(Items.EXPERIENCE_BOTTLE, random.nextInt(8) + 8),     // 8-15
                new ItemStack(Items.EXPERIENCE_BOTTLE, random.nextInt(8) + 8),

                new ItemStack(Items.GOLD_BLOCK, random.nextInt(2) + 1),          // 1-2
                new ItemStack(Items.GOLD_BLOCK, random.nextInt(2) + 1)
        };
    }

    private static ItemStack[] generateDeveloperLoot() {
        // Developer loot remains intentionally overpowered for testing (512 drops expected)
        return new ItemStack[]{
                new ItemStack(Items.DRAGON_EGG),
                new ItemStack(Items.NETHERITE_BLOCK, random.nextInt(2) + 1),
                new ItemStack(Items.EMERALD_BLOCK, random.nextInt(3) + 1),
                new ItemStack(Items.DIAMOND_BLOCK, random.nextInt(3) + 1),
                new ItemStack(Items.BEACON),
                new ItemStack(Items.TOTEM_OF_UNDYING, random.nextInt(5) + 1),
                new ItemStack(Items.ENCHANTED_GOLDEN_APPLE),
                new ItemStack(Items.NETHERITE_INGOT, random.nextInt(2) + 1),
                new ItemStack(Items.ELYTRA),
                new ItemStack(Items.SHULKER_SHELL, random.nextInt(6) + 2),
                new ItemStack(Items.BLAZE_ROD, random.nextInt(5) + 2),
                new ItemStack(Items.PHANTOM_MEMBRANE, random.nextInt(4) + 1),
                new ItemStack(Items.DIAMOND, random.nextInt(5) + 2),
                new ItemStack(Items.NETHERITE_SCRAP, random.nextInt(3) + 1),
                new ItemStack(Items.TOTEM_OF_UNDYING),
                new ItemStack(Items.GOLDEN_CARROT, random.nextInt(5) + 2),
                new ItemStack(Items.ENDER_PEARL, random.nextInt(5) + 2),
                new ItemStack(Items.ENDER_DRAGON_SPAWN_EGG),
                new ItemStack(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, random.nextInt(2) + 1),
                new ItemStack(Items.DRAGON_HEAD)
        };
    }

    private static ItemStack[] generateFallbackLoot() {
        return new ItemStack[]{
                new ItemStack(Items.BONE, random.nextInt(3) + 1),
                new ItemStack(Items.ROTTEN_FLESH, random.nextInt(4) + 2),
                new ItemStack(Items.SKELETON_SKULL),
                new ItemStack(Items.SPIDER_EYE, random.nextInt(2) + 1),
                new ItemStack(Items.FLINT, random.nextInt(3) + 1)
        };
    }
}
