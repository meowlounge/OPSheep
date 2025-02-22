package com.dwhincandi.opsheeps.item.custom;

import com.dwhincandi.opsheeps.Opsheeps;
import com.dwhincandi.opsheeps.entity.SheepEntityData;
import net.minecraft.item.ShearsItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.text.Style;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraft.text.Text;

import java.util.Random;

public class SuperShearItem extends ShearsItem {
    private final int opDropCount;
    private final int opShearVersion;

    public SuperShearItem(Settings settings, int opDropCount, int opShearVersion) {
        super(settings);
        this.opDropCount = opDropCount;
        this.opShearVersion = opShearVersion;
        Opsheeps.LOGGER.info("SuperShearItem created with version: {}", this.opShearVersion);
    }

    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    public ActionResult useOnEntity(ItemStack stack, PlayerEntity player, LivingEntity entity, Hand hand) {
        if (entity instanceof SheepEntity sheep) {

            if (!sheep.getDataTracker().get(SheepEntityData.IS_OP_SHEEP)) {
                player.sendMessage(Text.literal("This sheep is not powerful enough for the OP Shears!").setStyle(Style.EMPTY.withColor(Formatting.RED)), true);
            }
            
            World world = sheep.getWorld();
            Random random = new Random();

            if (!sheep.isSheared()) {
                sheep.setSheared(true);

//                sheep.setSheared(false);

                if (!world.isClient) {
                    ItemStack[] lootTable = switch (this.opShearVersion) {
                        case 1 -> {
                            yield new ItemStack[]{
                                    new ItemStack(Items.STICK, random.nextInt(6) + 1),
                                    new ItemStack(Items.STRING, random.nextInt(3) + 1)
                            };
                        }
                        case 2 -> {
                            yield new ItemStack[]{
                                    new ItemStack(Items.NETHERITE_SCRAP, random.nextInt(2) + 1),
                                    new ItemStack(Items.DIAMOND, random.nextInt(4) + 1),
                                    new ItemStack(Items.ENCHANTED_GOLDEN_APPLE, random.nextInt(3) + 1),
                                    new ItemStack(Items.EXPERIENCE_BOTTLE, random.nextInt(16) + 1)
                            };
                        }
                        case 3 -> {
                            yield new ItemStack[]{
                                    new ItemStack(Items.NETHERITE_BLOCK),
                                    new ItemStack(Items.NETHER_STAR, random.nextInt(4) + 1),
                                    new ItemStack(Items.TOTEM_OF_UNDYING)
                            };
                        }
                        case 4 -> {
                            yield new ItemStack[]{
                                    new ItemStack(Items.GLOWSTONE_DUST, random.nextInt(16) + 1),
                                    new ItemStack(Items.ELYTRA),
                                    new ItemStack(Items.GOLDEN_APPLE, random.nextInt(16) + 1)
                            };
                        }
                        case 5 -> {
                            yield new ItemStack[]{
                                    new ItemStack(Items.DRAGON_BREATH, random.nextInt(16) + 1),
                                    new ItemStack(Items.POPPED_CHORUS_FRUIT, random.nextInt(32) + 1),
                                    new ItemStack(Items.BEACON),
                                    new ItemStack(Items.SHULKER_SHELL, random.nextInt(16) + 1),
                                    new ItemStack(Items.END_CRYSTAL),
                                    new ItemStack(Items.DRAGON_EGG)
                            };
                        }
                        case 69 -> {
                            yield new ItemStack[]{
                                    new ItemStack(Items.BONE_BLOCK, random.nextInt(16) + 1),
                                    new ItemStack(Items.AMETHYST_BLOCK, random.nextInt(32) + 1),
                                    new ItemStack(Items.COPPER_BLOCK, random.nextInt(16) + 1),
                                    new ItemStack(Items.BONE_BLOCK, random.nextInt(16) + 1),
                                    new ItemStack(Items.RAW_COPPER_BLOCK, random.nextInt(16) + 1),
                                    new ItemStack(Items.HONEYCOMB_BLOCK, random.nextInt(16) + 1)
                            };
                        }
                        default -> {
                            yield new ItemStack[]{
                                    new ItemStack(Items.SKELETON_SKULL)
                            };
                        }
                    };

                    for (int i = 0; i < opDropCount; i++) {
                        ItemStack drop = lootTable[random.nextInt(lootTable.length)];
                        sheep.dropStack(drop);
                    }
                }

                sheep.getWorld().addParticle(ParticleTypes.HAPPY_VILLAGER,
                        sheep.getX(), sheep.getY() + 2, sheep.getZ(),
                        3, 3, 3);

                return ActionResult.SUCCESS;
            } else {
                player.sendMessage(Text.of("This sheep has already been sheared. Skipping"), false);
            }
        }
        return super.useOnEntity(stack, player, entity, hand);
    }
}
