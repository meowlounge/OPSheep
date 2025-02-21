package com.dwhincandi.opsheeps.item.custom;
import net.minecraft.item.ShearsItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import java.util.Random;

public class SuperShearItem extends ShearsItem {
    private final int opDropCount; // Anzahl der OP-Items

    public SuperShearItem(Settings settings, int opDropCount) {
        super(settings);
        this.opDropCount = opDropCount;
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity player, LivingEntity entity, Hand hand) {
        if (entity instanceof SheepEntity sheep) {
            World world = sheep.getWorld();
            Random random = new Random();

            if (!world.isClient) {
                // Liste der möglichen OP-Drops
                ItemStack[] opDrops = {
                        new ItemStack(Items.NETHERITE_INGOT),
                        new ItemStack(Items.DIAMOND),
                        new ItemStack(Items.ENCHANTED_GOLDEN_APPLE),
                        new ItemStack(Items.TOTEM_OF_UNDYING),
                        new ItemStack(Items.POTION)
                };

                // Dropt die entsprechende Anzahl an OP-Items
                for (int i = 0; i < opDropCount; i++) {
                    ItemStack drop = opDrops[random.nextInt(opDrops.length)];
                    sheep.dropStack(drop);
                }
            }

            return ActionResult.SUCCESS;
        }
        return super.useOnEntity(stack, player, entity, hand);
    }
}

//This is a Test