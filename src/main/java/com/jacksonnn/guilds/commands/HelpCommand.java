package com.jacksonnn.guilds.commands;

import com.jacksonnn.guilds.GeneralMethods;
import com.jacksonnn.guilds.configuration.ConfigManager;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.List;

public class HelpCommand extends GuildsCommand {

    public HelpCommand() {
        super("help", "/guilds help <page>", ConfigManager.languageConfig.get().getString("Commands.Help.Description"), new String[] { "?", "h", "help" });
    }

    public void execute(CommandSender sender, List<String> args) {
        sender.sendMessage(GeneralMethods.prefixNormal + "Guilds Command Help");
        sender.sendMessage(GeneralMethods.prefixNormal + "Aliases: /g, /guild, /guilds");
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
