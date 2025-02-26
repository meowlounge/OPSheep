package com.chilllounge.opsheeps.item.custom;

import com.chilllounge.opsheeps.util.OpSheepAccessor;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Hand;

import java.util.Arrays;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class SuperDyeItem extends Item {
	private static final List<DyeColor> RAINBOW_COLORS = Arrays.asList(
			DyeColor.WHITE, DyeColor.ORANGE, DyeColor.MAGENTA, DyeColor.LIGHT_BLUE,
			DyeColor.YELLOW, DyeColor.LIME, DyeColor.PINK, DyeColor.GRAY,
			DyeColor.LIGHT_GRAY, DyeColor.CYAN, DyeColor.PURPLE, DyeColor.BLUE,
			DyeColor.BROWN, DyeColor.GREEN, DyeColor.RED, DyeColor.BLACK
	);

	private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

	public SuperDyeItem(Settings settings) {
		super(settings);
	}

	@Override
	public boolean hasGlint(ItemStack stack) {
		return true;
	}

	@Override
	public ActionResult useOnEntity(ItemStack stack, PlayerEntity player, LivingEntity entity, Hand hand) {
		if (!(entity instanceof SheepEntity sheep) || sheep.getWorld().isClient) {
			return super.useOnEntity(stack, player, entity, hand);
		}

		if (sheep instanceof OpSheepAccessor opSheep && opSheep.opsheeps$isOpSheep()) {
			return ActionResult.FAIL;
		}

		if (sheep.getColor() == null) {
			sheep.setColor(RAINBOW_COLORS.getFirst());
		}

		startRainbowEffect(sheep);

		if (sheep instanceof OpSheepAccessor opSheep) {
			opSheep.opsheeps$setOpSheep(true);
		}

		if (!player.isCreative()) {
			stack.decrement(1);
		}
		return ActionResult.SUCCESS;
	}

	private static final class ActiveRainbowTasksHolder {
		private static final WeakHashMap<SheepEntity, ScheduledFuture<?>> activeRainbowTasks = new WeakHashMap<>();
	}

	public static void startRainbowEffect(SheepEntity sheep) {

		synchronized (ActiveRainbowTasksHolder.activeRainbowTasks) {
			if (ActiveRainbowTasksHolder.activeRainbowTasks.containsKey(sheep)) {
				return;
			}
		}

		final ScheduledFuture<?>[] futureHolder = new ScheduledFuture<?>[1];
		futureHolder[0] = scheduler.scheduleAtFixedRate(() -> {
			if (!sheep.isAlive() || sheep.isSheared() || sheep.getWorld().isClient) {
				futureHolder[0].cancel(false);
				synchronized (ActiveRainbowTasksHolder.activeRainbowTasks) {
					ActiveRainbowTasksHolder.activeRainbowTasks.remove(sheep);
				}
				return;
			}

			DyeColor currentColor = sheep.getColor() == null ? RAINBOW_COLORS.getFirst() : sheep.getColor();
			int nextIndex = (RAINBOW_COLORS.indexOf(currentColor) + 1) % RAINBOW_COLORS.size();
			DyeColor newColor = RAINBOW_COLORS.get(nextIndex);
			sheep.setColor(newColor);
		}, 0, 300, TimeUnit.MILLISECONDS);

		synchronized (ActiveRainbowTasksHolder.activeRainbowTasks) {
			ActiveRainbowTasksHolder.activeRainbowTasks.put(sheep, futureHolder[0]);
		}
	}
}
