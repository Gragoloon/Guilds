package com.jacksonnn.guilds.commands.subcommands;

import com.jacksonnn.guilds.GuildUtils;
import com.jacksonnn.guilds.GuildsMain;
import com.jacksonnn.guilds.commands.SubCommand;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CreateCommand implements SubCommand {

  private GuildsMain guildsMain;

  public CreateCommand(GuildsMain guildsMain) {
    this.guildsMain = guildsMain;
  }

  @Override
  public String getName() {
    return "create";
  }

  @Override
  public List<String> getAliases() {
    List<String> aliases = new ArrayList<>();
    return aliases;
  }

  // /guild create other {owner} {Name}
  @Override
  public String getProperUse() {
    return "/guild create {NAME}";
  }

  @Override
  public String getDescription() {
    return guildsMain.getConfigManager().getLanguageConfig().get().getString("Commands.Create.Description");
  }

  @Override
  public void execute(CommandSender sender, List<String> args) {
    if (args.size() >= 3) {
      if (args.get(0).equalsIgnoreCase("other")) {
        //Create guild as other as owner
        String user = args.get(1);
        String name = GuildUtils.getMessage(args, 2);
        Player player = Bukkit.getPlayer(user);
        if (player == null) {
            GuildUtils.sendMessage(sender, GuildUtils.Prefix.prefixError, GuildUtils.color(guildsMain.getConfigManager().getLanguageConfig().get().getString("Error.UserMustBeOnline")));
          return;
        }
        if (guildsMain.getGuildManager().hasGuild(player.getUniqueId())) {
            GuildUtils.sendMessage(sender, GuildUtils.Prefix.prefixNormal, GuildUtils.color(guildsMain.getConfigManager().getLanguageConfig().get().getString("Error.AlreadyApartOfGuild.Other")));
          return;
        }
        guildsMain.getGuildManager().createGuild(player.getUniqueId(), name);
          GuildUtils.sendMessage(sender, GuildUtils.Prefix.prefixSuccess, GuildUtils.color(guildsMain.getConfigManager().getLanguageConfig().get().getString("Success.CreatedGuild.Other")));
        return;
      }
    }
    if (sender instanceof Player) {
      Player player = (Player) sender;
      if (guildsMain.getGuildManager().hasGuild(player.getUniqueId())) {
          GuildUtils.sendMessage(sender, GuildUtils.Prefix.prefixError, GuildUtils.color(guildsMain.getConfigManager().getLanguageConfig().get().getString("Error.AlreadyApartOfGuild.Player")));
        return;
      }
      String name = GuildUtils.getMessage(args, 0);

      guildsMain.getGuildManager().createGuild(player.getUniqueId(), name);
      GuildUtils.sendMessage(player, GuildUtils.Prefix.prefixSuccess, GuildUtils.color(guildsMain.getConfigManager().getLanguageConfig().get().getString("Success.CreatedGuild.Player")));
    } else {
        GuildUtils.sendMessage(sender, GuildUtils.Prefix.prefixError, GuildUtils.color(guildsMain.getConfigManager().getLanguageConfig().get().getString("Error.MustBePlayer")));
    }


  }
}

