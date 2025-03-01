package com.chilllounge.opsheep.mixin;

import com.chilllounge.opsheep.item.custom.SuperDyeItem;
import com.chilllounge.opsheep.util.OpSheepAccessor;
import net.minecraft.entity.passive.SheepEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SheepEntity.class)
public abstract class SheepTickMixin {

	@Inject(method = "tickMovement", at = @At("HEAD"))
	private void opsheep$tickOpSheep(CallbackInfo ci) {
		SheepEntity sheep = (SheepEntity) (Object) this;

		if (sheep instanceof OpSheepAccessor rainbowSheep && rainbowSheep.opsheep$isOpSheep()) {
			SuperDyeItem.startRainbowEffect(sheep);
		}
	}
}
