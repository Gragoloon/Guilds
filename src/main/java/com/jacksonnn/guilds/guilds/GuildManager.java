package com.jacksonnn.guilds.guilds;

import com.jacksonnn.guilds.GuildsMain;
import com.jacksonnn.guilds.storage.Mysql;
import com.jacksonnn.guilds.storage.SqlLite;
import com.jacksonnn.guilds.storage.SqlQueries;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GuildManager {

  private GuildsMain guildsMain;
  List<String> guilds = new ArrayList<>();

  public GuildManager(GuildsMain guildsMain) {
    this.guildsMain = guildsMain;
  }

  public void createGuild(UUID guildLeader, String name) {
    String query;
    if (guildsMain.getDatabaseManager().getDatabase() instanceof SqlLite) {
      query = SqlQueries.CREATE_GUILD.getSqliteQuery();
    } else {
      query = SqlQueries.CREATE_GUILD.getMysqlQuery();
    }
    try {
      PreparedStatement preparedStatement = guildsMain.getDatabaseManager().getDatabase()
          .getConnection().prepareStatement(query);
      preparedStatement.setString(1, guildLeader.toString());
      preparedStatement.setInt(2, guildsMain.getConfigManager().getDefaultConfig().get()
          .getInt("GuildsMain.StarterOptions.startingCoin"));
      preparedStatement.setString(3, name);
      preparedStatement.execute();
      preparedStatement.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void createUser(UUID createUser) {
    String query;
    if (guildsMain.getDatabaseManager().getDatabase() instanceof SqlLite) {
      query = SqlQueries.CREATE_USER.getSqliteQuery();
    } else {
      query = SqlQueries.CREATE_USER.getMysqlQuery();
    }
    try {
      PreparedStatement preparedStatement = guildsMain.getDatabaseManager().getDatabase()
          .getConnection().prepareStatement(query);
      preparedStatement.setString(1, createUser.toString());
      preparedStatement.execute();
      preparedStatement.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public boolean hasGuild(UUID uniqueId) {

    String query;
    if (guildsMain.getDatabaseManager().getDatabase() instanceof SqlLite) {
      query = SqlQueries.SELECT_GUILD_OWNER.getSqliteQuery();
    } else {
      query = SqlQueries.SELECT_GUILD_OWNER.getMysqlQuery();
    }
    boolean ret = false;

    try {
      PreparedStatement preparedStatement = guildsMain.getDatabaseManager().getDatabase()
          .getConnection().prepareStatement(query);
      preparedStatement.setString(1, uniqueId.toString());
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.isClosed()) {
        return false;
      }
      while (resultSet.next()) {
        ret = true;
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }

    return ret;
  }

  public boolean hasUser(UUID uniqueId) {

    String query;
    if (guildsMain.getDatabaseManager().getDatabase() instanceof Mysql) {
      query = SqlQueries.SELECT_USER.getMysqlQuery();
    } else {
      query = SqlQueries.SELECT_USER.getSqliteQuery();
    }
    boolean ret = false;

    try {
      PreparedStatement preparedStatement = guildsMain.getDatabaseManager().getDatabase()
          .getConnection().prepareStatement(query);
      preparedStatement.setString(1, uniqueId.toString());
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.isClosed()) {
        return false;
      }
      while (resultSet.next()) {
        ret = true;
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }

    return ret;
  }

  public List<String> getGuilds() {
    String query;
    if (guildsMain.getDatabaseManager().getDatabase() instanceof Mysql) {
      query = SqlQueries.GET_GUILDS.getMysqlQuery();
    } else {
      query = SqlQueries.GET_GUILDS.getSqliteQuery();
    }
    boolean ret = false;
    try {
      PreparedStatement preparedStatement = guildsMain.getDatabaseManager().getDatabase().getConnection().prepareStatement(query);
      ResultSet getGuilds = preparedStatement.executeQuery();


      while (getGuilds.next()) {
        guilds.add(getGuilds.getString("name"));
        return guilds;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return guilds;
  }
}
