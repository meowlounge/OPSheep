package com.chilllounge.opsheeps.mixin;

import com.chilllounge.opsheeps.Opsheeps;
import com.chilllounge.opsheeps.util.OpSheepAccessor;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(SheepEntity.class)
public abstract class SheepEntityMixin implements OpSheepAccessor {
	@Unique
	private boolean isOpSheep = false;

	@Override
	@Unique
	public boolean opsheeps$isOpSheep() {
		Opsheeps.LOGGER.debug("[DEBUG] Checking if sheep is OP: {}", isOpSheep);
		return isOpSheep;
	}

	@Override
	@Unique
	public void opsheeps$setOpSheep(boolean opSheep) {
		this.isOpSheep = opSheep;
		Opsheeps.LOGGER.info("[DEBUG] Set OP Sheep status to: {}", opSheep);
	}

	@Inject(method = "writeCustomDataToNbt", at = @At("HEAD"))
	private void writeOpSheepToNbt(NbtCompound nbt, CallbackInfo ci) {
		nbt.putBoolean("IsOpSheep", this.isOpSheep);
		Opsheeps.LOGGER.info("[DEBUG] Writing OP Sheep status to NBT: {}", this.isOpSheep);
	}

	@Inject(method = "readCustomDataFromNbt", at = @At("HEAD"))
	private void readOpSheepFromNbt(NbtCompound nbt, CallbackInfo ci) {
		this.isOpSheep = nbt.getBoolean("IsOpSheep");
		Opsheeps.LOGGER.info("[DEBUG] Loaded OP Sheep status from NBT: {}", this.isOpSheep);
	}
}
