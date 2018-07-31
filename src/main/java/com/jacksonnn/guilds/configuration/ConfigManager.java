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

      lang.addDefault("Commands.Admin.Description", "&6Admin Description");
      lang.addDefault("Commands.Create.Description", "&6Create Description");
      lang.addDefault("Commands.Help.Description", "&6Help Description");
      lang.addDefault("Commands.Info.Description", "&6Info Description");

      lang.addDefault("Error.NoPermission", "You do not have permission to do that.");
      lang.addDefault("Error.MustBePlayer", "The executor of the command must be a player.");
      lang.addDefault("Error.InvalidCommand", "&6Please run /guilds help for a commands");
      lang.addDefault("Error.UserMustBeOnline", "&6Sorry your user must be online");
      lang.addDefault("Error.AlreadyApartOfGuild.Other", "&6Sorry that user is already apart of a guild");
      lang.addDefault("Error.AlreadyApartOfGuild.Player", "&6Sorry You are already apart of a guild");

      lang.addDefault("Success.CreatedGuild.Other", "&6Created a Guild");
      lang.addDefault("Success.CreatedGuild.Player", "&6You now own a guild");

      lang.addDefault("General.prefix", "&8[&2Guilds&8]&f ");

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
