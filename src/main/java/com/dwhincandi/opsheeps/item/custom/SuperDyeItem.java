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
import com.dwhincandi.opsheeps.entity.SheepEntityData;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
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
        if (entity instanceof SheepEntity sheep && !sheep.getWorld().isClient) {
            if (sheep.getColor() == null) {
                sheep.setColor(RAINBOW_COLORS.getFirst());
            }

            sheep.getDataTracker().set(SheepEntityData.IS_OP_SHEEP, true);
            startRainbowEffect(sheep);
            spawnFlameParticles(sheep);

            if (!player.isCreative()) {
                stack.decrement(1);
            }
            return ActionResult.SUCCESS;
        }
        return super.useOnEntity(stack, player, entity, hand);
    }

    private void startRainbowEffect(SheepEntity sheep) {
        scheduler.scheduleAtFixedRate(() -> {
            if (!sheep.isAlive() || sheep.isSheared() || sheep.getWorld().isClient) {
                return;
            }

            DyeColor currentColor = sheep.getColor() == null ? RAINBOW_COLORS.getFirst() : sheep.getColor();
            DyeColor newColor = RAINBOW_COLORS.get((RAINBOW_COLORS.indexOf(currentColor) + 1) % RAINBOW_COLORS.size());
            sheep.setColor(newColor);
        }, 0, 150, TimeUnit.MILLISECONDS);
    }

    private void spawnFlameParticles(SheepEntity sheep) {
        sheep.getWorld().addParticle(ParticleTypes.FLAME, sheep.getX(), sheep.getY() + 1, sheep.getZ(), 3, 3, 3);
    }
}
