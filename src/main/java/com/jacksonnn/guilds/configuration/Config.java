package com.jacksonnn.guilds.configuration;

import java.io.File;

import com.jacksonnn.guilds.Guilds;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Config {
	private File file;
	private Guilds plugin;
	private FileConfiguration config;
	
	public Config(File file) {
		this.plugin = Guilds.plugin;
		this.file = new File(plugin.getDataFolder() + File.separator + file);
		this.config = YamlConfiguration.loadConfiguration(this.file);
		reload();
	}
	
	public void create() {
		if (!file.getParentFile().exists()) {
			try {
				file.getParentFile().mkdir();
				plugin.getLogger().info("Generating new directory for " + file.getName());
			} catch (Exception e) {
				plugin.getLogger().info("Failed to generate directory!");
				e.printStackTrace();
			}
		}
		
		if (!file.exists()) {
			try {
				file.createNewFile();
				plugin.getLogger().info("Generating new " + file.getName() + "!");
			} catch (Exception e) {
				plugin.getLogger().info("Failed to generate " + file.getName() + "!");
			}
		}
	}
	
	public FileConfiguration get() {
		return config;
	}
	
	public void reload() {
		create();
		try {
			config.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void save() {
		try {
			config.options().copyDefaults(true);
			config.save(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
