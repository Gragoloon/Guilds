package com.jacksonnn.guilds.commands;

import com.jacksonnn.guilds.configuration.ConfigManager;
import java.util.List;
import org.bukkit.command.CommandSender;

public class InfoCommand extends GuildsCommand {

  public InfoCommand() {
    super("info", "/guilds info <guild | player>",
        ConfigManager.languageConfig.get().getString("Commands.Info.Description"),
        new String[]{"i", "who", "info"});
  }

  public void execute(CommandSender sender, List<String> args) {

  }
}
