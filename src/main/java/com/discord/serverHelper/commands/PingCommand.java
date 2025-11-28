package com.discord.serverHelper.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class PingCommand {

    public static void handle(MessageReceivedEvent event) {
        event.getChannel().sendMessage("Pong 🏓").queue();
    }
}
