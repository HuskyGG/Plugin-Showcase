package com.abysspvp.staffbase.Messages;

import java.util.logging.Level;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.abysspvp.staffbase.Main;
import com.abysspvp.staffbase.Utils.Utils;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_8_R3.CommandExecute;

public class Help extends CommandExecute implements Listener, CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (Main.plugin.getConfig().getBoolean("HelpEnabled") == true) {
			if (!(sender instanceof Player)) {
				Utils.log(Level.WARNING, "You must be a player to use this command!");
				return true;
			}

			Player p = (Player) sender;
			if (cmd.getName().equalsIgnoreCase("help")) {
				p.sendMessage(
						ChatColor.translateAlternateColorCodes('&', Main.plugin.getConfig().getString("HelpHeader")));
				p.sendMessage(
						ChatColor.translateAlternateColorCodes('&', Main.plugin.getConfig().getString("HelpCenter1")));
				p.sendMessage(
						ChatColor.translateAlternateColorCodes('&', Main.plugin.getConfig().getString("HelpCenter2")));
				p.sendMessage(
						ChatColor.translateAlternateColorCodes('&', Main.plugin.getConfig().getString("HelpCenter3")));
				p.sendMessage(
						ChatColor.translateAlternateColorCodes('&', Main.plugin.getConfig().getString("HelpCenter4")));
				p.sendMessage(
						ChatColor.translateAlternateColorCodes('&', Main.plugin.getConfig().getString("HelpCenter5")));
				p.sendMessage(
						ChatColor.translateAlternateColorCodes('&', Main.plugin.getConfig().getString("HelpFooter")));

			}
		}
		return false;
	}
}