package com.abysspvp.staffbase.Freeze.Events;

import java.util.Set;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.abysspvp.staffbase.Main;
import com.abysspvp.staffbase.Freeze.Commands.Fcommands;

import net.md_5.bungee.api.ChatColor;

public class FreezeEvent implements Listener {
	private Main plugin;

	public FreezeEvent(Main plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onPlayerDrop(PlayerDropItemEvent e) {
		Player p = e.getPlayer();
		Fcommands fcommands = plugin.getFcommands();
		//
		Set<UUID> frozen = fcommands.getFrozen();
		if (frozen.contains(p.getUniqueId())) {
			p.sendMessage(
					ChatColor.translateAlternateColorCodes('&', Main.plugin.getConfig().getString("FrozenHeader")));
			e.getPlayer().sendMessage(
					ChatColor.translateAlternateColorCodes('&', Main.plugin.getConfig().getString("FrozenLine1")));
			e.getPlayer().sendMessage(
					ChatColor.translateAlternateColorCodes('&', Main.plugin.getConfig().getString("FrozenLine2")));
			e.getPlayer().sendMessage(
					ChatColor.translateAlternateColorCodes('&', Main.plugin.getConfig().getString("FrozenFooter")));
			e.setCancelled(true);

		}
	}

	@EventHandler
	public void onPlayerCommand(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		Fcommands fcommands = plugin.getFcommands();
		//
		Set<UUID> frozen = fcommands.getFrozen();
		if (frozen.contains(p.getUniqueId())) {
		}
	}

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		Fcommands fcommands = plugin.getFcommands();
		//
		Set<UUID> frozen = fcommands.getFrozen();
		if (frozen.contains(p.getUniqueId())) {
			frozen.remove(p.getUniqueId());
			for (Player online : Bukkit.getOnlinePlayers()) {
				online.sendMessage(ChatColor.translateAlternateColorCodes('&',
						Main.plugin.getConfig().getString("ServerAlertFormat")) +

						ChatColor.translateAlternateColorCodes('&', "&c&l" + p.getName()
								+ "&ehas logged out whilst frozen!\n" + "&eThey will now be banned"));
			}
		}
	}

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		Fcommands fcommands = plugin.getFcommands();
		//
		Set<UUID> frozen = fcommands.getFrozen();
		if (frozen.contains(p.getUniqueId())) {
			p.teleport(p);
			p.sendMessage(
					ChatColor.translateAlternateColorCodes('&', Main.plugin.getConfig().getString("FrozenHeader")));
			e.getPlayer().sendMessage(
					ChatColor.translateAlternateColorCodes('&', Main.plugin.getConfig().getString("FrozenLine1")));
			e.getPlayer().sendMessage(
					ChatColor.translateAlternateColorCodes('&', Main.plugin.getConfig().getString("FrozenLine2")));
			e.getPlayer().sendMessage(
					ChatColor.translateAlternateColorCodes('&', Main.plugin.getConfig().getString("FrozenFooter")));
		}
	}
}
