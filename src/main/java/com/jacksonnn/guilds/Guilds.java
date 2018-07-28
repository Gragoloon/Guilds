package com.jacksonnn.guilds;

import com.jacksonnn.guilds.storage.DatabaseManager;
import java.sql.SQLException;
import org.bukkit.plugin.java.JavaPlugin;

public class Guilds extends JavaPlugin {

  public DatabaseManager databaseManager;

  public void onEnable() {
    try {
      databaseManager.init();
    } catch (SQLException e) {
      e.printStackTrace();
      getServer().getPluginManager().disablePlugin(this);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
      getServer().getPluginManager().disablePlugin(this);
    }
    installDatabase();
    saveDefaultConfig();
  }

  private void installDatabase() {
    //
  }

  public void onDisable() {

  }
}
