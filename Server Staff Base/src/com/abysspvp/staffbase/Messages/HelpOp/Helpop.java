package com.abysspvp.staffbase.Messages.HelpOp;

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

public class Helpop extends CommandExecute implements Listener, CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (Main.plugin.getConfig().getBoolean("FreezeEnabled") == true) {
			if (!(sender instanceof Player)) {
				Utils.log(Level.WARNING, "You must be a player to use this command!");
				return true;
			}

			Player p = (Player) sender;
			if (cmd.getName().equalsIgnoreCase("Helpop")) {
				if (args.length == 0) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', " &eUsage: Helpop <QUESTION>"));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));

				} else {
					p.sendMessage("Staff have recieved the help question!");
					for (Player staff : Bukkit.getOnlinePlayers()) {
						if (staff.hasPermission("abyss.helpopop")) {
							staff.sendMessage(ChatColor.translateAlternateColorCodes('&',
									"&8&l[&c&lHelpOP&8&l]" + " &a&l" + p.getName() + " &8&l:" + " &f" + args[0]));
						}
					}
				}
			}

		}
		return false;
	}
}