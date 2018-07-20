package com.Jacksonnn.Guilds.commands;

import com.Jacksonnn.Guilds.Guilds;
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
    }
}
