package com.chilllounge.opsheeps.item.custom;

import com.chilllounge.opsheeps.Opsheeps;
import net.minecraft.item.ShearsItem;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class SuperShearItem extends ShearsItem {
    private final int opDropCount;
    private final int opShearVersion;

    public SuperShearItem(Settings settings, int opDropCount, int opShearVersion) {
        super(settings);
        this.opDropCount = opDropCount;
        this.opShearVersion = opShearVersion;
        Opsheeps.LOGGER.info("SuperShearItem created with version: {}", this.opShearVersion);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity player, LivingEntity entity, Hand hand) {
        if (!(entity instanceof SheepEntity sheep)) {
            return super.useOnEntity(stack, player, entity, hand);
        }

        World world = sheep.getWorld();

        // TODO: Uncomment and fix when the OP Sheep data is ready.
        // if (!sheep.getDataTracker().get(SheepEntityData.IS_OP_SHEEP)) {
        //     player.sendMessage(Text.literal("This sheep is not powerful enough for the OP Shears!")
        //             .setStyle(Style.EMPTY.withColor(Formatting.RED)), true);
        //     return ActionResult.FAIL;
        // }

        if (sheep.isSheared()) {
            return ActionResult.PASS;
        }

        sheep.setSheared(true);

        if (Opsheeps.DEV_MODE) {
            sheep.setSheared(false);
        }

        //! damage stays at 0 and item doesn't break
        if (!player.isCreative() && stack.isDamageable()) {
            stack.damage(1, player);
            // The call to willBreakNextUse() is typically handled internally after damage().
        }

        if (world instanceof ServerWorld serverWorld) {
            ItemStack[] drops = LootManager.generateLoot(this.opShearVersion, this.opDropCount);
            for (ItemStack drop : drops) {
                sheep.dropStack(serverWorld, drop, 1.0f);
            }
        }

        return ActionResult.SUCCESS;
    }
}
