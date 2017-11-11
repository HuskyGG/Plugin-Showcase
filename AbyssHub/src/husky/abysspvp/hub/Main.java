package husky.abysspvp.hub;

import java.io.File;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Main extends org.bukkit.plugin.java.JavaPlugin
{
  public Main() {}
  
  public void onEnable()
  {	
	  
	  	Bukkit.getServer().getPluginManager().registerEvents(new EventClass(), this);
	  	getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "\n\nTutorial has been Enabled\n\n");
	  	
		Commands commands = new Commands();

		getCommand(commands.cmd2).setExecutor(commands);  
	  
  }
  
  public void onDisable()
  {
	  getServer().getConsoleSender().sendMessage(ChatColor.RED + "\n\nTutorial has been DISABLED\n\n");
   
  }
  
  
}
