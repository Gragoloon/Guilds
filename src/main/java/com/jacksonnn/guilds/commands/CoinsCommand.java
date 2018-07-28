package com.jacksonnn.guilds.commands;

import com.jacksonnn.guilds.configuration.ConfigManager;
import java.util.List;
import org.bukkit.command.CommandSender;

public class CoinsCommand extends GuildsCommand {

  public CoinsCommand() {
    super("coins", "/guilds coins <add | remove | deposit | withdrawl>",
        ConfigManager.languageConfig.get().getString("Commands.Coins.Description"),
        new String[]{"money", "bank", "coins"});
  }

  public void execute(CommandSender sender, List<String> args) {

  }
}
