package com.gmail.segers1.pieterjan.raecipes.commands;

import com.gmail.segers1.pieterjan.raecipes.Raecipes;
import com.gmail.segers1.pieterjan.raecipes.api.ServiceNickname;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LastnameCommand extends BaseCommand {
    private final String permission = "reacipes.lastname";

    public LastnameCommand(Raecipes plugin) {
        super(plugin);
    }

    @Override
    void doCommand(CommandSender sender, String[] args) {
        Player player = null;
        if (sender instanceof Player) {
            player = (Player) sender;
        } else {
            return;
        }

        String prefix = String.join(" ", args);
        ServiceNickname.setSuffix(player, prefix);
    }
}
