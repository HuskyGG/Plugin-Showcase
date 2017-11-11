package com.abysspvp.staffmode.Events;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.abysspvp.staffmode.Utils.Utils;

public class EventClass implements Listener {

	List<UUID> staff = new ArrayList<>();

	@EventHandler
	public void rightclick(PlayerInteractEvent event) {
		Player p = event.getPlayer();

		ItemStack fb = new ItemStack(Material.STICK, 1);
		ItemMeta fbmeta = p.getItemInHand().getItemMeta();
		if (fbmeta.hasDisplayName()) {
			if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if (p.getInventory().getItemInHand().getType() == Material.STICK && fbmeta.getDisplayName()
						.equals(ChatColor.translateAlternateColorCodes('&', "&d&lFire Ball"))) {
					if (p.hasPermission("abyssstaffmode.fb")) {
						p.getLocation().getDirection().normalize().multiply(1);
						p.launchProjectile(Fireball.class);
						p.playSound(p.getLocation(), Sound.EXPLODE, 5, 1);
						Utils.send(p, "Boom");
					} else {
						Utils.send(p, "");
						Utils.send(p, "&e&lYou do not have permission to fireball!");
						Utils.send(p, "");
					}
				}

				ItemStack showp = new ItemStack(Material.MAGMA_CREAM, 1);
				ItemMeta showpmeta = p.getItemInHand().getItemMeta();
				if (showpmeta.hasDisplayName()) {
					if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
						if (p.getInventory().getItemInHand().getType() == Material.MAGMA_CREAM
								&& showpmeta.getDisplayName()
										.equals(ChatColor.translateAlternateColorCodes('&', "&d&lShow Reports"))) {

							if (p.hasPermission("abyssstaffmode.basic")) {
								p.playSound(p.getLocation(), Sound.ANVIL_USE, 5, 2);
								Utils.send(p, " ");
								Utils.send(p, " &eReports Opened");
								Utils.send(p, " ");
								p.performCommand("reports");

							} else {
								Utils.send(p, "");
								Utils.send(p, "&e&lYou do not have permission to use this!");
								Utils.send(p, "");
							}
						}

						ItemStack disable = p.getItemInHand();
						ItemMeta disablemeta = p.getItemInHand().getItemMeta();
						if (disablemeta.hasDisplayName()) {
							if (event.getAction() == Action.RIGHT_CLICK_BLOCK
									|| event.getAction() == Action.RIGHT_CLICK_AIR) {
								if (disable.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Vanish")) {

									if (p.hasPermission("abyssstaffmode.basic")) {
										p.playSound(p.getLocation(), Sound.NOTE_PLING, 5, 2);
										Utils.send(p, " ");
										Utils.send(p, " &eYou are now vanished");
										Utils.send(p, " ");
										p.performCommand("vanish");

									} else {
										Utils.send(p, "");
										Utils.send(p, "&e&lYou do not have permission to use this!");
										Utils.send(p, "");
									}
								}

								ItemStack randomtp = new ItemStack(Material.BLAZE_ROD, 1);
								ItemMeta randomtpmeta = p.getItemInHand().getItemMeta();
								if (randomtpmeta.hasDisplayName()) {
									if (event.getAction() == Action.RIGHT_CLICK_AIR
											|| event.getAction() == Action.RIGHT_CLICK_BLOCK) {
										if (p.getInventory().getItemInHand().getType() == Material.BLAZE_ROD
												&& randomtpmeta.getDisplayName().equals(ChatColor
														.translateAlternateColorCodes('&', "&d&lRandom Player"))) {
											if (p.hasPermission("abyssstaffmode.basic")) {
												ArrayList<Player> players = new ArrayList<Player>();
												for (Player e : Bukkit.getOnlinePlayers())
													players.add(e);
												Player randomPlayer = players.get(new Random().nextInt(players.size()));
												p.teleport(randomPlayer.getLocation());

												p.playSound(p.getLocation(), Sound.FIREWORK_BLAST, 5, 1);
												Utils.send(p, " ");
												Utils.send(p, " &eTeleported to &c&l" + randomPlayer.getName());
												Utils.send(p, " ");

											} else {
												Utils.send(p, "");
												Utils.send(p, "&e&lYou do not have permission to use this!");
												Utils.send(p, "");
											}
										}

									}
								}
							}
						}
					}
				}
			}
		}
	}
}
