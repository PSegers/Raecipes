package com.gmail.segers1.pieterjan.raecipes.listener;

import com.gmail.segers1.pieterjan.raecipes.Raecipes;
import com.gmail.segers1.pieterjan.raecipes.api.ServiceNickname;
import com.gmail.segers1.pieterjan.raecipes.commands.FirstnameCommand;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * @author AgentLV
 */
public class PlayerListener implements Listener {

    private Raecipes plugin;
    private FileConfiguration config;

    public PlayerListener(Raecipes plugin) {
        this.plugin = plugin;
        config = plugin.getConfig();
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        // Set the players nickname upon joining
        ServiceNickname.setNickname(player);
        player.setFoodLevel(18);
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerKick(PlayerKickEvent event) {
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerQuit(PlayerQuitEvent event) {
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        /*
        We must add this for Essentials specifically, as Essentials will otherwise overwrite the setNickname command
        entirely with its own mumbojumbo.
         */
        Player player = event.getPlayer();
        ServiceNickname.setNickname(player, false);
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onFoodLevelChange(FoodLevelChangeEvent event) {
        Player player = (Player) event.getEntity();
        player.setFoodLevel(18);
    }
}
