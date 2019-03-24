package com.gmail.segers1.pieterjan.raecipes.engine;

import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class MultiScoreboard {
    public void setPlayerPrefix(Player player, String prefix) {
        Scoreboard board = player.getScoreboard();

        Team team = getTeam(board, player.getName());
        team.addEntry(player.getName());
        team.setPrefix(String.format("%s [", prefix));
    }

    public void setPlayerSuffix(Player player, String suffix) {
        Scoreboard board = player.getScoreboard();

        Team team = getTeam(board, player.getName());
        team.addEntry(player.getName());
        team.setSuffix(String.format("] %s", suffix));
    }

    public void resetPlayer(Player player){
        Scoreboard board = player.getScoreboard();

        Team team = getTeam(board, player.getName());
        team.addEntry(player.getName());
        team.setSuffix("");
        team.setPrefix("");
    }

    public void unregisterPlayerTeam(Player player) {
        Scoreboard board = player.getScoreboard();
        Team team;

        if ((team = getTeam(board, player.getName())) != null) {
            team.removeEntry(player.getName());

            if (team.getEntries().size() <= 0) {
                team.unregister();
            }
        }
    }

    private Team getTeam(Scoreboard scoreboard, String name) {
        return scoreboard.getTeam(name) == null ? scoreboard.registerNewTeam(name) : scoreboard.getTeam(name);
    }

}
