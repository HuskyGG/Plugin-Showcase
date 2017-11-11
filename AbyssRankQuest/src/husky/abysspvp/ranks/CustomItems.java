package husky.abysspvp.ranks;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class CustomItems implements Listener {
	
	public void giveItems(Player player) {
		ItemStack item = new ItemStack(Material.MAGMA_CREAM, 1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.RED + "{Rank} | Rank Key");
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GRAY  + "to comeplete "
				+ "the rank quest. ");
		lore.add(ChatColor.GRAY + "Apon completion you will recive a voucher for this rank");
		lore.add(ChatColor.GRAY + "You can then right click to redeem it to your account!");
		lore.add(ChatColor.WHITE + " ");
		meta.setLore(lore);
		item.setItemMeta(meta);
		
		player.getInventory().addItem(item);
	
	}
	
	

}
