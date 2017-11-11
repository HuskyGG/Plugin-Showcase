package com.abysspvp.staffmode.Commands;

import java.util.ArrayList;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import com.abysspvp.staffmode.Utils.Utils;

import net.minecraft.server.v1_8_R3.CommandExecute;

public class StaffModeBan extends CommandExecute implements Listener, CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			Utils.log(Level.WARNING, "You must be a player to use this command!");
			return true;
		}

		Player p = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("smb")) {
			Player player = (Player) sender;
			if (p.hasPermission("abyssstaffmode.ban")) {
				if (args.length == 0) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));

				} else {

					Player target = Bukkit.getPlayerExact(args[0]);
					if (target == null) {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
								"&d&l* &7&lPlayer &7&l" + target + " &d&lis not online!"));
					} else {

						Player recieving = Bukkit.getPlayer(args[0]);
						Inventory i = Bukkit.getServer().createInventory(null, 27,
								ChatColor.GREEN + "Ban Selection Reasons");

						ItemStack empty = new ItemStack(Material.STAINED_GLASS_PANE, 1, DyeColor.WHITE.getData());
						ItemMeta emptyMeta = empty.getItemMeta();
						emptyMeta.setDisplayName("'");
						empty.setItemMeta(emptyMeta);

						ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
						SkullMeta meta = (SkullMeta) skull.getItemMeta();
						meta.setOwner(recieving.getName());
						meta.setDisplayName(
								ChatColor.translateAlternateColorCodes('&', "&dViewing &7" + recieving.getName()));
						ArrayList<String> lore = new ArrayList<String>();
						meta.setLore(lore);
						skull.setItemMeta(meta);

						ItemStack mal = new ItemStack(Material.POWERED_RAIL, 1);
						ItemMeta malMeta = mal.getItemMeta();
						malMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&d&lMalicious Hacks"));
						mal.setItemMeta(malMeta);

						ItemStack move = new ItemStack(Material.REDSTONE, 1);
						ItemMeta moveMeta = move.getItemMeta();
						moveMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&d&lMovement Hacks"));
						move.setItemMeta(moveMeta);

						ItemStack bug = new ItemStack(Material.SPIDER_EYE, 1);
						ItemMeta bugMeta = bug.getItemMeta();
						bugMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&d&lBug Exploiting"));
						bug.setItemMeta(bugMeta);

						ItemStack Xray = new ItemStack(Material.GRASS, 1);
						ItemMeta XrayMeta = Xray.getItemMeta();
						XrayMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&d&lXray Hacks"));
						Xray.setItemMeta(XrayMeta);

						ItemStack paper = new ItemStack(Material.PAPER, 1);
						ItemMeta paperMeta = paper.getItemMeta();
						paperMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&',
								"&d&lIf you would like to use another reason use the ingame command!"));
						paper.setItemMeta(paperMeta);

						// Row 1
						i.setItem(0, empty);
						i.setItem(1, empty);
						i.setItem(2, empty);
						i.setItem(3, empty);
						i.setItem(4, skull);
						i.setItem(5, empty);
						i.setItem(6, empty);
						i.setItem(7, empty);
						i.setItem(8, empty);

						// Row 2
						i.setItem(9, empty);
						i.setItem(12, mal);
						i.setItem(13, move);
						i.setItem(14, bug);
						i.setItem(15, Xray);
						i.setItem(16, empty);
						i.setItem(10, empty);
						i.setItem(11, paper);
						i.setItem(17, empty);

						// Row3
						i.setItem(18, empty);
						i.setItem(19, empty);
						i.setItem(20, empty);
						i.setItem(21, empty);
						i.setItem(22, empty);
						i.setItem(23, empty);
						i.setItem(24, empty);
						i.setItem(25, empty);
						i.setItem(26, empty);

						player.openInventory(i);

					}

				}
			}
			return false;
		}
		return false;
	}
}
