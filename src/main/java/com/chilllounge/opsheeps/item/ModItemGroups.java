package com.chilllounge.opsheeps.item;

import com.chilllounge.opsheeps.Opsheeps;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup SUPER_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Opsheeps.MOD_ID, "super_items"),
            FabricItemGroup.builder()
                    .icon(()-> new ItemStack(ModItems.SUPER_DYE))
                    .displayName(Text.translatable("itemgroups.opsheeps.super_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.SUPER_DYE);
                        entries.add(ModItems.SUPER_SHEAR_V69);
                        entries.add(ModItems.SUPER_SHEAR_V1);
                        entries.add(ModItems.SUPER_SHEAR_V2);
                        entries.add(ModItems.SUPER_SHEAR_V3);
                        entries.add(ModItems.SUPER_SHEAR_V4);
                        entries.add(ModItems.SUPER_SHEAR_V5);
                        entries.add(ModItems.GROW_BACK);

                        //? OP SET ( v5 Loot (ultra rare, but ultra op)
                        entries.add(OPLootTableItems.OP_HELMET);
                        entries.add(OPLootTableItems.OP_CHESTPLATE);
                        entries.add(OPLootTableItems.OP_LEGGINGS);
                        entries.add(OPLootTableItems.OP_BOOTS);

                        entries.add(OPLootTableItems.OP_SWORD);
                        entries.add(OPLootTableItems.OP_AXE);
                        entries.add(OPLootTableItems.OP_PICKAXE);
                        entries.add(OPLootTableItems.OP_SHOVEL);
                        entries.add(OPLootTableItems.OP_HOE);
                    })
                    .build());

    public static void registerItemGroups() {
        Opsheeps.LOGGER.info("🐑 REGISTER ITEMGROUPS");
    }
}
