package com.chilllounge.opsheeps.item.custom;

import com.chilllounge.opsheeps.Opsheeps;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShearsItem;
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
			sheep.setSheared(false);

			return ActionResult.SUCCESS;
		}

		if (Opsheeps.DEV_MODE || !player.isCreative()) {
			stack.increment(1);
		}

		return super.useOnEntity(stack, player, entity, hand);
	}
}
