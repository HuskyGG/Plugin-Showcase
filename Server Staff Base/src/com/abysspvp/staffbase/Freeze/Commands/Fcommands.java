package com.abysspvp.staffbase.Freeze.Commands;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
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

public class Fcommands extends CommandExecute implements Listener, CommandExecutor {
	// Map<UUID, UUID> frozen = new WeakHashMap<>();
	Set<UUID> frozen = new HashSet<>();

	public Set<UUID> getFrozen() {
		return frozen;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (Main.plugin.getConfig().getBoolean("FreezeEnabled") == true) {
			if (!(sender instanceof Player)) {
				Utils.log(Level.WARNING, "You must be a player to use this command!");
				return true;
			}

			Player p = (Player) sender;
			Player freeze = Bukkit.getPlayer(args[0]);
			String string2 = Main.plugin.getConfig().getString("FreezePlayerMessage").replace("%player%",
					freeze.getName());
			String string1 = Main.plugin.getConfig().getString("UnFreezePlayerMessage").replace("%player%",
					freeze.getName());
			if (cmd.getName().equalsIgnoreCase("ss")) {
				if (p.hasPermission("abyss.freeze")) {
					if (!frozen.contains(freeze.getUniqueId())) {
						frozen.add(freeze.getUniqueId());
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', string2));
						p.sendMessage(ChatColor.translateAlternateColorCodes('&',
								Main.plugin.getConfig().getString("FreezePlayerMessage")));
						freeze.sendMessage(ChatColor.translateAlternateColorCodes('&',
								Main.plugin.getConfig().getString("FrozenHeader")));
						freeze.sendMessage(ChatColor.translateAlternateColorCodes('&',
								Main.plugin.getConfig().getString("FrozenLine1")));
						freeze.sendMessage(ChatColor.translateAlternateColorCodes('&',
								Main.plugin.getConfig().getString("FrozenLine2")));
						freeze.sendMessage(ChatColor.translateAlternateColorCodes('&',
								Main.plugin.getConfig().getString("FrozenFooter")));
						System.out.println(frozen);
					} else if (frozen.contains(freeze.getUniqueId())) {
						frozen.remove(freeze.getUniqueId());
						freeze.sendMessage(ChatColor.translateAlternateColorCodes('&', "&eYou have been unfrozen!"));
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', string1));
					}
				}
			}
		}
		return false;
	}
}
