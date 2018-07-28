package com.jacksonnn.guilds.storage;

public enum SqlQueries {
  CREATE_GUILDS("CREATE TABLE `guilds` ("
      + "`id` INT NOT NULL AUTO_INCREMENT,"
      + "`leader` TEXT NOT NULL,"
      + "`claimed` TEXT NOT NULL,"
      + "`members` TEXT NOT NULL,"
      + "`balance` INT NOT NULL,"
      + "`mods` TEXT NOT NULL,"
      + "`alies` TEXT NOT NULL,"
      + "`name` TEXT NOT NULL,"
      + "PRIMARY KEY (`id`)"
      + ");", "CREATE TABLE guilds ("
      + "id integer PRIMARY KEY AUTOINCREMENT,"
      + "leader text,"
      + "claimed text,"
      + "members text,"
      + "balance integer,"
      + "mods text,"
      + "alies text,"
      + "name text"
      + ");"),

  CREATE_USERS("CREATE TABLE `users` ("
      + "`id` INT NOT NULL AUTO_INCREMENT,"
      + "`uuid` TEXT NOT NULL,"
      + "`current_guild` TEXT NOT NULL,"
      + "`guilds_previous` TEXT NOT NULL,"
      + "`rank` TEXT NOT NULL,"
      + "PRIMARY KEY (`id`)"
      + ");", "CREATE TABLE users ("
      + "id integer PRIMARY KEY AUTOINCREMENT,"
      + "uuid text,"
      + "current_guild text,"
      + "guilds_previous text,"
      + "rank text"
      + ");");


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
