package husky.abysspvp.hub;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class CustomItems implements Listener {
	
	public void giveItems(Player player) {
		ItemStack item = new ItemStack(Material.SKULL_ITEM, 1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.RED + "Something");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.WHITE + "Something");
		lore.add(ChatColor.WHITE + "Something");
		lore.add(ChatColor.WHITE + "Something");
		lore.add(ChatColor.WHITE + "Something");
		lore.add(ChatColor.WHITE + "Something");
		meta.setLore(lore);
		item.setItemMeta(meta);
		
		player.getInventory().addItem(item);
	
	}
	
	

}
