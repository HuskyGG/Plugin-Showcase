package husky.abysspvp.hub;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.PlayerInventory;

import net.minecraft.server.v1_8_R1.CommandExecute;

public class Commands extends CommandExecute implements Listener, CommandExecutor {

	public String cmd2 = "hub";
	private CustomItems ci = new CustomItems();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			
			if(cmd.getName().equalsIgnoreCase(cmd2)){
				Player player = (Player) sender;
				PlayerInventory inventory = player.getInventory();
				
				ci.giveItems(player);
				
			}

		} else {
			sender.sendMessage(ChatColor.RED + "Only players can use this command!");
			return true;
		}
		return false;
	}

}