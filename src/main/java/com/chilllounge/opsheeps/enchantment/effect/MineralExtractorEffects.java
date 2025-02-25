// MineralExtractorEffects.java
package com.chilllounge.opsheeps.enchantment.effect;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.entity.ItemEntity;
import net.minecraft.util.math.random.Random;
import java.util.List;

public class MineralExtractorEffects {
    private static final List<ItemStack> MINERAL_DROPS = List.of(
            new ItemStack(Items.IRON_INGOT),
            new ItemStack(Items.GOLD_INGOT),
            new ItemStack(Items.COPPER_INGOT),
            new ItemStack(Items.DIAMOND),
            new ItemStack(Items.EMERALD),
            new ItemStack(Items.REDSTONE, 2),
            new ItemStack(Items.LAPIS_LAZULI, 2)
    );

    public static void applyBlockEffect(ServerWorld world, BlockPos pos, int level) {
        float chanceValue = 3 * level;
        float dropChance = chanceValue / 100f;
        Random random = world.getRandom();
        if (random.nextFloat() < dropChance) {
            ItemStack drop = MINERAL_DROPS.get(random.nextInt(MINERAL_DROPS.size()));
            ItemEntity itemEntity = new ItemEntity(world,
                    pos.getX() + 0.5,
                    pos.getY() + 1.0,
                    pos.getZ() + 0.5,
                    drop
            );
            world.spawnEntity(itemEntity);
        }
    }
}
