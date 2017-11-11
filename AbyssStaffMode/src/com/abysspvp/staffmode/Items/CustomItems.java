package com.abysspvp.staffmode.Items;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class CustomItems implements Listener {

	public void giveItems(Player player) {
		ItemStack staff = new ItemStack(Material.BOOK, 1);
		ItemMeta staffmeta = staff.getItemMeta();
		staffmeta.setDisplayName((ChatColor.translateAlternateColorCodes('&', "&d&lPlayer History")));
		ArrayList<String> staff1 = new ArrayList<String>();
		staff1.add(ChatColor.translateAlternateColorCodes('&',
				"&7RIGHT CLICK: &eto see the player you clickeds punishment history!"));
		staffmeta.setLore(staff1);
		staff.setItemMeta(staffmeta);

		ItemStack randomtp = new ItemStack(Material.BLAZE_ROD, 1);
		ItemMeta randomtpmeta = randomtp.getItemMeta();
		randomtpmeta.setDisplayName((ChatColor.translateAlternateColorCodes('&', "&d&lRandom Player")));
		ArrayList<String> randomtp1 = new ArrayList<String>();
		randomtp1.add(ChatColor.translateAlternateColorCodes('&',
				"&7RIGHT CLICK: &eto teleport to a random player on the server!"));
		randomtpmeta.setLore(randomtp1);
		randomtp.setItemMeta(randomtpmeta);

		ItemStack showp = new ItemStack(Material.MAGMA_CREAM, 1);
		ItemMeta showpmeta = showp.getItemMeta();
		showpmeta.setDisplayName((ChatColor.translateAlternateColorCodes('&', "&d&lShow Reports")));
		ArrayList<String> showp1 = new ArrayList<String>();
		showp1.add(ChatColor.translateAlternateColorCodes('&', "&7RIGHT CLICK: &eto show the current active reports!"));
		showpmeta.setLore(showp1);
		showp.setItemMeta(showpmeta);

		ItemStack enable = new ItemStack(Material.INK_SACK, 1, (short) 10);
		ItemMeta enableMeta = (ItemMeta) enable.getItemMeta();
		enableMeta.setDisplayName(ChatColor.GREEN + "Players: Enable");
		List<String> enableList = new ArrayList<String>();
		enableList.add(ChatColor.WHITE + "Right click disable player visability");
		enableMeta.setLore(enableList);
		enable.setItemMeta(enableMeta);

		ItemStack disable = new ItemStack(Material.INK_SACK, 1, (short) 10);
		;
		ItemMeta disableMeta = (ItemMeta) disable.getItemMeta();
		disableMeta.setDisplayName(ChatColor.RED + "Vanish");
		List<String> disableList = new ArrayList<String>();
		disableList.add(ChatColor.WHITE + "Right click to enable player visability");
		disableMeta.setLore(disableList);
		disable.setItemMeta(disableMeta);

		ItemStack ban = new ItemStack(Material.LEASH, 1);
		ItemMeta banmeta = ban.getItemMeta();
		banmeta.setDisplayName((ChatColor.translateAlternateColorCodes('&', "&d&lBan Player")));
		ArrayList<String> ban1 = new ArrayList<String>();
		ban1.add(ChatColor.translateAlternateColorCodes('&',
				"&7RIGHT CLICK: &eon a player you are looking at to ban them!"));
		banmeta.setLore(ban1);
		ban.setItemMeta(banmeta);

		ItemStack sword = new ItemStack(Material.IRON_SWORD, 1);
		ItemMeta swordmeta = sword.getItemMeta();
		swordmeta.setDisplayName((ChatColor.translateAlternateColorCodes('&', "&d&lSmite Player")));
		ArrayList<String> sword1 = new ArrayList<String>();
		sword1.add(ChatColor.translateAlternateColorCodes('&',
				"&7RIGHT CLICK: &eon a player you are looking at to ban them!"));
		swordmeta.setLore(sword1);
		sword.setItemMeta(swordmeta);

		ItemStack fb = new ItemStack(Material.STICK, 1);
		ItemMeta fbmeta = fb.getItemMeta();
		fbmeta.setDisplayName((ChatColor.translateAlternateColorCodes('&', "&d&lFire Ball")));
		ArrayList<String> fb1 = new ArrayList<String>();
		fb1.add(ChatColor.translateAlternateColorCodes('&', "&7RIGHT CLICK: &eto fire a fireball!"));
		fbmeta.setLore(fb1);
		fb.setItemMeta(fbmeta);

		player.getInventory().setItem(8, staff);
		player.getInventory().setItem(7, fb);
		player.getInventory().setItem(6, disable);
		player.getInventory().setItem(4, ban);
		player.getInventory().setItem(1, randomtp);
		player.getInventory().setItem(0, showp);

	}
}
