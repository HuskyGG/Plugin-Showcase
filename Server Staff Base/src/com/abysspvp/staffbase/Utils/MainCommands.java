package com.abysspvp.staffbase.Utils;

import java.util.logging.Level;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.abysspvp.staffbase.Main;

import net.minecraft.server.v1_8_R3.CommandExecute;

public class MainCommands extends CommandExecute implements Listener, CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			Utils.log(Level.WARNING, "You must be a player to use this command!");
			return true;
		}

		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("StaffbaseReload")) {
			if (p.hasPermission("abyss.staffbasereload")) {
				Main.plugin.saveDefaultConfig();
				Main.plugin.reloadConfig();
				p.sendMessage("Config Reloaded Brad");
			}
		}

		return false;
	}
}