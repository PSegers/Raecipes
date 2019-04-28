package com.gmail.segers1.pieterjan.raecipes.commands;

import com.gmail.segers1.pieterjan.raecipes.Raecipes;
import com.gmail.segers1.pieterjan.raecipes.api.ServiceNickname;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ResetnameCommand extends BaseCommand {
    private final String permission = "raecipes.resetname";

    public ResetnameCommand(Raecipes plugin) {
        super(plugin);
    }

    @Override
    void doCommand(CommandSender sender, String[] args) {
        Player player = null;

        if (sender instanceof Player) {
            // The player is the sender
            player = (Player) sender;
        }

        else {
            System.out.println("Use `raecipes resetname` instead");
            return;
        }

        command(player, args);
    }

    static void command(Player player, String[] args){
        ServiceNickname.removeNickname(player);
    }

    @Override
    boolean hasPermission(CommandSender sender) {
        System.out.println(sender.getEffectivePermissions());
        return sender.hasPermission(permission) || sender.hasPermission(getAllPermission());
    }
}
