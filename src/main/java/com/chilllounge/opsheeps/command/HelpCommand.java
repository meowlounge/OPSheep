package com.chilllounge.opsheeps.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.entity.Entity;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.network.ServerPlayerEntity;

import java.util.ArrayList;
import java.util.List;

public class HelpCommand {
	public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
		dispatcher.register(
				CommandManager.literal("opsheeps")
						.then(CommandManager.literal("help")
								.executes(context -> {
									ServerCommandSource source = context.getSource();
									Entity entity = source.getEntity();
									if (!(entity instanceof ServerPlayerEntity player)) {
										source.sendFeedback(() -> Text.translatable("command.opsheeps.help.client"), false);
										return 0;
									}
									sendHelpMessage(player);
									return Command.SINGLE_SUCCESS;
								})
						)
		);
	}

	public static void sendHelpMessage(ServerPlayerEntity player) {
		List<Text> pages = createHelpPages();
		for (Text page : pages) {
			player.sendMessage(page, false);
		}
	}

	private static List<Text> createHelpPages() {
		List<Text> pages = new ArrayList<>();
		pages.add(Text.translatable("opsheeps.help.page1"));
		pages.add(Text.translatable("opsheeps.help.page2"));
		pages.add(Text.translatable("opsheeps.help.page3"));
		pages.add(Text.translatable("opsheeps.help.page4"));
		pages.add(Text.translatable("opsheeps.help.page5"));
		return pages;
	}
}
