package com.dwhincandi.opsheeps.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public class SuperDyeItem extends Item {
    public SuperDyeItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity player, LivingEntity entity, Hand hand) {
        if (entity instanceof SheepEntity sheep) {
            if (!sheep.getWorld().isClient) {
                sheep.setCustomName(Text.literal("jeb_"));
                sheep.setPersistent();

                sheep.getWorld().addParticle(ParticleTypes.HAPPY_VILLAGER,
                        sheep.getX(), sheep.getY() + 0.5, sheep.getZ(),
                        0, 0.1, 0);

                if (!player.isCreative()) {
                    stack.decrement(1);
                }
            }
            return ActionResult.SUCCESS;
        }
        return super.useOnEntity(stack, player, entity, hand);
    }
}
