package com.abysspvp.staffbase.StaffMode.Commands;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Level;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import com.abysspvp.staffbase.Main;
import com.abysspvp.staffbase.StaffMode.Items.CustomItems;
import com.abysspvp.staffbase.Utils.Utils;

import net.minecraft.server.v1_8_R3.CommandExecute;

public class Staffmode extends CommandExecute implements Listener, CommandExecutor {

	Set<UUID> staff = new HashSet<>();

	public Set<UUID> getFrozen() {
		return staff;
	}

	private CustomItems ci = new CustomItems();
	public String prefix = ChatColor.translateAlternateColorCodes('&', " &2&lAbyssPvP");

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (Main.plugin.getConfig().getBoolean("StaffmodeEnabled") == true) {
			if (!(sender instanceof Player)) {
				Utils.log(Level.WARNING, "You must be a player to use this command!");
				return true;
			}

			Player p = (Player) sender;
			if (cmd.getName().equalsIgnoreCase("staffmode")) {
				if (p.hasPermission("abyss.staffmode")) {
					if (!staff.contains(p.getUniqueId())) {
						staff.add(p.getUniqueId());
						System.out.println(Main.plugin);
						Utils.send(p, prefix);
						Utils.send(p, " &eStaff Mode");
						Utils.send(p, " &2Enabled!");
						Utils.send(p, " ");
						p.performCommand("god");
						p.performCommand("fly");
						p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);
						p.getInventory().clear();
						p.getInventory().setBoots(new ItemStack(Material.AIR));
						p.getInventory().setLeggings(new ItemStack(Material.AIR));
						p.getInventory().setChestplate(new ItemStack(Material.AIR));
						p.getInventory().setHelmet(new ItemStack(Material.AIR));
						ci.giveItems(p);

					} else if (staff.contains(p.getUniqueId())) {
						staff.remove(p.getUniqueId());
						p.performCommand("god");
						p.performCommand("fly");
						Utils.send(p, " ");
						Utils.send(p, prefix);
						Utils.send(p, " &eStaff Mode");
						Utils.send(p, " &cDisabled!");
						Utils.send(p, " ");
						p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 5, 1);

						p.getInventory().clear();
					}
				}

				return false;

			}
		}

		return false;
	}

}