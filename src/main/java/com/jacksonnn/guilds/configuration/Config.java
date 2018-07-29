package com.jacksonnn.guilds.configuration;

import java.io.File;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Config {

  private File file;
  private FileConfiguration config;

  public Config(File file) {
    this.file = file;
    this.config = YamlConfiguration.loadConfiguration(this.file);
    reload();
  }

  public void create() {
    if (!file.getParentFile().exists()) {
      try {
        file.getParentFile().mkdir();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    if (!file.exists()) {
      try {
        file.createNewFile();
      } catch (Exception e) {
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
