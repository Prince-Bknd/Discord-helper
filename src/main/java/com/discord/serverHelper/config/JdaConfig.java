package com.discord.serverHelper.config;

import com.discord.serverHelper.dto.DiscordConfigProperties;
import com.discord.serverHelper.listeners.MessageListener;
import com.discord.serverHelper.listeners.SlashCommandListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

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
                .addEventListeners(
                        new MessageListener(),
                        new SlashCommandListener()
                )
                .build();

        jda.awaitReady();
        System.out.println("Discord Bot is running via Spring Boot!");

        return jda;
    }
}
