package com.husky.elevators.Events;

import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import com.husky.elevators.Utils.Utils;

import net.md_5.bungee.api.ChatColor;

public class Events implements Listener {

	@EventHandler
	public void onSignChange(SignChangeEvent e) {

		if (e.getLine(0).equalsIgnoreCase("[Elevator]") && e.getLine(1).equalsIgnoreCase("up")) {
			e.setLine(0, ChatColor.translateAlternateColorCodes('&', "&c[Elevator]"));
			e.setLine(1, ChatColor.translateAlternateColorCodes('&', "&3Up"));
		}

	}

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		if (!(e.getAction() == Action.RIGHT_CLICK_BLOCK))
			return;
		if (e.getClickedBlock().getState() instanceof Sign) {
			Sign s = (Sign) e.getClickedBlock().getState();
			if (s.getLine(0).equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&c[Elevator]"))) {
				if (s.getLine(1).equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&3Up")))
					e.getPlayer().performCommand("elevator");
					Utils.send(e.getPlayer(), ChatColor.translateAlternateColorCodes('&', "&eThis is working"));
			}
		}
	}
}
