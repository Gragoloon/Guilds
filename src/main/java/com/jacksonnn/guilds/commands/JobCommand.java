package com.jacksonnn.guilds.commands;

import com.jacksonnn.guilds.configuration.ConfigManager;
import java.util.List;
import org.bukkit.command.CommandSender;

public class JobCommand extends GuildsCommand {

  public JobCommand() {
    super("job", "/guilds job",
        ConfigManager.languageConfig.get().getString("Commands.Job.Description"),
        new String[]{"j", "work", "job", "jobs"});
  }

  public void execute(CommandSender sender, List<String> args) {

  }
}
