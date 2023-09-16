package me.noklyf.economyplugin.listeners;

import me.noklyf.economyplugin.economy.EconomyManager;

import static org.bukkit.ChatColor.*;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();

        if (event.getBlock().getType().equals(Material.DIAMOND_ORE) || event.getBlock().getType().equals(Material.DEEPSLATE_DIAMOND_ORE)) {
            EconomyManager.setBalance(player, EconomyManager.getBalance(player) + 100);
            player.sendMessage("You earned: " + GREEN + "100$");
        }
    }
}
