package me.noklyf.economyplugin.commands;

import static org.bukkit.ChatColor.*;

import me.noklyf.economyplugin.economy.EconomyManager;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import org.jetbrains.annotations.NotNull;

public class PayCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(RED + "This command should only be executed by players!");
            return true;
        }

        Player player = (Player)sender;

        if (args.length != 2) {
            player.sendMessage("Usage: /pay <player> <amount>");
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);

        if (target == null) {
            player.sendMessage(RED + "Player not found!");
            return true;
        }

        if (target.equals(player)) {
            player.sendMessage(RED + "You can't pay yourself!");
            return true;
        }

        try {
            int amount = Integer.parseInt(args[1]);

            if (EconomyManager.getBalance(player) < amount) {
                player.sendMessage(RED + "You can't pay " + amount + "$ to " + target.getName() + ". You only have: " + EconomyManager.getBalance(player) + "$");
                return true;
            }

            EconomyManager.setBalance(player, EconomyManager.getBalance(player) - amount);
            EconomyManager.setBalance(target, EconomyManager.getBalance(target) + amount);

            player.sendMessage("You paid " + target.getName() + ": " + GREEN.toString() + amount + "$");
            target.sendMessage(player.getName() + " paid you: " + GREEN.toString() + amount + "$");
        } catch (Exception e) {
            player.sendMessage(RED + "The last argument must be an integer!");
        }

        return true;
    }
}
