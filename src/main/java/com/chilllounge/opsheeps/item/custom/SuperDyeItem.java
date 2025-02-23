package com.chilllounge.opsheeps.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
//import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Hand;
 import com.chilllounge.opsheeps.entity.SheepEntityData;

import java.util.Arrays;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SuperDyeItem extends Item {
    private static final List<DyeColor> RAINBOW_COLORS = Arrays.asList(
            DyeColor.WHITE, DyeColor.ORANGE, DyeColor.MAGENTA, DyeColor.LIGHT_BLUE,
            DyeColor.YELLOW, DyeColor.LIME, DyeColor.PINK, DyeColor.GRAY,
            DyeColor.LIGHT_GRAY, DyeColor.CYAN, DyeColor.PURPLE, DyeColor.BLUE,
            DyeColor.BROWN, DyeColor.GREEN, DyeColor.RED, DyeColor.BLACK
    );

    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private static final Logger LOGGER = LoggerFactory.getLogger(SuperDyeItem.class);

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

        if (sheep.getColor() == null) {
            sheep.setColor(RAINBOW_COLORS.getFirst());
        }

        startRainbowEffect(sheep);

//        NbtCompound nbt = new NbtCompound();
//        sheep.writeNbt(nbt);
//        nbt.putBoolean("IsOpSheep", true);
//        sheep.readNbt(nbt);
//
//        System.out.println("Applied Spectral Dye to sheep at (" + sheep.getBlockX() + ", "
//                + sheep.getBlockY() + ", " + sheep.getBlockZ() + "). Marked as OP Sheep.");

        if (!player.isCreative()) {
            stack.decrement(1);
        }
        return ActionResult.SUCCESS;
    }

    private static final class ActiveRainbowTasksHolder {
        private static final WeakHashMap<SheepEntity, ScheduledFuture<?>> activeRainbowTasks = new WeakHashMap<>();
    }

    private void startRainbowEffect(SheepEntity sheep) {

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
        }, 0, 100, TimeUnit.MILLISECONDS);

        synchronized (ActiveRainbowTasksHolder.activeRainbowTasks) {
            ActiveRainbowTasksHolder.activeRainbowTasks.put(sheep, futureHolder[0]);
        }
    }
}
