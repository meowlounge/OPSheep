package com.chilllounge.opsheeps.mixin;

import com.chilllounge.opsheeps.item.custom.SuperDyeItem;
import com.chilllounge.opsheeps.util.OpSheepAccessor;
import net.minecraft.entity.passive.SheepEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(SheepEntity.class)
public abstract class SheepTickMixin {

	@Inject(method = "tickMovement", at = @At("HEAD"))
	private void opsheeps$tickOpSheep(CallbackInfo ci) {
		SheepEntity sheep = (SheepEntity) (Object) this;

		if (sheep instanceof OpSheepAccessor rainbowSheep && rainbowSheep.opsheeps$isOpSheep()) {
			SuperDyeItem.startRainbowEffect(sheep);
		}
	}
}
