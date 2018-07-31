package com.jacksonnn.guilds.commands.subcommands;

import com.jacksonnn.guilds.GuildUtils;
import com.jacksonnn.guilds.GuildsMain;
import com.jacksonnn.guilds.commands.SubCommand;
import java.util.ArrayList;
import java.util.List;

import com.jacksonnn.guilds.configuration.ConfigManager;
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
    GuildUtils.sendMessage(sender, GuildUtils.Prefix.prefixNormal, "Guilds Command Help");
    GuildUtils.sendMessage(sender, GuildUtils.Prefix.prefixNormal, "Aliases: /g, /guild, /guilds");
    sender.sendMessage(ChatColor.YELLOW + "/guilds help - " + guildsMain.getConfigManager().getLanguageConfig().get().getString("Commands.Help.Description"));
    sender.sendMessage(ChatColor.YELLOW + "/guilds admin - " + guildsMain.getConfigManager().getLanguageConfig().get().getString("Commands.Admin.Description"));
    sender.sendMessage(ChatColor.YELLOW + "/guilds create - " + guildsMain.getConfigManager().getLanguageConfig().get().getString("Commands.Create.Description"));
    sender.sendMessage(ChatColor.YELLOW + "/guilds info - " + guildsMain.getConfigManager().getLanguageConfig().get().getString("Commands.Info.Description"));
  }

}

