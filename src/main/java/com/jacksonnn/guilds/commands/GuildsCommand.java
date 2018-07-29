package com.jacksonnn.guilds.commands;

import com.jacksonnn.guilds.GuildUtils;
import com.jacksonnn.guilds.GuildsMain;
import com.jacksonnn.guilds.commands.subcommands.AdminCommand;
import com.jacksonnn.guilds.commands.subcommands.InfoCommand;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class GuildsCommand implements CommandExecutor, TabCompleter {

  private List<SubCommand> subCommands = new ArrayList<>();
  private GuildsMain plugin;

  public GuildsCommand(GuildsMain guildsMain) {
    this.plugin = guildsMain;
    registerSubCommands();
  }

  private void registerSubCommands() {
    subCommands.add(new AdminCommand(plugin));
    subCommands.add(new InfoCommand(plugin));
  }


  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

    if (args.length >= 1) {

      for (SubCommand subCommand : subCommands) {
        if (subCommand.getAliases().contains(args[0]) || subCommand.getName()
            .equalsIgnoreCase(args[0])) {
          subCommand.execute(sender, buildArguments(args));
          return true;
        }
      }
      sender.sendMessage(GuildUtils
          .color(plugin.getConfigManager().getLanguageConfig().get().getString("invalid-command")));
    } else {
      sender.sendMessage(GuildUtils
          .color(plugin.getConfigManager().getLanguageConfig().get().getString("invalid-command")));
    }
    return true;
  }

  /**
   * This skips the first arg.
   *
   * @param args all the args
   * @return the new args
   */
  private List<String> buildArguments(String[] args) {
    List<String> bArgs = new ArrayList<>();
    int i = 0;
    for (String arg : args) {
      if (i == 0) {

      } else {
        bArgs.add(arg);
      }
      i++;
    }
    return bArgs;
  }

  @Override
  public List<String> onTabComplete(CommandSender sender, Command command, String alias,
      String[] args) {
    return null;
  }
}
