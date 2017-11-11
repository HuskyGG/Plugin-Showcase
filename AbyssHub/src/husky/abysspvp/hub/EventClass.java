package husky.abysspvp.hub;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import husky.abysspvp.hub.CustomItems;

public class EventClass implements Listener {
	
	private CustomItems ci = new CustomItems();
	
	@EventHandler
	public void toggle(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		
        ItemStack item = new ItemStack(Material.SKULL_ITEM, 1);
        ItemMeta meta = player.getItemInHand().getItemMeta();
        if(meta.hasDisplayName()){
            if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
                if(player.getInventory().getItemInHand().getType() == Material.SKULL_ITEM && meta.getDisplayName().equals(ChatColor.RED + "Something")){
                 
                    Bukkit.broadcastMessage(ChatColor.GOLD + player.getName() + " Just got dicked");             

               
                    
                    if(item.getAmount() > 1)
                        item.setAmount(item.getAmount() - 1);
                    else player.setItemInHand(null);      
                }
            }
            }
          }
   
   
	}

