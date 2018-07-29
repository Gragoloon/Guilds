package com.jacksonnn.guilds.storage;

public enum SqlQueries {
  CREATE_GUILDS("CREATE TABLE `guilds` ("
      + "`id` INT NOT NULL AUTO_INCREMENT,"
      + "`leader` TEXT NOT NULL,"
      + "`claimed` TEXT,"
      + "`members` TEXT,"
      + "`balance` INT NOT NULL,"
      + "`mods` TEXT,"
      + "`allies` TEXT,"
      + "`name` TEXT NOT NULL,"
      + "PRIMARY KEY (`id`)"
      + ");", "CREATE TABLE guilds ("
      + "id integer PRIMARY KEY AUTOINCREMENT,"
      + "leader text,"
      + "claimed text,"
      + "members text,"
      + "balance integer,"
      + "mods text,"
      + "allies text,"
      + "name text"
      + ");"),

  CREATE_USERS("CREATE TABLE `users` ("
      + "`id` INT NOT NULL AUTO_INCREMENT,"
      + "`uuid` TEXT NOT NULL,"
      + "`current_guild` TEXT,"
      + "`guilds_previous` TEXT,"
      + "`rank` TEXT,"
      + "PRIMARY KEY (`id`)"
      + ");", "CREATE TABLE users ("
      + "id integer PRIMARY KEY AUTOINCREMENT,"
      + "uuid text,"
      + "current_guild text,"
      + "guilds_previous text,"
      + "rank text"
      + ");"),

  CREATE_GUILD(
      "INSERT INTO `guilds` (leader, balance, name) VALUES ?,?,?",
      "INSERT INTO guilds (leader, balance, name) VALUES ?,?,?"),
  CREATE_USER(
      "INSERT INTO `users` (uuid) VALUES ?",
      "INSERT INTO users (uuid) VALUES ?"),

  SELECT_USER(
      "SELECT * FROM `users` WHERE uuid=?",
      "SELECT * FROM users WHERE uuid=?");

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
