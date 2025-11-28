package com.discord.serverHelper.listeners;

import com.discord.serverHelper.commands.PingCommand;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MessageListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;

        String msg = event.getMessage().getContentRaw();

        if (msg.equalsIgnoreCase("!ping")) {
            PingCommand.handle(event);
        }
    }
}
