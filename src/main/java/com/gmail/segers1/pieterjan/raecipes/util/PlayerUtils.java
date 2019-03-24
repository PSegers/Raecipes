package com.gmail.segers1.pieterjan.raecipes.util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PlayerUtils {
    public static Player findPlayer(String playerName){
        // Find a player by their name among the currently online Players.
        Player player = null;
        for (Player p : Bukkit.getOnlinePlayers()){
            if (p.getName().equals(playerName)) {
                player = p;
                break;
            }
        }

        if (player == null){
            System.out.println(String.format("Player %s is not online.", playerName));
        }

        return player;
    }
}
