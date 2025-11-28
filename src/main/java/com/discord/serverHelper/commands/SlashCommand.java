package com.discord.serverHelper.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class SlashCommand {

    public static void handleHello(SlashCommandInteractionEvent event) {
        event.reply("Hello " + event.getUser().getName() + "! 👋").queue();
    }

    public static void handleAllCommand(SlashCommandInteractionEvent event) {
        switch(event.getName()){
            case "hi":
                event.reply("Hi, How can i help you??").queue();
                break;
            default:
                event.reply("cmd not recognised").queue();
        }
    }

    public static void handleErrorCommand(SlashCommandInteractionEvent event) {
        event.reply("Provided cmd has not being found!!!").queue();
    }
}
