package com.gmail.segers1.pieterjan.raecipes.engine.config;


public class PlayerConfig {

    private Config playerConfig;
    private static final String cPrefix = ".Prefix";
    private static final String cSuffix = ".Suffix";

    public PlayerConfig(Config playerConfig) {
        this.playerConfig = playerConfig;
    }

    private void createEntry(String uuid) {
        // Creates an entry for uuid when it doesn't exist yet.
        if (playerConfig.getConfig().getConfigurationSection(uuid) == null) {
            playerConfig.getConfig().set(uuid + cPrefix, "");
            playerConfig.getConfig().set(uuid + cSuffix, "");

            playerConfig.saveConfig();
        }
    }

    public void write(String uuid, String prefix, String suffix) {
        /* *
        Sets the following:
        uuid:
            - Prefix: prefix
            - Suffix: suffix
         */
        createEntry(uuid);

        playerConfig.getConfig().set(uuid + cPrefix, prefix);
        playerConfig.getConfig().set(uuid + cSuffix, suffix);

        playerConfig.saveConfig();
    }

    public void writePrefix(String uuid, String prefix) {
        createEntry(uuid);

        playerConfig.getConfig().set(uuid + cPrefix, prefix);

        playerConfig.saveConfig();
    }

    public void writeSuffix(String uuid, String suffix) {
        createEntry(uuid);

        playerConfig.getConfig().set(uuid + cSuffix, suffix);

        playerConfig.saveConfig();
    }

    public void removeEntry(String uuid) {
        // Removes a uuid entry.
        if (playerConfig.getConfig().getConfigurationSection(uuid) != null) {
            playerConfig.getConfig().set(uuid, null);

            playerConfig.saveConfig();
        }
    }

    public String getPlayerPrefix(String uuid) {
        return playerConfig.getConfig().getString(uuid + cPrefix, "");
    }

    public String getPlayerSuffix(String uuid) {
        return playerConfig.getConfig().getString(uuid + cSuffix, "");
    }

    public void reloadConfig() {
        playerConfig.reloadConfig();
    }

}
