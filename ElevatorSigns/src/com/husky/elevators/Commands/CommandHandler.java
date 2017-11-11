package com.husky.elevators.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.husky.elevators.Utils.Utils;

import net.minecraft.server.v1_8_R1.CommandExecute;

public class CommandHandler extends CommandExecute implements Listener, CommandExecutor {

	List<UUID> staff = new ArrayList<>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			Utils.log(Level.WARNING, "You must be a player to use this command!");
			return true;
		}

		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("elevator")) {
			if (p.hasPermission("abysspvp.staffmode")) {
				if (p.getLocation().getBlockY() + 1 > p.getWorld().getHighestBlockYAt(p.getLocation())) {
					p.damage(.5);
				}
			}

			return false;

		}

		return false;
	}
}