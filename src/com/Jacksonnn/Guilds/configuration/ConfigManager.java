package com.Jacksonnn.Guilds.configuration;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;

public class ConfigManager {
	public static Config defaultConfig;
	public static Config languageConfig;
	
	public ConfigManager() {
		defaultConfig = new Config(new File("config.yml"));
		languageConfig = new Config(new File("language.yml"));
		configCheck(ConfigType.DEFAULT);
		configCheck(ConfigType.LANGUAGE);
	}
	
	public static void configCheck(ConfigType type) {
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

			lang.addDefault("Commands.NoPermission", "You do not have permission to do that.");
			lang.addDefault("Commands.mustBePlayer", "The executor of the command must be a player.");
			
			lang.addDefault("General.prefix", "&8[&2Guilds&8]&f ");

			languageConfig.save();

		} else if (type == ConfigType.DEFAULT) {
			FileConfiguration config;
			config = defaultConfig.get();

			config.addDefault("Guilds.StarterOptions.startingCoins", "250");

			config.addDefault("Storage.engine", "sqlite");

			config.addDefault("Storage.MySQL.host", "localhost");
			config.addDefault("Storage.MySQL.port", 3306);
			config.addDefault("Storage.MySQL.pass", "");
			config.addDefault("Storage.MySQL.db", "minecraft");
			config.addDefault("Storage.MySQL.user", "root");

			defaultConfig.save();
		}
	}
}
