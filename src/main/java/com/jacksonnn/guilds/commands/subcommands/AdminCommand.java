package com.jacksonnn.guilds.commands.subcommands;

import com.jacksonnn.guilds.GuildsMain;
import com.jacksonnn.guilds.commands.SubCommand;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.command.CommandSender;

public class AdminCommand implements SubCommand {

  private GuildsMain plugin;

  public AdminCommand(GuildsMain plugin) {
    this.plugin = plugin;
  }

  @Override
  public String getName() {
    return "admin";
  }

  @Override
  public List<String> getAliases() {
    List<String> aliases = new ArrayList<>();
    aliases.add("a");
    aliases.add("staff");
    aliases.add("mod");
    return aliases;
  }

  @Override
  public String getProperUse() {
    return "/guilds admin";
  }

  @Override
  public String getDescription() {
    return plugin.getConfigManager().getLanguageConfig().get()
        .getString("Commands.Info.Description");
  }

  @Override
  public void execute(CommandSender sender, List<String> args) {
    sender.sendMessage("Welcome to the admin  Command.");
  }

}
