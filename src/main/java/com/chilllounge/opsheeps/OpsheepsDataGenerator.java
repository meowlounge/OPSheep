package com.chilllounge.opsheeps;

import com.chilllounge.opsheeps.datagen.EnchantmentGenerator;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class OpsheepsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
	FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

	pack.addProvider(EnchantmentGenerator::new);
	}
}
