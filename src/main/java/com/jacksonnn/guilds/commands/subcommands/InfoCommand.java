/*
    TODO METHODS:
        - void getPlayerBalance Method.
        - void getGuildBalance Method.
        - void getUserGuild Method.
        - void getPreviousGuild Method.
        - void getGuildLeader Method.
        - void getGuildApprentices Method.
        - void getGuildClaimedChunks Method.
*/
package com.jacksonnn.guilds.commands.subcommands;

import com.jacksonnn.guilds.GuildUtils;
import com.jacksonnn.guilds.GuildsMain;
import com.jacksonnn.guilds.commands.SubCommand;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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
    aliases.add("i");
    return aliases;
  }

  @Override
  public String getProperUse() {
    return "/guilds info <guild/player>";
  }

  @Override
  public String getDescription() {
    return plugin.getConfigManager().getLanguageConfig().get().getString("Commands.Info.Description");
  }


  @Override
  public void execute(CommandSender sender, List<String> args) {
      if(plugin.getGuildManager().isGuild(args.get(0))) {
            info(sender, args, "guild");
         } else if (plugin.getGuildManager().isPlayer(args.get(0))) {
            info(sender, args, "player");
         } else {
            GuildUtils.sendMessage(sender, GuildUtils.Prefix.prefixError, "The argument you entered was not a guild nor a player. Please enter one of those.");
      }
  }


  public void info(CommandSender sender, List<String> args, String type) {
      if (type.equalsIgnoreCase("player")) {

          Player player = Bukkit.getServer().getPlayer(args.get(0));

          GuildUtils.sendMessage(sender, GuildUtils.Prefix.prefixNormal, "Showing player information for: " + ChatColor.WHITE + args.get(2));
          sender.sendMessage(ChatColor.YELLOW + "Server Join Date: " + ChatColor.WHITE + player.getFirstPlayed() + " " + ChatColor.YELLOW + "|| Bank: " + ChatColor.WHITE /* + getPlayerBalanceMethod() */);
          sender.sendMessage(ChatColor.YELLOW + "Current Guild: " + ChatColor.WHITE + "[" /* + getUserGuildMethod()*/ + "]" );
          sender.sendMessage(ChatColor.YELLOW + "Previous Guilds: " + ChatColor.WHITE /* + getPreviousGuildsMethod() */);
      } else if (type.equalsIgnoreCase("guild")) {
          String guild = args.get(0);

          GuildUtils.sendMessage(sender, GuildUtils.Prefix.prefixNormal, "Showing guild information for: " + ChatColor.WHITE + guild);
          sender.sendMessage(ChatColor.YELLOW + "Leader: " + ChatColor.WHITE /* + getGuildLeaderMethod() */ + ChatColor.YELLOW + "|| Apprentices: " + ChatColor.WHITE /* + getGuildApprenticesMethod()*/);
          sender.sendMessage(ChatColor.YELLOW + "Guild Start Date: " + ChatColor.WHITE /* + getGuildStartDateMethod() */);
          sender.sendMessage(ChatColor.YELLOW + "Bank: " + ChatColor.WHITE /* + getGuildBankMethod() */ + ChatColor.YELLOW + "|| Chunks Claimed: " + ChatColor.WHITE /* +getGuildChunksClaimedMethod()*/);
          getMembers(sender, guild);
      }
  }

  public void getMembers(CommandSender sender, String guild) {
      List<String> guildMembers = new ArrayList<>();
      String playerName;

      for (String member : plugin.getGuildManager().getGuildMembers(guild)) {
          Player player = Bukkit.getServer().getPlayer(member);

          if (player.isOnline()) {
              playerName = Bukkit.getPlayer(UUID.fromString(member)).getName();
          } else {
              playerName = Bukkit.getOfflinePlayer(UUID.fromString(member)).getName();
          }
          guildMembers.add(playerName);
      }

      String formatted = guildMembers.stream().collect(Collectors.joining(", "));

      sender.sendMessage(ChatColor.YELLOW + "Members: " + ChatColor.WHITE + formatted);
  }
}
