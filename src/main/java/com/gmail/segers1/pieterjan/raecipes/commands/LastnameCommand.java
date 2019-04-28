package com.gmail.segers1.pieterjan.raecipes.commands;

import com.gmail.segers1.pieterjan.raecipes.Raecipes;
import com.gmail.segers1.pieterjan.raecipes.api.ServiceNickname;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LastnameCommand extends BaseCommand {
    private final String permission = "raecipes.lastname";

    public LastnameCommand(Raecipes plugin) {
        super(plugin);
    }

    @Override
    void doCommand(CommandSender sender, String[] args) {
        Player player = null;
        if (sender instanceof Player) {
            // The player is the sender
            player = (Player) sender;

        } else {
            System.out.println("Invalid sender sent out command.");
            return;
        }

        command(player, args);
    }

    static void command(Player player, String[] args) {
        String suffix = String.join(" ", args);
        ServiceNickname.setSuffix(player, suffix);
    }

    @Override
    boolean hasPermission(CommandSender sender) {
        return sender.hasPermission(permission) || sender.hasPermission(getAllPermission());
    }
}
