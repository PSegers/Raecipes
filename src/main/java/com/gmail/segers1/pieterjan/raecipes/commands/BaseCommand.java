package com.gmail.segers1.pieterjan.raecipes.commands;

import com.gmail.segers1.pieterjan.raecipes.Raecipes;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.logging.Logger;

public abstract class BaseCommand implements CommandExecutor {
    private final String permission = "reacipes";
    private final Raecipes plugin;
    private final Logger logger;

    public BaseCommand(Raecipes plugin) {
        this.plugin = plugin;
        this.logger = plugin.getLogger();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
//        if (sender.hasPermission(permission)){
        if (true){
            doCommand(sender, args);
        } else {
            sender.sendMessage("No permission to use command.");
            logger.info(String.format("Player <%s> tried to access command %s but has no permission for this.",
                    sender.getName(), command.getName()));
            return false;
        }
        return true;
    }

    abstract void doCommand(CommandSender sender, String[] args);

    //    @Override
//    public boolean onCommand(final CommandSender sender, BaseCommand cmd, String label, final String[] args) {
//
//        String invalidPermission = "§cYou don't have permission.";
//
//        //Sender -> Player
//        Player player = null;
//        if (sender instanceof Player)
//            player = (Player) sender;
//
//        if (cmd.getName().equalsIgnoreCase("Raecipes")) {
//            if (args.length == 0) {
//                pluginDescription(sender);
//            } else if (args[0].equalsIgnoreCase("help")) {
//
//                if (sender.hasPermission("Raecipes.help")) {
//
//                    sender.sendMessage("");
//                    sender.sendMessage("§3---- §b§lRaecipes commands §r§3----");
//                    sender.sendMessage("");
//                    sender.sendMessage("§3/nm prefix <player> <prefix>  §7§  §bSets a prefix for a player");
//                    sender.sendMessage("§3/nm suffix <player> <suffix>  §7§  §bSets a suffix for a player");
//                    sender.sendMessage("§3/nm clear [player]  §7§  §bResets a name");
//                    sender.sendMessage("§3/nm rainbow [player]  §7§  §bRainbow name §c(could cause lag)");
//                    sender.sendMessage("§3/nm uuid [player]  §7§  §bShows the UUID of a player");
//                    sender.sendMessage("§3/nm reload  §7§  §bReloads Raecipes");
//                    sender.sendMessage("§3/nm group  §7§  §bDisplay group commands");
//                    sender.sendMessage("");
//                    sender.sendMessage("§3All names are §ncase sensitive§r§3!");
//                    sender.sendMessage("");
//
//                } else {
//                    sender.sendMessage(invalidPermission);
//                }
//
//            } else if (args[0].equalsIgnoreCase("prefix")) {
//                if (sender.hasPermission("Raecipes.prefix")) {
//                    if (args.length >= 3) {
//                        ServiceNickname.getOfflinePlayer(args[1], new UUIDCallback() {
//                            @Override
//                            public void done(OfflinePlayer offlinePlayer) {
//                                StringBuilder prefixBuilder = new StringBuilder(args[2]);
//                                for (int i = 3; i < args.length; ++i) {
//                                    prefixBuilder.append(" ").append(args[i]);
//                                }
//                                String prefix = prefixBuilder.toString();
//
//                                if (prefix.length() > 16) {
//                                    sender.sendMessage("§3The prefix can only contain 16 Characters.");
//                                } else {
//                                    if (offlinePlayer.hasPlayedBefore() || offlinePlayer.isOnline()) {
//                                        ServiceNickname.setNametagPrefix(offlinePlayer, prefix);
//                                        sender.sendMessage("§3Prefix '§c" + prefix + "§3' set for §c" + args[1]);
//                                    } else {
//                                        sender.sendMessage("§cPlayer §3" + args[1] + "§c not found.");
//                                    }
//                                }
//                            }
//
//                            @Override
//                            public void fail(Exception e) {
//                                sender.sendMessage("§cPlayer §3" + args[1] + "§c not found.");
//                            }
//                        });
//                    } else {
//                        sender.sendMessage("§cUsage: /nm prefix <player> <prefix>");
//                    }
//                } else {
//                    sender.sendMessage(invalidPermission);
//                }
//            } else if (args[0].equalsIgnoreCase("suffix")) {
//
//                if (sender.hasPermission("Raecipes.suffix")) {
//
//                    if (args.length >= 3) {
//
//                        ServiceNickname.getOfflinePlayer(args[1], new UUIDCallback() {
//                            @Override
//                            public void done(OfflinePlayer offlinePlayer) {
//                                StringBuilder suffixBuilder = new StringBuilder(args[2]);
//                                for(int i = 3; i < args.length; ++i) {
//                                    suffixBuilder.append(" ").append(args[i]);
//                                }
//                                String suffix = suffixBuilder.toString();
//
//                                if (suffix.length() > 16) {
//                                    sender.sendMessage("§3The suffix can only contain 16 Characters.");
//                                } else {
//
//                                    if (offlinePlayer.hasPlayedBefore() || offlinePlayer.isOnline()) {
//                                        ServiceNickname.setNametagSuffix(offlinePlayer, suffix);
//                                        sender.sendMessage("§3Suffix '§c" + suffix + "§3' set for §c" + args[1]);
//
//                                    } else {
//                                        sender.sendMessage("§cPlayer §3" + args[1] + "§c not found.");
//                                    }
//                                }
//                            }
//
//                            @Override
//                            public void fail(Exception e) {
//                                sender.sendMessage("§cPlayer §3" + args[1] + "§c not found.");
//                            }
//                        });
//
//                    } else {
//                        sender.sendMessage("§cUsage: /nm suffix <player> <suffix>");
//                    }
//                } else {
//                    sender.sendMessage(invalidPermission);
//                }
//
//            } else if (args[0].equalsIgnoreCase("clear")) {
//
//                if (sender.hasPermission("Raecipes.clear")) {
//
//                    if (args.length == 1) {
//
//                        if (sender instanceof Player) {
//
//                            if (!Rainbow.rainbowEnabled(player.getName())) {
//                                ServiceNickname.getOfflinePlayer(player.getName(), new UUIDCallback() {
//                                    @Override
//                                    public void done(OfflinePlayer offlinePlayer) {
//                                        ServiceNickname.clearNametag(offlinePlayer);
//                                    }
//
//                                    @Override
//                                    public void fail(Exception e) {
//                                        // This shouldn't happen
//                                    }
//                                });
//
//                                sender.sendMessage("§3Your name was cleared.");
//                            } else {
//                                sender.sendMessage("§cTo clear your nametag, please turn off your rainbow");
//                            }
//
//                        } else {
//                            sender.sendMessage("§3A player is required.");
//                        }
//                    } else if (args.length == 2) {
//
//                        ServiceNickname.getOfflinePlayer(args[1], new UUIDCallback() {
//                            @Override
//                            public void done(OfflinePlayer offlinePlayer) {
//                                if (offlinePlayer.hasPlayedBefore() || offlinePlayer.isOnline()) {
//
//                                    if (!Rainbow.rainbowEnabled(offlinePlayer.getName())) {
//                                        ServiceNickname.clearNametag(offlinePlayer);
//                                        sender.sendMessage("§3Name cleared for §c" + args[1]);
//                                    } else {
//                                        sender.sendMessage("§cTo clear the nametag, please turn off the rainbow of §3" + offlinePlayer.getName());
//                                    }
//
//                                } else {
//                                    sender.sendMessage("§cPlayer §3" + args[1] + "§c not found.");
//                                }
//                            }
//
//                            @Override
//                            public void fail(Exception e) {
//                                sender.sendMessage("§cPlayer §3" + args[1] + "§c not found.");
//                            }
//                        });
//
//
//
//                    } else {
//                        sender.sendMessage("§cUsage: /nm clear <player>");
//                    }
//
//                } else {
//                    sender.sendMessage(invalidPermission);
//                }
//
//            } else if (args[0].equalsIgnoreCase("uuid")) {
//
//                if (sender.hasPermission("Raecipes.uuid")) {
//
//                    if (args.length == 1) {
//
//                        if (sender instanceof Player) {
//
//                            sender.sendMessage("§3Your UUID: §c" + player.getUniqueId());
//
//                        } else {
//                            sender.sendMessage("§cA player is required.");
//                        }
//
//                    } else if (args.length == 2) {
//
//                        ServiceNickname.getOfflinePlayer(args[1], new UUIDCallback() {
//                            @Override
//                            public void done(OfflinePlayer offlinePlayer) {
//                                sender.sendMessage("§3UUID of §c" + args[1] + "§3: §c" + offlinePlayer.getUniqueId().toString());
//                            }
//
//                            @Override
//                            public void fail(Exception e) {
//                                sender.sendMessage("§cPlayer §3" + args[1] + "§c not found.");
//                            }
//                        });
//
//                    } else {
//                        sender.sendMessage("§cUsage: /nm uuid <player>");
//                    }
//
//                } else {
//                    sender.sendMessage(invalidPermission);
//                }
//
//            } else if (args[0].equalsIgnoreCase("rainbow")) {
//
//                if (sender.hasPermission("Raecipes.rainbow")) {
//
//                    if (args.length == 1) {
//
//                        if (sender instanceof Player) {
//
//                            if (!Rainbow.enableRainbow(player)) {
//
//                                sender.sendMessage("§3Rainbow activated");
//
//                            } else {
//
//                                Rainbow.disableRainbow(player.getName());
//                                sender.sendMessage("§3Rainbow deactivated");
//                            }
//
//                        } else {
//                            sender.sendMessage("§cA player is required.");
//                        }
//
//                    } else if (args.length == 2) {
//
//                        Player targetPlayer = Bukkit.getPlayer(args[1]);
//
//                        if (targetPlayer != null && targetPlayer.isOnline()) {
//
//                            if (!Rainbow.enableRainbow(targetPlayer)) {
//
//                                sender.sendMessage("§3Rainbow activated for §c" + targetPlayer.getName());
//
//                            } else {
//
//                                Rainbow.disableRainbow(targetPlayer.getName());
//                                sender.sendMessage("§3Rainbow deactivated for §c" + targetPlayer.getName());
//                            }
//
//                        } else {
//                            sender.sendMessage("§cPlayer §3" + args[1] + "§c not found.");
//                        }
//                    } else {
//                        sender.sendMessage("§c§cUsage: /nm rainbow <player>");
//                    }
//
//                } else {
//                    sender.sendMessage(invalidPermission);
//                }
//
//            }  else if (args[0].equalsIgnoreCase("reload")) {
//
//                if (sender.hasPermission("Raecipes.reload")) {
//                    Raecipes.getMultiScoreboard().removeGroups();
//
//                    for (Player reloadPlayer : Bukkit.getOnlinePlayers()) {
//                        Raecipes.getMultiScoreboard().unregisterPlayerTeam(reloadPlayer.getName());
//                    }
//
//                    plugin.reloadConfig();
//                    Raecipes.getPlayerConfig().reloadConfig();
//                    Raecipes.getGroupConfig().reloadConfig();
//                    RaecipesGroupAPI.getGroups().clear();
//
//                    Raecipes.getGroupConfig().initGroups();
//
//                    for (Player reloadPlayer : Bukkit.getOnlinePlayers())
//                        PlayerGroupHandler.add(reloadPlayer);
//
//                    sender.sendMessage("§3Reloaded Raecipes!");
//                } else {
//                    sender.sendMessage(invalidPermission);
//                }
//
//            }
//
//
//            //Group commands
//
//            else if (args[0].equalsIgnoreCase("group") || args[0].equalsIgnoreCase("groups")) {
//
//                if (args.length == 1) {
//
//                    if(sender.hasPermission("Raecipes.group.help")) {
//                        sender.sendMessage("");
//                        sender.sendMessage("§3---- §b§lRaecipes group commands §r§3----");
//                        sender.sendMessage("");
//                        sender.sendMessage("§3/nm group prefix <group> <prefix>  §7§  §bSets a prefix for a group");
//                        sender.sendMessage("§3/nm group suffix <group> <suffix>  §7§  §bSets a suffix for a group");
//                        sender.sendMessage("§3/nm group remove <group>  §7§  §bRemoves a group");
//                        sender.sendMessage("§3/nm group list  §7§  §bDisplays all valid groups");
//                        sender.sendMessage("§3/nm group add <player> <group>  §7§  §bTemporarily add a player to a group");
//                        sender.sendMessage("");
//                    } else {
//                        sender.sendMessage(invalidPermission);
//                    }
//
//                    //BaseCommand /nm group prefix
//                } else if (args[1].equalsIgnoreCase("prefix")) {
//                    if (sender.hasPermission("Raecipes.group.prefix")) {
//                        if (args.length >= 4) {
//                            StringBuilder prefix = new StringBuilder(args[3]);
//                            for(int i = 4; i < args.length; ++i) {
//                                prefix.append(" ").append(args[i]);
//                            }
//
//                            if (prefix.length() > 16) {
//                                sender.sendMessage("§3The prefix can only contain 16 Characters.");
//                            } else {
//                                RaecipesGroupAPI.setGroupPrefix(args[2], prefix.toString());
//                                sender.sendMessage("§3Set prefix '§c" + prefix + "§3' for group §c" + args[2]);
//                            }
//                        } else {
//                            sender.sendMessage("§cUsage: /nm group prefix <group> <prefix>");
//                        }
//                    } else {
//                        sender.sendMessage(invalidPermission);
//                    }
//
//                    //BaseCommand /nm group suffix
//                } else if (args[1].equalsIgnoreCase("suffix")) {
//                    if (sender.hasPermission("Raecipes.group.suffix")) {
//                        if (args.length >= 4) {
//                            StringBuilder suffixBuilder = new StringBuilder(args[3]);
//                            for(int i = 4; i < args.length; ++i) {
//                                suffixBuilder.append(" ").append(args[i]);
//                            }
//                            String suffix = suffixBuilder.toString();
//
//                            if (suffix.length() > 16) {
//                                sender.sendMessage("§3The suffix can only contain 16 Characters.");
//                            } else {
//                                RaecipesGroupAPI.setGroupSuffix(args[2], suffix);
//                                sender.sendMessage("§3Set suffix '§c" + suffix + "§3' for group §c" + args[2]);
//                            }
//                        } else {
//                            sender.sendMessage("§cUsage: /nm group suffix <group> <prefix>");
//                        }
//                    } else {
//                        sender.sendMessage(invalidPermission);
//                    }
//
//                    //nm group reload
//                } else if (args[1].equalsIgnoreCase("remove")) {
//
//                    if (sender.hasPermission("Raecipes.group.remove")) {
//                        RaecipesGroupAPI.removeGroup(args[2]);
//                        sender.sendMessage("§3Succesfully removed group '§c" + args[2] + "§3'");
//                    } else {
//                        sender.sendMessage(invalidPermission);
//                    }
//
//                    //nm group list
//                } else if (args[1].equalsIgnoreCase("list")) {
//
//                    if (sender.hasPermission("Raecipes.group.list")) {
//                        for (String s : RaecipesGroupAPI.getGroups().keySet()) {
//                            sender.sendMessage("§3" + s);
//                        }
//                    } else {
//                        sender.sendMessage(invalidPermission);
//                    }
//
//                }  else if (cmd.getName().equals("add")) {
//
//                    if (sender.hasPermission("Raecipes.group.add")) {
//
//                        if (args.length == 4) {
//
//                            Player targetPlayer = Bukkit.getPlayer(args[3]);
//
//                            if (targetPlayer != null && targetPlayer.isOnline()) {
//
//                                if (RaecipesGroupAPI.getGroups().containsKey(args[4])) {
//
//                                    RaecipesGroupAPI.addPlayer(args[4], targetPlayer.getName());
//
//                                    sender.sendMessage("§3Temporarily added §c" + targetPlayer.getName() + " §3to Group §c" + args[4]);
//
//                                } else {
//                                    sender.sendMessage("§cGroup §3" + args[4] + " §cnot found.");
//                                }
//
//                            } else {
//                                sender.sendMessage("§cPlayer §3" + args[3] + " §cnot found.");
//                            }
//
//                        } else {
//                            sender.sendMessage("§cUsage: /nm group add <player> <group>");
//                        }
//
//                    } else {
//                        sender.sendMessage(invalidPermission);
//                    }
//
//                } else {
//                    pluginDescription(sender);
//                }
//
//            } else {
//                pluginDescription(sender);
//            }
//
//        }
//
//        return true;
//    }

    public Raecipes getPlugin() {
        return plugin;
    }

}
