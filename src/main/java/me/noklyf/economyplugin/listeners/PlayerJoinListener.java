package me.noklyf.economyplugin.listeners;

import me.noklyf.economyplugin.EconomyPlugin;

import me.noklyf.economyplugin.economy.EconomyManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
    private final EconomyPlugin plugin = EconomyPlugin.getInstance();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String uuid = player.getUniqueId().toString();

        if (!plugin.getConfig().contains(uuid)) {
            EconomyManager.setBalance(player, 0);
        }
    }
}