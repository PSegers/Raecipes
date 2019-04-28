package com.gmail.segers1.pieterjan.raecipes.commands;

import com.gmail.segers1.pieterjan.raecipes.Raecipes;
import com.gmail.segers1.pieterjan.raecipes.api.ServiceNickname;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FirstnameCommand extends BaseCommand {
    private final String permission = "raecipes.firstname";

    public FirstnameCommand(Raecipes plugin) {
        super(plugin);
    }

    @Override
    void doCommand(CommandSender sender, String[] args) {
        Player player = null;
        if (sender instanceof Player) {
            // The player is the sender
            player = (Player) sender;

        } else {
            System.out.println("Use `raecipes firstname` instead");
            return;
        }

        command(player, args);
    }

    @Override
    boolean hasPermission(CommandSender sender) {
        return sender.hasPermission(permission) || sender.hasPermission(getAllPermission());
    }

    static void command(Player player, String[] args){
        String prefix = String.join(" ", args);
        ServiceNickname.setPrefix(player, prefix);
    }

}
