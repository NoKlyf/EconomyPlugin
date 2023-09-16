package me.noklyf.economyplugin.economy;

import me.noklyf.economyplugin.EconomyPlugin;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class EconomyManager {
    private static EconomyPlugin plugin = EconomyPlugin.getInstance();
    private static FileConfiguration config = plugin.getConfig();

    public static void setBalance(Player player, int balance) {
        config.set(player.getUniqueId().toString(), balance);
        plugin.saveConfig();
    }

    public static int getBalance(Player player) {
        if (config.contains(player.getUniqueId().toString()))
            return config.getInt(player.getUniqueId().toString());

        return 0;
    }
}
