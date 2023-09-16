package me.noklyf.economyplugin.commands;

import static org.bukkit.ChatColor.*;

import me.noklyf.economyplugin.economy.EconomyManager;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import org.jetbrains.annotations.NotNull;

public class BalanceCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(RED + "This command should only be excuted by players!");
            return true;
        }

        Player player = (Player)sender;
        player.sendMessage("Your balance is: " + GREEN.toString() + EconomyManager.getBalance(player) + "$");

        return true;
    }
}
