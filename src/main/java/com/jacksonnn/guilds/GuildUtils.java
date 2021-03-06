package com.jacksonnn.guilds;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class GuildUtils {

  public enum Prefix {
    prefixNormal(ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "Guilds" + ChatColor.DARK_GRAY + "] " + ChatColor.YELLOW),
    prefixError(ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "Guilds" + ChatColor.DARK_GRAY + "] " + ChatColor.DARK_RED + "Error! " + ChatColor.RED),
    prefixSuccess(ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "Guilds" + ChatColor.DARK_GRAY + "] " + ChatColor.DARK_GREEN + "Success! " + ChatColor.GREEN);

    private String prefix;

    Prefix(String prefix) {
      this.prefix = prefix;
    }

    public String getPrefix() {
      return prefix;
    }
  }

  public static void sendMessage(CommandSender sender, Prefix prefix, String message) {
    sender.sendMessage(prefix.getPrefix() + message);
  }

  public static String color(final String string) {
    return ChatColor.translateAlternateColorCodes('&', string);
  }

  public static String getCurrentDate() {
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

    Date date = new Date();
    return dateFormat.format(date);
  }


  public static String getMessage(final List<String> args, final int start) {
    final StringBuilder bldr = new StringBuilder();

    for (int i = start; i < args.size(); i++) {
      if (i != start) {
        bldr.append(" ");

      }
      bldr.append(args.get(i));
    }
    return bldr.toString();
  }

}
