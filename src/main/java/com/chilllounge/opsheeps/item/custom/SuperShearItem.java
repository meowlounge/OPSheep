package com.chilllounge.opsheeps.item.custom;

import com.chilllounge.opsheeps.Opsheeps;
import com.chilllounge.opsheeps.util.OpSheepAccessor;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShearsItem;
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

		shearSheep(sheep, player, stack);

		if (this.opShearVersion >= 2 && world.getRandom().nextFloat() < 0.10f) {
			shearSheep(sheep, player, stack);

			player.sendMessage(net.minecraft.text.Text.translatable("item.opsheeps.supershear_perk_v2"), true);
		}

		if (this.opShearVersion >= 4) {
			for (SheepEntity nearbySheep : world.getEntitiesByClass(
					SheepEntity.class, sheep.getBoundingBox().expand(3),
					s -> s instanceof OpSheepAccessor && ((OpSheepAccessor) s).opsheeps$isOpSheep() && !s.isSheared())) {
				shearSheep(nearbySheep, player, stack);

				player.sendMessage(net.minecraft.text.Text.translatable("item.opsheeps.supershear_perk_v4"), true);
			}
		}

		return ActionResult.SUCCESS;
	}

	private void shearSheep(SheepEntity sheep, PlayerEntity player, ItemStack stack) {
		World world = sheep.getWorld();

		sheep.setSheared(true);

		if (Opsheeps.DEV_MODE) {
			sheep.setSheared(false);
		}

		if (!world.isClient && stack.isDamageable()) {
			stack.damage(1, player, EquipmentSlot.MAINHAND);

			if (stack.getDamage() >= stack.getMaxDamage()) {
				world.playSound(null, player.getX(), player.getY(), player.getZ(),
						net.minecraft.sound.SoundEvents.ENTITY_ITEM_BREAK,
						net.minecraft.sound.SoundCategory.PLAYERS, 999.0F, 1.0F);
				player.getInventory().removeOne(stack);
			}
		}

		if (world instanceof ServerWorld serverWorld) {
			if (this.opShearVersion >= 3) {
				if (world.getRandom().nextFloat() < 0.25f) {
					LootManager.generateLoot(4, this.opDropCount);
					player.sendMessage(net.minecraft.text.Text.translatable("item.opsheeps.supershear_perk_v3"), true);
				}
			}
			ItemStack[] drops = LootManager.generateLoot(this.opShearVersion, this.opDropCount);

			for (ItemStack drop : drops) {
				sheep.dropStack(serverWorld, drop, 1.0f);
			}

			if (this.opShearVersion >= 5 && world.getRandom().nextFloat() < 0.05f) {
				ItemStack[] treasures = LootManager.generateLoot(5, 1);
				if (treasures.length > 0 && !treasures[0].isEmpty()) {
					ItemEntity entity = new ItemEntity(world, sheep.getX(), sheep.getY(), sheep.getZ(), treasures[0]);
					world.spawnEntity(entity);

					player.sendMessage(net.minecraft.text.Text.translatable("item.opsheeps.supershear_perk_v5"
							+ treasures[0].getCount() + "x " + treasures[0].getName().getString()), true);
				}
			}
		}
	}

}
