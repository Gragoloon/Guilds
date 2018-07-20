package com.Jacksonnn.Guilds;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GeneralMethods {

    public static String prefixNormal = ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "Guilds" + ChatColor.DARK_GRAY + "] " + ChatColor.YELLOW;
    public static String prefixError = ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "Guilds" + ChatColor.DARK_GRAY + "] " + ChatColor.DARK_RED + "Error! " + ChatColor.RED;
    public static String prefixSuccess = ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "Guilds" + ChatColor.DARK_GRAY + "] " + ChatColor.DARK_GREEN + "Success! " + ChatColor.GREEN;

    public static void sendMessage(CommandSender sender, String prefix ,String message) {
        if (prefix.equalsIgnoreCase("normal")) {
            sender.sendMessage(prefixNormal + message);
        } else if (prefix.equalsIgnoreCase("error")) {
            sender.sendMessage(prefixError + message);
        } else if (prefix.equalsIgnoreCase("success")) {
            sender.sendMessage(prefixSuccess + message);
        }
    }

    public static String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

        Date date = new Date();
        return dateFormat.format(date);
    }
}
