package com.jacksonnn.guilds.storage;

public enum SqlQueries {
  CREATE_GUILDS("CREATE TABLE IF NOT EXISTS `guilds` ("
      + "`id` INT NOT NULL AUTO_INCREMENT,"
      + "`leader` TEXT NOT NULL,"
      + "`claimed` TEXT,"
      + "`balance` INT NOT NULL,"
      + "`mods` TEXT,"
      + "`allies` TEXT,"
      + "`name` TEXT NOT NULL,"
      + "PRIMARY KEY (`id`)"
      + ");", "CREATE TABLE IF NOT EXISTS guilds ("
      + "id integer PRIMARY KEY AUTOINCREMENT,"
      + "leader text,"
      + "claimed text,"
      + "balance integer,"
      + "mods text,"
      + "allies text,"
      + "name text"
      + ");"),

  CREATE_USERS("CREATE TABLE IF NOT EXISTS `users` ("
      + "`id` INT NOT NULL AUTO_INCREMENT,"
      + "`uuid` TEXT NOT NULL,"
      + "`guild` TEXT,"
      + "`previous_guilds` TEXT,"
      + "`rank` TEXT,"
      + "PRIMARY KEY (`id`)"
      + ");", "CREATE TABLE IF NOT EXISTS users ("
      + "id integer PRIMARY KEY AUTOINCREMENT,"
      + "uuid text,"
      + "guild text,"
      + "previous_guilds text,"
      + "rank text"
      + ");"),

  CREATE_GUILD(
      "INSERT INTO `guilds` (leader, balance, name) VALUES (?,?,?)",
      "INSERT INTO guilds (leader, balance, name) VALUES (?,?,?)"),
  CREATE_USER(
      "INSERT INTO `users` (uuid) VALUES (?)",
      "INSERT INTO users (uuid) VALUES (?)"),

  SELECT_USER(
      "SELECT * FROM `users` WHERE uuid=?",
      "SELECT * FROM users WHERE uuid=?"),

  SELECT_GUILD_OWNER(
      "SELECT * FROM `guilds` WHERE leader=?",
      "SELECT * FROM guilds WHERE leader=?"),

  GET_GUILDS(
      "SELECT * FROM `guilds`",
      "SELECT * FROM guilds"),

  GET_USERS(
          "SELECT * FROM `users`",
          "SELECT * FROM users"),

  GET_GUILD_MEMBERS(
      "SELECT * FROM `users` WHERE guild=?",
      "SELECT * FROM users WHERE guild=?"),

  ADD_USER_TO_GUILD(
          "UPDATE `users` SET guild=? WHERE uuid=?",
          "UPDATE users SET guild=? WHERE uuid=?");

  private String mysqlQuery;
  private String sqliteQuery;

  SqlQueries(String mysqlQuery, String sqliteQuery) {
    this.mysqlQuery = mysqlQuery;
    this.sqliteQuery = sqliteQuery;
  }


  public String getMysqlQuery() {
    return mysqlQuery;
  }

  public String getSqliteQuery() {
    return sqliteQuery;
  }
}
