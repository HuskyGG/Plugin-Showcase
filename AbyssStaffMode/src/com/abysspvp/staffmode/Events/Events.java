package com.abysspvp.staffmode.Events;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Events implements Listener {

	List<UUID> staff = new ArrayList<>();

	@EventHandler
	public void onPlayerPickup(PlayerPickupItemEvent e) {
		Player player = e.getPlayer();
		if (!staff.contains(player.getUniqueId())) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onPlayerInteract(InventoryClickEvent e) {
		Player player = null;
		if (e.getWhoClicked() instanceof Player)
			player = (Player) e.getWhoClicked();
		if (!staff.contains(player.getUniqueId())) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onPlayerDrop(PlayerDropItemEvent e) {
		Player player = e.getPlayer();
		if (!staff.contains(player.getUniqueId())) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		if (!staff.contains(player.getUniqueId())) {
			staff.remove(player.getUniqueId());
			player.getInventory().clear();
		}
	}

	@EventHandler
	public void onBandageUse(PlayerInteractEntityEvent e) {
		Player player = e.getPlayer();
		Player clicked = (Player) e.getRightClicked();
		if (!(clicked instanceof Player))
			return;
		if (player.getItemInHand().getType().equals(Material.LEASH) && player.getItemInHand().getItemMeta()
				.getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', "&d&lBan Player"))) {
			clicked.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 2000, 100));
			clicked.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 2000, 100));
			clicked.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 2000, -1));
			player.performCommand("smb " + clicked.getName());

		}

	}

	@EventHandler
	public void onHistoryUse(PlayerInteractEntityEvent e) {
		Player player = e.getPlayer();
		Player clicked = (Player) e.getRightClicked();
		if (!(clicked instanceof Player))
			return;
		if (player.getItemInHand().getType().equals(Material.BOOK) && player.getItemInHand().getItemMeta()
				.getDisplayName().equals(ChatColor.translateAlternateColorCodes('&', "&d&lPlayer History"))) {
			player.performCommand("history " + clicked.getName());
			player.playSound(player.getLocation(), Sound.ANVIL_USE, 5, 2);

		}

	}

}
