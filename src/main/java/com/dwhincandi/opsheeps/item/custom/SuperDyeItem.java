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

/**
 * Represents the Super Dye item that transforms a sheep into a rainbow-colored sheep.
 * This item applies a continuous rainbow effect to a sheep when used and provides visual feedback via particles.
 */
public class SuperDyeItem extends Item {
    private static final List<DyeColor> RAINBOW_COLORS = Arrays.asList(
            DyeColor.WHITE, DyeColor.ORANGE, DyeColor.MAGENTA, DyeColor.LIGHT_BLUE,
            DyeColor.YELLOW, DyeColor.LIME, DyeColor.PINK, DyeColor.GRAY,
            DyeColor.LIGHT_GRAY, DyeColor.CYAN, DyeColor.PURPLE, DyeColor.BLUE,
            DyeColor.BROWN, DyeColor.GREEN, DyeColor.RED, DyeColor.BLACK
    );
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    /**
     * Constructor for SuperDyeItem.
     *
     * @param settings the settings for the item, including its behavior and appearance.
     */
    public SuperDyeItem(Settings settings) {
        super(settings);
    }

    /**
     * Indicates that the Super Dye item has a glint, making it appear enchanted.
     *
     * @param stack the ItemStack representing this item.
     * @return true, as the item always has a glint.
     */
    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    /**
     * When used on a sheep entity, applies the rainbow color effect to the sheep and spawns a flame particle effect.
     * The item will be consumed unless the player is in creative mode.
     *
     * @param stack  the ItemStack representing this item.
     * @param player the player using the item.
     * @param entity the entity being interacted with, expected to be a SheepEntity.
     * @param hand   the hand with which the item is being used.
     * @return ActionResult.SUCCESS if the item was successfully used, otherwise the default action.
     */
    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity player, LivingEntity entity, Hand hand) {
        if (entity instanceof SheepEntity sheep && !sheep.getWorld().isClient) {
            // Set initial color if sheep doesn't have one
            if (sheep.getColor() == null) {
                sheep.setColor(RAINBOW_COLORS.getFirst());  // Start with the first color in the rainbow
            }

            startRainbowEffect(sheep, player);
            spawnFlameParticles(sheep);

            if (!player.isCreative()) {
                stack.decrement(1);
            }
            return ActionResult.SUCCESS;
        }
        return super.useOnEntity(stack, player, entity, hand);
    }

    /**
     * Starts the rainbow effect on the sheep, changing its color every 150 milliseconds.
     *
     * @param sheep  the sheep entity to apply the effect to.
     * @param player the player who used the item (not currently used in this method).
     */
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

    /**
     * Spawns flame particles at the sheep's position.
     *
     * @param sheep the sheep entity at whose position the particles will appear.
     */
    private void spawnFlameParticles(SheepEntity sheep) {
        sheep.getWorld().addParticle(ParticleTypes.FLAME,
                sheep.getX(), sheep.getY() + 1, sheep.getZ(),
                3, 3, 3);
    }
}
