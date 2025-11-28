package com.discord.serverHelper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.discord.serverHelper.dto.DiscordConfigProperties;

@SpringBootApplication
@EnableConfigurationProperties(DiscordConfigProperties.class)
public class ServerHelperApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerHelperApplication.class, args);
	}

}
