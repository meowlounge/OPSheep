package com.chilllounge.opsheeps.datagen;

import com.chilllounge.opsheeps.item.OpSheepsItems;
import com.chilllounge.opsheeps.util.ShearTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ShearsTagGen extends FabricTagProvider.ItemTagProvider {
	public ShearsTagGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
		getOrCreateTagBuilder(ShearTags.Items.SUPER_SHEARS)
				.add(OpSheepsItems.SUPER_SHEAR_V1)
				.add(OpSheepsItems.SUPER_SHEAR_V2)
				.add(OpSheepsItems.SUPER_SHEAR_V3)
				.add(OpSheepsItems.SUPER_SHEAR_V4)
				.add(OpSheepsItems.SUPER_SHEAR_V5)
				.add(OpSheepsItems.SUPER_SHEAR_V69);
	}

	@Override
	public String getName() {
		return "ShearsTagGen";
	}
}
