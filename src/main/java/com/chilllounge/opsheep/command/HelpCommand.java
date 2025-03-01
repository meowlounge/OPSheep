package com.chilllounge.opsheep.command;

import com.chilllounge.opsheep.item.OpSheepItemGroups;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.WrittenBookContentComponent;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.RawFilteredPair;
import net.minecraft.text.Text;

import java.util.ArrayList;
import java.util.List;

public class HelpCommand {
	public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
		dispatcher.register(
				CommandManager.literal("opsheep")
						.then(CommandManager.literal("get-help-book")
								.executes(context -> {
									ServerCommandSource source = context.getSource();
									Entity entity = source.getEntity();
									if (!(entity instanceof ServerPlayerEntity player)) {
										source.sendFeedback(() -> Text.translatable("command.opsheep.help.client"), false);
										return 0;
									}
									sendHelpBook(player);
									return Command.SINGLE_SUCCESS;
								})
						)
		);

		ItemGroupEvents.modifyEntriesEvent(OpSheepItemGroups.SUPER_ITEM_GROUP_KEY)
				.register((entries) -> entries.add(createBookItem()));
	}

	public static void sendHelpBook(ServerPlayerEntity player) {
		ItemStack book = createBookItem();

		boolean added = player.giveItemStack(book);
		if (!added) {
			player.dropItem(book, false);
		}
	}

	private static ItemStack createBookItem() {
		List<Text> helpPages = createHelpPages();

		List<RawFilteredPair<Text>> rawPages = helpPages.stream()
				.map(RawFilteredPair::of)
				.toList();

		WrittenBookContentComponent content = new WrittenBookContentComponent(
				RawFilteredPair.of("Help Guide"),
				"opsheep Guide",
				0,
				rawPages,
				true
		);

		ItemStack book = new ItemStack(Items.WRITTEN_BOOK);
		book.set(DataComponentTypes.WRITTEN_BOOK_CONTENT, content);

		return book;
	}

	private static List<Text> createHelpPages() {
		List<Text> pages = new ArrayList<>();
		pages.add(Text.translatable("opsheep.help.page1"));
		pages.add(Text.translatable("opsheep.help.page2"));
		pages.add(Text.translatable("opsheep.help.page3"));
		pages.add(Text.translatable("opsheep.help.page4"));
		pages.add(Text.translatable("opsheep.help.page5"));
		return pages;
	}
}
