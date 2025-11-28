package com.discord.serverHelper.listeners;

import com.discord.serverHelper.Utils.Utils;
import com.discord.serverHelper.commands.PrefixCommands;
import com.discord.serverHelper.commands.PingCommand;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MessageListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;

        Message message = event.getMessage();

        if (message.getContentRaw() == null || message.getContentRaw().isEmpty()) {
            System.out.println("Message content is empty, skipping text processing");
            return;
        }

        if (event.getMessage().getContentRaw().startsWith(Utils.PREFIX)) {
            switch (event.getMessage().getContentRaw().substring(1).split("\\s+")[0].toLowerCase()) {
                case "ping":
                    PingCommand.handle(event);
                    break;
                case "hello":
                    event.getChannel().sendMessage("Hello, " + event.getAuthor().getName() + "!").queue();
                    break;
                default:
                    PrefixCommands.handleDefaultCommand(event);
                    break;
            }
        }
    }
}