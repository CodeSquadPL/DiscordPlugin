package me.alan.discordplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;

public final class DiscordPlugin extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        reloadConfig();
        getCommand("discord").setExecutor(this);
        Bukkit.getPluginManager().addPermission(new Permission("discordplugin.use"));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("discordplugin.use")) {
            sender.sendMessage(colorutil.colorize(getConfig().getString("link")));
        }
        else{
            sender.sendMessage(colorutil.colorize(getConfig().getString("errormsg")));
        }
        return super.onCommand(sender, command, label, args);
    }
}
