package com.abysspvp.staffbase;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.abysspvp.staffbase.Freeze.Commands.Fcommands;
import com.abysspvp.staffbase.Freeze.Events.FreezeEvent;
import com.abysspvp.staffbase.Messages.Help;
import com.abysspvp.staffbase.Messages.Messages;
import com.abysspvp.staffbase.Messages.HelpOp.Helpop;
import com.abysspvp.staffbase.StaffChat.StaffChat;
import com.abysspvp.staffbase.StaffMode.Commands.Staffmode;
import com.abysspvp.staffbase.StaffMode.Events.Events;
import com.abysspvp.staffbase.Utils.MainCommands;
import com.abysspvp.staffbase.Utils.Utils;

public class Main extends JavaPlugin {

	private Fcommands fcommands;
	private Staffmode staffmode;
	public static Main plugin;

	@Override
	public void onEnable() {
		super.getConfig().options().copyDefaults(true);
		super.saveDefaultConfig();
		plugin = this;
		// Getting Stuff On
		fcommands = new Fcommands();
		staffmode = new Staffmode();
		// Freeze Events
		Bukkit.getServer().getPluginManager().registerEvents(new FreezeEvent(this), this);

		// Staff Mode Events
		// Bukkit.getServer().getPluginManager().registerEvents(new InvClick(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Events(this), this);

		// Console Shit
		Utils.log(Level.INFO, "Plugin Loaded!");

		registerCommands();
	}

	public Fcommands getFcommands() {
		return fcommands;
	}

	public Staffmode getStaffMode() {
		return staffmode;
	}

	public void onDisable() {

	}

	public static Main getMain() {
		return plugin;
	}

	public void registerCommands() {
		// Staff Mode Commands
		getCommand("staffmode").setExecutor(getStaffMode());

		// Messages Commands
		getCommand("alert").setExecutor(new Messages());
		getCommand("salert").setExecutor(new Messages());

		// StaffChat
		getCommand("staffchat").setExecutor(new StaffChat());

		// Help Command / HelpOP
		getCommand("help").setExecutor(new Help());
		getCommand("helpop").setExecutor(new Helpop());

		// Freeze Commands
		getCommand("ss").setExecutor(getFcommands());

		// Main Plugin Commands
		getCommand("staffbasereload").setExecutor(new MainCommands());
	}

}
