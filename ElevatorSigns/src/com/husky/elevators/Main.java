package com.husky.elevators;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.husky.elevators.Commands.CommandHandler;
import com.husky.elevators.Events.Events;
import com.husky.elevators.Utils.Utils;

public class Main extends JavaPlugin {

	public void onEnable() {

		Bukkit.getServer().getPluginManager().registerEvents(new Events(), this);
		Utils.log(Level.INFO, "Plugin Loaded!");
		registerCommands();

	}

	public void onDisable() {

	}

	public void registerCommands() {
		getCommand("elevator").setExecutor(new CommandHandler());
	}

}
