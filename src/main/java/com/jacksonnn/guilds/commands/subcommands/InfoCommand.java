package com.jacksonnn.guilds.commands.subcommands;

import com.jacksonnn.guilds.GuildsMain;
import com.jacksonnn.guilds.commands.SubCommand;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InfoCommand implements SubCommand {

  private GuildsMain plugin;

  public InfoCommand(GuildsMain plugin) {
    this.plugin = plugin;
  }

  @Override
  public String getName() {
    return "info";
  }

  @Override
  public List<String> getAliases() {
    List<String> aliases = new ArrayList<>();
    aliases.add("about");
    return aliases;
  }

  @Override
  public String getProperUse() {
    return "/guilds info";
  }

  @Override
  public String getDescription() {
    return "The Info extension";
  }


  @Override
  public void execute(CommandSender sender, List<String> args) {
    if (sender instanceof Player) {
      sender.sendMessage("Hi");
      return;
    }
    sender.sendMessage("You must be a player");

  }

}
