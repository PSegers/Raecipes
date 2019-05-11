package com.gmail.segers1.pieterjan.raecipes.runnable;

import com.gmail.segers1.pieterjan.raecipes.Raecipes;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class HungerRunnable extends BukkitRunnable {
    private Raecipes plugin;

    public HungerRunnable(Raecipes plugin){
        this.plugin = plugin;
    }

    @Override
    public void run() {
        for(Player p : plugin.getServer().getOnlinePlayers()) {
            p.setFoodLevel(18);
        }
    }
}
