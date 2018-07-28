package com.jacksonnn.guilds;

import java.util.logging.Logger;

import com.jacksonnn.guilds.commands.Commands;
import com.jacksonnn.guilds.commands.GuildsCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.jacksonnn.guilds.configuration.ConfigManager;
import com.jacksonnn.guilds.storage.DBConnection;

import net.md_5.bungee.api.ChatColor;

public class Guilds extends JavaPlugin {
	public static Guilds plugin;
	public static Logger log;
	
	@Override
	public void onEnable() {
		plugin = this;
		Guilds.log = this.getLogger();
        new ConfigManager();
		DBConnection.host = getConfig().getString("Storage.MySQL.host");
		DBConnection.port = getConfig().getInt("Storage.MySQL.port");
		DBConnection.pass = getConfig().getString("Storage.MySQL.pass");
		DBConnection.db = getConfig().getString("Storage.MySQL.db");
		DBConnection.user = getConfig().getString("Storage.MySQL.user");
		DBConnection.init();
		if (!DBConnection.isOpen()) {
			// Message is logged by DBConnection
			return;
		}
		GuildsCommand.loadGuilds();
		GuildsCommand.loadLeaders();
        new Commands(plugin);
		Bukkit.getServer().getLogger().info(ChatColor.DARK_GREEN + "[Guilds] Guilds has sucessfully been enabled!");
	}
	
	@Override
	public void onDisable() {
		if (DBConnection.isOpen != false) {
			DBConnection.sql.close();
		}
		Bukkit.getServer().getLogger().info(ChatColor.DARK_GREEN + "[Guilds] Guilds has sucessfully been disabled!");
	}
}
