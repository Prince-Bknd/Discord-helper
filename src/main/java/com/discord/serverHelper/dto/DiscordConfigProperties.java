package com.discord.serverHelper.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "discord")
public class DiscordConfigProperties {
    private String token;
    private boolean enabled;
    private String intents;

    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }

    public boolean isEnabled() {
        return enabled;
    }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getIntents() {
        return intents;
    }
    public void setIntents(String intents) {
        this.intents = intents;
    }
}

