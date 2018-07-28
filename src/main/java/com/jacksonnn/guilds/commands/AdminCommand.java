package com.jacksonnn.guilds.commands;

import com.jacksonnn.guilds.configuration.ConfigManager;
import java.util.List;
import org.bukkit.command.CommandSender;

public class AdminCommand extends GuildsCommand {

  public AdminCommand() {
    super("admin", "/guilds admin",
        ConfigManager.languageConfig.get().getString("Commands.Admin.Description"),
        new String[]{"admin", "staff"});
  }

  public void execute(CommandSender sender, List<String> args) {

  }
}
