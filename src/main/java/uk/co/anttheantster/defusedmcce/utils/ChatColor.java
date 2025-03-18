package uk.co.anttheantster.defusedmcce.utils;

public interface ChatColor {

    static String translate(String message) {
        String msg = org.bukkit.ChatColor.translateAlternateColorCodes('&', message);
        return msg;
    }

}
