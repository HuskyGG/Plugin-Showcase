package com.abysspvp.staffbase.Messages;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.abysspvp.staffbase.Main;
import com.abysspvp.staffbase.Utils.Utils;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_8_R3.CommandExecute;

public class Messages extends CommandExecute implements Listener, CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (Main.plugin.getConfig().getBoolean("AlertsEnabled") == true) {
			if (!(sender instanceof Player)) {
				Utils.log(Level.WARNING, "You must be a player to use this command!");
				return true;
			}

			Player p = (Player) sender;
			if (cmd.getName().equalsIgnoreCase("alert")) {
				if (p.hasPermission("abyss.alert")) {
					if (args.length == 0) {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								" &eYou must add a message to create an Alert!"));
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));

					} else {

						for (Player online : Bukkit.getOnlinePlayers()) {
							online.sendMessage(ChatColor.translateAlternateColorCodes('&',
									Main.plugin.getConfig().getString("ServerAlertFormat")) +

									ChatColor.translateAlternateColorCodes('&', args[0]));
							return true;
						}
					}
				}
			}

			if (cmd.getName().equalsIgnoreCase("salert")) {
				if (p.hasPermission("abyss.salert")) {
					if (args.length == 0) {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								" &eYou must add a message to create a Staff Alert!"));
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));

					} else {

						for (Player online : Bukkit.getOnlinePlayers()) {
							if (p.hasPermission("something.salert")) {
								online.sendMessage(ChatColor.translateAlternateColorCodes('&',
										Main.plugin.getConfig().getString("StaffAlertFormat"))
										+ ChatColor.translateAlternateColorCodes('&', args[0]));
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}
}