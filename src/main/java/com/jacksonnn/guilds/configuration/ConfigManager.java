package com.jacksonnn.guilds.configuration;

import com.jacksonnn.guilds.GuildsMain;
import java.io.File;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigManager {

  private Config defaultConfig;
  private Config languageConfig;

  public ConfigManager(GuildsMain guildsMain) {
    defaultConfig = new Config(new File(guildsMain.getDataFolder(), "config.yml"));
    languageConfig = new Config(new File(guildsMain.getDataFolder(), "language.yml"));
    configCheck(ConfigType.DEFAULT);
    configCheck(ConfigType.LANGUAGE);
  }

  public void configCheck(ConfigType type) {
    if (type == ConfigType.LANGUAGE) {
      FileConfiguration lang;
      lang = languageConfig.get();

      lang.addDefault("Commands.Add.Description", "&6Add Description");
      lang.addDefault("Commands.Admin.Description", "&6Admin Description");
      lang.addDefault("Commands.Attack.Description", "&6AttackDescription");
      lang.addDefault("Commands.Chat.Description", "&6Chat Description");
      lang.addDefault("Commands.Claim.Description", "&6Claim Description");
      lang.addDefault("Commands.Coins.Description", "&6Coins Description");
      lang.addDefault("Commands.Create.Description", "&6Create Description");
      lang.addDefault("Commands.Delete.Description", "&6Delete Description");
      lang.addDefault("Commands.Help.Description", "&6Help Description");
      lang.addDefault("Commands.Info.Description", "&6Info Description");
      lang.addDefault("Commands.Invite.Description", "&6Invite Description");
      lang.addDefault("Commands.Job.Description", "&6Job Description");
      lang.addDefault("Commands.Kick.Description", "&6Kick Description");
      lang.addDefault("Commands.Remove.Description", "&6Remove Description");
      lang.addDefault("Commands.Trust.Description", "&6Trust Description");
      lang.addDefault("Commands.Unclaim.Description", "&6Unclaim Description");
      lang.addDefault("invalid-command", "&6Please run /guilds help for a commands");
      lang.addDefault("user-must-be-online", "&6Sorry your user must be online");
      lang.addDefault("already-apart-of-guild.other",
          "&6Sorry that user is already apart of an guild");
      lang.addDefault("already-apart-of-guild.player", "&6Sorry You are already apart of an group");

      lang.addDefault("Commands.NoPermission", "You do not have permission to do that.");
      lang.addDefault("Commands.mustBePlayer", "The executor of the command must be a player.");

      lang.addDefault("General.prefix", "&8[&2Guilds&8]&f ");

      languageConfig.save();

    } else if (type == ConfigType.DEFAULT) {
      FileConfiguration config;
      config = defaultConfig.get();

      config.addDefault("GuildsMain.StarterOptions.startingCoins", "250");

      config.addDefault("Storage.engine", "sqlite");

      config.addDefault("Storage.settings.host", "localhost");
      config.addDefault("Storage.settings.port", 3306);
      config.addDefault("Storage.settings.pass", "");
      config.addDefault("Storage.settings.db", "minecraft");
      config.addDefault("Storage.settings.user", "root");
      config.addDefault("Storage.settings.ssl", false);

      config.addDefault("Storage.settings.path", "db.sql");

      defaultConfig.save();
    }
  }


  public Config getDefaultConfig() {
    return defaultConfig;
  }

  public Config getLanguageConfig() {
    return languageConfig;
  }
}
