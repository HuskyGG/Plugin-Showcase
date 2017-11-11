package husky.abysspvp.ranks;

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

import husky.abysspvp.ranks.CustomItems;

public class EventClass implements Listener {
	
	public String prefix = ChatColor.translateAlternateColorCodes('&', "                      &d&l* &7&lRankQuests");
	public String divider = ChatColor.translateAlternateColorCodes('&', "&d&l*****&7&l*****&d&l*****&7&l*****&d&l*****&7&l*****&d&l*****&7&l*****&d&l*****&7&l*****");
	private CustomItems ci = new CustomItems();
	
	@EventHandler
	public void toggle(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		
        ItemStack item = new ItemStack(Material.MAGMA_CREAM, 1);
        ItemMeta meta = player.getItemInHand().getItemMeta();
        if(meta.hasDisplayName()){
            if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
                if(player.getInventory().getItemInHand().getType() == Material.MAGMA_CREAM && meta.getDisplayName().equals(ChatColor.RED + "{Rank} | Rank Quest (20s)")){
                 
                
                	Bukkit.broadcastMessage(divider);    
                    Bukkit.broadcastMessage("");  
                    Bukkit.broadcastMessage(prefix);  
                    Bukkit.broadcastMessage("");    
                    Bukkit.broadcastMessage("    " + ChatColor.RED + player.getName() + ChatColor.YELLOW + " Has just started a Rank Quest!");  
                    Bukkit.broadcastMessage("");   
                    Bukkit.broadcastMessage("    " + ChatColor.YELLOW + "Find " + ChatColor.RED + player.getName() + ChatColor.YELLOW  + " in the warzone to take that rank.");    
                    Bukkit.broadcastMessage("");  
                    Bukkit.broadcastMessage(divider);    
                      
                }
            }
            }
          }
   
   
	}

