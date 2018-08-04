package com.jacksonnn.guilds.commands.subcommands;

import com.jacksonnn.guilds.GuildUtils;
import com.jacksonnn.guilds.GuildsMain;
import com.jacksonnn.guilds.commands.SubCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public class ListCommand implements SubCommand {

    private GuildsMain guildsMain;

    public ListCommand(GuildsMain guildsMain) {
        this.guildsMain = guildsMain;
    }

    @Override
    public String getName() {
        return "list";
    }

    @Override
    public List<String> getAliases() {
        List<String> aliases = new ArrayList<>();
        aliases.add("l");
        aliases.add("community");
        return aliases;
    }

    @Override
    public String getProperUse() {
        return "/guilds list";
    }

    @Override
    public String getDescription() {
        return guildsMain.getConfigManager().getLanguageConfig().get().getString("Commands.List.Description");
    }

    @Override
    public void execute(CommandSender sender, List<String> args) {
        List<String> guilds = guildsMain.getGuildManager().getGuilds();

        GuildUtils.sendMessage(sender, GuildUtils.Prefix.prefixNormal, "List of all current guilds:");

        for (String g : guilds) {
            sender.sendMessage(ChatColor.YELLOW + g);
        }

        guilds.removeAll(guildsMain.getGuildManager().getGuilds());
    }
}
