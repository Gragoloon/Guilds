package com.Jacksonnn.Guilds.commands;

import static com.Jacksonnn.Guilds.GeneralMethods.*;

import com.Jacksonnn.Guilds.GeneralMethods;
import com.Jacksonnn.Guilds.configuration.ConfigManager;
import com.Jacksonnn.Guilds.storage.DBConnection;
import org.bukkit.command.CommandSender;

import java.util.List;


public class CreateCommand extends GuildsCommand {
    public CreateCommand() {
        super("create", "/guilds create <name> [<leader>]", ConfigManager.languageConfig.get().getString("Commands.Create.Description"), new String[] { "new", "start", "create" });
    }

    public void execute(CommandSender sender, List<String> args) {
        if (correctLength(sender, args.size(), 2, 2)) {
                if (hasPermission(sender, "admin")) {
                    create(sender, args.get(0), args.get(1));
                }
        } else if (correctLength(sender, args.size(), 1, 1)) {
            if (isPlayer(sender)) {
                if (hasPermission(sender)) {
                    create(sender, args.get(0), sender.getName());
                }
            }
        } else {
            help(sender, false);
        }
    }

    public void create(CommandSender sender, String guildName, String leader) {
        Object scoins = ConfigManager.defaultConfig.get().get("Guilds.StarterOptions.startingCoins");

        DBConnection.sql.modifyQuery("INSERT INTO guilds_guilds (leader, name, members, coins, sdate) VALUES (" +
                "'" + leader + "', " +
                "'" + guildName + "', " +
                "'" + leader + "', " +
                "'" + ConfigManager.defaultConfig.get().get("Guilds.StarterOptions.startingCoins") + "', " +
                "'" + getCurrentDate() + "')");
        sender.sendMessage(GeneralMethods.prefixSuccess + "Created the guild (" + guildName + "), with the leader " + leader + " and " + scoins + " coins on " + getCurrentDate() + ".");
        return;
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