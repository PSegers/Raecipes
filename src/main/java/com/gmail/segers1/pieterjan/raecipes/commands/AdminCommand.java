package com.gmail.segers1.pieterjan.raecipes.commands;

import com.gmail.segers1.pieterjan.raecipes.Raecipes;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;

import static com.gmail.segers1.pieterjan.raecipes.util.PlayerUtils.findPlayer;

public class AdminCommand extends BaseCommand {
    private ArrayList<String> firstNameCommands = new ArrayList<String>() {{
        add("firstname");
        add("fn");}};
    private ArrayList<String> lastNameCommands = new ArrayList<String>() {{
        add("lastname");
        add("ln");}};
    private ArrayList<String> resetNameCommands = new ArrayList<String>() {{
        add("resetname");
        add("reset");
        add("rn");}};


    public AdminCommand(Raecipes plugin) {
        super(plugin);
    }

    @Override
    void doCommand(CommandSender sender, String[] args) {
        // Fetch the actual command
        ArrayList<String> argsList = new ArrayList<>(Arrays.asList(args));
        String playerName;
        String commandName;

        try {
            playerName = argsList.remove(1);
            commandName = argsList.remove(0);
        } catch (IndexOutOfBoundsException e) {
            sender.sendMessage("No command name and/or player name provided.");
            return;
        }

        args = argsList.toArray(new String[0]);
        Player player = findPlayer(playerName);

        if (player == null){
            return;
        }

        if (firstNameCommands.contains(commandName.toLowerCase())){
            FirstnameCommand.command(player, args);

        } else if (lastNameCommands.contains(commandName.toLowerCase())){
            LastnameCommand.command(player, args);

        } else if (resetNameCommands.contains(commandName.toLowerCase())) {
            ResetnameCommand.command(player, args);
        }
    }
}
