package com.jacksonnn.guilds.commands;

import com.jacksonnn.guilds.GeneralMethods;
import com.jacksonnn.guilds.configuration.ConfigManager;
import com.jacksonnn.guilds.storage.DBConnection;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class GuildsCommand implements SubCommand {

    private final String name;
    private final String properUse;
    private final String description;
    private final String[] aliases;
    private final String noPermissionMessage;
    private final String mustBePlayer;
    public static Set<String> guilds = new HashSet<>();
    public static Set<String> leaders = new HashSet<>();

    public static Map<String, GuildsCommand> instances = new HashMap<>();

    public GuildsCommand(String name, String properUse, String description, String[] aliases) {
        this.name = name;
        this.properUse = properUse;
        this.description = description;
        this.aliases = aliases;

        this.noPermissionMessage = ChatColor.RED + ConfigManager.languageConfig.get().getString("Commands.NoPermission");
        this.mustBePlayer = ChatColor.RED + ConfigManager.languageConfig.get().getString("Commands.mustBePlayer");

        instances.put(name, this);
    }

    public String getName() {
        return name;
    }

    public String getProperUse() {
        return properUse;
    }

    public String getDescription() {
        return description;
    }

    public String[] getAliases() {
        return aliases;
    }

    public void help(CommandSender sender, boolean description) {
        GeneralMethods.sendMessage(sender, "error", "Proper Usage: " + properUse);
        if (description) {
            sender.sendMessage(ChatColor.YELLOW + this.description);
        }
    }

    public boolean hasPermission(CommandSender sender) {
        if (sender.hasPermission("guilds.command." + name)) {
            return true;
        } else {
            GeneralMethods.sendMessage(sender, "error", this.noPermissionMessage);
            return false;
        }
    }

    public boolean inAGuild(String player) {
        //Coming Soon
        return true;
    }

    public boolean isGuildLeader(String player) {
        if (leaders.contains(player)) {
            return true;
        } else {
            return false;
        }
    }

    public static void loadLeaders() {
        try {
            while(getGuilds().next()) {
                leaders.add(getGuilds().getString("leader"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean guildExists(String guild) {
        if (guilds.contains(guild)) {
            return true;
        } else {
            return false;
        }
    }

    public static ResultSet getGuilds() {
        return DBConnection.sql.readQuery("SELECT * FROM guilds_guilds");
    }

    public static void loadGuilds() {
        try {
            while (getGuilds().next()) {
                guilds.add(getGuilds().getString("guild"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean hasPermission(CommandSender sender, String extra) {
        if (sender.hasPermission("guilds.command." + name + "." + extra)) {
            return true;
        } else {
            GeneralMethods.sendMessage(sender, "error", this.noPermissionMessage);
            return false;
        }
    }

    public boolean correctLength(CommandSender sender, int size, int min, int max) {
        if (size < min || size > max) {
            help(sender, false);
            return false;
        } else {
            return true;
        }
    }

    public boolean isPlayer(CommandSender sender) {
        if (sender instanceof Player) {
            return true;
        } else {
            GeneralMethods.sendMessage(sender, "error", this.mustBePlayer);
            return false;
        }
    }
}
