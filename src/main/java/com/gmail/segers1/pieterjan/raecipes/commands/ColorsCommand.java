package com.gmail.segers1.pieterjan.raecipes.commands;

import com.gmail.segers1.pieterjan.raecipes.Raecipes;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ColorsCommand extends BaseCommand {
    private final String permission = "raecipes.colors";

    public ColorsCommand(Raecipes plugin) {
        super(plugin);
    }

    @Override
    void doCommand(CommandSender sender, String[] args) {
        Player player = null;

        if (sender instanceof Player){
            player = (Player) sender;
            player.sendMessage("===== COLORS =====");
            player.sendMessage(String.format("&0 - %sBlack", ChatColor.BLACK));
            player.sendMessage(String.format("&1 - %sDark Blue", ChatColor.DARK_BLUE));
            player.sendMessage(String.format("&2 - %sDark Green", ChatColor.DARK_GREEN));
            player.sendMessage(String.format("&3 - %sDark Aqua", ChatColor.DARK_AQUA));
            player.sendMessage(String.format("&4 - %sDark Red", ChatColor.DARK_RED));
            player.sendMessage(String.format("&5 - %sDark Purple", ChatColor.DARK_PURPLE));
            player.sendMessage(String.format("&6 - %sGold", ChatColor.GOLD));
            player.sendMessage(String.format("&7 - %sGray", ChatColor.GRAY));
            player.sendMessage(String.format("&8 - %sDark Gray", ChatColor.DARK_GRAY));
            player.sendMessage(String.format("&9 - %sBlue", ChatColor.BLUE));
            player.sendMessage(String.format("&a - %sGreen", ChatColor.GREEN));
            player.sendMessage(String.format("&b - %sAqua", ChatColor.AQUA));
            player.sendMessage(String.format("&c - %sRed", ChatColor.RED));
            player.sendMessage(String.format("&d - %sLight Purple", ChatColor.LIGHT_PURPLE));
            player.sendMessage(String.format("&e - %sYellow", ChatColor.YELLOW));
            player.sendMessage(String.format("&f - %sWhite", ChatColor.WHITE));
            player.sendMessage(String.format("&r - %sResets the colour back to the default colour (white)", ChatColor.RESET));
            player.sendMessage(String.format("&l - %sBold", ChatColor.BOLD));
            player.sendMessage(String.format("&o - %sItalic", ChatColor.ITALIC));
            player.sendMessage(String.format("&n - %sUnderline", ChatColor.UNDERLINE));
            player.sendMessage(String.format("&m - %sStrikethrough", ChatColor.STRIKETHROUGH));
            player.sendMessage(String.format("&k - %sScrambled", ChatColor.MAGIC));
            player.sendMessage("==================");
        }
    }

    @Override
    boolean hasPermission(CommandSender sender) {
        return sender.hasPermission(permission) || sender.hasPermission(getAllPermission());
    }
}
