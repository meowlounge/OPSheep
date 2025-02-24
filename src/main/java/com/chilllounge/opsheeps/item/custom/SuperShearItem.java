package com.chilllounge.opsheeps.item.custom;

import com.chilllounge.opsheeps.Opsheeps;
import com.chilllounge.opsheeps.util.OpSheepAccessor;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ShearsItem;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.SheepEntity;
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

        if (!(sheep instanceof OpSheepAccessor opSheep) || !opSheep.opsheeps$isOpSheep()) {
            return ActionResult.FAIL;
        }

        if (sheep.isSheared()) {
            return ActionResult.PASS;
        }

        sheep.setSheared(true);

        if (Opsheeps.DEV_MODE) {
            sheep.setSheared(false);
        }

        if (!world.isClient && stack.isDamageable()) {
            stack.damage(1, entity, EquipmentSlot.MAINHAND); // Keine Methode// notwendig

            if (stack.getDamage() >= stack.getMaxDamage()) {
                world.playSound(null, player.getX(), player.getY(), player.getZ(),
                        net.minecraft.sound.SoundEvents.ENTITY_ITEM_BREAK,
                        net.minecraft.sound.SoundCategory.PLAYERS, 999.0F, 1.0F);
                player.getInventory().removeOne(stack);
            }
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
