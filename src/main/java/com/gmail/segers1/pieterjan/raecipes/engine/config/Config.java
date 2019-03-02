package com.gmail.segers1.pieterjan.raecipes.engine.config;

import com.gmail.segers1.pieterjan.raecipes.Raecipes;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class Config {

    private final String fileName;
    private File file;
    private FileConfiguration fileConfiguration;

    public Config(String fileName) {
        this.fileName = fileName;
        File dataFolder = Raecipes.getInstance().getDataFolder();
        if (dataFolder == null)
            throw new IllegalStateException();

        this.file = new File(Raecipes.getInstance().getDataFolder(), fileName);
    }

    public void reloadConfig() {
        // Takes all the values from the resource and places them in the fileConfiguration variable.
        fileConfiguration = YamlConfiguration.loadConfiguration(file);

        // Look for defaults in the jar
        InputStream defConfigStream = Raecipes.getInstance().getResource(fileName);
        if (defConfigStream != null) {
            YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defConfigStream));
            fileConfiguration.setDefaults(defConfig);
        }
    }

    public FileConfiguration getConfig() {
        // Gets the config or reloads it if it wasn't initiated yet.
        if (fileConfiguration == null) {
            this.reloadConfig();
        }
        return fileConfiguration;
    }

    public void saveConfig() {
        // Saves the values placed in the configuration into the physical file.
        if (fileConfiguration != null && file != null) {
            try {
                getConfig().save(file);
            } catch (IOException ex) {
                Raecipes.getInstance().getLogger().severe("Could not save config to " + file + ex);
            }
        }
    }

    public void saveDefaultConfig() {
        // If the file doesn't exist yet, create a resource for it.
        if (!file.exists()) {
            Raecipes.getInstance().saveResource(fileName, false);
        }
    }

}
