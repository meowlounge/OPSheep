package com.dwhincandi.opsheeps.item.custom;

import com.dwhincandi.opsheeps.Opsheeps;
import net.minecraft.item.ShearsItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Represents the Super Shear item, which shears a sheep and drops special items.
 * This item is a custom shears that provides additional loot drops when used on a sheep.
 */
public class SuperShearItem extends ShearsItem {
    private final int opDropCount;

    /**
     * Constructor for the Super Shear item.
     *
     * @param settings the settings for the item, including its behavior and appearance.
     * @param opDropCount the number of special loot items dropped when the sheep is sheared.
     */
    public SuperShearItem(Settings settings, int opDropCount) {
        super(settings);
        this.opDropCount = opDropCount;
    }

    /**
     * Indicates that the Super Shear item has a glint, making it appear enchanted.
     *
     * @param stack the ItemStack representing this item.
     * @return true, as the item always has a glint.
     */
    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    /**
     * When used on a sheep entity, shears the sheep and drops a special set of loot items.
     * The item also spawns a particle effect at the sheep's position.
     * If the sheep has already been sheared, the action is skipped.
     *
     * @param stack  the ItemStack representing this item.
     * @param player the player using the item.
     * @param entity the entity being interacted with, expected to be a SheepEntity.
     * @param hand   the hand with which the item is being used.
     * @return ActionResult.SUCCESS if the sheep was sheared, otherwise the default action.
     */
    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity player, LivingEntity entity, Hand hand) {
        if (entity instanceof SheepEntity sheep) {
            World world = sheep.getWorld();
            Random random = new Random();

            if (!sheep.isSheared()) {
                sheep.setSheared(true);

                //* Developer Mode ( INSTANT WOOL BACK )
//                sheep.setSheared(false);

                if (!world.isClient) {
                    ItemStack[] opDrops = {
                            new ItemStack(Items.NETHERITE_INGOT),
                            new ItemStack(Items.DIAMOND),
                            new ItemStack(Items.ENCHANTED_GOLDEN_APPLE),
                            new ItemStack(Items.NETHERITE_BLOCK),
                            new ItemStack(Items.NETHER_STAR)
                    };

                    for (int i = 0; i < opDropCount; i++) {
                        ItemStack drop = opDrops[random.nextInt(opDrops.length)];
                        sheep.dropStack(drop);
                    }
                }

                sheep.getWorld().addParticle(ParticleTypes.HAPPY_VILLAGER,
                        sheep.getX(), sheep.getY() + 0.5, sheep.getZ(),
                        3, 3, 3);

                return ActionResult.SUCCESS;
            } else {
                Opsheeps.LOGGER.info("This sheep has already been sheared. Skipping");
            }
        }
        return super.useOnEntity(stack, player, entity, hand);
    }
}
