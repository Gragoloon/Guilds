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
    return guildsMain.getConfigManager().getLanguageConfig().get()
        .getString("Commands.Create.Description");
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
          sender.sendMessage(GuildUtils.color(
              guildsMain.getConfigManager().getLanguageConfig().get()
                  .getString("user-must-be-online")));
          return;
        }
        if (guildsMain.getGuildManager().hasGuild(player.getUniqueId())) {
          sender.sendMessage(GuildUtils.color(
              guildsMain.getConfigManager().getLanguageConfig().get()
                  .getString("already-apart-of-guild.other")));
          return;
        }
        guildsMain.getGuildManager().createGuild(player.getUniqueId(), name);
        sender.sendMessage(GuildUtils.color(
            guildsMain.getConfigManager().getLanguageConfig().get()
                .getString("created-guild.other")));
        return;
      }
    }
    if (sender instanceof Player) {
      Player player = (Player) sender;
      if (guildsMain.getGuildManager().hasGuild(player.getUniqueId())) {
        sender.sendMessage(GuildUtils.color(
            guildsMain.getConfigManager().getLanguageConfig().get()
                .getString("already-apart-of-guild.player")));
        return;
      }
      String name = GuildUtils.getMessage(args, 0);

      guildsMain.getGuildManager().createGuild(player.getUniqueId(), name);
      player.sendMessage(GuildUtils.color(
          guildsMain.getConfigManager().getLanguageConfig().get()
              .getString("created-guild.player")));
    } else {
      //Commands.mustBePlayer
      sender.sendMessage(GuildUtils.color(
          guildsMain.getConfigManager().getLanguageConfig().get()
              .getString("Commands.mustBePlayer")));
    }


  }
}

