package com.gmail.segers1.pieterjan.raecipes.api;

import com.gmail.segers1.pieterjan.raecipes.Raecipes;
import com.gmail.segers1.pieterjan.raecipes.util.Colors;
import org.bukkit.entity.Player;


public class ServiceNickname {
    private ServiceNickname() {
        /*
         * Prevent instance creation
         */
    }

    // Invoked when a player joins the server.
    public static void setNickname(Player player) {
        setNickname(player, true);
    }

    public static void setNickname(Player player, boolean full) {
        // Fetch the prefix and suffix
        String prefix = Raecipes.getPlayerConfig().getPlayerPrefix(player.getUniqueId().toString());
        String suffix = Raecipes.getPlayerConfig().getPlayerSuffix(player.getUniqueId().toString());

        // Create a nickname of the prefix and suffix
        if (!prefix.isEmpty()|| !suffix.isEmpty()){
            String nickname = String.join(" ", new String[] {prefix, suffix}).trim();
            player.setDisplayName(nickname);
            player.setPlayerListName(nickname);


            if (full) {
                Raecipes.getMultiScoreboard().setPlayerPrefix(player, prefix);
                Raecipes.getMultiScoreboard().setPlayerSuffix(player, suffix);
            }

        } else {
            player.setDisplayName(player.getName());
            player.setPlayerListName(player.getName());
            Raecipes.getMultiScoreboard().resetPlayer(player);
        }
    }


        public static void setPrefix(Player player, String prefix) {
       if (prefix.length() > 12){
           player.sendMessage("A first name cannot be over 12 characters long.");
       } else {
           // First, replace all color coding with the correct ChatColor equivalents.
           prefix = Colors.replace(prefix);

           // Write the prefix to the config file.
           Raecipes.getPlayerConfig().writePrefix(player.getUniqueId().toString(), prefix);

           // Set the player's nickname
           setNickname(player);
           player.sendMessage(String.format("Successfully set first name to %s", prefix));
       }
    }

    public static void setSuffix(Player player, String suffix) {
        if (suffix.length() > 12){
            player.sendMessage("A last name cannot be over 12 characters long.");
        } else {
            // First, replace all color coding with the correct ChatColor equivalents.
            suffix = Colors.replace(suffix);

            // Write the suffix to the config file.
            Raecipes.getPlayerConfig().writeSuffix(player.getUniqueId().toString(), suffix);

            // Set the player's nickname
            setNickname(player);
            player.sendMessage(String.format("Successfully set last name to %s", suffix));
        }
    }

    public static void removeNickname(Player player) {
        // Remove a player entirely from the config and reset their nickname.
        Raecipes.getPlayerConfig().removeEntry(player.getUniqueId().toString());
        setNickname(player);
        player.sendMessage("Successfully reset name.");

    }

}
