package com.jacksonnn.guilds.commands;

import com.jacksonnn.guilds.configuration.ConfigManager;
import java.util.List;
import org.bukkit.command.CommandSender;

public class ClaimCommand extends GuildsCommand {

  public ClaimCommand() {
    super("claim", "/guilds claim",
        ConfigManager.languageConfig.get().getString("Commands.Claim.Description"),
        new String[]{"claim", "take"});
  }

  public void execute(CommandSender sender, List<String> args) {

  }
}
