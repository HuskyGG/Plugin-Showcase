package com.husky.animations;

import java.lang.reflect.Field;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;

public class Main extends JavaPlugin {

	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(new Events(), this);

	}

	public void onDisable() {

	}

	public boolean onCommand(Command sender, Command command, String label, String[] args) {

		if (sender instanceof Player && command.getLabel().equalsIgnoreCase("animate")) {

			Player player = (Player) sender;

		}

		return true;
	}

	public void createHelixWithReflection(Player player) throws Exception {
        Location loc = player.getLocation();
        int radius = 2;
        for (double y = 0; y <= 50; y += 0.05) {
            double x = radius * Math.cos(y);
            double z = radius * Math.sin(y);
            Object packet = getNMSClass(player, "PacketPlayOutWorldParticles").newInstance();
            packet = packet.getClass().getConstructor(String.class, float.class, float.class, float.class, float.class, float.class, float.class, float.class, int.class).newInstance("fireworksSpark", (float) (loc.getX() + x), (float) (loc.getY() + y), (float) (loc.getZ() + z), 0, 0, 0, 0, 1);
            for (Player online : Bukkit.getOnlinePlayers()) {
                Object nmsPlayer = online.getClass().getMethod("getHandle").invoke(online);
                Object playerConnection = nmsPlayer.getClass().getDeclaredField("playerConnection").get(nmsPlayer);
                playerConnection.getClass().getMethod("sendPacket", getNMSClass(online, "Packet")).invoke(playerConnection, packet);
            }
        }
    }
 
    public Class<?> getNMSClass(Player player, String className) throws Exception {
        Field field = Bukkit.getServer().getClass().getDeclaredField("console");
        field.setAccessible(true);
        return (Class.forName(field.get(Bukkit.getServer()).getClass().getPackage().getName() + "." + className));
    }
}
