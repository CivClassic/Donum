package com.github.civcraft.donum.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import vg.civcraft.mc.civmodcore.itemHandling.ItemMap;

import com.github.civcraft.donum.Donum;

public class PlayerListener implements Listener {

	@EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = true)
	public void playerJoin(PlayerJoinEvent e) {
		System.out.println("Listener called");
		Donum.getManager().loadPlayerData(e.getPlayer().getUniqueId(), e.getPlayer().getInventory());
	}

	@EventHandler
	public void playerQuit(PlayerQuitEvent e) {
		System.out.println("Listener called");
		Donum.getManager().savePlayerData(e.getPlayer().getUniqueId(), e.getPlayer().getInventory());
	}
	
	@EventHandler
	public void playerWasStupid(PlayerDeathEvent e) {
		System.out.println("Listener called");
		Donum.getManager().saveDeathInventory(e.getEntity().getUniqueId(), new ItemMap(e.getDrops()));
	}
}
