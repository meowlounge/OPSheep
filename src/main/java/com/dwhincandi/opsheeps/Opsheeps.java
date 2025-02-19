package com.dwhincandi.opsheeps;

import com.dwhincandi.opsheeps.item.ModItemGroups;
import com.dwhincandi.opsheeps.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Opsheeps implements ModInitializer {
	public static final String MOD_ID = "data";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
	}
}