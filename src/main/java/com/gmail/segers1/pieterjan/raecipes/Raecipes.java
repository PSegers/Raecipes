package com.gmail.segers1.pieterjan.raecipes;

import com.gmail.segers1.pieterjan.raecipes.commands.FirstnameCommand;
import com.gmail.segers1.pieterjan.raecipes.commands.LastnameCommand;
import com.gmail.segers1.pieterjan.raecipes.engine.config.Config;
import com.gmail.segers1.pieterjan.raecipes.engine.config.PlayerConfig;
import com.gmail.segers1.pieterjan.raecipes.engine.MultiScoreboard;
import com.gmail.segers1.pieterjan.raecipes.listener.PlayerListener;
import net.milkbowl.vault.chat.Chat;

import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * original author AgentLV
 * @author Pieterjan Segers
 */
public class Raecipes extends JavaPlugin {

    private static Raecipes instance;
    private static MultiScoreboard multiScoreboard;
    private static PlayerConfig playerConfig;
    private static Chat chat = null;
    private static boolean useVault = false;

    public static boolean useVault() {
        return useVault;
    }

    @Override
    public void onEnable() {
        instance = this;

        // Create a config file if it doesn't exist yet.
        initConfigs();

        // Hooks the plugin into Vault.
        setupVaultChat();

        multiScoreboard = new MultiScoreboard();

        // Register Listener
        new PlayerListener(this);

        // Initiate all the commands
        getCommand("firstname").setExecutor(new FirstnameCommand(this));
        getCommand("lastname").setExecutor(new LastnameCommand(this));
    }

    @Override
    public void onDisable() {
    }

    private void setupVaultChat() {

        if (this.getConfig().getBoolean("Vault")) {

            if (getServer().getPluginManager().getPlugin("Vault") != null) {

                RegisteredServiceProvider<Chat> chatProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.chat.Chat.class);
                if (chatProvider != null) {

                    chat = chatProvider.getProvider();
                    useVault = true;
                    getLogger().info("Hooked into Vault");

                    return;
                }

            }
            getLogger().warning("Could not hook into Vault, are you sure Vault is installed?");
        }
    }

    private void initConfigs() {
        // Creates a Config file if it does not exist yet. Doesn't overwrite existing config files.
        this.saveDefaultConfig();
        Config config;

        config = new Config("players.yml");
        config.saveDefaultConfig();
        playerConfig = new PlayerConfig(config);
    }

    public static Raecipes getInstance() {
        return instance;
    }

    public static MultiScoreboard getMultiScoreboard() {
        return multiScoreboard;
    }

    public static PlayerConfig getPlayerConfig() {
        return playerConfig;
    }

    public static Chat getChat() {
        return chat;
    }
}
