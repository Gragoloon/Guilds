package com.jacksonnn.guilds.commands;

import com.jacksonnn.guilds.GuildUtils;
import com.jacksonnn.guilds.configuration.ConfigManager;
import com.jacksonnn.guilds.storage.DBConnection;
import java.util.List;
import org.bukkit.command.CommandSender;

public class CreateCommand extends GuildsCommand {

  public CreateCommand() {
    super("create", "/guilds create <name> [<leader>]",
        ConfigManager.languageConfig.get().getString("Commands.Create.Description"),
        new String[]{"new", "start", "create"});
  }

  public void execute(CommandSender sender, List<String> args) {
    if (correctLength(sender, args.size(), 2, 2)) {
      if (hasPermission(sender, "admin")) {
        if (!inAGuild(args.get(1))) {
          create(sender, args.get(0), args.get(1));
        } else {
          sender.sendMessage(GuildUtils.prefixError + args.get(1) + "is already in a guild.");
        }
      }
    } else if (correctLength(sender, args.size(), 1, 1)) {
      if (isPlayer(sender)) {
        if (hasPermission(sender)) {
          if (!inAGuild(sender.getName())) {
            create(sender, args.get(0), sender.getName());
          } else {
            sender.sendMessage(GuildUtils.prefixError + "You are already in a guild!");
          }
        }
      }
    } else {
      help(sender, false);
    }
  }

  public void create(CommandSender sender, String guildName, String leader) {
    Object scoins = ConfigManager.defaultConfig.get().get("Guilds.StarterOptions.startingCoins");

    if (guildExists(guildName)) {
      sender.sendMessage(GuildUtils.prefixError + "Guild " + guildName + " already exists.");
    } else {
      DBConnection.sql
          .modifyQuery("INSERT INTO guilds_guilds (leader, name, members, coins, sdate) VALUES (" +
              "'" + leader + "', " +
              "'" + guildName + "', " +
              "'" + leader + "', " +
              "'" + ConfigManager.defaultConfig.get().get("Guilds.StarterOptions.startingCoins")
              + "', " +
              "'" + GuildUtils.getCurrentDate() + "')");

      DBConnection.sql
          .modifyQuery("INSERT INTO guilds_players (uuid, name, current_guild) VALUES (" +
              "'" + leader + "', " +
              "'" + sender.getName() + "', " +
              "'" + guildName + "')");

      guilds.add(guildName);
      sender.sendMessage(
          GuildUtils.prefixSuccess + "Created the guild (" + guildName + "), with the leader "
              + leader + " and " + scoins + " coins on " + GuildUtils
              .getCurrentDate() + ".");
    }
  }
}

/*
DBConnection.sql.modifyQuery("INSERT INTO bounties (player, issuer, item, amount, startdate, enddate, assassin, status) VALUES ("
				+ "'" + player + "', "
				+ "'" + issuer + "', "
				+ "'" + item + "', "
				+ amount + ", "
				+ "'" + getCurrentDate() + "', "
				+ null + ", "
				+ null + ", "
				+ "'open')");
 */