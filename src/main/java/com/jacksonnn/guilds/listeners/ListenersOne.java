package com.jacksonnn.guilds.listeners;

import com.jacksonnn.guilds.GuildsMain;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ListenersOne implements Listener {

  private GuildsMain plugin;

  public ListenersOne(GuildsMain plugin) {
    this.plugin = plugin;
  }

  @EventHandler
  public void onJoin(PlayerJoinEvent e) {
    if (!e.getPlayer().hasPlayedBefore()) {
      plugin.getGuildManager().createUser(e.getPlayer().getUniqueId());
    }
  }
}
