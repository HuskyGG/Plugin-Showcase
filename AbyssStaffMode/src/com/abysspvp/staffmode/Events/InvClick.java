package com.abysspvp.staffmode.Events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InvClick implements Listener {

	@EventHandler
	public void InvClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		Inventory open = event.getClickedInventory();
		ItemStack item = event.getCurrentItem();

		Player recieving = Bukkit.getPlayer(ChatColor
				.stripColor(event.getInventory().getItem(4).getItemMeta().getDisplayName().replace("Viewing ", "")));
		if (open.getName().equals(ChatColor.GREEN + "Ban Selection Reasons")) {

			event.setCancelled(true);

			if (item == null || !item.hasItemMeta()) {
				return;
			}

			if (item.getItemMeta().getDisplayName()
					.equals(ChatColor.translateAlternateColorCodes('&', "&d&lMalicious Hacks"))) {
				player.closeInventory();
				player.performCommand("ban " + recieving.getName() + " &d&lMalicious Hacks -s");
			} else {
				if (item.getItemMeta().getDisplayName()
						.equals(ChatColor.translateAlternateColorCodes('&', "&d&lMovement Hacks"))) {
					player.closeInventory();
					player.performCommand("ban " + recieving.getName() + " &d&lMovement Hacks -s");
				} else {
					if (item.getItemMeta().getDisplayName()
							.equals(ChatColor.translateAlternateColorCodes('&', "&d&lBug Exploiting"))) {
						player.closeInventory();
						player.performCommand("tempban " + recieving.getName() + " 30d &d&lBug Exploiting -s");
					} else {
						if (item.getItemMeta().getDisplayName()
								.equals(ChatColor.translateAlternateColorCodes('&', "&d&lXray Hacks"))) {
							player.closeInventory();
							player.performCommand("tempban " + recieving.getName() + " 31d &d&lBug Exploiting");
						}
					}
				}
			}
		}
	}
}