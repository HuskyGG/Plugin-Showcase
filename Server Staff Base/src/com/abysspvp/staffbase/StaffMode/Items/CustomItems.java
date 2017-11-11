package com.abysspvp.staffbase.StaffMode.Items;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.abysspvp.staffbase.Main;

import net.md_5.bungee.api.ChatColor;

public class CustomItems implements Listener {

	public void giveItems(Player player) {

		ItemStack staff = new ItemStack(Material.BOOK, 1);
		ItemMeta staffmeta = staff.getItemMeta();
		staffmeta.setDisplayName(
				(ChatColor.translateAlternateColorCodes('&', Main.plugin.getConfig().getString("PlayerHistory"))));
		ArrayList<String> staff1 = new ArrayList<String>();
		staff1.add(ChatColor.translateAlternateColorCodes('&',
				"&7&lRIGHT CLICK: &7to see the player you clickeds punishment history!"));
		staffmeta.setLore(staff1);
		staff.setItemMeta(staffmeta);

		ItemStack randomtp = new ItemStack(Material.BLAZE_ROD, 1);
		ItemMeta randomtpmeta = randomtp.getItemMeta();
		randomtpmeta.setDisplayName(
				(ChatColor.translateAlternateColorCodes('&', Main.plugin.getConfig().getString("RandomPlayer"))));
		ArrayList<String> randomtp1 = new ArrayList<String>();
		randomtp1.add(ChatColor.translateAlternateColorCodes('&',
				"&7&lRIGHT CLICK: &7to teleport to a random player on the server!"));
		randomtpmeta.setLore(randomtp1);
		randomtp.setItemMeta(randomtpmeta);

		ItemStack showp = new ItemStack(Material.MAGMA_CREAM, 1);
		ItemMeta showpmeta = showp.getItemMeta();
		showpmeta.setDisplayName(
				(ChatColor.translateAlternateColorCodes('&', Main.plugin.getConfig().getString("ShowReports"))));
		ArrayList<String> showp1 = new ArrayList<String>();
		showp1.add(
				ChatColor.translateAlternateColorCodes('&', "&7&lRIGHT CLICK: &7to show the current active reports!"));
		showpmeta.setLore(showp1);
		showp.setItemMeta(showpmeta);

		ItemStack disable = new ItemStack(Material.INK_SACK, 1, (short) 10);
		;
		ItemMeta disableMeta = (ItemMeta) disable.getItemMeta();
		disableMeta.setDisplayName(
				ChatColor.translateAlternateColorCodes('&', Main.plugin.getConfig().getString("VanishToggle")));
		List<String> disableList = new ArrayList<String>();
		disableList.add(ChatColor.WHITE + "&7&lRIGHT CLICK: &7to enable player visability");
		disableMeta.setLore(disableList);
		disable.setItemMeta(disableMeta);

		ItemStack ban = new ItemStack(Material.ICE, 1);
		ItemMeta banmeta = ban.getItemMeta();
		banmeta.setDisplayName(
				(ChatColor.translateAlternateColorCodes('&', Main.plugin.getConfig().getString("FreezePlayer"))));
		ArrayList<String> ban1 = new ArrayList<String>();
		ban1.add(ChatColor.translateAlternateColorCodes('&',
				"&7&lRIGHT CLICK: &7on a player you are looking at to freeze them!"));
		banmeta.setLore(ban1);
		ban.setItemMeta(banmeta);

		ItemStack fb = new ItemStack(Material.STICK, 1);
		ItemMeta fbmeta = fb.getItemMeta();
		fbmeta.setDisplayName(
				(ChatColor.translateAlternateColorCodes('&', Main.plugin.getConfig().getString("FireBall"))));
		ArrayList<String> fb1 = new ArrayList<String>();
		fb1.add(ChatColor.translateAlternateColorCodes('&', "&7&lRIGHT CLICK: &7to fire a fireball!"));
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
