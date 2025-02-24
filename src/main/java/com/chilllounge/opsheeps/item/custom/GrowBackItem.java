package com.chilllounge.opsheeps.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShearsItem;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public class GrowBackItem extends ShearsItem {

	public GrowBackItem(Settings settings) {
		super(settings);
	}

	@Override
	public boolean hasGlint(ItemStack stack) {
		return true;
	}

	@Override
	public ActionResult useOnEntity(ItemStack stack, PlayerEntity player, LivingEntity entity, Hand hand) {
		if (!(entity instanceof SheepEntity sheep) || sheep.getWorld().isClient) {
			return super.useOnEntity(stack, player, entity, hand);
		}

		if (sheep.isSheared()) {
			sheep.setSheared(false); // Restore wool

			sheep.getWorld().playSound(null, sheep.getBlockPos(), SoundEvents.BLOCK_AMETHYST_BLOCK_RESONATE,
					SoundCategory.NEUTRAL, 1.0f, 0.3f);

			for (int i = 0; i < 10; i++) {
				double offsetX = (sheep.getWorld().random.nextDouble() - 0.2) * 0.2;
				double offsetY = sheep.getWorld().random.nextDouble() * 0.2 + 0.2;
				double offsetZ = (sheep.getWorld().random.nextDouble() - 0.2) * 0.2;

				sheep.getWorld().addParticle(ParticleTypes.HAPPY_VILLAGER,
						sheep.getX() + offsetX,
						sheep.getY() + offsetY,
						sheep.getZ() + offsetZ,
						0.1, 0.1, 0.1);
			}

			if (!player.isCreative()) {
				stack.decrement(1);
			}

			return ActionResult.SUCCESS;
		}

		return super.useOnEntity(stack, player, entity, hand);
	}
}
