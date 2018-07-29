package com.jacksonnn.guilds.commands.subcommands;

import com.jacksonnn.guilds.GuildUtils;
import com.jacksonnn.guilds.GuildsMain;
import com.jacksonnn.guilds.commands.SubCommand;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class HelpCommand implements SubCommand {

  private GuildsMain guildsMain;

  public HelpCommand(GuildsMain guildsMain) {
    this.guildsMain = guildsMain;
  }

  @Override
  public String getName() {
    return "help";
  }

  @Override
  public List<String> getAliases() {
    List<String> aliases = new ArrayList<>();
    return aliases;
  }

  @Override
  public String getProperUse() {
    return "/guilds help";
  }

  @Override
  public String getDescription() {
    return guildsMain.getConfigManager().getLanguageConfig().get()
        .getString("Commands.Help.Description");
  }

  @Override
  public void execute(CommandSender sender, List<String> args) {
    sender.sendMessage(GuildUtils.Prefix.prefixNormal.getPrefix() + "Guilds Command Help");
    sender.sendMessage(GuildUtils.Prefix.prefixNormal.getPrefix() + "Aliases: /g, /guild, /guilds");
    sender.sendMessage(ChatColor.YELLOW + "/guilds help - Displays this help menu.");
    sender.sendMessage(ChatColor.YELLOW + "/guilds admin - Description coming soon");
    sender.sendMessage(ChatColor.YELLOW + "/guilds chat - Description coming soon");
    sender.sendMessage(ChatColor.YELLOW + "/guilds claim - Description coming soon");
    sender.sendMessage(ChatColor.YELLOW + "/guilds coins - Description coming soon");
    sender.sendMessage(ChatColor.YELLOW + "/guilds create - Description coming soon");
    sender.sendMessage(ChatColor.YELLOW + "/guilds info - Description coming soon");
    sender.sendMessage(ChatColor.YELLOW + "/guilds job - Description coming soon");
    sender.sendMessage(ChatColor.YELLOW + "/guilds unclaim - Description coming soon");
  }

}

