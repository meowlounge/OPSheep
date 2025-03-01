package com.chilllounge.opsheep.util;

import com.chilllounge.opsheep.Opsheep;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModItemTags {
	public static final TagKey<Item> SUPER_SHEARS = createTag("super_shears");
	public static final TagKey<Item> OP_ARMORS = createTag("op_armors");
	public static final TagKey<Item> OP_TOOLS = createTag("op_tools");


	private static TagKey<Item> createTag(String name) {
		return TagKey.of(RegistryKeys.ITEM, Identifier.of(Opsheep.MOD_ID, name));
	}

}