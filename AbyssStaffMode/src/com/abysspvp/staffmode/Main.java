package com.abysspvp.staffmode;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.abysspvp.staffmode.Commands.CommandHandler;
import com.abysspvp.staffmode.Commands.StaffModeBan;
import com.abysspvp.staffmode.Events.EventClass;
import com.abysspvp.staffmode.Events.Events;
import com.abysspvp.staffmode.Events.InvClick;
import com.abysspvp.staffmode.Utils.Utils;

public class Main extends JavaPlugin {

	public Main plugin;

	@Override
	public void onEnable() {
		plugin = this;

		Bukkit.getServer().getPluginManager().registerEvents(new EventClass(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new InvClick(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Events(), this);
		Utils.log(Level.INFO, "Plugin Loaded!");

		registerCommands();
	}

	public void onDisable() {
		plugin = null;

	}

	public void registerCommands() {
		getCommand("staffmode").setExecutor(new CommandHandler());
		getCommand("smb").setExecutor(new StaffModeBan());
	}

}
