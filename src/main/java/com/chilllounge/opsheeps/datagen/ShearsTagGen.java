package com.chilllounge.opsheeps.datagen;

import com.chilllounge.opsheeps.item.ModItems;
import com.chilllounge.opsheeps.util.ModTags;
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
		getOrCreateTagBuilder(ModTags.Items.SUPER_SHEARS)
				.add(ModItems.SUPER_SHEAR_V1)
				.add(ModItems.SUPER_SHEAR_V2)
				.add(ModItems.SUPER_SHEAR_V3)
				.add(ModItems.SUPER_SHEAR_V4)
				.add(ModItems.SUPER_SHEAR_V5)
				.add(ModItems.SUPER_SHEAR_V69);
	}

	@Override
	public String getName() {
		return "ShearsTagGen";
	}
}
