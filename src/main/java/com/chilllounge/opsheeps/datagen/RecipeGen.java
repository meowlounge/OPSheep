package com.chilllounge.opsheeps.datagen;

import com.chilllounge.opsheeps.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class RecipeGen extends FabricRecipeProvider {
	public RecipeGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
		return new RecipeGenerator(registryLookup, exporter) {
			@Override
			public void generate() {
				createShaped(RecipeCategory.MISC, ModItems.SUPER_DYE)
						.pattern("111")
						.pattern("1D1")
						.pattern("111")
						.input('1', Ingredient.ofItems(
								Items.BLACK_DYE, Items.BLUE_DYE, Items.BROWN_DYE, Items.CYAN_DYE,
								Items.GRAY_DYE, Items.GREEN_DYE, Items.LIGHT_BLUE_DYE, Items.LIGHT_GRAY_DYE,
								Items.LIME_DYE, Items.MAGENTA_DYE, Items.ORANGE_DYE, Items.PINK_DYE,
								Items.PURPLE_DYE, Items.RED_DYE, Items.WHITE_DYE, Items.YELLOW_DYE))
						.input('D', Items.DIAMOND_BLOCK)
						.criterion(hasItem(Items.DIAMOND_BLOCK), conditionsFromItem(Items.DIAMOND_BLOCK))
						.offerTo(exporter);

				createShaped(RecipeCategory.TOOLS, ModItems.SUPER_SHEAR_V1)
						.pattern("111")
						.pattern("1D1")
						.pattern("111")
						.input('1', Items.SHEARS)
						.input('D', Items.DIAMOND_BLOCK)
						.criterion(hasItem(Items.SHEARS), conditionsFromItem(Items.SHEARS))
						.offerTo(exporter);

				createShaped(RecipeCategory.TOOLS, ModItems.SUPER_SHEAR_V2)
						.pattern("111")
						.pattern("1D1")
						.pattern("111")
						.input('1', ModItems.SUPER_SHEAR_V1)
						.input('D', Items.DIAMOND_BLOCK)
						.criterion(hasItem(Items.SHEARS), conditionsFromItem(Items.SHEARS))
						.offerTo(exporter);

				createShaped(RecipeCategory.TOOLS, ModItems.SUPER_SHEAR_V3)
						.pattern("111")
						.pattern("1D1")
						.pattern("111")
						.input('1', ModItems.SUPER_SHEAR_V2)
						.input('D', Items.DIAMOND_BLOCK)
						.criterion(hasItem(Items.SHEARS), conditionsFromItem(Items.SHEARS))
						.offerTo(exporter);

				createShaped(RecipeCategory.TOOLS, ModItems.SUPER_SHEAR_V4)
						.pattern("111")
						.pattern("1D1")
						.pattern("111")
						.input('1', ModItems.SUPER_SHEAR_V3)
						.input('D', Items.DIAMOND_BLOCK)
						.criterion(hasItem(Items.SHEARS), conditionsFromItem(Items.SHEARS))
						.offerTo(exporter);

				createShaped(RecipeCategory.TOOLS, ModItems.SUPER_SHEAR_V5)
						.pattern("111")
						.pattern("1D1")
						.pattern("111")
						.input('1', ModItems.SUPER_SHEAR_V4)
						.input('D', Items.DIAMOND_BLOCK)
						.criterion(hasItem(Items.SHEARS), conditionsFromItem(Items.SHEARS))
						.offerTo(exporter);
			}
		};
	}

	@Override
	public String getName() {
		return "OPSheeps Recipe Provider";
	}
}
