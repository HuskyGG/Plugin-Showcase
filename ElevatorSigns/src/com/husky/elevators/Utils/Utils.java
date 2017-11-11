package com.husky.elevators.Utils;

import java.util.logging.Level;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Utils implements Listener {

	public static void send(Player p, String msg) {
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
	}

	public static void log(Level level, String msg) {
		System.out.println("[Elevators] " + msg);
	}

}
