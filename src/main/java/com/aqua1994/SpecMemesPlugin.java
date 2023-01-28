package com.aqua1994;

import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.events.ChatMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import javax.inject.Inject;

@Slf4j
@PluginDescriptor(
        name = "Audio SpecMemes"
)
public class SpecMemesPlugin extends Plugin {
    @Inject
    private SoundEngine soundEngine;
    @Inject
    private Client client;

    @Override
    protected void startUp() throws Exception {
        log.info("SpecMemes started!");
    }

    @Override
    protected void shutDown() throws Exception {
        log.info("SpecMemes stopped!");
    }

    @Subscribe
    public void onChatMessage(ChatMessage message) {
        Sound sound = null;
        switch (message.getMessage()) {
            case "Smashing!":
                sound = Sound.SMASHING;
                break;
            case "Here fishy fishies!":
                sound = Sound.FISHIES;
                break;
            case "Chop chop!":
                sound = Sound.CHOP;
                break;
            case "Raarrrrrgggggghhhhhhh!":
                sound = Sound.RAARGH;
                break;
            case "For Camelot!":
                sound = Sound.CAMELOT;
                break;
        }
        if (sound != null) {
            client.addChatMessage(ChatMessageType.PUBLICCHAT, "Debug message", "Tried to play: " + sound.getResourceName(), "Debug message");
            soundEngine.playClip(sound);
        }
    }

    @Provides
    SpecMemesPluginConfig provideConfig(ConfigManager configManager) {
        return configManager.getConfig(SpecMemesPluginConfig.class);
    }
}
