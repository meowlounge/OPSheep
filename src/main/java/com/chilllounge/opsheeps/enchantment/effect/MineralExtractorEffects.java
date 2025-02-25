package com.chilllounge.opsheeps.enchantment.effect;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.entity.ItemEntity;
import net.minecraft.util.math.random.Random;
import java.util.NavigableMap;
import java.util.TreeMap;

public class MineralExtractorEffects {

	private static final NavigableMap<Integer, ItemStack> WEIGHTED_MINERAL_DROPS = new TreeMap<>();
	private static int totalWeight = 0;

	static {
		addWeightedDrop(new ItemStack(Items.RAW_COPPER), 200);
		addWeightedDrop(new ItemStack(Items.RAW_IRON), 200);
		addWeightedDrop(new ItemStack(Items.RAW_GOLD), 200);
		addWeightedDrop(new ItemStack(Items.DIAMOND), 15);
		addWeightedDrop(new ItemStack(Items.LAPIS_LAZULI, 3), 100);
		addWeightedDrop(new ItemStack(Items.QUARTZ), 50);
	}

	private static void addWeightedDrop(ItemStack item, int weight) {
		if (weight > 0) {
			totalWeight += weight;
			WEIGHTED_MINERAL_DROPS.put(totalWeight, item);
		}
	}

	private static ItemStack getRandomDrop(Random random) {
		if (totalWeight <= 0 || WEIGHTED_MINERAL_DROPS.isEmpty()) {
			return new ItemStack(Items.AIR);
		}
		int randomValue = random.nextInt(totalWeight) + 1;
		return WEIGHTED_MINERAL_DROPS.ceilingEntry(randomValue).getValue();
	}

	public static void applyBlockEffect(ServerWorld world, BlockPos pos, int level) {
		float chanceValue = 2 * level;
		float dropChance = chanceValue / 100f;
		Random random = world.getRandom();

		if (random.nextFloat() < dropChance) {
			ItemStack drop = getRandomDrop(random);
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
