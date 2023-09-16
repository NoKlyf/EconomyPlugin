package me.noklyf.economyplugin;

import me.noklyf.economyplugin.commands.BalanceCommand;
import me.noklyf.economyplugin.commands.PayCommand;
import me.noklyf.economyplugin.listeners.BlockBreakListener;
import me.noklyf.economyplugin.listeners.PlayerJoinListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class EconomyPlugin extends JavaPlugin {
    private static EconomyPlugin instance = null;

    @Override
    public void onEnable() {
        getLogger().info("EconomyPlugin is working!");

        if (instance == null)
            instance = this;

        getConfig().options().copyDefaults(true);
        saveConfig();

        setCommands();
        setListeners();
    }

    @Override
    public void onDisable() {
        getLogger().info("EconomyPlugin disabled!");
    }

    private void setCommands() {
        getCommand("pay").setExecutor(new PayCommand());
        getCommand("balance").setExecutor(new BalanceCommand());
    }

    private void setListeners() {
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
    }

    public static EconomyPlugin getInstance() {
        return instance;
    }
}