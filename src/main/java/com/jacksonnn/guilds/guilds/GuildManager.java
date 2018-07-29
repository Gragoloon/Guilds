package com.jacksonnn.guilds.guilds;

import com.jacksonnn.guilds.GuildsMain;
import com.jacksonnn.guilds.storage.Mysql;
import com.jacksonnn.guilds.storage.SqlQueries;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class GuildManager {

  private GuildsMain guildsMain;

  public GuildManager(GuildsMain guildsMain) {
    this.guildsMain = guildsMain;
  }

  public Guild createGuild(UUID guildLeader, String name) {
    String query;
    if (guildsMain.getDatabaseManager().getDatabase() instanceof Mysql) {
      query = SqlQueries.CREATE_GUILD.getSqliteQuery();
    } else {
      query = SqlQueries.CREATE_GUILD.getMysqlQuery();
    }
    return null;
  }

  public void createUser(UUID createUser) {
    String query;
    if (guildsMain.getDatabaseManager().getDatabase() instanceof Mysql) {
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
    if (guildsMain.getDatabaseManager().getDatabase() instanceof Mysql) {
      query = SqlQueries.SELECT_USER.getSqliteQuery();
    } else {
      query = SqlQueries.SELECT_USER.getMysqlQuery();
    }
    boolean ret;
    try {
      PreparedStatement preparedStatement = guildsMain.getDatabaseManager().getDatabase()
          .getConnection().prepareStatement(query);
      preparedStatement.setString(1, uniqueId.toString());
      preparedStatement.execute();
      if (preparedStatement.getResultSet().getString("current_guild") == null || preparedStatement
          .getResultSet().getString("current_guild").equals("")) {
        ret = false;
      } else {
        ret = true;
      }
      preparedStatement.close();
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
    try {
      PreparedStatement preparedStatement = guildsMain.getDatabaseManager().getDatabase()
          .getConnection().prepareStatement(query);
      preparedStatement.setString(1, uniqueId.toString());
      preparedStatement.execute();
      if (preparedStatement.getResultSet().getString("current_guild") == null || preparedStatement
          .getResultSet().getString("current_guild").equals("")) {
        ret = false;
      } else {
        ret = true;
      }
      preparedStatement.close();
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
    return ret;
  }
}
