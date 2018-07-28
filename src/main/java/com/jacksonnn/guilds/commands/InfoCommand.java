package com.jacksonnn.guilds.commands;

import com.jacksonnn.guilds.configuration.ConfigManager;
import org.bukkit.command.CommandSender;

import java.util.List;

public class InfoCommand extends GuildsCommand {
    public InfoCommand() {
        super("info", "/guilds info <guild | player>", ConfigManager.languageConfig.get().getString("Commands.Info.Description"), new String[] { "i", "who", "info" });
    }

    public void execute(CommandSender sender, List<String> args) {

    }
}
