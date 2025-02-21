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

public class SuperShearItem extends ShearsItem {
    private final int opDropCount;

    public SuperShearItem(Settings settings, int opDropCount) {
        super(settings);
        this.opDropCount = opDropCount;
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity player, LivingEntity entity, Hand hand) {
        if (entity instanceof SheepEntity sheep) {
            World world = sheep.getWorld();
            Random random = new Random();

            if (!sheep.isSheared()) {
                sheep.setSheared(true);

                if (!world.isClient) {

                    //? Some Development Items. Will be changed into a Drop System?
                    //? Were we can add Enchantments, Custom Styling for Name, and Lore.
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

//              Stack bei nicht-Kreativmodus abziehen
                if (!player.isCreative()) {
                    stack.decrement(1);
                }

                return ActionResult.SUCCESS;
            } else {
                Opsheeps.LOGGER.info("This sheep has already been sheared. Skipping");
            }
        }
        return super.useOnEntity(stack, player, entity, hand);
    }
}
