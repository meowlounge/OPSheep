package com.chilllounge.opsheeps;

import com.chilllounge.opsheeps.datagen.EnchantmentGen;
import com.chilllounge.opsheeps.datagen.ItemModelGen;
import com.chilllounge.opsheeps.datagen.RecipeGen;
import com.chilllounge.opsheeps.datagen.ShearsTagGen;
import com.chilllounge.opsheeps.datagen.lang.DeTranslationGen;
import com.chilllounge.opsheeps.datagen.lang.EnTranslationGen;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class OpsheepsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(EnchantmentGen::new);
		pack.addProvider(ShearsTagGen::new);
		pack.addProvider(ItemModelGen::new);
		pack.addProvider(RecipeGen::new);
		pack.addProvider(EnTranslationGen::new);
		pack.addProvider(DeTranslationGen::new);
	}
}
