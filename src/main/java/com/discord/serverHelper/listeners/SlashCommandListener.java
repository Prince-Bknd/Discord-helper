package com.discord.serverHelper.listeners;

import com.discord.serverHelper.commands.SlashCommand;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class SlashCommandListener extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        switch (event.getName()) {
            case "hello":
                SlashCommand.handleHello(event);
                break;
            case "hi" :
                SlashCommand.handleAllCommand(event);
                break;
            default:
                SlashCommand.handleErrorCommand(event);
        }
    }
}
