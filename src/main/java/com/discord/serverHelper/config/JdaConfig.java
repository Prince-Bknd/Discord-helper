package com.discord.serverHelper.config;

import com.discord.serverHelper.dto.DiscordConfigProperties;
import com.discord.serverHelper.listeners.MessageListener;
import com.discord.serverHelper.listeners.SlashCommandListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.GatewayIntent;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JdaConfig {
    
    private final DiscordConfigProperties config;

    public JdaConfig(DiscordConfigProperties config) {
        this.config = config;
    }

    @Bean
    public JDA jda() throws Exception {
        System.out.println("Loaded token from YAML: " + config.getToken().substring(0, 6) + "*******");

        JDA jda = JDABuilder.createDefault(config.getToken())
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .addEventListeners(
                    new MessageListener(),
                    new SlashCommandListener()
                )
                .build();

        jda.awaitReady();

        jda.getGuilds().forEach(guild -> {
            guild.updateCommands()
                .addCommands(
                    Commands.slash("hello", "Say hello to the bot!"),
                    Commands.slash("hi", "Testing the bot!"),
                    Commands.slash("help", "This Cmd will be avialable soon")
                )
                .queue();
        });

        System.out.println("Discord Bot is running via Spring Boot!");

        return jda;
    }
}
