package com.chilllounge.opsheeps.enchantment.effect;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.EnchantmentLevelBasedValue;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public record DiamondExtractorEnchantmentEffect(EnchantmentLevelBasedValue chance) implements EnchantmentEntityEffect {
	public static final MapCodec<DiamondExtractorEnchantmentEffect> CODEC = RecordCodecBuilder.mapCodec(instance ->
			instance.group(
					EnchantmentLevelBasedValue.CODEC.fieldOf("chance").forGetter(DiamondExtractorEnchantmentEffect::chance)
			).apply(instance, DiamondExtractorEnchantmentEffect::new)
	);

	@Override
	public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity target, Vec3d pos) {
		if (target instanceof LivingEntity victim) {
			if (context.owner() instanceof PlayerEntity player) {
				float chanceValue = 5 * level;
				float dropChance = chanceValue / 100f;

				if (world.getRandom().nextFloat() < dropChance) {
					BlockPos spawnPos = victim.getBlockPos();
					ItemStack diamondStack = new ItemStack(Items.DIAMOND, 1);
					ItemEntity diamondEntity = new ItemEntity(world, spawnPos.getX() + 0.5, spawnPos.getY() + 1.0, spawnPos.getZ() + 0.5, diamondStack);
					world.spawnEntity(diamondEntity);
				}
			}
		}
	}

	@Override
	public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
		return CODEC;
	}
}
