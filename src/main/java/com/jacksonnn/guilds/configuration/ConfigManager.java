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

      lang.addDefault("Commands.Admin.Description", "&eAdmin Description");
      lang.addDefault("Commands.Create.Description", "&eCreate Description");
      lang.addDefault("Commands.Help.Description", "&eHelp Description");
      lang.addDefault("Commands.Info.Description", "&eInfo Description");

      lang.addDefault("Error.NoPermission", "&cYou do not have permission to do that.");
      lang.addDefault("Error.MustBePlayer", "&cThe executor of the command must be a player.");
      lang.addDefault("Error.InvalidCommand", "&cPlease run /guilds help for a commands.");
      lang.addDefault("Error.UserMustBeOnline", "&cSorry that user must be online.");
      lang.addDefault("Error.AlreadyApartOfGuild.Other", "&cSorry that user is already apart of a guild.");
      lang.addDefault("Error.AlreadyApartOfGuild.Player", "&cSorry You are already apart of a guild.");

      lang.addDefault("Success.CreatedGuild.Other", "&aCreated a Guild.");
      lang.addDefault("Success.CreatedGuild.Player", "&aYou now own a guild!");

      languageConfig.save();

    } else if (type == ConfigType.DEFAULT) {
      FileConfiguration config;
      config = defaultConfig.get();

      config.addDefault("GuildsMain.StarterOptions.startingCoins", "250");

      config.addDefault("Storage.engine", "sqlite");

      config.addDefault("Storage.settings.host", "localhost");
      config.addDefault("Storage.settings.port", 3306);
      config.addDefault("Storage.settings.password", "");
      config.addDefault("Storage.settings.database", "minecraft");
      config.addDefault("Storage.settings.username", "root");
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
