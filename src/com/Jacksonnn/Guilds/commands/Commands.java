package com.Jacksonnn.Guilds.commands;

import com.Jacksonnn.Guilds.GeneralMethods;
import com.Jacksonnn.Guilds.Guilds;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;

import java.util.Arrays;
import java.util.List;

public class Commands {
    private Guilds plugin;

    public Commands(Guilds plugin) {
        this.plugin = plugin;
        registerCommands();
    }

    public void registerCommands() {
        PluginCommand Guilds = plugin.getCommand("guilds");
        new AddCommand();
        new AdminCommand();
        new AttackCommand();
        new ChatCommand();
        new ClaimCommand();
        new CoinsCommand();
        new CreateCommand();
        new DeleteCommand();
        new HelpCommand();
        new InfoCommand();
        new InviteCommand();
        new JobCommand();
        new KickCommand();
        new RemoveCommand();
        new TrustCommand();
        new UnclaimCommand();

        CommandExecutor exe = new CommandExecutor() {
            @Override
            public boolean onCommand(CommandSender s, Command c, String label, String[] args) {

                if (args.length == 0) {
                    s.sendMessage(GeneralMethods.prefixNormal + "Guilds Command Help");
                    s.sendMessage(GeneralMethods.prefixNormal + "Aliases: /g, /guild, /guilds");
                    s.sendMessage(ChatColor.YELLOW + "/guilds help - Displays this help menu.");
                    s.sendMessage(ChatColor.YELLOW + "/guilds add - Description coming soon");
                    s.sendMessage(ChatColor.YELLOW + "/guilds admin - Description coming soon");
                    s.sendMessage(ChatColor.YELLOW + "/guilds attack - Description coming soon");
                    s.sendMessage(ChatColor.YELLOW + "/guilds chat - Description coming soon");
                    s.sendMessage(ChatColor.YELLOW + "/guilds claim - Description coming soon");
                    s.sendMessage(ChatColor.YELLOW + "/guilds coins - Description coming soon");
                    s.sendMessage(ChatColor.YELLOW + "/guilds create - Description coming soon");
                    s.sendMessage(ChatColor.YELLOW + "/guilds delete - Description coming soon");
                    s.sendMessage(ChatColor.YELLOW + "/guilds info - Description coming soon");
                    s.sendMessage(ChatColor.YELLOW + "/guilds invite - Description coming soon");
                    s.sendMessage(ChatColor.YELLOW + "/guilds job - Description coming soon");
                    s.sendMessage(ChatColor.YELLOW + "/guilds kick - Description coming soon");
                    s.sendMessage(ChatColor.YELLOW + "/guilds remove - Description coming soon");
                    s.sendMessage(ChatColor.YELLOW + "/guilds trust - Description coming soon");
                    s.sendMessage(ChatColor.YELLOW + "/guilds unclaim - Description coming soon");

                    return true;
                }

                List<String> sendingArgs = Arrays.asList(args).subList(1, args.length);
                for (GuildsCommand command : GuildsCommand.instances.values()) {
                    if (Arrays.asList(command.getAliases()).contains(args[0].toLowerCase())) {
                        command.execute(s, sendingArgs);
                        return true;
                    }
                }

                return true;
            }
        };
        Guilds.setExecutor(exe);
        Bukkit.getServer().getLogger().info("Commands have been enabled!");
    }
}
