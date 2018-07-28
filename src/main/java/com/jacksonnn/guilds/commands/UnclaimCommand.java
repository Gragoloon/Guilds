package com.jacksonnn.guilds.commands;

import com.jacksonnn.guilds.configuration.ConfigManager;
import org.bukkit.command.CommandSender;

import java.util.List;

public class UnclaimCommand extends GuildsCommand {
    public UnclaimCommand() {
        super("unclaim", "/guilds unclaim", ConfigManager.languageConfig.get().getString("Commands.Unclaim.Description"), new String[] { "u", "unclaim" });
    }

    public void execute(CommandSender sender, List<String> args) {

    }
}
