package com.jacksonnn.guilds.guilds;

import com.jacksonnn.guilds.GuildsMain;
import com.jacksonnn.guilds.storage.Mysql;
import com.jacksonnn.guilds.storage.SqlLite;
import com.jacksonnn.guilds.storage.SqlQueries;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GuildManager {

  private GuildsMain guildsMain;
  List<String> guilds = new ArrayList<>();
  List<String> members = new ArrayList<>();
  List<String> players = new ArrayList<>();

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

  public List<String> getPlayers() {
    String query;
    if (guildsMain.getDatabaseManager().getDatabase() instanceof Mysql) {
      query = SqlQueries.GET_USERS.getMysqlQuery();
    } else {
      query = SqlQueries.GET_USERS.getSqliteQuery();
    }
    try {
      PreparedStatement preparedStatement = guildsMain.getDatabaseManager().getDatabase().getConnection().prepareStatement(query);
      ResultSet getPlayers = preparedStatement.executeQuery();

      while (getPlayers.next()) {
        players.add(getPlayers.getString("uuid"));
        return players;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return players;
  }

  public List<String> getGuildMembers(String guild) {
    String query;
    if (guildsMain.getDatabaseManager().getDatabase() instanceof Mysql) {
      query = SqlQueries.GET_GUILD_MEMBERS.getMysqlQuery();
    } else {
      query = SqlQueries.GET_GUILD_MEMBERS.getSqliteQuery();
    }
    try {
      PreparedStatement preparedStatement = guildsMain.getDatabaseManager().getDatabase().getConnection().prepareStatement(query);
      preparedStatement.setString(1, guild);
      ResultSet getGuildMembers = preparedStatement.executeQuery();

      while (getGuildMembers.next()) {
       members.add(getGuildMembers.getString("uuid"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return members;
  }

  public boolean isGuild(String guild) {
    List<String> guilds = getGuilds();

    if (guilds.contains(guild)) {
      return true;
    } else {
      return false;
    }
  }

  public boolean isPlayer(String player) {
    List<String> players = getPlayers();

    Player player1 = Bukkit.getPlayer(player);
    UUID uuid = player1.getUniqueId();

    if (players.contains(uuid)) {
      return true;
    } else {
      return false;
    }
  }

  public void addPlayerToGuild(String guild, String player) {
    String playerUUID = Bukkit.getPlayer(player).getUniqueId().toString();

    String query;
    if (guildsMain.getDatabaseManager().getDatabase() instanceof Mysql) {
      query = SqlQueries.ADD_USER_TO_GUILD.getMysqlQuery();
    } else {
      query = SqlQueries.ADD_USER_TO_GUILD.getSqliteQuery();
    }
    try {
      PreparedStatement preparedStatement = guildsMain.getDatabaseManager().getDatabase().getConnection().prepareStatement(query);
      preparedStatement.setString(1, guild);
      preparedStatement.setString(2, playerUUID);
      preparedStatement.execute();
      preparedStatement.close();

    } catch (SQLException e) {
      e.printStackTrace();
    }

    /*
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
     */
  }
}
