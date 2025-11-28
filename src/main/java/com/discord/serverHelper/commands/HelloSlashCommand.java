package com.discord.serverHelper.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class HelloSlashCommand {

    public static void handle(SlashCommandInteractionEvent event) {
        event.reply("Hello " + event.getUser().getName() + "! 👋").queue();
    }
}
