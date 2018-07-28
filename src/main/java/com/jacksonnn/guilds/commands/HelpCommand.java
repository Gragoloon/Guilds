package com.jacksonnn.guilds.commands;

import com.jacksonnn.guilds.configuration.ConfigManager;
import java.util.List;
import org.bukkit.command.CommandSender;

public class HelpCommand extends GuildsCommand {

  public HelpCommand() {
    super("help", "/guilds help <page>",
        ConfigManager.languageConfig.get().getString("Commands.Help.Description"),
        new String[]{"?", "h", "help"});
  }

  public void execute(CommandSender sender, List<String> args) {

  }
}
