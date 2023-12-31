package org.michael.test;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class TestPlugin extends JavaPlugin implements Listener
{

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getCommand("config").setExecutor(new ConfigCommand(this));
        // Plugin startup logic
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("test").setExecutor(new TestCommand());



    }
}
