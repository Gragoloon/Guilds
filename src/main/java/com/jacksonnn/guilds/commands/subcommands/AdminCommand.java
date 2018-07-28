package com.jacksonnn.guilds.commands.subcommands;

import com.jacksonnn.guilds.GuildsMain;
import com.jacksonnn.guilds.commands.SubCommand;
import java.util.List;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminCommand implements SubCommand {

  private GuildsMain plugin;

  public AdminCommand(GuildsMain plugin) {
    this.plugin = plugin;
  }

  @Override
  public String getName() {
    return null;
  }

  @Override
  public List<String> getAliases() {
    return null;
  }

  @Override
  public String getProperUse() {
    return null;
  }

  @Override
  public String getDescription() {
    return null;
  }

  @Override
  public boolean requiresPlayer() {
    return false;
  }

  @Override
  public void execute(CommandSender sender, List<String> args) {

  }

  @Override
  public void execute(Player player, List<String> args) {
    execute((CommandSender) player, args);
  }
}
