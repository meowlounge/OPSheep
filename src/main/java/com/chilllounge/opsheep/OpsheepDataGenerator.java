package com.chilllounge.opsheep;

import com.chilllounge.opsheep.datagen.EnchantmentGen;
import com.chilllounge.opsheep.datagen.ItemModelGen;
import com.chilllounge.opsheep.datagen.ModItemsTagGen;
import com.chilllounge.opsheep.datagen.RecipeGen;
import com.chilllounge.opsheep.datagen.lang.DeTranslationGen;
import com.chilllounge.opsheep.datagen.lang.EnTranslationGen;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class OpsheepDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(EnchantmentGen::new);
		pack.addProvider(ModItemsTagGen::new);
		pack.addProvider(ItemModelGen::new);
		pack.addProvider(RecipeGen::new);
		pack.addProvider(EnTranslationGen::new);
		pack.addProvider(DeTranslationGen::new);
	}
}
