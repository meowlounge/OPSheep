package com.dwhincandi.opsheeps.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SuperDyeItem extends Item {
    private static final List<DyeColor> RAINBOW_COLORS = Arrays.asList(
            DyeColor.RED, DyeColor.ORANGE, DyeColor.YELLOW, DyeColor.LIME,
            DyeColor.LIGHT_BLUE, DyeColor.BLUE, DyeColor.PURPLE, DyeColor.MAGENTA
    );
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public SuperDyeItem(Settings settings) {
        super(settings);
    }

    // kann man so lassen, oder baut später ein das nur bestimmte items das haben.
    // finde das aber so besser. lässt die items mehr op aussehen.
    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity player, LivingEntity entity, Hand hand) {
        if (entity instanceof SheepEntity sheep && !sheep.getWorld().isClient) {
            if (sheep.getColor() == null) {
                sheep.setColor(RAINBOW_COLORS.getFirst());
            }

            startRainbowEffect(sheep, player);

            sheep.getWorld().addParticle(ParticleTypes.FLAME,
                    sheep.getX(), sheep.getY() + 1, sheep.getZ(),
                    3, 3, 3);

            if (!player.isCreative()) {
                stack.decrement(1);
            }
            return ActionResult.SUCCESS;
        }
        return super.useOnEntity(stack, player, entity, hand);
    }

    private void startRainbowEffect(SheepEntity sheep, PlayerEntity player) {
        final World world = sheep.getWorld();
        scheduler.scheduleAtFixedRate(() -> {
            if (!sheep.isAlive() || sheep.isSheared() || world.isClient) {
                return;
            }

            DyeColor currentColor = sheep.getColor();
            if (currentColor == null) {
                currentColor = RAINBOW_COLORS.getFirst();
            }

            int nextColorIndex = (RAINBOW_COLORS.indexOf(currentColor) + 1) % RAINBOW_COLORS.size();
            DyeColor newColor = RAINBOW_COLORS.get(nextColorIndex);
            sheep.setColor(newColor);

        }, 0, 150, TimeUnit.MILLISECONDS);
    }
}