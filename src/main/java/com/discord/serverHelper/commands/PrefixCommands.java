package com.discord.serverHelper.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class PrefixCommands {
    public static void handleDefaultCommand(MessageReceivedEvent cmd){
        switch(cmd.getMessage().getContentRaw().substring(1).trim()){
            case "help":
                cmd.getChannel().sendMessage("Cmd to help Avialable soon").queue();
                break;
            case "mf":
                cmd.getChannel().sendMessage("WTH?").queue();
                break;
            default:
                cmd.getChannel().sendMessage("Cmd has not been recognised").queue();
        }
        
    }
}
