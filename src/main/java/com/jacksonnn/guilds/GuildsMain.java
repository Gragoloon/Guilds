package com.jacksonnn.guilds;

import com.jacksonnn.guilds.commands.GuildsCommand;
import com.jacksonnn.guilds.configuration.ConfigManager;
import com.jacksonnn.guilds.guilds.GuildManager;
import com.jacksonnn.guilds.storage.DatabaseManager;
import com.jacksonnn.guilds.storage.Mysql;
import com.jacksonnn.guilds.storage.SqlQueries;
import java.sql.SQLException;
import org.bukkit.plugin.java.JavaPlugin;

public class GuildsMain extends JavaPlugin {

  private DatabaseManager databaseManager;
  private ConfigManager configManager;
  private GuildManager guildManager;

  public void onEnable() {
    configManager = new ConfigManager(this);

    databaseManager = new DatabaseManager(this);
    try {
      databaseManager.init();
    } catch (SQLException e) {
      e.printStackTrace();
      getServer().getPluginManager().disablePlugin(this);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
      getServer().getPluginManager().disablePlugin(this);
    }
    try {
      installDatabase();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    GuildsCommand guildsCommand = new GuildsCommand(this);
    getCommand("guilds").setExecutor(guildsCommand);
    getCommand("guilds").setTabCompleter(guildsCommand);
  }

  private void installDatabase() throws SQLException {
    if (databaseManager.getDatabase() instanceof Mysql) {
      databaseManager.getDatabase().getConnection().createStatement()
          .execute(SqlQueries.CREATE_GUILDS.getMysqlQuery());
      databaseManager.getDatabase().getConnection().createStatement()
          .execute(SqlQueries.CREATE_USERS.getMysqlQuery());
    } else {
      databaseManager.getDatabase().getConnection().createStatement()
          .execute(SqlQueries.CREATE_GUILDS.getSqliteQuery());
      databaseManager.getDatabase().getConnection().createStatement()
          .execute(SqlQueries.CREATE_USERS.getSqliteQuery());
    }

  }

  public void onDisable() {

  }

  public DatabaseManager getDatabaseManager() {
    return databaseManager;
  }

  public ConfigManager getConfigManager() {
    return configManager;
  }

  public GuildManager getGuildManager() {
    return guildManager;
  }
}
