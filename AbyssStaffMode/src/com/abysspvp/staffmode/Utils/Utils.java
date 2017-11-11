package com.abysspvp.staffmode.Utils;

import java.util.logging.Level;

import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class Utils {

	public static void send(Player p, String msg) {
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
	}
	
	public static void log(Level level, String msg) {
		System.out.println("[AbyssPvP] " + msg);
	}
	
	
}
