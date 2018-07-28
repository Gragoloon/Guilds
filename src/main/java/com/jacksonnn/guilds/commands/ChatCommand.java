package com.jacksonnn.guilds.commands;

import com.jacksonnn.guilds.configuration.ConfigManager;
import java.util.List;
import org.bukkit.command.CommandSender;

public class ChatCommand extends GuildsCommand {

  public ChatCommand() {
    super("chat", "/guilds chat <chatName>",
        ConfigManager.languageConfig.get().getString("Commands.Chat.Description"),
        new String[]{"c", "chat", "talk"});
  }

  public void execute(CommandSender sender, List<String> args) {

  }
}
