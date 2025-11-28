package com.discord.serverHelper.listeners;

import com.discord.serverHelper.commands.HelloSlashCommand;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class SlashCommandListener extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        switch (event.getName()) {
            case "hello" -> HelloSlashCommand.handle(event);
        }
    }
}
