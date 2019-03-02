package com.gmail.segers1.pieterjan.raecipes.util;

import net.milkbowl.vault.chat.Chat;
import org.bukkit.ChatColor;

import java.util.HashMap;
import java.util.Map;

public class Colors {
    private static final HashMap<String, ChatColor> colorMap = new HashMap<String, ChatColor>(){{
        put("&0", ChatColor.BLACK);
        put("&1", ChatColor.DARK_BLUE);
        put("&2", ChatColor.DARK_GREEN);
        put("&3", ChatColor.DARK_AQUA);
        put("&4", ChatColor.DARK_RED);
        put("&5", ChatColor.DARK_PURPLE);
        put("&6", ChatColor.GOLD);
        put("&7", ChatColor.GRAY);
        put("&8", ChatColor.DARK_GRAY);
        put("&9", ChatColor.BLUE);
        put("&a", ChatColor.GREEN);
        put("&b", ChatColor.AQUA);
        put("&c", ChatColor.RED);
        put("&d", ChatColor.LIGHT_PURPLE);
        put("&e", ChatColor.YELLOW);
        put("&f", ChatColor.WHITE);
        put("&k", ChatColor.MAGIC);
        put("&l", ChatColor.BOLD);
        put("&m", ChatColor.STRIKETHROUGH);
        put("&n", ChatColor.UNDERLINE);
        put("&o", ChatColor.ITALIC);
        put("&r", ChatColor.RESET);
    }};

    public static ChatColor get(String colorCode){
        return colorMap.get(colorCode);
    }

    public static String replace(String name){
        if (name.contains("&")){
            for (Map.Entry<String, ChatColor> entry : colorMap.entrySet()){
                if (!name.contains("&")) {
                    break;
                }
                String key = entry.getKey();
                ChatColor value = entry.getValue();
                name = name.replace(key, value.toString());
            }
        }

        return String.format("%s%s", name, ChatColor.WHITE);
    }
}
