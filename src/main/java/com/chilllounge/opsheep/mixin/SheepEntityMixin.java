package com.chilllounge.opsheep.mixin;

import com.chilllounge.opsheep.util.OpSheepAccessor;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SheepEntity.class)
public abstract class SheepEntityMixin implements OpSheepAccessor {
	@Unique
	private boolean isOpSheep = false;

	@Override
	@Unique
	public boolean opsheep$isOpSheep() {
		return isOpSheep;
	}

	@Override
	@Unique
	public void opsheep$setOpSheep(boolean opSheep) {
		this.isOpSheep = opSheep;
	}

	@Inject(method = "writeCustomDataToNbt", at = @At("HEAD"))
	private void writeOpSheepToNbt(NbtCompound nbt, CallbackInfo ci) {
		nbt.putBoolean("IsOpSheep", this.isOpSheep);
	}

	@Inject(method = "readCustomDataFromNbt", at = @At("HEAD"))
	private void readOpSheepFromNbt(NbtCompound nbt, CallbackInfo ci) {
		this.isOpSheep = nbt.getBoolean("IsOpSheep");
	}
}
