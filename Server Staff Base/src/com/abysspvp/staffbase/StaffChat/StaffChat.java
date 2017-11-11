package com.abysspvp.staffbase.StaffChat;

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

public class StaffChat extends CommandExecute implements Listener, CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (Main.plugin.getConfig().getBoolean("StaffchatEnabled") == true) {
			if (!(sender instanceof Player)) {
				Utils.log(Level.WARNING, "You must be a player to use this command!");
				return true;
			}

			Player p = (Player) sender;
			String string = Main.plugin.getConfig().getString("StaffChatFormat").replace("%player%", p.getName());
			if (cmd.getName().equalsIgnoreCase("StaffChat")) {
				if (p.hasPermission("abyss.staffchat")) {
					if (args.length == 0) {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								" &eYou must be a staff member to use this command!"));
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));

					} else {
						if (p.hasPermission("something.staffchatuse")) {
							for (Player staff : Bukkit.getOnlinePlayers()) {
								staff.sendMessage(ChatColor.translateAlternateColorCodes('&', string + " " + args[0]));
							}
						}

					}
				}
			}
		}
		return false;
	}
}