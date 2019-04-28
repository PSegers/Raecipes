package com.gmail.segers1.pieterjan.raecipes.commands;

import com.gmail.segers1.pieterjan.raecipes.Raecipes;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.logging.Logger;

public abstract class BaseCommand implements CommandExecutor {
    private final String allPermission = "raecipes.*";
    private final Raecipes plugin;
    private final Logger logger;

    public BaseCommand(Raecipes plugin) {
        this.plugin = plugin;
        this.logger = plugin.getLogger();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (hasPermission(sender)){
            doCommand(sender, args);
        } else {
            sender.sendMessage("No permission to use command.");
            logger.info(String.format("Player <%s> tried to access command <%s> but has no permission for this.",
                    sender.getName(), command.getName()));
            return false;
        }
        return true;
    }

    abstract void doCommand(CommandSender sender, String[] args);

    abstract boolean hasPermission(CommandSender sender);

    public Raecipes getPlugin() {
        return plugin;
    }

    public String getAllPermission() {
        return allPermission;
    }


}
