package me.alan.discordplugin;

import org.bukkit.ChatColor;

public class colorutil {
    public static String colorize(String text){
        return ChatColor.translateAlternateColorCodes('&', text);
    }
}
