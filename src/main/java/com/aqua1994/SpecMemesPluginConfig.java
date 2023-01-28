package com.aqua1994;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Range;

@ConfigGroup("specmemes")
public interface SpecMemesPluginConfig extends Config {
    @Range(
            min = 0,
            max = 200
    )
    @ConfigItem(
            keyName = "volume",
            name = "Volume",
            description = "Adjust how loud the audio is played!"
    )
    default int volume() {
        return 100;
    }

}
