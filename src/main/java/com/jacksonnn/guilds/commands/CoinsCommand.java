package com.jacksonnn.guilds.commands;

import com.jacksonnn.guilds.configuration.ConfigManager;
import org.bukkit.command.CommandSender;

import java.util.List;

public class CoinsCommand extends GuildsCommand {
    public CoinsCommand() {
        super("coins", "/guilds coins <add | remove | deposit | withdrawl>", ConfigManager.languageConfig.get().getString("Commands.Coins.Description"), new String[] { "money", "bank", "coins" });
    }

    public void execute(CommandSender sender, List<String> args) {

    }
}
